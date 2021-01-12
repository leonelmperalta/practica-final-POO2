package ar.edu.unahur.obj2.lugares;

import ar.edu.unahur.obj2.alma.Alma;
import ar.edu.unahur.obj2.demonios.Demonio;
import ar.edu.unahur.obj2.demonios.DemonioFuego;
import ar.edu.unahur.obj2.demonios.DemonioSombra;

import javax.net.ssl.SSLEngineResult;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Lugar {
    public static void main(String[] args) {
        Demonio demonio;
        Lugar lugar;
            demonio = new DemonioSombra(15, "Pepe");
            lugar = new Purgatorio();
            lugar.crearAlma("cazable",11,6,false);
            lugar.crearAlma("cazable",11,6,false);
            lugar.crearAlma("cazable",11,6,false);
            lugar.crearAlma("cazable",9,4,false);
            lugar.crearAlma("cazable",9,4,false);
            lugar.crearAlma("noCazable",11,51,false);
            lugar.crearAlma("noCazable",9,51,false);
            demonio.salirACazar(lugar);

    }
    HashSet<Alma> almas = new HashSet<Alma>();
    HashSet<Alma> almasEscondidas = new HashSet<Alma>();
    abstract int lugaresParaEsconder();

    public void recibirAtaque(Demonio demonio){
        esconderAlmas();
        Set<Alma> aCazar = new HashSet<Alma>();
        for(Iterator<Alma> iterator = almas.iterator(); iterator.hasNext();){
            Alma alma = iterator.next();
            if(demonio.puedeCazar(alma)){
                demonio.cazar(alma);
                aCazar.add(alma);
            }
        }
        almas.removeAll(aCazar);
        ataqueTerminado(demonio);
    }

    void esconderAlmas(){
        Set<Alma> aEsconder = new HashSet<Alma>();
        for(Iterator<Alma> iterator = almas.iterator(); iterator.hasNext();){
            Alma alma = iterator.next();
            if(puedeEsconderse(alma)){
                aEsconder.add(alma);
                almasEscondidas.add(alma);
            }
        }
        almas.removeAll(aEsconder);
    }

    public void ataqueTerminado(Demonio demonio){
        Set<Alma> aSacarDelEscondite = new HashSet<Alma>();
        almasEscondidas.stream().forEach(alma -> {
            demonio.atormentar(alma);
            aSacarDelEscondite.add(alma);
            almas.add(alma);
        } );
        almasEscondidas.removeAll(aSacarDelEscondite);
    }
    boolean hayLugar(){
        return almasEscondidas.size() < lugaresParaEsconder();
    }
    public HashSet<Alma> getAlmas() {
        return almas;
    }
    boolean puedeEsconderse(Alma alma){
        return hayLugar() && condicionExtraParaEsconder(alma);
    }
    protected abstract boolean condicionExtraParaEsconder(Alma alma);
    abstract void penalizar(Alma alma);

    public void crearAlma(String nombre,float nivelDeBondad, float nivelDeValor, boolean esFriolenta){
        Alma alma = new Alma(nombre,nivelDeBondad,nivelDeValor,esFriolenta);
        almas.add(alma);
    }
    public void eliminarAlma(Alma alma){
        almas.remove(alma);
    }
    abstract public String getNombre();
}

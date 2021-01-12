package ar.edu.unahur.obj2.diablo;

import ar.edu.unahur.obj2.alma.Alma;
import ar.edu.unahur.obj2.armas.Arma;
import ar.edu.unahur.obj2.armas.ArmaFactory;
import ar.edu.unahur.obj2.demonios.Demonio;
import ar.edu.unahur.obj2.demonios.DemonioFactory;
import ar.edu.unahur.obj2.estadosDeAnimo.Contento;
import ar.edu.unahur.obj2.estadosDeAnimo.EstadoDeAnimo;
import ar.edu.unahur.obj2.estadosDeAnimo.Triste;
import ar.edu.unahur.obj2.lugares.Infierno;
import ar.edu.unahur.obj2.lugares.Lugar;
import ar.edu.unahur.obj2.lugares.Paraiso;
import ar.edu.unahur.obj2.lugares.Purgatorio;
import ar.edu.unahur.obj2.tecnicasDeDefensa.TecnicaDeDefensa;
import ar.edu.unahur.obj2.tecnicasDeDefensa.TecnicaFactory;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Diablo {
    HashSet<Demonio> demonios= new HashSet<Demonio>();
    Set<Lugar> lugares = new HashSet<Lugar>();
    EstadoDeAnimo contento = new Contento();
    EstadoDeAnimo triste = new Triste();
    EstadoDeAnimo animoActual;
    TecnicaFactory tecnicaFactory;
    DemonioFactory demonioFactory;
    ArmaFactory armaFactory;

    public Diablo(){
        lugares.add(new Paraiso());
        lugares.add(new Purgatorio());
        lugares.add(new Infierno());
        tecnicaFactory = new TecnicaFactory();
        demonioFactory = new DemonioFactory();
        armaFactory = new ArmaFactory();
        animoActual = contento;
    }

    public void crearDemonio(String tipoDeDemonio,float nivelDeMaldad, String nombre){
        Demonio demonio = demonioFactory.getDemonio(tipoDeDemonio,nivelDeMaldad,nombre);
        demonios.add(demonio);
    }
    public void crearAlma(String nombre, float nivelDeBondad, float nivelDeValor, boolean esFriolenta, Lugar lugar){
        lugar.crearAlma(nombre,nivelDeBondad,nivelDeValor,esFriolenta);
    }
    public void mandarACazar(Demonio demonio, Lugar lugar){
        demonio.salirACazar(lugar);
    }
    public void atormentar(Demonio demonio, Alma alma){
        demonio.atormentar(alma);
    }
    public boolean puedeCazar(Demonio demonio, Alma alma){
        return demonio.puedeCazar(alma);
    }
    public void entrenar(Alma alma, String tipoDeTecnica){
        TecnicaDeDefensa entrenamiento = tecnicaFactory.getTecnica(tipoDeTecnica);
        alma.setEntrenamiento(entrenamiento,tipoDeTecnica);
        entrenamiento.aplicarBonus(alma);
    }


    public HashSet<Alma> getAlmasCazadas(){
        HashSet<Alma> todasAlmasCazadas= new HashSet<Alma>();
        for(Demonio d: demonios){
            Set<Alma> cazadasPorDemonio = d.getAlmasCazadas();
            for(Alma a : cazadasPorDemonio){
                todasAlmasCazadas.add(a);
            }
        }
        return todasAlmasCazadas;
    }
    public Alma getAlmaMasValiente(){
        return getAlmasCazadas().stream().max(Comparator.comparing(Alma::getNivelDeValor)).get();
    }
    public Demonio getMasCazador(){
        return demonios.stream().max(Comparator.comparing(Demonio::getCantidadDeAlmasCazadas)).get();
    }
    public Lugar getLugar(String nombre){
        return lugares.stream().filter(l -> l.getNombre().equals(nombre)).findFirst().get();
    }
    public Optional<Demonio> batallar(Demonio demonio1,Demonio demonio2){
        Optional<Demonio> ganador = obtenerGanador(demonio1,demonio2);
        Optional<Demonio> perdedor = obtenerPerdedor(demonio1,demonio2);
        if(ganador.isPresent() && perdedor.isPresent()){
            premiar(ganador.get());
            castigar(perdedor.get());
            return ganador;
        }
        return Optional.empty();
    }
    public void asignarArma(Demonio demonio ,String tipoDeArma){
        Arma arma = armaFactory.getArma(tipoDeArma);
        demonio.setArma(Optional.of(arma));
    }
    void cambiarEstadoDeAnimo(){
        if(animoActual == triste){
            animoActual = contento;
        }
        else{
            animoActual = triste;
        }
    }
    void premiar(Demonio demonio){
        animoActual.premiar(demonio);
    }
    void castigar(Demonio demonio){
        animoActual.castigar(demonio);
    }

    Optional<Demonio> obtenerGanador(Demonio demonio1, Demonio demonio2){
        if(demonio1.getPoder() > demonio2.getPoder()){
            return Optional.of(demonio1);
        }
        else if(demonio1.getPoder() < demonio2.getPoder()){
            return Optional.of(demonio2);
        }
        return Optional.empty();
    }
    Optional<Demonio> obtenerPerdedor(Demonio demonio1, Demonio demonio2){
        if(demonio1.getPoder() < demonio2.getPoder()){
            return Optional.of(demonio1);
        }
        else if(demonio1.getPoder() > demonio2.getPoder()){
            return Optional.of(demonio2);
        }
        return Optional.empty();
    }
    public HashSet<Demonio> getDemonios() {
        return demonios;
    }


}

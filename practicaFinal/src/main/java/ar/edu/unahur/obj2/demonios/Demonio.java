package ar.edu.unahur.obj2.demonios;
import ar.edu.unahur.obj2.armas.Arma;
import ar.edu.unahur.obj2.lugares.Lugar;
import ar.edu.unahur.obj2.alma.Alma;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class Demonio {


    String nombre;
    float nivelDeMaldad;
    Set<Alma> almasCazadas = new HashSet<Alma>();



    Optional<Arma> arma = Optional.empty();

    public Demonio(float nivelDeMaldad,String nombre){
        this.nivelDeMaldad = nivelDeMaldad;
        this.nombre = nombre;
    }

    public float getPoder(){
        float poder = this.getNivelDeMaldad() + this.getCantidadDeAlmasCazadas();
        if(arma.isPresent()){
            poder = poder + arma.get().energia();
        }
        return poder;
    }
    public void salirACazar(Lugar lugar){
        lugar.recibirAtaque(this);
    }

    public void cazar(Alma a){
        almasCazadas.add(a);
    };

    public void atormentar(Alma a){
        a.setNivelDeBondad(a.getNivelDeBondad() - 5);
        atormentamientoParticular(a);
    }

    protected abstract void atormentamientoParticular(Alma a);
    protected abstract boolean condicionExtraParaCazar(Alma alma);
    public boolean puedeCazar(Alma alma){
        return alma.getNivelDeBondad() < this.getNivelDeMaldad() && this.condicionExtraParaCazar(alma);
    }
    public float getNivelDeMaldad() {
        return nivelDeMaldad;
    }
    public Set<Alma> getAlmasCazadas(){
        return almasCazadas;
    }
    public int getCantidadDeAlmasCazadas(){
        return almasCazadas.size();
    }
    public void setNivelDeMaldad(float nivelDeMaldad) {
        this.nivelDeMaldad = nivelDeMaldad;
    }
    public void eliminarAlmaCazada(){
        if(almasCazadas.size() > 0){
            almasCazadas.remove(almasCazadas.stream().findAny().get());
        }
    }
    public void setArma(Optional<Arma> arma) {
        this.arma = arma;
    }
    @Override
    public String toString() {
        return "Demonio " +
                "nombre='" + nombre + '\'' +
                ", nivelDeMaldad=" + nivelDeMaldad + '\'' +
                ". poder= " + getPoder();
    }
}

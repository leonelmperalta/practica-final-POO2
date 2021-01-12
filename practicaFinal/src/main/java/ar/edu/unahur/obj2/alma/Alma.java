package ar.edu.unahur.obj2.alma;

import ar.edu.unahur.obj2.tecnicasDeDefensa.CruzRoja;
import ar.edu.unahur.obj2.tecnicasDeDefensa.LuchaMarcialDemoniaca;
import ar.edu.unahur.obj2.tecnicasDeDefensa.SupervivenciaExtremaEnElInfierno;
import ar.edu.unahur.obj2.tecnicasDeDefensa.TecnicaDeDefensa;

import javax.print.attribute.standard.MediaSize;
import javax.swing.text.html.Option;
import java.util.Optional;

public class Alma {
    String nombre;
    float nivelDeBondad;
    float nivelDeValor;
    boolean friolenta;
    Optional<TecnicaDeDefensa> cruzRoja;
    Optional<TecnicaDeDefensa> luchaMarcial;
    Optional<TecnicaDeDefensa> supervivencia;

    public Alma(String nombre, float nivelDeBondad, float nivelDeValor, boolean friolenta){
        this.nombre = nombre;
        this.nivelDeBondad = nivelDeBondad;
        this.nivelDeValor = nivelDeValor;
        this.friolenta = friolenta;
        this.cruzRoja = Optional.empty();
        this.luchaMarcial = Optional.empty();
        this.supervivencia = Optional.empty();
    }

    public float getNivelDeBondad(){
        if(cruzRoja.isPresent()){
            if(this.nivelDeBondad < 100){
                this.setNivelDeBondad(100);
            }
        }
        return nivelDeBondad;
    }
    public float getNivelDeValor() {return nivelDeValor;}
    public void setFriolenta(boolean friolenta) {
        if(supervivencia.isPresent()){
            this.friolenta = false;
        }
        else{
            friolenta = friolenta;
        }
    }
    public void setNivelDeValor(float nivelDeValor) {this.nivelDeValor = nivelDeValor;}
    public void setNivelDeBondad(float nivelDeBondad){this.nivelDeBondad = nivelDeBondad;}
    public boolean isFriolenta() {return this.friolenta;}
    public void setEntrenamiento(TecnicaDeDefensa tecnicaDeDefensa, String tipoDeTecnica){
        if(tipoDeTecnica.equals("cruz roja")){
            this.cruzRoja = Optional.of(tecnicaDeDefensa);
        }
        else if(tipoDeTecnica.equals("lucha marcial demoniaca")){
            this.luchaMarcial = Optional.of(tecnicaDeDefensa);
        }
        else if(tipoDeTecnica.equals("supervivencia extrema en el infierno")){
            this.supervivencia = Optional.of(tecnicaDeDefensa);
        }
    }

    @Override
    public String toString() {
        return "Alma: " +
                nombre + '\'' +
                ", nivelDeBondad=" + nivelDeBondad +
                ", nivelDeValor=" + nivelDeValor +
                ", friolenta=" + friolenta;
    }


}

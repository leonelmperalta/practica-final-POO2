package ar.edu.unahur.obj2.demonios;

import ar.edu.unahur.obj2.tecnicasDeDefensa.CruzRoja;
import ar.edu.unahur.obj2.tecnicasDeDefensa.LuchaMarcialDemoniaca;
import ar.edu.unahur.obj2.tecnicasDeDefensa.SupervivenciaExtremaEnElInfierno;

public class DemonioFactory {
    public Demonio getDemonio(String tipoDemonio, float nivelDeMaldad,String nombre){
        if(tipoDemonio == null){
            return null;
        }
        else if(tipoDemonio.equals("demonio de sombra")){
            return new DemonioSombra(nivelDeMaldad,nombre);
        }
        else if(tipoDemonio.equals("demonio de fuego")){
            return new DemonioFuego(nivelDeMaldad,nombre);
        }
        else if(tipoDemonio.equals("demonio de hielo")){
            return new DemonioHielo(nivelDeMaldad,nombre);
        }
        return null;
    }
}

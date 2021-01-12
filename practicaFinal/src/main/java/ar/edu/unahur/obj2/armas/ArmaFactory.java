package ar.edu.unahur.obj2.armas;

import ar.edu.unahur.obj2.demonios.DemonioFuego;
import ar.edu.unahur.obj2.demonios.DemonioHielo;
import ar.edu.unahur.obj2.demonios.DemonioSombra;

public class ArmaFactory {

    public Arma getArma(String tipoDeArma){
        if(tipoDeArma == null){
            return null;
        }
        else if(tipoDeArma.equals("ballesta")){
            return new Ballesta();
        }
        else if(tipoDeArma.equals("espada")){
            return new Espada();
        }
        else if(tipoDeArma.equals("arco y flecha")){
            return new Arco_Y_Flecha();
        }
            return null;
    }
}

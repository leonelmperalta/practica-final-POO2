package ar.edu.unahur.obj2.demonios;

import ar.edu.unahur.obj2.alma.Alma;
import ar.edu.unahur.obj2.lugares.Infierno;
import ar.edu.unahur.obj2.lugares.Lugar;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;

import static org.testng.Assert.*;

public class DemonioFuegoSalirACazarTest {

    Demonio demonio;
    Lugar lugar = new Infierno();
    @BeforeMethod
    public void setUp() {
        demonio = new DemonioFuego(10,"Pepe");
        lugar.crearAlma("cazable",9,10,false);
        lugar.crearAlma("cazable1", 7,10,false);
        lugar.crearAlma("escondida",7,7,false);
        lugar.crearAlma("escondida1",11,11,false);
        lugar.crearAlma("noCazable",11,10,true);
    }

    @Test
    public void salirACazar(){
        /* En este cazo el demonio saldra a cazar al infierno, cazara 2 almas(cazabley cazable1), 2 se esconderan y no
        seran cazadas (escondida y escondida1) y 1 no puede ser cazada por el demonio(noCazable). Por lo tanto al final
        obtendriamos que el demonio cazo 2 almas y 3 almas siguen estando en el infierno.*/
        demonio.salirACazar(lugar);
        assertEquals(demonio.getCantidadDeAlmasCazadas(),2);
        assertEquals(lugar.getAlmas().size(), 3);
    }
}
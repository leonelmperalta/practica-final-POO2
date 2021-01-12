package ar.edu.unahur.obj2.demonios;

import ar.edu.unahur.obj2.lugares.Lugar;
import ar.edu.unahur.obj2.lugares.Paraiso;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DemonioHieloTestSalirACazar {
    Demonio demonio;
    Lugar lugar = new Paraiso();
    @BeforeMethod
    public void setUp() {
        demonio = new DemonioHielo(10,"Pepe");
        lugar.crearAlma("cazable",9,10,true);
        lugar.crearAlma("cazable1", 7,10,true);
        lugar.crearAlma("cazable",9,10,true);
        lugar.crearAlma("cazable1", 7,10,true);
        lugar.crearAlma("cazable",9,10,true);
        lugar.crearAlma("cazable1", 7,10,true);
        lugar.crearAlma("cazable",9,10,true);
        lugar.crearAlma("cazable1", 7,10,true);
        lugar.crearAlma("cazable",9,10,true);
        lugar.crearAlma("cazable1", 7,10,true);
        lugar.crearAlma("cazable",9,10,true);
        lugar.crearAlma("cazable1", 7,10,true);
        lugar.crearAlma("cazableYNoPuedeEsconderse",0,10,true);
        lugar.crearAlma("cazableYNoPuedeEsconderse",0,10,true);
        lugar.crearAlma("noCazableYNoPuedeEsconderse",0,10,false);
        lugar.crearAlma("noCazableYNoPuedeEsconderse",0,10,false);
        lugar.crearAlma("noCazableYNoPuedeEsconderse",0,10,false);
    }

    @Test
    public void salirACazar(){
        /* Para el siguiente caso, se crearon 17 almas habitantes del paraiso. En el paraiso si el alma tiene bondad > 0
        puede esconderse. Por lo tanto tenemos 12 almas cazables por el demonio, de las cuales 10 se esconderan. De las
        restantes, 3 no son cazables por el demonio y no pueden esconderse. Con lo que obtenemos que:
        El demonio podra cazar 4 almas, 10 se esconderan y 3 no pueden ser cazadas por el mismo.
         */
        demonio.salirACazar(lugar);
        assertEquals(lugar.getAlmas().size(), 13);
        assertEquals(demonio.getCantidadDeAlmasCazadas(),4);
    }
}
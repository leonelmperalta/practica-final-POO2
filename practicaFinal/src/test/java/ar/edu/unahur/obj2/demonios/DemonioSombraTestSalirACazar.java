package ar.edu.unahur.obj2.demonios;

import ar.edu.unahur.obj2.lugares.Lugar;
import ar.edu.unahur.obj2.lugares.Purgatorio;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DemonioSombraTestSalirACazar {
    Demonio demonio;
    Lugar lugar;
    @BeforeTest
    public void setUp(){
        demonio = new DemonioSombra(15, "Pepe");
        lugar = new Purgatorio();
        lugar.crearAlma("cazable",11,6,false);
        lugar.crearAlma("cazable",11,6,false);
        lugar.crearAlma("cazable",11,6,false);
        lugar.crearAlma("cazable",9,4,false);
        lugar.crearAlma("cazable",9,4,false);
        lugar.crearAlma("noCazable",11,51,false);
        lugar.crearAlma("noCazable",9,51,false);
    }

    @Test
    public void salirACazar(){
        /* Para este caso creamos 5 almas cazables por el demonio de sombras,  3 de ellas capaces de esconderse. Y 2
        almas mas , estas incazables para el demonio , una de ellas capaz de esconderse.
        Entonces obtendremos que el demonio podra cazar 2 almas y 5 quedaran a salvo en el purgatorio.
         */
        demonio.salirACazar(lugar);
        assertEquals(lugar.getAlmas().size(),5);
        assertEquals(demonio.getCantidadDeAlmasCazadas(),2);
    }
}
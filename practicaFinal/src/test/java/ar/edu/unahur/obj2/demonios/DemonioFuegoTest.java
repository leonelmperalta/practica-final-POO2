package ar.edu.unahur.obj2.demonios;

import ar.edu.unahur.obj2.alma.Alma;
import ar.edu.unahur.obj2.lugares.Lugar;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class DemonioFuegoTest {
    Demonio demonio;
    Alma alma1;
    Alma alma2;
    Alma alma3;
    Alma alma4;
    @BeforeMethod
    public void setUp() {
        demonio = new DemonioFuego(10,"Pepe");
        alma1 = new Alma("cazable",9,10,false);
        alma2 = new Alma("noCazablePorNoSerFriolenta",9,10,true);
        alma3 = new Alma("noCazablePorTenerMayorBondad",11,10,false);
        alma4 = new Alma("noCazablePorNoCumplirNingunaCondicion",11,10,true);
    }

    @Test
    public void puedeCazarok(){
        //Se cumple la condicion de que el demonio tiene mayor nivel de maldad que de bondad el alma. Y que el alma caza
        //da no es friolenta
        assertTrue(demonio.puedeCazar(alma1));

    }
    @Test
    public void puedeCazarFailPorNoSerFriolenta(){
        //El demonio no puede cazar el alma porque si bien su nivel de maldad es mayor al nivel de bondad del alma, esta
        //es friolenta
        assertFalse(demonio.puedeCazar(alma2));
    }
    @Test
    public void puedeCazarFailPorTenerMayorBondad(){
        //El demonio no puede cazar el alma porque si bien esta no es friolenta, tiene mayor nivel de bondad que de maldad
        //el demonio.
        assertFalse(demonio.puedeCazar(alma3));
    }
    @Test
    public void puedeCazarFailPorNoCumplirNingunaCondicion(){
        //El demonio no puede cazar el alma porque esta tiene mayor nivel de bondad que de maldad el demonio y ademas
        // es friolenta
        assertFalse(demonio.puedeCazar(alma4));
    }

    @Test
    public void atormentarAlma(){
        //En este caso al atormentar el alma, esta debe restar en 5 su nivel de bondad y deja de ser friolenta.
        demonio.atormentar(alma1);
        assertEquals(alma1.getNivelDeBondad(),4f);
        assertFalse(alma1.isFriolenta());
    }
}
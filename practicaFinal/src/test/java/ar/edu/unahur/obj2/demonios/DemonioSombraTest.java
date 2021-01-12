package ar.edu.unahur.obj2.demonios;

import ar.edu.unahur.obj2.alma.Alma;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DemonioSombraTest {
    Demonio demonio;
    Alma alma1;
    Alma alma2;
    Alma alma3;
    Alma alma4;
    @BeforeMethod
    public void setUp() {
        demonio = new DemonioSombra(10,"Pepe");
        alma1 = new Alma("cazable",9,10,false);
        alma2 = new Alma("noCazablePorNivelDeValor",9,51,true);
        alma3 = new Alma("noCazablePorTenerMayorBondad",11,10,false);
        alma4 = new Alma("noCazablePorNoCumplirNingunaCondicion",11,51,true);
    }

    @Test
    public void puedeCazarok(){
        //Se cumple la condicion de que el demonio tiene mayor nivel de maldad que de bondad el alma. Y que el alma caza
        //da no es friolenta
        assertTrue(demonio.puedeCazar(alma1));

    }
    @Test
    public void puedeCazarFailPorNivelDeValoyMayorA50(){
        //El demonio no puede cazar el alma porque si bien su nivel de maldad es mayor al nivel de bondad del alma, esta
        //tiene nivel de valor mayor a 50
        assertFalse(demonio.puedeCazar(alma2));
    }
    @Test
    public void puedeCazarFailPorTenerMayorBondad(){
        //El demonio no puede cazar el alma porque si bien esta no tiene nivel de valor mayor a 50, tiene mayor nivel de
        // bondad que de maldad el demonio.
        assertFalse(demonio.puedeCazar(alma3));
    }
    @Test
    public void puedeCazarFailPorNoCumplirNingunaCondicion(){
        //El demonio no puede cazar el alma porque esta tiene mayor nivel de bondad que de maldad el demonio y ademas
        // tiene nivel de valor mayor a 50
        assertFalse(demonio.puedeCazar(alma4));
    }

    @Test
    public void atormentarAlma(){
        //En este caso al atormentar el alma, esta debe restar en 5 su nivel de bondad y debe restar a la mitad el nivel
        //de valor
        demonio.atormentar(alma2);
        assertEquals(alma2.getNivelDeBondad(),4f);
        assertEquals(alma2.getNivelDeValor(),25.5f);
    }
}
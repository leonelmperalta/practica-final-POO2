package ar.edu.unahur.obj2.diablo;

import ar.edu.unahur.obj2.demonios.Demonio;
import ar.edu.unahur.obj2.demonios.DemonioFuego;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;
import static org.mockito.Mockito.*;
public class DiabloTestBatallarDemonios {
    Diablo diablo;
    Demonio demonio1;
    Demonio demonio2;
    Demonio demonio3;
    @BeforeTest
    public void setUp(){
        diablo = new Diablo();
        demonio1 = new DemonioFuego(10,"Carlos");
        demonio2 = new DemonioFuego(12,"Pepe");
        demonio3 = new DemonioFuego(10,"Rob");
    }
    // Estos test deben ser corridos uno por uno ya que al ganar una batalla un demonio, este es premiado y difiere los
    // resultados.
    @Test
    public void testBatallarGanaDemonio2(){
        assertEquals(diablo.batallar(demonio1,demonio2).get(),demonio2);
    }
    @Test
    public void testBatallarEmpate(){
        assertEquals(diablo.batallar(demonio1,demonio3), Optional.empty());
    }
    @Test
    public void testBatallarGanaDemonio1ConArma(){
        diablo.asignarArma(demonio1,"espada");
        assertEquals(diablo.batallar(demonio1,demonio2).get(),demonio1);
    }

}
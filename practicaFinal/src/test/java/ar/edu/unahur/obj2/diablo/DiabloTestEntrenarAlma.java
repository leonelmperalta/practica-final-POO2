package ar.edu.unahur.obj2.diablo;

import ar.edu.unahur.obj2.alma.Alma;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DiabloTestEntrenarAlma {
    Diablo diablo;
    Alma alma;

    @BeforeTest
    public void setUp(){
        diablo = new Diablo();
        alma = new Alma("carla",10,20,true);
    }

    @Test
    public void testEntrenarLuchaMarcialDemoniaca() {
        /* Cuando se entrena a un alma con esta tecnica, esta duplica el nivel de valor, osea esperamos un nivel de valor
        de 40.
         */
        diablo.entrenar(alma,"lucha marcial demoniaca");
        assertEquals(alma.getNivelDeValor(),40f);
    }

    @Test
    public void testEntrenarSupervivenciaExtremaEnElInfierno(){
        /* Cuando se entrena a un alma con esta tecnica, esta nunca puede volver a ser friolenta. Por lo tanto, lo aplica
        remos, corroboraremos que no es friolenta. Y luego volveremos a hacerla friolenta para verificar que no sea posible.
         */

        diablo.entrenar(alma, "supervivencia extrema en el infierno");
        assertFalse(alma.isFriolenta());
        alma.setFriolenta(false);
        assertFalse(alma.isFriolenta());
    }

    @Test
    public void testEntrenarCruzRoja(){
        /* Cuando se entrena a un alma con esta tecnica, esta nunca va a tener menos que 100 de bondad. Por lo tanto, lo aplica
        remos, corroboraremos que tenga por lo menos 100 de bondad y luego bajaremos la bondad a menos de 10 para verificar
        que no es posible.
         */

        diablo.entrenar(alma,"cruz roja");
        assertTrue(alma.getNivelDeBondad() >= 100);
        alma.setNivelDeBondad(50);
        assertTrue(alma.getNivelDeBondad() >= 100);
    }
}
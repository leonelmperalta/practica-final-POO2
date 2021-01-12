package ar.edu.unahur.obj2.tecnicasDeDefensa;

import ar.edu.unahur.obj2.alma.Alma;

public class SupervivenciaExtremaEnElInfierno implements TecnicaDeDefensa{
    public void aplicarBonus(Alma alma){
        alma.setFriolenta(false);
    }
}

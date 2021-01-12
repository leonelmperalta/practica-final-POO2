package ar.edu.unahur.obj2.lugares;

import ar.edu.unahur.obj2.alma.Alma;

public class Paraiso extends Lugar{
    @Override
    int lugaresParaEsconder() {
        return 10;
    }

    @Override
    protected boolean condicionExtraParaEsconder(Alma alma) {
        return alma.getNivelDeBondad() > 0;
    }

    @Override
    void penalizar(Alma alma) {
        alma.setNivelDeBondad(alma.getNivelDeBondad() - 1);
    }

    @Override
    public String getNombre() {
        return "paraiso";
    }
}

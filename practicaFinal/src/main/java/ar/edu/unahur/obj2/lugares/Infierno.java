package ar.edu.unahur.obj2.lugares;

import ar.edu.unahur.obj2.alma.Alma;

public class Infierno extends Lugar{
    @Override
    int lugaresParaEsconder() {
        return 2;
    }

    @Override
    protected boolean condicionExtraParaEsconder(Alma alma) {
        return ! alma.isFriolenta() && alma.getNivelDeBondad() == alma.getNivelDeValor();
    }

    @Override
    void penalizar(Alma alma) {
        alma.setFriolenta(true);
    }

    @Override
    public String getNombre() {
        return "infierno";
    }
}

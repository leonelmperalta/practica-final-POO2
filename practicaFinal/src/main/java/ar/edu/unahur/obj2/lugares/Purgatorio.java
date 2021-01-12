package ar.edu.unahur.obj2.lugares;

import ar.edu.unahur.obj2.alma.Alma;

public class Purgatorio extends Lugar{
    @Override
    int lugaresParaEsconder() {
        return 5;
    }

    @Override
    protected boolean condicionExtraParaEsconder(Alma alma) {
        return alma.getNivelDeBondad() > 10 && alma.getNivelDeValor() > 5;
    }

    @Override
    void penalizar(Alma alma) {
        alma.setNivelDeBondad(alma.getNivelDeBondad() - 5);
        alma.setNivelDeValor(alma.getNivelDeValor() - 1);
    }

    @Override
    public String getNombre() {
        return "purgatorio";
    }
}

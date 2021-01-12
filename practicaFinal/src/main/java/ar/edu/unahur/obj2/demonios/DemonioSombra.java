package ar.edu.unahur.obj2.demonios;

import ar.edu.unahur.obj2.alma.Alma;

public class DemonioSombra extends Demonio{
    public DemonioSombra(float nivelDeMaldad, String nombre) {
        super(nivelDeMaldad, nombre);
    }

    @Override
    protected void atormentamientoParticular(Alma a){ a.setNivelDeValor(a.getNivelDeValor() / 2f); }

    @Override
    protected boolean condicionExtraParaCazar(Alma alma) {
        return alma.getNivelDeValor() < 50;
    }
}

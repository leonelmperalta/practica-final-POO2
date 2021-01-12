package ar.edu.unahur.obj2.demonios;

import ar.edu.unahur.obj2.alma.Alma;

public class DemonioFuego extends Demonio{
    public DemonioFuego(float nivelDeMaldad, String nombre) {
        super(nivelDeMaldad, nombre);
    }

    @Override
    protected void atormentamientoParticular(Alma a) {
        a.setFriolenta(false);
    }
    @Override
    protected boolean condicionExtraParaCazar(Alma alma) {
        return  ! alma.isFriolenta();
    }
}

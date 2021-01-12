package ar.edu.unahur.obj2.estadosDeAnimo;

import ar.edu.unahur.obj2.demonios.Demonio;

public class Contento implements EstadoDeAnimo{
    @Override
    public void premiar(Demonio demonio) {
        demonio.setNivelDeMaldad(demonio.getNivelDeMaldad() + 10);
    }

    @Override
    public void castigar(Demonio demonio) {
        for(int i = 0; i < 3 ; i ++){
            demonio.eliminarAlmaCazada();
        }
    }
}

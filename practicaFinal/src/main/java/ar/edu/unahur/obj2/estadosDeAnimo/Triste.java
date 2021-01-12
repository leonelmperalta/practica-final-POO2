package ar.edu.unahur.obj2.estadosDeAnimo;

import ar.edu.unahur.obj2.demonios.Demonio;

public class Triste implements EstadoDeAnimo{
    @Override
    public void premiar(Demonio demonio) {
        demonio.setNivelDeMaldad(demonio.getNivelDeMaldad() + 1);
    }

    @Override
    public void castigar(Demonio demonio) {
        for(int i = 0; i <= demonio.getCantidadDeAlmasCazadas() ; i++){
            demonio.eliminarAlmaCazada();
        }
    }
}

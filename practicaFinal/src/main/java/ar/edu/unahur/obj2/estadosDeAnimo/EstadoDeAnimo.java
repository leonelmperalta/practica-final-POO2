package ar.edu.unahur.obj2.estadosDeAnimo;

import ar.edu.unahur.obj2.demonios.Demonio;

public interface EstadoDeAnimo {
    void premiar(Demonio demonio);
    void castigar(Demonio demonio);
}

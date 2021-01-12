package ar.edu.unahur.obj2.tecnicasDeDefensa;

import ar.edu.unahur.obj2.alma.Alma;

public class LuchaMarcialDemoniaca implements TecnicaDeDefensa{
    public void aplicarBonus(Alma alma){
        alma.setNivelDeValor(alma.getNivelDeValor() * 2);
    }
}

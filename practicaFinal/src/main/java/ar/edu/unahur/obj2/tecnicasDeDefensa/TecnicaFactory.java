package ar.edu.unahur.obj2.tecnicasDeDefensa;

public class TecnicaFactory {
    public TecnicaDeDefensa getTecnica(String tipoDeTecnica){
        if(tipoDeTecnica == null){
            return null;
        }
        else if(tipoDeTecnica.equals("cruz roja")){
            return new CruzRoja();
        }
        else if(tipoDeTecnica.equals("lucha marcial demoniaca")){
            return new LuchaMarcialDemoniaca();
        }
        else if(tipoDeTecnica.equals("supervivencia extrema en el infierno")){
            return new SupervivenciaExtremaEnElInfierno();
        }
        return null;
    }
}

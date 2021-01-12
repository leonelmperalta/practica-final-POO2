package ar.edu.unahur.obj2.interfaz;
import ar.edu.unahur.obj2.*;
import ar.edu.unahur.obj2.alma.Alma;
import ar.edu.unahur.obj2.demonios.Demonio;
import ar.edu.unahur.obj2.diablo.Diablo;
import ar.edu.unahur.obj2.lugares.Lugar;
import ar.edu.unahur.obj2.tecnicasDeDefensa.TecnicaDeDefensa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class InterfazGrafica extends JFrame{
    public InterfazGrafica(){
        super("Diablo");
        final Diablo diablo = new Diablo();
        setLayout(new GridBagLayout());
        Container panel = getContentPane();
        GridBagConstraints constraints = new GridBagConstraints();

        JButton botonCrearAlma = new JButton("Crear un Alma");
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weighty = 1;
        panel.add(botonCrearAlma,constraints);
        botonCrearAlma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    Lugar lugar = elegirLugar(botonCrearAlma,diablo);
                    String nombreAlma = JOptionPane.showInputDialog(botonCrearAlma,"Ingrese el nombre del alma a crear.");
                    float nivelDeBondad = Float.parseFloat(JOptionPane.showInputDialog(botonCrearAlma,"Inserte " +
                    "el nivel de bondad del alma.",JOptionPane.QUESTION_MESSAGE));
                    float nivelDeValor = Float.parseFloat(JOptionPane.showInputDialog(botonCrearAlma,"Inserte " +
                    "el nivel de valor del alma",JOptionPane.QUESTION_MESSAGE));
                    String[] friolentaONo = {"Es Friolenta","No es friolenta"};
                    int seleccionFriolenta = JOptionPane.showOptionDialog(botonCrearAlma,"Seleccione si el alma es friolenta", "",
                    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,friolentaONo,null);
                    if(seleccionFriolenta != -1){
                        if(seleccionFriolenta == 0){
                            lugar.crearAlma(nombreAlma,nivelDeBondad,nivelDeValor,true);
                        }
                        else{
                            lugar.crearAlma(nombreAlma,nivelDeBondad,nivelDeValor,false);
                        }
                    }
                }
        });
        JButton botonCrearDemonio = new JButton("Crear un Demonio");
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weighty = 1;
        panel.add(botonCrearDemonio,constraints);
        botonCrearDemonio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] tiposDemonio = {"demonio de sombra","demonio de fuego","demonio de hielo"};
                int seleccion = JOptionPane.showOptionDialog(botonCrearDemonio,"Elige el tipo de demonio",""
                ,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,tiposDemonio,null);
                float nivelDeMaldad = Float.parseFloat(JOptionPane.showInputDialog(botonCrearDemonio,"Inserte " +
                "el nivel de maldad del demonio.",JOptionPane.QUESTION_MESSAGE));
                String nombreDemonio = JOptionPane.showInputDialog(botonCrearDemonio,"Inserte " +
                "el nombre del demonio.",JOptionPane.QUESTION_MESSAGE);
                if(seleccion != - 1){
                    diablo.crearDemonio(tiposDemonio[seleccion],nivelDeMaldad,nombreDemonio);
                }
            }
        });
        JButton botonEntrenarAlma = new JButton("Entrenar un Alma");
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weighty = 1;
        panel.add(botonEntrenarAlma,constraints);
        botonEntrenarAlma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Alma almaAEntrenar = elegirAlmaAEntrenar(botonEntrenarAlma,diablo);
                if(almaAEntrenar != null){
                    String[] entrenamientos = {"cruz roja","lucha marcial demoniaca","supervivencia extrema en el infierno"};
                    int seleccion = JOptionPane.showOptionDialog(botonEntrenarAlma,"Elige el tipo de tecnica para en" +
                    "trenar el alma.","",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,entrenamientos
                    ,null);
                    diablo.entrenar(almaAEntrenar,entrenamientos[seleccion]);
                }
            }
        });

        JButton botonDeEstadisticas = new JButton("Ver estadisticas");
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 2; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weighty = 1;
        panel.add(botonDeEstadisticas,constraints);
        botonDeEstadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] opciones = {"Todas las almas cazadas","Alma mas valiente","Demonio que mas cazo"};
                int seleccion = JOptionPane.showOptionDialog(botonDeEstadisticas,"seleccione el dato que desea " +
                "conocer","Estadisticas",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opciones,null);
                if(seleccion != -1){
                    if(seleccion == 0){
                        mostrarTodasLasAlmasCazadas(botonDeEstadisticas,diablo);
                    }
                    else if(seleccion == 1){
                        mostrarAlmaMasValiente(botonDeEstadisticas,diablo);
                    }
                    else if(seleccion == 2){
                        mostrarDemonioQueMasCazo(botonDeEstadisticas,diablo);
                    }
                }
            }
        });
        JButton botonOrganizarBatalla = new JButton("Organizar Batalla");
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 2; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weighty = 1;
        panel.add(botonOrganizarBatalla,constraints);
        botonOrganizarBatalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Demonio demonio1 = elegirDemonio(botonOrganizarBatalla,diablo);
                Demonio demonio2 = elegirDemonio(botonOrganizarBatalla,diablo);
                if(demonio1 != null && demonio2 != null){
                    Optional<Demonio> resultado = diablo.batallar(demonio1,demonio2);
                    if(resultado.get() == null){
                        JOptionPane.showMessageDialog(botonOrganizarBatalla,"Empate!");
                    }
                    else{
                        JOptionPane.showMessageDialog(botonOrganizarBatalla,"El ganador es: " + resultado.get().toString());
                    }
                }
            }
        });

        JButton botonMandarACazarDemonio = new JButton("Ir a cazar almas");
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weighty = 1;
        panel.add(botonMandarACazarDemonio,constraints);
        botonMandarACazarDemonio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Demonio demonio = elegirDemonio(botonMandarACazarDemonio,diablo);
                 if(demonio != null){
                    Lugar lugar = elegirLugar(botonMandarACazarDemonio,diablo);
                    diablo.mandarACazar(demonio,lugar);
                 }
            }
        });

        JLabel logo =  new JLabel(new ImageIcon("src/main/resources/diablo.png"));
        constraints.gridx = 1; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 3; // El área de texto ocupa 2 filas.
        constraints.weightx = 1;
        constraints.weighty = 1;
        panel.add(logo,constraints);

        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void mostrarDemonioQueMasCazo(Component componentePadre, Diablo diablo) {
        if(!diablo.getDemonios().isEmpty()){
            HashSet<Demonio> demonios = diablo.getDemonios();
            String demonioQueMasCazo = "Demonio que mas cazo: " + diablo.getMasCazador().toString();
            if(diablo.getMasCazador().getAlmasCazadas().size() > 0){
                JOptionPane.showMessageDialog(componentePadre, demonioQueMasCazo);
            }
            else{
                JOptionPane.showMessageDialog(componentePadre,"Ningun demonio ha cazado un alma aun.",":(",
                JOptionPane.ERROR_MESSAGE,null);
            }
        }
        else{
            JOptionPane.showMessageDialog(componentePadre,"Aun no se ha creado un demonio.","Error!",
            JOptionPane.ERROR_MESSAGE,null);
        }

    }

    private void mostrarAlmaMasValiente(Component componentePadre, Diablo diablo) {
        if(! diablo.getAlmasCazadas().isEmpty()){
            String almaMasValiente = "Alma mas valiente: " + diablo.getAlmaMasValiente().toString();
            JOptionPane.showMessageDialog(componentePadre, almaMasValiente);
        }
        else{
            JOptionPane.showMessageDialog(componentePadre,"Aun no se ha cazado ningun alma.","Error!",
            JOptionPane.ERROR_MESSAGE,null);
        }
    }

    public Alma elegirAlmaAEntrenar(Component componentepadre, Diablo diablo){
            Lugar lugar = elegirLugar(componentepadre,diablo);
            if(! lugar.getAlmas().isEmpty()){
                HashSet<Alma> almas = lugar.getAlmas();
                Object[] almasList = almas.toArray();
                Object seleccionAlma = JOptionPane.showInputDialog(componentepadre,"Seleccione el alma a " +
                "entrenar","",JOptionPane.QUESTION_MESSAGE,null,almasList,almasList[0]);
                Alma almaAEntrenar = almas.stream().filter(a -> a.toString().equalsIgnoreCase(seleccionAlma.toString())).findFirst().get();
                return almaAEntrenar;
            }
            else{
                JOptionPane.showMessageDialog(componentepadre,"No hay almas en el lugar seleccionado.",
                "Error!",JOptionPane.ERROR_MESSAGE,null);
            }
            return null;
    }
    public Demonio elegirDemonio(Component componentePadre, Diablo diablo){
        HashSet<Demonio> demonios = diablo.getDemonios();
         if(! demonios.isEmpty()){
            Object[] demoniosList = demonios.toArray();
            Object seleccionDemonio = JOptionPane.showInputDialog(componentePadre,"Seleccione el demonio "
            ,"",JOptionPane.QUESTION_MESSAGE,null,demoniosList,demoniosList[0]);
            Demonio demonio = demonios.stream().filter(a -> a.toString().equalsIgnoreCase(seleccionDemonio.toString())).findFirst().get();
            return demonio;
         }
         else{
             JOptionPane.showMessageDialog(componentePadre,"Todavia no ha creado un demonio.","Error!"
             ,JOptionPane.ERROR_MESSAGE,null);
         }
         return null;
     }

    public Lugar elegirLugar(Component componentePadre, Diablo diablo){
        String[] lugares = {"paraiso","purgatorio","infierno"};
        int seleccion = JOptionPane.showOptionDialog(componentePadre,"Elige el lugar:",""
                ,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,lugares,null);
        if(seleccion != -1){
            Lugar lugar = diablo.getLugar(lugares[seleccion]);
            return lugar;
        }
        return null;
    }

    public void mostrarTodasLasAlmasCazadas(Component componentePadre,Diablo diablo){
        if(! diablo.getAlmasCazadas().isEmpty()){
            Alma[] almas = diablo.getAlmasCazadas().toArray(new Alma[0]);
            JList<Alma> almaJList = new JList<Alma>(almas);
            JFrame lista = new JFrame();
            lista.getContentPane().add(almaJList);
            lista.setSize(200,200);
            lista.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(componentePadre,"Aun no se ha cazado ningun alma.","Error!"
            ,JOptionPane.ERROR_MESSAGE,null);
        }
    }
    public static void main(String[] args) {
        InterfazGrafica interfaz = new InterfazGrafica();
    }
}

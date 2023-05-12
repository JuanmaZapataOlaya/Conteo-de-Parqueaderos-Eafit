import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParqueaderoEafit extends JPanel{
    private JButton botonTocame;
    private String documento = null;
    private String placa = null;
    private JTextField textFieldCCTI;
    private JTextField textFieldPlaca;
    private JLabel textoID;
    private JLabel textoPlaca;
    private JLabel textoCopy;
    private JCheckBox disabilityCheck;
    private JLabel textoHeader;

    public ParqueaderoEafit() {
        //construct components
        textoID = new JLabel ("Documento de Identidad (C.C o T.I)");
        textoPlaca = new JLabel ("Placa del vehículo (formato preferido: ABC123)");
        textoHeader = new JLabel ("PARQUEA EAFIT");
        textoHeader.setFont(new Font("Serif", Font.PLAIN, 30)); //Usado para que el header tenga un estilo distintivo
        textoCopy = new JLabel ("(C) Juan Manuel Zapata Olaya, Carlos David Sanchez Soto, Miguel Angel Salgar Olarte; 2023");
        textFieldCCTI = new JTextField();
        textFieldCCTI.setToolTipText("Ingrese Cédula o Tarjeta de Identidad");
        textFieldPlaca = new JTextField();
        textFieldPlaca.setToolTipText("Ingrese Placa");
        botonTocame = new JButton ("Acceder");
        disabilityCheck = new JCheckBox ("Discapacitad@");
        disabilityCheck.setToolTipText ("Si eres una persona de movilidad reducida, marca esto");
        
        
        botonTocame.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                documento = textFieldCCTI.getText();
                if(documento.length() == 0){
                    JOptionPane.showMessageDialog(null, "No ingresaste un documento válido, automáticamente asignaremos el documento 0000000000", "Error", JOptionPane.OK_OPTION);
                    documento = "0000000000";
                    System.out.println("Documento inválido, se asignó automáticamente 0000000000");
                }
                placa = textFieldPlaca.getText();
                char ultimoDigitoPlaca = '0';
                if(placa.length() < 5){
                    JOptionPane.showMessageDialog(null, "No ingresaste una placa válida, automáticamente asignaremos la placa ABC000", "Error", JOptionPane.OK_OPTION);
                    System.out.println("La placa ingresada no es válida, se autoasignará la placa AAA000");
                    placa = "AAA000";
                }
                else{
                    ultimoDigitoPlaca = placa.charAt(5);
                }
                LocalDate localDate=LocalDate.now();
                Locale spanishLocale=new Locale("es", "ES");
                String dia=localDate.format(DateTimeFormatter.ofPattern("EEEE",spanishLocale));
                System.out.println(dia);
                boolean discapacidad = false;
                if(disabilityCheck.isSelected()){
                    discapacidad = true;
                }
                boolean tienePicoYPlaca = Proceso.procesoPlaca(ultimoDigitoPlaca, dia);
                System.out.println(tienePicoYPlaca);
                if(tienePicoYPlaca) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, pero tienes pico y placa", "Alerta",JOptionPane.CLOSED_OPTION);
                }else {
                    Persistencia.guardarUsuario(documento, ultimoDigitoPlaca, discapacidad);
                    JFrame frame = new JFrame ("Opciones");
                    frame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
                    frame.getContentPane().add (new PanelOpciones(documento, placa));
                    frame.pack();
                    frame.setVisible (true);
                }
            }
        });
        
       //adjust size and set layout
        setPreferredSize (new Dimension (752, 425));
        setLayout (null);

        //add components
        add (textFieldCCTI);
        add (textFieldPlaca);
        add (botonTocame);
        add (disabilityCheck);
        add (textoID);
        add (textoPlaca);
        add (textoCopy);
        add (textoHeader);
        
        //set component bounds (only needed by Absolute Positioning)
        textFieldCCTI.setBounds (300, 105, 100, 25);
        textFieldPlaca.setBounds (300, 140, 100, 25);
        botonTocame.setBounds (300, 225, 100, 25);
        disabilityCheck.setBounds (300, 175, 150, 40);
        textoID.setBounds (98, 100, 265, 30);
        textoPlaca.setBounds (32, 136, 315, 25);
        textoCopy.setBounds (220 ,395 ,650 , 25);
        textoHeader.setBounds (250, 45, 450, 40);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("PARQUEA EAFIT Inicio"); //El nombre de la ventana que aparece ahí arriba lol
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ParqueaderoEafit());
        frame.pack();
        frame.setVisible (true);
    }
}

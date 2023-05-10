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
    private JCheckBox disabilityCheck;

    public ParqueaderoEafit() {
        //construct components
        textFieldCCTI = new JTextField();
        textFieldCCTI.setToolTipText("Ingrese Cedula o Tarjeta de Identidad");
        textFieldPlaca = new JTextField();
        textFieldPlaca.setToolTipText("Ingrese Placa");
        botonTocame = new JButton ("Acceder");
        disabilityCheck = new JCheckBox ("Discapacitad@");
        disabilityCheck.setToolTipText ("Si eres una persona de movilidad reducida, marca esto");
        
        botonTocame.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                documento = textFieldCCTI.getText();
                placa = textFieldPlaca.getText();
                char ultimoDigitoPlaca = placa.charAt(5);
                LocalDate localDate=LocalDate.now();
                Locale spanishLocale=new Locale("es", "ES");
                String dia=localDate.format(DateTimeFormatter.ofPattern("EEEE",spanishLocale));
                System.out.println(dia);
                boolean tienePicoYPlaca = Proceso.procesoPlaca(ultimoDigitoPlaca, dia);
                System.out.println(tienePicoYPlaca);
                if(tienePicoYPlaca) {
                    JOptionPane.showMessageDialog(null, "Lo sentimos, pero tienes pico y placa", "Alerta",JOptionPane.CLOSED_OPTION);
                }else {
                    Persistencia.guardarUsuario(documento, ultimoDigitoPlaca);
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
        

        //set component bounds (only needed by Absolute Positioning)
        textFieldCCTI.setBounds (300, 105, 100, 25);
        textFieldPlaca.setBounds (300, 140, 100, 25);
        botonTocame.setBounds (300, 225, 100, 25);
        disabilityCheck.setBounds (300, 175, 150, 40);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("ParqueaderoEafitPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ParqueaderoEafit());
        frame.pack();
        frame.setVisible (true);
    }
}

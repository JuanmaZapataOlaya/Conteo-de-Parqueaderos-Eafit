import java.awt.Dimension;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelOpciones extends JPanel{
	
	private JButton botonPerfil;
    private JButton botonParqueadero;
    private JButton botonSaldo;
    private JLabel labelDocumento;
    private JTextField textFieldDocumento;
    private JLabel labelPlaca;
    private JTextField textFieldPlaca;
    private JComboBox tipoParqueadero;
    private String documento;
    private String placa;
    private JLabel labelSaldoTiene;
    private JTextField textFieldSaldoTiene;
    private JLabel labelSaldoPagar;
    private JTextField textFieldSaldoPagar;
    private JLabel labelSaldoRestante;
    private JTextField textFieldSaldoRestante;
    private JButton botonAsignarSaldo;
    private int saldo = 0;

    public PanelOpciones(String documento, String placa) {
    	this.documento = documento;
    	this.placa = placa;
    	botonPerfil = new JButton ("Pérfil");
        botonParqueadero = new JButton ("Parqueaderos");
        botonSaldo = new JButton ("Saldo");
        
        botonPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textFieldDocumento != null && textFieldDocumento.isVisible()) {
					labelDocumento.setVisible(false);
					remove(labelDocumento);
					textFieldDocumento.setVisible(false);
					remove(textFieldDocumento);
				}
				if(textFieldPlaca != null && textFieldPlaca.isVisible()) {
					labelPlaca.setVisible(false);
					remove(labelPlaca);
					textFieldPlaca.setVisible(false);
					remove(textFieldPlaca);
				}
				if(textFieldSaldoTiene != null && textFieldSaldoTiene.isVisible()) {
					labelSaldoTiene.setVisible(false);
					remove(labelSaldoTiene);
					textFieldSaldoTiene.setVisible(false);
					remove(textFieldSaldoTiene);
				}
				if(textFieldSaldoPagar != null && textFieldSaldoPagar.isVisible()) {
					labelSaldoPagar.setVisible(false);
					remove(labelSaldoPagar);
					textFieldSaldoPagar.setVisible(false);
					remove(textFieldSaldoPagar);
				}
				if(textFieldSaldoRestante != null && textFieldSaldoRestante.isVisible()) {
					labelSaldoRestante.setVisible(false);
					remove(labelSaldoRestante);
					textFieldSaldoRestante.setVisible(false);
					remove(textFieldSaldoRestante);
				}
				if(tipoParqueadero != null && tipoParqueadero.isVisible()) {
					tipoParqueadero.setVisible(false);
					remove(tipoParqueadero);
				}
				if(botonAsignarSaldo != null && botonAsignarSaldo.isVisible()) {
					botonAsignarSaldo.setVisible(false);
					remove(botonAsignarSaldo);
				}
				labelDocumento = new JLabel ("C.C. o T.I.");
		        textFieldDocumento = new JTextField (5);
		        textFieldDocumento.setEditable(false);
		        textFieldDocumento.setText(documento);
				textFieldDocumento.setVisible(true);
				labelPlaca = new JLabel ("Placa del vehículo");
				textFieldPlaca = new JTextField (5);
				textFieldPlaca.setEditable(false);
				textFieldPlaca.setText(placa);
				textFieldPlaca.setVisible(true);
				add (labelDocumento);
		        add (textFieldDocumento);
		        add (labelPlaca);
		        add (textFieldPlaca);
		        textFieldDocumento.setBounds (180, 100, 100, 25);
		        textFieldPlaca.setBounds (180, 140, 100, 25);
		        labelDocumento.setBounds (50, 95, 100, 25);
		        labelPlaca.setBounds (50, 140, 115, 25);
				
			}
		});
        
        
        botonParqueadero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method 
				if(textFieldDocumento != null && textFieldDocumento.isVisible()) {
					labelDocumento.setVisible(false);
					remove(labelDocumento);
					textFieldDocumento.setVisible(false);
					remove(textFieldDocumento);
				}
				if(textFieldPlaca != null && textFieldPlaca.isVisible()) {
					labelPlaca.setVisible(false);
					remove(labelPlaca);
					textFieldPlaca.setVisible(false);
					remove(textFieldPlaca);
				}
				if(textFieldSaldoTiene != null && textFieldSaldoTiene.isVisible()) {
					labelSaldoTiene.setVisible(false);
					remove(labelSaldoTiene);
					textFieldSaldoTiene.setVisible(false);
					remove(textFieldSaldoTiene);
				}
				if(textFieldSaldoPagar != null && textFieldSaldoPagar.isVisible()) {
					labelSaldoPagar.setVisible(false);
					remove(labelSaldoPagar);
					textFieldSaldoPagar.setVisible(false);
					remove(textFieldSaldoPagar);
				}
				if(textFieldSaldoRestante != null && textFieldSaldoRestante.isVisible()) {
					labelSaldoRestante.setVisible(false);
					remove(labelSaldoRestante);
					textFieldSaldoRestante.setVisible(false);
					remove(textFieldSaldoRestante);
				}
				if(botonAsignarSaldo != null && botonAsignarSaldo.isVisible()) {
					botonAsignarSaldo.setVisible(false);
					remove(botonAsignarSaldo);
				}
				
				int[] tipos = Celdas.tiposCeldas(8);
				int totalParqueaderosDisponibles = tipos[0] + tipos[1] + tipos[2];
				int opcion = JOptionPane.showConfirmDialog(null, "Hay "+totalParqueaderosDisponibles+" parqueaderos disponibles, desea escoger su parqueadero", "Opciones",JOptionPane.OK_CANCEL_OPTION);
				System.out.println(opcion+" "+JOptionPane.OK_OPTION);
				if(opcion == JOptionPane.OK_OPTION) {
					String[] tipoParqueaderos = {"Carros Normales: "+tipos[0], "Motos: "+tipos[1], "Carros Eléctricos: "+tipos[2]};
					tipoParqueadero = new JComboBox (tipoParqueaderos);
					add (tipoParqueadero);
					tipoParqueadero.setBounds (305, 120, 145, 20);
					tipoParqueadero.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println("Opcion: "+tipoParqueadero.getSelectedIndex());
							System.out.println("Valor: "+tipos[tipoParqueadero.getSelectedIndex()]);
							if(saldo == 0 || saldo < 6000) {
								int opcionSaldo = JOptionPane.showConfirmDialog(null, "No tiene suficiente saldo, por favor revise su saldo", null, JOptionPane.OK_OPTION);
								if(opcionSaldo == JOptionPane.OK_OPTION) {
									cargarSaldos();
								}
							}else if(tipos[tipoParqueadero.getSelectedIndex()] == 0){
								JOptionPane.showMessageDialog(null, "Lo sentimos, no hay parqueaderos disponibles por el momento", "Error", JOptionPane.OK_OPTION);
							}else {
								System.out.println("Saldo antes de pagar parqueadero: "+saldo);								
								String ticket = Proceso.procesoParquear(saldo, tipos[tipoParqueadero.getSelectedIndex()]);
								saldo = saldo - 6000;
								JOptionPane.showConfirmDialog(null, "Parqueo exitoso con tiquete: "+ticket, "Parqueo exitoso", JOptionPane.DEFAULT_OPTION);
							}
						}
					});
				}
			}
		});
        
        botonSaldo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cargarSaldos();
			}
		});

        //adjust size and set layout
        setPreferredSize (new Dimension (752, 425));
        setLayout (null);

        //add components
        add (botonPerfil);
        add (botonParqueadero);
        add (botonSaldo);

        //set component bounds (only needed by Absolute Positioning)
        botonPerfil.setBounds (180, 60, 100, 20);
        botonParqueadero.setBounds (300, 60, 140, 20);
        botonSaldo.setBounds (460, 60, 135, 20);
    }
    
    public void cargarSaldos() {
    	botonAsignarSaldo = new JButton ("Asignar Saldo");
    	if(textFieldDocumento != null && textFieldDocumento.isVisible()) {
			labelDocumento.setVisible(false);
			remove(labelDocumento);
			textFieldDocumento.setVisible(false);
			remove(textFieldDocumento);
		}
		if(textFieldPlaca != null && textFieldPlaca.isVisible()) {
			labelPlaca.setVisible(false);
			remove(labelPlaca);
			textFieldPlaca.setVisible(false);
			remove(textFieldPlaca);
		}
		if(tipoParqueadero != null && tipoParqueadero.isVisible()) {
			tipoParqueadero.setVisible(false);
			remove(tipoParqueadero);
		}
		
		labelDocumento = new JLabel ("C.C. o T.I.");
        textFieldDocumento = new JTextField (5);
        textFieldDocumento.setEditable(false);
        textFieldDocumento.setText(documento);
		textFieldDocumento.setVisible(true);
		labelPlaca = new JLabel ("Placa del vehículo");
		textFieldPlaca = new JTextField (5);
		textFieldPlaca.setEditable(false);
		textFieldPlaca.setText(placa);
		textFieldPlaca.setVisible(true);
		labelSaldoTiene = new JLabel ("Saldo que tiene");
        textFieldSaldoTiene = new JTextField (5);
        textFieldSaldoTiene.setText(""+saldo);
		textFieldSaldoTiene.setVisible(true);
		labelSaldoPagar = new JLabel ("Saldo a pagar");
		textFieldSaldoPagar = new JTextField (5);
		textFieldSaldoPagar.setText(""+6000);
		textFieldSaldoPagar.setVisible(true);
		labelSaldoRestante = new JLabel ("Saldo restante");
		textFieldSaldoRestante = new JTextField (5);
		textFieldSaldoRestante.setText(""+(saldo - 6000));
		textFieldSaldoRestante.setVisible(true);
		add (labelDocumento);
        add (textFieldDocumento);
        add (labelPlaca);
        add (textFieldPlaca);
        add (labelSaldoTiene);
        add (textFieldSaldoTiene);
        add (labelSaldoPagar);
        add (textFieldSaldoPagar);
        add (labelSaldoRestante);
        add (textFieldSaldoRestante);
        add (botonAsignarSaldo);
        textFieldDocumento.setBounds (230, 100, 100, 25);
        textFieldPlaca.setBounds (230, 140, 100, 25);
        textFieldSaldoTiene.setBounds (230, 180, 100, 25);
        textFieldSaldoPagar.setBounds (230, 220, 100, 25);
        textFieldSaldoRestante.setBounds (230, 260, 100, 25);
        labelDocumento.setBounds (50, 95, 200, 25);
        labelPlaca.setBounds (50, 140, 200, 25);
        labelSaldoTiene.setBounds (50, 185, 200, 25);
        labelSaldoPagar.setBounds (50, 230, 200, 25);
        labelSaldoRestante.setBounds (50, 275, 100, 25);
        botonAsignarSaldo.setBounds (190, 325, 200, 30);
        botonAsignarSaldo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] valoresRecarga = {"2000", "4000", "6000", "8000", "10000", "20000", "50000", "100000"};
				String s = (String)JOptionPane.showInputDialog(
				                    null,
				                    "Cuanto saldo desea recargar?",
				                    "Recargas",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    valoresRecarga,
				                    "2000");

				if ((s != null) && (s.length() > 0)) {
					saldo = saldo + Integer.valueOf(s);
					Persistencia.guardarSaldo(saldo);
					if(textFieldDocumento != null && textFieldDocumento.isVisible()) {
						labelDocumento.setVisible(false);
						remove(labelDocumento);
						textFieldDocumento.setVisible(false);
						remove(textFieldDocumento);
					}
					if(textFieldPlaca != null && textFieldPlaca.isVisible()) {
						labelPlaca.setVisible(false);
						remove(labelPlaca);
						textFieldPlaca.setVisible(false);
						remove(textFieldPlaca);
					}
					if(tipoParqueadero != null && tipoParqueadero.isVisible()) {
						tipoParqueadero.setVisible(false);
						remove(tipoParqueadero);
					}
					if(textFieldSaldoTiene != null && textFieldSaldoTiene.isVisible()) {
						labelSaldoTiene.setVisible(false);
						remove(labelSaldoTiene);
						textFieldSaldoTiene.setVisible(false);
						remove(textFieldSaldoTiene);
					}
					if(textFieldSaldoPagar != null && textFieldSaldoPagar.isVisible()) {
						labelSaldoPagar.setVisible(false);
						remove(labelSaldoPagar);
						textFieldSaldoPagar.setVisible(false);
						remove(textFieldSaldoPagar);
					}
					if(textFieldSaldoRestante != null && textFieldSaldoRestante.isVisible()) {
						labelSaldoRestante.setVisible(false);
						remove(labelSaldoRestante);
						textFieldSaldoRestante.setVisible(false);
						remove(textFieldSaldoRestante);
					}
					if(botonAsignarSaldo != null && botonAsignarSaldo.isVisible()) {
						botonAsignarSaldo.setVisible(false);
						remove(botonAsignarSaldo);
					}
					JOptionPane.showConfirmDialog(null, "El monto de  $"+saldo+" fue recargado exitosamente", "Recarga exitoso", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
    }

	
}

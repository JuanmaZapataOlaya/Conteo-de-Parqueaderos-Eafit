import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPlaca extends JPanel{
	
    private JLabel labelCCTI;
    private JTextField textFieldCCTI;
    private JButton guardar;
    private String documento;

    public PanelPlaca() {
    	guardar = new JButton ("Guardar");
    	labelCCTI = new JLabel ("Ingrese su T.I. o C.C.");
    	setPreferredSize (new Dimension (752, 425));
        setLayout (null);
        textFieldCCTI = new JTextField (5);
		textFieldCCTI.setVisible(true);
		add (labelCCTI);
        add (textFieldCCTI);
        labelCCTI.setBounds (45, 130, 100, 25);
		textFieldCCTI.setBounds (110, 130, 100, 25);
		
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method 
				documento = textFieldCCTI.getText();
			}
		});
  
    }

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


//    public static void main (String[] args) {
//        JFrame frame = new JFrame ("ParqueaderoEafitPanel");
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add (new ParqueaderoEafit());
//        frame.pack();
//        frame.setVisible (true);
//    }
	
}

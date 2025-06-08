package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

public class AgregarPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	public JButton btnAceptar;	

	
	public AgregarPanel() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(82, 20, 49, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(82, 70, 49, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(82, 120, 49, 14);
		add(lblDni);
		
		btnAceptar = new JButton("Aceptar");		
		btnAceptar.setBounds(67, 170, 89, 23);
		add(btnAceptar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(198, 20, 110, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(198, 70, 110, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(198, 120, 110, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		//solo letras y espacios
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
					e.consume();
				}
			}
		});

		//solo letras
		txtApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
					e.consume();
				}
			}
		});

		//solo numeros para DNI
		txtDni.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}		
	
	
	public JButton getBtnAceptar() {
	    return btnAceptar;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	public JTextField getTxtApellido() {
		return txtApellido;
	}
	
	public JTextField getTxtDni() {
		return txtDni;
	}
	
}

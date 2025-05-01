package aplicacionDeEscritorio;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFecha;
	
	private JLabel lblNombreIng;
	private JLabel lblApellidoIng;
	private JLabel lblTelefonoIng;
	private JLabel lblFechaIng;
	
	public Ejercicio1(JFrame owner) {
		super(owner,"Contactos",true);
		
		setTitle("Contactos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 50, 450, 585);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(77, 50, 49, 25);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(177, 50, 200, 25);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(77, 118, 61, 25);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(71, 192, 67, 25);
		contentPane.add(lblTelefono);
		
		JLabel lblFecha = new JLabel("Fecha Nac.");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(71, 260, 67, 25);
		contentPane.add(lblFecha);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(177, 120, 200, 25);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(177, 190, 200, 25);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(177, 260, 200, 25);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);		
		
		JLabel lblMuestraIngreso = new JLabel("Los datos ingresados fueron :");
		lblMuestraIngreso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMuestraIngreso.setBounds(34, 389, 190, 25);
		contentPane.add(lblMuestraIngreso);
		
	    lblNombreIng = new JLabel("");
		lblNombreIng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreIng.setBounds(34, 425, 100, 25);
		contentPane.add(lblNombreIng);
		
	    lblApellidoIng = new JLabel("");
		lblApellidoIng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidoIng.setBounds(208, 436, 100, 25);
		contentPane.add(lblApellidoIng);
		
		lblTelefonoIng = new JLabel("");
		lblTelefonoIng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefonoIng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefonoIng.setBounds(34, 483, 100, 25);
		contentPane.add(lblTelefonoIng);
		
		lblFechaIng = new JLabel("");
		lblFechaIng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaIng.setBounds(208, 483, 100, 25);
		contentPane.add(lblFechaIng);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean camposValidos = true;
				
				try {
					
					if(txtNombre.getText().trim().isEmpty()) {					
						txtNombre.setBackground(Color.red);
						camposValidos = false;
					} else {
						txtNombre.setBackground(Color.WHITE);					
					}
					
					if(txtApellido.getText().trim().isEmpty()) {
						txtApellido.setBackground(Color.red);
						camposValidos = false;
					} else {
						txtApellido.setBackground(Color.WHITE);
					}
					
					if (txtTelefono.getText().trim().isEmpty()) {
						txtTelefono.setBackground(Color.red);
						camposValidos = false;
					} else {
						txtTelefono.setBackground(Color.WHITE);
					}
					
					if (txtFecha.getText().trim().isEmpty()) {
						txtFecha.setBackground(Color.red);
						camposValidos = false;
					} else {
						txtFecha.setBackground(Color.WHITE);
					}
									
					 if (!camposValidos) {
				            JOptionPane.showMessageDialog(null, "Por favor, completá todos los campos.");
				            vaciarCampos();
					 } else {
				    	 	lblNombreIng.setText(txtNombre.getText());
				    	 	lblApellidoIng.setText(txtApellido.getText());
							lblTelefonoIng.setText(txtTelefono.getText());
							lblFechaIng.setText(txtFecha.getText());
							
							txtNombre.setText("");
							txtApellido.setText("");
							txtTelefono.setText("");
							txtFecha.setText("");
				     }
					
				} catch (Exception e2) {
					
				}				
				
			}
		});
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMostrar.setBounds(252, 316, 140, 30);
		contentPane.add(btnMostrar);		
		
		JButton btnBorrar = new JButton("Limpiar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vaciarCampos();
					
				} catch (Exception e2) {
					System.out.println("Borrado de cajas");
				}
				
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrar.setBounds(44, 316, 140, 30);
		contentPane.add(btnBorrar);
	}
	
	public void vaciarCampos() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtFecha.setText("");
		
		lblNombreIng.setText("");
		lblApellidoIng.setText("");
		lblTelefonoIng.setText("");
		lblFechaIng.setText("");
		
		txtNombre.setBackground(Color.WHITE);
		txtApellido.setBackground(Color.WHITE);
		txtTelefono.setBackground(Color.WHITE);
		txtFecha.setBackground(Color.WHITE);	    
		
		txtNombre.requestFocus();
		
	}
}

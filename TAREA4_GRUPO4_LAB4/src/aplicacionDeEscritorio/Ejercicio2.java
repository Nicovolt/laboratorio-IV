package aplicacionDeEscritorio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtPromedio;
	private JTextField txtCondicion;
		
	public Ejercicio2(JFrame owner) {
		super(owner,"Promedio",true);
		setTitle("Promedio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 50, 590, 487);		
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		
		JPanel panel = new JPanel();		
		panel.setBorder(BorderFactory.createTitledBorder("Notas del estudiante"));
		panel.setBounds(39, 38, 305, 214);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNota1.setBounds(48, 40, 49, 14);
		panel.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNota2.setBounds(48, 80, 49, 14);
		panel.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNota3.setBounds(48, 120, 49, 14);
		panel.add(lblNota3);
		
		JLabel lblTps = new JLabel("TPs");
		lblTps.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTps.setBounds(48, 160, 49, 14);
		panel.add(lblTps);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(130, 40, 110, 20);
		panel.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(130, 80, 110, 20);
		panel.add(txtNota2);
		txtNota2.setColumns(10);
		
		txtNota3 = new JTextField();
		txtNota3.setBounds(130, 120, 110, 20);
		panel.add(txtNota3);
		txtNota3.setColumns(10);
		
		JComboBox cbxTp = new JComboBox();
		cbxTp.setModel(new DefaultComboBoxModel(new String[] {"Aprobado", "Desaprobado"}));
		cbxTp.setBounds(130, 160, 110, 22);
		panel.add(cbxTp);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Double numero = Double.parseDouble(txtNota1.getText());
					Double numero2 = Double.parseDouble(txtNota2.getText());
					Double numero3 = Double.parseDouble(txtNota3.getText());
					
					if(numero >= 0 && numero <= 10 &&
					   numero2 >= 0 && numero2 <= 10 &&
					   numero3 >= 0 && numero3 <= 10) {
						
						numero = Math.round(numero * 100.0) / 100.0;
						numero2 = Math.round(numero2 * 100.0) / 100.0;
						numero3 = Math.round(numero3 * 100.0) / 100.0;
						
						Double total = Math.round(((numero + numero2 + numero3)/3)* 100.0) / 100.0; 
						
						String tipo = (String) cbxTp.getSelectedItem();
						
						if(tipo.equals("Desaprobado") ||
						   numero < 6 || numero2 < 6 || numero3 < 6) {
							
							txtCondicion.setText("Libre");
							txtPromedio.setText(String.valueOf(total));
						} else if(tipo.equals("Aprobado") && total >= 8 &&
						   numero >= 8 && numero2 >= 8 && numero3 >= 8) {
							
							txtCondicion.setText("Promocionado");
							txtPromedio.setText(String.valueOf(total));
						} else {							
							txtCondicion.setText("Regular");
							txtPromedio.setText(String.valueOf(total));
						}
						
						
					} else {
						JOptionPane.showMessageDialog(null,"Debe ingresar un número entre 0 y 9");
					}					
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,"Ingrese un número valido con  punto decimal.");
				}
				
				
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalcular.setBounds(400, 110, 89, 25);
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNota1.setText("");
				txtNota2.setText("");
				txtNota3.setText("");
				txtPromedio.setText("");
				txtCondicion.setText("");
				
			}
		});
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevo.setBounds(400, 160, 89, 25);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose(); 
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.setBounds(400, 210, 89, 25);
		contentPane.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 291, 305, 122);
		panel_1.setBorder(BorderFactory.createTitledBorder("Notas del estudiante"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPromedio = new JLabel("Promedio");
		lblPromedio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPromedio.setBounds(53, 42, 75, 14);
		panel_1.add(lblPromedio);
		
		JLabel lblCondicion = new JLabel("Condicion");
		lblCondicion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCondicion.setBounds(53, 81, 75, 14);
		panel_1.add(lblCondicion);
		
		txtPromedio = new JTextField();
		txtPromedio.setBounds(151, 39, 96, 20);
		panel_1.add(txtPromedio);
		txtPromedio.setColumns(10);
		
		txtCondicion = new JTextField();
		txtCondicion.setBounds(151, 78, 96, 20);
		panel_1.add(txtCondicion);
		txtCondicion.setColumns(10);
	}
}

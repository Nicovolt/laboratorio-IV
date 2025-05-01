package aplicacionDeEscritorio;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JTextField txtHoras;

	public Ejercicio3(JFrame owner) {
		super(owner,"Seleccion multiple",true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 100, 525, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 22, 463, 77);
		panel_1.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblsistOper = new JLabel("Elige un sistema operativo.");
		lblsistOper.setBounds(25, 30, 177, 20);
		panel_1.add(lblsistOper);
		
		JRadioButton rbtWindows = new JRadioButton("Windows");
		rbtWindows.setBounds(208, 29, 82, 23);
		panel_1.add(rbtWindows);
		
		JRadioButton rbtMac = new JRadioButton("Mac");
		rbtMac.setBounds(306, 29, 67, 23);
		panel_1.add(rbtMac);
		
		JRadioButton rbtLinux = new JRadioButton("Linux");
		rbtLinux.setBounds(375, 29, 59, 23);
		panel_1.add(rbtLinux);
		
		ButtonGroup grupoSO = new ButtonGroup();
		grupoSO.add(rbtWindows);
		grupoSO.add(rbtMac);
		grupoSO.add(rbtLinux);
		rbtWindows.setSelected(true);
		
		
		JPanel panel = new JPanel();		
		panel.setBounds(262, 10, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 129, 463, 136);
		panel_2.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEspecialidad = new JLabel("Elige una especialidad");
		lblEspecialidad.setBounds(25, 56, 187, 23);
		panel_2.add(lblEspecialidad);
		
		JCheckBox chbProgramacion = new JCheckBox("Programación");
		chbProgramacion.setBounds(255, 20, 126, 23);
		panel_2.add(chbProgramacion);
		
		JCheckBox chbAdministracion = new JCheckBox("Administración");
		chbAdministracion.setBounds(255, 56, 126, 23);
		panel_2.add(chbAdministracion);
		
		JCheckBox chbDiseno = new JCheckBox("Diseño Gráfico");
		chbDiseno.setBounds(255, 92, 126, 23);
		panel_2.add(chbDiseno);
		
		JLabel lblHoras = new JLabel("Cantidad de horas en el computador:");
		lblHoras.setBounds(59, 288, 228, 24);
		contentPane.add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(327, 288, 96, 24);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String soSeleccionado = "";

				if (rbtWindows.isSelected()) {
				    soSeleccionado = "Windows";
				} else if (rbtMac.isSelected()) {
				    soSeleccionado = "Mac";
				} else if (rbtLinux.isSelected()) {
				    soSeleccionado = "Linux";
				}
				
				String seleccionados = "";

				if (chbProgramacion.isSelected()) {
				    seleccionados += "- Programación ";
				}
				if (chbAdministracion.isSelected()) {
				    seleccionados += "- Administración ";
				}
				if (chbDiseno.isSelected()) {
				    seleccionados += "- Diseño Gráfico ";
				}		
				
				String horasString = txtHoras.getText();
				String horas = "0";
				
				try {
					Integer.parseInt(horasString);
					horas = horasString;
					
				} catch (NumberFormatException e2) {
					UIManager.put("OptionPane.okButtonText", "Aceptar");
					JOptionPane.showMessageDialog(null,"Ingrese numeros en el campo horas.");
					txtHoras.setText("");
					return;
				}					
				
				UIManager.put("OptionPane.okButtonText", "Aceptar");
				JOptionPane.showMessageDialog(null,soSeleccionado +" "+ seleccionados +" - "+ horas + " hs.");
			}
		});
		btnAceptar.setBounds(334, 349, 89, 24);
		contentPane.add(btnAceptar);
	}
}

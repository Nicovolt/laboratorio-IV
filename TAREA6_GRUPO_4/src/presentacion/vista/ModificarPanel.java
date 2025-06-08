package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;

import entidad.Personas;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ModificarPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;
	private JList<Personas> list;
	private DefaultListModel<Personas> model;

	public void setModel(DefaultListModel<Personas> model) {
		this.model = model;
		list.setModel(model);
	}

	public ModificarPanel() {
		setLayout(null);

		list = new JList<Personas>();
		list.setBounds(45, 48, 390, 143);
		add(list);

		txtNombre = new JTextField();
		txtNombre.setBounds(30, 206, 100, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(136, 206, 100, 20);
		add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(242, 206, 100, 20);
		add(txtDni);
		txtDni.setColumns(10);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(348, 205, 100, 23);
		add(btnModificar);

		JLabel lblTitulo = new JLabel("Seleccione  le persona que desea modificar");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(45, 23, 279, 14);
		add(lblTitulo);

		// solo letras y espacios
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
					e.consume();
				}
			}
		});

		// solo letras
		txtApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
					e.consume();
				}
			}
		});

		// solo numeros para DNI
		txtDni.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});

	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JList<Personas> getListaPersonas() {
		return list;
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

package presentacion.vista;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import entidad.Personas;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class EliminarPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<Personas> list;
	private DefaultListModel<Personas> model;
	private JButton btnEliminar;
	
	public void setModel(DefaultListModel<Personas> model) {
		this.model = model;
		list.setModel(model);
	}
	
	public EliminarPanel() {
		setLayout(null);
		
		list = new JList<Personas>();
		list.setBounds(45, 48, 390, 143);
		add(list);
		
		JLabel lblTitulo = new JLabel("Eliminar usuarios");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(45, 22, 104, 15);
		add(lblTitulo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(200, 202, 90, 23);
		add(btnEliminar);
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	public JList<Personas> getListaPersonas() {
	    return list;
	}
	
	

}

package ventanas;

import javax.swing.JPanel;

import diagramaClases.Peliculas;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelListar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList list;
	private DefaultListModel<Peliculas> model;
	
	
	public DefaultListModel<Peliculas> getModel() {
		return model;
	}


	public void setModel(DefaultListModel<Peliculas> model) {
		this.model = model;
		list.setModel(model);
	}


	public PanelListar() {
		setLayout(null);
		
		list = new JList();		
		list.setBounds(163, 68, 362, 240);
		add(list);	
		
		JLabel lblPelicula = new JLabel("Peliculas");
		lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPelicula.setBounds(60, 180, 66, 27);
		add(lblPelicula);

	}
}

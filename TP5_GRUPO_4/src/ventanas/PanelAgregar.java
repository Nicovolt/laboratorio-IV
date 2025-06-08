package ventanas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import diagramaClases.Categorias;
import diagramaClases.Peliculas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class PanelAgregar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private DefaultListModel<Peliculas> listModel;
	private Set<Peliculas> listPeliOrdenada = Ventana.getListOrdenada();
	
	public DefaultListModel<Peliculas> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<Peliculas> listModel) {
		this.listModel = listModel;
	}

	public PanelAgregar() {
		setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(277, 130, 137, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(174, 80, 49, 14);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(174, 130, 61, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNombre);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(174, 180, 49, 14);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblGenero);
		
		JLabel lblIdNumero = new JLabel(String.valueOf(Peliculas.getContId()));		
		lblIdNumero.setBounds(277, 80, 49, 20);
		add(lblIdNumero);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(277, 180, 137, 22);
		comboBox.addItem("Seleccione un genero");
		comboBox.addItem("Terror");
		comboBox.addItem("Acción");
		comboBox.addItem("Suspenso");
		comboBox.addItem("Romantica");
		add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(159, 230, 89, 23);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtNombre.getText().trim().isEmpty() &&
					comboBox.getSelectedItem().toString() != "Seleccione un genero") {
					Peliculas pelicula = new Peliculas();
					Categorias categoria = new Categorias();					
					
					pelicula.setNombre(txtNombre.getText());
					categoria.setGenero(comboBox.getSelectedItem().toString());
					pelicula.setCategoria(categoria);
					
					listPeliOrdenada.add(pelicula);
					
					listModel.clear();
					
					for(Peliculas peli : listPeliOrdenada ) {
						listModel.addElement(peli);
					}					
					
					Ventana.setListModel(listModel);
					
					lblIdNumero.setText(String.valueOf(Peliculas.getContId()));
					txtNombre.setText("");
					comboBox.setSelectedIndex(0);
					
				} else {
					if(comboBox.getSelectedItem().toString() == "Seleccione un genero") {
						JOptionPane.showMessageDialog(null, "Ingrega un genero");
					} else {
						JOptionPane.showMessageDialog(null, "Ingrega un Nombre.");
					}
				}
			}
		});
		add(btnAceptar);
	}
}

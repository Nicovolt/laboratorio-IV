package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ListarPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	
		
	public ListarPanel(DefaultTableModel model) {
		
		this.model = model;
		 String[] columnas = { "DNI", "Nombre", "Apellido" };		 
	        
	    model = new DefaultTableModel(columnas, 0);
	    table = new JTable(this.model);   		
		
		table.setBounds(45, 48, 390, 143);
		add(table);
		
		scrollPane = new JScrollPane(table);
        scrollPane.setBounds(45, 48, 390, 100);
        add(scrollPane);

	}
}

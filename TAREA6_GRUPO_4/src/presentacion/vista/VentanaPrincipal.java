package presentacion.vista;

import java.awt.BorderLayout;


import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Personas;
import negocioImpl.NegocioPersonaImpl;
import presentacion.controlador.AgregarControlador;
import presentacion.controlador.EliminarControlador;
import presentacion.controlador.ListarControlador;
import presentacion.controlador.ModificarControlador;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem mnItemAgregar;
	private JMenuItem mnItemModificar;
	private JMenuItem mnItemEliminar;
	private JMenuItem mnItemListar;
	private NegocioPersonaImpl negocioPersona;
	private static DefaultListModel<Personas> listaModelo;	
	private static List<Personas> listPersonas = new ArrayList<>();
	private AgregarPanel agregarPanel;
	private ModificarPanel modificarPanel;
	private EliminarPanel eliminarPanel;
	private ListarPanel listarPanel;
	
	private static DefaultTableModel tablaModelo;	
	
	
	public static DefaultTableModel getTablaModelo() {
		return tablaModelo;
	}

	public static void setTablaModelo(DefaultTableModel tablaModelo) {
		VentanaPrincipal.tablaModelo = tablaModelo;
	}

	public static List<Personas> getListOrdenada() {
		return listPersonas;
	}	
	
	public static DefaultListModel<Personas> getListaModelo() {
		return listaModelo;
	}


	public static void setListaModelo(DefaultListModel<Personas> listModel) {
		VentanaPrincipal.listaModelo = listModel;
	}
	
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		listaModelo = new DefaultListModel<Personas>();
		negocioPersona = new NegocioPersonaImpl();
		listPersonas = negocioPersona.readAllPersona();
		
		
		for(Personas persona : listPersonas) {
			listaModelo.addElement(persona);
		}
		
		VentanaPrincipal.setListaModelo(listaModelo);
		
		String[] columnas = { "DNI", "Nombre", "Apellido" };
        tablaModelo = new DefaultTableModel(columnas, 0); 
		
        for (Personas p : listPersonas) {
	        Object[] fila = { p.getDni(), p.getNombre(), p.getApellido() };
	        tablaModelo.addRow(fila);
	    }
        
        VentanaPrincipal.setTablaModelo(tablaModelo);		
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		mnItemAgregar = new JMenuItem("Agregar");
		mnItemAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				agregarPanel = new AgregarPanel();
				new AgregarControlador(agregarPanel, negocioPersona);
				contentPane.add(agregarPanel,  BorderLayout.CENTER);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnPersona.add(mnItemAgregar);
		
		mnItemModificar = new JMenuItem("Modificar");
		mnItemModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				VentanaPrincipal.actualizarModelo();
				modificarPanel = new ModificarPanel();
				modificarPanel.setModel(listaModelo);
				new ModificarControlador(modificarPanel, negocioPersona);
				contentPane.add(modificarPanel, BorderLayout.CENTER);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPersona.add(mnItemModificar);
		
		mnItemEliminar = new JMenuItem("Eliminar");
		mnItemEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				VentanaPrincipal.actualizarModelo();
				eliminarPanel = new EliminarPanel();
				eliminarPanel.setModel(listaModelo);
				new EliminarControlador(eliminarPanel, negocioPersona);
				contentPane.add(eliminarPanel, BorderLayout.CENTER);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPersona.add(mnItemEliminar);
		
		mnItemListar = new JMenuItem("Listar");
		mnItemListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				VentanaPrincipal.actualizarModelo();
				listarPanel = new ListarPanel(tablaModelo);				
				new ListarControlador(listarPanel, negocioPersona);
				contentPane.add(listarPanel, BorderLayout.CENTER);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnPersona.add(mnItemListar);		
	}
	
	public static void actualizarModelo() {
	    listPersonas = new NegocioPersonaImpl().readAllPersona();
	    listaModelo.clear();
	    tablaModelo.setRowCount(0);
	    
	    for (Personas p : listPersonas) {
	        listaModelo.addElement(p);
	        Object[] fila = { p.getDni(), p.getNombre(), p.getApellido() };
			tablaModelo.addRow(fila);
	    }
	}
	
	public void setPanels(AgregarPanel agregarPanel, ModificarPanel modificarPanel,
				EliminarPanel eliminarPanel, ListarPanel listarPanel ) {
		this.agregarPanel = agregarPanel;
		this.modificarPanel = modificarPanel;
		this.eliminarPanel = eliminarPanel;
		this.listarPanel = listarPanel;

		mnItemAgregar.addActionListener(e -> {
			contentPane.removeAll();
			
			agregarPanel.getTxtDni().setText("");
			agregarPanel.getTxtNombre().setText("");
			agregarPanel.getTxtApellido().setText("");

			contentPane.add(agregarPanel, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		});

		mnItemModificar.addActionListener(e -> {
			contentPane.removeAll();
			contentPane.add(modificarPanel, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		});
		
		mnItemEliminar.addActionListener(e -> {
			contentPane.removeAll();
			contentPane.add(eliminarPanel, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		});
		
		mnItemListar.addActionListener(e -> {
			contentPane.removeAll();
			contentPane.add(listarPanel, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		});	
	}
}



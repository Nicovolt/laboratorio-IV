package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import diagramaClases.Peliculas;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JMenuItem mnItemAgregar; 
	private JMenuBar menuBar;
	private JMenu mnPeliculas;
	private static DefaultListModel<Peliculas> listModel;
	
	private static Set<Peliculas> listPeliOrdenada = new TreeSet<>();
	
	public static Set<Peliculas> getListOrdenada() {
		return listPeliOrdenada;
	}
	
	
	public static DefaultListModel<Peliculas> getListModel() {
		return listModel;
	}


	public static void setListModel(DefaultListModel<Peliculas> listModel) {
		Ventana.listModel = listModel;
	}
	
	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		listModel = new DefaultListModel<Peliculas>();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		
		mnPeliculas = new JMenu("Peliculas");
		menuBar.add(mnPeliculas);
		
		 
		contentPane.setLayout(new BorderLayout()); 
				
		mnItemAgregar = new JMenuItem("Agregar");
		mnItemAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				PanelAgregar panelAgregar = new PanelAgregar();
				panelAgregar.setListModel(listModel);
			    contentPane.add(panelAgregar, BorderLayout.CENTER);								
				contentPane.repaint();
				contentPane.revalidate();				
			}
		});
		mnItemAgregar.setBounds(48, 134, 135, 26);
		mnPeliculas.add(mnItemAgregar);	
		
		JMenuItem mnItemListar = new JMenuItem("Listar");
		mnItemListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				PanelListar panelAgregar = new PanelListar();
				panelAgregar.setModel(listModel);
			    contentPane.add(panelAgregar, BorderLayout.CENTER);								
				contentPane.repaint();
				contentPane.revalidate();				
			}
		});
		mnItemListar.setBounds(48, 160, 135, 26);
		mnPeliculas.add(mnItemListar);	
		
	
	}
}

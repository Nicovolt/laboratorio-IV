package main;

import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;

import negocioImpl.NegocioPersonaImpl;
import presentacion.controlador.AgregarControlador;
import presentacion.controlador.ModificarControlador;
import presentacion.vista.AgregarPanel;
import presentacion.vista.EliminarPanel;
import presentacion.vista.ListarPanel;
import presentacion.vista.ModificarPanel;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					
					String[] columnas = { "DNI", "Nombre", "Apellido" };
					DefaultTableModel tablaModelo = new DefaultTableModel(columnas, 0);
					
					NegocioPersonaImpl negocio = new NegocioPersonaImpl();
					AgregarPanel agregarPanel = new AgregarPanel();
					ModificarPanel modificarPanel = new ModificarPanel();
					EliminarPanel eliminarPanel = new EliminarPanel();
					ListarPanel listarPanel = new ListarPanel(tablaModelo);
					
					AgregarControlador agregarControlador = new AgregarControlador(agregarPanel,negocio);
										
					ModificarControlador modificarControlador = new ModificarControlador(modificarPanel,negocio);
										
					frame.setPanels(agregarPanel, modificarPanel, eliminarPanel,listarPanel); 
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	

	}

}

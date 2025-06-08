package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Personas;
import negocioImpl.NegocioPersonaImpl;
import presentacion.vista.EliminarPanel;

public class EliminarControlador implements ActionListener {

	private EliminarPanel eliminarPanel;
	private NegocioPersonaImpl negocioPersona;
	private Personas personaSeleccionada;

	public EliminarControlador(EliminarPanel eliminarPanel, NegocioPersonaImpl negocioPersona) {
		
		this.eliminarPanel = eliminarPanel;
		this.negocioPersona = negocioPersona;
	    this.eliminarPanel.getBtnEliminar().addActionListener(a->panelEliminarPersona(a));
		
		eliminarPanel.getListaPersonas().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				 if (!e.getValueIsAdjusting()) {
			          
					 personaSeleccionada = eliminarPanel.getListaPersonas().getSelectedValue();
			          		
				 }	
			}
		});
		
	}

	public void panelEliminarPersona(ActionEvent a) {
		if (personaSeleccionada != null) {
				
			negocioPersona.deletePersona(personaSeleccionada);
			
			DefaultListModel<Personas> model = (DefaultListModel<Personas>) eliminarPanel.getListaPersonas().getModel();
			model.removeElement(personaSeleccionada);
		
			eliminarPanel.getListaPersonas().repaint();		

			JOptionPane.showMessageDialog(null, "Persona eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

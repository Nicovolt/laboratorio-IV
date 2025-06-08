package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entidad.Personas;
import negocioImpl.NegocioPersonaImpl;
import presentacion.vista.AgregarPanel;


public class AgregarControlador implements ActionListener {

	private AgregarPanel agregarPanel;
	private NegocioPersonaImpl negocioPersona;	
	
	
	public AgregarControlador(AgregarPanel agregarPanel, NegocioPersonaImpl negocioPersona) {
		
		this.agregarPanel = agregarPanel;
		this.negocioPersona = negocioPersona;
		this.agregarPanel.getBtnAceptar().addActionListener(a->panelAgregarPersona(a));
	}
	
	
	public void panelAgregarPersona(ActionEvent a) {
	    String dni = this.agregarPanel.getTxtDni().getText().trim();
	    String nombre = this.agregarPanel.getTxtNombre().getText().trim();
	    String apellido = this.agregarPanel.getTxtApellido().getText().trim();
	   
	    if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No se puede cargar con los campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	 	 

	    Personas persona = new Personas();
	    persona.setDni(dni);
	    persona.setNombre(nombre);
	    persona.setApellido(apellido);	    
	    
	    int resultado = negocioPersona.insertPersona(persona);		
	    
	    if (resultado == 0) {
	        JOptionPane.showMessageDialog(null, "Ya existe una persona con ese DNI.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }	    
	
	    if (resultado > 0) {
	        JOptionPane.showMessageDialog(null, "¡Cargado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        
	        agregarPanel.getTxtDni().setText("");
	        agregarPanel.getTxtNombre().setText("");
	        agregarPanel.getTxtApellido().setText("");
	    } else {
	        JOptionPane.showMessageDialog(null, "Hubo un problema al guardar.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	@Override
	public void actionPerformed(ActionEvent e) {		
		
	}

}

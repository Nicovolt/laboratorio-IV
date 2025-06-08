package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Personas;
import negocioImpl.NegocioPersonaImpl;
import presentacion.vista.ModificarPanel;

public class ModificarControlador implements ActionListener {

	
	private ModificarPanel modificarPanel;
	private NegocioPersonaImpl negocioPersona;
	private Personas personaSeleccionada;
	
    public ModificarControlador(ModificarPanel modificarPanel, NegocioPersonaImpl negocioPersona) {
		
		this.modificarPanel = modificarPanel;
		this.negocioPersona = negocioPersona;
		this.modificarPanel.getTxtDni().setEditable(false);
		this.modificarPanel.getBtnModificar().addActionListener(a->panelModificarPersona(a));
	
		modificarPanel.getListaPersonas().addListSelectionListener(new ListSelectionListener() {
            			
			 @Override
			    public void valueChanged(ListSelectionEvent e) {
			        if (!e.getValueIsAdjusting()) {
			            personaSeleccionada = modificarPanel.getListaPersonas().getSelectedValue();
			            if (personaSeleccionada != null) {
			                modificarPanel.getTxtNombre().setText(personaSeleccionada.getNombre());
			                modificarPanel.getTxtApellido().setText(personaSeleccionada.getApellido());
			                modificarPanel.getTxtDni().setText(personaSeleccionada.getDni());
			            }
			        }
			    }
			});		
    
    }
    
    public void panelModificarPersona(ActionEvent a) {
    	if (personaSeleccionada != null) {            
            String nuevoNombre = modificarPanel.getTxtNombre().getText();
            String nuevoApellido = modificarPanel.getTxtApellido().getText();
            String nuevoDni = modificarPanel.getTxtDni().getText();
            
            if (nuevoNombre.isEmpty() || nuevoApellido.isEmpty() || nuevoDni.isEmpty()) {
                System.out.println("Todos los campos deben estar completos.");
                return;
            }
           
            personaSeleccionada.setNombre(nuevoNombre);
            personaSeleccionada.setApellido(nuevoApellido);
            personaSeleccionada.setDni(nuevoDni);
            
            negocioPersona.updatePersona(personaSeleccionada);
           
            modificarPanel.getListaPersonas().repaint();
            
            modificarPanel.getTxtNombre().setText("");
            modificarPanel.getTxtApellido().setText("");
            modificarPanel.getTxtDni().setText("");

            System.out.println("Persona modificada correctamente.");
        }
    	
    }	
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		
	}

}

package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocioImpl.NegocioPersonaImpl;
import presentacion.vista.ListarPanel;

public class ListarControlador implements ActionListener{

	private ListarPanel listarPanel;
	private NegocioPersonaImpl negocioPersona;
	
	
	public ListarControlador(ListarPanel listarPanel, NegocioPersonaImpl negocioPersona) {
		
		this.listarPanel = listarPanel;
		this.negocioPersona = negocioPersona;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}

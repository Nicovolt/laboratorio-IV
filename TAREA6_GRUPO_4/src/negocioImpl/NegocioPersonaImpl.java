package negocioImpl;

import java.util.List;

import daoImpl.PersonaDaoImpl;
import entidad.Personas;
import negocio.NegocioPersona;

public class NegocioPersonaImpl implements NegocioPersona {

	private PersonaDaoImpl personaDaoImpl;
	
	public NegocioPersonaImpl() {
	      this.personaDaoImpl = new PersonaDaoImpl(); 
    }
	
	@Override
	public int insertPersona(Personas persona) {
		
		int fila = personaDaoImpl.insertPersona(persona);
		
		return fila;
	}

	@Override
	public int deletePersona(Personas persona) {
		
		int fila = personaDaoImpl.deletePersona(persona);
		
		return fila;
	}

	@Override
	public int updatePersona(Personas persona) {

		int fila = personaDaoImpl.updatePersona(persona);
		
		return fila;
	}

	@Override
	public List<Personas> readAllPersona() {
		
		List<Personas> listaPersona = personaDaoImpl.readAllPersona();
		
		return listaPersona;
	}

}

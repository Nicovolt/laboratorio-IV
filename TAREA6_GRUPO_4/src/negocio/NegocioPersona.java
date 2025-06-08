package negocio;

import java.util.List;

import entidad.Personas;

public interface NegocioPersona {
	
    public int insertPersona(Personas persona);
	
	public int deletePersona(Personas persona);
	
	public int updatePersona(Personas persona);
	
	public List<Personas> readAllPersona();

}

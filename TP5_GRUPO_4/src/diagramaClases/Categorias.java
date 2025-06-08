package diagramaClases;

public class Categorias {
	
	private String genero;

	public Categorias() {
		
	}

	public Categorias(String genero) {		
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return  genero;
	}
	
	

}

package diagramaClases;

public class Peliculas implements Comparable<Peliculas>{
	
	private final int id;
	private String nombre;
	private Categorias categoria;
    public static int contId = 1;
	
	public Peliculas() {
		super();
		this.id = contId;
		contId++;
	}

	public Peliculas(String nombre, Categorias categoria) {
		super();
		this.id = contId;
		this.nombre = nombre;
		this.categoria = categoria;
		contId ++;
	}
	
	@Override
	public int compareTo(Peliculas o) {			
		return this.getNombre().compareTo(o.getNombre());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public static int getContId() {
		return contId;
	}	

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return  id + "     " + nombre + "     " + categoria.getGenero();
	}
	
	

}

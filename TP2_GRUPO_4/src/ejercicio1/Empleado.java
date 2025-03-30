package ejercicio1;

public class Empleado {
	
	private final int id;
	private String nombre;
	private int edad;	
	static int contId = 1000;
	
	public Empleado() {				
		this.id = contId;		
		this.nombre = "sin nombre";
		this.edad = 99;
		contId++;
	}
	
	public Empleado(String nombre, int edad) {				
		this.id = contId;
		this.nombre = nombre;
		this.edad = edad;
		contId++;
	}
	
	
	public int getId() {
		return id;
	}	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public static int devuelveProximoID() {
		return contId;
	}

	@Override
	public String toString() {
		return "Empleado ID= " + id + ", nombre= " + nombre + ", edad= " + edad;
	}	

}

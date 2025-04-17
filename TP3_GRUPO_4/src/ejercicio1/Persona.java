package ejercicio1;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private String apellido;
	private String dni;

	public Persona(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return apellido + " " + nombre + " - DNI: " + dni;
	}

	@Override
	public int compareTo(Persona o) {
		int resultadoApellido = this.apellido.compareTo(o.getApellido());

		if (resultadoApellido == 0) {

			int resultadoNombre = this.nombre.compareTo(o.getNombre());

			if (resultadoNombre == 0) {
				return this.dni.compareTo(o.getDni());
			}

			return resultadoNombre;
		}
		return resultadoApellido;
	}
}

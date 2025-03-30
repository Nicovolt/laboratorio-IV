package ejercicio1;

public class Profesor extends Empleado{
	
	private String cargo;
	private int antiguedadDocente;
	
	public Profesor() {
		super();
		this.cargo = "ninguno";
		this.antiguedadDocente = 0;
	}
	public Profesor(String nombre, int edad, String cargo, int antiguedadDocente) {
		super(nombre, edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getAntiguedadDocente() {
		return antiguedadDocente;
	}
	public void setAntiguedadDocente(int antiguedadDocente) {
		this.antiguedadDocente = antiguedadDocente;
	}
	@Override
	public String toString() {
		return "Profesor ID= " + super.getId() + " Nombre= " 
				+ super.getNombre() + " Edad= " + super.getEdad() +
				" Cargo= " + cargo + " AntiguedadDocente= " + antiguedadDocente;
	}
	
	

}

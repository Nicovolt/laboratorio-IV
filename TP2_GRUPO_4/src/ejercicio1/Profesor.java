package ejercicio1;

import java.util.Objects;

public class Profesor extends Empleado implements Comparable<Profesor>{
	
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
	@Override
	public int hashCode() {
		return Objects.hash(antiguedadDocente, cargo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return antiguedadDocente == other.antiguedadDocente && Objects.equals(cargo, other.cargo);
	}
	@Override
	public int compareTo(Profesor o) {
		
		if(o.getEdad() == this.getEdad()) return 0;
		if(o.getEdad() < this.getEdad()) return 1;		
		return -1;
	}
	
	

}

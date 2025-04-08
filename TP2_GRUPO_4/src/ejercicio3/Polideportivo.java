package ejercicio3;

public class Polideportivo implements IInstalacionDeportiva, IEdificio{

	private String nombre;
	private double superficieEdificio;	
	private int tipoDeInstalacion;	
	
	public Polideportivo(double superficieEdificio, int tipoDeInstalacion, String nombre) {
		this.nombre = nombre;
		this.superficieEdificio = superficieEdificio;
		this.tipoDeInstalacion = tipoDeInstalacion;
	}

	@Override
	public double getSuperficieEdificio() {		
		return superficieEdificio;
	}

	@Override
	public int getTipoDeInstalacion() {		
		return tipoDeInstalacion;
	}

	@Override
	public String toString() {
		return "Polideportivo: Nombre= " + this.getNombre() +
				". Superficie del Edificio= " 
				+ this.getSuperficieEdificio() + ". Tipo De Instalacion= "
				+ this.getTipoDeInstalacion();
	}

	public void setSuperficieEdificio(double superficieEdificio) {
		this.superficieEdificio = superficieEdificio;
	}

	public void setTipoDeInstalacion(int tipoDeInstalacion) {
		this.tipoDeInstalacion = tipoDeInstalacion;
	}	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

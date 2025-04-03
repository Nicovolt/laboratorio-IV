package ejercicio3;

public class Polideportivo implements IInstalacionDeportiva, IEdificio{

	private double superficieEdificio;	
	private int tipoDeInstalacion;	
	
	public Polideportivo(double superficieEdificio, int tipoDeInstalacion) {
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
		return "Polideportivo: Superficie del Edificio= " 
				+ superficieEdificio + ". Tipo De Instalacion= "
				+ tipoDeInstalacion;
	}

	public void setSuperficieEdificio(double superficieEdificio) {
		this.superficieEdificio = superficieEdificio;
	}

	public void setTipoDeInstalacion(int tipoDeInstalacion) {
		this.tipoDeInstalacion = tipoDeInstalacion;
	}	

}

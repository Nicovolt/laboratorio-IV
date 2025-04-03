package ejercicio3;

public class Oficinas implements IEdificio{

	private int numeroOficinas;
	private double superficieEdificio;
	
	public Oficinas() {		
	}
	
	public Oficinas(int numeroOficinas, double superficieEdificio) {
		this.numeroOficinas = numeroOficinas;
		this.superficieEdificio = superficieEdificio;
	}

	public int getNumeroOficinas() {
		return numeroOficinas;
	}

	public void setNumeroOficinas(int numeroOficinas) {
		this.numeroOficinas = numeroOficinas;
	}

	@Override
	public double getSuperficieEdificio() {		
		return superficieEdificio;
	}

	public void setSuperficieEdificio(double superficieEdificio) {
		this.superficieEdificio = superficieEdificio;
	}

	@Override
	public String toString() {
		return "Oficinas: Numero de Oficinas= " 
				+ numeroOficinas + ". Superficie del Edificio= "
				+ superficieEdificio;
	}	

}

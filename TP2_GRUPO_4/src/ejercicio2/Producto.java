package ejercicio2;

public class Producto {
	 
	private String fechaCaducidad;
	private int numeroLote;
	
	public Producto() {		
	}

	public Producto(String fechaCaducidad, int numeroLote) {		
		this.fechaCaducidad = fechaCaducidad;
		this.numeroLote = numeroLote;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}
	
	
	
	
	
	
}

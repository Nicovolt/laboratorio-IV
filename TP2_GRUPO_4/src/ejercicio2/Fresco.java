package ejercicio2;

public class Fresco extends Producto{
	
	 private String fechaEnvasado;
	 private String paisOrigen;
	
	 public Fresco() {
		super();		
	}
	 
	public Fresco(String fechaCaducidad, int numeroLote, String fechaEnvasado, String paisOrigen) {
		super(fechaCaducidad, numeroLote);
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}

	public String getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		return "Producto Fresco: fechaEnvasado= " + fechaEnvasado +
				". paisOrigen= " + paisOrigen + ". Fecha caducidad= " 
				+ super.getFechaCaducidad() + ". Numero de lote= "
				+ super.getNumeroLote();
	}

	
	
	

}

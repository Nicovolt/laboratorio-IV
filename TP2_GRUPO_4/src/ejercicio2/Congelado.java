package ejercicio2;

public class Congelado extends Producto{
	
	private float tempCongelacionRecomendada;
	
	public Congelado() {
		super();
	}

	public Congelado(String fechaCaducidad, int numeroLote, float tempCongelacionRecomendada) {
		super(fechaCaducidad, numeroLote);
		this.tempCongelacionRecomendada = tempCongelacionRecomendada;
	}

	public float getTempCongelacionRecomendada() {
		return tempCongelacionRecomendada;
	}

	public void setTempCongelacionRecomendada(float tempCongelacionRecomendada) {
		this.tempCongelacionRecomendada = tempCongelacionRecomendada;
	}

	@Override
	public String toString() {
		return "Producto Congelado: Temperatura de Congelacion Recomendada= "
				+ tempCongelacionRecomendada + ". Fecha de caducidad= "
				+ super.getFechaCaducidad() + ". Numero de lote= "
				+ super.getNumeroLote();
	}
	
	
	

}

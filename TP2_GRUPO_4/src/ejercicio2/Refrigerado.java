package ejercicio2;

public class Refrigerado extends Producto{
	
	private int codSupervisionAlimentaria;

	public Refrigerado() {
		super();
	}		

	public Refrigerado(String fechaCaducidad, int numeroLote, int codSupervisionAlimentaria) {
		super(fechaCaducidad, numeroLote);
		this.codSupervisionAlimentaria = codSupervisionAlimentaria;
	}

	public int getCodSupervisionAlimentaria() {
		return codSupervisionAlimentaria;
	}

	public void setCodSupervisionAlimentaria(int codSupervisionAlimentaria) {
		this.codSupervisionAlimentaria = codSupervisionAlimentaria;
	}

	@Override
	public String toString() {
		return "Producto Refrigerado: codigo de Supervision Alimentaria= "
				+ codSupervisionAlimentaria + 
				". Fecha de caducidad= " + super.getFechaCaducidad() +
				". Numero de lote= " + super.getNumeroLote();
	}		
	
}

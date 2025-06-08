package dominio;

import java.math.BigDecimal;

public class Seguros {	
	
	private int idSeguro;
	private String descripcion;
	private int idTipo;
	private String descripcionTipo;
	private BigDecimal costoContratacion;
	private BigDecimal costoAsegurado;
	
	public Seguros() {		
	}	
	
	public Seguros(int idSeguro, String descripcion, int idTipo, BigDecimal costoContratacion, BigDecimal costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.idTipo = idTipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public BigDecimal getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(BigDecimal costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public BigDecimal getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(BigDecimal costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

	@Override
	public String toString() {
		return  idSeguro + " " + descripcion + " " + idTipo
				+ costoContratacion + " " + costoAsegurado;
	}
	
	
	

}

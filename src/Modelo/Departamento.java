package Modelo;

public class Departamento {
	private String nombreDpto;
	private int numeroDpto;
	private String dniDirector;
	private String fechaIngresoDirector;
	public Departamento(String nombreDpto, int numeroDpto, String dniDirector, String fechaIngresoDirector) {
		super();
		this.nombreDpto = nombreDpto;
		this.numeroDpto = numeroDpto;
		this.dniDirector = dniDirector;
		this.fechaIngresoDirector = fechaIngresoDirector;
	}
	public String getNombreDpto() {
		return nombreDpto;
	}
	public void setNombreDpto(String nombreDpto) {
		this.nombreDpto = nombreDpto;
	}
	public int getNumeroDpto() {
		return numeroDpto;
	}
	public void setNumeroDpto(int numeroDpto) {
		this.numeroDpto = numeroDpto;
	}
	public String getDniDirector() {
		return dniDirector;
	}
	public void setDniDirector(String dniDirector) {
		this.dniDirector = dniDirector;
	}
	public String getFechaIngresoDirector() {
		return fechaIngresoDirector;
	}
	public void setFechaIngresoDirector(String fechaIngresoDirector) {
		this.fechaIngresoDirector = fechaIngresoDirector;
	}
	@Override
	public String toString() {
		return "Departamento [nombreDpto=" + nombreDpto + ", numeroDpto=" + numeroDpto + ", dniDirector=" + dniDirector
				+ ", fechaIngresoDirector=" + fechaIngresoDirector + "]";
	}
	
	

}

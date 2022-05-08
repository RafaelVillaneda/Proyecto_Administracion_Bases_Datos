package Modelo;

public class Localizaciones_Dpto {
	private int numeroDpto;
	private String localizacionDpto;
	public Localizaciones_Dpto(int numeroDpto, String localizacionDpto) {
		super();
		this.numeroDpto = numeroDpto;
		this.localizacionDpto = localizacionDpto;
	}
	public int getNumeroDpto() {
		return numeroDpto;
	}
	public void setNumeroDpto(int numeroDpto) {
		this.numeroDpto = numeroDpto;
	}
	public String getLocalizacionDpto() {
		return localizacionDpto;
	}
	public void setLocalizacionDpto(String localizacionDpto) {
		this.localizacionDpto = localizacionDpto;
	}
	@Override
	public String toString() {
		return "Localizaciones_Dpto [numeroDpto=" + numeroDpto + ", localizacionDpto=" + localizacionDpto + "]";
	}
	
	
}

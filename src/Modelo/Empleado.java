package Modelo;

public class Empleado {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String fechaNac;
	private String direccion;
	private String sexo;
	private int sueldo;
	private String superdni;
	private String dno;
	public Empleado(String nombre, String apellido1, String apellido2, String dni, String fechaNac, String direccion,
			String sexo, int sueldo, String superdni, String dno) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.sexo = sexo;
		this.sueldo = sueldo;
		this.superdni = superdni;
		this.dno = dno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public String getSuperdni() {
		return superdni;
	}
	public void setSuperdni(String superdni) {
		this.superdni = superdni;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ ", fechaNac=" + fechaNac + ", direccion=" + direccion + ", sexo=" + sexo + ", sueldo=" + sueldo
				+ ", superdni=" + superdni + ", dno=" + dno + "]";
	}
	
	

}

package Controlador;

import ConexionBD.Conexion;
import Modelo.Departamento;
import Modelo.Empleado;

public class DepartamentoDAO {
	Conexion cn = new Conexion(2);
	
	public boolean insertarRegistro(Departamento dep) {
    	cn.getConexion();
        boolean resultado = false;
        resultado = cn.agregarRegistroDepartamento(dep);
        return resultado;
    }
}

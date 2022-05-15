package Controlador;

import java.sql.SQLException;

import ConexionBD.Conexion;
import Modelo.Departamento;
import Modelo.Empleado;

public class DepartamentoDAO {
	Conexion cn = new Conexion(2);
	
	public boolean insertarRegistro(Departamento dep) {
    	cn.getConexion();
        boolean resultado = false;
        try {
			resultado = cn.agregarRegistroDepartamento(dep);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resultado;
    }
}

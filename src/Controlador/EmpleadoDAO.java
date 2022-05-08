package Controlador;

import ConexionBD.Conexion;
import Modelo.Empleado;

public class EmpleadoDAO {
	Conexion cn = new Conexion(2);

    public boolean insertarRegistro(Empleado empleado) {
    	cn.getConexion();
        boolean resultado = false;
        resultado = cn.agregarRegistroEmpleado(empleado);
        return resultado;
    }


}

package Controlador;

import java.sql.SQLException;

import ConexionBD.Conexion;
import Modelo.Departamento;
import Modelo.Localizaciones_Dpto;

public class Localizaciones_Dpto_DAO {
Conexion cn = new Conexion(2);
	
	public boolean insertarRegistro(Localizaciones_Dpto loc) {
    	cn.getConexion();
        boolean resultado = false;
        try {
			resultado = cn.AgregarRegistroLocalizaciones_Dpto(loc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return resultado;
    }

}

package Controlador;

import java.sql.SQLException;

import ConexionBD.Conexion;
import Modelo.Departamento;
import Modelo.Empleado;
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
	
	public boolean eliminarRegistro(Localizaciones_Dpto loc) {
    	cn.getConexion();
        boolean resultado = false;
        try {
			resultado=cn.elimiarRegistro("DELETE FROM Empresa.dbo.localizaciones_dpto WHERE NumeroDpto="+loc.getNumeroDpto()+" AND UbicacionDpto='"+loc.getLocalizacionDpto()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			resultado=false;
		}
		return resultado;
	}
	public boolean ActualizarRegistro(Localizaciones_Dpto loc,String nuevo) {
    	cn.getConexion();
        boolean resultado = false;
        System.out.println(loc);
        System.out.println(nuevo);
        //System.out.println("Insersion?--> "+Conexion.agregarRegistroEmpleado(empleado));
        try {
			resultado = cn.actualizarRegistroDepartamentoLoc(loc,nuevo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return resultado;
        
    }
    	

}

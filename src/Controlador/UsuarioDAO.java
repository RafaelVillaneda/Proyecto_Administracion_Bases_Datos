package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ConexionBD.Conexion;
import Modelo.Localizaciones_Dpto;
import Modelo.Usuario;

public class UsuarioDAO {
	Conexion cn = new Conexion(2);
	public Usuario buscarRegistro(String user) {
		Usuario u1=new Usuario();
		String sql="SELECT * FROM Empresa.dbo.usuarios WHERE usuario ='"+user+"';";
		Conexion.getConexion();
		ResultSet rs=Conexion.ConsultarRegistro(sql);
		
		try {
			if(rs.next()) {
			u1.setUsuario(rs.getString(1));
			u1.setContraseña(rs.getString(2));
			return u1;
			}else {
				
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    	return null;
    }
	public boolean insertarRegistro(Usuario usu) {
    	cn.getConexion();
        boolean resultado = false;
        try {
			resultado = cn.agregarRegistroUsuario(usu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return resultado;
    }
	public boolean eliminarRegistro(Usuario u) {
    	cn.getConexion();
        boolean resultado = false;
        try {
			resultado=cn.elimiarRegistro("DELETE FROM Empresa.dbo.Usuarios WHERE usuario='"+u.getUsuario()+"'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			resultado=false;
		}
		return resultado;
	}
	public boolean ActualizarRegistro(Usuario u) {
    	cn.getConexion();
        boolean resultado = false;
        try {
			resultado = cn.actualizarRegistroUsuarios(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return resultado;
        
    }
}

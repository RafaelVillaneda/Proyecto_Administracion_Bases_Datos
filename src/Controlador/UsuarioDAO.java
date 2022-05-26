package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ConexionBD.Conexion;
import Modelo.Usuario;

public class UsuarioDAO {
	Conexion cn = new Conexion(2);
	public Usuario buscarRegistro(String user) {
		Usuario u1=new Usuario();
		String sql="SELECT * FROM Empresa.dbo.Usuarios WHERE usuario ='"+user+"';";
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
}

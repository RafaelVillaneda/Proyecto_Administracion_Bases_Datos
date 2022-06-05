package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
			
			e.printStackTrace();
		}
        return resultado;
    }
	public boolean ActualizarRegistro(Departamento dep) {
		cn.getConexion();
		boolean resultado = false;
		try {
			resultado= cn.actualizarRegistroDepartamento(dep);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return resultado;
	}
	public boolean eliminarRegistro(Departamento dep) {
    	cn.getConexion();
        boolean resultado = false;
        try {
			cn.procedimiento(dep.getNumeroDpto());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			resultado=cn.elimiarRegistro("DELETE FROM Empresa.dbo.Departamento WHERE NumeroDpto="+dep.getNumeroDpto()+";");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error eliminar departamento");
		}
    	return resultado;
    }
	public Empleado buscarRegistroSuperDNI(String dni) {
    	Empleado u1=new Empleado();
		String sql="SELECT * FROM Empresa.dbo.Empleado WHERE Dni ='"+dni+"';";
		Conexion.getConexion();
		ResultSet rs=Conexion.ConsultarRegistro(sql);
		
		try {
			if(rs.next()) {
			u1.setNombre(rs.getString(1));
			u1.setApellido1(rs.getString(2));
			u1.setApellido2(rs.getString(3));
			u1.setDni(rs.getString(4));
			u1.setFechaNac(rs.getString(5));
			u1.setDireccion(rs.getString(6));
			u1.setSexo(rs.getString(7));
			u1.setSuperdni(rs.getString(8));
			u1.setDno(rs.getString(9));
			return u1;
			}else {
				JOptionPane.showMessageDialog(null,"No existe ese Dni en el campo Super Dni verificalo");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    	return null;
    }
	public Empleado buscarRegistroSuperDNO(String dno) {
    	Empleado u1=new Empleado();
		String sql="SELECT * FROM Empresa.dbo.Empleado WHERE Dno ='"+dno+"';";
		Conexion.getConexion();
		ResultSet rs=Conexion.ConsultarRegistro(sql);
		
		try {
			if(rs.next()) {
			u1.setNombre(rs.getString(1));
			u1.setApellido1(rs.getString(2));
			u1.setApellido2(rs.getString(3));
			u1.setDni(rs.getString(4));
			u1.setFechaNac(rs.getString(5));
			u1.setDireccion(rs.getString(6));
			u1.setSexo(rs.getString(7));
			u1.setSuperdni(rs.getString(8));
			u1.setDno(rs.getString(9));
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

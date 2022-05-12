package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ConexionBD.Conexion;
import Modelo.Empleado;


public class EmpleadoDAO {
	Conexion con =new Conexion(0);

    public boolean insertarRegistro(Empleado empleado) {
    	con.getConexion();
        boolean resultado = false;
        //System.out.println("Insersion?--> "+Conexion.agregarRegistroEmpleado(empleado));
        resultado = con.agregarRegistroEmpleado(empleado);
       System.out.println("Resultado--->"+resultado);
        
		return resultado;
        
    }
    public boolean eliminarRegistro(Empleado obj) {
    	con.getConexion();
        boolean resultado = false;
        System.out.println(obj);
        resultado=con.elimiarRegistro("DELETE FROM Empresa.dbo.Empleado WHERE Dni='"+obj.getDni()+"' AND SuperDni='"+obj.getSuperdni()+"'");
    	return resultado;
    }
    public boolean ActualizarRegistro(Empleado empleadoModificado,String superdni,String dni) {
    	con.getConexion();
        boolean resultado = false;
        
        //System.out.println("Insersion?--> "+Conexion.agregarRegistroEmpleado(empleado));
        resultado = con.actualizarRegistroEmpleado(empleadoModificado,superdni,dni);
        
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
 


}

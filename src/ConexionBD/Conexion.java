package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.swing.JOptionPane;

import Controlador.Localizaciones_Dpto_DAO;
import Modelo.Departamento;
import Modelo.Empleado;
import Modelo.Localizaciones_Dpto;
import Modelo.Usuario;

public class Conexion {
	

    private static Connection conexion = null;
    private static PreparedStatement pstm; //NO es tan seguro ya que permite SQL Injection, se recomienda PreparedStatement
    private static Savepoint sp;
    public Conexion(int valor) {}
    private Conexion() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String URL = "jdbc:sqlserver://localhost:1433;databaseName=Empresa;"
            		+ "user=Lucy;"
            		+ "password=gulf1;"
            		+ "encrypt=true;trustServerCertificate=true;";
            try {
				conexion= DriverManager.getConnection(URL);
				System.out.println("--Conexion efectuada correctamente--");
				conexion.setAutoCommit(false);
				sp=conexion.setSavepoint();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            

        } catch (ClassNotFoundException e) {
            System.out.println("Error de DRIVER");
        }
    }

    public static Connection getConexion(){

         if (conexion == null){
             new Conexion();
         }

         return conexion;
    }
    public boolean elimiarRegistro(String sql) throws SQLException {
    	try {
    		
			pstm = conexion.prepareStatement(sql);
			pstm.executeUpdate();
			conexion.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			conexion.rollback();
			return false;
		}
        
    	
    }
    public void procedimiento(int dno) throws SQLException {
    	try {
			pstm = conexion.prepareStatement("EXECUTE [dbo].[sp_actualizarDno] ?");
			pstm.setInt(1, dno);
			pstm.execute();
			conexion.commit();
		} catch (SQLException e) {
			conexion.rollback();
			e.printStackTrace();
		}
    }
    
    public static boolean agregarRegistroEmpleado(Empleado empleado) {
        try {
            pstm = conexion.prepareStatement("INSERT \"Empleado\" (\"Nombre\",\"Apellido1\",\"Apellido2\",\"Dni\",\"FechaNac\",\"Direccion\",\"Sexo\",\"Sueldo\","
            		+ "\"SuperDni\",\"Dno\")"
            		+ " VALUES (?,?,?,?,?,?,?,?,?,?)");
            
            
            pstm.setString(1, empleado.getNombre());
            pstm.setString(2, empleado.getApellido1());
            pstm.setString(3, empleado.getApellido2());
            pstm.setString(4, empleado.getDni());
            pstm.setString(5, empleado.getFechaNac());
            pstm.setString(6, empleado.getDireccion());
            pstm.setString(7, empleado.getSexo());
            pstm.setInt(8, empleado.getSueldo());
            pstm.setString(9, empleado.getSuperdni());
            pstm.setString(10, empleado.getDno());
            
            pstm.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
        	ex.printStackTrace();
        	try {
				conexion.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return false;
    }
    public static boolean actualizarRegistroDepartamento(Departamento dep) throws SQLException {
    	System.out.println(dep);
    	try {
			pstm = conexion.prepareStatement("UPDATE Departamento SET NombreDpto=?,DniDirector=?,FechaIngresoDirector=? WHERE NumeroDpto =?");
			pstm.setString(1, dep.getNombreDpto());
	        pstm.setString(2, dep.getDniDirector());
	        pstm.setString(3, dep.getFechaIngresoDirector());
	        pstm.setInt(4, dep.getNumeroDpto());
	        pstm.executeUpdate();
            conexion.commit();
            return true;
		} catch (SQLException e) {
			conexion.rollback();
			e.printStackTrace();
		}
    	return false;
    }
    public static boolean actualizarRegistroDepartamentoLoc(Localizaciones_Dpto loc) throws SQLException {
    	try {
			pstm = conexion.prepareStatement("UPDATE localizaciones_dpto SET UbicacionDpto=? WHERE NumeroDpto =?");
			pstm.setString(1, loc.getLocalizacionDpto());
	        pstm.setInt(2, loc.getNumeroDpto());
	     
	        pstm.executeUpdate();
            conexion.commit();
            return true;
		} catch (SQLException e) {
			conexion.rollback();
			e.printStackTrace();
		}
    	return false;
    }
    
    public static boolean actualizarRegistroUsuarios(Usuario u) throws SQLException {
    	try {

			pstm = conexion.prepareStatement("UPDATE usuarios SET password=? WHERE usuario =?");
			pstm.setString(1,u.getContraseña());
	        pstm.setString(2,u.getUsuario());
	     
	        pstm.executeUpdate();
            conexion.commit();
            return true;
		} catch (SQLException e) {
			conexion.rollback();
			e.printStackTrace();
		}
    	return false;
    }
    
    public static boolean actualizarRegistroEmpleado(Empleado emp,String superDniOrigen,String dni) throws SQLException {
        try {
        	System.out.println(emp);
        	if(!emp.getDno().equals("null")) {
        		pstm = conexion.prepareStatement("UPDATE Empleado SET Nombre = ?, Apellido1 = ?,Apellido2=?,"
                		+ "Dni=?,FechaNac=?,Direccion=?, Sexo=?, Sueldo=?,SuperDni=?,"
                		+ "Dno=? WHERE Dni = ?");
		        pstm.setString(1, emp.getNombre());
		        pstm.setString(2, emp.getApellido1());
		        pstm.setString(3, emp.getApellido2());
		        pstm.setString(4, emp.getDni());
		        pstm.setString(5, emp.getFechaNac());
		        pstm.setString(6, emp.getDireccion());
		        pstm.setString(7, emp.getSexo());
		        pstm.setInt(8, emp.getSueldo());
		        pstm.setString(9, emp.getSuperdni());
		        pstm.setInt(10, Integer.parseInt(emp.getDno()));
		        
		        pstm.setString(11, dni);
		       
		        pstm.executeUpdate();
		        conexion.commit();
        	}else {
        		pstm = conexion.prepareStatement("UPDATE Empleado SET Nombre = ?, Apellido1 = ?,Apellido2=?"
                		+ "Dni=?,FechaNac=?,Direccion=?, Sexo=?, Sueldo=?,SuperDni=?,"
                		+ " WHERE Dni = ?");
		        pstm.setString(1, emp.getNombre());
		        pstm.setString(2, emp.getApellido1());
		        pstm.setString(3, emp.getApellido2());
		        pstm.setString(4, emp.getDni());
		        pstm.setString(5, emp.getFechaNac());
		        pstm.setString(6, emp.getDireccion());
		        pstm.setString(7, emp.getSexo());
		        pstm.setInt(8, emp.getSueldo());
		        pstm.setString(9, emp.getSuperdni());
		        
		        pstm.setString(10, dni);
		       // pstm.setString(11, superDniOrigen);
		        pstm.executeUpdate();
		        conexion.commit();
        	}
            
           return true;
        } catch (Exception ex) {
        	ex.printStackTrace();
            System.out.printf("Error al modificar el empleado");
            conexion.rollback();
        }
        return false;

    }
    public static boolean agregarRegistroDepartamento(Departamento dep) throws SQLException {
        try {
            pstm = conexion.prepareStatement("INSERT INTO Departamento(NombreDpto, NumeroDpto, DniDirector, FechaIngresoDirector)"
            		+ " VALUES (?,?,?,?)");
            // pstm.setInt(1, categoria.getCategoryID());
            pstm.setString(1, dep.getNombreDpto());
            pstm.setInt(2, dep.getNumeroDpto());
            pstm.setString(3, dep.getDniDirector());
            pstm.setString(4, dep.getFechaIngresoDirector());
            
            pstm.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
        	//System.out.println(ex.toString());
        	JOptionPane.showMessageDialog(null,"Ya existe un departamento en esa localizacion");
        	conexion.rollback();
            
        }
        return false;
    }
    public static boolean agregarRegistroUsuario(Usuario usu) throws SQLException{
        try {
            pstm = conexion.prepareStatement("INSERT INTO usuarios (usuario,password) VALUES(?,?)");
            // pstm.setInt(1, categoria.getCategoryID());
            pstm.setString(1, usu.getUsuario());
            pstm.setString(2, usu.getContraseña());
            
            pstm.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
        	conexion.rollback();
            
        }
        return false;
    }
    public static boolean AgregarRegistroLocalizaciones_Dpto(Localizaciones_Dpto loc) throws SQLException {
        try {
            pstm = conexion.prepareStatement("INSERT INTO localizaciones_dpto(NumeroDpto,UbicacionDpto)"
            		+ " VALUES (?,?)");
            pstm.setInt(1, loc.getNumeroDpto());
            pstm.setString(2,loc.getLocalizacionDpto());
            
            pstm.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
        	System.out.println(ex.toString());
        	conexion.rollback();
            System.out.printf("Error al agregar");
        }
        return false;
    }
    
    public static  ResultSet ConsultarRegistro(String consulta){
		
		 try {
			    pstm = conexion.prepareStatement(consulta);
		        return pstm.executeQuery();
		        
		 } catch (Exception ex) {
		        System.out.println(ex.toString());
		 }
		 return null;
	}
    

}

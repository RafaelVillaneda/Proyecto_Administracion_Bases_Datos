package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Empleado;

public class Conexion {
	

    private static Connection conexion = null;
    private static PreparedStatement pstm; //NO es tan seguro ya que permite SQL Injection, se recomienda PreparedStatement

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
    
    public static boolean agregarRegistro(Empleado empleado) {
        try {
            pstm = conexion.prepareStatement("INSERT INTO Empleado(Nombre, Apellido1, Apellido2, Dni, FechaNac, Direccion, Sexo, Sueldo)"
            		+ " VALUES (?,?,?,?,?,?,?,?)");
            // pstm.setInt(1, categoria.getCategoryID());
            pstm.setString(1, empleado.getNombre());
            pstm.setString(2, empleado.getApellido1());
            pstm.setString(3, empleado.getApellido1());
            pstm.setString(4, empleado.getDni());
            pstm.setString(5, empleado.getFechaNac());
            pstm.setString(6, empleado.getDireccion());
            pstm.setString(7, empleado.getSexo());
            pstm.setInt(8, empleado.getSueldo());
            pstm.executeUpdate();
            return true;
        } catch (Exception ex) {
        	System.out.println(ex.toString());
            System.out.printf("Error al agregar el empleado");
        }
        return false;
    }

}

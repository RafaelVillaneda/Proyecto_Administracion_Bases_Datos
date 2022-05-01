package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	

    private static Connection conexion = null;
    private static PreparedStatement pstm; //NO es tan seguro ya que permite SQL Injection, se recomienda PreparedStatement

    public Conexion(int valor) {}
    private Conexion() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String URL = "jdbc:sqlserver://localhost:1433;databaseName=pruebaconexion;"
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

}

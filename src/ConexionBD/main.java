package ConexionBD;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		//Connection a = Conexion.getConexion();
		String base="";
		
		try {
			Statement sql=Conexion.getConexion().createStatement();
			String consulta="SELECT * FROM pruebaconexion.dbo.Products";
			ResultSet resultado=sql.executeQuery(consulta);
			while(resultado.next()) {
				base+=resultado.getString(1)+"-";
			}
			System.out.println(base);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

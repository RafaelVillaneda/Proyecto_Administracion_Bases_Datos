package ConexionBD;

import java.sql.Statement;

import Controlador.EmpleadoDAO;
import Modelo.Empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		//Connection a = Conexion.getConexion();
		String base="";
		
		try {
			Statement sql=Conexion.getConexion().createStatement();
			String consulta="SELECT * FROM Empresa.dbo.Empleado";
			ResultSet resultado=sql.executeQuery(consulta);
			while(resultado.next()) {
				base+=resultado.getString(1)+"-";
			}
			System.out.println(base);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Empleado em=new Empleado("Rafa", "Villaneda", "De la torre", "026987264", "2022-05-08", "18 de julio", "M",1200, "333445555", "1");
		EmpleadoDAO dao=new EmpleadoDAO();
		dao.insertarRegistro(em);
		

	}

}

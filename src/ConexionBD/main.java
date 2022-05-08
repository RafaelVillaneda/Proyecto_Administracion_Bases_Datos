package ConexionBD;

import java.sql.Statement;

import Controlador.DepartamentoDAO;
import Controlador.EmpleadoDAO;
import Controlador.Localizaciones_Dpto_DAO;
import Modelo.Departamento;
import Modelo.Empleado;
import Modelo.Localizaciones_Dpto;

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
		/*
		Empleado em=new Empleado("Rafa", "Villaneda", "De la torre", "026987264", "2022-05-08", "18 de julio", "M",1200, "333445555", "1");
		EmpleadoDAO dao=new EmpleadoDAO();
		dao.insertarRegistro(em);
		*/
		base="";
		try {
			Statement sql=Conexion.getConexion().createStatement();
			String consulta="SELECT * FROM Empresa.dbo.Departamento";
			ResultSet resultado=sql.executeQuery(consulta);
			while(resultado.next()) {
				base+=resultado.getString(1)+"-";
			}
			System.out.println(base);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		Departamento dep=new Departamento("Departamento 1", 3, "333445555","2022-05-08");
		DepartamentoDAO DAO=new DepartamentoDAO();
		DAO.insertarRegistro(dep);
		*/
		/*
		Localizaciones_Dpto localizacion=new Localizaciones_Dpto(5,"Zacatecas");//Los dos campos son primarias
		Localizaciones_Dpto_DAO dao=new Localizaciones_Dpto_DAO();
		dao.insertarRegistro(localizacion);
		*/
	}

}

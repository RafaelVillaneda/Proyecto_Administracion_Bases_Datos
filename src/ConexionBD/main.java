package ConexionBD;

import java.sql.Statement;

import Controlador.DepartamentoDAO;
import Controlador.EmpleadoDAO;
import Controlador.Localizaciones_Dpto_DAO;
import Modelo.Departamento;
import Modelo.Empleado;
import Modelo.Localizaciones_Dpto;
import Vista.InterfazEmpleado;
import Vista.Interfaz_Departamento;
import Vista.MenuPrincipal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		Connection a = Conexion.getConexion();
		
		String base="";
		
		try {
			Statement sql=Conexion.getConexion().createStatement();
			String consulta="SELECT * FROM Empresa.dbo.Empleado";
			ResultSet resultado=sql.executeQuery(consulta);
			while(resultado.next()) {
				//System.out.println(base);
				base+=resultado.getString(1)+" "+resultado.getString(2)+"-";
			}
			System.out.println(base);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		Empleado em=new Empleado("zzzzzzzzz", "zzzzzzzz", "zzzzzzzzzzz", "123", "2022-05-08", "18 de julio", "M",1200, "777", "1");
		EmpleadoDAO dao=new EmpleadoDAO();
		dao.insertarRegistro(em);
		*/
		
		System.out.println("Pase");
		
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
		//new Interfaz_Departamento().setVisible(true);
		new MenuPrincipal().setVisible(true);
		Localizaciones_Dpto localizacion=new Localizaciones_Dpto(8,"San luis potosi");//Los dos campos son primarias
		Localizaciones_Dpto_DAO dao=new Localizaciones_Dpto_DAO();
		//dao.insertarRegistro(localizacion);
		
	}

}

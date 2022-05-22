package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import ConexionBD.Conexion;

public class Grafica {

	Conexion cn = new Conexion(2);
	
	public ImageIcon dibujar() {
		ImageIcon icono = null;
		try {
			cn.getConexion();
			String sql = "SELECT * FROM grafica_view";
			
			ResultSet rs=cn.ConsultarRegistro(sql);
			DefaultPieDataset dataset = new DefaultPieDataset();
			DecimalFormat format = new DecimalFormat("####");
			try {
				while(rs.next()) {
					dataset.setValue(rs.getString("Ubicacion")+" con "+format.format(rs.getDouble("Total_Empleados_Trabajando")),
							Integer.parseInt(rs.getString("Total_Empleados_Trabajando")));
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
				return null;
			}
			
	        JFreeChart chart= ChartFactory.createPieChart("Total de trabajadores en cada sucursal", dataset, true, true, false);
	        int x=500;
	        int y=500;
	        icono = new ImageIcon(chart.createBufferedImage(x, y));
		} catch (Exception ex) {
				ex.printStackTrace();
        }
		return icono;
	}


}

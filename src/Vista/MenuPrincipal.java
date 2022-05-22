package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.Conexion;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btn_GUI_Empleados;
	private JButton btn_Grafica;
	private JButton btn_departamentos;
	private JButton btn_Reportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setResizable(false);
		setTitle("Menu Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/menu.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Empleados");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setBounds(0, 23, 171, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblDepartamentos = new JLabel("Departamentos");
		lblDepartamentos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblDepartamentos.setBounds(0, 227, 171, 41);
		contentPane.add(lblDepartamentos);
		
		JLabel lblRegistroDeEmpleados = new JLabel("Registro de empleados");
		lblRegistroDeEmpleados.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblRegistroDeEmpleados.setBounds(234, 39, 171, 41);
		contentPane.add(lblRegistroDeEmpleados);
		
		JLabel lblGraficoSobreDepartamentos = new JLabel("Reporte de Empleados");
		lblGraficoSobreDepartamentos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblGraficoSobreDepartamentos.setBounds(234, 227, 222, 41);
		contentPane.add(lblGraficoSobreDepartamentos);
		
		btn_GUI_Empleados = new JButton("");
		btn_GUI_Empleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InterfazEmpleado().setVisible(true);
			}
		});
		btn_GUI_Empleados.setBackground(new Color(245, 245, 220));
		btn_GUI_Empleados.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/menu_Empleados.png")));
		btn_GUI_Empleados.setBounds(10, 76, 131, 137);
		contentPane.add(btn_GUI_Empleados);
		
		btn_departamentos = new JButton("");
		btn_departamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Interfaz_Departamento().setVisible(true);
			}
		});
		btn_departamentos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/menu_departamento.png")));
		btn_departamentos.setBackground(new Color(245, 245, 220));
		btn_departamentos.setBounds(10, 302, 131, 137);
		contentPane.add(btn_departamentos);
		
		btn_Grafica = new JButton("");
		btn_Grafica.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/menu_graficos.png")));
		btn_Grafica.setBackground(new Color(245, 245, 220));
		btn_Grafica.setBounds(234, 76, 131, 137);
		contentPane.add(btn_Grafica);
		
		btn_Reportes = new JButton("");
		btn_Reportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Conexion cn = new Conexion(2);
                    //cn.getConexion();
                    JasperReport jaspe=(JasperReport)JRLoader.loadObject(MenuPrincipal.class.getResource("/Reportes/ReporteEmpleados.jasper"));
                    JasperPrint print=JasperFillManager.fillReport(jaspe, null,cn.getConexion());
                    JasperViewer view= new JasperViewer(print,false);
                    view.setVisible(true);
                } catch (Exception ex) {
                	ex.printStackTrace();
                    System.err.println("Error al generar el reporte---->"+ex.getMessage());
                }
			}
		});
		btn_Reportes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/reporte.png")));
		btn_Reportes.setBackground(new Color(245, 245, 220));
		btn_Reportes.setBounds(234, 302, 131, 137);
		contentPane.add(btn_Reportes);
		
	}
}

package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btn_GUI_Empleados;
	private JButton btn_localizacion;

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
		setBounds(100, 100, 745, 533);
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
		
		JLabel lblLocalizaciones = new JLabel("Localizaciones");
		lblLocalizaciones.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblLocalizaciones.setBounds(296, 23, 171, 41);
		contentPane.add(lblLocalizaciones);
		
		JLabel lblRegistroDeEmpleados = new JLabel("Registro de empleados");
		lblRegistroDeEmpleados.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblRegistroDeEmpleados.setBounds(296, 227, 171, 41);
		contentPane.add(lblRegistroDeEmpleados);
		
		JLabel lblGraficoSobreDepartamentos = new JLabel("Reporte de Empleados");
		lblGraficoSobreDepartamentos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblGraficoSobreDepartamentos.setBounds(497, 183, 222, 41);
		contentPane.add(lblGraficoSobreDepartamentos);
		
		btn_GUI_Empleados = new JButton("");
		btn_GUI_Empleados.setBackground(new Color(245, 245, 220));
		btn_GUI_Empleados.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/menu_Empleados.png")));
		btn_GUI_Empleados.setBounds(10, 76, 131, 137);
		contentPane.add(btn_GUI_Empleados);
		
		btn_localizacion = new JButton("");
		btn_localizacion.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/localizacion.png")));
		btn_localizacion.setBounds(267, 75, 171, 125);
		btn_localizacion.setBackground(new Color(245, 245, 220));
		contentPane.add(btn_localizacion);
		
		JButton btn_departamentos = new JButton("");
		btn_departamentos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/menu_departamento.png")));
		btn_departamentos.setBackground(new Color(245, 245, 220));
		btn_departamentos.setBounds(10, 302, 131, 137);
		contentPane.add(btn_departamentos);
		
		JButton btn_Grafica = new JButton("");
		btn_Grafica.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/menu_graficos.png")));
		btn_Grafica.setBackground(new Color(245, 245, 220));
		btn_Grafica.setBounds(288, 302, 131, 137);
		contentPane.add(btn_Grafica);
		
		JButton btn_Reportes = new JButton("");
		btn_Reportes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Vista/RecursosVisuales/reporte.png")));
		btn_Reportes.setBackground(new Color(245, 245, 220));
		btn_Reportes.setBounds(531, 243, 131, 137);
		contentPane.add(btn_Reportes);
		
	}
}

package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Interfaz_Departamento extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField caja_nom_dep;
	private JTextField Caja_num_dep;
	private JTextField caja_dni_director;
	private JButton btn_agregar;
	private JButton btn_eliminar;
	private JButton btn_modificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Departamento frame = new Interfaz_Departamento();
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
	public Interfaz_Departamento() {
		setTitle("Departamentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		actualizarTabla("SELECT * FROM Empresa.dbo.Departamento");
		table.setEnabled(false);
		JComboBox combo_accion = new JComboBox();
		combo_accion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combo_accion.getSelectedIndex()==0) {
					actualizarTabla("SELECT * FROM Empresa.dbo.Departamento");
					caja_nom_dep.setEnabled(false);
					Caja_num_dep.setEnabled(false);
					caja_dni_director.setEnabled(false);
					btn_agregar.setEnabled(false);
					btn_eliminar.setEnabled(false);
					btn_modificar.setEnabled(false);
					table.setEnabled(false);
				}
				
			}
		});
		combo_accion.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una Opci\u00F3n", "Altas", "Bajas", "Cambios", "Consultas"}));
		combo_accion.setBounds(10, 11, 154, 22);
		contentPane.add(combo_accion);
		
		JLabel lblNewLabel = new JLabel("Nombre del departamento");
		lblNewLabel.setBounds(10, 56, 154, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumeroDelDepartamento = new JLabel("Numero del departamento");
		lblNumeroDelDepartamento.setBounds(10, 121, 142, 14);
		contentPane.add(lblNumeroDelDepartamento);
		
		JLabel lblDniDelDirector = new JLabel("Dni del director");
		lblDniDelDirector.setBounds(10, 201, 142, 14);
		contentPane.add(lblDniDelDirector);
		
		JComboBox combo_años = new JComboBox();
		combo_años.setEnabled(false);
		combo_años.setModel(new DefaultComboBoxModel(new String[] {"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070"}));
		combo_años.setToolTipText("Elige los dos ultimos n\u00FAmero de tu a\u00F1o de nacimiento");
		combo_años.setBounds(315, 245, 74, 22);
		contentPane.add(combo_años);
		
		JComboBox combo_meses = new JComboBox();
		combo_meses.setEnabled(false);
		combo_meses.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		combo_meses.setToolTipText("Elige tu mes de nacimiento\r\n");
		combo_meses.setBounds(258, 245, 47, 22);
		contentPane.add(combo_meses);
		
		JComboBox combo_dias = new JComboBox();
		combo_dias.setEnabled(false);
		combo_dias.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		combo_dias.setToolTipText("Elige tu d\u00EDa de nacimiento");
		combo_dias.setBounds(201, 245, 47, 22);
		contentPane.add(combo_dias);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso del director");
		lblFechaDeIngreso.setBounds(10, 249, 171, 14);
		contentPane.add(lblFechaDeIngreso);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 295, 495, 158);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Empresa");
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_Departamento.class.getResource("/Vista/RecursosVisuales/icono_departamento.png")));
		lblNewLabel_1.setBounds(228, 0, 190, 163);
		contentPane.add(lblNewLabel_1);
		
		caja_nom_dep = new JTextField();
		caja_nom_dep.setEnabled(false);
		caja_nom_dep.setBounds(10, 81, 127, 20);
		contentPane.add(caja_nom_dep);
		caja_nom_dep.setColumns(10);
		
		Caja_num_dep = new JTextField();
		Caja_num_dep.setEnabled(false);
		Caja_num_dep.setColumns(10);
		Caja_num_dep.setBounds(10, 160, 127, 20);
		contentPane.add(Caja_num_dep);
		
		caja_dni_director = new JTextField();
		caja_dni_director.setEnabled(false);
		caja_dni_director.setColumns(10);
		caja_dni_director.setBounds(10, 228, 127, 20);
		contentPane.add(caja_dni_director);
		
		JButton btn_limpiar = new JButton("Limpiar");
		btn_limpiar.setBackground(new Color(238, 232, 170));
		btn_limpiar.setBounds(354, 148, 88, 23);
		contentPane.add(btn_limpiar);
		
		btn_agregar = new JButton("");
		btn_agregar.setEnabled(false);
		btn_agregar.setBackground(new Color(238, 232, 170));
		btn_agregar.setBounds(185, 148, 63, 60);
		ImageIcon iconito=new ImageIcon(InterfazEmpleado.class.getResource("/Vista/RecursosVisuales/agregar2.png"));
		btn_agregar.setIcon(resizeIcon(iconito,btn_agregar));
		
		
		contentPane.add(btn_agregar);
		
		btn_eliminar = new JButton("");
		btn_eliminar.setEnabled(false);
		btn_eliminar.setBackground(new Color(238, 232, 170));
		btn_eliminar.setBounds(258, 148, 59, 60);
		ImageIcon iconito2=new ImageIcon(InterfazEmpleado.class.getResource("/Vista/RecursosVisuales/icono_Borrar.png"));
		btn_eliminar.setIcon(resizeIcon(iconito2,btn_eliminar));
		contentPane.add(btn_eliminar);
		
		btn_modificar = new JButton("Modificar");
		btn_modificar.setEnabled(false);
		btn_modificar.setBackground(new Color(238, 232, 170));
		btn_modificar.setBounds(354, 197, 88, 23);
		contentPane.add(btn_modificar);
	}
	public void actualizarTabla(String consulta) {
		String controlador = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Empresa;"
        		+ "user=Lucy;"
        		+ "password=gulf1;"
        		+ "encrypt=true;trustServerCertificate=true;";
		
		ResultSetTableModel modeloDatos=null;
		try {
			modeloDatos = new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(modeloDatos);
	}//Actualozar Tabla
	private Icon resizeIcon(ImageIcon icon,JButton boton) {
	    Image img = icon.getImage();
	    Image resizedImage = img.getScaledInstance(boton.getWidth(), boton.getHeight(),  java.awt.Image.SCALE_SMOOTH);
	    return new ImageIcon(resizedImage);
	}
}

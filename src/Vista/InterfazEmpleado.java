package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.Conexion;
import Controlador.EmpleadoDAO;
import Modelo.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InterfazEmpleado extends JFrame {
	

	private JPanel contentPane;
	private JTextField caja_nombre;
	private JTextField cajaPrimerAp;
	private JTextField caja_segundo_ap;
	private JTextField caja_dni;
	private JTextField caja_sueldo;
	private JTextField caja_superDni;
	private JTextField caja_dno;
	private JFormattedTextField caja_direccion;
	private JComboBox combo_dias;
	private JComboBox combo_meses;
	private JComboBox combo_años;
	private JComboBox combo_sexo;
	private JButton btn_Agregar;
	private JButton btnEliminar;
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();
	private EmpleadoDAO dao=new EmpleadoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEmpleado frame = new InterfazEmpleado();
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
	public InterfazEmpleado() {
		setTitle("Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 526);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Accion a realizar:");
		lblNewLabel.setBounds(10, 11, 107, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0) {
					caja_nombre.setEnabled(false);
					cajaPrimerAp.setEnabled(false);
					caja_segundo_ap.setEnabled(false);
					caja_dni.setEnabled(false);
					caja_sueldo.setEnabled(false);
					caja_superDni.setEnabled(false);
					caja_dno.setEnabled(false);
					table.setEnabled(false);
					combo_dias.setEnabled(false);
					combo_meses.setEnabled(false);
					combo_años.setEnabled(false);
					caja_direccion.setEnabled(false);
					combo_sexo.setEnabled(false);
					btn_Agregar.setEnabled(false);
					btnEliminar.setEnabled(false);
				}else if(comboBox.getSelectedIndex()==1) {
					caja_nombre.setEnabled(true);
					cajaPrimerAp.setEnabled(true);
					caja_segundo_ap.setEnabled(true);
					caja_dni.setEnabled(true);
					caja_sueldo.setEnabled(true);
					caja_superDni.setEnabled(true);
					caja_dno.setEnabled(true);
					btn_Agregar.setEnabled(true);
					caja_direccion.setEnabled(true);
					comboBox.setEnabled(true);
					combo_dias.setEnabled(true);
					combo_meses.setEnabled(true);
					combo_años.setEnabled(true);
					combo_sexo.setEnabled(true);
					
				}else if(comboBox.getSelectedIndex()==2) {
					btn_Agregar.setEnabled(false);
					caja_nombre.setEnabled(true);
					cajaPrimerAp.setEnabled(true);
					caja_segundo_ap.setEnabled(true);
					caja_dni.setEnabled(true);
					caja_sueldo.setEnabled(true);
					caja_superDni.setEnabled(true);
					caja_dno.setEnabled(true);
					table.setEnabled(true);
					caja_direccion.setEnabled(true);
					comboBox.setEnabled(true);
					combo_dias.setEnabled(true);
					combo_meses.setEnabled(true);
					combo_años.setEnabled(true);
					combo_sexo.setEnabled(true);
				}else if(comboBox.getSelectedIndex()==3) {
					caja_nombre.setEnabled(true);
					cajaPrimerAp.setEnabled(true);
					caja_segundo_ap.setEnabled(true);
					caja_dni.setEnabled(true);
					caja_sueldo.setEnabled(true);
					caja_superDni.setEnabled(true);
					caja_dno.setEnabled(true);
					caja_direccion.setEnabled(true);
					table.setEnabled(true);
					comboBox.setEnabled(true);
					combo_dias.setEnabled(true);
					combo_meses.setEnabled(true);
					combo_años.setEnabled(true);
					combo_sexo.setEnabled(true);
				}else if(comboBox.getSelectedIndex()==4) {
					caja_nombre.setEnabled(true);
					cajaPrimerAp.setEnabled(true);
					caja_segundo_ap.setEnabled(true);
					caja_dni.setEnabled(true);
					caja_sueldo.setEnabled(true);
					caja_superDni.setEnabled(true);
					caja_dno.setEnabled(true);
					table.setEnabled(true);
					caja_direccion.setEnabled(true);
					comboBox.setEnabled(true);
					combo_dias.setEnabled(true);
					combo_meses.setEnabled(true);
					combo_años.setEnabled(true);
					combo_sexo.setEnabled(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una opcion", "Altas", "Bajas", "Cambios", "Consultas"}));
		comboBox.setBounds(116, 7, 131, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setBounds(10, 65, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Primer apellido:");
		lblNewLabel_1_1.setBounds(10, 100, 107, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Segundo apellido:");
		lblNewLabel_1_1_1.setBounds(10, 138, 107, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dni:");
		lblNewLabel_1_2.setBounds(10, 175, 88, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Sexo:");
		lblNewLabel_2.setBounds(231, 65, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sueldo: ");
		lblNewLabel_3.setBounds(231, 100, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Super Dni: ");
		lblNewLabel_3_1.setBounds(231, 138, 61, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Dno");
		lblNewLabel_4.setBounds(231, 175, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		caja_nombre = new JTextField();
		caja_nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isLetter(car)|| Character.isSpace(car)){}else{
				e.consume();
				}
			}
		});
		caja_nombre.setEnabled(false);
		caja_nombre.setBounds(117, 59, 86, 20);
		contentPane.add(caja_nombre);
		caja_nombre.setColumns(10);
		
		
		
		cajaPrimerAp = new JTextField();
		cajaPrimerAp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isLetter(car)|| Character.isSpace(car)){}else{
				e.consume();
				}
			}
		});
		cajaPrimerAp.setEnabled(false);
		cajaPrimerAp.setColumns(10);
		cajaPrimerAp.setBounds(117, 94, 86, 20);
		contentPane.add(cajaPrimerAp);
		
		caja_segundo_ap = new JTextField();
		caja_segundo_ap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isLetter(car)|| Character.isSpace(car)){}else{
				e.consume();
				}
			}
		});
		caja_segundo_ap.setEnabled(false);
		caja_segundo_ap.setColumns(10);
		caja_segundo_ap.setBounds(117, 132, 86, 20);
		contentPane.add(caja_segundo_ap);
		
		caja_dni = new JTextField();
		caja_dni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){}else{
				e.consume();
				}
			}
		});
		caja_dni.setEnabled(false);
		caja_dni.setColumns(10);
		caja_dni.setBounds(117, 169, 86, 20);
		contentPane.add(caja_dni);
		
		combo_sexo = new JComboBox();
		combo_sexo.setEnabled(false);
		combo_sexo.setModel(new DefaultComboBoxModel(new String[] {"H", "M"}));
		combo_sexo.setBounds(299, 61, 46, 22);
		contentPane.add(combo_sexo);
		
		caja_sueldo = new JTextField();
		caja_sueldo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){}else{
				e.consume();
				}
			}
		});
		caja_sueldo.setEnabled(false);
		caja_sueldo.setBounds(298, 97, 86, 20);
		contentPane.add(caja_sueldo);
		caja_sueldo.setColumns(10);
		
		caja_superDni = new JTextField();
		caja_superDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){}else{
				e.consume();
				}
			}
		});
		caja_superDni.setEnabled(false);
		caja_superDni.setColumns(10);
		caja_superDni.setBounds(298, 135, 86, 20);
		contentPane.add(caja_superDni);
		
		caja_dno = new JTextField();
		caja_dno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car) && caja_dno.getText().length()<=0){}else{
				e.consume();
				}
			}
		});
		caja_dno.setEnabled(false);
		caja_dno.setColumns(10);
		caja_dno.setBounds(298, 172, 86, 20);
		contentPane.add(caja_dno);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setBounds(10, 215, 154, 14);
		contentPane.add(lblNewLabel_5);
		
		combo_dias = new JComboBox();
		combo_dias.setEnabled(false);
		combo_dias.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		combo_dias.setToolTipText("Elige tu d\u00EDa de nacimiento");
		combo_dias.setBounds(127, 207, 47, 22);
		contentPane.add(combo_dias);
		
		combo_meses = new JComboBox();
		combo_meses.setEnabled(false);
		combo_meses.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		combo_meses.setToolTipText("Elige tu mes de nacimiento\r\n");
		combo_meses.setBounds(196, 207, 47, 22);
		contentPane.add(combo_meses);
		
		combo_años = new JComboBox();
		combo_años.setEnabled(false);
		combo_años.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100", "2101", "2102", "2103", "2104", "2105", "2106", "2107", "2108", "2109", "2110", "2111", "2112", "2113", "2114", "2115", "2116", "2117", "2118", "2119", "2120", "2121", "2122", "2123", "2124", "2125", "2126", "2127", "2128", "2129", "2130", "2131", "2132", "2133", "2134", "2135", "2136", "2137", "2138", "2139", "2140", "2141", "2142", "2143", "2144", "2145", "2146", "2147", "2148", "2149", "2150", "2151", "2152", "2153", "2154", "2155", "2156", "2157", "2158", "2159", "2160", "2161", "2162", "2163", "2164", "2165", "2166", "2167", "2168", "2169", "2170", "2171", "2172", "2173", "2174", "2175", "2176", "2177", "2178", "2179", "2180", "2181", "2182", "2183", "2184", "2185", "2186", "2187", "2188", "2189", "2190", "2191", "2192", "2193", "2194", "2195", "2196", "2197", "2198", "2199", "2200", "2201", "2202", "2203", "2204", "2205", "2206", "2207", "2208", "2209", "2210", "2211", "2212", "2213", "2214", "2215", "2216", "2217", "2218", "2219", "2220", "2221", "2222", "2223", "2224", "2225", "2226", "2227", "2228", "2229", "2230", "2231", "2232", "2233", "2234", "2235", "2236", "2237", "2238", "2239", "2240", "2241", "2242", "2243", "2244", "2245", "2246", "2247", "2248", "2249", "2250", "2251", "2252", "2253", "2254", "2255", "2256"}));
		combo_años.setToolTipText("Elige los dos ultimos n\u00FAmero de tu a\u00F1o de nacimiento");
		combo_años.setBounds(271, 207, 74, 22);
		contentPane.add(combo_años);
		
		
		scrollPane.setBounds(10, 303, 731, 173);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		String controlador = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Empresa;"
        		+ "user=Lucy;"
        		+ "password=gulf1;"
        		+ "encrypt=true;trustServerCertificate=true;";
		
		String consulta = "SELECT * FROM Empresa.dbo.Empleado";
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
		
		caja_direccion = new JFormattedTextField();
		caja_direccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isLetter(car)||Character.isSpace(car)||car=='#'||Character.isDigit(car)){}else{
				e.consume();
				}
			}
		});
		caja_direccion.setEnabled(false);
		caja_direccion.setColumns(10);
		caja_direccion.setBounds(117, 250, 228, 20);
		contentPane.add(caja_direccion);
		
		btn_Agregar = new JButton("Agregar");
		btn_Agregar.setEnabled(false);
		btn_Agregar.setBackground(new Color(238, 232, 170));
		btn_Agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(verificarCajasVavias()==false) {
				String fecha ="";
				fecha+=combo_años.getSelectedItem().toString()+"-";
				fecha+=combo_meses.getSelectedItem().toString()+"-";
				fecha+=combo_dias.getSelectedItem().toString();
				Empleado empleado=new Empleado(caja_nombre.getText(), cajaPrimerAp.getText(), 
					caja_segundo_ap.getText(), caja_dni.getText(), fecha, caja_direccion.getText(), combo_sexo.getSelectedItem().toString(), 
					Integer.parseInt(caja_sueldo.getText()), caja_superDni.getText(), caja_dno.getText());
				if(dao.buscarRegistroSuperDNI(caja_superDni.getText())!=null) {
					boolean agregado=dao.insertarRegistro(empleado);
					if(agregado) {
						JOptionPane.showMessageDialog(null,"Registro Agregado correctamente");
						actualizarTabla("SELECT * FROM Empresa.dbo.Empleado");
					}else {
						JOptionPane.showMessageDialog(null,"Registro No Agregado");
					}
				}
				
				
				}//if
			}
		});
		btn_Agregar.setBounds(398, 45, 88, 23);
		contentPane.add(btn_Agregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(new Color(238, 232, 170));
		btnEliminar.setBounds(398, 106, 88, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel_1_3 = new JLabel("Direccion:");
		lblNewLabel_1_3.setBounds(10, 253, 73, 14);
		contentPane.add(lblNewLabel_1_3);
		
		
		
		
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
	
	public boolean verificarCajasVavias() {
		if(caja_nombre.getText().isEmpty()||cajaPrimerAp.getText().isEmpty()||caja_segundo_ap.getText().isEmpty()||caja_dni.getText().isEmpty()||caja_sueldo.getText().isEmpty()||caja_dno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Hay casillas vacias!");
			return true;
		}
		
	
		return false;
	}//Verificar
	public void obtenerRegistroTabla() {
		
		caja_nombre.setText("" + table.getValueAt(table.getSelectedRow(), 0));
		
	}
}

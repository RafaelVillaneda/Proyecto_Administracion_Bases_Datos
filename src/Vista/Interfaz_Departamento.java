package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.Conexion;
import Controlador.DepartamentoDAO;
import Controlador.Localizaciones_Dpto_DAO;
import Modelo.Departamento;
import Modelo.Localizaciones_Dpto;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz_Departamento extends JFrame {
	DepartamentoDAO dao=new DepartamentoDAO();
	Localizaciones_Dpto_DAO daoLoc=new Localizaciones_Dpto_DAO();
	

	private JPanel contentPane;
	private JTable table;
	private JTextField caja_nom_dep;
	private JTextField Caja_num_dep;
	private JTextField caja_dni_director;
	private JButton btn_agregar;
	private JButton btn_eliminar;
	private JButton btn_modificar;
	private JComboBox combo_dias;
	private JComboBox combo_años;
	private JComboBox combo_meses;
	private JComboBox combo_accion;
	private JTextField caja_ubicacion;
	private JLabel lblNewLabel_1;
	

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
		setResizable(false);
		setTitle("Departamentos");
		setBounds(100, 100, 789, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(combo_accion.getSelectedIndex()>0) {
					caja_nom_dep.setText("" + table.getValueAt(table.getSelectedRow(), 0));
					Caja_num_dep.setText("" + table.getValueAt(table.getSelectedRow(), 1));
					caja_dni_director.setText("" + table.getValueAt(table.getSelectedRow(), 2));
					
					String fecha[]=("" + table.getValueAt(table.getSelectedRow(), 3)).split("-");
					System.out.println(Arrays.toString(fecha));
					combo_dias.setSelectedItem(""+fecha[2]);
					combo_meses.setSelectedItem(""+fecha[1]);
					combo_años.setSelectedItem(""+fecha[0]);
					
					caja_ubicacion.setText("" + table.getValueAt(table.getSelectedRow(), 4));
					
					
					}
			}
		});
		//Vista
		actualizarTabla("SELECT * FROM dept_vista");
		table.setEnabled(false);

		//actualizarTabla2("SELECT * FROM localizaciones_dpto");
		
		combo_accion = new JComboBox();
		combo_accion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combo_accion.getSelectedIndex()==0) {
					actualizarTabla("SELECT * FROM dept_vista");
					caja_nom_dep.setEnabled(false);
					Caja_num_dep.setEnabled(false);
					caja_dni_director.setEnabled(false);
					caja_ubicacion.setEnabled(false);
					btn_agregar.setEnabled(false);
					btn_eliminar.setEnabled(false);
					btn_modificar.setEnabled(false);
					combo_dias.setEnabled(false);
					combo_años.setEnabled(false);
					combo_meses.setEnabled(false);
					table.setEnabled(false);
				}else if(combo_accion.getSelectedIndex()==1) {
					actualizarTabla("SELECT * FROM dept_vista");
					caja_nom_dep.setEnabled(true);
					Caja_num_dep.setEnabled(true);
					caja_dni_director.setEnabled(true);
					caja_ubicacion.setEnabled(true);
					btn_agregar.setEnabled(true);
					btn_eliminar.setEnabled(false);
					btn_modificar.setEnabled(false);
					combo_dias.setEnabled(true);
					combo_años.setEnabled(true);
					combo_meses.setEnabled(true);
					table.setEnabled(true);
				}else if(combo_accion.getSelectedIndex()==2) {
					actualizarTabla("SELECT * FROM dept_vista");
					caja_nom_dep.setEnabled(true);
					Caja_num_dep.setEnabled(true);
					caja_dni_director.setEnabled(true);
					caja_ubicacion.setEnabled(true);
					btn_agregar.setEnabled(false);
					btn_eliminar.setEnabled(true);
					btn_modificar.setEnabled(false);
					combo_dias.setEnabled(true);
					combo_años.setEnabled(true);
					combo_meses.setEnabled(true);
					table.setEnabled(true);
				}else if(combo_accion.getSelectedIndex()==3) {
					actualizarTabla("SELECT * FROM dept_vista");
					caja_nom_dep.setEnabled(true);
					Caja_num_dep.setEnabled(false);
					caja_dni_director.setEnabled(true);
					caja_ubicacion.setEnabled(true);
					btn_agregar.setEnabled(false);
					btn_eliminar.setEnabled(false);
					btn_modificar.setEnabled(true);
					combo_dias.setEnabled(true);
					combo_años.setEnabled(true);
					combo_meses.setEnabled(true);
					table.setEnabled(true);
				}else if(combo_accion.getSelectedIndex()==4) {
					actualizarTabla("SELECT * FROM dept_vista");
					caja_nom_dep.setEnabled(true);
					Caja_num_dep.setEnabled(true);
					caja_dni_director.setEnabled(true);
					caja_ubicacion.setEnabled(true);
					btn_agregar.setEnabled(false);
					btn_eliminar.setEnabled(false);
					btn_modificar.setEnabled(false);
					combo_dias.setEnabled(true);
					combo_años.setEnabled(true);
					combo_meses.setEnabled(true);
					table.setEnabled(true);
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
		
		combo_años = new JComboBox();
		combo_años.setEnabled(false);
		combo_años.setModel(new DefaultComboBoxModel(new String[] {"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070"}));
		combo_años.setToolTipText("Elige los dos ultimos n\u00FAmero de tu a\u00F1o de nacimiento");
		combo_años.setBounds(315, 251, 74, 22);
		contentPane.add(combo_años);
		
		combo_meses = new JComboBox();
		combo_meses.setEnabled(false);
		combo_meses.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		combo_meses.setToolTipText("Elige tu mes de nacimiento\r\n");
		combo_meses.setBounds(258, 251, 47, 22);
		contentPane.add(combo_meses);
		
		combo_dias = new JComboBox();
		combo_dias.setEnabled(false);
		combo_dias.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		combo_dias.setToolTipText("Elige tu d\u00EDa de nacimiento");
		combo_dias.setBounds(201, 251, 47, 22);
		contentPane.add(combo_dias);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso del director");
		lblFechaDeIngreso.setBounds(201, 231, 171, 14);
		contentPane.add(lblFechaDeIngreso);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 295, 638, 158);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		caja_nom_dep = new JTextField();
		caja_nom_dep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char car = e.getKeyChar();
				int borro=e.getKeyCode();
				if(Character.isLetter(car)|| Character.isSpace(car)|| borro==KeyEvent.VK_BACK_SPACE){
					if(combo_accion.getSelectedIndex()==2||combo_accion.getSelectedIndex()==3 || combo_accion.getSelectedIndex()==4) {
						actualizarTabla("SELECT * FROM Empresa.dbo.Departamento WHERE NombreDpto LIKE '"+caja_nom_dep.getText()+"%'");
					}
				}else{
				e.consume();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isLetter(car)|| Character.isSpace(car)){}else{
				e.consume();
				}
			}
		});
		caja_nom_dep.setEnabled(false);
		caja_nom_dep.setBounds(10, 81, 127, 20);
		contentPane.add(caja_nom_dep);
		caja_nom_dep.setColumns(10);
		
		Caja_num_dep = new JTextField();
		Caja_num_dep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char car = e.getKeyChar();
				int borro=e.getKeyCode();
				if(Character.isDigit(car)|| borro==KeyEvent.VK_BACK_SPACE){
					if(combo_accion.getSelectedIndex()==2||combo_accion.getSelectedIndex()==3 || combo_accion.getSelectedIndex()==4) {
						actualizarTabla("SELECT * FROM Empresa.dbo.Departamento WHERE NumeroDpto LIKE '"+Caja_num_dep.getText()+"%'");
					}
				}else{
				e.consume();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){}else{
				e.consume();
				}
			}
		});
		Caja_num_dep.setEnabled(false);
		Caja_num_dep.setColumns(10);
		Caja_num_dep.setBounds(10, 160, 127, 20);
		contentPane.add(Caja_num_dep);
		
		caja_dni_director = new JTextField();
		caja_dni_director.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char car = e.getKeyChar();
				int borro=e.getKeyCode();
				if(Character.isDigit(car)|| borro==KeyEvent.VK_BACK_SPACE){
					if(combo_accion.getSelectedIndex()==2||combo_accion.getSelectedIndex()==3 || combo_accion.getSelectedIndex()==4) {
						actualizarTabla("SELECT * FROM Empresa.dbo.Departamento WHERE DniDirector LIKE '"+caja_dni_director.getText()+"%'");
					}
				}else{
				e.consume();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(Character.isDigit(car)){}else{
				e.consume();
				}
				
			}
		});
		caja_dni_director.setEnabled(false);
		caja_dni_director.setColumns(10);
		caja_dni_director.setBounds(10, 228, 127, 20);
		contentPane.add(caja_dni_director);
		
		JButton btn_limpiar = new JButton("Limpiar");
		btn_limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja_dni_director.setText("");
				caja_nom_dep.setText("");
				Caja_num_dep.setText("");
				caja_ubicacion.setText("");
				combo_años.setSelectedIndex(0);
				combo_meses.setSelectedIndex(0);
				combo_dias.setSelectedIndex(0);
				actualizarTabla("SELECT * FROM dept_vista");
				//actualizarTabla2("SELECT * FROM localizaciones_dpto");
			}
		});
		btn_limpiar.setBackground(new Color(238, 232, 170));
		btn_limpiar.setBounds(354, 148, 88, 23);
		contentPane.add(btn_limpiar);
		
		btn_agregar = new JButton("");
		btn_agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificar_cajasVacias()==false) {
				String fecha ="";
				fecha+=combo_años.getSelectedItem().toString()+"-";
				fecha+=combo_meses.getSelectedItem().toString()+"-";
				fecha+=combo_dias.getSelectedItem().toString();
				Departamento dep=new Departamento(caja_nom_dep.getText(), Integer.parseInt(Caja_num_dep.getText()), caja_dni_director.getText(),fecha);
				System.out.println(dep);
				if(dao.buscarRegistroSuperDNI(caja_dni_director.getText())!=null) {
				if(dao.insertarRegistro(dep)==true) {
					JOptionPane.showMessageDialog(null,"Se Agrego el departamento");
					daoLoc.insertarRegistro(new Localizaciones_Dpto(dep.getNumeroDpto(), caja_ubicacion.getText()));
					actualizarTabla("SELECT * FROM dept_vista");
					//actualizarTabla2("SELECT * FROM localizaciones_dpto");
				}else {
					JOptionPane.showMessageDialog(null,"No se pudo agregar el departamento");
				}
				}else {
					JOptionPane.showMessageDialog(null,"No existe ese Dni Director");
					
				}
				}else {
					JOptionPane.showMessageDialog(null,"Hay campos vacios!");
				}
				
			}
		});
		btn_agregar.setEnabled(false);
		btn_agregar.setBackground(new Color(238, 232, 170));
		btn_agregar.setBounds(185, 148, 63, 60);
		ImageIcon iconito=new ImageIcon(InterfazEmpleado.class.getResource("/Vista/RecursosVisuales/agregar2.png"));
		btn_agregar.setIcon(resizeIcon(iconito,btn_agregar));
		if(verificar_cajasVacias()==false) {
			
		}else {
			
		}
		
		contentPane.add(btn_agregar);
		
		btn_eliminar = new JButton("");
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String fecha ="";
					fecha+=combo_años.getSelectedItem().toString()+"-";
					fecha+=combo_meses.getSelectedItem().toString()+"-";
					fecha+=combo_dias.getSelectedItem().toString();
					daoLoc.eliminarRegistro(new Localizaciones_Dpto(Integer.parseInt(Caja_num_dep.getText()),caja_ubicacion.getText()));
					if(dao.eliminarRegistro(new Departamento(caja_nom_dep.getText(), Integer.parseInt(Caja_num_dep.getText()), caja_dni_director.getText(), fecha))) {
						JOptionPane.showMessageDialog(null,"Se elimino correctamente el Departamento");
						actualizarTabla("SELECT * FROM dept_vista");
						//actualizarTabla2("SELECT * FROM localizaciones_dpto");
					}else {
						JOptionPane.showMessageDialog(null,"No se elimino Departamento");
					}
				
			}
		});
		btn_eliminar.setEnabled(false);
		btn_eliminar.setBackground(new Color(238, 232, 170));
		btn_eliminar.setBounds(258, 148, 59, 60);
		ImageIcon iconito2=new ImageIcon(InterfazEmpleado.class.getResource("/Vista/RecursosVisuales/icono_Borrar.png"));
		btn_eliminar.setIcon(resizeIcon(iconito2,btn_eliminar));
		contentPane.add(btn_eliminar);
		
		btn_modificar = new JButton("Modificar");
		btn_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificar_cajasVacias()==false) {
				String fecha ="";
				fecha+=combo_años.getSelectedItem().toString()+"-";
				fecha+=combo_meses.getSelectedItem().toString()+"-";
				fecha+=combo_dias.getSelectedItem().toString();
				daoLoc.ActualizarRegistro(new Localizaciones_Dpto(Integer.parseInt(Caja_num_dep.getText()),caja_ubicacion.getText()));
				if(dao.ActualizarRegistro(new Departamento(caja_nom_dep.getText(), Integer.parseInt(Caja_num_dep.getText()), caja_dni_director.getText(), fecha))) {
					JOptionPane.showMessageDialog(null,"Se actualizo correctamente el Departamento");
					actualizarTabla("SELECT * FROM dept_vista");
					//actualizarTabla2("SELECT * FROM localizaciones_dpto");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Hay camnpos vacios");
				}
			}
		});
		btn_modificar.setEnabled(false);
		btn_modificar.setBackground(new Color(238, 232, 170));
		btn_modificar.setBounds(354, 197, 88, 23);
		contentPane.add(btn_modificar);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setBounds(185, 56, 154, 14);
		contentPane.add(lblUbicacin);
		
		caja_ubicacion = new JTextField();
		caja_ubicacion.setEnabled(false);
		caja_ubicacion.setColumns(10);
		caja_ubicacion.setBounds(185, 81, 127, 20);
		contentPane.add(caja_ubicacion);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(468, 0, 305, 248);
		contentPane.add(lblNewLabel_1);
		ImageIcon iconito3=new ImageIcon(InterfazEmpleado.class.getResource("/Vista/RecursosVisuales/dep.png"));
		lblNewLabel_1.setIcon(resizeIcon(iconito3,lblNewLabel_1));
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
	private Icon resizeIcon(ImageIcon icon,JLabel label) {
	    Image img = icon.getImage();
	    Image resizedImage = img.getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH);
	    return new ImageIcon(resizedImage);
	}
	public boolean verificar_cajasVacias() {
		if(caja_nom_dep.getText().isEmpty()||Caja_num_dep.getText().isEmpty()||caja_dni_director.getText().isEmpty()||caja_ubicacion.getText().isEmpty()) {
			return true;
		}
		return false;
	}
}

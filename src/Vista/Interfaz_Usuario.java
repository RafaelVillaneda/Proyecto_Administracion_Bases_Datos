package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.UsuarioDAO;
import Modelo.Usuario;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Interfaz_Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField caja_usuario;
	private JTable table;
	private JButton btn_agregar;
	private JButton btn_eliminar;
	private JButton btn_modificar;
	private JButton btn_limpiar;
	private JPasswordField caja_contra;
	UsuarioDAO DAO=new UsuarioDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Usuario frame = new Interfaz_Usuario();
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
	public Interfaz_Usuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz_Usuario.class.getResource("/Vista/RecursosVisuales/usuario.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JComboBox combo_accion = new JComboBox();
		combo_accion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combo_accion.getSelectedIndex()==0) {
					caja_usuario.setEnabled(false);
					caja_contra.setEnabled(false);
					btn_agregar.setEnabled(false);
					btn_eliminar.setEnabled(false);
					btn_limpiar.setEnabled(false);
					btn_modificar.setEnabled(false);
					table.setEnabled(false);
				}else if(combo_accion.getSelectedIndex()==1) {
					caja_usuario.setEnabled(true);
					caja_contra.setEnabled(true);
					btn_agregar.setEnabled(true);
					btn_eliminar.setEnabled(false);
					btn_limpiar.setEnabled(true);
					btn_modificar.setEnabled(false);
					table.setEnabled(true);
				}else if(combo_accion.getSelectedIndex()==2) {
					caja_usuario.setEnabled(true);
					caja_contra.setEnabled(false);
					btn_eliminar.setEnabled(true);
					btn_agregar.setEnabled(false);
					btn_limpiar.setEnabled(true);
					btn_modificar.setEnabled(false);
					table.setEnabled(true);
				}else if(combo_accion.getSelectedIndex()==3) {
					caja_usuario.setEnabled(true);
					caja_contra.setEnabled(true);
					btn_eliminar.setEnabled(false);
					btn_limpiar.setEnabled(true);
					btn_modificar.setEnabled(true);
					btn_agregar.setEnabled(false);
					table.setEnabled(true);
				}else if(combo_accion.getSelectedIndex()==4) {
					caja_usuario.setEnabled(true);
					caja_contra.setEnabled(false);
					btn_eliminar.setEnabled(false);
					btn_limpiar.setEnabled(true);
					btn_modificar.setEnabled(false);
					btn_agregar.setEnabled(false);
					table.setEnabled(true);
				}
			}
		});
		combo_accion.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una Opci\u00F3n", "Altas", "Bajas", "Cambios", "Consultas"}));
		combo_accion.setBounds(10, 11, 154, 22);
		contentPane.add(combo_accion);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		caja_usuario = new JTextField();
		caja_usuario.setEnabled(false);
		caja_usuario.setBounds(10, 69, 86, 20);
		contentPane.add(caja_usuario);
		caja_usuario.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 193, 134);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(157, 44, 105, 14);
		contentPane.add(lblContrasea);
		
		btn_agregar = new JButton("Agregar Usuario");
		btn_agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usu=new Usuario(caja_usuario.getText(), caja_contra.getText());
				if(DAO.insertarRegistro(usu)==true) {
					JOptionPane.showMessageDialog(null,"Se agrego el usuario correctamente");
					actualizarTabla("SELECT usuario FROM Usuarios");
				}else {
					JOptionPane.showMessageDialog(null,"No se pudo e el usuario");
				}
			}
		});
		btn_agregar.setEnabled(false);
		btn_agregar.setBounds(265, 68, 141, 23);
		contentPane.add(btn_agregar);
		
		btn_eliminar = new JButton("Eliminar Usuario");
		btn_eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usu=new Usuario(caja_usuario.getText(),"");
				System.out.println(usu.getUsuario());
				if(!usu.getUsuario().equals("rafael") && DAO.eliminarRegistro(usu)==true) {
					if(DAO.buscarRegistro(caja_usuario.getText())!=null) {
						JOptionPane.showMessageDialog(null,"Usuario Eliminado correctamente");
					}else {
						JOptionPane.showMessageDialog(null,"No existe el usuario que deseas eliminar");
					}
					
					actualizarTabla("SELECT usuario FROM Usuarios");
				}else {
					JOptionPane.showMessageDialog(null,"No se pudo eliminar el usuario");
				}
			}
		});
		btn_eliminar.setEnabled(false);
		btn_eliminar.setBounds(265, 113, 141, 23);
		contentPane.add(btn_eliminar);
		
		btn_modificar = new JButton("Modificar Usuario");
		btn_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u=DAO.buscarRegistro(caja_usuario.getText());
				if(u!=null) {
					String contra=JOptionPane.showInputDialog(rootPane,"Ingresa la vieja contraseña");
					if(u.getContraseña().equals(contra)) {
						System.out.println("entre al if");
						System.out.println(DAO.ActualizarRegistro(u));
						JOptionPane.showMessageDialog(null,"Registro actualizado");
					}else {
						JOptionPane.showMessageDialog(null,"Error contraseña incorrecta");
					}
				}else {
					JOptionPane.showMessageDialog(null,"No existe el usuario que deseas modificar");
				}
				actualizarTabla("SELECT usuario FROM Usuarios");
				
			}
		});
		btn_modificar.setEnabled(false);
		btn_modificar.setBounds(265, 162, 141, 23);
		contentPane.add(btn_modificar);
		
		btn_limpiar = new JButton("Limpiar");
		btn_limpiar.setEnabled(false);
		btn_limpiar.setBounds(265, 212, 141, 23);
		contentPane.add(btn_limpiar);
		
		caja_contra = new JPasswordField();
		caja_contra.setEnabled(false);
		caja_contra.setBounds(130, 68, 120, 22);
		contentPane.add(caja_contra);
		actualizarTabla("SELECT usuario FROM Usuarios");
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
}

package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.UsuarioDAO;
import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Login extends JFrame {

	private JPanel contentPane;
	private JTextField caja_user;
	private JPasswordField caja_contra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Login frame = new Interfaz_Login();
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
	public Interfaz_Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresa tu usuario");
		lblNewLabel.setBounds(62, 164, 137, 14);
		contentPane.add(lblNewLabel);
		
		caja_user = new JTextField();
		caja_user.setBounds(35, 203, 153, 20);
		contentPane.add(caja_user);
		caja_user.setColumns(10);
		
		JLabel lblIngresaTuContrasea = new JLabel("Ingresa tu contrase\u00F1a");
		lblIngresaTuContrasea.setBounds(45, 234, 137, 14);
		contentPane.add(lblIngresaTuContrasea);
		
		caja_contra = new JPasswordField();
		caja_contra.setBounds(35, 274, 153, 20);
		contentPane.add(caja_contra);
		
		JButton btn_ingresar = new JButton("");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usu;
				UsuarioDAO DAO=new UsuarioDAO();
				usu=DAO.buscarRegistro(caja_user.getText());
				if(usu!=null && usu.getUsuario().equals(caja_user.getText()) && usu.getContraseña().equals(caja_contra.getText())) {
					new MenuPrincipal().setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"Oh vaya al parecer el usuario o la contraseña son incorrectos");
				}
			}
		});
		btn_ingresar.setIcon(new ImageIcon(Interfaz_Login.class.getResource("/Vista/RecursosVisuales/Login.png")));
		btn_ingresar.setBounds(45, 305, 121, 73);
		contentPane.add(btn_ingresar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_Login.class.getResource("/Vista/RecursosVisuales/usuario.png")));
		lblNewLabel_1.setBounds(38, 0, 128, 153);
		contentPane.add(lblNewLabel_1);
	}
}

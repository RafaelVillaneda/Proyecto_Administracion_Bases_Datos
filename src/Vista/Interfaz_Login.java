package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Interfaz_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
		
		textField = new JTextField();
		textField.setBounds(35, 203, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIngresaTuContrasea = new JLabel("Ingresa tu contrase\u00F1a");
		lblIngresaTuContrasea.setBounds(45, 234, 137, 14);
		contentPane.add(lblIngresaTuContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(35, 274, 153, 20);
		contentPane.add(passwordField);
		
		JButton btn_ingresar = new JButton("");
		btn_ingresar.setIcon(new ImageIcon(Interfaz_Login.class.getResource("/Vista/RecursosVisuales/Login.png")));
		btn_ingresar.setBounds(45, 305, 121, 73);
		contentPane.add(btn_ingresar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Interfaz_Login.class.getResource("/Vista/RecursosVisuales/usuario.png")));
		lblNewLabel_1.setBounds(38, 0, 128, 153);
		contentPane.add(lblNewLabel_1);
	}
}

package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Grafica;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Grafica extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Grafica frame = new Interfaz_Grafica();
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
	public Interfaz_Grafica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz_Grafica.class.getResource("/Vista/RecursosVisuales/menu_graficos.png")));
		setTitle("Grafica");
		setBounds(100, 100, 725, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 81, 689, 330);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Generar Grafica");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				establecerIcono();
			}
		});
		btnNewButton.setFont(new Font("Wide Latin", Font.ITALIC, 16));
		btnNewButton.setBounds(198, 23, 300, 33);
		contentPane.add(btnNewButton);
	}
	
	public void establecerIcono() {
		Grafica gp = new Grafica();
		ImageIcon icono = gp.dibujar();
		if(icono!=null) {
			lblNewLabel.setIcon(resizeIcon(icono,lblNewLabel));
		}
	}
	private Icon resizeIcon(ImageIcon icon,JLabel label) {
	    Image img = icon.getImage();
	    Image resizedImage = img.getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH);
	    return new ImageIcon(resizedImage);
	}
}

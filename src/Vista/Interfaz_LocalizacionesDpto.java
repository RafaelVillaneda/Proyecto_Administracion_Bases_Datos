package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JButton;

public class Interfaz_LocalizacionesDpto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_LocalizacionesDpto frame = new Interfaz_LocalizacionesDpto();
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
	public Interfaz_LocalizacionesDpto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz_LocalizacionesDpto.class.getResource("/Vista/RecursosVisuales/localizacion.png")));
		setTitle("Ubicaciones de departamentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox combo_accion = new JComboBox();
		combo_accion.setModel(new DefaultComboBoxModel(new String[] {"Selecciona una Opci\u00F3n", "Altas", "Bajas", "Cambios", "Consultas"}));
		combo_accion.setBounds(10, 11, 154, 22);
		contentPane.add(combo_accion);
		
		JLabel lblNewLabel = new JLabel("Numero de departamento:");
		lblNewLabel.setBounds(10, 64, 143, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(177, 61, 41, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(10, 118, 91, 14);
		contentPane.add(lblUbicacion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 115, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 264, 185);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btn_altas = new JButton("agregar");
		btn_altas.setBounds(284, 27, 89, 23);
		contentPane.add(btn_altas);
		
		JButton btn_bajas = new JButton("bajas");
		btn_bajas.setBounds(284, 100, 89, 23);
		contentPane.add(btn_bajas);
		
		JButton btn_cambios = new JButton("Cambiar");
		btn_cambios.setBounds(406, 27, 89, 23);
		contentPane.add(btn_cambios);
		
		JButton btn_limpiar = new JButton("Limpiar");
		btn_limpiar.setBounds(406, 100, 89, 23);
		contentPane.add(btn_limpiar);
	}
}

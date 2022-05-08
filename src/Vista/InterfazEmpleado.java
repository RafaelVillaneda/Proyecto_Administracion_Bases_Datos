package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class InterfazEmpleado extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField caja_nombre;
	private JTextField cajaPrimerAp;
	private JTextField caja_segundo_ap;
	private JTextField caja_dni;
	private JTextField caja_sueldo;
	private JTextField textField;
	private JTextField textField_1;

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
		setTitle("Empledos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Accion a realizar:");
		lblNewLabel.setBounds(10, 11, 107, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
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
		
		caja_nombre = new JFormattedTextField();
		caja_nombre.setBounds(117, 59, 86, 20);
		contentPane.add(caja_nombre);
		caja_nombre.setColumns(10);
		try {
			caja_nombre.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUUUUUUUUUUUUUUUUUUU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		
		cajaPrimerAp = new JTextField();
		cajaPrimerAp.setColumns(10);
		cajaPrimerAp.setBounds(117, 94, 86, 20);
		contentPane.add(cajaPrimerAp);
		
		caja_segundo_ap = new JTextField();
		caja_segundo_ap.setColumns(10);
		caja_segundo_ap.setBounds(117, 132, 86, 20);
		contentPane.add(caja_segundo_ap);
		
		caja_dni = new JTextField();
		caja_dni.setColumns(10);
		caja_dni.setBounds(117, 169, 86, 20);
		contentPane.add(caja_dni);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"H", "M"}));
		comboBox_1.setBounds(299, 61, 46, 22);
		contentPane.add(comboBox_1);
		
		caja_sueldo = new JTextField();
		caja_sueldo.setBounds(298, 97, 86, 20);
		contentPane.add(caja_sueldo);
		caja_sueldo.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(298, 135, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(298, 172, 86, 20);
		contentPane.add(textField_1);
		
		
	}
}

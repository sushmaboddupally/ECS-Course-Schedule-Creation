import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DegreePlan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DegreePlan frame = new DegreePlan();
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
	public DegreePlan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDegreeCode = new JLabel("Degree Code");
		lblDegreeCode.setBounds(96, 28, 89, 14);
		contentPane.add(lblDegreeCode);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(96, 65, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(97, 101, 46, 14);
		contentPane.add(lblHours);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setBounds(97, 137, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setBounds(97, 171, 88, 14);
		contentPane.add(lblCourses);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(96, 211, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(231, 211, 89, 23);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(231, 25, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(231, 62, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(231, 98, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(231, 134, 86, 20);
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(231, 168, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}

}

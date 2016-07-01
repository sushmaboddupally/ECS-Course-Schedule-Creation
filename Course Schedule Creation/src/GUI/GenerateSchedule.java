package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GenerateSchedule extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
	public static void NewScreen(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateSchedule frame = new GenerateSchedule();
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
	public GenerateSchedule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(59, 46, 78, 14);
		contentPane.add(lblSemester);
		
		JLabel lblFillPercentage = new JLabel("Fill Percentage");
		lblFillPercentage.setBounds(59, 83, 101, 14);
		contentPane.add(lblFillPercentage);
		
		JLabel lblOveragePercentage = new JLabel("Overage Percentage");
		lblOveragePercentage.setBounds(59, 124, 101, 14);
		contentPane.add(lblOveragePercentage);
		
		JLabel lblCourseCapacity = new JLabel("Course Capacity");
		lblCourseCapacity.setBounds(59, 167, 101, 14);
		contentPane.add(lblCourseCapacity);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(249, 43, 86, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(249, 83, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(249, 121, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(249, 164, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(161, 210, 89, 23);
		contentPane.add(btnGenerate);
	}
}

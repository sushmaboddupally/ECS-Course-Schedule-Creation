package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestSchedule extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSchedule frame = new TestSchedule();
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
	public TestSchedule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalNoOf = new JLabel("Total No. of Students");
		lblTotalNoOf.setBounds(33, 39, 234, 14);
		contentPane.add(lblTotalNoOf);
		
		JLabel lblNoOfStudents = new JLabel("No. of students with required courses ");
		lblNoOfStudents.setBounds(33, 77, 195, 14);
		contentPane.add(lblNoOfStudents);
		
		JLabel lblNoOfStudents_1 = new JLabel("No. of students without required courses");
		lblNoOfStudents_1.setBounds(33, 122, 234, 14);
		contentPane.add(lblNoOfStudents_1);
		
		JLabel lblNoOfSections = new JLabel("No. of Sections");
		lblNoOfSections.setBounds(33, 167, 179, 14);
		contentPane.add(lblNoOfSections);
		
		JLabel lblNoOfSections_1 = new JLabel("No. of sections above capacity");
		lblNoOfSections_1.setBounds(33, 210, 179, 14);
		contentPane.add(lblNoOfSections_1);
		
		JLabel lblNoOfSections_2 = new JLabel("No. of sections below Fill Percent");
		lblNoOfSections_2.setBounds(33, 253, 195, 14);
		contentPane.add(lblNoOfSections_2);
		
		JLabel lblNoOsSections = new JLabel("No. of sections above overage Percent");
		lblNoOsSections.setBounds(33, 295, 218, 14);
		contentPane.add(lblNoOsSections);
		
		JLabel lblNoOfSections_3 = new JLabel("No. of sections within Tolerance");
		lblNoOfSections_3.setBounds(33, 334, 179, 14);
		contentPane.add(lblNoOfSections_3);
		
		textField = new JTextField();
		textField.setBounds(289, 36, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 74, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(289, 119, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(289, 164, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(289, 207, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(289, 250, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(289, 292, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(289, 331, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
	}

}

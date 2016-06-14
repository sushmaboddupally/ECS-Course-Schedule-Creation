import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseEdit frame = new CourseEdit();
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
	public CourseEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setBounds(42, 11, 83, 14);
		contentPane.add(lblCourseCode);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(42, 36, 83, 14);
		contentPane.add(lblCourseName);
		
		JLabel lblCourseDescription = new JLabel("Course Description");
		lblCourseDescription.setBounds(42, 61, 121, 14);
		contentPane.add(lblCourseDescription);
		
		JLabel lblCourseHours = new JLabel("Course Hours");
		lblCourseHours.setBounds(42, 86, 96, 14);
		contentPane.add(lblCourseHours);
		
		JLabel lblCourseCapacity = new JLabel("Course Capacity");
		lblCourseCapacity.setBounds(42, 111, 96, 14);
		contentPane.add(lblCourseCapacity);
		
		JLabel lblOfferedFall = new JLabel("Offered Fall");
		lblOfferedFall.setBounds(42, 136, 96, 14);
		contentPane.add(lblOfferedFall);
		
		JLabel lblOfferdSpring = new JLabel("Offerd Spring");
		lblOfferdSpring.setBounds(42, 161, 106, 14);
		contentPane.add(lblOfferdSpring);
		
		JLabel lblOfferedSummer = new JLabel("Offered Summer");
		lblOfferedSummer.setBounds(42, 186, 96, 14);
		contentPane.add(lblOfferedSummer);
		
		JLabel lblCoursePrereq = new JLabel("Course Prereq");
		lblCoursePrereq.setBounds(42, 211, 121, 14);
		contentPane.add(lblCoursePrereq);
		
		JLabel lblTeachers = new JLabel("Teachers");
		lblTeachers.setBounds(42, 239, 83, 14);
		contentPane.add(lblTeachers);
		
		textField = new JTextField();
		textField.setBounds(160, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 33, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 58, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 86, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(160, 108, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(160, 136, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(160, 158, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(160, 186, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(160, 211, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(160, 236, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(264, 235, 75, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(349, 235, 75, 23);
		contentPane.add(btnCancel);
	}

}

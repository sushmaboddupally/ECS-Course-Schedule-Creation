package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CourseEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void NewScreen() {
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
		setBounds(100, 100, 711, 391);
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
		
		textField_8 = new JTextField();
		textField_8.setBounds(160, 211, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JList list = new JList();
		list.setBounds(326, 36, 316, 188);
		contentPane.add(list);
	
		
		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(326, 255, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(359, 307, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(446, 255, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(565, 255, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave_1.setBounds(229, 307, 89, 23);
		contentPane.add(btnSave_1);
		
		JLabel lblCourseEdit = new JLabel("Course Edit");
		lblCourseEdit.setBounds(447, 11, 76, 14);
		contentPane.add(lblCourseEdit);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(160, 133, 86, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(160, 158, 86, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(160, 183, 86, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(160, 236, 86, 20);
		contentPane.add(comboBox_4);
		
		textField = new JTextField();
		textField.setBounds(160, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}

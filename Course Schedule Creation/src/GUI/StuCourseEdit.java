package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SOURCE.Student;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;

public class StuCourseEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String id;
	private String dept;
	private String coursesComp;
	private String grade;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuCourseEdit frame = new StuCourseEdit();
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
	public StuCourseEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(56, 72, 86, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(55, 125, 132, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblCoursesCompleted = new JLabel("Courses Completed");
		lblCoursesCompleted.setBounds(56, 173, 132, 14);
		contentPane.add(lblCoursesCompleted);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(56, 228, 132, 14);
		contentPane.add(lblGrade);
		
		textField = new JTextField();
		textField.setBounds(197, 66, 94, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(235, 329, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(377, 329, 86, 23);
		contentPane.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(317, 260, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(438, 260, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(547, 260, 89, 23);
		contentPane.add(btnDelete);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(197, 122, 94, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(197, 170, 94, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(197, 225, 94, 20);
		contentPane.add(comboBox_2);
		
		JList list = new JList();
		list.setBounds(320, 57, 316, 188);
		contentPane.add(list);
		
		JLabel lblStudentCourseData = new JLabel("Student Course Data");
		lblStudentCourseData.setBounds(422, 32, 117, 14);
		contentPane.add(lblStudentCourseData);
		
	}

}

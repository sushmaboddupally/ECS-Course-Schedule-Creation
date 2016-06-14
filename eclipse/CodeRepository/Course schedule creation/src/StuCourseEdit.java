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
import javax.swing.JComboBox;

public class StuCourseEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public static void NewScreen() {
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(79, 28, 86, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(79, 76, 132, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblCoursesCompleted = new JLabel("Courses Completed");
		lblCoursesCompleted.setBounds(79, 129, 132, 14);
		contentPane.add(lblCoursesCompleted);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(79, 175, 132, 14);
		contentPane.add(lblGrade);
		
		textField = new JTextField();
		textField.setBounds(247, 25, 88, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(79, 212, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(249, 212, 86, 23);
		contentPane.add(btnCancel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(247, 73, 88, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(247, 123, 88, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(247, 172, 88, 20);
		contentPane.add(comboBox_2);
	}

}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class FacultyEdit extends JFrame {

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
	//public static void main(String[] args) {
	 public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyEdit frame = new FacultyEdit();
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
	public FacultyEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(45, 21, 111, 14);
		contentPane.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(45, 46, 100, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblSemester = new JLabel("Grad School");
		lblSemester.setBounds(45, 71, 100, 14);
		contentPane.add(lblSemester);
		
		JLabel lblDaysAvailable = new JLabel("Days To Teach");
		lblDaysAvailable.setBounds(45, 121, 111, 14);
		contentPane.add(lblDaysAvailable);
		
		JLabel lblCourse = new JLabel("Title");
		lblCourse.setBounds(45, 146, 63, 14);
		contentPane.add(lblCourse);
		
		JLabel lblCourse_1 = new JLabel("MaxLoadFall");
		lblCourse_1.setBounds(45, 171, 100, 14);
		contentPane.add(lblCourse_1);
		
		JLabel lblCourse_2 = new JLabel("MaxLoadSpring");
		lblCourse_2.setBounds(45, 196, 123, 14);
		contentPane.add(lblCourse_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(274, 227, 77, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(361, 227, 73, 23);
		contentPane.add(btnCancel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("M");
		chckbxNewCheckBox.setBounds(178, 117, 35, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxT = new JCheckBox("T");
		chckbxT.setBounds(215, 117, 35, 23);
		contentPane.add(chckbxT);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("W");
		chckbxNewCheckBox_1.setBounds(249, 117, 46, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxTh = new JCheckBox("TH");
		chckbxTh.setBounds(292, 117, 46, 23);
		contentPane.add(chckbxTh);
		
		JCheckBox chckbxF = new JCheckBox("F");
		chckbxF.setBounds(337, 117, 97, 23);
		contentPane.add(chckbxF);
		
		textField = new JTextField();
		textField.setBounds(178, 18, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 43, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Degree");
		lblNewLabel.setBounds(45, 96, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMaxloadsummer = new JLabel("MaxLoadSummer");
		lblMaxloadsummer.setBounds(45, 221, 123, 14);
		contentPane.add(lblMaxloadsummer);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 68, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(178, 90, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(178, 143, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(178, 168, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(178, 193, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(178, 218, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
	}
}

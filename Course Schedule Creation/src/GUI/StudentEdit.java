package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;

import SOURCE.Student;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;

public class StudentEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	

	private String id;
	private String dept;
	private String gradStartYear;
	private String gradEndYear;
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentEdit frame = new StudentEdit();
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
	public StudentEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(30, 62, 77, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblNewLabel = new JLabel("Department");
		lblNewLabel.setBounds(30, 121, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Grad Start Year");
		lblNewLabel_1.setBounds(30, 180, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEstimatedGradEnd = new JLabel("Estimated Grad End Year");
		lblEstimatedGradEnd.setBounds(30, 233, 144, 14);
		contentPane.add(lblEstimatedGradEnd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(355, 380, 89, 23);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(188, 59, 107, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(318, 295, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdate.setBounds(433, 295, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(545, 295, 89, 23);
		contentPane.add(btnDelete);
		
		
		JList list = new JList();
		list.setBounds(318, 61, 316, 188);
		contentPane.add(list);
	
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(218, 380, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblStudentData = new JLabel("Student Data");
		lblStudentData.setBounds(415, 22, 135, 14);
		contentPane.add(lblStudentData);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(188, 118, 107, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(184, 177, 111, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(184, 230, 111, 20);
		contentPane.add(comboBox_2);
	}
}

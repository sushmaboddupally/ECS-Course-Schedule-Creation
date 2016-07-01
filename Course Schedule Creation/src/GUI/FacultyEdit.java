package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FacultyEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	 public void NewScreen() {
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
		setBounds(100, 100, 709, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(33, 21, 111, 14);
		contentPane.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(33, 51, 100, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblSemester = new JLabel("Grad School");
		lblSemester.setBounds(33, 86, 100, 14);
		contentPane.add(lblSemester);
		
		JLabel lblDaysAvailable = new JLabel("Days To Teach");
		lblDaysAvailable.setBounds(34, 150, 111, 14);
		contentPane.add(lblDaysAvailable);
		
		JLabel lblCourse = new JLabel("Title");
		lblCourse.setBounds(33, 193, 63, 14);
		contentPane.add(lblCourse);
		
		JLabel lblCourse_1 = new JLabel("MaxLoadFall");
		lblCourse_1.setBounds(33, 238, 100, 14);
		contentPane.add(lblCourse_1);
		
		JLabel lblCourse_2 = new JLabel("MaxLoadSpring");
		lblCourse_2.setBounds(33, 280, 123, 14);
		contentPane.add(lblCourse_2);
		
		JList list = new JList();
		list.setBounds(318, 61, 316, 252);
		contentPane.add(list);
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(358, 381, 87, 23);
		contentPane.add(btnCancel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("M");
		chckbxNewCheckBox.setBounds(116, 146, 35, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxT = new JCheckBox("T");
		chckbxT.setBounds(151, 146, 35, 23);
		contentPane.add(chckbxT);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("W");
		chckbxNewCheckBox_1.setBounds(188, 146, 46, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxTh = new JCheckBox("TH");
		chckbxTh.setBounds(236, 146, 46, 23);
		contentPane.add(chckbxTh);
		
		JCheckBox chckbxF = new JCheckBox("F");
		chckbxF.setBounds(284, 146, 35, 23);
		contentPane.add(chckbxF);
		
		textField = new JTextField();
		textField.setBounds(196, 18, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 52, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Degree");
		lblNewLabel.setBounds(34, 122, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMaxloadsummer = new JLabel("MaxLoadSummer");
		lblMaxloadsummer.setBounds(33, 328, 123, 14);
		contentPane.add(lblMaxloadsummer);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(337, 324, 87, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(441, 324, 86, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(537, 324, 87, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(214, 381, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblFacultyEdit = new JLabel("Faculty Edit");
		lblFacultyEdit.setBounds(441, 21, 86, 14);
		contentPane.add(lblFacultyEdit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(196, 83, 86, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(196, 119, 86, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(196, 190, 86, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(196, 235, 86, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(196, 277, 86, 20);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(196, 325, 86, 20);
		contentPane.add(comboBox_5);
	}
}

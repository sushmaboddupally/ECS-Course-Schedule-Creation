package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DegreePlan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void NewScreen() {
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
		setBounds(100, 100, 716, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDegreeCode = new JLabel("Degree Code");
		lblDegreeCode.setBounds(83, 65, 89, 14);
		contentPane.add(lblDegreeCode);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(84, 117, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(84, 173, 46, 14);
		contentPane.add(lblHours);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setBounds(84, 229, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setBounds(84, 286, 88, 14);
		contentPane.add(lblCourses);
		
		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(350, 282, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(382, 346, 89, 23);
		contentPane.add(btnCancel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 114, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(212, 170, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(212, 226, 86, 20);
		contentPane.add(comboBox);
		
		JList list = new JList();
		list.setBounds(335, 61, 321, 188);
		contentPane.add(list);
		
		textField_3 = new JTextField();
		textField_3.setBounds(212, 283, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(455, 282, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(567, 282, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblDegreePlan = new JLabel("Degree Plan");
		lblDegreePlan.setBounds(446, 24, 98, 14);
		contentPane.add(lblDegreePlan);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setBounds(235, 346, 89, 23);
		contentPane.add(btnSave_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(212, 62, 86, 20);
		contentPane.add(comboBox_1);
	}

}

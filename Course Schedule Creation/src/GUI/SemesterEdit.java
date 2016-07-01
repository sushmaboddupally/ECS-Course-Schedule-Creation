package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SemesterEdit extends JFrame {

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
					SemesterEdit frame = new SemesterEdit();
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
	public SemesterEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(60, 68, 86, 14);
		contentPane.add(lblSemester);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(60, 128, 98, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(60, 181, 86, 14);
		contentPane.add(lblEndDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(173, 65, 86, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(173, 125, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 178, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JList list = new JList();
		list.setBounds(279, 46, 316, 169);
		contentPane.add(list);
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(322, 291, 86, 23);
		contentPane.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(279, 238, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(391, 238, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(506, 238, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(188, 291, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblSmesterEdit = new JLabel("Semester Edit");
		lblSmesterEdit.setBounds(391, 21, 90, 14);
		contentPane.add(lblSmesterEdit);
	}

}

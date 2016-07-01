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

public class DegreeReq extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					DegreeReq frame = new DegreeReq();
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
	public DegreeReq() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDgreeCode = new JLabel("Dgree Code");
		lblDgreeCode.setBounds(52, 71, 104, 14);
		contentPane.add(lblDgreeCode);
		
		JLabel lblDegreeName = new JLabel("Grad School");
		lblDegreeName.setBounds(52, 132, 104, 14);
		contentPane.add(lblDegreeName);
		
		JLabel lblDegreeName_1 = new JLabel("Degree Name");
		lblDegreeName_1.setBounds(52, 189, 79, 14);
		contentPane.add(lblDegreeName_1);
		
		JLabel lblForecast = new JLabel("Forecast");
		lblForecast.setBounds(52, 243, 77, 14);
		contentPane.add(lblForecast);
		
		textField = new JTextField();
		textField.setBounds(177, 68, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(177, 186, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(177, 240, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JList list = new JList();
		list.setBounds(314, 70, 316, 188);
		contentPane.add(list);
	
		
		JButton btnSave = new JButton("Add");
		btnSave.setBounds(314, 279, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(349, 332, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(430, 279, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(541, 279, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setBounds(223, 332, 89, 23);
		contentPane.add(btnSave_1);
		
		JLabel lblDegreeEdit = new JLabel("Degree Edit");
		lblDegreeEdit.setBounds(425, 31, 79, 14);
		contentPane.add(lblDegreeEdit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 129, 86, 20);
		contentPane.add(comboBox);
	}
}

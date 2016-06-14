import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

      public static void NewScreen() {
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(81, 68, 86, 14);
		contentPane.add(lblSemester);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(81, 115, 98, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(81, 156, 86, 14);
		contentPane.add(lblEndDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(201, 65, 86, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(201, 112, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 153, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(201, 202, 86, 23);
		contentPane.add(btnCancel);
	}

}

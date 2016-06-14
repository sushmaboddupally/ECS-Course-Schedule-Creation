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

public class DegreeReq extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public static void NewScreen() {
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDgreeCode = new JLabel("Dgree Code");
		lblDgreeCode.setBounds(52, 36, 104, 14);
		contentPane.add(lblDgreeCode);
		
		JLabel lblDegreeName = new JLabel("Grad School");
		lblDegreeName.setBounds(52, 82, 104, 14);
		contentPane.add(lblDegreeName);
		
		JLabel lblDegreeName_1 = new JLabel("Degree Name");
		lblDegreeName_1.setBounds(52, 129, 79, 14);
		contentPane.add(lblDegreeName_1);
		
		JLabel lblForecast = new JLabel("Forecast");
		lblForecast.setBounds(54, 171, 77, 14);
		contentPane.add(lblForecast);
		
		textField = new JTextField();
		textField.setBounds(177, 33, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 79, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(177, 126, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(177, 168, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(52, 206, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(174, 206, 89, 23);
		contentPane.add(btnCancel);
	}
}

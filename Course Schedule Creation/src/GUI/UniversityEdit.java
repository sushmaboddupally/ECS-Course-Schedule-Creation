package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import SOURCE.GraduateSchool;
import SOURCE.Student;
import java.io.FileWriter;
import java.util.ArrayList;


public class UniversityEdit extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAbr;
	ArrayList<GraduateSchool> stdList=new ArrayList<GraduateSchool>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UniversityEdit frame = new UniversityEdit();
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
	public UniversityEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUniversityName = new JLabel("University Name");
		lblUniversityName.setBounds(63, 65, 89, 14);
		contentPane.add(lblUniversityName);
		
		JLabel lblAbbrevation = new JLabel("Abbrevation");
		lblAbbrevation.setBounds(63, 120, 89, 14);
		contentPane.add(lblAbbrevation);
		
		txtName = new JTextField();
		txtName.setBounds(240, 62, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAbr = new JTextField();
		txtAbr.setBounds(240, 117, 86, 20);
		contentPane.add(txtAbr);
		txtAbr.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();

			}
		});
		btnSave.setBounds(103, 185, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(222, 185, 89, 23);
		contentPane.add(btnCancel);
	}
	
	public void writeDataToCSV()
	{
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter("TestDataUniversityName.csv", true);
//			fileWriter.append("Univ Name, Abbrevation");
//			fileWriter.append("\n");
				fileWriter.append(txtName.getText());
				fileWriter.append(",");
				fileWriter.append(txtAbr.getText());
				fileWriter.append("\n");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				fileWriter.flush();
				fileWriter.close();

			}catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}




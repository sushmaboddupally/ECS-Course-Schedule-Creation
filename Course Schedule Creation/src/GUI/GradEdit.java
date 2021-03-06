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

public class GradEdit extends JFrame {

	private JPanel contentPane;
	private JTextField txtGradname;
	private JTextField txtAbr;
	ArrayList<GraduateSchool> stdList=new ArrayList<GraduateSchool>();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {

        public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradEdit frame = new GradEdit();
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
	public GradEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGradSchoolName = new JLabel("Grad School Abbrevation");
		lblGradSchoolName.setBounds(57, 53, 152, 14);
		contentPane.add(lblGradSchoolName);
		
		JLabel lblGradSchoolName_1 = new JLabel("Grad School Name");
		lblGradSchoolName_1.setBounds(57, 99, 113, 14);
		contentPane.add(lblGradSchoolName_1);
		
		txtGradname = new JTextField();
		txtGradname.setBounds(219, 50, 147, 20);
		contentPane.add(txtGradname);
		txtGradname.setColumns(10);
		
		txtAbr = new JTextField();
		txtAbr.setBounds(219, 96, 147, 20);
		contentPane.add(txtAbr);
		txtAbr.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();

			}
		});
		btnSave.setBounds(93, 170, 89, 23);
		contentPane.add(btnSave);
	
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel_1.setBounds(218, 170, 89, 23);
		contentPane.add(btnCancel_1);
		
	}
	
	public void writeDataToCSV()
	{
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter("TestDataGradSchools.csv", true);
			fileWriter.append("Degree Code,Grad School,Degree Name,Forecast");
			fileWriter.append("\n");
				fileWriter.append(txtGradname.getText());
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

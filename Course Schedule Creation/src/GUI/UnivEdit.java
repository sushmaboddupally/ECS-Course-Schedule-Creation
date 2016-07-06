package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import GUI.StuCourseEdit.StudentTableModel;
import SOURCE.University;
import SOURCE.Student;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UnivEdit {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAbr;
	
	ArrayList<University> stdList=new ArrayList<University>();
	
	
	/**
	 * Launch the application.
	 */
//public static void main(String[] args) {
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnivEdit window = new UnivEdit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnivEdit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Name");
		lblNewLabel.setBounds(100, 68, 104, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Abbrevation");
		lblNewLabel_1.setBounds(100, 118, 104, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtName.setBounds(260, 65, 86, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtAbr = new JTextField();
		txtAbr.setBounds(260, 115, 86, 20);
		frame.getContentPane().add(txtAbr);
		txtAbr.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();

			}
		});
		btnSave.setBounds(100, 183, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(257, 183, 89, 23);
		frame.getContentPane().add(btnCancel);
	}

	protected void setAbbrevation(Object token) {
		// TODO Auto-generated method stub
		
	}

	protected void setUniversityName(Object token) {
		// TODO Auto-generated method stub
		
	}
	
	public void writeDataToCSV()
	{
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter("OUTPUT_University.CSV", false);
			fileWriter.append("University Name, Abbreviation");
			fileWriter.append("\n");
			for (University student : stdList) {
				fileWriter.append(student.getName());
				fileWriter.append(",");
				fileWriter.append(student.getNumber());
				fileWriter.append("\n");
			}	
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

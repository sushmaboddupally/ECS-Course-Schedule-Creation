package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SOURCE.Student;

import javax.swing.JTextArea;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

public class ImportStu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ArrayList<Student> stdList=new ArrayList<Student>();
	List<String> degreeList= new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportStu frame = new ImportStu();
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
	public ImportStu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentData = new JLabel("Student Data");
		lblStudentData.setBounds(184, 26, 118, 14);
		contentPane.add(lblStudentData);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(247, 159, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnBrowse = new JButton("Attach");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Choosing a file 
			  JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textField.setText(filename);
			}
	     });
		btnBrowse.setBounds(247, 89, 89, 23);
		contentPane.add(btnBrowse);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importdata();
			}
		});
		btnImport.setBounds(108, 159, 89, 23);
		contentPane.add(btnImport);
		
		textField = new JTextField();
		textField.setBounds(108, 90, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	public void importdata(){
		String fileName = "STU.DUMP.CSV";
		File file = new File(fileName);
		try{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.next();
				System.out.println(data);
			}
			inputStream.close();
		   } catch (FileNotFoundException e){
			   e.printStackTrace();
		   }	
	}
}

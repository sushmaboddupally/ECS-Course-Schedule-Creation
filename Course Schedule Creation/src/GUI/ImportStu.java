package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import java.util.HashSet;

import SOURCE.Semester;
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
	List<String> stdIdList= new ArrayList<String>();
	List<String> deptCodeList= new ArrayList<String>();
	List<String> yearsList= new ArrayList<String>();
	List<String> degreeList= new ArrayList<String>();
	
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
//		String fileName = "STU.DUMP.CSV";
//		File file = new File(fileName);
//		try{
//			Scanner inputStream = new Scanner(file);
//			while(inputStream.hasNext()){
//				String data = inputStream.next();
//				System.out.println(data);
//				
//				//Need to pass this data to Generate schedule Method or function
//				GenerateReport.loadUniversityCourse();
//			}
//			inputStream.close();
//		   } catch (FileNotFoundException e){
//			   e.printStackTrace();
//		   }	
//	}
		BufferedReader fileReader = null;
		try{
			HashSet<String> hsStdIt=new HashSet<String>();
			HashSet<String> hsDptCode=new HashSet<String>();
			HashSet<String> hsYear=new HashSet<String>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("STU.DUMP.CSV"));
//			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(",");
				String stdId="",DptCode="",endYear="";
				if (tokens.length > 0) {				
					if(!hsStdIt.contains(tokens[0]))
					{
						stdIdList.add(tokens[0]);
						hsStdIt.add(tokens[0]);
					}
					stdId=tokens[0];
					if(!hsDptCode.contains(tokens[1]))
					{
						deptCodeList.add(tokens[1]);
						hsDptCode.add(tokens[1]);
					}
					DptCode=tokens[1];
					if(!hsYear.contains(tokens[2]))
					{
						yearsList.add(tokens[2]);
						hsYear.add(tokens[2]);	
					}
					endYear=tokens[2];
				}
				Student std=new Student(stdId,DptCode,"",endYear,"");
				stdList.add(std);
				System.out.println(stdId+","+DptCode+","+endYear);
			}


		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				fileReader.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}		

	}
}

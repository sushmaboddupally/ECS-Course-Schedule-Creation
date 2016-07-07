package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SOURCE.Student;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

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

public class ImportStuCou extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ArrayList<Student> stdList=new ArrayList<Student>();
	List<String> stdIdList= new ArrayList<String>();
	List<String> deptCodeList= new ArrayList<String>();
	List<String> yearsList= new ArrayList<String>();
	List<String> degreeList= new ArrayList<String>();
	List<String> gradeList= new ArrayList<String>();
	
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportStuCou frame = new ImportStuCou();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ImportStuCou() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentCourseData = new JLabel("Student Course Data");
		lblStudentCourseData.setBounds(149, 30, 137, 14);
		contentPane.add(lblStudentCourseData);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setBounds(228, 147, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnAttach = new JButton("Attach");
		btnAttach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				textField.setText(filename);
			}
		});
		btnAttach.setBounds(228, 81, 89, 23);
		contentPane.add(btnAttach);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				importdata();
			}
		});
		btnImport.setBounds(94, 147, 89, 23);
		contentPane.add(btnImport);
		
		textField = new JTextField();
		textField.setBounds(97, 82, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	public void importdata(){
			BufferedReader fileReader = null;
			try{
				HashSet<String> hsStdIt=new HashSet<String>();
				HashSet<String> hsDptCode=new HashSet<String>();
				HashSet<String> hsYear=new HashSet<String>();
				HashSet<String> hsGrade=new HashSet<String>();
				String line = "";
				fileReader = new BufferedReader(new FileReader("STC.DUMP.CSV"));
				fileReader.readLine();
				while ((line = fileReader.readLine()) != null) {
					String[] tokens = line.split(",");
					String stdId="",DptCode="",strtYear="",grade="";
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
						if(!hsYear.contains(tokens[3]))
						{
							yearsList.add(tokens[3]);
							hsYear.add(tokens[3]);	
						}
						strtYear=tokens[3];
						if(!hsGrade.contains(tokens[4]))
						{
							gradeList.add(tokens[4]);
							hsGrade.add(tokens[4]);	
						}
						grade=tokens[4];
					}
					Student std=new Student(stdId,DptCode,"",strtYear,grade);
					stdList.add(std);
					System.out.println(stdId+","+DptCode+","+strtYear+","+grade);
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




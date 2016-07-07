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

import GUI.StudentEdit.RowListener;
import GUI.StudentEdit.StudentTableModel;
import SOURCE.Student;

import javax.swing.JLabel;
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
import javax.swing.JList;
import javax.swing.JOptionPane;

public class StuCourseEdit extends JFrame {

	private JFrame contentPane;

	private JTextField textField;
	JComboBox strtYearComboBox;
	JComboBox deptComboBox;
	JComboBox endYearComboBox;
	ArrayList<Student> stdList=new ArrayList<Student>();
	List<String> stdIdList= new ArrayList<String>();
	List<String> deptCodeList= new ArrayList<String>();
	List<String> yearsList= new ArrayList<String>();
	List<String> degreeList= new ArrayList<String>();
	List<String> gradeList= new ArrayList<String>();


	private String id;
	private String dept;
	private String gradStartYear;
	private String gradEndYear;
	JTable table;

	StudentTableModel tableModel;
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuCourseEdit frame = new StuCourseEdit();
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
	public StuCourseEdit() {
		readDataFromCSV();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 447);
		contentPane = this;
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(56, 72, 86, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(55, 125, 132, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblCoursesCompleted = new JLabel("Courses Completed");
		lblCoursesCompleted.setBounds(56, 173, 132, 14);
		contentPane.add(lblCoursesCompleted);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(56, 228, 132, 14);
		contentPane.add(lblGrade);
		
		textField = new JTextField();
		textField.setBounds(197, 66, 94, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();

			}
		});
		btnSave.setBounds(235, 329, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(377, 329, 86, 23);
		contentPane.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student std= new Student(textField.getText(),(String)deptComboBox.getSelectedItem(),"", (String)strtYearComboBox.getSelectedItem(),(String)endYearComboBox.getSelectedItem());
				tableModel.addRow(std);
			}
		});
		btnAdd.setBounds(317, 260, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student std= new Student(textField.getText(),(String)deptComboBox.getSelectedItem(),"", (String)strtYearComboBox.getSelectedItem(),(String)endYearComboBox.getSelectedItem());
				if(table.getSelectedRow()>=0)
					tableModel.updateRow(std, table.getSelectedRow());
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for update");
			}
		});
		btnUpdate.setBounds(438, 260, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0)
				{
					Student std= tableModel.getStudent(table.getSelectedRow());
					tableModel.removeRow(std);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for delete");  
			}
		});
		btnDelete.setBounds(547, 260, 89, 23);
		contentPane.add(btnDelete);
		
		deptComboBox = new JComboBox(deptCodeList.toArray());
		deptComboBox.setBounds(197, 122, 94, 20);
		contentPane.add(deptComboBox);
		
		strtYearComboBox = new JComboBox(yearsList.toArray());
		strtYearComboBox.setBounds(197, 170, 94, 20);
		contentPane.add(strtYearComboBox);
		
//		strtYearComboBox = new JComboBox(degreeList.toArray());
//		strtYearComboBox.setBounds(197, 170, 94, 20);
//		contentPane.add(strtYearComboBox);
		
		endYearComboBox = new JComboBox(gradeList.toArray());
		endYearComboBox.setBounds(197, 225, 94, 20);
		contentPane.add(endYearComboBox);
		
		table = new JTable();
		tableModel=new StudentTableModel();
		table.setModel(tableModel);
		JScrollPane contentPane1 = new JScrollPane(table);
		contentPane1.setBounds(320, 57, 316, 188);
		contentPane.add(contentPane1);
		
		ListSelectionModel model1=table.getSelectionModel();
		model1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model1.addListSelectionListener(new RowListener());
		
		JLabel lblStudentCourseData = new JLabel("Student Course Data");
		lblStudentCourseData.setBounds(422, 32, 117, 14);
		contentPane.add(lblStudentCourseData);
		
	}
	class StudentTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public int getRowCount() {
			return stdList.size();
		}
		public void removeRow(Student student) {
			stdList.remove(student);
			fireTableRowsDeleted(stdList.size()-1, stdList.size()-1);
		}

		public void addRow(Student student)
		{
			stdList.add(student);
			fireTableRowsInserted(stdList.size()-1, stdList.size()-1);
		}

		public void updateRow(Student student,int index)
		{
			stdList.set(index,student);
			fireTableRowsUpdated(stdList.size()-1, stdList.size()-1);
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0: return "Id";
			case 1: return "Dept.";
			case 2: return "Courses Comp.";
			case 3: return "Grade";
			default: return "";
			}
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			Student student = stdList.get(rowIndex);

			switch (columnIndex) {
			case 0: return student.getStudentSTCId();
			case 1: return student.getStudentDegreeCourseCode();
			case 2: return student.getStudentStartYr();
			case 3: return student.getStudentGrad();
			default: return null;

			}
		}
		public Student getStudent(int row)
		{
			return stdList.get(row);
		}
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 4;
		}

	}
	public void readDataFromCSV()
	{
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

	public void writeDataToCSV()
	{
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter("STC.DUMP.CSV", false);
			fileWriter.append("StudentId,Dept,Courses Completed,Grade");
			fileWriter.append("\n");
			for (Student student : stdList) {
				fileWriter.append(student.getStudentSTCId());
				fileWriter.append(",");
				fileWriter.append(student.getStudentDegreeCourseCode());
				fileWriter.append(",");
				fileWriter.append(student.getStudentStartYr());
				fileWriter.append(",");
				fileWriter.append(student.getStudentGrad());
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
	
	class RowListener implements ListSelectionListener
	{	   
		public void valueChanged(ListSelectionEvent e)
		{
			if(!e.getValueIsAdjusting())
			{
				ListSelectionModel model = table.getSelectionModel();
				int lead = model.getLeadSelectionIndex();
				displayRowValues(lead);
			}
		}

		private void displayRowValues(int rowIndex)
		{
			int columns = table.getColumnCount();
			String selectedStdId="",selectedDept="",selectedStrtYear="", selectedEndYear="";
			for(int col = 0; col < columns; col++)
			{
				Object o = table.getValueAt(rowIndex, col);
				if(col==0)
					selectedStdId=o.toString();
				else if(col==1)
					selectedDept=o.toString();
				else if(col==2)
					selectedStrtYear=o.toString();
				else if(col==3)
					selectedEndYear=o.toString();
			}
			textField.setText(selectedStdId);
			deptComboBox.setSelectedItem(selectedDept);
			strtYearComboBox.setSelectedItem(selectedStrtYear);
			endYearComboBox.setSelectedItem(selectedEndYear);
		}
	}

}

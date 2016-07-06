package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import SOURCE.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StudentEdit extends JFrame {

	//private JPanel contentPane;
	private JFrame contentPane;

	private JTextField textField;
	JComboBox strtYearComboBox;
	JComboBox deptComboBox;
	JComboBox endYearComboBox;
	ArrayList<Student> stdList=new ArrayList<Student>();;
	List<String> stdIdList= new ArrayList<String>();
	List<String> deptCodeList= new ArrayList<String>();
	List<String> yearsList= new ArrayList<String>();


	private String id;
	private String dept;
	private String gradStartYear;
	private String gradEndYear;
	JTable table;

	private StudentTableModel stdTableModel;

	StudentTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentEdit frame = new StudentEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StudentEdit()
	{
		mainControls();
	}

	public void mainControls()
	{
		readDataFromCSV();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 675, 496);
		tableModel = new StudentTableModel();
		table = new JTable();
		table.setModel(tableModel);
		contentPane = this;
		JScrollPane contentPane1 = new JScrollPane(table);
		contentPane1.setBounds(318, 61, 316, 188);
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		contentPane.add(contentPane1);
		studentTable();
		leftControls();
		modifyButtons();
		rightControls();
	}

	public void leftControls()
	{
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(30, 62, 77, 14);
		contentPane.add(lblStudentId);

		textField = new JTextField();
		textField.setBounds(188, 59, 107, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Department");
		lblNewLabel.setBounds(30, 121, 77, 14);
		contentPane.add(lblNewLabel);	

		deptComboBox = new JComboBox(deptCodeList.toArray());
		deptComboBox.setBounds(188, 118, 107, 20);
		contentPane.add(deptComboBox);


		JLabel lblNewLabel_1 = new JLabel("Grad  Year");
		lblNewLabel_1.setBounds(30, 180, 119, 14);
		contentPane.add(lblNewLabel_1);

		strtYearComboBox = new JComboBox(yearsList.toArray());
		strtYearComboBox.setBounds(184, 177, 111, 20);
		contentPane.add(strtYearComboBox);

//		JLabel lblEstimatedGradEnd = new JLabel("Estimated Grad End Year");
//		lblEstimatedGradEnd.setBounds(30, 233, 144, 14);
//		contentPane.add(lblEstimatedGradEnd);		
//
//		endYearComboBox = new JComboBox(yearsList.toArray());
//		endYearComboBox.setBounds(184, 230, 111, 20);
//		contentPane.add(endYearComboBox);
	}

	/**
	 * Create the frame.
	 */
	public void modifyButtons() {	

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(355, 380, 89, 23);
		contentPane.add(btnCancel);



		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student std= new Student(textField.getText(),(String)deptComboBox.getSelectedItem(),"", (String)strtYearComboBox.getSelectedItem(),(String)endYearComboBox.getSelectedItem());
				tableModel.addRow(std);
			}
		});
		btnAdd.setBounds(318, 295, 89, 23);
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
		btnUpdate.setBounds(433, 295, 89, 23);
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
		btnDelete.setBounds(545, 295, 89, 23);
		contentPane.add(btnDelete);
	}


	public void studentTable()
	{
		ListSelectionModel model=table.getSelectionModel();
		model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model.addListSelectionListener(new RowListener());
	}



	public void rightControls()
	{
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();

			}
		});

		btnSave.setBounds(218, 380, 89, 23);
		contentPane.add(btnSave);

		JLabel lblStudentData = new JLabel("Student Data");
		lblStudentData.setBounds(415, 22, 135, 14);
		contentPane.add(lblStudentData);

	}

	public void readDataFromCSV()
	{
		BufferedReader fileReader = null;
		try{
			HashSet<String> hsStdIt=new HashSet<String>();
			HashSet<String> hsDptCode=new HashSet<String>();
			HashSet<String> hsYear=new HashSet<String>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("STU.DUMP.CSV"));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(",");
				String stdId="",DptCode="",strtYear="",gradYear="";
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
					strtYear=tokens[2];
					gradYear=tokens[2];
				}
				Student std=new Student(stdId,DptCode,"",strtYear,gradYear);
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
			fileWriter = new FileWriter("OUTPUT.CSV", false);
			fileWriter.append("StudentId,Dept,StartYear,GradYear");
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
			case 2: return "Grad Year";
//			case 3: return "Grad Year";
			default: return "";
			}
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			Student student = stdList.get(rowIndex);

			switch (columnIndex) {
			case 0: return student.getStudentSTCId();
			case 1: return student.getStudentDegreeCourseCode();
			case 2: return student.getStudentStartYr();
//			case 3: return student.getStudentGrad();
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
			return 3;
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


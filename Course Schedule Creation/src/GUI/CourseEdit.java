package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import GUI.StuCourseEdit.StudentTableModel;
import SOURCE.Course;
import SOURCE.Faculty;
import SOURCE.Student;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

public class CourseEdit extends JFrame {

	private JFrame contentPane;
	private JTextField textFieldCourseCode;
	private JTextField textFieldCourseName;
	private JTextField textFieldCourseDesc;
	private JTextField textFieldCourseHrs;
	private JTextField textFieldCourseCapacity;
	private JTextField textFieldCoursePrereq;
	
	JComboBox fallComboBox;
	JComboBox springComboBox;
	JComboBox summerComboBox;
	JComboBox teacherComboBox;
	
	JTable table;

	StudentTableModel tableModel;
	ArrayList<Course> stdList=new ArrayList<Course>();
	List<String> teacherList= new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseEdit frame = new CourseEdit();
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
	public CourseEdit() {
		readDataFromCSV();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 391);
		contentPane = this;
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setBounds(42, 11, 83, 14);
		contentPane.add(lblCourseCode);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(42, 36, 83, 14);
		contentPane.add(lblCourseName);
		
		JLabel lblCourseDescription = new JLabel("Course Description");
		lblCourseDescription.setBounds(42, 61, 121, 14);
		contentPane.add(lblCourseDescription);
		
		JLabel lblCourseHours = new JLabel("Course Hours");
		lblCourseHours.setBounds(42, 86, 96, 14);
		contentPane.add(lblCourseHours);
		
		JLabel lblCourseCapacity = new JLabel("Course Capacity");
		lblCourseCapacity.setBounds(42, 111, 96, 14);
		contentPane.add(lblCourseCapacity);
		
		JLabel lblOfferedFall = new JLabel("Offered Fall");
		lblOfferedFall.setBounds(42, 136, 96, 14);
		contentPane.add(lblOfferedFall);
		
		JLabel lblOfferdSpring = new JLabel("Offerd Spring");
		lblOfferdSpring.setBounds(42, 161, 106, 14);
		contentPane.add(lblOfferdSpring);
		
		JLabel lblOfferedSummer = new JLabel("Offered Summer");
		lblOfferedSummer.setBounds(42, 186, 96, 14);
		contentPane.add(lblOfferedSummer);
		
		JLabel lblCoursePrereq = new JLabel("Course Prereq");
		lblCoursePrereq.setBounds(42, 211, 121, 14);
		contentPane.add(lblCoursePrereq);
		
		JLabel lblTeachers = new JLabel("Teachers");
		lblTeachers.setBounds(42, 239, 83, 14);
		contentPane.add(lblTeachers);
		
		textFieldCourseCode = new JTextField();
		textFieldCourseCode.setBounds(160, 33, 86, 20);
		contentPane.add(textFieldCourseCode);
		textFieldCourseCode.setColumns(10);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setBounds(160, 58, 86, 20);
		contentPane.add(textFieldCourseName);
		textFieldCourseName.setColumns(10);
		
		textFieldCourseDesc = new JTextField();
		textFieldCourseDesc.setBounds(160, 86, 86, 20);
		contentPane.add(textFieldCourseDesc);
		textFieldCourseDesc.setColumns(10);
		
		textFieldCourseHrs = new JTextField();
		textFieldCourseHrs.setBounds(160, 108, 86, 20);
		contentPane.add(textFieldCourseHrs);
		textFieldCourseHrs.setColumns(10);
		
		textFieldCourseCapacity = new JTextField();
		textFieldCourseCapacity.setBounds(160, 211, 86, 20);
		contentPane.add(textFieldCourseCapacity);
		textFieldCourseCapacity.setColumns(10);
		
		table = new JTable();
		tableModel=new StudentTableModel();
		table.setModel(tableModel);
		JScrollPane contentPane1 = new JScrollPane(table);
		contentPane1.setBounds(326, 36, 316, 188);
		contentPane.add(contentPane1);
	
		
		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course cou= new Course(textFieldCourseCode.getText(),textFieldCourseName.getText(),textFieldCourseDesc.getText(),textFieldCourseHrs.getText(),textFieldCourseCapacity.getText(),textFieldCoursePrereq.getText(),(String)fallComboBox.getSelectedItem(),(String)springComboBox.getSelectedItem(),(String)summerComboBox.getSelectedItem(),(String)teacherComboBox.getSelectedItem());
				tableModel.addRow(cou);
			}
		});
		btnSave.setBounds(326, 255, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(359, 307, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course cou= new Course(textFieldCourseCode.getText(),textFieldCourseName.getText(),textFieldCourseDesc.getText(),textFieldCourseHrs.getText(),textFieldCourseCapacity.getText(),textFieldCoursePrereq.getText(),(String)fallComboBox.getSelectedItem(),(String)springComboBox.getSelectedItem(),(String)summerComboBox.getSelectedItem(),(String)teacherComboBox.getSelectedItem());
				tableModel.updateRow(cou, table.getSelectedRow());
			}
		});
		btnUpdate.setBounds(446, 255, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0)
				{
					Course cou= tableModel.getStudent(table.getSelectedRow());
					tableModel.removeRow(cou);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for delete");  
			}
		});
		btnDelete.setBounds(565, 255, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();
			}
		});
		btnSave_1.setBounds(229, 307, 89, 23);
		contentPane.add(btnSave_1);
		
		JLabel lblCourseEdit = new JLabel("Course Edit");
		lblCourseEdit.setBounds(447, 11, 76, 14);
		contentPane.add(lblCourseEdit);
		
		String yesNo[]=new String[]{
				"Y","N"
		};
		
		fallComboBox = new JComboBox(yesNo);
		fallComboBox.setBounds(160, 133, 86, 20);
		contentPane.add(fallComboBox);
		
		springComboBox = new JComboBox(yesNo);
		springComboBox.setBounds(160, 158, 86, 20);
		contentPane.add(springComboBox);
		
		summerComboBox = new JComboBox(yesNo);
		summerComboBox.setBounds(160, 183, 86, 20);
		contentPane.add(summerComboBox);
		
		teacherComboBox = new JComboBox(teacherList.toArray());
		teacherComboBox.setBounds(160, 236, 86, 20);
		contentPane.add(teacherComboBox);
		
		textFieldCoursePrereq = new JTextField();
		textFieldCoursePrereq.setBounds(160, 8, 86, 20);
		contentPane.add(textFieldCoursePrereq);
		textFieldCoursePrereq.setColumns(10);
	}
	
	class StudentTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public int getRowCount() {
			return stdList.size();
		}
		public void removeRow(Course student) {
			stdList.remove(student);
			fireTableRowsDeleted(stdList.size()-1, stdList.size()-1);
		}

		public void addRow(Course student)
		{
			stdList.add(student);
			fireTableRowsInserted(stdList.size()-1, stdList.size()-1);
		}

		public void updateRow(Course student,int index)
		{
			stdList.set(index,student);
			fireTableRowsUpdated(stdList.size()-1, stdList.size()-1);
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0: return "Couse Code";
			case 1: return "Couse Name";
			case 2: return "Couse Desc";
			case 3: return "Couse Hours";
			case 4: return "Couse Cap";
			case 5: return "In Fall";
			case 6: return "In Spring";
			case 7: return "In Summer";
			case 8: return "Couse Prereq";
			case 9: return "Teachers";
			
			default: return "";
			}
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			Course student = stdList.get(rowIndex);

			switch (columnIndex) {
			case 0: return student.getCourseCode();
			case 1: return student.getCourseName();
			case 2: return student.getCourseDescription();
			case 3: return student.getCourseHours();
			case 4: return student.getCourseCap();
			case 5: return student.getCourseOfferedInFall();
			case 6: return student.getCourseOfferedInSpring();
			case 7: return student.getCourseOfferedInSummer();
			case 8: return student.getCoursePrereqs();
			case 9: return student.getCourseTeachers();
			
			default: return null;

			}
		}
		public Course getStudent(int row)
		{
			return stdList.get(row);
		}
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 10;
		}

	}
	
	
	public void readDataFromCSV()
	{
		BufferedReader fileReader = null;
		try{
			HashSet<String> hsTeachr=new HashSet<String>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("TestDataCourses.csv"));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(",");
				String courseCode="",courseName="",courseDesc="",courseHrs="", courseCap="",courseFall="",courseSpring="", courseSummer="", coursePre="",courseTeach="";
				if (tokens.length > 0) {				
					courseCode=tokens[0];
					courseName=tokens[1];
					courseDesc=tokens[2];
					courseHrs=tokens[3];
					courseCap=tokens[4];
					courseFall=tokens[5];
					courseSpring=tokens[6];
					courseSummer=tokens[7];
					coursePre=tokens[8];
					courseTeach=tokens[9];
					if(!hsTeachr.contains(courseTeach))
					{
						teacherList.add(courseTeach);
						hsTeachr.add(courseTeach);
					}
				}
				Course std=new Course(courseCode,courseName,courseDesc,courseHrs,courseCap,courseFall,courseSpring,courseSummer,coursePre,courseTeach);
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
			fileWriter = new FileWriter("TestDataCourses.csv", false);
			fileWriter.append("courseCode,courseName,courseDesc,courseHrs,courseCap,courseFall,courseSpring,courseSummer,coursePre,courseTeach");
			fileWriter.append("\n");
			for (Course student : stdList) {
				fileWriter.append(student.getCourseCode());
				fileWriter.append(",");
				fileWriter.append(student.getCourseName());
				fileWriter.append(",");
				fileWriter.append(student.getCourseDescription());
				fileWriter.append(",");
				fileWriter.append(student.getCourseHours());
				fileWriter.append(",");
				fileWriter.append(student.getCourseCap());
				fileWriter.append(",");
				fileWriter.append(student.getCourseOfferedInFall());
				fileWriter.append(",");
				fileWriter.append(student.getCourseOfferedInSpring());
				fileWriter.append(",");
				fileWriter.append(student.getCourseOfferedInSpring());
				fileWriter.append(",");
				fileWriter.append(student.getCourseOfferedInSummer());
				fileWriter.append(",");
				fileWriter.append(student.getCoursePrereqs());
				fileWriter.append(",");
				fileWriter.append(student.getCourseTeachers());
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

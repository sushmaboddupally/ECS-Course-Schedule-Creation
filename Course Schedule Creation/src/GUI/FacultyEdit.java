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

import GUI.StuCourseEdit.RowListener;
import GUI.StudentEdit.StudentTableModel;
import SOURCE.Faculty;
import SOURCE.Student;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class FacultyEdit extends JFrame {

	private JFrame contentPane;
	
	private JTextField textLastName;
	private JTextField textFirstName;
	
	JComboBox gradSchoolCombo;
	JComboBox degreeCombo;
	JComboBox titleCombo;
	JComboBox fallCombo;
	JComboBox springCombo;
	JComboBox summerCombo;
	
	JCheckBox chckbxM;
	JCheckBox chckbxT;
	JCheckBox chckbxW;
	JCheckBox chckbxTh;
	JCheckBox chckbxF;
	

	ArrayList<Faculty> stdList=new ArrayList<Faculty>();
	List<String> schoolList= new ArrayList<String>();
	List<String> degreeList= new ArrayList<String>();
	List<String> titleList= new ArrayList<String>();
	List<String> fallList= new ArrayList<String>();
	List<String> springList= new ArrayList<String>();
	List<String> summerList= new ArrayList<String>();
	
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
					FacultyEdit frame = new FacultyEdit();
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
	public FacultyEdit() {
		readDataFromCSV();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 478);
		contentPane = this;
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(33, 21, 111, 14);
		contentPane.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(33, 51, 100, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblSemester = new JLabel("Grad School");
		lblSemester.setBounds(33, 86, 100, 14);
		contentPane.add(lblSemester);
		
		JLabel lblDaysAvailable = new JLabel("Days To Teach");
		lblDaysAvailable.setBounds(34, 150, 111, 14);
		contentPane.add(lblDaysAvailable);
		
		JLabel lblCourse = new JLabel("Title");
		lblCourse.setBounds(33, 193, 63, 14);
		contentPane.add(lblCourse);
		
		JLabel lblCourse_1 = new JLabel("MaxLoadFall");
		lblCourse_1.setBounds(33, 238, 100, 14);
		contentPane.add(lblCourse_1);
		
		JLabel lblCourse_2 = new JLabel("MaxLoadSpring");
		lblCourse_2.setBounds(33, 280, 123, 14);
		contentPane.add(lblCourse_2);
		
		
		table = new JTable();
		tableModel=new StudentTableModel();
		table.setModel(tableModel);
		JScrollPane contentPane1 = new JScrollPane(table);
		contentPane1.setBounds(318, 61, 316, 252);
		contentPane.add(contentPane1);
		
		ListSelectionModel model1=table.getSelectionModel();
		model1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model1.addListSelectionListener(new RowListener());
	
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(358, 381, 87, 23);
		contentPane.add(btnCancel);
		
		chckbxM = new JCheckBox("M");
		chckbxM.setBounds(116, 146, 35, 23);
		contentPane.add(chckbxM);
		
		chckbxT = new JCheckBox("T");
		chckbxT.setBounds(151, 146, 35, 23);
		contentPane.add(chckbxT);
		
		chckbxW = new JCheckBox("W");
		chckbxW.setBounds(188, 146, 46, 23);
		contentPane.add(chckbxW);
		
		chckbxTh = new JCheckBox("TH");
		chckbxTh.setBounds(236, 146, 46, 23);
		contentPane.add(chckbxTh);
		
		chckbxF = new JCheckBox("F");
		chckbxF.setBounds(284, 146, 35, 23);
		contentPane.add(chckbxF);
		
		textLastName = new JTextField();
		textLastName.setBounds(196, 18, 86, 20);
		contentPane.add(textLastName);
		textLastName.setColumns(10);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(196, 52, 86, 20);
		contentPane.add(textFirstName);
		textFirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Degree");
		lblNewLabel.setBounds(34, 122, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMaxloadsummer = new JLabel("MaxLoadSummer");
		lblMaxloadsummer.setBounds(33, 328, 123, 14);
		contentPane.add(lblMaxloadsummer);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Faculty std= new Faculty(textLastName.getText(),textFirstName.getText(),(String)gradSchoolCombo.getSelectedItem(), (String)degreeCombo.getSelectedItem(),(String)titleCombo.getSelectedItem(),"",(String)fallCombo.getSelectedItem(),(String)springCombo.getSelectedItem(),(String)summerCombo.getSelectedItem());
				tableModel.addRow(std);
			}
		});
		btnAdd.setBounds(337, 324, 87, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Faculty std= new Faculty(textLastName.getText(),textFirstName.getText(),(String)gradSchoolCombo.getSelectedItem(), (String)degreeCombo.getSelectedItem(),(String)titleCombo.getSelectedItem(),"",(String)fallCombo.getSelectedItem(),(String)springCombo.getSelectedItem(),(String)summerCombo.getSelectedItem());
				if(table.getSelectedRow()>=0)
					tableModel.updateRow(std, table.getSelectedRow());
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for update");
			}
		});
		btnUpdate.setBounds(441, 324, 86, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0)
				{
					Faculty std= tableModel.getStudent(table.getSelectedRow());
					tableModel.removeRow(std);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for delete");  
			}
		});
		btnDelete.setBounds(537, 324, 87, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();

			}
		});
		btnSave.setBounds(214, 381, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblFacultyEdit = new JLabel("Faculty Edit");
		lblFacultyEdit.setBounds(441, 21, 86, 14);
		contentPane.add(lblFacultyEdit);
		
		gradSchoolCombo = new JComboBox(schoolList.toArray());
		gradSchoolCombo.setBounds(196, 83, 86, 20);
		contentPane.add(gradSchoolCombo);
		
		degreeCombo = new JComboBox(degreeList.toArray());
		degreeCombo.setBounds(196, 119, 86, 20);
		contentPane.add(degreeCombo);
		
		titleCombo = new JComboBox(titleList.toArray());
		titleCombo.setBounds(196, 190, 86, 20);
		contentPane.add(titleCombo);
		
		fallCombo = new JComboBox(fallList.toArray());
		fallCombo.setBounds(196, 235, 86, 20);
		contentPane.add(fallCombo);
		
		springCombo = new JComboBox(springList.toArray());
		springCombo.setBounds(196, 277, 86, 20);
		contentPane.add(springCombo);
		
		summerCombo = new JComboBox(summerList.toArray());
		summerCombo.setBounds(196, 325, 86, 20);
		contentPane.add(summerCombo);
	}
	
	
	class StudentTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public int getRowCount() {
			return stdList.size();
		}
		public void removeRow(Faculty student) {
			stdList.remove(student);
			fireTableRowsDeleted(stdList.size()-1, stdList.size()-1);
		}

		public void addRow(Faculty student)
		{
			stdList.add(student);
			fireTableRowsInserted(stdList.size()-1, stdList.size()-1);
		}

		public void updateRow(Faculty student,int index)
		{
			stdList.set(index,student);
			fireTableRowsUpdated(stdList.size()-1, stdList.size()-1);
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0: return "LastName";
			case 1: return "FirstName";
			case 2: return "Grad School";
			case 3: return "Degree";
			case 4: return "Title";
			case 5: return "DaysToTeach";
			case 6: return "Fall";
			case 7: return "Spring";
			case 8: return "Summer";
			
			default: return "";
			}
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			Faculty student = stdList.get(rowIndex);

			switch (columnIndex) {
			case 0: return student.getFacultyLastName();
			case 1: return student.getFacultyFirstName();
			case 2: return student.getFacultyGradeSchool();
			case 3: return student.getFacultyDegree();
			case 4: return student.getFacultyTitle();
			case 5: return student.getFacultyDaysToTeach();
			case 6: return student.getMaxLoadFall();
			case 7: return student.getMaxLoadSpring();
			case 8: return student.getMaxLoadSummer();
			
			default: return null;

			}
		}
		public Faculty getStudent(int row)
		{
			return stdList.get(row);
		}
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 9;
		}

	}
	
	public void readDataFromCSV()
	{
		BufferedReader fileReader = null;
		try{
			HashSet<String> hsSummer=new HashSet<String>();
			HashSet<String> hsDegree=new HashSet<String>();
			HashSet<String> hsSchool=new HashSet<String>();
			HashSet<String> hsTitle=new HashSet<String>();
			HashSet<String> hsFall=new HashSet<String>();
			HashSet<String> hsSpring=new HashSet<String>();
			
			String line = "";
			fileReader = new BufferedReader(new FileReader("TestDataFaculty.csv"));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(",");
				String lastName="",firstName="",gradSchool="",degree="",title="",days="",fall="",spring="",summer="";
				if (tokens.length > 0) {
					lastName=tokens[0];
					firstName=tokens[1];
					gradSchool=tokens[2];
					degree=tokens[3];
					System.out.println("Degree**********"+degree);
					title=tokens[4];
					days=tokens[5];
					fall=tokens[6];
					spring=tokens[7];
					summer=tokens[8];
					
					
					if(!hsSchool.contains(gradSchool))
					{
						schoolList.add(gradSchool);
						hsSchool.add(gradSchool);
					}
					if(!hsDegree.contains(degree))
					{
						degreeList.add(degree);
						hsDegree.add(degree);
					}
					if(!hsTitle.contains(title))
					{
						titleList.add(title);
						hsTitle.add(title);
					}
					if(!hsFall.contains(fall))
					{
						fallList.add(fall);
						hsFall.add(fall);
					}
					if(!hsSpring.contains(spring))
					{
						springList.add(spring);
						hsSpring.add(spring);
					}
					if(!hsSummer.contains(summer))
					{
						summerList.add(summer);
						hsSummer.add(summer);
					}
					
				}
				Faculty std=new Faculty(lastName,firstName,gradSchool,degree,title,days,fall,spring,summer);
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
			fileWriter = new FileWriter("OUTPUT3.CSV", false);
			fileWriter.append("lastName,firstName,gradSchool,degree,title,days,fall,spring,summer");
			fileWriter.append("\n");
			for (Faculty student : stdList) {
				fileWriter.append(student.getFacultyLastName());
				fileWriter.append(",");
				fileWriter.append(student.getFacultyFirstName());
				fileWriter.append(",");
				fileWriter.append(student.getFacultyGradeSchool());
				fileWriter.append(",");
				fileWriter.append(student.getFacultyDegree());
				fileWriter.append(",");
				fileWriter.append(student.getFacultyTitle());
				fileWriter.append(",");
				fileWriter.append(student.getFacultyDaysToTeach());
				fileWriter.append(",");
				fileWriter.append(student.getMaxLoadFall());
				fileWriter.append(",");
				fileWriter.append(student.getMaxLoadSpring());
				fileWriter.append(",");
				fileWriter.append(student.getMaxLoadSummer());
				
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
			String lastName="",firstName="",gradSchool="",degree="",title="",days="",fall="",spring="",summer="";
			for(int col = 0; col < columns; col++)
			{
				Object o = table.getValueAt(rowIndex, col);
				if(o!=null)
				{
				if(col==0)
					lastName=o.toString();
				else if(col==1)
					firstName=o.toString();
				else if(col==2)
					gradSchool=o.toString();
				else if(col==3)
					degree=o.toString();
				else if(col==4)
					title=o.toString();
				else if(col==5)
					days=o.toString();
				else if(col==6)
					fall=o.toString();
				else if(col==7)
					spring=o.toString();
				else if(col==8)
					summer=o.toString();
				}
			}
			
			textFirstName.setText(firstName);
			textLastName.setText(lastName);
			gradSchoolCombo.setSelectedItem(gradSchool);
			degreeCombo.setSelectedItem(degree);
			titleCombo.setSelectedItem(title);
			fallCombo.setSelectedItem(fall);
			springCombo.setSelectedItem(spring);
			summerCombo.setSelectedItem(summer);
		}
	}
	
}

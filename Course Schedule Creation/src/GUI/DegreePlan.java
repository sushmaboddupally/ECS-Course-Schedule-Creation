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
import SOURCE.Student;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.awt.event.ActionEvent;
import SOURCE.DegreeReq;

public class DegreePlan extends JFrame {

	private JFrame contentPane;
	private JTextField textDesc;
	private JTextField textHrs;
	private JTextField textCourses;
	
	ArrayList<DegreeReq> stdList=new ArrayList<DegreeReq>();
	List<String> degreeList= new ArrayList<String>();
	List<String> typeList= new ArrayList<String>();
	
	JComboBox degreeCombo;
	JComboBox typeCombo;
	
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
					DegreePlan frame = new DegreePlan();
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
	public DegreePlan() {
		readDataFromCSV();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 450);
		contentPane = this;
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.getContentPane().setLayout(null);
		
		JLabel lblDegreeCode = new JLabel("Degree Code");
		lblDegreeCode.setBounds(83, 65, 89, 14);
		contentPane.getContentPane().add(lblDegreeCode);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(84, 117, 76, 14);
		contentPane.getContentPane().add(lblNewLabel);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(84, 173, 46, 14);
		contentPane.getContentPane().add(lblHours);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setBounds(84, 229, 118, 14);
		contentPane.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setBounds(84, 286, 88, 14);
		contentPane.getContentPane().add(lblCourses);
		
		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreeReq std= new DegreeReq((String)degreeCombo.getSelectedItem(),textDesc.getText(), textHrs.getText(),(String)typeCombo.getSelectedItem());
				String arr[]=new String[]{
						textCourses.getText()
				};
				std.setDegreeReqCourses(arr);
				tableModel.addRow(std);
			}
		});
		btnSave.setBounds(350, 282, 89, 23);
		contentPane.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(382, 346, 89, 23);
		contentPane.getContentPane().add(btnCancel);
		
		textDesc = new JTextField();
		textDesc.setBounds(212, 114, 86, 20);
		contentPane.getContentPane().add(textDesc);
		textDesc.setColumns(10);
		
		textHrs = new JTextField();
		textHrs.setBounds(212, 170, 86, 20);
		contentPane.getContentPane().add(textHrs);
		textHrs.setColumns(10);
		
		degreeCombo = new JComboBox(degreeList.toArray());
		degreeCombo.setBounds(212, 226, 86, 20);
		contentPane.getContentPane().add(degreeCombo);
		
		table = new JTable();
		tableModel=new StudentTableModel();
		table.setModel(tableModel);
		JScrollPane contentPane1 = new JScrollPane(table);
		contentPane1.setBounds(335, 61, 321, 188);
		contentPane.getContentPane().add(contentPane1);
		
		ListSelectionModel model1=table.getSelectionModel();
		model1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model1.addListSelectionListener(new RowListener());
		
		
		textCourses = new JTextField();
		textCourses.setBounds(212, 283, 86, 20);
		contentPane.getContentPane().add(textCourses);
		textCourses.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DegreeReq std= new DegreeReq((String)degreeCombo.getSelectedItem(),textDesc.getText(), textHrs.getText(),(String)typeCombo.getSelectedItem());
				String arr[]=new String[]{
						textCourses.getText()
				};
				std.setDegreeReqCourses(arr);
				if(table.getSelectedRow()>=0)
					tableModel.updateRow(std, table.getSelectedRow());
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for update");
			}
		});
		btnUpdate.setBounds(455, 282, 89, 23);
		contentPane.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0)
				{
					DegreeReq std= tableModel.getStudent(table.getSelectedRow());
					tableModel.removeRow(std);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for delete");  
			}
		});
		btnDelete.setBounds(567, 282, 89, 23);
		contentPane.getContentPane().add(btnDelete);
		
		JLabel lblDegreePlan = new JLabel("Degree Plan");
		lblDegreePlan.setBounds(446, 24, 98, 14);
		contentPane.getContentPane().add(lblDegreePlan);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();

			}
		});
		btnSave_1.setBounds(235, 346, 89, 23);
		contentPane.getContentPane().add(btnSave_1);
		
		typeCombo = new JComboBox(typeList.toArray());
		typeCombo.setBounds(212, 62, 86, 20);
		contentPane.getContentPane().add(typeCombo);
	}
	public void readDataFromCSV()
	{
		BufferedReader fileReader = null;
		try{
			HashSet<String> hsDegree=new HashSet<String>();
			HashSet<String> hsType=new HashSet<String>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("TestDataDegreePlanReq.csv"));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(",");
				String degree="",desc="",hrs="",type="",courses="";
				ArrayList<String> arr=new ArrayList<String>();;
				if (tokens.length > 0) {
					
					degree=tokens[3];
					desc=tokens[1];
					hrs=tokens[2];
					type=tokens[0];
					for (int i = 4; i < tokens.length; i++) {
						arr.add(tokens[i]);
					}
					
					if(!hsDegree.contains(degree))
					{
						degreeList.add(degree);
						hsDegree.add(degree);
					}
					if(!hsType.contains(type))
					{
						typeList.add(type);
						hsType.add(type);
					}
				}
				DegreeReq std=new DegreeReq(type,desc,hrs,degree);
				//std.setDegreeReqCourses((String[]) arr.toArray());
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
			fileWriter.append("degree,desc,hrs,type,courses=");
			fileWriter.append("\n");
			for (DegreeReq student : stdList) {
				fileWriter.append(student.getDegreeReqCode());
				fileWriter.append(",");
				fileWriter.append(student.getDegreeReqdesc());
				fileWriter.append(",");
				fileWriter.append(student.getDegreeReqHours());
				fileWriter.append(",");
				fileWriter.append(student.getDegreeReqType());
				fileWriter.append(",");
				fileWriter.append(student.getDegreeReqCourses().toString());
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
		public void removeRow(DegreeReq student) {
			stdList.remove(student);
			fireTableRowsDeleted(stdList.size()-1, stdList.size()-1);
		}

		public void addRow(DegreeReq student)
		{
			stdList.add(student);
			fireTableRowsInserted(stdList.size()-1, stdList.size()-1);
		}

		public void updateRow(DegreeReq student,int index)
		{
			stdList.set(index,student);
			fireTableRowsUpdated(stdList.size()-1, stdList.size()-1);
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0: return "Degree Code";
			case 1: return "Desc.";
			case 2: return "Hours";
			case 3: return "Type";
			case 4: return "Courses";
			default: return "";
			}
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			DegreeReq student = stdList.get(rowIndex);

			switch (columnIndex) {
			case 0: return student.getDegreeReqCode();
			case 1: return student.getDegreeReqdesc();
			case 2: return student.getDegreeReqHours();
			case 3: return student.getDegreeReqType();
			case 4: return "";
			
			default: return null;

			}
		}
		public DegreeReq getStudent(int row)
		{
			return stdList.get(row);
		}
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 4;
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
			String degree="",desc="",hours="", type="", courses="";
			for(int col = 0; col < columns; col++)
			{
				Object o = table.getValueAt(rowIndex, col);
				if(col==0)
					degree=o.toString();
				else if(col==1)
					desc=o.toString();
				else if(col==2)
					hours=o.toString();
				else if(col==3)
					type=o.toString();
				else if(col==4)
					courses=o.toString();
			}
			degreeCombo.setSelectedItem(degree);
			textDesc.setText(desc);
			textHrs.setText(hours);
			typeCombo.setSelectedItem(type);
			textCourses.setText(courses);
		}
	}

}

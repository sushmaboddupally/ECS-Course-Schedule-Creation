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
import SOURCE.Degree;
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

public class DegreeReq extends JFrame {

	private JFrame contentPane;
	private JTextField txtDegreeCode;
	private JTextField txtDegreeName;
	private JTextField txtForecast;
	
	JTable table;

	StudentTableModel tableModel;
	
	JComboBox gradSchoolCombo;
	ArrayList<Degree> stdList=new ArrayList<Degree>();
	List<String> gradList= new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DegreeReq frame = new DegreeReq();
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
	public DegreeReq() {
		readDataFromCSV();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 452);
		contentPane = this;
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDgreeCode = new JLabel("Dgree Code");
		lblDgreeCode.setBounds(52, 71, 104, 14);
		contentPane.add(lblDgreeCode);
		
		JLabel lblDegreeName = new JLabel("Grad School");
		lblDegreeName.setBounds(52, 132, 104, 14);
		contentPane.add(lblDegreeName);
		
		JLabel lblDegreeName_1 = new JLabel("Degree Name");
		lblDegreeName_1.setBounds(52, 189, 79, 14);
		contentPane.add(lblDegreeName_1);
		
		JLabel lblForecast = new JLabel("Forecast");
		lblForecast.setBounds(52, 243, 77, 14);
		contentPane.add(lblForecast);
		
		txtDegreeCode = new JTextField();
		txtDegreeCode.setBounds(177, 68, 86, 20);
		contentPane.add(txtDegreeCode);
		txtDegreeCode.setColumns(10);
		
		txtDegreeName = new JTextField();
		txtDegreeName.setBounds(177, 186, 86, 20);
		contentPane.add(txtDegreeName);
		txtDegreeName.setColumns(10);
		
		txtForecast = new JTextField();
		txtForecast.setBounds(177, 240, 86, 20);
		contentPane.add(txtForecast);
		txtForecast.setColumns(10);
		
		table = new JTable();
		tableModel=new StudentTableModel();
		table.setModel(tableModel);
		JScrollPane contentPane1 = new JScrollPane(table);
		contentPane1.setBounds(320, 57, 316, 188);
		contentPane.add(contentPane1);
	
		
		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Degree std= new Degree(txtDegreeCode.getText(),(String)gradSchoolCombo.getSelectedItem(),txtDegreeName.getText(),txtForecast.getText());
				tableModel.addRow(std);
			}
		});
		btnSave.setBounds(314, 279, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(349, 332, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Degree std= new Degree(txtDegreeCode.getText(),(String)gradSchoolCombo.getSelectedItem(),txtDegreeName.getText(),txtForecast.getText());
				if(table.getSelectedRow()>=0)
					tableModel.updateRow(std, table.getSelectedRow());
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for update");
			}
		});
		btnUpdate.setBounds(430, 279, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0)
				{
					Degree std= tableModel.getStudent(table.getSelectedRow());
					tableModel.removeRow(std);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "Please select a row for delete");  
			}
		});
		btnDelete.setBounds(541, 279, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataToCSV();

			}
		});
		btnSave_1.setBounds(223, 332, 89, 23);
		contentPane.add(btnSave_1);
		
		JLabel lblDegreeEdit = new JLabel("Degree Edit");
		lblDegreeEdit.setBounds(425, 31, 79, 14);
		contentPane.add(lblDegreeEdit);
		
		gradSchoolCombo = new JComboBox(gradList.toArray());
		gradSchoolCombo.setBounds(177, 129, 86, 20);
		contentPane.add(gradSchoolCombo);
	}
	
	public void readDataFromCSV()
	{
		BufferedReader fileReader = null;
		try{
			HashSet<String> hsStdIt=new HashSet<String>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("TestDataDegrees.csv"));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(",");
				String stdId="",DptCode="",strtYear="",grade="";
				if (tokens.length > 0) {
					stdId=tokens[0];
					DptCode=tokens[1];
					strtYear=tokens[2];
					grade=tokens[3];					
					
					if(!hsStdIt.contains(DptCode))
					{
						gradList.add(DptCode);
						hsStdIt.add(DptCode);
					}
				}
				Degree std=new Degree(stdId,DptCode,strtYear,grade);
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
			fileWriter = new FileWriter("OUTPUT_DegreeReq.CSV", false);
			fileWriter.append("Degree Code,Grad School,Degree Name,Forecast");
			fileWriter.append("\n");
			for (Degree student : stdList) {
				fileWriter.append(student.getDegreeCode());
				fileWriter.append(",");
				fileWriter.append(student.getGradSchool());
				fileWriter.append(",");
				fileWriter.append(student.getDegreeName());
				fileWriter.append(",");
				fileWriter.append(student.getForescast());
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
		public void removeRow(Degree student) {
			stdList.remove(student);
			fireTableRowsDeleted(stdList.size()-1, stdList.size()-1);
		}

		public void addRow(Degree student)
		{
			stdList.add(student);
			fireTableRowsInserted(stdList.size()-1, stdList.size()-1);
		}

		public void updateRow(Degree student,int index)
		{
			stdList.set(index,student);
			fireTableRowsUpdated(stdList.size()-1, stdList.size()-1);
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0: return "Degree Code";
			case 1: return "Grad School";
			case 2: return "Degree Name";
			case 3: return "Forecast";
			default: return "";
			}
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			Degree student = stdList.get(rowIndex);

			switch (columnIndex) {
			case 0: return student.getDegreeCode();
			case 1: return student.getGradSchool();
			case 2: return student.getDegreeName();
			case 3: return student.getForescast();
			default: return null;

			}
		}
		public Degree getStudent(int row)
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
			txtDegreeCode.setText(selectedStdId);
			gradSchoolCombo.setSelectedItem(selectedDept);
			txtDegreeName.setText(selectedStrtYear);
			txtForecast.setText(selectedEndYear);
		}
	}
	
}

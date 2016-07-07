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
import SOURCE.Student;
import SOURCE.Semester;
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

public class SemesterEdit extends JFrame {

	private JFrame contentPane;
	private JTextField txtStart;
	private JTextField txtEnd;
	
	JTable table;
	
	StudentTableModel tableModel;
	
	JComboBox semester;
	ArrayList<Semester> semList=new ArrayList<Semester>();
	List<String> nameList= new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {

      public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterEdit frame = new SemesterEdit();
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
	public SemesterEdit() {
		readDataFromCSV();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 452);
		contentPane = this;
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(60, 68, 86, 14);
		contentPane.add(lblSemester);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(60, 128, 98, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(60, 181, 86, 14);
		contentPane.add(lblEndDate);
		
		semester = new JComboBox(nameList.toArray());
		semester.setBounds(173, 65, 86, 20);
		contentPane.add(semester);
		
		txtStart = new JTextField();
		txtStart.setBounds(173, 125, 86, 20);
		contentPane.add(txtStart);
		txtStart.setColumns(10);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(173, 178, 86, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);
		
		table = new JTable();
		tableModel=new StudentTableModel();
		table.setModel(tableModel);
		JScrollPane contentPane1 = new JScrollPane(table);
		contentPane1.setBounds(320, 57, 316, 188);
		contentPane.add(contentPane1);
	
		
		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Semester std= new Semester(txtStart.getText(),(String)semester.getSelectedItem(),txtEnd.getText());
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
				Semester std= new Semester(txtStart.getText(),(String)semester.getSelectedItem(),txtEnd.getText());
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
					Semester std= tableModel.getStudent(table.getSelectedRow());
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
		
		JLabel lblSmesterEdit = new JLabel("Semester Edit");
		lblSmesterEdit.setBounds(391, 21, 90, 14);
		contentPane.add(lblSmesterEdit);
	}

	public void readDataFromCSV()
	{
		BufferedReader fileReader = null;
		try{
			HashSet<String> hsStdIt=new HashSet<String>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("TestDataSemesters.csv"));
			fileReader.readLine();
			line = fileReader.readLine();
			while (line != null) {
				String[] tokens = line.split(",");
				String name="",start="",end="";
				if (tokens.length > 0) {
					name=tokens[0];
					start=tokens[1];
					end=tokens[2];					
					
					if(!hsStdIt.contains(name))
					{
						nameList.add(name);
						hsStdIt.add(name);
					}
				}
				Semester std=new Semester(start,name,end);
				semList.add(std);
				line = fileReader.readLine();
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
			fileWriter = new FileWriter("TestDataSemesters.csv", false);
			fileWriter.append("Name,Start,End");
			fileWriter.append("\n");
			for (Semester semester : semList) {
				fileWriter.append(semester.getName());
				fileWriter.append(",");
				fileWriter.append(semester.getStartDate());
				fileWriter.append(",");
				fileWriter.append(semester.getEndDate());
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
			return semList.size();
		}
		public void removeRow(Semester semester) {
			semList.remove(semester);
			fireTableRowsDeleted(semList.size()-1, semList.size()-1);
		}

		public void addRow(Semester semester)
		{
			semList.add(semester);
			fireTableRowsInserted(semList.size()-1, semList.size()-1);
		}

		public void updateRow(Semester semester,int index)
		{
			semList.set(index,semester);
			fireTableRowsUpdated(semList.size()-1, semList.size()-1);
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0: return "Name";
			case 1: return "Start";
			case 2: return "End";
			default: return "";
			}
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			Semester semester = semList.get(rowIndex);

			switch (columnIndex) {
			case 0: return semester.getName();
			case 1: return semester.getStartDate();
			case 2: return semester.getEndDate();
			default: return null;

			}
		}
		public Semester getStudent(int row)
		{
			return semList.get(row);
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
			String selectedName="",selectedStart="", selectedEnd="";
			for(int col = 0; col < columns; col++)
			{
				Object o = table.getValueAt(rowIndex, col);
				if(col==0)
					selectedName=o.toString();
				else if(col==1)
					selectedStart=o.toString();
				else if(col==2)
					selectedEnd=o.toString();
			}
			txtStart.setText(selectedName);
			semester.setSelectedItem(selectedStart);
			txtEnd.setText(selectedEnd);
			
		}
	}
	
}

	

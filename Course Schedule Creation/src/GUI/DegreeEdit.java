package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import SOURCE.University;
import SOURCE.GraduateSchool; 
import SOURCE.Degree;
import SOURCE.DegreePlanReq;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class DegreeEdit extends JPanel {
	private JTextField txtDegreecode;
	private JTextField txtName;
	private JTextField txtForecast;
	private JComboBox comboBox;
    private ArrayList<String> courses;
    private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete; 
	private DefaultListModel listModel;
	/**
	 * Create the panel.
	 */
	public DegreeEdit(JFrame currentFrame, University univ, GraduateSchool gradSchool, Degree degree, boolean isAdd ) {

		setLayout(null);
		/*courses = new ArrayList<String>();
		courses=.getDegreePlanReqs();*/
		JLabel lblDegreeEdit = new JLabel("Degree Edit");
		lblDegreeEdit.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		lblDegreeEdit.setBounds(169, 27, 161, 32);
		add(lblDegreeEdit);
		
		JLabel lblNewLabel = new JLabel("Degree Code");
		lblNewLabel.setBounds(10, 73, 84, 14);
		add(lblNewLabel);
		
		JLabel lblGradSchool = new JLabel("Grad School");
		lblGradSchool.setBounds(10, 110, 84, 14);
		add(lblGradSchool);
		
		JLabel lblDegreeName = new JLabel("Degree Name");
		lblDegreeName.setBounds(10, 147, 84, 14);
		add(lblDegreeName);
		
		JLabel lblForecast = new JLabel("Forecast");
		lblForecast.setBounds(10, 173, 84, 14);
		add(lblForecast);
		
		txtDegreecode = new JTextField(degree.getCode());
		txtDegreecode.setBounds(120, 70, 140, 20);
		add(txtDegreecode);
		txtDegreecode.setColumns(10);
		
		DefaultComboBoxModel tcList = new DefaultComboBoxModel(univ.getGradSchoolsList());
		comboBox = new JComboBox(tcList);
		
		if(!isAdd) comboBox.setSelectedItem(univ.getGradSchoolsList());
		
		comboBox.setBounds(120, 104, 134, 27);
		add(comboBox);
		
		txtName = new JTextField(degree.getName());
		txtName.setBounds(120, 144, 175, 20);
		add(txtName);
		txtName.setColumns(10);
		
		txtForecast = new JTextField(degree.getForecast());
		txtForecast.setBounds(120, 170, 86, 20);
		add(txtForecast);
		txtForecast.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isAdd && !degree.getCode().equals(txtDegreecode.getText()))
				{
					gradSchool.removeDegree(degree);
					degree.setCode(txtDegreecode.getText());
					gradSchool.addDegree(degree);
					
				}
				if (isAdd) 
				{
					degree.setCode(txtDegreecode.getText());
					gradSchool.addDegree(degree);
				}
				
				degree.setName(txtName.getText());
				degree.setGradSchool((GraduateSchool)comboBox.getSelectedItem());
							
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UniversityEdit(currentFrame,univ,gradSchool));
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DegreeList(currentFrame,univ,gradSchool));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(23, 237, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new GSCSHome(univ));
					currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(156, 237, 89, 23);
		add(btnCancel);
		
		
		JLabel lblDegreePlanRequirment = new JLabel("Degree Plan Requirment");
		lblDegreePlanRequirment.setBounds(372, 56, 161, 14);
		add(lblDegreePlanRequirment);
		
	/*	JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(326, 237, 89, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(420, 237, 89, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(519, 237, 89, 23);
		add(btnDelete);*/
		listModel = new DefaultListModel();
		//for (Entry<String, DegreePlanReq> degreePlan : gradSchool.getDegreePlans().entrySet())
		for (DegreePlanReq degreePlan : degree.getDegreePlanReqs())
		listModel.addElement(degreePlan);
		System.out.println(degree.getDegreePlanReqs());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 73, 282, 156);
		add(scrollPane);
JList list = new JList(listModel);
scrollPane.setViewportView(list);
list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
list.addListSelectionListener(new ListSelectionListener() {
	public void valueChanged(ListSelectionEvent arg0) {
	
	if (list.getSelectedValue() != null ) 
	{// System.out.println(list.getSelectedValue()); 
		btnUpdate.setEnabled(true);
	}
	if(list.getSelectedValue() == null  )
	{
		btnDelete.setEnabled(false);
	}
	else
	{
	   btnDelete.setEnabled(true);
	}
}

});

btnUpdate = new JButton("Update");
btnUpdate.setEnabled(false);
btnUpdate.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		currentFrame.getContentPane().removeAll();
		currentFrame.getContentPane().add(new DegreeEdit(currentFrame,univ, gradSchool,(Degree)list.getSelectedValue(),false));
		currentFrame.getContentPane().revalidate();
	}
});
btnUpdate.setBounds(420, 237, 89, 23);
add(btnUpdate);
btnUpdate.setEnabled(false);

//JButton
btnDelete = new JButton("Delete");
btnDelete.setEnabled(false);
btnDelete.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		gradSchool.removeDegree((Degree)list.getSelectedValue());
		listModel.removeElement(list.getSelectedValue());
	}
});
btnDelete.setBounds(519, 237, 89, 23);
add(btnDelete);
btnUpdate.setEnabled(false);


 btnAdd = new JButton("Add");
btnAdd.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		currentFrame.getContentPane().removeAll();
		currentFrame.getContentPane().add(new DegreeEdit(currentFrame,univ, gradSchool,new Degree(),true));
		currentFrame.getContentPane().revalidate();
	}
});
btnAdd.setBounds(326, 237, 89, 23);
add(btnAdd);
		
		//list.setBounds(326, 73, 282, 156);
		//add(list);
	}
}

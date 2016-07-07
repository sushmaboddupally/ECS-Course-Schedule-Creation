package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ImportStuCou extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
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
		String fileName = "STC.DUMP.CSV";
		File file = new File(fileName);
		try{
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()){
				String data = inputStream.next();
				System.out.println(data);
			}
			inputStream.close();
		   } catch (FileNotFoundException e){
			   e.printStackTrace();
		   }	
	}

}

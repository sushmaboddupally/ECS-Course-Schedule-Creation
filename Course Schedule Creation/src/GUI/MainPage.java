package GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import SOURCE.Degree;
import SOURCE.Student;
//import SOURCE.University;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainPage {

	private JFrame frame;
	
//	public static University Univ;
	public static Degree degree;
	public static Student student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//		Univ = new University();
//		Univ.openUniversity();
//		StuEdit.run(Univ);

	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMaintain = new JMenu("Maintain");
		menuBar.add(mnMaintain);
		
		JMenu mnUniversity = new JMenu("University");
		mnMaintain.add(mnUniversity);
		
		JMenuItem mntmUniversityEdit = new JMenuItem("University Edit");
		mntmUniversityEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnivEdit nw = new UnivEdit();
				nw.NewScreen();
			}
		});
		mnUniversity.add(mntmUniversityEdit);
		
		JMenuItem mntmGradSchoolEdit = new JMenuItem("Grad School Edit");
		mntmGradSchoolEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GradEdit nw = new GradEdit();
				nw.NewScreen();
			}
		});
		
		JSeparator separator_9 = new JSeparator();
		mnUniversity.add(separator_9);
		mnUniversity.add(mntmGradSchoolEdit);
		
		JSeparator separator = new JSeparator();
		mnMaintain.add(separator);
		
		JMenu mnStudentData = new JMenu("Student Data");
		mnMaintain.add(mnStudentData);
		
		JMenuItem mntmStudentData = new JMenuItem("Student Edit");
		mntmStudentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEdit nw = new StudentEdit();
				nw.NewScreen();
			}
		});
		mnStudentData.add(mntmStudentData);
		
		JSeparator separator_10 = new JSeparator();
		mnStudentData.add(separator_10);
		
		JMenuItem mntmStudentCourseData_1 = new JMenuItem("Student Course Edit");
		mntmStudentCourseData_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				StuCourseEdit nw = new StuCourseEdit();
				nw.NewScreen();
			}
		});
		mnStudentData.add(mntmStudentCourseData_1);
		
		JSeparator separator_4 = new JSeparator();
		mnMaintain.add(separator_4);
		
		JMenu mnFaculty = new JMenu("Faculty");
		mnMaintain.add(mnFaculty);
		
		JMenuItem mntmFacultiEdit = new JMenuItem("Faculty Edit");
		mntmFacultiEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyEdit nw = new FacultyEdit();
				nw.NewScreen();

			}
		});
		mnFaculty.add(mntmFacultiEdit);
		
		JSeparator separator_7 = new JSeparator();
		mnFaculty.add(separator_7);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Faculty Load");
		mnFaculty.add(mntmAdd_1);
		
		JSeparator separator_2 = new JSeparator();
		mnMaintain.add(separator_2);
		
		JMenuItem mntmCourse = new JMenuItem("Course");
		mntmCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseEdit nw = new CourseEdit();
				nw.NewScreen();

			}
		});
		mnMaintain.add(mntmCourse);
		
		JSeparator separator_3 = new JSeparator();
		mnMaintain.add(separator_3);
		
		JMenu mnDegree = new JMenu("Degree");
		mnMaintain.add(mnDegree);
		
		JMenuItem mntmDegreePlan = new JMenuItem("Degree Plan");
		mntmDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreePlan nw = new DegreePlan();
				nw.NewScreen();
			}
		});
		mnDegree.add(mntmDegreePlan);
		
		JSeparator separator_22 = new JSeparator();
		mnDegree.add(separator_22);
		
		JMenuItem mntmDegree = new JMenuItem("Degree");
		mntmDegree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreeReq nw = new DegreeReq();
				nw.NewScreen();
			}
		});
		mnDegree.add(mntmDegree);
		
		JSeparator separator_25 = new JSeparator();
		mnMaintain.add(separator_25);
		
		JMenuItem mntmSemester = new JMenuItem("Semester");
		mntmSemester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SemesterEdit nw = new SemesterEdit();
				nw.NewScreen();
				
			}
		});
		mnMaintain.add(mntmSemester);
		
		JMenu mnImport = new JMenu("Import");
		menuBar.add(mnImport);
		
		JMenuItem mntmStudent = new JMenuItem("Student Data");
		mntmStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportStu nw = new ImportStu();
				nw.NewScreen();
			}
		});
		mnImport.add(mntmStudent);
		
		JSeparator separator_8 = new JSeparator();
		mnImport.add(separator_8);
		
		JMenuItem mntmStudentCourseData = new JMenuItem("Student Course Data");
		mntmStudentCourseData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportStuCou nw = new ImportStuCou();
				nw.NewScreen();
			}
		});
		mnImport.add(mntmStudentCourseData);
		
		JMenu mnSchedule = new JMenu("Schedule");
		menuBar.add(mnSchedule);
		
		JMenuItem mntmGenerateSchedule = new JMenuItem("Generate Schedule");
		mntmGenerateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenerateSchedule nw = new GenerateSchedule();
				nw.NewScreen();
			}
		});
		mnSchedule.add(mntmGenerateSchedule);
		
		JSeparator separator_11 = new JSeparator();
		mnSchedule.add(separator_11);
		
		JMenuItem mntmTestSchedule = new JMenuItem("Test Schedule");
		mntmTestSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestSchedule nw = new TestSchedule();
				nw.NewScreen();
			}
		});
		mnSchedule.add(mntmTestSchedule);
		
		JMenu mnSystem = new JMenu("System");
		menuBar.add(mnSystem);
		
		JMenuItem mntmScheduleReport = new JMenuItem("Schedule report");
		mnSystem.add(mntmScheduleReport);
		
		JSeparator separator_12 = new JSeparator();
		mnSystem.add(separator_12);
		
		JMenuItem mntmStudentReport = new JMenuItem("Student Report");
		mnSystem.add(mntmStudentReport);
		
		JMenuItem mntmLogoff = new JMenuItem("LogOff");
		mntmLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JSeparator separator_13 = new JSeparator();
		mnSystem.add(separator_13);
		mnSystem.add(mntmLogoff);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOklahomaChristianUniversity = new JLabel("OKLAHOMA CHRISTIAN UNIVERSITY");
		lblOklahomaChristianUniversity.setBounds(105, 31, 288, 14);
		frame.getContentPane().add(lblOklahomaChristianUniversity);
	}
}

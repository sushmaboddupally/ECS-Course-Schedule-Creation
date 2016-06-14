import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainPage {

	private JFrame frame;

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
		mnUniversity.add(mntmGradSchoolEdit);
		
		JSeparator separator = new JSeparator();
		mnMaintain.add(separator);
		
		JMenu mnStudent = new JMenu("Student Data");
		mnMaintain.add(mnStudent);
		
		JMenu mnStudentEdit = new JMenu("Student Edit");
		mnStudent.add(mnStudentEdit);
		
		JMenuItem mntmAdd_5 = new JMenuItem("Add");
		mntmAdd_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEdit nw = new StudentEdit();
				nw.NewScreen();
			}
		});
		mnStudentEdit.add(mntmAdd_5);
		
		JSeparator separator_14 = new JSeparator();
		mnStudentEdit.add(separator_14);
		
		JMenuItem mntmUpdate_5 = new JMenuItem("Update");
		mntmUpdate_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//UpdateStudent nw = new UpdateStudent();
				//nw.NewScreen();
				StudentEdit nw = new StudentEdit();
				nw.NewScreen();
			}
		});
		mnStudentEdit.add(mntmUpdate_5);
		
		JSeparator separator_15 = new JSeparator();
		mnStudentEdit.add(separator_15);
		
		JMenuItem mntmDelete_5 = new JMenuItem("Delete");
		mntmDelete_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEdit nw = new StudentEdit();
				nw.NewScreen();
			}
		});
		mnStudentEdit.add(mntmDelete_5);
		
		JSeparator separator_4 = new JSeparator();
		mnStudent.add(separator_4);
		
		JMenu mnStudentCourseData = new JMenu("Student Course Data");
		mnStudent.add(mnStudentCourseData);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuCourseEdit nw = new StuCourseEdit();
				nw.NewScreen();
			}
		});
		mnStudentCourseData.add(mntmAdd);
		
		JSeparator separator_16 = new JSeparator();
		mnStudentCourseData.add(separator_16);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuCourseEdit nw = new StuCourseEdit();
				nw.NewScreen();
			}
		});
		mnStudentCourseData.add(mntmUpdate);
		
		JSeparator separator_17 = new JSeparator();
		mnStudentCourseData.add(separator_17);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuCourseEdit nw = new StuCourseEdit();
				nw.NewScreen();
			}
		});
		mnStudentCourseData.add(mntmDelete);
		
		JSeparator separator_1 = new JSeparator();
		mnMaintain.add(separator_1);
		
		JMenu mnFaculty = new JMenu("Faculty");
		mnMaintain.add(mnFaculty);
		
		JMenu mnFacultyEdit = new JMenu("Faculty Edit");
		mnFaculty.add(mnFacultyEdit);
		
		JMenuItem mntmAdd_6 = new JMenuItem("Add");
		mntmAdd_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyEdit nw = new FacultyEdit();
				nw.NewScreen();
			}
		});
		mnFacultyEdit.add(mntmAdd_6);
		
		JSeparator separator_18 = new JSeparator();
		mnFacultyEdit.add(separator_18);
		
		JMenuItem mntmUpdate_6 = new JMenuItem("Update");
		mntmUpdate_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyEdit nw = new FacultyEdit();
				nw.NewScreen();
			}
		});
		mnFacultyEdit.add(mntmUpdate_6);
		
		JSeparator separator_19 = new JSeparator();
		mnFacultyEdit.add(separator_19);
		
		JMenuItem mntmDelete_6 = new JMenuItem("Delete");
		mntmDelete_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyEdit nw = new FacultyEdit();
				nw.NewScreen();
			}
		});
		mnFacultyEdit.add(mntmDelete_6);
		
		JSeparator separator_7 = new JSeparator();
		mnFaculty.add(separator_7);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Faculty Load");
		mnFaculty.add(mntmAdd_1);
		
		JSeparator separator_5 = new JSeparator();
		mnFaculty.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		mnFaculty.add(separator_6);
		
		JSeparator separator_2 = new JSeparator();
		mnMaintain.add(separator_2);
		
		JMenu mnCourse = new JMenu("Course");
		mnMaintain.add(mnCourse);
		
		JMenuItem mntmAdd_2 = new JMenuItem("Add");
		mntmAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseEdit nw = new CourseEdit();
				nw.NewScreen();
			}
		});
		mnCourse.add(mntmAdd_2);
		
		JSeparator separator_20 = new JSeparator();
		mnCourse.add(separator_20);
		
		JMenuItem mntmUpdate_2 = new JMenuItem("Update");
		mntmUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseEdit nw = new CourseEdit();
				nw.NewScreen();
			}
		});
		mnCourse.add(mntmUpdate_2);
		
		JSeparator separator_21 = new JSeparator();
		mnCourse.add(separator_21);
		
		JMenuItem mntmDelete_2 = new JMenuItem("Delete");
		mntmDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseEdit nw = new CourseEdit();
				nw.NewScreen();
			}
		});
		mnCourse.add(mntmDelete_2);
		
		JSeparator separator_3 = new JSeparator();
		mnMaintain.add(separator_3);
		
		JMenu mnDegree = new JMenu("Degree");
		mnMaintain.add(mnDegree);
		
		JMenu mnDegreeRequirements = new JMenu("Degree Plan");
		mnDegree.add(mnDegreeRequirements);
		
		JMenuItem mntmAdd_3 = new JMenuItem("Add");
		mntmAdd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreePlan nw = new DegreePlan();
				nw.NewScreen();
			}
		});
		mnDegreeRequirements.add(mntmAdd_3);
		
		JSeparator separator_23 = new JSeparator();
		mnDegreeRequirements.add(separator_23);
		
		JMenuItem mntmUpdate_3 = new JMenuItem("Update");
		mntmUpdate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreePlan nw = new DegreePlan();
				nw.NewScreen();
			}
		});
		mnDegreeRequirements.add(mntmUpdate_3);
		
		JSeparator separator_24 = new JSeparator();
		mnDegreeRequirements.add(separator_24);
		
		JMenuItem mntmDelete_3 = new JMenuItem("Delete");
		mntmDelete_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreePlan nw = new DegreePlan();
				nw.NewScreen();
			}
		});
		mnDegreeRequirements.add(mntmDelete_3);
		
		JSeparator separator_22 = new JSeparator();
		mnDegree.add(separator_22);
		
		JMenu mnPrerequisites = new JMenu("Degree");
		mnDegree.add(mnPrerequisites);
		
		JMenuItem mntmAdd_4 = new JMenuItem("Add");
		mnPrerequisites.add(mntmAdd_4);
		
		JMenuItem mntmUpdate_4 = new JMenuItem("Update");
		mnPrerequisites.add(mntmUpdate_4);
		
		JMenuItem mntmDelete_4 = new JMenuItem("Delete");
		mnPrerequisites.add(mntmDelete_4);
		
		JSeparator separator_25 = new JSeparator();
		mnMaintain.add(separator_25);
		
		JMenu mnSemester = new JMenu("Semester");
		mnMaintain.add(mnSemester);
		
		JMenuItem mntmAdd_7 = new JMenuItem("Add");
		mntmAdd_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SemesterEdit nw = new SemesterEdit();
				nw.NewScreen();
			}
		});
		mnSemester.add(mntmAdd_7);
		
		JMenuItem mntmUpdate_1 = new JMenuItem("Update");
		mntmUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SemesterEdit nw = new SemesterEdit();
				nw.NewScreen();
			}
		});
		
		JSeparator separator_26 = new JSeparator();
		mnSemester.add(separator_26);
		mnSemester.add(mntmUpdate_1);
		
		JMenuItem mntmDelete_1 = new JMenuItem("Delete");
		mntmDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SemesterEdit nw = new SemesterEdit();
				nw.NewScreen();
			}
		});
		
		JSeparator separator_27 = new JSeparator();
		mnSemester.add(separator_27);
		mnSemester.add(mntmDelete_1);
		
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
		
		JSeparator separator_9 = new JSeparator();
		mnImport.add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		mnImport.add(separator_10);
		
		JMenu mnSchedule = new JMenu("Schedule");
		menuBar.add(mnSchedule);
		
		JMenuItem mntmGenerateSchedule = new JMenuItem("Generate Schedule");
		mnSchedule.add(mntmGenerateSchedule);
		
		JSeparator separator_11 = new JSeparator();
		mnSchedule.add(separator_11);
		
		JMenuItem mntmTestSchedule = new JMenuItem("Test Schedule");
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
		
		JLabel lblOkhlahomaChristianUniversity = new JLabel("Okhlahoma Christian University");
		lblOkhlahomaChristianUniversity.setBounds(127, 35, 255, 14);
		frame.getContentPane().add(lblOkhlahomaChristianUniversity);
	}
}
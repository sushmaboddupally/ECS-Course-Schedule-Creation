import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {

	ArrayList<Section> section;
	ArrayList<FacultyLoad> facultyLoad;
	ArrayList<Course> course;
	/**
	 * degree course teaching faculty name
	 */
	private String facultyFirstName;
	private String facultyLastName;
	

	private String maxLoadFall;
	private String maxLoadSpring;
	private String maxLoadSummer;
	
	
	GraduateSchool facultyGradeSchool;
	
	public Faculty()
	{
	/*	section = new ArrayList<String, Section>();
		facultyLoad = new ArrayList<String, FacultyLoad>();
		course = new ArrayList<String, Course>();
	*/
	}
	
	public Faculty(String facultyFirstName, String facultyLastName, String facultyGradeSchool, String maxLoadFall, String maxLoadSpring,String maxLoadSummer)
	{
		setfacultyFirstName(facultyFirstName);
		setfacultyLastName(facultyLastName);
		setfacultyGradeSchool(facultyGradeSchool);
		setmaxLoadFall(maxLoadFall);
		setmaxLoadFall(maxLoadSpring);
		setmaxLoadFall(maxLoadSummer);
		//setSSN(ssn);
	}
	
	public String getfacultyFirstName() {
		return this.facultyFirstName;
	}

	public void setfacultyFirstName(String name) {
		this.facultyFirstName = facultyFirstName;
	}
	
	public String getfacultyLastName() {
		return this.facultyLastName;
	}

	public void setfacultyLastName(String facultyLastName) {
		this.facultyFirstName = facultyFirstName;
	}

	public String getmaxLoadFall() {
		return this.maxLoadFall;
	}

	public void setmaxLoadFall(String maxLoadFall) {
		this.maxLoadFall = maxLoadFall;
	}

	/**
	 * faculty basic information
	 */
	public String faculty() {
		// TODO - implement Faculty.faculty
		throw new UnsupportedOperationException();
	}

	/**
	 * Faculty additional course list he can teach
	 */
	public String facultyTeachAdditionalSection() {
		// TODO - implement Faculty.facultyTeachAdditionalSection
		throw new UnsupportedOperationException();
	}

}
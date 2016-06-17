package SOURCE;

import java.util.ArrayList;

public class Faculty {
	private String section;
	//ArrayList<FacultyLoad> facultyLoad;
	private String  course;
	/**
	 * degree course teaching faculty name
	 */
	private String facultyFirstName;
	private String facultyLastName;
	private String maxLoadFall;
	private String maxLoadSpring;
	private String maxLoadSummer;
//	GraduateSchool facultyGradeSchool;
	
	public Faculty(String section, String course, String facultyFirstName, String facultyLastName, String maxLoadFall,
			String maxLoadSpring, String maxLoadSummer) {
		super();
		this.section = section;
		this.course = course;
		this.facultyFirstName = facultyFirstName;
		this.facultyLastName = facultyLastName;
		this.maxLoadFall = maxLoadFall;
		this.maxLoadSpring = maxLoadSpring;
		this.maxLoadSummer = maxLoadSummer;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getFacultyFirstName() {
		return facultyFirstName;
	}

	public void setFacultyFirstName(String facultyFirstName) {
		this.facultyFirstName = facultyFirstName;
	}

	public String getFacultyLastName() {
		return facultyLastName;
	}

	public void setFacultyLastName(String facultyLastName) {
		this.facultyLastName = facultyLastName;
	}

	public String getMaxLoadFall() {
		return maxLoadFall;
	}

	public void setMaxLoadFall(String maxLoadFall) {
		this.maxLoadFall = maxLoadFall;
	}

	public String getMaxLoadSpring() {
		return maxLoadSpring;
	}

	public void setMaxLoadSpring(String maxLoadSpring) {
		this.maxLoadSpring = maxLoadSpring;
	}

	public String getMaxLoadSummer() {
		return maxLoadSummer;
	}

	public void setMaxLoadSummer(String maxLoadSummer) {
		this.maxLoadSummer = maxLoadSummer;
	}
	
}

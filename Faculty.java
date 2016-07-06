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
	public String getFacultyGradeSchool() {
		return facultyGradeSchool;
	}

	public void setFacultyGradeSchool(String facultyGradeSchool) {
		this.facultyGradeSchool = facultyGradeSchool;
	}

	public String getFacultyDegree() {
		return facultyDegree;
	}

	public void setFacultyDegree(String facultyDegree) {
		this.facultyDegree = facultyDegree;
	}

	public String getFacultyDaysToTeach() {
		return facultyDaysToTeach;
	}

	public void setFacultyDaysToTeach(String facultyDaysToTeach) {
		this.facultyDaysToTeach = facultyDaysToTeach;
	}

	public String getFacultyTitle() {
		return facultyTitle;
	}

	public void setFacultyTitle(String facultyTitle) {
		this.facultyTitle = facultyTitle;
	}

	private String facultyLastName;
	private String maxLoadFall;
	private String maxLoadSpring;
	private String maxLoadSummer;
	private String facultyGradeSchool;
	private String facultyDegree;
	private String facultyDaysToTeach;
	private String facultyTitle;
	
	//GraduateSchool facultyGradeSchool;
	
//	public Faculty(String facultyLastName, String facultyFirstName, String facultyGradeSchool,
//			String facultyDegree, String facultyTitle,String facultyDaysToTeach,
//			String maxLoadFall,String maxLoadSpring, String maxLoadSummer) {
	public Faculty(String facultyLastName, String facultyFirstName,String facultyGradeSchool,String facultyDegree,
			String facultyTitle,String daysToTeach,String maxDayFall,String maxDaySpring,String maxDaySummer) {
		super();
		this.facultyFirstName = facultyFirstName;
		this.facultyLastName = facultyLastName;
		this.facultyGradeSchool = facultyGradeSchool;
		this.facultyTitle = facultyTitle;
		this.facultyDaysToTeach=daysToTeach;
		this.maxLoadFall=maxDayFall;
		this.maxLoadSpring=maxDaySpring;
		this.maxLoadSummer=maxDaySummer;
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

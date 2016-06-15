/**
 * 
 */

/**
 * @author netra
 *
 */
import java.util.*;

public class Course {

	ArrayList<Faculty> faculty;
	ArrayList<Course> preRequisit;
	//ArrayList<Course> preRequisit;

	/**
	 * course number offered in grad school
	 */
	private String courseCode;
	/**
	 * Degree course name
	 */
	private String courseName;
	/**
	 * degree course description
	 */
	private String courseDescription;
	/**
	 * credit hrs required for course to complete
	 */
	private String courseHours;
	/**
	 * Maximum cap for class
	 */
	private String courseCap;
	
	private String courseOfferedInFall;
	private String courseOfferedInSpring;
	private String courseOfferedInSummer;
	
	private String CoursePrereqs;
	private String CourseTeachers;

	public Course() {
		faculty = new ArrayList<Faculty>();
		preRequisit = new ArrayList<Course>();
	}
	
	public ArrayList<Faculty>getCourseFacultyData()
	{
		return this.faculty;
	}

	public void addCourseFaculty (Faculty facultyData)
	{
		if (facultyData != null)
		{
			getCourseFacultyData().add(facultyData);
		}
	}
	// link prerequisite course
	public ArrayList<Course>getCoursePrereqData()
	{
		return this.preRequisit;
	}

	public void addCourseFaculty (Course prereqData)
	{
		if (prereqData != null)
		{
			getCoursePrereqData().add(prereqData);
		}
	}
/*******************Adding getter and setter********************/

	/**
	 * @return the faculty
	 */
	public ArrayList<Faculty> getFaculty() {
		return faculty;
	}

	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(ArrayList<Faculty> faculty) {
		this.faculty = faculty;
	}

	/**
	 * @return the preRequisit
	 */
	public ArrayList<Course> getPreRequisit() {
		return preRequisit;
	}

	/**
	 * @param preRequisit the preRequisit to set
	 */
	public void setPreRequisit(ArrayList<Course> preRequisit) {
		this.preRequisit = preRequisit;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}

	/**
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	/**
	 * @return the courseHours
	 */
	public String getCourseHours() {
		return courseHours;
	}

	/**
	 * @param courseHours the courseHours to set
	 */
	public void setCourseHours(String courseHours) {
		this.courseHours = courseHours;
	}

	/**
	 * @return the courseCap
	 */
	public String getCourseCap() {
		return courseCap;
	}

	/**
	 * @param courseCap the courseCap to set
	 */
	public void setCourseCap(String courseCap) {
		this.courseCap = courseCap;
	}



	/**
	 * @return the coursePrereqs
	 */
	public String getCoursePrereqs() {
		return CoursePrereqs;
	}

	/**
	 * @param coursePrereqs the coursePrereqs to set
	 */
	public void setCoursePrereqs(String coursePrereqs) {
		CoursePrereqs = coursePrereqs;
	}

	/**
	 * @return the courseTeachers
	 */
	public String getCourseTeachers() {
		return CourseTeachers;
	}

	/**
	 * @param courseTeachers the courseTeachers to set
	 */
	public void setCourseTeachers(String courseTeachers) {
		CourseTeachers = courseTeachers;
	}

	/**
	 * @return the courseOfferedInFall
	 */
	public String getCourseOfferedInFall() {
		return courseOfferedInFall;
	}

	/**
	 * @param courseOfferedInFall the courseOfferedInFall to set
	 */
	public void setCourseOfferedInFall(String courseOfferedInFall) {
		this.courseOfferedInFall = courseOfferedInFall;
	}

	/**
	 * @return the courseOfferedInSpring
	 */
	public String getCourseOfferedInSpring() {
		return courseOfferedInSpring;
	}

	/**
	 * @param courseOfferedInSpring the courseOfferedInSpring to set
	 */
	public void setCourseOfferedInSpring(String courseOfferedInSpring) {
		this.courseOfferedInSpring = courseOfferedInSpring;
	}

	/**
	 * @return the courseOfferedInSummer
	 */
	public String getCourseOfferedInSummer() {
		return courseOfferedInSummer;
	}

	/**
	 * @param courseOfferedInSummer the courseOfferedInSummer to set
	 */
	public void setCourseOfferedInSummer(String courseOfferedInSummer) {
		this.courseOfferedInSummer = courseOfferedInSummer;
	}
	

}
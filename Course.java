package SOURCE;
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
	
	
	public Course(String courseCode, String courseName, String courseDescription, String courseHours, String courseCap,
			String courseOfferedInFall, String courseOfferedInSpring, String courseOfferedInSummer,
			String coursePrereqs, String courseTeachers) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseHours = courseHours;
		this.courseCap = courseCap;
		this.courseOfferedInFall = courseOfferedInFall;
		this.courseOfferedInSpring = courseOfferedInSpring;
		this.courseOfferedInSummer = courseOfferedInSummer;
		CoursePrereqs = coursePrereqs;
		CourseTeachers = courseTeachers;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseHours() {
		return courseHours;
	}
	public void setCourseHours(String courseHours) {
		this.courseHours = courseHours;
	}
	public String getCourseCap() {
		return courseCap;
	}
	public void setCourseCap(String courseCap) {
		this.courseCap = courseCap;
	}
	public String getCourseOfferedInFall() {
		return courseOfferedInFall;
	}
	public void setCourseOfferedInFall(String courseOfferedInFall) {
		this.courseOfferedInFall = courseOfferedInFall;
	}
	public String getCourseOfferedInSpring() {
		return courseOfferedInSpring;
	}
	public void setCourseOfferedInSpring(String courseOfferedInSpring) {
		this.courseOfferedInSpring = courseOfferedInSpring;
	}
	public String getCourseOfferedInSummer() {
		return courseOfferedInSummer;
	}
	public void setCourseOfferedInSummer(String courseOfferedInSummer) {
		this.courseOfferedInSummer = courseOfferedInSummer;
	}
	public String getCoursePrereqs() {
		return CoursePrereqs;
	}
	public void setCoursePrereqs(String coursePrereqs) {
		CoursePrereqs = coursePrereqs;
	}
	public String getCourseTeachers() {
		return CourseTeachers;
	}
	public void setCourseTeachers(String courseTeachers) {
		CourseTeachers = courseTeachers;
	}
	
	
}

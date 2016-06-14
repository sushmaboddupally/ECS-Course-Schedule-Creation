import java.util.*;

public class DegreeRequirements {

	Degree degree;
	ArrayList<Course> courses;
	
	private String degreeReqCode;
	private String degreeReqdesc;
	private String degreeReqHours;
	private String degreeReqType;
	private String degreeReqCourses;
	/**
	 * 
	 */
	public DegreeRequirements() {
		courses = new ArrayList<Course>();
	}
	
	public ArrayList<Course>getCourseData()
	{
		return this.courses;
	}

	public void addCourseReq (Course courseData)
	{
		if (courseData != null)
		{
			getCourseData().add(courseData);
		}
	}

	/**
	 * @return the degree
	 */
	public Degree getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	/**
	 * @return the courses
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	/**
	 * @return the degreeReqCode
	 */
	public String getDegreeReqCode() {
		return degreeReqCode;
	}

	/**
	 * @param degreeReqCode the degreeReqCode to set
	 */
	public void setDegreeReqCode(String degreeReqCode) {
		this.degreeReqCode = degreeReqCode;
	}

	/**
	 * @return the degreeReqdesc
	 */
	public String getDegreeReqdesc() {
		return degreeReqdesc;
	}

	/**
	 * @param degreeReqdesc the degreeReqdesc to set
	 */
	public void setDegreeReqdesc(String degreeReqdesc) {
		this.degreeReqdesc = degreeReqdesc;
	}

	/**
	 * @return the degreeReqHours
	 */
	public String getDegreeReqHours() {
		return degreeReqHours;
	}

	/**
	 * @param degreeReqHours the degreeReqHours to set
	 */
	public void setDegreeReqHours(String degreeReqHours) {
		this.degreeReqHours = degreeReqHours;
	}

	/**
	 * @return the degreeReqType
	 */
	public String getDegreeReqType() {
		return degreeReqType;
	}

	/**
	 * @param degreeReqType the degreeReqType to set
	 */
	public void setDegreeReqType(String degreeReqType) {
		this.degreeReqType = degreeReqType;
	}

	/**
	 * @return the degreeReqCourses
	 */
	public String getDegreeReqCourses() {
		return degreeReqCourses;
	}

	/**
	 * @param degreeReqCourses the degreeReqCourses to set
	 */
	public void setDegreeReqCourses(String degreeReqCourses) {
		this.degreeReqCourses = degreeReqCourses;
	}
	
	
	
	
	
}
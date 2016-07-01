package SOURCE;

import java.util.List;

public class CourseStudent {

	private String StudentId;
	private String courseId;
	private List studentList;
	private String faculty;
	
	/**
	 * @return the studentList
	 */
	public List getStudentList() {
		return studentList;
	}
	/**
	 * @param studentList the studentList to set
	 */
	public void setStudentList(List studentList) {
		this.studentList = studentList;
	}
	/**
	 * @return the faculty
	 */
	public String getFaculty() {
		return faculty;
	}
	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return StudentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	

}

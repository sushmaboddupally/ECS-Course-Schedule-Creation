package SOURCE;

public class StudentCompletedCourse {
	
	private String studentId;
	private String CourseCode;
	private String CourseDiscription;
	private String CourseGrade;
	private String term;
	
	public StudentCompletedCourse() {
		super();
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}

	public String getCourseDiscription() {
		return CourseDiscription;
	}

	public void setCourseDiscription(String courseDiscription) {
		CourseDiscription = courseDiscription;
	}

	public String getCourseGrade() {
		return CourseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		CourseGrade = courseGrade;
	}
	
	

}

package SOURCE;

public class Student {
	private String studentSTCId;
	private String studentDegreeCourseCode;
	private String studentDegreeDesc;
	private String studentStartYr;
	private String studentGrad;	
//	
//	private String studentSTUId;
//	private String studentGradSch;
//	private String studentEndYr;
//	 
	public Student(String studentSTCId, String studentDegreeCourseCode, String studentDegreeDesc, 
			String studentStartYr,String studentGrad) {
		super();
		this.studentSTCId = studentSTCId;
		this.studentDegreeCourseCode = studentDegreeCourseCode;
		this.studentDegreeDesc = studentDegreeDesc;
		this.studentStartYr = studentStartYr;
		this.studentGrad = studentGrad;
	}
	public String getStudentSTCId() {
		return studentSTCId;
	}
	public void setStudentSTCId(String studentSTCId) {
		this.studentSTCId = studentSTCId;
	}
	public String getStudentDegreeCourseCode() {
		return studentDegreeCourseCode;
	}
	public void setStudentDegreeCourseCode(String studentDegreeCourseCode) {
		this.studentDegreeCourseCode = studentDegreeCourseCode;
	}
	public String getStudentDegreeDesc() {
		return studentDegreeDesc;
	}
	public void setStudentDegreeDesc(String studentDegreeDesc) {
		this.studentDegreeDesc = studentDegreeDesc;
	}
	public String getStudentStartYr() {
		return studentStartYr;
	}
	public void setStudentStartYr(String studentStartYr) {
		this.studentStartYr = studentStartYr;
	}
	public String getStudentGrad() {
		return studentGrad;
	}
	public void setStudentGrad(String studentGrad) {
		this.studentGrad = studentGrad;
	}
	
	
}

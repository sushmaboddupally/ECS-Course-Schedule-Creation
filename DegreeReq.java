package SOURCE;

import java.util.ArrayList;

public class DegreeReq {
	Degree degree;
	ArrayList<Course> courses;
	
	private String degreeReqCode;
	private String degreeReqdesc;
	private String degreeReqHours;
	private String degreeReqType;
	private String degreeReqCourses;
	public DegreeReq(String degreeReqCode, String degreeReqdesc, String degreeReqHours, String degreeReqType,
			String degreeReqCourses) {
		super();
		this.degreeReqCode = degreeReqCode;
		this.degreeReqdesc = degreeReqdesc;
		this.degreeReqHours = degreeReqHours;
		this.degreeReqType = degreeReqType;
		this.degreeReqCourses = degreeReqCourses;
	}
	public String getDegreeReqCode() {
		return degreeReqCode;
	}
	public void setDegreeReqCode(String degreeReqCode) {
		this.degreeReqCode = degreeReqCode;
	}
	public String getDegreeReqdesc() {
		return degreeReqdesc;
	}
	public void setDegreeReqdesc(String degreeReqdesc) {
		this.degreeReqdesc = degreeReqdesc;
	}
	public String getDegreeReqHours() {
		return degreeReqHours;
	}
	public void setDegreeReqHours(String degreeReqHours) {
		this.degreeReqHours = degreeReqHours;
	}
	public String getDegreeReqType() {
		return degreeReqType;
	}
	public void setDegreeReqType(String degreeReqType) {
		this.degreeReqType = degreeReqType;
	}
	public String getDegreeReqCourses() {
		return degreeReqCourses;
	}
	public void setDegreeReqCourses(String degreeReqCourses) {
		this.degreeReqCourses = degreeReqCourses;
	}
	
	
	
}

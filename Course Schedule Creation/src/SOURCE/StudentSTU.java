package SOURCE;

public class StudentSTU {
	private String studentSTUId;
	private String studentGradSch;
	private String studentYrOfGrad;
	public StudentSTU(String studentSTUId, String studentGradSch, String studentYrOfGrad) {
		this.studentSTUId = studentSTUId;
		this.studentGradSch = studentGradSch;
		this.studentYrOfGrad = studentYrOfGrad;
	}

	public String getStudentSTUId() {
		return studentSTUId;
	}

	public void setStudentSTUId(String studentSTUId) {
		this.studentSTUId = studentSTUId;
	}

	public String getStudentGradSch() {
		return studentGradSch;
	}

	public void setStudentGradSch(String studentGradSch) {
		this.studentGradSch = studentGradSch;
	}

	public String getStudentYrOfGrad() {
		return studentYrOfGrad;
	}

	public void setStudentYrOfGrad(String studentYrOfGrad) {
		this.studentYrOfGrad = studentYrOfGrad;
	}
	
}

/**
 * 
 */

/**
 * @author netra
 *
 */
import java.util.*;

/**
 * Student attend lecture
 */
public class Section {

	ArrayList<Student> students;
	Schedule schedule;
	Faculty faculty;
	/**
	 * section number allocated for the course
	 */
	private String number;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * number of student in a section
	 */
	public String numberStudents() {
		// TODO - implement Section.numberStudents
		throw new UnsupportedOperationException();
	}

	/**
	 * maximum number per section allotted
	 */
	public String calcPerCentCap() {
		// TODO - implement Section.calcPerCentCap
		throw new UnsupportedOperationException();
	}

	/**
	 * section service function
	 */
	public Section() {
		// TODO - implement Section.Section
		throw new UnsupportedOperationException();
	}

}
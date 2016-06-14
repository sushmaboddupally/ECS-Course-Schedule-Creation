/**
 * 
 */

/**
 * @author netra
 *
 */
/**
 * A Semester is a period of time that a set of course is offered.  
 */
public class Semester {

	Schedule schedule;
	/**
	 * semester start data
	 */
	private String startDate;
	/**
	 * semester name
	 */
	private String name;
	/**
	 * semester end data
	 */
	private String endDate;

	/**
	 * service to provide semester data
	 */
	public String semester() {
		// TODO - implement Semester.semester
		throw new UnsupportedOperationException();
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(string startDate) {
		this.startDate = startDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}

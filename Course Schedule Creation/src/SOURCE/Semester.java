package SOURCE;

public class Semester {
//	Schedule schedule;
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
	public Semester(String startDate, String name, String endDate) {
		super();
		this.startDate = startDate;
		this.name = name;
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}

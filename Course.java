/**
 * 
 */

/**
 * @author netra
 *
 */
import java.util.*;

public class Course {

	ArrayList<Faculty> faculty;
	Course preRequisit;
	/**
	 * course number offered in grad school
	 */
	private int number;
	/**
	 * Degree course name
	 */
	private String name;
	/**
	 * degree course description
	 */
	private String description;
	/**
	 * credit hrs required for course to complete
	 */
	private String creditHours;
	/**
	 * Maximum cap for class
	 */
	private int classCap;

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(string description) {
		this.description = description;
	}

	public String getCreditHours() {
		return this.creditHours;
	}

	public void setCreditHours(String creditHours) {
		this.creditHours = creditHours;
	}

	public int getClassCap() {
		return this.classCap;
	}

	public void setClassCap(int classCap) {
		this.classCap = classCap;
	}

	/**
	 * Service to provide course information's
	 */
	public String course() {
		// TODO - implement Course.course
		throw new UnsupportedOperationException();
	}

}
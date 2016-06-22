import java.util.*;

/**
 * Grad School offers many degree courses
 */
public class GraduateSchool {
	private String name;
	private String abbrevation;
	//ArrayList<Student> student;
//	University university;
	//ArrayList<Student> students;
//	ArrayList<Degree> degreePlan;
//	ArrayList<Faculty> faculties;
	ArrayList<Degree> degreeList;       //Added
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return this.abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	
	public GraduateSchool() {
		
		degreeList = new ArrayList<Degree>();
	}
	
	public ArrayList<Degree> getDegreeList()
	{
		return this.degreeList;
	}
	
	public void addDegree (Degree degreeElement)
	{
		if (degreeElement != null)
		{
			getDegreeList().add(degreeElement);
		}
	}

}
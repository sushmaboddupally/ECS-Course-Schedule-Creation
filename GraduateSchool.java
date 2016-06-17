package SOURCE;

import java.util.ArrayList;

//import USM.Degree;

public class GraduateSchool {
	private String name;
	private String abbrevation;
	ArrayList<Degree> degreeList; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}
	public GraduateSchool(String name, String abbrevation) {
		super();
		this.name = name;
		this.abbrevation = abbrevation;
	}

}

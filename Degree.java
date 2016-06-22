package SOURCE;

import java.util.ArrayList;
import java.util.*;
//import USM.DegreeRequirements;

public class Degree {
ArrayList<DegreeReq> degreeReq;
	
	private String degreeCode;
	
	private String gradSchool;
	
	private String degreeName;
	
	private String forescast;

	public Degree(String degreeCode, String gradSchool, String degreeName, String forescast) {
		super();
		this.degreeCode = degreeCode;
		this.gradSchool = gradSchool;
		this.degreeName = degreeName;
		this.forescast = forescast;
	}

	public String getDegreeCode() {
		return degreeCode;
	}

	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}

	public String getGradSchool() {
		return gradSchool;
	}

	public void setGradSchool(String gradSchool) {
		this.gradSchool = gradSchool;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getForescast() {
		return forescast;
	}

	public void setForescast(String forescast) {
		this.forescast = forescast;
	}
	
	

}

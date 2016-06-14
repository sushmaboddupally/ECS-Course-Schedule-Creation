import java.util.*;

/**
 * Grad school degree department data
 */
public class Degree {

	ArrayList<DegreeRequirements> degreeReq;
	
	private String degreeCode;
	
	private String gradSchool;
	
	private String degreeName;
	
	private String forescast;

	/**
	 * 
	 */
	public Degree() {
		degreeReq = new ArrayList<DegreeRequirements>();
	}
	
	public ArrayList<DegreeRequirements>getDegreeData ()
	{
		return this.degreeReq;
	}

	public void addDegreeReq (DegreeRequirements degreeReqElement)
	{
		if (degreeReqElement != null)
		{
			getDegreeData().add(degreeReqElement);
		}
	}

	/**
	 * @return the degreeReq
	 */
	public ArrayList<DegreeRequirements> getDegreeReq() {
		return degreeReq;
	}

	/**
	 * @param degreeReq the degreeReq to set
	 */
	public void setDegreeReq(ArrayList<DegreeRequirements> degreeReq) {
		this.degreeReq = degreeReq;
	}

	/**
	 * @return the degreeCode
	 */
	public String getDegreeCode() {
		return degreeCode;
	}

	/**
	 * @param degreeCode the degreeCode to set
	 */
	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}

	/**
	 * @return the gradSchool
	 */
	public String getGradSchool() {
		return gradSchool;
	}

	/**
	 * @param gradSchool the gradSchool to set
	 */
	public void setGradSchool(String gradSchool) {
		this.gradSchool = gradSchool;
	}

	/**
	 * @return the degreeName
	 */
	public String getDegreeName() {
		return degreeName;
	}

	/**
	 * @param degreeName the degreeName to set
	 */
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	/**
	 * @return the forescast
	 */
	public String getForescast() {
		return forescast;
	}

	/**
	 * @param forescast the forescast to set
	 */
	public void setForescast(String forescast) {
		this.forescast = forescast;
	}

	

}
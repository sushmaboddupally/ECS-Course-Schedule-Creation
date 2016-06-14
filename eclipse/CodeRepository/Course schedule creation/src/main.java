/**
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author netra
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		String fileName ="TestDataDegrees.csv";
		String line = null;
		String[] token;
		//String dataType; 
		try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	        new FileReader(fileName);
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	        new BufferedReader(fileReader);
	        //while there is data in file do this
	        Scanner inputSteam = new Scanner(fileReader);
	        inputSteam.hasNext();
	        while((line = bufferedReader.readLine()) != null)
	        {
	        	DegreeRequirements gradSchool = new DegreeRequirements();
	        		//split data by comma
		        	token = line.split(",");
		        	//dataType = token[0];
		        	gradSchool.setDegreeReqCode(token[0]); 
		        	gradSchool.setDegreeReqdesc(token[1]);
		        	gradSchool.setDegreeReqHours(token[2]);
		        	gradSchool.setDegreeReqType(token[3]);
		        	gradSchool.setDegreeReqCourses(token[4]);
		        	/**
		        	 * Determined by data type of the token, variables are set. For 
		        	 * example if it is "Store", it has to be name of the store. However, if it 
		        	 * is "Cashier", it is all info about the current cashier and so on. 
		        	 */
		        	System.out.println(gradSchool.getDegreeReqCode());
		        	System.out.println(gradSchool.getDegreeReqdesc());
		        	System.out.println(gradSchool.getDegreeReqHours());
		        	System.out.println(gradSchool.getDegreeReqType());
		        	System.out.println(gradSchool.getDegreeReqCourses());
	        }
	      
		}
		 catch(FileNotFoundException ex) 
	    {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    } catch(IOException ex) {
	        System.out.println(
	                "Error reading file '" 
	                + fileName + "'");   	
	    	
	    	}
	}		 
}

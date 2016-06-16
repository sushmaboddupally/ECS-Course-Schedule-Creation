/**
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		String fileName ="TestDataCourses.csv";
		String line = null;
		String[] token;
		ArrayList<Course> CoursesData;
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
	       // inputSteam.hasNext();
	        while((line = bufferedReader.readLine()) != null)
	        {
	        	Course gradSchool = new Course();
	        		//split data by comma
		        	token = line.split(",");
		        	//dataType = token[0];
		        	gradSchool.setCourseCode(token[0]); 
		        	gradSchool.setCourseName(token[1]);
		        	gradSchool.setCourseDescription(token[2]);
		        	gradSchool.setCourseHours(token[3]);
		        	gradSchool.setCourseCap(token[4]);
		        	gradSchool.setCourseOfferedInFall(token[5]);
		        	gradSchool.setCourseOfferedInSpring(token[6]);
		        	gradSchool.setCourseOfferedInSummer(token[7]);
		        	
		        	
		        	/**
		        	 * Determined by data type of the token, variables are set. For 
		        	 * example if it is "Store", it has to be name of the store. However, if it 
		        	 * is "Cashier", it is all info about the current cashier and so on. 
		        	 */
		        	System.out.println(gradSchool.getCourseCode());
		        	System.out.println(gradSchool.getCourseName());
		        	System.out.println(gradSchool.getCourseDescription());
		        	System.out.println(gradSchool.getCourseHours());
		        	System.out.println(gradSchool.getCourseCap());
		        	
		        	System.out.println(gradSchool.getCourseOfferedInFall());
		        	System.out.println(gradSchool.getCourseOfferedInSpring());
		        	System.out.println(gradSchool.getCourseOfferedInSummer());
		        	
	        }
	        bufferedReader.close();
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

/**
 * 
 */
package SDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import USM.Course;
import USM.Degree;
import USM.Faculty;
import USM.DegreeRequirements;
import USM.Student;
import USM.University;
import USM.Student;
import USM.GraduateSchool;
/**
 * @author netra
 *
 */
public class Schedule {
	public  void loadUniversity(University university)
	{
		this.initCourseData();
		
		
	}
//		//String fileName ="StoreData.csv";
//		String fileName ="TestDataGradSchool.csv";
//		String line = null;
//		String[] token;
//		String dataType; 
//		//Session currentSession = null;
//		//Sale currentSale = null;
//		
//	    try { 
//	        // FileReader reads text files in the default encoding.
//	        FileReader fileReader = 
//	            new FileReader(fileName);
//
//	        // Always wrap FileReader in BufferedReader.
//	        BufferedReader bufferedReader = 
//	            new BufferedReader(fileReader);
//	        //while there is data in file do this
//	        while((line = bufferedReader.readLine()) != null) 
//	        {
//	        		//split data by comma
//		        	token = line.split(",");
//		        	dataType = token[0];
//		        	/**
//		        	 * Determined by data type of the token, variables are set. For 
//		        	 * example if it is "Store", it has to be name of the store. However, if it 
//		        	 * is "Cashier", it is all info about the current cashier and so on. 
//		        	 */
//		        	GraduateSchool grad = new GraduateSchool(token[0],token[1]);
//	        		//storePerson.setCashier(storeCashier);
//		        	university.addGraduateSchool(grad);
//	        				        		
//		        	}	       
//
//	        // Always close files.
//	        bufferedReader.close();            
//	    }
//	    catch(FileNotFoundException ex) 
//	    {
//	        System.out.println(
//	            "Unable to open file '" + 
//	            fileName + "'");                
//	    }
//	    catch(IOException ex) {
//	        System.out.println(
//	            "Error reading file '" 
//	            + fileName + "'");   	
//		
//		}
//	}

/********************************************************************************/
	
	public void initCourseData()
	{	
		String fileName ="TestDataCourses.csv";
		Course course = new Course();
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
	        //inputSteam.hasNext();
	        while((line = bufferedReader.readLine()) != null)
	        {
	        	//Course gradSchool = new Course();
	        		//split data by comma
		        	token = line.split(",");
		        	//dataType = token[0];
		        	course.setCourseCode(token[0]); 
		        	course.setCourseName(token[1]);
		        	course.setCourseDescription(token[2]);
		        	course.setCourseHours(token[3]);
		        	course.setCourseCap(token[4]);
		        	course.setCourseOfferedInFall(token[5]);
		        	course.setCourseOfferedInSpring(token[6]);
		        	course.setCourseOfferedInSummer(token[7]);
		        	/**
		        	 * Determined by data type of the token, variables are set. For 
		        	 * example if it is "Store", it has to be name of the store. However, if it 
		        	 * is "Cashier", it is all info about the current cashier and so on. 
		        	 */
		        	System.out.println(course.getCourseCode());
		        	System.out.println(course.getCourseName());
		        	System.out.println(course.getCourseDescription());
		        	System.out.println(course.getCourseHours());
		        	System.out.println(course.getCourseCap());
		        	
		        	System.out.println(course.getCourseOfferedInFall());
		        	System.out.println(course.getCourseOfferedInSpring());
		        	System.out.println(course.getCourseOfferedInSummer());
		        	
	        }
	        bufferedReader.close();
		}
		 catch(FileNotFoundException ex) 
	    {
	        System.out.println(
	            "Unable to open file course'" + 
	            fileName + "'");                
	    } catch(IOException ex) {
	        System.out.println(
	                "Error reading file course '" 
	                + fileName + "'");   	
	    	
	    	}
}		 
	
/*****************************************************************************/
	
	public void initGradSchoolData()
	{	
		String fileName ="TestDataGradSchools.csv";
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
	        //inputSteam.hasNext();
	        while((line = bufferedReader.readLine()) != null)
	        {
	        		GraduateSchool gradSchool = new GraduateSchool();
	        		//split data by comma
		        	token = line.split(",");
		        	//dataType = token[0];
		        	gradSchool.setAbbrevation(token[0]); 
		        	gradSchool.setName(token[1]); 
		        	/**
		        	 * Determined by data type of the token, variables are set. For 
		        	 * example if it is "Store", it has to be name of the store. However, if it 
		        	 * is "Cashier", it is all info about the current cashier and so on. 
		        	 */
		        	System.out.println(gradSchool.getAbbrevation());
					System.out.println(gradSchool.getName());
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

/*************************************************************************************/	
	
	public void initDegereeData()
	{	
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
	        	Degree degree = new Degree();
	        		//split data by comma
		        	token = line.split(",");
		        	//dataType = token[0];
		        	degree.setDegreeCode(token[0]); 
		        	degree.setGradSchool(token[1]);
		        	degree.setDegreeName(token[2]);
		        	degree.setForescast(token[3]);
		        	/**
		        	 * Determined by data type of the token, variables are set. For 
		        	 * example if it is "Store", it has to be name of the store. However, if it 
		        	 * is "Cashier", it is all info about the current cashier and so on. 
		        	 */
		        	System.out.println(degree.getDegreeCode());
		        	System.out.println(degree.getGradSchool());
		        	System.out.println(degree.getDegreeName());
		        	System.out.println(degree.getForescast());
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
	
/***************************************************************************************************/	

}

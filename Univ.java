package UnivDM;
import SOURCE.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import java.io.*;
import java.util.Scanner;

public class Univ {
	public static void loadUniversity(University university)
	{		
	//	String fileName ="TestDataFaculty.csv";
		//String fileName ="TestDataGradSchools.csv";
		String fileName ="TestDataCourses.csv";
		//String fileName ="TestDataDegrees.csv";
//		String fileName ="TestDataDegreePlanReq.csv";
	//	String fileName ="TestDataSemesters.csv";
		String line = null;
		String[] token;
		String dataType; 
		//Session currentSession = null;
		//Sale currentSale = null;
		
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
	        		//split data by comma
		        	token = line.split(",");
		        	dataType = token[0];
		        	/**
		        	 * Determined by data type of the token, variables are set. For 
		        	 * example if it is "Store", it has to be name of the store. However, if it 
		        	 * is "Cashier", it is all info about the current cashier and so on. 
		        	 */
//		        	GraduateSchool grad = new GraduateSchool(token[0],token[1]);			//For GradSchoolData
//	        		university.addGraduateSchool(grad);
		        	
//		        	Faculty faculty = new Faculty(token[0],token[1],token[2],token[3],token[4],token[5],token[6]);			//For Faculty
//		        	university.addFculty(faculty);
		        	
//		        	GraduateSchool gradSchool = new GraduateSchool(token[0],token[1]);			//For Faculty
//		        	university.addGradSchool(gradSchool);
		        	
		        	Course course = 
		        			new Course(token[0],token[1],token[2],token[3],token[4],
		        					token[5],token[6],token[7],token[8],token[9]);			//For Faculty
		        	university.addCourse(course);
		        	
//		        	Degree degree = new Degree(token[0],token[1],token[2],token[3]);			//For Faculty
//		        	university.addDegree(degree);
		        	
//		        	DegreeReq degreeReq = new DegreeReq(token[0],token[1],token[2],token[3],token[4]);			//For Faculty
//		        	university.addDegreeReq(degreeReq);
		        	
//		        	Semester semester = new Semester(token[0],token[1],token[2]);			//For Faculty
//		        	university.addSemester(semester);
	        				        		
		        	}	       

	        // Always close files.
	        bufferedReader.close();            
	    }
	    catch(FileNotFoundException ex) 
	    {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    }
	    catch(IOException ex) {
	        System.out.println(
	            "Error reading file '" 
	            + fileName + "'");   	
		
		}
	}
}

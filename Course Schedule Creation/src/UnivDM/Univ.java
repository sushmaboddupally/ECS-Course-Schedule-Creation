package UnivDM;
import SOURCE.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Univ {
	public static void loadUniversity(University university)
	{		
		String fileName ="TestDataUniversityName.csv";
		
		String line = null;
		String[] token;
		String dataType; 
		 Scanner inputSteam = null;
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
	        //inputSteam.hasNext();
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
		        	university.setName(token[0]);
		        	university.setNumber(token[1]);
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
	    finally{
	    	inputSteam.close();
	    }
	}
	
	public static void loadUniversityFaculty(University universityFaculty)
	{		
		String fileName ="TestDataFaculty.csv";
		
		String line = null;
		String[] token;
		String dataType; 
		Scanner inputSteam = null;
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
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
		        	
		        	/*Faculty faculty = new Faculty(token[0],token[1],token[2],token[3],token[4]);//For Faculty
		        	universityFaculty.addFculty(faculty);*/
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
	    finally{
	    	inputSteam.close();
	    }
	}
	
	public static void loadUniversityCourse(University universityCourse)
	{		
		String fileName ="TestDataCourses.csv";
		
		String line = null;
		String[] token;
		String dataType; 
		//Session currentSession = null;
		//Sale currentSale = null;
		Scanner inputSteam = null;
		
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
	        inputSteam.hasNext();
	        while(inputSteam.hasNext()) 
	        {
	        	line = inputSteam.nextLine();
	        		//split data by comma
		        	token = line.split(",");
		        	
		        	Course course = 
		        			new Course(token[0],token[1],token[2],token[3],token[4],
		        					token[5],token[6],token[7],token[8],token[9]);
		        	//System.out.println("Token 9 "+token[9]);
		        	//courseList.add(course);
		        	
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
	    finally{
	    	inputSteam.close();
	    }
	}
	
	public static void loadUniversityGradSchool(University universityGradSch)
	{		
		String fileName ="TestDataGradSchools.csv";
		
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
	       // inputSteam.hasNext();
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
		        	GraduateSchool gradSchool = new GraduateSchool(token[0],token[1]);			//For Faculty
		        	universityGradSch.addGradSchool(gradSchool);
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
	
	public static void loadUniversityDegree(University universityDegree)
	{		
		String fileName ="TestDataDegrees.csv";		
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
		        	
		        	Degree degree = new Degree(token[0],token[1],token[2],token[3]);			//For Faculty
		        	universityDegree.addDegree(degree);
		        	        				        		
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
	
	
	public static void loadUniversityDegreeReq(University universityDegreeReq)
	{		
		String fileName ="TestDataDegreePlanReq.csv";		
		String line = null;
		String line1 = null;
		String[] token;
		String[] token1;
		String dataType; 
		Scanner inputSteam = null;
		
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
		        inputSteam = new Scanner(fileReader);
		        inputSteam.nextLine();
		        while(inputSteam.hasNext()) 
		        {
		        	 line = inputSteam.nextLine();
			         token = line.split(",");
			         token1 = line.split("\"");
			         List<String> elephantList = Arrays.asList(token1[1].split(","));
	 		         DegreeReq degreereq = new DegreeReq(token[1],token[0],token[2],token[3]);
			         degreereq.setDegreeReqList(elephantList);
			        
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
	
	public static void loadUniversitySemester(University universitySemester)
	{		
		String fileName ="TestDataSemesters.csv";	
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
	        //inputSteam.hasNext();
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
		        	Semester semester = new Semester(token[0],token[1],token[2]);			//For Faculty
		        	universitySemester.addSemester(semester);
	        				        		
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
	
	public static void loadUniversityStudent(University universityStudent)
	{		
		String fileName ="Students.csv";		
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

		        	Student student = new Student(token[0],token[1],token[2],token[3],token[4]);			//For Faculty
		        	universityStudent.addStudent(student);	        				        		
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
	
	public static void loadUniversityStudentSTU(University universityStudentSTU)
	{		
		String fileName ="Students.csv";		
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
		        	
		        	StudentSTU student = new StudentSTU(token[0],token[1],token[2]);
		        	
		        	universityStudentSTU.getStudentList().add(student);
		        	//universityStudentSTU.addStudentSTU(student);	        				        		
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

package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import SOURCE.Course;
import SOURCE.Degree;
import SOURCE.Faculty;
import SOURCE.FacultyReport;
import SOURCE.Semester;
import SOURCE.StudentCourse;
import SOURCE.StudentReport;
import SOURCE.Studentd;
import SOURCE.University;

public class GenerateReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadUniversityCourse();
		/*String str = "Donnt,Doug";
		System.out.println(str.contains("Doug"));*/
	}
	
	public static void loadUniversityCourse()
	{		
		String fileName ="TestDataCourses.csv";
		
		String line = null;
		String[] token;
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
	        boolean fall = false;
        	boolean spr = false;
        	boolean summer = false;
        	List<Course> courseList = new ArrayList<Course>();
	        while(inputSteam.hasNext()) 
	        {
	        	line = inputSteam.nextLine();
	        		//split data by comma
		        	token = line.split(",");
		        	
		        	Course course = 
		        			new Course(token[0],token[1],token[2],token[3],token[4],
		        					token[5],token[6],token[7],token[8],token[9]);
		        	System.out.println("Token 9 "+token[9]);
		        	courseList.add(course);
		        	
		        	}
	        List<Faculty> facultyList = loadUniversityFaculty();
        	List<FacultyReport> facultyReportList = new ArrayList<FacultyReport>();
        	for(Course course : courseList){
        	for(Faculty f : facultyList){
        		FacultyReport fr = new FacultyReport();
        		if(course.getCourseTeachers().contains(f.getFacultyLastName())){
        			fr.setProfessor(f.getFacultyLastName());
        		}
        			
        			if(course.getCourseOfferedInFall().equalsIgnoreCase("Y")){
        				fall = true;
        			}
        			if(course.getCourseOfferedInSpring().equalsIgnoreCase("Y")){
        				spr= true;
        			}
        			if(course.getCourseOfferedInSummer().equalsIgnoreCase("Y")){
        				summer=true;
        			}
        			
        			fr.setCourseCode(course.getCourseCode());
        			fr.setCourseName(course.getCourseName());
        			fr.setGradeSchool(f.getFacultyGradeSchool());
        			fr.setMaxStudents(course.getCourseCap());
        			if(fall && spr && summer){
        				fr.setTerm("FALL");
        				fr.setMaxLoad(f.getMaxLoadFall());
        				facultyReportList.add(fr);
        				fr.setTerm("SPRING");
        				fr.setMaxLoad(f.getMaxLoadSpring());
        				facultyReportList.add(fr);
        				fr.setTerm("SUMMER");
        				fr.setMaxLoad(f.getMaxLoadSummer());
        				facultyReportList.add(fr);
        			}else if(fall && spr){
        				fr.setTerm("FALL");
        				fr.setMaxLoad(f.getMaxLoadFall());
        				facultyReportList.add(fr);
        				fr.setTerm("SPRING");
        				fr.setMaxLoad(f.getMaxLoadSpring());
        				facultyReportList.add(fr);
        			}else if(spr && summer){
        				fr.setTerm("SPRING");
        				fr.setMaxLoad(f.getMaxLoadSpring());
        				facultyReportList.add(fr);
        				fr.setTerm("SUMMER");
        				fr.setMaxLoad(f.getMaxLoadSummer());
        				facultyReportList.add(fr);
        			}else if(summer && fall){
        				fr.setTerm("FALL");
        				fr.setMaxLoad(f.getMaxLoadFall());
        				facultyReportList.add(fr);
        				fr.setTerm("SUMMER");
        				fr.setMaxLoad(f.getMaxLoadSummer());
        				facultyReportList.add(fr);
        			}else if(fall){
        				fr.setTerm("FALL");
        				fr.setMaxLoad(f.getMaxLoadFall());
        				facultyReportList.add(fr);
        			}else if(spr){
        				fr.setTerm("SPRING");
        				fr.setMaxLoad(f.getMaxLoadSpring());
        				facultyReportList.add(fr);
        			}else if(summer){
        				fr.setTerm("SUMMER");
        				fr.setMaxLoad(f.getMaxLoadSummer());
        				facultyReportList.add(fr);
        			}
        		}
        	}
        	
        	System.out.println("Faculty Report Size "+facultyReportList.size());

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
	
	public static List loadUniversityFaculty()
	{		
		String fileName ="Faculty.csv";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
		List<Faculty> facultyList = new ArrayList<Faculty>();
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
	        while(inputSteam.hasNext()) 
	        {
	        		//split data by comma
	        	 line = inputSteam.nextLine();
		        	token = line.split(",");
		        	/**
		        	 * Determined by data type of the token, variables are set. For 
		        	 * example if it is "Store", it has to be name of the store. However, if it 
		        	 * is "Cashier", it is all info about the current cashier and so on. 
		        	 */
		        	Faculty faculty = new Faculty(token[0],token[1],token[2],token[3],token[4],token[5],token[6],token[7],token[8]);//For Faculty
		        	facultyList.add(faculty);
		        	//universityFaculty.addFculty(faculty);
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
	    return facultyList;
	}
	
	public static void load()
	{		
		String fileName ="Students1.csv";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);
	        Map map = new HashMap();
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
	        while(inputSteam.hasNext()) 
	        {
	        		//split data by comma
	        	 line = inputSteam.nextLine();
		        	token = line.split(",");
		        	Studentd stu = new Studentd();
		        	stu.setStudentId(token[0]);
		        	stu.setDegree(token[1]);
		        	stu.setSemester(token[2]);
		        	
		        	map.put(token[0],stu);
		        	//universityFaculty.addFculty(faculty);
		       }	       
	        
	        // Always close files.
	        bufferedReader.close();  
	        List<StudentCourse> stuCourseList = loadStudentCourse();
	        for(StudentCourse stuCourse : stuCourseList){
	        	{
	        		Set keys = map.keySet();
	        	    for (Iterator i = keys.iterator(); i.hasNext();) {
	        	      Integer key = (Integer) i.next();
	        	      String value = (String) map.get(key);
	        	      if(stuCourse.getStudentId().equalsIgnoreCase(value)){
	        	    	  
	        	      }
	        	    }
	        	
	        		
	        	}
	        }
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
	public static List loadStudentCourse()
	{		
		String fileName ="StudentCourse.csv";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
		List<StudentCourse> studCourseList = new ArrayList<StudentCourse>();
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
	        while(inputSteam.hasNext()) 
	        {
	        		//split data by comma
	        	 line = inputSteam.nextLine();
		        	token = line.split(",");
		        	/**
		        	 * Determined by data type of the token, variables are set. For 
		        	 * example if it is "Store", it has to be name of the store. However, if it 
		        	 * is "Cashier", it is all info about the current cashier and so on. 
		        	 */
		        	StudentCourse stuCourse = new StudentCourse();
		        	studCourseList.add(stuCourse);
		        	//universityFaculty.addFculty(faculty);
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
	    return studCourseList;
	}
	
	public static void loadStudents()
	{		
		String fileName ="Students1.csv";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);
	        Map map = new HashMap();
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
	        while(inputSteam.hasNext()) 
	        {
	        		//split data by comma
	        	 line = inputSteam.nextLine();
		        	token = line.split(",");
		        	Studentd stu = new Studentd();
		        	stu.setStudentId(token[0]);
		        	stu.setDegree(token[1]);
		        	stu.setSemester(token[2]);
		        	
		        	map.put(token[0],stu);
		        	//universityFaculty.addFculty(faculty);
		       }	       
	        
	        // Always close files.
	        bufferedReader.close();  
	        List<StudentCourse> stuCourseList = loadStudentCourse();
	        List<StudentReport> stuReportList = new ArrayList<StudentReport>();
	        for(StudentCourse stuCourse : stuCourseList){
	        	{
	        		Set keys = map.keySet();
	        	    for (Iterator i = keys.iterator(); i.hasNext();) {
	        	      String key = (String) i.next();
	        	      Studentd value = (Studentd) map.get(key);
	        	      if(stuCourse.getStudentId().equalsIgnoreCase(value.getStudentId())){
	        	    	  Map degreeMap = loadDegrees();
	        	    	  Degree d= (Degree) degreeMap.get(value.getDegree());
	        	    	  StudentReport stuReport = new StudentReport();
	        	    	  stuReport.setNoofStudents(value.getStudentId());
	        	    	  stuReport.setGradeSchool(d.getGradSchool());
	        	    	  Map semMap = loaddsemesters();
	        	    	  
	        	    	  Semester s= (Semester) degreeMap.get(value.getDegree());
	        	    	  stuReport.setStartDate(s.getStartDate());
	        	    	  stuReport.setCourseCompletionDate(s.getEndDate());
	        	    	  stuReportList.add(stuReport);
	        	      }
	        	    }
	        	
	        		
	        	}
	        }
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
	
	public static Map loadDegrees()
	{		
		String fileName ="TestDataDegrees.csv";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
		Map map = new HashMap();
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);
	        
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
	        while(inputSteam.hasNext()) 
	        {
	        		//split data by comma
	        	 line = inputSteam.nextLine();
		        	token = line.split(",");
		        	Degree deg = new Degree(token[0],token[1],token[2],token[3]);
		        	
		        	
		        	map.put(token[0],deg);
		        	//universityFaculty.addFculty(faculty);
		       }	       
	        
	        // Always close files.
	        bufferedReader.close();  
	        List<StudentCourse> stuCourseList = loadStudentCourse();
	        for(StudentCourse stuCourse : stuCourseList){
	        	{
	        		Set keys = map.keySet();
	        	    for (Iterator i = keys.iterator(); i.hasNext();) {
	        	      Integer key = (Integer) i.next();
	        	      String value = (String) map.get(key);
	        	      if(stuCourse.getStudentId().equalsIgnoreCase(value)){
	        	    	  
	        	      }
	        	    }
	        	
	        		
	        	}
	        }
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
	    return map;
	}
	
	public static Map loaddsemesters()
	{		
		String fileName ="TestDataSemesters.csv";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
		Map map = new HashMap();
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);
	        
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
	        inputSteam = new Scanner(fileReader);
	        while(inputSteam.hasNext()) 
	        {
	        		//split data by comma
	        	 line = inputSteam.nextLine();
		        	token = line.split(",");
		        	Semester sem = new Semester(token[1],token[0],token[2]);
		        	map.put(token[0],sem);
		        	//universityFaculty.addFculty(faculty);
		       }	       
	        
	        // Always close files.
	        bufferedReader.close();  
	        List<StudentCourse> stuCourseList = loadStudentCourse();
	        for(StudentCourse stuCourse : stuCourseList){
	        	{
	        		Set keys = map.keySet();
	        	    for (Iterator i = keys.iterator(); i.hasNext();) {
	        	      Integer key = (Integer) i.next();
	        	      String value = (String) map.get(key);
	        	      if(stuCourse.getStudentId().equalsIgnoreCase(value)){
	        	    	  
	        	      }
	        	    }
	        	
	        		
	        	}
	        }
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
	    return map;
	}

}

package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import SOURCE.Course;
import SOURCE.CourseStudent;
import SOURCE.Degree;
import SOURCE.DegreeReq;
import SOURCE.Faculty;
import SOURCE.FacultyReport;
import SOURCE.Schedule;
import SOURCE.Semester;
import SOURCE.StudentCourse;
import SOURCE.StudentReport;
import SOURCE.StudentSTU;
import SOURCE.Studentd;
import SOURCE.University;

public class GenerateReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//loadDegreeReq();
		loadUniversityCourse();
		loadStudents();
//		loadStudentCourse();
//		loadUniversityFaculty();
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
        		FacultyReport fr = null;
        		fall = false;
    			spr = false;
    			summer = false;
        		if(course.getCourseTeachers().contains(f.getFacultyLastName())){
        			    			
        			if(course.getCourseOfferedInFall().equalsIgnoreCase("Y")){
        				fall = true;
        			}
        			if(course.getCourseOfferedInSpring().equalsIgnoreCase("Y")){
        				spr= true;
        			}
        			if(course.getCourseOfferedInSummer().equalsIgnoreCase("Y")){
        				summer=true;
        			}
        			if(fall){
        				fr = new FacultyReport();
        				fr.setProfessor(f.getFacultyLastName());
            			fr.setCourseCode(course.getCourseCode());
            			fr.setCourseName(course.getCourseName());
            			fr.setGradeSchool(f.getFacultyGradeSchool());
            			fr.setMaxStudents(course.getCourseCap());
        				fr.setTerm("FALL");
        				fr.setMaxLoad(f.getMaxLoadFall());
        				facultyReportList.add(fr);
        			}
        			if(spr){
        				fr = new FacultyReport();
        				fr.setProfessor(f.getFacultyLastName());
            			fr.setCourseCode(course.getCourseCode());
            			fr.setCourseName(course.getCourseName());
            			fr.setGradeSchool(f.getFacultyGradeSchool());
            			fr.setMaxStudents(course.getCourseCap());
        				fr.setTerm("SPRING");
        				fr.setMaxLoad(f.getMaxLoadSpring());
        				facultyReportList.add(fr);
        			}
        			if(summer){
        				fr = new FacultyReport();
        				fr.setProfessor(f.getFacultyLastName());
            			fr.setCourseCode(course.getCourseCode());
            			fr.setCourseName(course.getCourseName());
            			fr.setGradeSchool(f.getFacultyGradeSchool());
            			fr.setMaxStudents(course.getCourseCap());
        				fr.setTerm("SUMMER");
        				fr.setMaxLoad(f.getMaxLoadSummer());
        				facultyReportList.add(fr);
        			}
        		}
        		}
        	}
        	
        	System.out.println("Faculty Report Size "+facultyReportList.size());
        	for(FacultyReport fr: facultyReportList){
        		System.out.println(fr.getProfessor()+","+fr.getCourseCode()+","+fr.getCourseName()+","+fr.getTerm()+","+fr.getMaxLoad());
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
		String fileName ="StudentCourse.csv";   //STC
		
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
		        	StudentCourse stc = new StudentCourse();
		        	stc.setStudentId(token[0]);
		        	stc.setCourseCode(token[1]);
		        	stc.setCourseDesc(token[2]);
		        	stc.setSemester(token[3]);
		        	stc.setStatus(token[4]);
		        	studCourseList.add(stc);
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
	        	    	  if(d!=null){
	        	    	  StudentReport stuReport = new StudentReport();
	        	    	  stuReport.setNoofStudents(d.getForescast());
	        	    	  stuReport.setGradeSchool(d.getGradSchool());
	        	    	  Map semMap = loaddsemesters();
	        	    	  
	        	    	  Semester s= (Semester) semMap.get(value.getSemester());
	        	    	  stuReport.setStartDate(s.getStartDate());
	        	    	  stuReport.setCourseCompletionDate(s.getEndDate());
	        	    	  stuReportList.add(stuReport);
	        	    	  }
	        	      }
	        	    }
	        	
	        		
	        	}
	        }
	        for(StudentReport s:stuReportList){
	        	System.out.println(s.getNoofStudents()+","+s.getGradeSchool()+","+s.getStartDate()
	        	+","+s.getCourseCompletionDate()+","+s.getCompletedSubject()+","+s.getCourseCompletionDate());
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
	        /*List<StudentCourse> stuCourseList = loadStudentCourse();
	        for(StudentCourse stuCourse : stuCourseList){
	        	{
	        		Set keys = map.keySet();
	        	    for (Iterator i = keys.iterator(); i.hasNext();) {
	        	      //Integer key = (Integer) i.next();
	        	      String value = (String) map.get(i);
	        	      if(stuCourse.getStudentId().equalsIgnoreCase(value)){
	        	    	  
	        	      }
	        	    }
	        	}
	        }*/
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
	        /*List<StudentCourse> stuCourseList = loadStudentCourse();
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
	        }*/
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
	
	
	private static Object token(Object object) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
	public static void loadDegreeReq()
	{		
		String fileName ="TestDataDegreePlanReq.csv";
		String line = null;
		String line1 = null;
		String[] token;
		String[] token1;
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
	    finally{
	    	inputSteam.close();
	    }
	  
	}
	
	
	public static void scheduleReport(){
		List<String> studentIdList = null;
		Map<String, CourseStudent> courseList = new HashMap<String,CourseStudent>();
		for (Entry<String, Course> entry : myUniversityCourse.getCourses().entrySet()) 
		{
			String courseCode = entry.getValue().getCourseCode();
			CourseStudent courseStu = new CourseStudent();
			for(StudentSTU studentStu : myUniversityStudentSTU.getStudentList()){
				String id = studentStu.getStudentSTUId();
				String courseId = studentStu.getStudentGradSch();
				 studentIdList = new ArrayList<String>();
				if(courseCode.equalsIgnoreCase(courseId)){
					courseStu.setFaculty(entry.getValue().getCourseTeachers());
					studentIdList.add(id);
				}
				courseStu.setStudentList(studentIdList);
	}
			courseList.put(courseCode, courseStu);
			
		}
		
		for(String courseValue : courseList.keySet())
		{
		Schedule schedule = new Schedule();
		schedule.setAcademicLevel("Graduate");
		schedule.setCredits("3");
		schedule.setSection(courseValue);
		CourseStudent occupancy = (CourseStudent) courseList.get(courseValue);
		schedule.setOccupied(String.valueOf(occupancy.getStudentList().size()));
		int available = 25 - (Integer.parseInt(schedule.getOccupied()));
		schedule.setAvailability(String.valueOf(available));
		if(available > 0){
			schedule.setStatus("Open");
	}else{
		schedule.setStatus(" ");
	}
		schedule.setFaculty(occupancy.getFaculty());
		System.out.println("Faculty "+occupancy.getFaculty());
		}
		
	}
	
	

}

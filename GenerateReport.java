package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import SOURCE.StudentCompletedCourse;
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
		studLoad();
		studLoadCourseCount();
		//loadStudents();
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
		        	//System.out.println("Token 9 "+token[9]);
		        	courseList.add(course);
		        	
		        	}
	        List<Faculty> facultyList = loadUniversityFaculty();
        	List<FacultyReport> facultyReportList = new ArrayList<FacultyReport>();
        	List<FacultyReport> summerReport = new ArrayList<FacultyReport>();
        	List<FacultyReport> springReport = new ArrayList<FacultyReport>();
        	List<FacultyReport> fallReport = new ArrayList<FacultyReport>();
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
        				fr.setTerm("FA");
            			fr.setCourseCode(course.getCourseCode());
            			fr.setCourseName(course.getCourseName());
        				fr.setProfessor(f.getFacultyLastName());
        				fr.setMaxLoad(f.getMaxLoadFall());
        				fr.setAvaialbleDays(f.getFacultyDaysToTeach());
            			//fr.setGradeSchool(f.getFacultyGradeSchool());
            			fr.setMaxStudents(course.getCourseCap());
            			fr.setCourseHours(course.getCourseHours());
        				facultyReportList.add(fr);
        				fallReport.add(fr);
        			}
        			if(spr){        				
        				fr = new FacultyReport();
        				fr.setTerm("SP");
            			fr.setCourseCode(course.getCourseCode());
            			fr.setCourseName(course.getCourseName());
        				fr.setProfessor(f.getFacultyLastName());
        				fr.setMaxLoad(f.getMaxLoadSpring());
        				fr.setAvaialbleDays(f.getFacultyDaysToTeach());
            			//fr.setGradeSchool(f.getFacultyGradeSchool());
            			fr.setMaxStudents(course.getCourseCap());
            			fr.setCourseHours(course.getCourseHours());
        				facultyReportList.add(fr);
        				springReport.add(fr);
        			}
        			if(summer){
        				fr = new FacultyReport();
        				fr.setTerm("SU");
            			fr.setCourseCode(course.getCourseCode());
            			fr.setCourseName(course.getCourseName());
        				fr.setProfessor(f.getFacultyLastName());
        				fr.setMaxLoad(f.getMaxLoadSummer());
        				fr.setAvaialbleDays(f.getFacultyDaysToTeach());
            			//fr.setGradeSchool(f.getFacultyGradeSchool());
            			fr.setMaxStudents(course.getCourseCap());
            			fr.setCourseHours(course.getCourseHours());
        				facultyReportList.add(fr);
        				summerReport.add(fr);
        			}
        		}
        		}
        	}
        	
        	System.out.println("Faculty Report Size "+facultyReportList.size());
        	List<Semester> semList = loadSemesterLst();
        	GregorianCalendar gcalendar = new GregorianCalendar();
        	List<StudentCourse> stuCourseList = loadStudentCourse();
        	List<FacultyReport> finalFacultyReport18plus = new ArrayList<FacultyReport>();
        	List<FacultyReport> finalFacultyReport = new ArrayList<FacultyReport>();
	        
        	for(Semester sem:semList){
        		Integer year = Integer.valueOf(sem.getName().substring(0,4));
        		Map<String,String> mapStudCourse = genStudCourseMap(year);
        		if(year >= gcalendar.get(Calendar.YEAR)){
        			String term = sem.getName().substring(4,6);
        			if(term.equalsIgnoreCase("FA")){
        				Map<String,FacultyReport> mapLastRec = new HashMap<String,FacultyReport>();
        				for(FacultyReport fr:fallReport){
        					String courseCode = fr.getCourseCode();
        					String mapKey = year+term+','+courseCode;
        					if(mapStudCourse.get(mapKey)!=null){
	        					int noOfStud = Integer.valueOf(mapStudCourse.get(mapKey));
	        					if(noOfStud > 0 ){
	        						int newNoOfStud = 0;
	        						FacultyReport newFrRec = new FacultyReport();
		        					newFrRec.setSemTerm(sem.getName());
		        					newFrRec.setCourseCode(fr.getCourseCode());
		        					newFrRec.setCourseName(fr.getCourseName());
		        					newFrRec.setProfessor(fr.getProfessor());
		        					newFrRec.setMaxLoad(fr.getMaxLoad());
		        					newFrRec.setAvaialbleDays(fr.getAvaialbleDays());
		        					newFrRec.setMaxStudents(fr.getMaxStudents());
		        					newFrRec.setWaitLStudents("0");
		        					newFrRec.setCourseStart(sem.getStartDate());
		        					newFrRec.setCourseEnd(sem.getEndDate());
		        					newFrRec.setCourseHours(fr.getCourseHours());
		        					if(noOfStud >= Integer.valueOf(fr.getMaxStudents())){
	        							newNoOfStud = noOfStud - Integer.valueOf(fr.getMaxStudents());
	        							newFrRec.setCurrentStudents(fr.getMaxStudents());
	        							mapStudCourse.put(mapKey, String.valueOf(newNoOfStud));
	        						}
	        						else{
	        							newFrRec.setCurrentStudents(String.valueOf(noOfStud));
	        							mapStudCourse.put(mapKey, "0");
	        						}
		        					if(Integer.valueOf(newFrRec.getCurrentStudents()) > 18){
		        						finalFacultyReport18plus.add(newFrRec);
		        					}
		        					else
		        						finalFacultyReport.add(newFrRec);
		        					mapLastRec.put(mapKey, newFrRec);
	        					}
        					}
        				}
        				for(String lastFr: mapLastRec.keySet()){
        					if(mapStudCourse.get(lastFr)!=null){
	        					int noOfStud = Integer.valueOf(mapStudCourse.get(lastFr));
	        					if(noOfStud > 0 ){
	        						FacultyReport updfr = mapLastRec.get(lastFr);
	        						updfr.setWaitLStudents(String.valueOf(noOfStud));
	        						if(finalFacultyReport.contains(mapLastRec.get(lastFr))){
		        						finalFacultyReport.remove(mapLastRec.get(lastFr));
		        						finalFacultyReport.add(updfr);
	        						}else{
	        							finalFacultyReport18plus.remove(mapLastRec.get(lastFr));
		        						finalFacultyReport18plus.add(updfr);
	        						}
	        					}
        					}
        				}
        			}else if(term.equalsIgnoreCase("SU")){
        				Map<String,FacultyReport> mapLastRec = new HashMap<String,FacultyReport>();
        				for(FacultyReport fr:summerReport){
        					String courseCode = fr.getCourseCode();
        					String mapKey = year+term+','+courseCode;
        					if(mapStudCourse.get(mapKey)!=null){
	        					int noOfStud = Integer.valueOf(mapStudCourse.get(mapKey));
	        					if(noOfStud > 0 ){
	        						int newNoOfStud = 0;
	        						FacultyReport newFrRec = new FacultyReport();
		        					newFrRec.setSemTerm(sem.getName());
		        					newFrRec.setCourseCode(fr.getCourseCode());
		        					newFrRec.setCourseName(fr.getCourseName());
		        					newFrRec.setProfessor(fr.getProfessor());
		        					newFrRec.setMaxLoad(fr.getMaxLoad());
		        					newFrRec.setAvaialbleDays(fr.getAvaialbleDays());
		        					newFrRec.setMaxStudents(fr.getMaxStudents());
		        					newFrRec.setWaitLStudents("0");
		        					newFrRec.setCourseStart(sem.getStartDate());
		        					newFrRec.setCourseEnd(sem.getEndDate());
		        					newFrRec.setCourseHours(fr.getCourseHours());
		        					if(noOfStud >= Integer.valueOf(fr.getMaxStudents())){
	        							newNoOfStud = noOfStud - Integer.valueOf(fr.getMaxStudents());
	        							newFrRec.setCurrentStudents(fr.getMaxStudents());
	        							mapStudCourse.put(mapKey, String.valueOf(newNoOfStud));
	        						}
	        						else{
	        							newFrRec.setCurrentStudents(String.valueOf(noOfStud));
	        							mapStudCourse.put(mapKey, "0");
	        						}
		        					if(Integer.valueOf(newFrRec.getCurrentStudents()) > 18){
		        						finalFacultyReport18plus.add(newFrRec);
		        					}
		        					else
		        						finalFacultyReport.add(newFrRec);
		        					mapLastRec.put(mapKey, newFrRec);
	        					}
        					}
        				}
        				for(String lastFr: mapLastRec.keySet()){
        					if(mapStudCourse.get(lastFr)!=null){
	        					int noOfStud = Integer.valueOf(mapStudCourse.get(lastFr));
	        					if(noOfStud > 0 ){
	        						FacultyReport updfr = mapLastRec.get(lastFr);
	        						updfr.setWaitLStudents(String.valueOf(noOfStud));
	        						if(finalFacultyReport.contains(mapLastRec.get(lastFr))){
		        						finalFacultyReport.remove(mapLastRec.get(lastFr));
		        						finalFacultyReport.add(updfr);
	        						}else{
	        							finalFacultyReport18plus.remove(mapLastRec.get(lastFr));
		        						finalFacultyReport18plus.add(updfr);
	        						}
	        					}
        					}
        				}
        			}else if(term.equalsIgnoreCase("SP")){
        				Map<String,FacultyReport> mapLastRec = new HashMap<String,FacultyReport>();
        				for(FacultyReport fr:springReport){
        					String courseCode = fr.getCourseCode();
        					String mapKey = year+term+','+courseCode;
        					if(mapStudCourse.get(mapKey)!=null){
	        					int noOfStud = Integer.valueOf(mapStudCourse.get(mapKey));
	        					if(noOfStud > 0 ){
	        						int newNoOfStud = 0;
	        						FacultyReport newFrRec = new FacultyReport();
		        					newFrRec.setSemTerm(sem.getName());
		        					newFrRec.setCourseCode(fr.getCourseCode());
		        					newFrRec.setCourseName(fr.getCourseName());
		        					newFrRec.setProfessor(fr.getProfessor());
		        					newFrRec.setMaxLoad(fr.getMaxLoad());
		        					newFrRec.setAvaialbleDays(fr.getAvaialbleDays());
		        					newFrRec.setMaxStudents(fr.getMaxStudents());
		        					newFrRec.setWaitLStudents("0");
		        					newFrRec.setCourseStart(sem.getStartDate());
		        					newFrRec.setCourseEnd(sem.getEndDate());
		        					newFrRec.setCourseHours(fr.getCourseHours());
		        					if(noOfStud >= Integer.valueOf(fr.getMaxStudents())){
	        							newNoOfStud = noOfStud - Integer.valueOf(fr.getMaxStudents());
	        							newFrRec.setCurrentStudents(fr.getMaxStudents());
	        							mapStudCourse.put(mapKey, String.valueOf(newNoOfStud));
	        						}
	        						else{
	        							newFrRec.setCurrentStudents(String.valueOf(noOfStud));
	        							mapStudCourse.put(mapKey, "0");
	        						}
		        					if(Integer.valueOf(newFrRec.getCurrentStudents()) > 18){
		        						finalFacultyReport18plus.add(newFrRec);
		        					}
		        					else
		        						finalFacultyReport.add(newFrRec);
		        					mapLastRec.put(mapKey, newFrRec);
	        					}
        					}
        				}
        				for(String lastFr: mapLastRec.keySet()){
        					if(mapStudCourse.get(lastFr)!=null){
	        					int noOfStud = Integer.valueOf(mapStudCourse.get(lastFr));
	        					if(noOfStud > 0 ){
	        						FacultyReport updfr = mapLastRec.get(lastFr);
	        						updfr.setWaitLStudents(String.valueOf(noOfStud));
	        						if(finalFacultyReport.contains(mapLastRec.get(lastFr))){
		        						finalFacultyReport.remove(mapLastRec.get(lastFr));
		        						finalFacultyReport.add(updfr);
	        						}else{
	        							finalFacultyReport18plus.remove(mapLastRec.get(lastFr));
		        						finalFacultyReport18plus.add(updfr);
	        						}
	        					}
        					}
        				}
        			}
        		}
        	}
        	for(FacultyReport fr:finalFacultyReport18plus){
        		System.out.println(fr.getSemTerm()+','+
            			fr.getCourseCode()+','+
            			fr.getCourseName()+','+
        				fr.getProfessor()+','+
        				fr.getMaxLoad()+','+
        				fr.getAvaialbleDays()+','+
            			fr.getMaxStudents()+','+
            			fr.getCurrentStudents()+','+
            			fr.getWaitLStudents()+','+
            			fr.getCourseStart()+','+
            			fr.getCourseEnd()+','+
            			fr.getCourseHours());
        	}
        	for(FacultyReport fr:finalFacultyReport){
        		System.out.println(fr.getSemTerm()+','+
            			fr.getCourseCode()+','+
            			fr.getCourseName()+','+
        				fr.getProfessor()+','+
        				fr.getMaxLoad()+','+
        				fr.getAvaialbleDays()+','+
            			fr.getMaxStudents()+','+
            			fr.getCurrentStudents()+','+
            			fr.getWaitLStudents()+','+
            			fr.getCourseStart()+','+
            			fr.getCourseEnd()+','+
            			fr.getCourseHours());
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
	
	public static Map<String,String> genStudCourseMap(Integer intRecYear){
		List<StudentCourse> stuCourseList = loadStudentCourse();
		Map<String,String> studCourseMap = new HashMap<String,String>();
		int i =1;
		for(StudentCourse stuCourse : stuCourseList){
			Integer year = Integer.valueOf(stuCourse.getSemester().trim().substring(0,4));
			if(year <= intRecYear && (!stuCourse.getStatus().equalsIgnoreCase("A") && !stuCourse.getStatus().equalsIgnoreCase("B") && 
						!stuCourse.getStatus().equalsIgnoreCase("C") && !stuCourse.getStatus().equalsIgnoreCase("D"))){
				String stuSemCourse = intRecYear+stuCourse.getSemester().substring(4,6)+','+stuCourse.getCourseCode();
				Integer intMapVal = 1;
				if(studCourseMap.containsKey(stuSemCourse)){
					intMapVal = Integer.valueOf(studCourseMap.get(stuSemCourse));
					intMapVal = intMapVal + 1;
				}
				studCourseMap.put(stuSemCourse, String.valueOf(intMapVal));
			}
			i = i+1;
		} 
		return studCourseMap;
	}
	
	
	public static List loadStudentCourse()
	{		
		String fileName ="STC.DUMP.CSV";   //STC
		
		String line = null;
		List<String> token = new ArrayList<String>();
		List<String> token1 = new ArrayList<String>();
		//String[] token1 = null;
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
	        	if(line.indexOf("\"") > 0){
	        		token = Arrays.asList(line.split("\".*\""));
	        	}
	        	else
	        		token = Arrays.asList(line.split(","));
	        	if(token.size()<=4){
	        		for(String str:token){
	        			for(String s:Arrays.asList(str.split(","))){
	        				token1.add(s);
	        			}
	        		}
	        		token = token1;
	        	}

	        	StudentCourse stc = new StudentCourse();
	        	stc.setStudentId(token.get(0));
	        	stc.setCourseCode(token.get(1));
	        	stc.setCourseDesc(token.get(2));
	        	stc.setSemester(token.get(3));
	        	stc.setStatus(token.get(4));
	        	studCourseList.add(stc);
	        	//System.out.println(token[0]+","+token[1]+","+token[2]+","+token[3]+","+token[4]);
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

	
	public static List loadUniversityFaculty()
	{		
		String fileName ="TestDataFaculty.csv";
		
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
		        	Faculty faculty = new Faculty(token[0].trim(),token[1].trim(),token[2].trim(),token[3].trim(),token[4].trim(),token[5].trim(),token[6].trim(),token[7].trim(),token[8].trim());//For Faculty
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
	
	public static void studLoad()
	{		
		String fileName ="STU.DUMP.CSV";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);
	        Map<String,Integer> map = new HashMap<String,Integer>();
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
		        	stu.setStudentId(token[0].trim());
		        	stu.setDegree(token[1].trim());
		        	stu.setSemester(token[2].trim());
		        	String key = token[2].trim()+','+token[1].trim();
		        	Integer i = 1;
		        	if(map.containsKey(key)){
		        		i = map.get(key) + 1;
		        		map.put(key,i);
		        	}else
		        		map.put(key, i);
		        	//universityFaculty.addFculty(faculty);
		       }
	        for(String str:map.keySet()){
	        	String[] termCourse = str.split(",");
	        	System.out.println(termCourse[0]+","+termCourse[1]+","+map.get(str));
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
	
	
/*************************************************/
	public static void studLoadCourseCount()
	{		
		String fileName ="STC.DUMP.CSV";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
	    try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);
	        Map<String,Integer> map = new HashMap<String,Integer>();
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
		        	StudentCompletedCourse stu = new StudentCompletedCourse();
		        	stu.setStudentId(token[0].trim());
		        	stu.setTerm(token[3].trim());
		        	stu.setCourseGrade(token[4].trim());
		        	//String key = token[0].trim()+','+token[3].trim();
		        	String key = token[0]+','+token[3];
		        	Integer i = 1;
		        	if(map.containsKey(key)){
		        		i = map.get(key) + 1;
		        		map.put(key,i);
		        	}else
		        		map.put(key, i);
		        	//universityFaculty.addFculty(faculty);
		       }
	        for(String str:map.keySet()){
	        	String[] termCourse = str.split(",");
	        	System.out.println(termCourse[0]+","+termCourse[1]+","+map.get(str));
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
	
	
	
/************************************************/	
	public static void load()
	{		
		String fileName ="STU.DUMP.CSV";
		
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
		        	stu.setStudentId(token[0].trim());
		        	stu.setDegree(token[1].trim());
		        	stu.setSemester(token[2].trim());
		        	
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
	
		
	public static void loadStudents()
	{		
		String fileName ="STU.DUMP.CSV";
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
	        	    	  Map semMap = loadSemesters();
	        	    	  
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
	
	public static Map loadSemesters()
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
	
	public static List<Semester> loadSemesterLst()
	{		
		String fileName ="TestDataSemesters.csv";
		
		String line = null;
		String[] token;
		Scanner inputSteam = null;
		List<Semester> semList = new ArrayList<Semester>();
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
		        	semList.add(sem);
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
	    return semList;
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
	
	
	/*public static void scheduleReport(){
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
		
	}*/
	
	

}

package GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import SOURCE.*;


public class MainStart {
	public static University myUniversity;
	public static University myUniversityFaculty;
	public static University myUniversityCourse;
	public static University myUniversityGradSch;
	public static University myUniversityDegree;
	public static University myUniversityDegreeReq;
	public static University myUniversitySemester;
	public static University myUniversityStudent;
	public static University myUniversityStudentSTU;
	/**
	 * Main prints out name of the store, creates new instance of Store(), 
	 * and runs store in POSJFrame.
	 *  
	 * @param args
	 */
	public static void main(String[] args) 
	{

		myUniversity = new University();
		myUniversityFaculty = new University();
		myUniversityCourse = new University();
		myUniversityGradSch = new University();
		myUniversityDegree = new University();
		myUniversityDegreeReq = new University();
		myUniversitySemester = new University();
		
		myUniversity.openUniversity();
		myUniversityCourse.openUniversityCourse();
		myUniversityFaculty.openUniversityFaculty();
		myUniversityGradSch.openUniversityGradSch();
		myUniversityDegree.openUniversityDegree();
		
		myUniversityDegreeReq.openUniversityDegreeReq();
		myUniversitySemester.openUniversitySemester();
		
		myUniversityStudent = new University();
		//myUniversityStudent.openUniversityStudent();
		
		myUniversityStudentSTU = new University();
		myUniversityStudentSTU.openUniversityStudentSTU();
		//myUniversity.loadUniversityFaculty();
		//POSJFrame.run(myUniversity);
		printUniversity();
		
		//scheduleReport();

	}
	
//	public static void scheduleReport(){
//		List<String> studentIdList = null;
//		Map<String, CourseStudent> courseList = new HashMap<String,CourseStudent>();
//		for (Entry<String, Course> entry : myUniversityCourse.getCourses().entrySet()) 
//		{
//			String courseCode = entry.getValue().getCourseCode();
//			CourseStudent courseStu = new CourseStudent();
//			//for(StudentSTU studentStu : myUniversityStudentSTU.getStudentList()){
//			for(StudentSTU studentStu : myUniversityStudentSTU.getStudentList()){
//				String id = studentStu.getStudentSTUId();
//				String courseId = studentStu.getStudentGradSch();
//				 studentIdList = new ArrayList<String>();
//				if(courseCode.equalsIgnoreCase(courseId)){
//					courseStu.setFaculty(entry.getValue().getCourseTeachers());
//					studentIdList.add(id);
//				}
//				courseStu.setStudentList(studentIdList);
//	}
//			courseList.put(courseCode, courseStu);
//			
//		}
//		
//		for(String courseValue : courseList.keySet())
//		{
//		Schedule schedule = new Schedule();
//		schedule.setAcademicLevel("Graduate");
//		schedule.setCredits("3");
//		schedule.setSection(courseValue);
//		CourseStudent occupancy = (CourseStudent) courseList.get(courseValue);
//		schedule.setOccupied(String.valueOf(occupancy.getStudentList().size()));
//		int available = 25 - (Integer.parseInt(schedule.getOccupied()));
//		schedule.setAvailability(String.valueOf(available));
//		if(available > 0){
//			schedule.setStatus("Open");
//	}else{
//		schedule.setStatus("Closed");
//	}
//		schedule.setFaculty(occupancy.getFaculty());
//		System.out.println("Faculty "+occupancy.getFaculty());
//		}
//		
//	}
//	
	/**
	 * printStore() prints out the data from the file. It prints all of the cashiers,
	 * registers, items and sessions.
	 */
	public static void printUniversity()
	{
		System.out.println("==============");
		System.out.println("University ");
		System.out.println("==============");
		System.out.println(myUniversity.getName());
		System.out.println(myUniversity.getNumber());
		
//		System.out.println("==============");
//		System.out.println("Faculty");
//		System.out.println("==============");
//		for (Entry<String, Faculty> entry : myUniversityFaculty.getFaculty().entrySet()) 
//		{
//			
//			System.out.print(entry.getValue().getFacultyLastName()+" ");
//			System.out.print(entry.getValue().getFacultyFirstName());
//			System.out.print(entry.getValue().getFacultyGradeSchool());
//			System.out.print(entry.getValue().getFacultyTitle());
//			System.out.print(entry.getValue().getFacultyDaysToTeach());
//			System.out.print(entry.getValue().getMaxLoadFall());
//			System.out.print(entry.getValue().getMaxLoadSpring());
//			System.out.println(entry.getValue().getMaxLoadSummer());
//	        
//		}
		System.out.println("==============");
		System.out.println("GradeSchool");
		System.out.println("==============");
		for (Entry<String, GraduateSchool> entry : myUniversityGradSch.getGradSchool().entrySet()) 
		{
			System.out.print(entry.getValue().getName()+"");
			System.out.print(entry.getValue().getAbbrevation()+"");
	        
		}
		System.out.println("==============");
		System.out.println("Courses");
		System.out.println("==============");
		for (Entry<String, Course> entry : myUniversityCourse.getCourses().entrySet()) 
		{
			System.out.print(entry.getValue().getCourseCode()+" ");
			System.out.print(entry.getValue().getCourseName()+" ");
			System.out.print(entry.getValue().getCourseDescription()+" ");
			System.out.print(entry.getValue().getCourseHours()+" ");
			System.out.print(entry.getValue().getCourseCap()+" ");
			System.out.print(entry.getValue().getCourseOfferedInFall()+" ");
			System.out.print(entry.getValue().getCourseOfferedInSpring()+" ");
			System.out.println(entry.getValue().getCourseOfferedInSummer()+" ");
	        
		}
		System.out.println("==============");
		System.out.println("Degree");
		System.out.println("==============");
		for (Entry<String, Degree> entry : myUniversityDegree.getDegree().entrySet()) 
		{
			System.out.print(entry.getValue().getDegreeCode()+" ");
			System.out.print(entry.getValue().getGradSchool()+" ");
			System.out.print(entry.getValue().getDegreeName()+" ");
			System.out.println(entry.getValue().getForescast()+" ");
				        
		}
		
		System.out.println("==============");
		System.out.println("Degree Requirement");
		System.out.println("==============");
		for (Entry<String, DegreeReq> entry : myUniversityDegreeReq.getDegreeReq().entrySet()) 
		{
			System.out.print(entry.getValue().getDegreeReqCode()+" ");
			System.out.print(entry.getValue().getDegreeReqdesc()+" ");
			System.out.print(entry.getValue().getDegreeReqHours()+" ");
			System.out.print(entry.getValue().getDegreeReqType()+" ");
			System.out.println(entry.getValue().getDegreeReqCourses()+" ");
			
	        
		}
		
		System.out.println("==============");
		System.out.println("Semester");
		System.out.println("==============");
		for (Entry<String, Semester> entry : myUniversitySemester.getSemester().entrySet()) 
		{
			//System.out.println(myUniversity.getSemester());
			System.out.print(entry.getValue().getStartDate()+" ");
			System.out.print(entry.getValue().getName()+" ");
			System.out.println(entry.getValue().getEndDate()+" ");
		}
		
		System.out.println("==============");
		System.out.println("Student");
		System.out.println("==============");
		for (Entry<String, Student> entry : myUniversityStudent.getStudent().entrySet()) 
		{
			//System.out.println(myUniversity.getSemester());
			System.out.print(entry.getValue().getStudentSTCId()+" ");
			System.out.print(entry.getValue().getStudentDegreeCourseCode()+" ");
			System.out.println(entry.getValue().getStudentDegreeDesc()+" ");
			System.out.println(entry.getValue().getStudentStartYr()+" ");
			System.out.println(entry.getValue().getStudentGrad()+" ");
			
		}
		
		System.out.println("==============");
		System.out.println("StudentSTU");
		System.out.println("==============");
		for (Entry<String, StudentSTU> entry : myUniversityStudentSTU.getStudentSTU().entrySet()) 
		{
			//System.out.println(myUniversity.getSemester());
			System.out.print(entry.getValue().getStudentSTUId()+" ");
			System.out.print(entry.getValue().getStudentGradSch()+" ");
			System.out.println(entry.getValue().getStudentYrOfGrad()+" ");
			
		}
		//scheduleReport();
	}
}



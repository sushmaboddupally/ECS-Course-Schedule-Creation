package GUI;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import SOURCE.*;


public class MainStart {
	public static University myUniversity;
	
	/**
	 * Main prints out name of the store, creates new instance of Store(), 
	 * and runs store in POSJFrame.
	 *  
	 * @param args
	 */
	public static void main(String[] args) 
	{

		myUniversity = new University();
		myUniversity.openUniversity();
	//POSJFrame.run(myUniversity);
		printStore();

	}

	/**
	 * printStore() prints out the data from the file. It prints all of the cashiers,
	 * registers, items and sessions.
	 */
	public static void printStore()
	{
//		System.out.println("==============");
//		System.out.println("Faculty");
//		System.out.println("==============");
//		for (Entry<String, Faculty> entry : myUniversity.getFaculty().entrySet()) 
//		{
//			System.out.println(myUniversity.getFaculty());
//	        
//		}
//		System.out.println("==============");
//		System.out.println("GradeSchool");
//		System.out.println("==============");
//		for (Entry<String, GraduateSchool> entry : myUniversity.getGradSchool().entrySet()) 
//		{
//			System.out.println(myUniversity.getGradSchool());
//	        
//		}
		System.out.println("==============");
		System.out.println("Courses");
		System.out.println("==============");
		for (Entry<String, Course> entry : myUniversity.getCourses().entrySet()) 
		{
			System.out.print(entry.getValue().getCourseCode());
			System.out.print(entry.getValue().getCourseName());
			System.out.print(entry.getValue().getCourseTeachers());
			System.out.print(entry.getValue().getCourseHours());
	        
		}
//		System.out.println("==============");
//		System.out.println("Degree");
//		System.out.println("==============");
//		for (Entry<String, Degree> entry : myUniversity.getName().entrySet()) 
//		{
//			System.out.println(myUniversity.getDegree());
//	        
//		}
//		
//		System.out.println("==============");
//		System.out.println("Degree Requirement");
//		System.out.println("==============");
//		for (Entry<String, DegreeReq> entry : myUniversity.getName().entrySet()) 
//		{
//			System.out.println(myUniversity.getDegreeReq());
//	        
//		}
//		
//		System.out.println("==============");
//		System.out.println("Semester");
//		System.out.println("==============");
//		for (Entry<String, Semester> entry : myUniversity.getName().entrySet()) 
//		{
//			System.out.println(myUniversity.getSemester());
//	        
//		}
		
		
	}
}



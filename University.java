
package SOURCE;

import java.util.*;
import java.util.Map.Entry;

import UnivDM.Univ;

public class University
{

	private String number;
	private String name;
	/**
	 * Association Type = POSPD.Register
	 */
	private TreeMap<String,Student> student;
	private TreeMap<String,StudentSTU> studentSTU;
	/**
	 * Association Type = POSPD.TaxCategory
	 */
	private TreeMap<String,Course> courses;
	/**
	 * Association Type = POSPD.Item
	 */
	private TreeMap<String,Faculty > faculty;
	/**
	 * Association Type = POSPD.Cashier
	 */
	private TreeMap<String, Degree> degree;
	
	private TreeMap<String, GraduateSchool> gradSchool;
	
	private TreeMap<String, DegreeReq> degreeReq;
	
	private TreeMap<String, Semester> semester;
	
	/**
	 * Association Type = POSPD.UPC
	 */
	//private TreeSet<Session> sessions;
    
	/**
     * Default Store constructor that creates an instance of Store with TreeMap of items, cashiers, registers, 
     * upcs and taxCategories, and TreeSet of sessions.
     */
	public University()
	{
		student = new TreeMap <String, Student>();
		studentSTU = new TreeMap <String, StudentSTU>();
		courses = new TreeMap <String, Course>();
		faculty = new TreeMap <String, Faculty>();
		
		degree = new TreeMap <String, Degree>();
		gradSchool = new TreeMap <String, GraduateSchool>();
		degreeReq = new TreeMap <String, DegreeReq>();
		semester = new TreeMap <String, Semester>();
		//sessions = new TreeSet<Session>();
		//upcs = new TreeMap <String, UPC>();
	}

	/**
	 * Store constructor with store number and store name passed. It creates an instance of store with name, number and 
	 * TreeMaps of items, cashiers, registers, upcs and taxcategories.
	 * 
	 * @param number
	 * @param name
	 */
	public University(String number, String name)
	{
		this.setNumber(number);
		this.setName(name);
		student = new TreeMap <String, Student>();
		courses = new TreeMap <String, Course>();
		faculty = new TreeMap <String, Faculty>();
		degree = new TreeMap <String, Degree>();
		gradSchool = new TreeMap <String, GraduateSchool>();
		degreeReq = new TreeMap <String, DegreeReq>();
		semester = new TreeMap <String, Semester>();
		studentSTU = new TreeMap <String, StudentSTU>();
		//upcs = new TreeMap <String, UPC>();
		//taxCategories = new TreeMap <String, TaxCategory>();
		//sessions = new TreeSet<Session>();
	}
	
	public void setStudentSTU(TreeMap<String, StudentSTU> studentSTU) {
		this.studentSTU = studentSTU;
	}

	public TreeMap<String, Semester> getSemester() {
		return semester;
	}

	public void setSemester(TreeMap<String, Semester> semester) {
		this.semester = semester;
	}

	public TreeMap<String, DegreeReq> getDegreeReq() {
		return degreeReq;
	}

	public void setDegreeReq(TreeMap<String, DegreeReq> degreeReq) {
		this.degreeReq = degreeReq;
	}

	public void openUniversity()
	{
		Univ.loadUniversity(this);
	}
	
	public void openUniversityFaculty()
	{
		Univ.loadUniversityFaculty(this);
		
	}
	
	public void openUniversityCourse()
	{	
		Univ.loadUniversityCourse(this);
	}
	
	public void openUniversityGradSch()
	{	
		Univ.loadUniversityGradSchool(this);
	}
	
	public void openUniversityDegree()
	{	
		Univ.loadUniversityDegree(this);
	}
	
	public void openUniversityDegreeReq()
	{	
		Univ.loadUniversityDegreeReq(this);
	}
	
	public void openUniversitySemester()
	{	
		Univ.loadUniversitySemester(this);
	}

	public void openUniversityStudent()
	{	
		Univ.loadUniversityStudent(this);
	}
	public void openUniversityStudentSTU()
	{	
		Univ.loadUniversityStudentSTU(this);
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeMap<String, Student> getStudent() {
		return student;
	}
	
	public TreeMap<String, StudentSTU> getStudentSTU() {
		return studentSTU;
	}

	public void setStudent(TreeMap<String, Student> student) {
		this.student = student;
	}

	public TreeMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(TreeMap<String, Course> courses) {
		this.courses = courses;
	}

	public TreeMap<String, Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(TreeMap<String, Faculty> faculty) {
		this.faculty = faculty;
	}

	public TreeMap<String, Degree> getDegree() {
		return degree;
	}

	public void setDegree(TreeMap<String, Degree> degree) {
		this.degree = degree;
	}

	public TreeMap<String, GraduateSchool> getGradSchool() {
		return gradSchool;
	}

	public void setGradSchool(TreeMap<String, GraduateSchool> gradSchool) {
		this.gradSchool = gradSchool;
	}
	
	/********************************************/
	public void addFculty(Faculty faculty)
	{
		if (faculty != null)
		{
			getFaculty().put(faculty.getFacultyLastName(), faculty);
		}
	}
	
	public void addGradSchool(GraduateSchool gradSchool)
	{
		if (gradSchool != null)
		{
			getGradSchool().put(gradSchool.getName(), gradSchool);
		}
	}
	
	public void addCourse(Course course)
	{
		if (course != null)
		{
			getCourses().put(course.getCourseCode(), course);
		}
	}
	
	public void addDegree(Degree degree)
	{
		if (degree != null)
		{
			getDegree().put(degree.getGradSchool(), degree);
		}
	}
	
	public void addDegreeReq(DegreeReq degreeReq)
	{
		if (degreeReq != null)
		{
			getDegreeReq().put(degreeReq.getDegreeReqCode(), degreeReq);
		}
	}
	
	public void addSemester(Semester semester)
	{
		if (semester != null)
		{
			getSemester().put(semester.getName(), semester);
		}
	}
	
	public void addStudent(Student student)
	{
		if (student != null)
		{
			getStudent().put(student.getStudentSTCId(), student);
		}
	}
	public void addStudentSTU(StudentSTU studentSTU)
	{
		if (studentSTU != null)
		{
			getStudentSTU().put(studentSTU.getStudentSTUId(), studentSTU);
		}
	}
	
	public void removeFculty(Faculty faculty )
	{
		if (faculty != null)
		{
			getFaculty().remove(faculty.getFacultyLastName());
		}
	}
	
	public void removeGradSchool(GraduateSchool gradSchool )
	{
		if (gradSchool != null)
		{
			getFaculty().remove(gradSchool.getName());
		}
	}

	
	public void removeCourse(Course course )
	{
		if (course != null)
		{
			getCourses().remove(course.getCourseCode());
		}
	}
	
	public void removeDegree(Degree degree )
	{
		if (degree != null)
		{
			getDegree().remove(degree.getGradSchool());
		}
	}
	
	public void removeDegreeReq(DegreeReq degreeReq )
	{
		if (degreeReq != null)
		{
			getDegreeReq().remove(degreeReq.getDegreeReqCode());
		}
	}
	
	public void removeSemester(Semester semester )
	{
		if (semester != null)
		{
			getSemester().remove(semester.getName());
		}
	}
}

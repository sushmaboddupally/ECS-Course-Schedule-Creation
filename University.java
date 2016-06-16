package USM;

import java.util.*;
import java.util.Map.Entry;


import SDM.Schedule;

public class University
{

	private String number;
	private String name;
	/**
	 * Association Type = POSPD.Register
	 */
	private TreeMap<String,Student> student;
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
		courses = new TreeMap <String, Course>();
		faculty = new TreeMap <String, Faculty>();
		
		degree = new TreeMap <String, Degree>();
		gradSchool = new TreeMap <String, GraduateSchool>();
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
		//upcs = new TreeMap <String, UPC>();
		//taxCategories = new TreeMap <String, TaxCategory>();
		//sessions = new TreeSet<Session>();
	}

	/**
	 * Loads the store.
	 */
	public void openUniversity()
	{
		Schedule.loadUniversity(this);
	}

    
	/**
	 * Finds item based on the upc that is being passed as parameter.
	 * First, it looks if upc length is more than 0. If it is, it looks at upcs and if it finds matching 
	 * upc, it returns the item associated with that upc. If it doesn't find matching upc, it returns null.
	 * 
	 * @param upc
	 */
//	public Item findItemForUPC(String upc)
//	{
//		if (upc.length() >0) 
//		{ 
//			if (getUpcs().get(upc) == null) return null;
//			
//			else return getUpcs().get(upc).getItem();
//		}
//		else return null;
//	}
	/**
	 * Finds item based on the number that is being passed as parameter. 
	 * First, it looks if the number length is bigger to zero to validate number.
	 * If it is, it returns item associated with that number.
	 * If there is no item associated with that number, it returns null.
	 * 
	 * @param upc
	 */
//	public Item findItemForNumber(String number)
//	{
//		if (number.length() >0) 
//		{ 
//			return getItems().get(number);
//		}
//		else return null;
//	}
	/**
	 * Finds cashier based on the number being passed as parameter.
	 * First, it looks if the number length is bigger to zero to validate number.
	 * If it is, it returns cashier associated with that number.
	 * If there is no cashier associated with that number, it returns null.
	 * 
	 * @param number
	 */
//	public Cashier findCashierForNumber(String number)
//	{
//		if (number.length() >0) 
//		{ 
//			return getCashiers().get(number);
//		}
//		else return null;
//	}
	
	/**
	 * Finds register based on the number being passed as parameter.
	 * First, it looks if the number length is bigger to zero to validate number.
	 * If it is, it returns register associated with that number.
	 * If there is no register associated with that number, it returns null.
	 * 
	 * @param number
	 */
//	public Register findRegisterForNumber(String number)
//	{
//		if (number.length() >0) 
//		{ 
//			return getRegisters().get(number);
//		}
//		else return null;
//	}
	
	/**
	 * Finds tax category based on the category being passed as parameter.
	 * First, it looks if the category length is bigger to zero to validate category.
	 * If it is, it returns tax category associated with passed category.
	 * If there is no tax category associated with that category, it returns null.
	 * 
	 * @param category
	 */
//	public TaxCategory findTaxCategoryForCategory(String category)
//	{
//		if (category.length() >0) 
//		{ 
//			return taxCategories.get(category);
//		}
//		else return null;
//	}
	
	/**
	 * Adds the item to the store.
	 * If item is not null, it adds it to the all items in the store.
	 * 
	 * @param item
	 */
	public void addCourse(Course courses)
	{
		if (courses != null)
		{
			getCourses().put(courses.getCourseCode(), courses);
		}
	}
	
	/**
	 * Removes the item from the store.
	 * If passed item is not equal to null, it removes it from the store.
	 * 
	 * @param item
	 */
	public void removeCourse(Course courses )
	{
		if (courses != null)
		{
			getCourses().remove(courses.getCourseCode());
		}
	}
	
	/**
	 * Adds the upc to the store.
	 * If passed upc is not equal to null, it adds it to the store.
	 * 
	 * @param upc
	 */
//	public void addUPC(UPC upc)
//	{
//		if (upc != null)
//		{
//			getUpcs().put(upc.getUpc(), upc);
//		}
//	}
	
	/**
	 * Removes the upc from the store.
	 * If passed upc is not equal to the null, it removes it from the store.
	 *  
	 * @param upc
	 */
//	public void removeUPC(UPC upc)
//	{
//		if (upc != null)
//		{
//			getUpcs().remove(upc.getUpc());
//		}
//	}
	
	/**
	 * Adds tax category to the store.
	 * If passed tax category is not equal to null, it adds it to store.
	 * 
	 * @param upc
	 */
//	public void addTaxCategory(TaxCategory taxCategory)
//	{
//		if (taxCategory != null)
//		{
//			getTaxCategories().put(taxCategory.getCategory(), taxCategory);
//		}
//	}
	
	/**
	 * Removes tax category from the store.
	 * If passed tax category is not equal to null, it removes it from the store.
	 * 
	 * @param taxCategory
	 */
//	public void removeTaxCategory(TaxCategory taxCategory)
//	{
//		if (taxCategory != null)
//		{
//			getTaxCategories().remove(taxCategory.getCategory());
//		}
//	}
	
	/**
	 * Looks if tax category is used for any item in the store. 
	 * Returns true if there is item that uses passed tax category, otherwise it returns false.
	 * 
	 * @param taxCategory
	 * @return true if it is used
	 */
//	public boolean isTaxCategoryUsed(TaxCategory taxCategory)
//	{
//		boolean isUsed = false;
//		for (Entry <String, Item> itemEntry : getItems().entrySet())
//			if (taxCategory == itemEntry.getValue().getTaxCategory()) isUsed =true;
//		return isUsed;
//	}
	
	/**
	 * Looks if register is used for any session in the store. 
	 * Returns true if there is session that uses passed register, otherwise it returns false.
	 * 
	 * @param register
	 * @return true if it is used
	 */
//	public boolean isRegisterUsed(Register register)
//	{
//		boolean isUsed = false;
//		for (Session session : getSessions()) 
//		{
//			if (session.getRegister() == register) isUsed =true;
//		}
//		return isUsed;
//	}
	
	/**
	 * Adds register to the store.
	 * If passed register is not equal to null, it adds it to the store.
	 * 
	 * @param register
	 */
	public void addRegister(Register register)
	{
		if (register != null)
		{
			getRegisters().put(register.getNumber(), register);
		}
	}
	
	/**
	 * Removes register from the store.
	 * If passed register is not equal to the null, it removes it from the store.
	 * 
	 * @param register
	 */
	public void removeRegister(Register register)
	{
		if (register != null)
		{
			getRegisters().remove(register.getNumber());
		}
	}
	
	/**
	 * Adds cashier to the store.
	 * If passed cashier is not equal to the null, it adds it to the store.
	 * 
	 * @param cashier
	 */
//	public void addCashier(Cashier cashier)
//	{
//		if (cashier != null)
//		{
//			getCashiers().put(cashier.getNumber(), cashier);
//		}
//	}
	
	/**
	 * Removes the cashier from the store.
	 * If passed cashier is not equal to null, it removes it from the store.
	 * 
	 * @param cashier
	 */
//	public void removeCashier(Cashier cashier)
//	{
//		if (cashier != null)
//		{
//			getCashiers().remove(cashier.getNumber());
//		}
//	}
	
	/**
	 * Adds session to the store.
	 * If session is not equal to the null, it adds it to the store.
	 * 
	 * @param session
	 */
//	public void addSession(Session session)
//	{
//		if (session != null)
//		{
//			getSessions().add(session);
//		}
//	}
//	
	/**
	 * Looks for and returns the ArrayList of all cashiers in the store.
	 * 
	 * @return cashiers
	 */
	public ArrayList getCashierList()
	{
		ArrayList cashierList = new ArrayList();
		for (Entry <String, Cashier> cashierEntry : getCashiers().entrySet())
		{
			cashierList.add(cashierEntry.getValue());
		}
		return cashierList;
	}
	
	/**
	 * Looks for and returns ArrayList of all registers in the store.
	 * 
	 * @return registers
	 */
	public ArrayList getRegisterList()
	{
		ArrayList registerList = new ArrayList();
		for (Entry <String, Register> registerEntry : getRegisters().entrySet())
		{
			registerList.add(registerEntry.getValue());
		}
		return registerList;
	}
	
	/**
	 * Looks for and returns ArrayList of all tax categories in the store.
	 * 
	 * @return tax categories
	 */
	public ArrayList getTaxCategoryList()
	{
		ArrayList tcList = new ArrayList();
		for (Entry <String, TaxCategory> tcEntry : getTaxCategories().entrySet())
		{
			tcList.add(tcEntry.getValue());
		}
		return tcList;
	}
	
	/**
	 * Loads the store.
	 */
	public void openStore()
	{
		StoreDM.loadStore(this);
	}
	
	/**
	 * Looks for and returns array of all items in the store.
	 * 
	 * @return items
	 */
	public String[] getItemList()
	{
		String[] itemList = new String[getItems().entrySet().size()]; 
		int i =0;
		for (Entry<String, Item> entry : getItems().entrySet()) 
		{
	        itemList[i] = (entry.getValue().getDescription());
	        i++;
		}
		return itemList;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the student
	 */
	public TreeMap<String, Student> getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(TreeMap<String, Student> student) {
		this.student = student;
	}

	/**
	 * @return the courses
	 */
	public TreeMap<String, Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(TreeMap<String, Course> courses) {
		this.courses = courses;
	}

	/**
	 * @return the faculty
	 */
	public TreeMap<String, Faculty> getFaculty() {
		return faculty;
	}

	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(TreeMap<String, Faculty> faculty) {
		this.faculty = faculty;
	}

	/**
	 * @return the degree
	 */
	public TreeMap<String, Degree> getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(TreeMap<String, Degree> degree) {
		this.degree = degree;
	}

//	/**
//	 * @return the sessions
//	 */
//	public TreeSet<Session> getSessions() {
//		return sessions;
//	}

//	/**
//	 * @param sessions the sessions to set
//	 */
//	public void setSessions(TreeSet<Session> sessions) {
//		this.sessions = sessions;
//	}
}
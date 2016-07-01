package SOURCE;
//
////public class Schedule {
////
////}
////Find jar from here "http://poi.apache.org/download.html"
//import  java.io.*;
//import  org.apache.poi.hssf.usermodel.HSSFSheet;
//import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import  org.apache.poi.hssf.usermodel.HSSFRow;
//import  org.apache.poi.hssf.usermodel.HSSFCell;
//
//public class CreateExlFile{
//  public void excel() {
//      try {
//          String filename = "C:/NewExcelFile.xls" ;
//          HSSFWorkbook workbook = new HSSFWorkbook();
//          HSSFSheet sheet = workbook.createSheet("FirstSheet");  
//
//          HSSFRow rowhead = sheet.createRow((short)0);
//          rowhead.createCell(0).setCellValue("No.");
//          rowhead.createCell(1).setCellValue("Name");
//          rowhead.createCell(2).setCellValue("Address");
//          rowhead.createCell(3).setCellValue("Email");
//
//          HSSFRow row = sheet.createRow((short)1);
//          row.createCell(0).setCellValue("1");
//          row.createCell(1).setCellValue("Sankumarsingh");
//          row.createCell(2).setCellValue("India");
//          row.createCell(3).setCellValue("sankumarsingh@gmail.com");
//
//          FileOutputStream fileOut = new FileOutputStream(filename);
//          workbook.write(fileOut);
//          fileOut.close();
//          System.out.println("Your excel file has been generated!");
//
//      } catch ( Exception ex ) {
//          System.out.println(ex);
//      }
//  }
//}

public class Schedule{
	
	private String term;
	private String status="Open";
	private String section;
	private String location;
	private String meetingInfo;
	private String faculty;
	private String availability;
	private String ceu;
	private String credits="3";
	private String academicLevel="Graduate";
	private String occupied;
	/**
	 * @return the occupied
	 */
	public String getOccupied() {
		return occupied;
	}
	/**
	 * @param occupied the occupied to set
	 */
	public void setOccupied(String occupied) {
		this.occupied = occupied;
	}
	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the meetingInfo
	 */
	public String getMeetingInfo() {
		return meetingInfo;
	}
	/**
	 * @param meetingInfo the meetingInfo to set
	 */
	public void setMeetingInfo(String meetingInfo) {
		this.meetingInfo = meetingInfo;
	}
	/**
	 * @return the faculty
	 */
	public String getFaculty() {
		return faculty;
	}
	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}
	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	/**
	 * @return the ceu
	 */
	public String getCeu() {
		return ceu;
	}
	/**
	 * @param ceu the ceu to set
	 */
	public void setCeu(String ceu) {
		this.ceu = ceu;
	}
	/**
	 * @return the credits
	 */
	public String getCredits() {
		return credits;
	}
	/**
	 * @param credits the credits to set
	 */
	public void setCredits(String credits) {
		this.credits = credits;
	}
	/**
	 * @return the academicLevel
	 */
	public String getAcademicLevel() {
		return academicLevel;
	}
	/**
	 * @param academicLevel the academicLevel to set
	 */
	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}
	
}
/**
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import POSPD.Item;

/**
 * @author netra
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	String fileName = "STCDUMP.CSV";
		File file = new File(fileName);            //read STCDUMP file
		try{
			Scanner inputSteam = new Scanner(file);
			while(inputSteam.hasNext()){
				String data = inputSteam.next();
				System.out.println(data);
			}
			inputSteam.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}*/
		Student student = new Student();
		//String fileName ="STCDUMP.CSV";
		String fileName ="TestDataFaculty.csv";
		String line = null;
		String[] token;
		String dataType; 
		Student currentSession = null;
		Student currentSale = null;
		student.setFirstName("read");
		student.setLastName("red");
		student.setHourlyRate(10);
		
		//print the state of the current person object
		System.out.println(student.toString());
		System.out.println(student.getPayment(40));
		
		//String fileName = "STCDUMP.CSV";
		//File file = new File(fileName); 
		//File file = new File(fileName);            //read STCDUMP file
		
		try { 
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        //while there is data in file do this
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
		        	if (dataType.equals("M.S"))
		        	{
		        		Faculty store;
						Faculty firstNameFaculty = new Faculty();
		        		System.out.println(dataType);
		        	}
	        }
		}
		 catch(FileNotFoundException ex) 
	    {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    } catch(IOException ex) {
	        System.out.println(
	                "Error reading file '" 
	                + fileName + "'");   	
	    	
	    	}
	}		 
}

package edu.cuny.csi.csc330.fileio;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;


public class XMLSerializer extends BaseSerializer {
	
	private static String fileName = "C://tmp/SerializedPerson.xml";
	

	public XMLSerializer() {
		// TODO Auto-generated constructor stub
	}
	
	public void write(Person f, String filename) throws Exception{
	        XMLEncoder encoder = new XMLEncoder(
	        		   				new BufferedOutputStream(
	        		   							new FileOutputStream(filename) ) );
	        
	        encoder.writeObject(f);
	        encoder.close();
	}

	 public Person read(String filename) throws Exception {
	        XMLDecoder decoder = new XMLDecoder(
	        						new BufferedInputStream(
	                					new FileInputStream(filename) ) );
	        
	        Person o = (Person)decoder.readObject();
	        decoder.close();
	        return o;
	 }
	 
	 public void run() {
		//separate out in 2 methods - write() read()
	   	    Person person = createDummyObject();
	   	    
	   	    Person readPerson; 
		   	
		   	System.out.println(person + "\n");
		         
	        try {
	        	write(person, fileName); 
	        	
	        	readPerson = this.read(fileName);
	        	System.out.println("Read from file:\n" + readPerson);
	        }
	        catch(Exception ex) {
	        	System.err.println(ex);
	        }
	        
	 
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		XMLSerializer serializer = new XMLSerializer();
		
		serializer.run(); 
        

	}

}






  

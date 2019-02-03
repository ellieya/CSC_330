package edu.cuny.csi.csc330.fileio;

import java.util.*;
import java.io.*;

public class SerializableTester extends BaseSerializer  {
	
	
	private static String fileName = "C://tmp/Person.ser";
	private  File file; 
	
	
	public SerializableTester() {
		file = new File(fileName);
	}
	
	public void run() {
		
		write();
		
		read();
        
	}
	
	protected void write() {
    	Person person = this.createDummyObject(); 
         
    	System.out.println(person);
        System.out.println("Begining the serialization process.");
         
        try {   
             
            file.createNewFile();
         
            System.out.println("Serializing Object");
         
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream buf = new BufferedOutputStream(out);
            ObjectOutputStream objOut = new ObjectOutputStream(buf);
            
            // HERE'S WHERE THE MAGIC HAPPENS ... 
            objOut.writeObject(person);
             
            objOut.close();
            buf.close();
            out.close();
             
            System.out.println("Serialization complete.");
             
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ending the serialization process.\n");
       
		
	}
	
	protected void read() {
		
        System.out.println("Begining the deserialization process.");
        try {   
                 
            System.out.println("Deserializing Object");
            
            File file = new File(fileName);
         
            FileInputStream input = new FileInputStream(file);
            BufferedInputStream buf = new BufferedInputStream(input);
            ObjectInputStream objip = new ObjectInputStream(buf);
            
            // HERE'S WHERE THE OTHER SIDE OF THE MAGIC HAPPENS ... 
            Object obj = objip.readObject();
             
            Person person = (Person)obj;
             
            System.out.println(person.toString());
             
            objip.close();
            buf.close();
            input.close();
             
            System.out.println("Deserialization complete.");
             
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        System.out.println("Ending the deserialization process.\n");
	}
	
	
	 
    public static void main(String[] args) {
         
    	SerializableTester tester = new SerializableTester(); 
    	
    	tester.run(); 
 
    }
}

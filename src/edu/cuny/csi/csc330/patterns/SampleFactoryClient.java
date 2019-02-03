package edu.cuny.csi.csc330.patterns;

import java.util.*;
import java.io.*;

public class SampleFactoryClient {
	
	private List myList; 
	private Appendable myBuffer; 
	
	
	public SampleFactoryClient() {
		 init();
	}
	
	private void init() {
		myList = ListCollectionFactory.createList(); 
		myBuffer = AppendableFactory.createAppendable();
		
	}
	
	
	
	@Override
	public String toString() {
		return "SampleFactoryClient [myList=" + myList.getClass().getSimpleName() + ", myBuffer="
				+ myBuffer.getClass().getSimpleName() + "]";
	}

	public void doSomeWork() {
		
		try { 
			for(int i = 0 ; i < 100 ; ++i ) {
				myList.add(i); 
				myBuffer.append(new Date() + " " + i);
			}
		}
		catch (IOException ioex) {
			
		}
		
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SampleFactoryClient client = new SampleFactoryClient();
		client.doSomeWork(); 
		System.out.println(client);
	}

}

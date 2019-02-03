package edu.cuny.csi.csc330.singleton;

import java.util.*;

public class PrintManager {
		 
	
		/////////////////////////////////////////////
		// Single Instance Control 
	    private static PrintManager instance;
	     
	    // preclude creating an instance through default contructor ... 
	    private PrintManager(){
	    	init(); 
	    }
	     
	    public static synchronized PrintManager getInstance(){
	        if(instance == null){
	            instance = new PrintManager();
	        }
	        return instance;
	    }
	    //
	    ////////////////////////////////////////////////
	    
	    private List<StringBuilder> jobQueue; 
	    private static final int INIT_JOBQ_SIZE = 100; 
	    
	    private void init() {
	    	jobQueue = new ArrayList<StringBuilder>(INIT_JOBQ_SIZE); 
	    }
	    
	    public StringBuilder getNextJob() {
	    	StringBuilder job = jobQueue.get(0); 
	    	jobQueue.remove(0); 
	    	return job;
	    }
	    
	    public void submitJob(StringBuilder content) {
	    	jobQueue.add(content); 
	    	return; 
	    }
	    
	    
	    public int queueSize() {
	    	return jobQueue.size(); 
	    }

		@Override
		public String toString() {
			return "SIZE:  " + jobQueue.size() +  "\nPrintManager [jobQueue=" + jobQueue + "]";
		}
	    
	    
	    	

}

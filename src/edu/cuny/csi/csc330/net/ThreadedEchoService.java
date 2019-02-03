/**
o * implements a simple "echo" service binded to an arbitrary service port ... 
 * echos text received back to the client/sender.
 * 
 * telnet localhost port can be used in place of a custom Java client ... 
 * 
 * THIS TIME WE CAN HANDLE CONCURRENT CLIENT REQUESTS - USING JAVA THREADS 
 * 
 */
package edu.cuny.csi.csc330.net;

import java.io.*;
import java.net.*;
import java.util.*;

public class ThreadedEchoService  {
	
	private static final int PORT = 10144; 
	
	private int clientRequestCount = 0; 
	
	public ThreadedEchoService() {
		
	}
	
	public void startUp() {
		
	        ServerSocket echoServer = null;
	        Socket clientSocket = null;

	      
		    try {
		           echoServer = new ServerSocket(PORT);
		           System.out.println("Successfully binded to service port: " + PORT );
		    }
		    catch (IOException e) {
		           System.err.println(" Couldn't bind to service port: " + PORT);
		           System.err.println(e);
		    }   
		        
		        
		    /**
		         * Create a socket object from the ServerSocket to listen and accept connections.
					Open input and output streams
		     */
		    // outer loop waiting for requests 
		    while(true) {
			    try {
			    	   System.out.println("Waiting for Client Connection: " + new Date() );
			    	   
			           clientSocket = echoServer.accept();  // block on service request ... WAIT, WAIT, WAIT 
			           clientRequestCount++; 
			           // HAND OFF WORK TO A THREAD, AND KEEP CYCLING THOUGH service.accept() loop 
			           // pass the clientSocket to child thread 
			           
			           Thread echoThread = new Thread( new EchoThread(clientSocket,clientRequestCount ) ); 
			           echoThread.start();  // run in the  "background" as a thread .... 
			           
			       
			    }   
			    catch (IOException e) {
			           System.err.println(e);
			    }
		}
		    
	}

	
    public static void main(String args[]) {
    	ThreadedEchoService service = new ThreadedEchoService();
    	
    	service.startUp(); 
    	
    }
    	
    	
    	

 
    
}

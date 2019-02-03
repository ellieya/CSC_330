/**
 * implements a simple "echo" service binded to an arbitrary service port ... 
 * echos text received back to the client/sender.
 * 
 * telnet localhost port can be used in place of a custom Java client ... 
 * 
 */
package edu.cuny.csi.csc330.net;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoService  {
	
	private static final int PORT = 10143; 
	
	public EchoService() {
		
	}
	
	public void startUp() {
		
	        ServerSocket echoServer = null;
	        String line;
	        DataInputStream is;
	        PrintStream os;
	        Socket clientSocket = null;
	        boolean exitState = false; 

	      
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
		    // outer loop waiting for client connections  
		    while(true) {
			    try {
			    	   System.out.println("Waiting for Client Connection: " + new Date() );
			    	   
			           clientSocket = echoServer.accept();  // block on service request ... WAIT, WAIT, WAIT 
			           
			           // input stream, output stream 
			           is = new DataInputStream(clientSocket.getInputStream());
			           os = new PrintStream(clientSocket.getOutputStream());
			           
			           int lineCount = 0; 
			           
			           // inner loop waiting for data/conversation 
			           while (true) {
			        	 System.out.println("Waiting for data: " + new Date() );
			        	 // waiting/blocking for data 
			        	 
			        	 // As long as we receive data, echo that data back to the client.
			             line = is.readLine();
			             ++lineCount;
			             // echo back 
			             os.printf("%s (%d)\n", line, lineCount); 
			             
			             System.out.printf("ECHOED %s (%d) BACK TO CLIENT\n\n", line, lineCount); 
			             
			             if(line.toUpperCase().equals("QUIT") )
				             	break;   
			             
			             if(line.toUpperCase().equals("TERMINATE") ) {
			            	 	exitState = true; 
				             	break;  
			             }
			             
			           }
			           
			           if(exitState)
			        	   break; 
			           
			           System.out.printf("Blocked Read terminating\n");
			           
			    }   
			    catch (IOException e) {
			           System.err.println(e);
			        }
			    }
		    
	       }

	
    public static void main(String args[]) {
    	EchoService service = new EchoService();
    	
    	service.startUp(); 
    	
    	System.out.println("Service Exited");
    	
    }
    	
    	
    	

 
    
}

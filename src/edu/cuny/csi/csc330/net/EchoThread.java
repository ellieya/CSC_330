/**
 * implements a simple "echo" service binded to an arbitrary service port ... 
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

public class EchoThread implements Runnable  {
	
	private Socket clientSocket;
	private int threadNumber;
	
	public EchoThread(Socket clientSocket, int threadNumber) {
		this.clientSocket = clientSocket; 
		this.threadNumber = threadNumber;
	}
	
	public void run() {
		
	         String line;
	         DataInputStream is;
	         PrintStream os;
			           
	         try {
				   // input stream, output stream 
				   is = new DataInputStream(clientSocket.getInputStream());
				   os = new PrintStream(clientSocket.getOutputStream());
				           
				   int lineCount = 0; 
				           
				   // wait for client data 
				   while (true) {
				        	 System.out.println("Thread: " + threadNumber + " Waiting for data: " + new Date() );
				        	 // waiting/blocking for data 
				        	 
				        	 // As long as we receive data, echo that data back to the client.
				             line = is.readLine();
 
				             ++lineCount;
				             os.printf("%s (%d)\n", line, lineCount); 
				             
				             if(line.toUpperCase().equals("QUIT") )
					             	break;   
				    }
				   
				    System.out.printf("Thread # %d terminating\n", threadNumber);
				   
	            }
			    catch (IOException e) {
			           System.err.println(e);
			    }
			    
	}

    
}

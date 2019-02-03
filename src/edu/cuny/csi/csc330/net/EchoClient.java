package edu.cuny.csi.csc330.net;

import java.io.*;
import java.net.*;

public class EchoClient {
	
	private final static String serverHostname = "localhost";
	private static int servicePort = 10143;


	public static void main(String[] args) throws IOException {

		int servicePort = EchoClient.servicePort;
		if (args.length > 0)
			servicePort = Integer.parseInt(args[0]);
		
		
		System.out.printf("Attemping to connect to %s %d\n", serverHostname, servicePort);

		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		int messageCount = 0; 

		try {
			echoSocket = new Socket(serverHostname, servicePort);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader( echoSocket.getInputStream()));
		} 
		catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + serverHostname);
			System.exit(1);
		} 
		catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: "
					+ serverHostname);
			System.exit(2);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader( System.in ) );
		String userInput;

		System.out.println("Type Text To be echoed (\"quit\" to exit client program)");
		
		while ((userInput = stdIn.readLine()) != null) {
			out.printf("[%d]  %s\n", ++messageCount, userInput); 

			// end loop
			if (userInput.equalsIgnoreCase("quit"))
				break;

			System.out.println("echo: " + in.readLine());
		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
		
		
	}

}

package edu.cuny.csi.csc330.radio;

import java.io.*;
import java.util.*;


public class RadioController {
	
	protected final static String DEFAULT_SCRIPT_FILE_NAME = "C://tmp//RadioScript.txt";
	
	private String scriptFileName;
	private Radio radio;
	private StringBuilder script; 
	private boolean isReady; 
	
	
	// default constructor 
	public RadioController() {
		init(); 
	}
	
	/**
	 * Utility method that pauses execution for N seconds 
	 * @param seconds
	 */
	protected static void pause(int seconds) {
		try {
		    Thread.sleep(seconds * 1000); //  Thread.sleep works in milliseconds .... 
		} 
		catch(InterruptedException ex) {
		    ;
		}
	}
	
	/**
	 * called by constructor 
	 */
	private void init() {
		
		// basic setup 
		scriptFileName = DEFAULT_SCRIPT_FILE_NAME; 
		 
		if(System.getProperty("SCRIPT_FILE") != null  ) {
			scriptFileName = System.getProperty("SCRIPT_FILE"); 
		}
		
		radio = new Radio(); 
		
		script = new StringBuilder(); 
		
		// load the script 
		isReady = loadScript(); 
	
		
	}
	
	/**
	 * load the script body based on the scriptFileName 
	 * @return
	 */
	protected boolean loadScript() {
		
		File scriptFile = new File(scriptFileName);
		
		if(scriptFile.exists() == false) {
			System.err.println("Cannot open file:  " + scriptFileName ); 
			return false; 
		}
		
	    try {
	    	FileReader fileReader = new FileReader(scriptFile.getAbsolutePath());  
	    	BufferedReader bufferedReader = new BufferedReader(fileReader);
	    	String line; 
	    	while( ( line = bufferedReader.readLine() ) != null ) {
	    		
	    		if(line.length() == 0 ||  line.startsWith("#" )  )  
	    			continue; 
	    		
	            script.append( line + "\n" );
	            
	        }
		      
	    	fileReader.close();

	    } 
	    catch (Exception ex) {
		      System.err.println(ex );
		      return false; 
	    }
		
		return true; 
	}
	
	/** execute operations on Radio instance based on script commands 
	 */
	protected void executeScript()  {
		
		StringTokenizer lines = new StringTokenizer(script.toString(), "\n"); 
		// for each line 
		while(lines.hasMoreTokens()) {
			String line = lines.nextToken(); 
			// System.out.println(line);
			StringTokenizer fields = new StringTokenizer(line);
			int noOfFields = fields.countTokens();
			String [] commandArgs = new String[noOfFields]; 
			int f = 0; 
			// for each field 
			while(fields.hasMoreTokens()) {
				commandArgs[f] = fields.nextToken(); 
				++f;
			}
			// execute the command 
			executeCommand(commandArgs); 
		}
		
	}
	
	
	/**
	 * show the state of the radio instance 
	 * @param commandArgs
	 */
	protected void displayRadio(String [] commandArgs) {
		
		System.out.println(Arrays.toString(commandArgs)); 
		System.out.println(radio + "\n\n"); 
		
	}
	
	protected void executeCommand(String [] commandArgs) {
		
		String command = commandArgs[0].toLowerCase(); 
		
		switch (command)  {
			case "on":
				radio.on(); 
				break; 
			case "off":
				radio.off(); 
				break; 
			case "band":
				radio.setSelectedBand(commandArgs[1]); 
				break; 
			case "station":
				radio.setSelectedStation(Double.parseDouble(commandArgs[1] ) ); 
				break; 
			case "volume":
				radio.setVolume( Integer.parseInt(commandArgs[1] ) ); 
				break; 
			case "treble":
				radio.setSelectedTrebleLevel(Integer.parseInt(commandArgs[1] ) ); 
				break; 
			case "bass":
				radio.setSelectedBassLevel(Integer.parseInt(commandArgs[1] ) ); 
				break; 
			case "pause":
				RadioController.pause(Integer.parseInt(commandArgs[1]) ); 
				break; 
			case "preset":
				int position = Integer.parseInt(commandArgs[1]); 
				double station = Double.parseDouble(commandArgs[2]); 
				radio.assignToPreset(position, station ); 
				break; 
			case "use_preset": 
				radio.selectFromPreset( Integer.parseInt(commandArgs[1]) ); 
				break; 
			
			default:
					System.err.println("unrecognized command: " +  command ); 
					break; 
		}
		
		displayRadio(commandArgs);
		
	}
	
	public void start() {
		
		if(isReady == false || script.length() == 0 ) {
			System.err.println(getClass().getName() + ": could not load script - nothing to execute");
			return; 
		}
		
		// radio.on();
		
		executeScript();  
		
	}
	

	@Override
	public String toString() {
		return "RadioController [scriptFileName=" + scriptFileName
				+ "\n\nScript=\n" + script + "\nisReady=" + isReady + "]\n";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create instance of Radio  
		RadioController controller = new RadioController();  
		
		/*
		 * READ IN A SCRIPT THAT LOOKS SOMETHING LIKE THIS:
		 * ON 
		 * BAND FM 
		 * VOLUME 40  
		 * VOLUME 19 
		 * PRESET 4 101.5 
		 * USE_PRESET 4
		 * STATE
		 * PAUSE 10 
		 * OFF 
		 * PAUSE 2
		 * ON 
		 * BAND AM 
		 * STATION 660
		 * PAUSE 10 
		 * OFF  
		 */
		
		System.out.println(controller);
		
		controller.start();  
		
		
	}

}

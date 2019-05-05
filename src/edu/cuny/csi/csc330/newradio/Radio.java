/**
 * Not all applications are designed and implemented to process repetitive data, 
 * interact with a user through a web browser, etc.
 * Sometimes, we model a physical object in software - to perhaps:
 * 	- simulate a design of a product before we build it 
 *  - control a physical device through user provided controls - or an event/time driven control 
 *  
 *   So this is an attempt to MODEL the structure and operation of an appliance we've all used: a radio
 *      likely a car radio. 
 *   
 */

package edu.cuny.csi.csc330.newradio;

import java.util.*;

import edu.cuny.csi.csc330.lab1.*;
import edu.cuny.csi.csc330.lib.Randomizer;

// Radio Class definition  
public class Radio {
	
	
	/**
	 *  group Band radio band information into nested inner Classes  
	 * static data and methods specific to AM/FM banding 
	 */
	public static class Bands {
		
		public static double [] generateInitialPresets(int size, double from, double to) {
			Randomizer randomizer = new Randomizer(); 
			double [] presets = new double[size];
			
			for(int i = 0 ; i  < presets.length ; i++ ) {
				presets[i] = randomizer.generateInt(from, to);
			}
			
			return presets;
		}
		
		static public class AM { 
			public final static String name = "AM";
			public final static int MAX_SELECTIONS = 8;
			public final static double LOW_STATION = 530;
			public final static double HIGH_STATION = 1200;
			// create initial AM BAND settings - RANDOM 
			public static double [] generateInitialPresets() {
				return Bands.generateInitialPresets(MAX_SELECTIONS, LOW_STATION, HIGH_STATION);
			}
		}
		public static class FM { 
			public final static String name = "FM";
			public final static int MAX_SELECTIONS = 12;
			public final static double LOW_STATION = 88.30;
			public final static double HIGH_STATION = 107.10;
			// create initial FM BAND settings - RANDOM 
			public static double [] generateInitialPresets() {
				return Bands.generateInitialPresets(MAX_SELECTIONS, LOW_STATION, HIGH_STATION);
			}
		}
	}
	

	/////////////////////////////////////////
	// Misc static constants 
	protected static final int MIN_VOLUME = 0;
	protected static final int MAX_VOLUME = 20;
	protected static final int DEFAULT_VOLUME = 5;
	protected static final String DEFAULT_BAND = Bands.AM.name;
	protected static final double DEFAULT_STATION = 770;
	protected static final int DEFAULT_BALANCE = 0;
	protected static final int DEFAULT_TREBLE = 3;
	protected static final int DEFAULT_BASS = 2;
	

	// Object instance properties ... 
	private boolean powerState; 
	private int selectedVolume;
	private double selectedStation;
	private String selectedBand;
	private double[] amPresets;
	private double[] fmPresets;
	private Date firstTimeOn;
	private Date lastTimeOn;
	private String serialNumber; 
	private int selectedBalance; 
	private int selectedBassLevel; 
	private int selectedTrebleLevel; 

	// the default and only constructor  
	public Radio() {
		init(); 
	}
	
	/**
	 * initialize - Only gets invoked by constructor 
	 */
	private void init() {
		// serial number 
		Randomizer randomizer = new Randomizer(); 
		Integer irand = randomizer.generateInt(11111111, 99999999); 
		this.serialNumber = new Date().getTime() + ":" + irand.toString(); 
	}
				

	/**
	 * turn on the radio instance 
	 */
	public void on() throws RadioException  {
		
		if(this.isOn() )  
			throw new RadioException("on() method",  RadioException.INVALID_STATE_CHANGE);  
		
		Date now = new Date(); 
		
		// all the things we need to do the 1st time we turn on the instance ... 
		if(firstTimeOn == null) {
			// create pre-sets arrays - have the inner classes do it for us 
			amPresets = Bands.AM.generateInitialPresets();  
			fmPresets = Bands.FM.generateInitialPresets();  
			firstTimeOn = now; 
			// selectedVolume & station 
			selectedVolume = DEFAULT_VOLUME; 
			selectedBand = DEFAULT_BAND;
			selectedStation = DEFAULT_STATION; 
			// tone and balance 
			selectedBalance = DEFAULT_BALANCE; 
			selectedTrebleLevel = DEFAULT_TREBLE; 
			selectedBassLevel = DEFAULT_BASS; 
		}
		
		powerState = true; 
		lastTimeOn = now; 
		
	}
	
	/**
	 * turn off the radio instance 
	 */
	public void off() throws RadioException  {
		
		if(this.isOn() == false )  
			throw new RadioException("off() method",  RadioException.INVALID_STATE_CHANGE);  
		
		
		powerState = false; 
		
	}


	/**
	 * is the radio powerState on/off??
	 * @return
	 */
	public boolean isOn() {
		return powerState == true;
	}
	
	
	public int getVolume() {
		return selectedVolume;
	}

	public void setVolume(int volume) throws RadioException {
		if(volume < Radio.MIN_VOLUME || volume > Radio.MAX_VOLUME )  
			throw new RadioException("setVolume() method",  RadioException.INVALID_RANGE);  
		
		this.selectedVolume = volume;
	}
	
	public void decreaseVolume(int volume) {
		this.selectedVolume -= volume;
	}
	
	public void increaseVolume(int volume) {
		this.selectedVolume += volume;
	}

	public double getSelectedStation() {
		return selectedStation;
	}

	public void setSelectedStation(double selectedStation) {
		this.selectedStation = selectedStation;
	}

	public String getSelectedBand() {
		return selectedBand;
	}

	public void setSelectedBand(String selectedBand) {
		this.selectedBand = selectedBand;
	}

	public double[] getFmPresets() {
		return fmPresets;
	}


	public Date getFirstTimeOn() {
		return firstTimeOn;
	}
	

	public int getSelectedBalance() {
		return selectedBalance;
	}

	public void setSelectedBalance(int selectedBalance) {
		this.selectedBalance = selectedBalance;
	}

	public int getSelectedBassLevel() {
		return selectedBassLevel;
	}

	public void setSelectedBassLevel(int selectedBassLevel) {
		this.selectedBassLevel = selectedBassLevel;
	}

	public int getSelectedTrebleLevel() {
		return selectedTrebleLevel;
	}

	public void setSelectedTrebleLevel(int selectedTrebleLevel) {
		this.selectedTrebleLevel = selectedTrebleLevel;
	}

	// Assign Band Presets - to current band 
	public void assignToPreset( int position, double station) {
		if(Bands.AM.name.equals(this.selectedBand)) {
			this.amPresets[position - 1] = station; 
		}
		else if(Bands.FM.name.equals(this.selectedBand)) {
			this.fmPresets[position - 1] = station; 
		}
	}
	
	// Select from Preset - from current band 
	public void selectFromPreset(int position) {
		if(Bands.AM.name.equals(this.selectedBand)) {
			this.selectedStation = this.amPresets[position - 1]; 
		}
		else if(Bands.FM.name.equals(this.selectedBand)) {
			this.selectedStation = this.fmPresets[position - 1]; 
		}
	}
	



	@Override
	public String toString() {
		return "Radio Instance: " + "[SerialNumber=" + serialNumber + 
				", powerState=" + powerState + ", selectedVolume="
				+ selectedVolume + ", selectedStation=" + selectedStation  
				+ ", selectedBand=" + selectedBand + ",\n amPresets="
				+ Arrays.toString(amPresets) + ",\n fmPresets="
				+ Arrays.toString(fmPresets) + ",\n firstTimeOn=" + firstTimeOn
				+ ", lastTimeOn=" + lastTimeOn + ", selectedBalance=" + selectedBalance
				+ ", selectedBassLevel=" + selectedBassLevel
				+ ", selectedTrebleLevel=" + selectedTrebleLevel + "]\n";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Radio radio = new Radio();  
		System.out.println("New Instance\n" + radio + "\n");
		
		try { 
		
			// Create instance of - power up & down ... other ops, and 
			//  display the powerState of the Radio instance 
			
			// turn it on
			radio.on(); 
			radio.on();
			System.out.println("Turned On\n" + radio + "\n");
			
			// select FM Band & a station 
			radio.setSelectedBand(Radio.Bands.FM.name); 
			radio.setSelectedStation(92.3); 
			System.out.println("Changed Station\n" + radio + "\n");
			
			// assign a station to a preset on FM 
			radio.assignToPreset(1,  101.1); 
			radio.selectFromPreset(1);
			System.out.println("Assign Preset [1] to + " + radio.getSelectedBand() + "\n" + radio + "\n");
			
			// Turn off radio 
			radio.off(); 
			System.out.println("Turned Off\n" + radio + "\n");
			
		}
		catch(RadioException re ) {
			System.err.println(re); 
		}
		finally {
			System.out.println(radio.getClass().getName() + " Completed Simple Test"); 
		}

	}

}

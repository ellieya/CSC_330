/**
 * LAB 3 - Sweetmillion Lotto QuickPicker Game 
 */
package edu.cuny.csi.csc330.lab3;

import java.util.*;
import edu.cuny.csi.csc330.lib.*;

public class SweetMillionGame {
	
	// constants  specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1; 
	private final static String GAME_NAME = "Sweet Million"; 
	private final static int SELECTION_POOL_SIZE = 40; 
	private final static int SELECTION_COUNT = 6; 


	public SweetMillionGame() {
		init(DEFAULT_GAME_COUNT); 
	}
	
	public SweetMillionGame(int games) {
		init(games); 
	}
  

	private void init(int games) {
		
		/**
		 * 
		 * Now what ... START FROM HERE 
		 * What additional methods do you need?
		 * What additional data properties/members do you need? 
		 */
		
		
	}
	


	/**
	 * 
	 */
	public void displayTicket() {
		
		/**
		 * display heading 
		 * 
		 * for i in gameCount 
		 * 		generate selectionCount number of unique random selections in ascending order 
		 * 
		 * display footer 
		 */
		
		
		
		// display ticket heading 
		displayHeading(); 
		
		
		
		/**
		 * Display selected numbers 
		 */

		
		
		// display ticket footer 
		displayFooter(); 
		
		return;
	}
	
	protected void displayHeading() {
	 
		
	}
	
	protected void displayFooter() {
		 
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	private long calculateOdds() {
 
		
		return 0;
	}
  

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// takes an optional command line parameter specifying number of QP games to be generated
		//  By default, generate 1  
		int numberOfGames  = 1; 
		if(args.length > 0) {
			numberOfGames = Integer.parseInt(args[0]);
		}
		
		SweetMillionGame game = new SweetMillionGame(numberOfGames);
		// now what 
		 
		game.displayTicket(); 
		
		// COMMENT THIS OUT WHEN YOU'RE DONE ... 
		System.out.println("Leaving ...");

	}

}

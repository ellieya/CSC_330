/**
 * LAB 3 - Sweetmillion Lotto QuickPicker Game 
 */
package edu.cuny.csi.csc330.lab3;

import java.math.BigInteger; //Required for factorial calculation
import java.util.*;

import edu.cuny.csi.csc330.lib.*;

public class SweetMillionGame {
	
	// constants specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1; 
	private final static String GAME_NAME = "Sweet Million"; 
	private final static int SELECTION_POOL_SIZE = 40; 
	private final static int SELECTION_COUNT = 6;
	private final static String STORE_NAME = "Some Store";
	
	/**
	 * Array #1 represents the games. Array #2 (inside array #1) represents the numbers generated for that game.
	 */
	private int[][] gamesList;


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
		
		gamesList = new int[games][SELECTION_COUNT];
		
		
	}
	
	private void generateNos() {
		boolean duplicateFlag;
		int holder = 0; //Temporary holder

		
		for (int i = 0; i < gamesList.length; i++) {
			/*
			 * START - Loop for per game
			 */
			
			for (int j = 0; j < gamesList[i].length; j++) {
				/*
				 * START - Loop for per # in per game
				 */
				

				do {
					//Reset or initialize duplicateFlag
					duplicateFlag = false;
					holder = Randomizer.generateInt(1, SELECTION_POOL_SIZE);

					//Duplicate search
					/*
					 * j is equal to numbers processed thus far in current (i) game,
					 * used to keep current # of identified no's in the nested array
					 * so as to avoid additional iterations that we do not need
					*/
					for (int k = 0; k < j; k++) {	
						//If match found, set off flag
						if (holder == gamesList[i][k])
							duplicateFlag = true;
					}

				} while (duplicateFlag); //If flag set off, loop is continued until unique number is generated

				//When falls out of duplicate search loop, store holder into gamesList's numbers array
				gamesList[i][j] = holder;
				
				/*
				 * END - Loop for per # in per game
				 */
			}
			//Sort numbers in the game after completion
			Arrays.sort(gamesList[i]);
			
			
			/*
			 * END - Loop for per # in per game
			 */
		}		
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
		
		
		
		//Print game-specific heading w/ date/time
		// display ticket heading 
		displayHeading(); 
		
		

		/**
		 * Display selected numbers 
		 */
		//Print numbers w/ games numbered, starting from 1 w/ even formatting & 0 padding
		for (int i = 0; i < gamesList.length; i++) {
			System.out.printf("(%3d) ", i+1);
			for (int j = 0; j < gamesList[i].length; j++) {
				System.out.printf("%02d ", gamesList[i][j]);
			}
			System.out.println();
			
		}
		
		// display ticket footer 
		displayFooter(); 
		
		return;
	}
	
	protected void displayHeading() {
		Date now = Calendar.getInstance().getTime();
		
		//Print header
		System.out.println("* * * * * * * * * * * * * * * * * * * *");
		System.out.printf(" %15s ~ %-15s%n", STORE_NAME.toUpperCase(), GAME_NAME);
		System.out.println("* * * * * * * * * * * * * * * * * * * *");
		
		//Print formatted date/time
		System.out.println("\n" + now + "\n");
		
		
	}
	
	protected void displayFooter() {
		//Print odds of winning
		System.out.println("\nChances of winning: 1 in " + calculateOdds() + "\n");
		
		//Print footer
		System.out.println("* * * * * * * * * * * * * * * * * * * *");
		System.out.printf(" %15s ~ %-15s%n","Ellie Chen","CSC 330 Lab 3");
		System.out.println("* * * * * * * * * * * * * * * * * * * *");
	}
	
	
	
	
	private BigInteger calculateFactorial(int num) {
		BigInteger product = new BigInteger("1");
		for (int i = num; i >= 1; i--)
			product = product.multiply(BigInteger.valueOf(i));
			
		return product;
	}
	
	/**
	 * I calculated the odds of winning by using the combination formula, n!/(r!(n-r)!.
	 * In order to implement this, I would need to create a method for calculating the factorial.
	 * I had succeeded initially, but then noticed that when I calculated !40, I received a negative number.
	 * I assumed this was due to overflow from too large of a number, so in order to circumvent this,
	 * I used the java.Math data type "BigInteger", which allowed me to store numbers greater than 2,147,483,647.
	 * I then used BigInteger's built-in functions to perform arithmetic operations.
	 * @return
	 */
	
	private BigInteger calculateOdds() {
		
		//formula n!/(r!(n-r)! where n = SELECTION_POOL_SIZE and r = SELECTION_COUNT
		BigInteger n = calculateFactorial(SELECTION_POOL_SIZE);
		BigInteger r = calculateFactorial(SELECTION_COUNT);
		BigInteger nSubR = calculateFactorial(SELECTION_POOL_SIZE - SELECTION_COUNT);
		
		return n.divide(r.multiply(nSubR));
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
		//Generate and sort numbers
		game.generateNos();
		game.displayTicket(); 
		
		// COMMENT THIS OUT WHEN YOU'RE DONE ... 
		//System.out.println("Leaving ...");

	}

}

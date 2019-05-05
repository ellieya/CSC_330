package edu.cuny.csi.csc330.lab6;

import java.math.BigInteger; //Required for factorial calculation
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import edu.cuny.csi.csc330.lib.Randomizer;

public class QuickPicker {
	
	// constants specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1;
	public final static int MAX_POSSIBLE_POOLS = 2;
	private String gameName = "Sweet Million"; 
	
	private int poolCount = -1; //Initialized to -1 for a check in init
	private int[] selectionSize = new int[MAX_POSSIBLE_POOLS];
	private int[] selectionCount = new int[MAX_POSSIBLE_POOLS];
	private String vendor;
	
	
	/**
	 * Array #1 represents a game from a pool. Array #2 represents the games. Array #3 (inside array #2) represents the numbers generated for that game.
	 */
	private int[][][] gamesList;


	private QuickPicker() {
		//intentionally blank 
	}
	
	public QuickPicker(String gameName, int games) throws QuickPickerException {
		try {
			init(gameName, games);
		} catch (QuickPickerException e) {
			throw e;
		}
	}
	
	/**
	 * Supporting function of init. Sends Pool1 or Pool2 value and gets selection size/count through string tokenizer.
	 */
	public String[] getPoolNumbers(String target) {
		
		String[] holder = new String[MAX_POSSIBLE_POOLS];
		StringTokenizer tokenizer = new StringTokenizer(target, "/");
		
		int i = 0;
		while (tokenizer.hasMoreElements()) {
			holder[i] = tokenizer.nextToken();
			i++;
		}
		
		return holder;
	}
  
	private void init(String gameName, int games) throws QuickPickerException {
		String holder = new String();
		String[] poolHolder = new String[2];

		
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(gameName);
			// If the properties file contains everything we need, then proceed with
			// program.
			// Otherwise, throw exception.
			if (bundle.containsKey("GameName") && bundle.containsKey("Pool1") && bundle.containsKey("Pool2")
					&& bundle.containsKey("Vendor")) {

				// Populate variables with info from properties file
				this.gameName = bundle.getString("GameName");
				vendor = bundle.getString("Vendor");

				// POOL SIZE
				// Populate selectionSize & selectionCount.
				for (int i = 0; i < MAX_POSSIBLE_POOLS; i++) {
					holder = bundle.getString("Pool" + (i + 1));
					poolHolder = getPoolNumbers(holder);
					selectionCount[i] = Integer.parseInt(poolHolder[0]);
					selectionSize[i] = Integer.parseInt(poolHolder[1]);

					// If selectionCount[i] is ever equal to 0 then it means it's using i pools
					if (selectionCount[i] == 0) {
						poolCount = i;
					}
				}

				// If poolCount never got updated, then it means that poolCount has to be MAX
				if (poolCount == -1) {
					poolCount = MAX_POSSIBLE_POOLS;
				}

				// Update gamesList
				// i represents poolCount no.; j represents game no.
				gamesList = new int[poolCount][games][];
				for (int i = 0; i < poolCount; i++) {
					for (int j = 0; j < games; j++) {
						gamesList[i][j] = new int[selectionCount[i]];
					}
				}

			} else {
				throw new QuickPickerException(gameName, 1);
			}
		} catch (MissingResourceException e) {
			throw new QuickPickerException(gameName, 0);
		}
		
		
		
	}
	
	private void generateAllNos() {
		for (int i = 0; i < gamesList.length; i++) {
			generateNos(i);
		}
	}
	
	private void generateNos(int poolIndex) {
		
		boolean duplicateFlag;
		int holder = 0; //Temporary holder

		for (int i = 0; i < gamesList[poolIndex].length; i++) {
			/*
			 * START - Loop for per game
			 */
			
			for (int j = 0; j < gamesList[poolIndex][i].length; j++) {
				/*
				 * START - Loop for per # in per game
				 */

				do {
					//Reset or initialize duplicateFlag
					duplicateFlag = false;
					holder = Randomizer.generateInt(1, selectionSize[poolIndex]);

					//Duplicate search
					/*
					 * j is equal to numbers processed thus far in current (i) game,
					 * used to keep current # of identified no's in the nested array
					 * so as to avoid additional iterations that we do not need
					*/
					for (int k = 0; k < j; k++) {	
						//If match found, set off flag
						if (holder == gamesList[poolIndex][i][k])
							duplicateFlag = true;
					}

				} while (duplicateFlag); //If flag set off, loop is continued until unique number is generated

				//When falls out of duplicate search loop, store holder into gamesList's numbers array
				gamesList[poolIndex][i][j] = holder;
				
				/*
				 * END - Loop for per # in per game
				 */
			}
			//Sort numbers in the game after completion
			Arrays.sort(gamesList[poolIndex][i]);
			
			
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
		//The first gamesList is used because they all share the same game size
		for (int g = 0; g < gamesList[0].length; g++) {
			System.out.printf("(%3d) ", g + 1);
			
			//NOTE: poolCount must be used here, because regardless of 
			for (int p = 0; p < gamesList.length; p++) {
				for (int i = 0; i < gamesList[p][g].length; i++) {
					System.out.printf("%02d ", gamesList[p][g][i]);
				}
				
				if (p == gamesList.length - 1) {
					System.out.println();
				} else {
					System.out.print(" | ");
				}
			}
		}
		// display ticket footer 
		displayFooter(); 
		
		return;
	}
	
	protected void displayHeading() {
		Date now = Calendar.getInstance().getTime();
		
		//Print header
		System.out.println("* * * * * * * * * * * * * * * * * * * *");
		System.out.printf(" %15s ~ %-15s%n", vendor.toUpperCase(), gameName);
		System.out.println("* * * * * * * * * * * * * * * * * * * *");
		
		//Print formatted date/time
		System.out.println("\n" + now + "\n");
		
		
	}
	
	protected void displayFooter() {
		//Print odds of winning
		System.out.println("\nChances of winning: 1 in " + calculateOdds() + "\n");
		
		//Print footer
		System.out.println("* * * * * * * * * * * * * * * * * * * *");
		System.out.printf(" %15s ~ %-15s%n","Ellie Chen","CSC 330 Lab 6");
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
	
	private BigInteger calculateCombination(int selectionSize, int selectionCount) {
		
		//formula n!/(r!(n-r)! where n = SELECTION_POOL_SIZE and r = SELECTION_COUNT
		BigInteger n = calculateFactorial(selectionSize);
		BigInteger r = calculateFactorial(selectionCount);
		BigInteger nSubR = calculateFactorial(selectionSize - selectionCount);
		
		return n.divide(r.multiply(nSubR));
	}
	
	private BigInteger calculateOdds() {
		BigInteger[] arrHolder = new BigInteger[gamesList.length];
		BigInteger resultHolder;
		
		//Hold calculated values into arrHolder
		for (int i = 0; i < arrHolder.length; i++) {
			arrHolder[i] = calculateCombination(selectionSize[i], selectionCount[i]);
		}
		
		//Place initial value into resultHolder and multiply against odds of all other pools for final result
		resultHolder = arrHolder[0];
		for (int i = 1; i < arrHolder.length; i++) {
			resultHolder = resultHolder.multiply(arrHolder[i]);
		}
		
		return resultHolder;
	}
  

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// takes an optional command line parameter specifying number of QP games to be generated
		//  By default, generate 1  
		int numberOfGames  = 1; 
		if(args.length > 1) {
			numberOfGames = Integer.parseInt(args[1]);
		}
		
		QuickPicker game;
		try {
			game = new QuickPicker(args[0], numberOfGames);
			//Generate and sort numbers
			game.generateAllNos();
			game.displayTicket(); 
		} catch (QuickPickerException e) {
			System.err.println(e);
		}

		

	}

}

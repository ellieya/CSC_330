/**
 * DealOrNoDealer 
 * 
This FinalProject models activity is a "special" version of the "Deal or No Deal" game.

Background: 
The 'Monty Hall problem' is named for its similarity to the Let's Make a Deal 
television game show hosted by Monty Hall. The 'problem' is stated as follows: 

	Assume that a room is equipped with three doors. Behind two are goats, and behind 
	the third is a shiny new car. 
	You are asked to pick a door, and will win whatever is behind it. 
	Let's say you pick door 1. Before the door is opened, however, someone who 
	knows what's behind the doors (Monty Hall) opens one of the other two doors, revealing a goat, 
	and asks you if you wish to change your selection to the third door (i.e., the door which neither 
	you picked nor he opened). 
	
The Monty Hall problem is deciding whether you should trade or stay – statistically!
Odds: 1/3 chance of winning the desired prize if we don't switch.
      2/3 chance of winning the desired prize if we do switch.
Why?  there's only one door left unopened - either the player stays or switches.
So the original selection still has a 1/3 chance of being the winner.  
You've been given additional information since the selection was made increasing the odds on the only other door you didn't pick.  
So, 1 - 1/3 = 2/3 

This is somewhat counter-intuitive ... most people believe it's a 50/50 proposition.  
Let's make the same argument with a much greater impact on the odds.  
Applying the “Monty Hall Problem” premise to ‘Deal or No Deal’ game, let's imagine that 
the contestant chooses one briefcase from a selection of 26. 
Each briefcase contains a cash value from $.01 to $1,000,000. 
Over the course of the game, the contestant eliminates the other cases, 
periodically being presented with a "deal" from The Banker to take a cash amount to quit the game. 
Assuming the player makes it all the way to opening 24 of the 25 cases not selected, and the $1,000,000 prize has not been opened yet, 
should the contestant accept the chance to exchange exchange case selected with the only other case left unopened?  
Well, here the case is even more compelling:  
Odds: 1/26 (~4%) chance of winning the desired prize if we don't switch.
      25/26 chance of winning the desired prize if we do switch.
Why? Same reason!  There's only one case left unopened - either the player stays or switches.
So the original selection still has a 1/26 chance of being the winner.  
You've been given LOTS of additional information since the selection was made increasing the 
odds on the only other case you didn't pick.  
1 - 1/26 = 25/26

THIS PROGRAM ALLOWS US TO PROVE THIS POINT - VERY QUICKLY - IN SECONDS, WITHOUT NEEDING TO MANUALLY SIMULATE THE GAME OF CHANCE ACTIVITY
 * 
 */

// package 
package edu.cuny.csi.csc330.stats.dond;

// Core Java entities used 
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Class Declaration  
public class DealOrNoDealer {

	private static final int DEFAULT_GAME_COUNT = 500;
	private static final int PRINT_LIMIT = 10;

	private List<Game> history;

	private DealOrNoDealGame game;
	private int winCount; 
	private int gameCount;

	/*
	 * Inner Class History ... the selectedCase, switched and won booleans
	 */
	private class Game {
		private Case selectedCase;
		boolean switched;
		boolean won;

		public Game(Case selectedCase, boolean switched, boolean won) {
			this.selectedCase = selectedCase;
			this.switched = switched;
			this.won = won;
		}

		public boolean getSwitched() {
			return switched;
		}

		public boolean getWon() {
			return won;
		}

	}

	public DealOrNoDealer(int gameCount) {
		this.gameCount = gameCount;
		init();
	}

	private void init() {

		game = new DealOrNoDealGame();
		history = new ArrayList<Game>(512);

	}

	private void saveToHistory() {

		boolean switched = game.getUnopenedCase() == game.getPlayerChoice();
		boolean won = game.getPlayerChoice().getValue() == DealOrNoDealGame.TOP_PRIZE;

		history.add(new Game(game.getPlayerChoice(), switched, won));

	}

	public void reset() {
		this.history.clear();
		winCount = 0;
	}

	/**
	 * determine % of win when stay vs % win when swtched
	 */
	public void displaySummary() {
		int totalGames = this.history.size();
		int gamesWon = 0;
		int gamesWonWhenSwitched = 0;
		int gamesSwitched = 0;
		int gamesWonWhenKept = 0;

		for (Game g : history) {
			// Won
			if (g.getWon()) {
				++gamesWon;
				if (g.getSwitched())
					++gamesWonWhenSwitched;
			}
			// Case Kept
			if (g.getSwitched() == false) {
				if (g.getWon())
					++gamesWonWhenKept;
			} else { // Switched
				gamesSwitched++;
			}
		}

		int gamesLost = totalGames - gamesWon;
		int gamesKept = totalGames - gamesSwitched;

		double percentWonWhenKept = ((double) gamesWonWhenKept / (double) gamesKept) * 100;
		double percentWonWhenSwtiched = ((double) gamesWonWhenSwitched / (double) gamesSwitched) * 100;

		// % of winning when switch
		// % of winning when not switching
		System.out.printf(
				"Player Won %,4d of %,4d games (%4.1f%%) when case was kept.%n",
				gamesWonWhenKept, gameCount, percentWonWhenKept);
		System.out.printf(
				"Player Won %,4d of %,4d games (%4.1f%%) when case was switched.%n",
					gamesWonWhenSwitched, gameCount, percentWonWhenSwtiched);

	}

	/**
	 * game cycle ... play gameCount times - keep and trade 
	 * 
	 */
	public void play() {

		System.out
				.println("====================================================================================================");
		System.out.printf("%75s%n",
				"GAMES WHERE THE PLAYER KEPT THE CASE ORIGINALLY SELECTED");

		// keep case ...
		simulateGames(false);

		System.out
				.println("----------------------------------------------------------------------------------------------------");
		System.out.printf("%75s%n",
				"GAMES WHERE THE PLAYER TRADED THE CASE ORIGINALLY SELECTED");

		// trade / switch case ...
		simulateGames(true);

		System.out
				.println("----------------------------------------------------------------------------------------------------");
		this.displaySummary();
		System.out
				.println("====================================================================================================");

		reset();

	}

	/*
	 * critical method that runs through N number of Game 
	 * simulations - if flag arg = true, we trade/switch, otherwise we keep orig choice  
	 */
	private void simulateGames(boolean tradeCase) {

		for (int i = 0; i < gameCount; ++i) {
			game.pick(i + 1);

			if (tradeCase)
				game.trade();
			else
				game.keep();

			// save to history for later analysis ... 
			saveToHistory();
			if (i < PRINT_LIMIT)
				System.out.printf("%s%n", game);
			
			game.reset();

		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// takes an optional command line parameter specifying number of games
		// to play
		int games = DEFAULT_GAME_COUNT;
		if (args.length > 0) {
			games = Integer.parseInt(args[0]);
		}
		else {
			Scanner scanner = new Scanner(System.in); 
			System.out.print("How many games would you like to simulate for each keep/trade decision? ");
			games = scanner.nextInt(); 
		}

		DealOrNoDealer dealer = new DealOrNoDealer(games);
		dealer.play();

	}

}

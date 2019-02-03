/**
 * DealOrNoDealGame 
 * 
  This Class models a single Game cycle of Deal or No Deal 
 * 
 */

package edu.cuny.csi.csc330.stats.dond;


import java.util.*;

import edu.cuny.csi.csc330.lib.Randomizer;

public class DealOrNoDealGame {
	
	private int gameNo; // the Nth game being played 
	
	// These 26 values are the actual $$ denominations 
	// used in the DOND Game 
	private static final double ACTUAL_GAME_VALUES [] = {
		0.01, 1.00,	5.00, 10.00, 25.00, 50.00,  
		75.00,	100.00,	200.00,	300.00,	400.00,	500.00,
		750.00, 1000.00, 5000.00, 10000.00, 25000.00, 50000.00,
		75000.00, 100000.00, 200000.00, 300000.00, 400000.00, 500000.00,
		750000.00, 1000000.00		
	}; 
	
	// To add more drama to our simulation of this game, 
	// there's a $1,000,000 case and the rest are all $0.01 cent cases .... 
	private static final double VALUES [] = {
		0.01, 0.01,	0.01, 0.01, 0.01, 0.01,  
		0.01, 0.01,	0.01, 0.01,	0.01, 0.01,
		0.01, 0.01, 0.01, 0.01, 0.01, 0.01,
		0.01, 0.01, 0.01, 0.01, 0.01, 0.01,
		0.01, 1000000.00		
	}; 

	// The last array element contains the top $money prize 
	public static final double TOP_PRIZE = VALUES [VALUES.length -1];  // top prize 
	// default number of games played 
	public static final int DEFAULT_GAME_COUNT = 500; 
	
	private Randomizer randomizer; 
	
	// list of cases represents the set of all Game cases 
	private List<Case> cases;  
	private Case playerChoice; // selected by player (1/26) 
	private Case unopenedCase; // case that's left closed after Howie opens 24/25 remaining cases 
	
	// default constructor 
	public DealOrNoDealGame() {
		init(); 
	}
	
	// create "stuff" we need to do our job 
	private void init() {
		randomizer = new Randomizer(); 
		cases = new ArrayList<Case>(VALUES.length); 
		setup(); 
	}
	
	/**
	 * populate the set of cases with static $$values, and shuffle 
	 */
	private void setup() {
		
		int i = 1; 
		for(double v : VALUES) {
			cases.add( new Case(i++, v) );
		}
		
		Collections.shuffle(cases);
	}
	
	// simulates the action of trading = player's choice is now the single unopened case ... .
	public void trade() {
		playerChoice = unopenedCase; 
	}
	
	//  this is a logical place holder method ... it represents sticking with orig choice .... 
	public void keep() {
		// ... nothing to do right now  
	}
	
	/**
	 * reset cases, etc. so that another game can be replayed 
	 */
	public void reset() {
		setup(); 
	}


	/**
	 * simulate the task randomly selecting a Case and opening up 24 of the 25 remaining cases ... 
	 */
	public void pick(int gameNo) {
		this.gameNo = gameNo; 
		
		// player selects "pick" 
		int pick = randomizer.generateInt(1, VALUES.length); // models a player's selection 
		this.playerChoice = cases.get(pick - 1); 
		
		// spin through 26 cases opening all but the player selected Case and the $1,000,000 
		for(Case c : cases) {
			/* 
			 * Open up all cases except the one that 
			 * player picked and the Top Prize 
			 */
			if(c.getValue() != TOP_PRIZE && c != playerChoice) 
				c.setOpened(true);
			else if (c.getValue() == TOP_PRIZE ) 
				this.unopenedCase = c; 
		}
		
		// if player has top prize, keep the last case closed 
		if(playerChoice.getValue() == TOP_PRIZE) {
			Case c = cases.get(VALUES.length -1 );  // select the Last unopened Case 
			c.setOpened(false); 
			this.unopenedCase = c; 
		}
	}  


	@Override
	public String toString() {
		return "Game: " + String.format("%2d", gameNo)  +  " [Player's Choice: "  + playerChoice + ", Unopened Case: " + unopenedCase + "]";
	}

	
	// getters 
	
	public Case getPlayerChoice() {
		return playerChoice;
	}

	public Case getUnopenedCase() {
		return unopenedCase;
	}


}

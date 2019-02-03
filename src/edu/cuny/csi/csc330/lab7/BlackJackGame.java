package edu.cuny.csi.csc330.lab7; 

import java.util.Scanner;

public class BlackJackGame {

	private Deck deck;
	private Player player;
	private Dealer dealer;
	private Scanner input;
	private String winner; 
	
	// static Class constants 
	private static final int INIT_HIT_MAX = 2; 
	protected static final int MAX_SCORE = 21; 
	
	public BlackJackGame() {
		
		player = new Player();
		dealer = new Dealer(); 
		input = new Scanner(System.in);
		
		init(); // perform rest of BlackJackGame initialization - create a Deck and shuffle it! 
		
	}
	
	
	/**
	 * Create Deck instance and shuffle it 
	 */
	private void init() {
		deck = new Deck();
		deck.shuffle(); 
	}


	/**
	 * determines if the game is over ... 
	 * @return
	 */
	private boolean isOver() { 
		// if either dealer or player cards-value is < HIT_MAX (17), game is not over  
		if(player.getTotal() < Dealer.HIT_MAX || dealer.getTotal() < Dealer.HIT_MAX  )  
			return false; 
		// otherwise, over 
		return true; 
		
	}
	
	/**
	 * A method for display purposes 
	 * @return
	 */
	private String deriveWinner() {
		int pscore = player.getTotal(); 
		int dscore = dealer.getTotal(); 
		
		// rules of BlackJack 
		if(pscore > MAX_SCORE && dscore <= MAX_SCORE) 
			return "DEALER WON";
		else if(dscore > MAX_SCORE && pscore <= MAX_SCORE) 
			return "PLAYER WON";
		else if(pscore > dscore ) 
			return "PLAYER WON";
		else if(dscore > pscore ) 
			return "DEALER WON";
		
		return "NO WINNER";
	}
	
	/**
	 * A method for display purposes
	 */
	private void displayResults() { 
		winner = this.deriveWinner(); 
		System.out.printf("NUMBER OF CARDS DEALT %d\n", deck.getCardsDrawn()); 
		System.out.printf("PLAYER SCORE %d\n", player.getTotal() ); 
		System.out.printf("DEALER SCORE %d\n", dealer.getTotal() ); 
		System.out.printf("GAME OUTCOME: %s\n", winner ); 
		System.out.println(""); 
	}
	
	
	/**
	 * START PLAYING 
	 */
	public void play() {
		
		// Keep playing until user says NO 
		while(true) {
			
			/*
			 * Setup both dealer and player - now they both have an initial hand of 2 Cards  ... 
			 */
			for(int i = 0 ; i < INIT_HIT_MAX ; ++i ) {
				
				dealer.hit(deck.draw(), player); // hit the player 
				dealer.hit(deck.draw()); // hit yourself (dealer)  
				
			}
			
			//System.out.println(player.toString()); 
			//System.out.println(dealer.toString()); 
	
			// keeping hitting player & dealer until game is deemed over 
			while( isOver() == false ) {
				dealer.hit(deck, player); // hit the player 
				dealer.hit(deck); // hit yourself 
				
			}
			
			System.out.println(player.toString()); 
			System.out.println(dealer.toString()); 
			
			// display game results .... 
			displayResults(); 
			
			
			// GIVE USER OPPY TO PLAY AGAIN .... 
			System.out.print("Want to play again? (y/n): " );
			String response = this.input.next().toUpperCase();
			if(response.startsWith("Y") == false) {
				break; 
			}
			
			// prepare for a new game 
			this.init(); // NEW DECK 
			player.reset(); // EMPTY OUT HAND 
			dealer.reset(); // EMPTY OUT HAND 
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		BlackJackGame blackJack = new BlackJackGame(); 
		
		blackJack.play();
		
		System.exit(0);
		
	}
	
	

}

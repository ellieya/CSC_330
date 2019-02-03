package edu.cuny.csi.csc330.lab7; 

import java.util.*;

import edu.cuny.csi.csc330.lib.Randomizer;

public class Deck {

    private Card[] cards; // Card Deck - represented as an Array of Card Objects 
    private int cardsDrawn;  // number of Cards drawn from Deck   
    private Randomizer randomizer; 
    private int top; 
    
    // static array of 4 suits 
    private static String [] suits = {"Diamonds", "Hearts", "Clubs", "Spades"}; 
    private static int DECK_SIZE = 52;
	
    public Deck(){
    	randomizer = new Randomizer();
    
    	// call private init() method to do all the work 
    	init(); 
			
    }
    
    
    /**
     * private method called by constructor - initializes all data properties 
     */
    private void init() {
    	
    	cardsDrawn = 0; 
    	
    	cards = new Card[DECK_SIZE];  // stub out an array of 52 Card references 
    	
    	top = cards.length - 1;  
    	
    	// create 52 Card instances 
    	/*
    	 * for each value/suite create a Card instance 
    	 */
    	int i = 0;
    	for(int value = 1 ; value <= 13 ; value++ ) {
    		for(int suitIndex = 0 ; suitIndex < suits.length; suitIndex++ ) {
    			cards[i] = new Card(value, suits[suitIndex]); 
    			++i; 
        	}
    	}
    	
    }
    
	
    public Card draw(){
	    // this method deals the top card of the deck
    	
    	/**
    	 * We view the end of the array as the top of the deck, 
    	 * and increment the cardsDrawn value
    	 */
    	cardsDrawn++; 
    	
    	if(top < 0) // ensure that we still have cards in the deck
    		return null; 
    	
    	// then we decrement the top position index 
    	return cards[top--]; 
    }
    
	
    public void shuffle() {
    	
    	cardsDrawn = 0; 
    	
        // Start from the last element/card and swap one by one. 
    	// We perform this down to the 2nd two 1st - since there's nothing to swap with before the 1st Card
        for (int i = cards.length - 1; i > 0; i--)  // top to bottom of deck 
        {
            // Pick a random index from 0 to i using built-in Math Rand method and mod arithmetic 
            int randIndex = randomizer.generateInt(0, (cards.length - 1) );  
            
            // Swap cards[i] with the element at the random index
            swap(i, randIndex);
        }
    	
    }
    
    /**
     * swap cards in positions i & j 
     * @param i
     * @param j 
     */
    private void swap(int i, int j)  {
    	Card temp = new Card(cards[i].getValue(), cards[i].getSuit()); 
    	cards[i] = cards[j]; 
    	cards[j] = temp; 
    }
    
	
    public int getCardsDrawn(){

		return cardsDrawn;
    }
    
    public int getCardsRemaining(){

		return DECK_SIZE - cardsDrawn;
    }
    
    

	public String toString() {
    
    	 String  myCards = ""; 
    	 for(int i = 0 ; i < cards.length; i++ ) {
    		 myCards = myCards + cards[i].toString() + "\n"; 
     	 }
    	
    	return myCards; 
    }

    // any more methods you may need here

    public static void main(String [] args) {
    	
    	Deck deck = new Deck(); 
    	
    	System.out.println("Deck:\n" + deck);
    	
    	deck.shuffle(); 

    	System.out.println("Deck Post Shuffle:\n" + deck);
    	
    	System.out.println("Drawing Card:  " + deck.draw());
    	System.out.println("Cards Drawn:  " + deck.getCardsDrawn());
    	System.out.println("Cards Remaining: " + deck.getCardsRemaining() );
    
    }

}

package edu.cuny.csi.csc330.lab7; 

import java.util.*;

public class StackDeck {
	
	private Stack<Card> cards; 
    
    // static array of 4 suits 
    private static String [] suits = {"Diamonds", "Hearts", "Clubs", "Spades"}; 
    private static int DECK_SIZE = 52;
	
    public StackDeck(){
    	// call private init() method to do all the work 
    	init();
    }
    
    /**
     * private method called by constructor - initializes all data properties 
     */
    private void init() {

    	cards = new Stack<Card>(); 
    	
    	// create 52 Card instances 
    	/*
    	 * for each value/suite create a Card instance 
    	 */
    	int i = 0;
    	for(int value = 1 ; value <= 13 ; value++ ) {
    		for(int suitIndex = 0 ; suitIndex < suits.length; suitIndex++ ) {
    			cards.push( new Card(value, suits[suitIndex] ) ); 
    			++i; 
        	}
    	}
    }
	
    public Card draw(){
	    // this method deals the top card of the deck
    	
    	if(cards.isEmpty() ) // ensure that we still have cards in the deck
    		return null; 
    	
    	// return the top card 
    	return cards.pop();
    }
	
    public int getCardsDrawn(){
		return DECK_SIZE - cards.size();
    }
    
    public int getCardsRemaining(){
		return cards.size();
    }
    
    public void shuffle() {
    	Collections.shuffle(cards); 
    }
   

	public String toString() {
    
    	 String  myCards = ""; 
    	 for(int i = 0 ; i < cards.size() ; i++ ) {
    		 myCards = myCards + cards.get(i).toString() + "\n"; 
     	 }
    	
    	return myCards; 
    }

    // any more methods you may need here

    public static void main(String [] args) {
    	
    	StackDeck deck = new StackDeck(); 
    	
    	System.out.println("Deck:\n" + deck);
    	
    	deck.shuffle(); 

    	System.out.println("Deck Post Shuffle:\n" + deck);
    	
    	System.out.println("Drawing Card:  " + deck.draw());
    	System.out.println("Cards Drawn:  " + deck.getCardsDrawn());
    	System.out.println("Cards Remaining: " + deck.getCardsRemaining() );
    
    }

}

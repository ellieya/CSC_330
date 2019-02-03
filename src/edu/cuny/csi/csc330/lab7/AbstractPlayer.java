package edu.cuny.csi.csc330.lab7;

import java.util.ArrayList;

public abstract class AbstractPlayer {
	
    protected ArrayList<Card> hand; // the player's cards
    protected int handTotal; // The total value of the hand
    
    public AbstractPlayer()  {
    	hand = new ArrayList<Card>();
    }


    public int getTotal() {
        return handTotal;
    }
    
    /**
     * needs to be invoked before starting new game 
     */
    public void reset() {
    	hand.clear(); 
    	handTotal = 0; 
    }

    
    /**
     * Add card to hand 
     * @param card
     */
    protected void add(Card card) {
    	
    	this.hand.add(card); 
    	// determine how to use an Ace - 1 or 11 
    	int value = card.getValue(); 
    	if(value == 1 ) {
    		if(this.handTotal + 11 <= BlackJackGame.MAX_SCORE) 
    			value = 11;
    	}
    	
    	this.handTotal += value; 
    	
    }
    

}

package edu.cuny.csi.csc330.lab7; 

import java.util.*;

public class Dealer extends AbstractPlayer {

	protected static int HIT_MAX = 16;

    public Dealer() {
    	super();
    	reset(); 
    }

    
    /** unconditional self-hit
     * @param card
     */
    public void hit(Card card) {
    		add(card);
    }
    
    /**
     * unconditional player-hit
     * @param card
     * @param player
     */
    public void hit(Card card, Player player) {
    		player.add(card);
    }

    
    /**
     * HIT SELF (THE DEALER) 
     * @param deck
     */
    public void hit(Deck deck) {
    	if(getTotal() <= HIT_MAX)
    		add(deck.draw()); // HIT 
    	
    	// OTHERWISE, STAND 
    	
    }
    
    /**
     * HIT THE PLAYER 
     * @param deck
     * @param player
     */
    public void hit(Deck deck, Player player) {
    	if(player.getTotal() <= HIT_MAX)
    		player.add(deck.draw());  // HIT 
    	
    	// OTHERWISE, STAND 
    	
    }
   


	@Override
	public String toString() {
		return "Dealer [hand=" + hand + ", handTotal=" + handTotal + "]";
	}
    
	public static void main(String[] args){
	        Dealer dealer = new Dealer();	        
	        
			System.out.println(dealer);
			
	 }
    

}

package edu.cuny.csi.csc330.lab7; 

import java.util.*;

public class Player extends AbstractPlayer {


    public Player(){
    	super();
	    // player constructor
    	reset();
    
    }
    
    
	public static void main(String[] args){
        Player player = new Player();	        
        
		System.out.println(player);
		
	}

	@Override
	public String toString() {
		return "Player [hand=" + hand + ", handTotal=" + handTotal + "]";
	}

}
	

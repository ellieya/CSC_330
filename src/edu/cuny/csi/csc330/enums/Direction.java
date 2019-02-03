package edu.cuny.csi.csc330.enums;

import edu.cuny.csi.csc330.lib.Randomizer;


public enum Direction {
	 NONE, NORTH, EAST, SOUTH, WEST  ;
	 
	 // methods 
	 public Direction getFavorite() {
		 return SOUTH;  // It's getting cold! ... 
	 }
	 
	 public Direction getNextRandom() {
		 	Randomizer randomizer = new Randomizer();
			int direction = randomizer.generateInt(1, 4); 
		
			// 1 = south,  2 = west, 3 = north, 4 = east 
			if(direction == 1) { // south 
				 return SOUTH;
			}
			else if(direction == 2) {   // west 
				 return WEST; 
			}
			else if(direction == 3) {   // north 
				 return NORTH; 
			}
			else {    // east 
				return EAST; 
			}
	 }
	 
}

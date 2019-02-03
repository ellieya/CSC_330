/**
 * Direction ENUM 
 */

package edu.cuny.csi.csc330.scratch;

import edu.cuny.csi.csc330.lib.Randomizer;


public enum Direction {
	 NONE, NORTH, EAST, SOUTH, WEST, NORTHEAST, NORTHWEST, SOUTHWEST, SOUTHEAST; 
	 
	 // methods 
	 public Direction getFavorite() {
		 return SOUTH;  // It's getting cold! ... 
	 }
	 
	 public Direction getNextRandom() {
		 	Randomizer randomizer = new Randomizer();

			int direction = randomizer.generateInt(1, 8); 
		
			// 1 = south,  2 = west, 3 = north, 4 = east, 5, 6, 7, 8 
			if(direction == 1) { // south 
				 return SOUTH;
			}
			else if(direction == 2) {   // west 
				 return WEST; 
			}
			else if(direction == 3) {   // north 
				 return NORTH; 
			}
			else if(direction == 4) {   // EAST  
				 return EAST; 
			}
			else if(direction == 5) {   // northeast 
				 return NORTHEAST; 
			}
			else if(direction == 6) {   // southwest   
				 return SOUTHEAST; 
			}
			else if(direction == 7) {   // northwest   
				 return NORTHWEST; 
			}
			else {    // southwest 
				return SOUTHWEST; 
			}
	 }
	 
}

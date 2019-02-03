package edu.cuny.csi.csc330.enums;

public class DirectionClient {
	
		private Direction direction; 
		

		public DirectionClient(Direction direction) {
			this.direction = direction; 
		} 
		

	    public void explain() {
	    	
	    	String directionPhrase = ""; 
	    	
	        switch (direction) {
	            case NORTH:
	                directionPhrase = "Going North!";
	                break;
	                    
	            case SOUTH:
	            	directionPhrase = "Going South!";
	                break;
	                   
	            case EAST: 
	            	directionPhrase = "Going East!";
	                break;
                    
			    case WEST:
			    	   directionPhrase = "Going West!";
			           break;
	                        
	            default:
	                System.err.printf("Going in Some unknown direction (%s)\n", direction );
	                break;
	         }
	        
	         System.out.printf("%s\n\n", directionPhrase);  
	         
	     }
	   
	   
		public Direction getDirection() {
			return direction;
		}
		
	    public static void main(String[] args) {
	    	DirectionClient direction = new DirectionClient(Direction.NORTH);
	    	direction.explain();
	    
	    	for(int i = 0 ; i < 10 ; ++i) 
	    		System.out.printf("%s \n", Direction.NONE.getNextRandom());
	    	
	    	
	    }
}


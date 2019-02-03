package edu.cuny.csi.csc330.examples2;

public class DRYDog {

    private int barkCount;
    
    public DRYDog() {
    	barkCount = 0; 
    }

    public void bark(){
        System.out.println("bark");
        System.out.flush(); 
        barkCount++;
    }

    public void defendHouse(){
    	bark(); 
        System.out.println("run in circles");
    }
    
    public static void main(String[] args) {
    	boolean heardSomething  =  args.length == 0 ? false : true;
    	
		DRYDog dog = new DRYDog();
		
		if(heardSomething) {
			dog.bark(); 
			dog.defendHouse(); 
			dog.bark();
		}

	}

}

package edu.cuny.csi.csc330.examples2;

public class WETDog {

    private int barkCount;
    
    public WETDog() {
    	barkCount = 0; 
    }

    public void bark(){
        System.out.println("bark");
        System.out.flush(); 
        barkCount++;
    }

    public void defendHouse(){
    	System.out.println("bark");
    	System.out.flush(); 
        barkCount++;
        System.out.println("run in circles");
    }
    
    public static void main(String[] args) {
    	boolean heardSomething  =  args.length == 0 ? false : true;
    	
		WETDog dog = new WETDog();
		
		if(heardSomething) {
			dog.bark(); 
			dog.defendHouse(); 
			dog.bark();
		}

	}

}

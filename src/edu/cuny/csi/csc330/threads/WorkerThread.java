package edu.cuny.csi.csc330.threads;


class WorkerThread implements Runnable {
    private String message;
    private double sleepTime;
    
    public WorkerThread(String message){
        this.message=message;
        sleepTime = 2; 
    }
    
 
    public double getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(double sleepTime) {
		this.sleepTime = sleepTime;
	}

	public String getMessage() {
		return message;
	}


	/**
     * Do something simulated work 
     */
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);
        processmessage();
        System.out.println(Thread.currentThread().getName()+" (End)");
    }
 
    /**
     * Sleep a fixed 2 seconds ... 
     */
    private void processmessage() {
        try {  
        	Thread.sleep((int) (1000 * sleepTime));  
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
   
}

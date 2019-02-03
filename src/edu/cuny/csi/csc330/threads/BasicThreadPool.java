package edu.cuny.csi.csc330.threads;

import java.util.Date;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class BasicThreadPool {
	
	static final int POOL_SIZE = 10; 
	static final int THREAD_LIMIT = 22; 
	 
    public static void main(String[] args) throws Exception  {
    	
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);  // try with multiple pools
        
        Runnable worker = null; 
        
        System.out.println("Started Managed Thraed: " + new Date() );
        worker = new WorkerThread("managed job 1");
        ((WorkerThread)worker).setSleepTime(2); 
        Future future = executor.submit(worker);  // synchronously launch a worker thread 
        future.get(); // Blocks 
        System.out.println("Ended Managed Thread: " +  new Date() );
        
        for (int i = 0; i < THREAD_LIMIT ; i++) {
            worker = new WorkerThread("" + i);
            executor.execute(worker);  // asynchronously launch a worker thread 
        }
        
        
        executor.shutdown(); // clean up - graceful shutdown 
        
        while (!executor.isTerminated()) { // wait until there's no more active worker threads ... 
        	; 
        }
        
        System.out.println("All Worker Threads Completed");
    }
 
}
package edu.cuny.csi.csc330.examples2;

import java.util.concurrent.*;

public class ThreadedLambda {
	
	public static void main(String[] args) {
		 
		// Lambda - an anonymous implementation of a 
		//  single-method Interface ... closest Java thing to using Java functions as an Object
		Runnable runnable = () -> {
		    try {
		        String name = Thread.currentThread().getName();
		        TimeUnit.SECONDS.sleep(1);
		        System.out.println( name);
		    }
		    catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		Thread thread3 = new Thread(runnable);

		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}

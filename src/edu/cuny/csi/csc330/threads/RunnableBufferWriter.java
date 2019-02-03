package edu.cuny.csi.csc330.threads;

import edu.cuny.csi.csc330.lib.Randomizer;

import java.util.Date;

public class RunnableBufferWriter implements Runnable {
	
	private static int [][] buffer; 
	private static final int BUFFER_DIM = 7500; 
	
	private int assignedSection;
	private int start;
	private int end;
	
	static {
		buffer = new int[BUFFER_DIM][BUFFER_DIM];
	}

	
	public RunnableBufferWriter( ) {
		
	}
		 

	public RunnableBufferWriter(int assignedSection) {
		this.assignedSection = assignedSection;
	}
	
	@Override
	public void run() {
		
		switch(assignedSection) {
		case 2:
			start = BUFFER_DIM/4;
			break;
		case 3:
			start = BUFFER_DIM/2;
			break;
		case 4:
			start = (int) ((double)BUFFER_DIM * .75);
			break;
		case 1:
		default:
			start = 0;
			break;
		}
		
		end = start + (BUFFER_DIM/4); 
		
		System.out.printf("Started Section=%d  Start=%d End=%d\n", assignedSection, start, end);
		
		int i, j;
		i = j = 0;
		for( i = start ; i < end ; ++i)  {
			for( j = start ; j < BUFFER_DIM ; ++j)  {
				// buffer[i][j] = i * j; 
				buffer[i][j] = Randomizer.generateInt(); 
			}
		}
		
		System.out.printf("Finished Section=%d  Row Limit=%d  Column Limit=%d\n", assignedSection, i, j);
		
	}

	public static void main(String[] args) throws Exception {
		
		 /////////////////////////////////////////////////////////////
		 // threaded 
		 RunnableBufferWriter buffer1 = new RunnableBufferWriter(1); 
		 RunnableBufferWriter buffer2 = new RunnableBufferWriter(2); 
		 RunnableBufferWriter buffer3 = new RunnableBufferWriter(3); 
		 RunnableBufferWriter buffer4 = new RunnableBufferWriter(4); 
		 
		 System.out.println("Before Creating Threads: " + new Date() );
		 
		 Thread t1 = new Thread(buffer1); 
		 Thread t2 = new Thread(buffer2);
		 Thread t3 = new Thread(buffer3); 
		 Thread t4 = new Thread(buffer4); 
		 
		 t1.start();
		 t2.start();
		 t3.start();
		 t4.start();
		 
		 t1.join();
		 t2.join();
		 t3.join();
		 t4.join();
		 
		 System.out.println("After join()s: " + new Date() );
		 
		 /////////////////////////////////////////////////////////////
		 // un-threaded 
		 System.out.println("\nBefore all sequencial run()s " + new Date() );
		 buffer1.run();  
		 buffer2.run(); 
		 buffer3.run(); 
		 buffer4.run(); 
		 System.out.println("After all sequencial run()s " + new Date() );
		
	}



}

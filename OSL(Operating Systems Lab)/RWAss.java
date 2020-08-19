
/*
 * SHREYA CHETAN PAWASKAR
 * ROLL NO-2939
 * BATCH -C3
 * SY COMP DIVISION C
 * Assignment- readers writers algorithm
 */

import java.util.concurrent.Semaphore;

class RWAss 
{
	// mutex = 1
	static Semaphore mutex = new Semaphore(1); 
	
	// wrt = 1
	static Semaphore wrt = new Semaphore(1); 
	
	//(initial value = 0)
	static int readCount = 0;

	static class Reader implements Runnable 
	{ // Reader Thread
		
		public void run() 
		{
			try 
			{
				// Acquire Section
				mutex.acquire();//Ensure that no other reader can execute the <Entry> section while you are in it
				//Writing Section
				
				//reader added
				readCount++;  
				
				//if its the first reader we have to check if writer is writing
				if (readCount == 1)  
				{
					//If you are the first reader, lock the resource from writers. 
					//Resource stays reserved for subsequent readers
					wrt.acquire();
					
				}
				mutex.release();

				// Reading section
				System.out.println("Thread " + Thread.currentThread().getName() + " is READING");
				Thread.sleep(1500); 
				//sleep method is used to pause a thread for few milliseconds
				System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED READING");

				// Releasing section
				mutex.acquire();
				
				//Indicate that you are no longer needing the shared resource. One fewer reader
				readCount--;
				
				//Checks if you are the last (only) reader who is reading the shared file
				if (readCount == 0)
				{
					wrt.release();
				}
				mutex.release(); //Release

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	static class Writer implements Runnable { // Writer Thread
		public void run() {
			try {
				wrt.acquire();
				System.out.println("Thread " + Thread.currentThread().getName() + " is WRITING");
				Thread.sleep(2500);
				System.out.println("Thread " + Thread.currentThread().getName() + " has finished WRITING");
				wrt.release();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		//new object of reader
		Reader read = new Reader();
		
		//new object of writer
		Writer write = new Writer();
		
		Thread r1 = new Thread(read);
		r1.setName("Reader1");
		Thread r2 = new Thread(read);
		r2.setName("Reader2");
		Thread r3 = new Thread(read);
		r3.setName("Reader3"); //start method causes thread to begin execution the JVM calls runs method of this thread

		Thread w1 = new Thread(write);
		w1.setName("Writer1");
		Thread w2 = new Thread(write);
		w2.setName("Writer2");
		Thread w3 = new Thread(write);
		w3.setName("Writer3");
		w1.start();
		r1.start();
		w2.start();
		r2.start();
		r3.start();
		w3.start();

	}
}

/*Output
 * 
Thread Writer1 is WRITING
Thread Writer1 has finished WRITING
Thread Writer3 is WRITING
Thread Writer3 has finished WRITING
Thread Writer2 is WRITING
Thread Writer2 has finished WRITING
Thread Reader3 is READING
Thread Reader1 is READING
Thread Reader2 is READING
Thread Reader3 has FINISHED READING
Thread Reader1 has FINISHED READING
Thread Reader2 has FINISHED READING


*/

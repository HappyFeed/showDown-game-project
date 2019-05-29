package threads;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;

public class RefreshThread extends Thread {
	
	CountDownLatch time;
	IntroThread td;

	/*This is a constructor method of RefreshThread
	 * 
	 */
	public RefreshThread() {
		td= new IntroThread();
		time=new CountDownLatch(1);
		
		
	}
	
	/*This method allow to run the Thread
	 * @pre: empty
	 * @param: empty
	 * @return: This method return void
	 * @post: run the Thread
	 */
	
	@Override
	public void run() {
		
		try {
			time.await(20000,TimeUnit.MILLISECONDS);
			time.countDown();
			Platform.runLater(td);
			td.start();
		} catch (InterruptedException | IllegalStateException e) {
			
		}
    	
		
        
	}
	
	
	

}

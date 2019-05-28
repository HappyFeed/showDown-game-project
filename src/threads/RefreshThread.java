package threads;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;

public class RefreshThread extends Thread {
	
	CountDownLatch time;
	IntroThread td;

	public RefreshThread() {
		td= new IntroThread();
		time=new CountDownLatch(1);
		
		
	}
	
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

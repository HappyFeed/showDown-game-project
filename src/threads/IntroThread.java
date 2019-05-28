package threads;



import java.io.IOException;


import ui.MenuController;

public class IntroThread extends Thread {
	
	
	MenuController mc;
	public IntroThread() {
		
	        	mc=new MenuController();
	        	
	        	
	    		      
       
	}
	
	@Override
	public void run() {
		
		try {
        	
			mc.changeScene();
		} catch (IOException | IllegalStateException e) {
			
		}
		
        
	}

}

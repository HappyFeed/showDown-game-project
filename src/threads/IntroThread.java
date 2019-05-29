package threads;



import java.io.IOException;


import ui.MenuController;

public class IntroThread extends Thread {
	
	
	MenuController mc;
	
	/*This is constructor method of IntroThread
	 * 
	 */
	public IntroThread() {
		
	        	mc=new MenuController();
	        	
	        	
	    		      
       
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
        	
			mc.changeScene();
		} catch (IOException | IllegalStateException e) {
			
		}
		
        
	}

}

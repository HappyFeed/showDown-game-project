package threads;

import model.Game;
import ui.MatchController;

public class RefreshMatchThread extends Thread {
	
	MatchController mc;
	Game g;
	/*This is a constructor method os RefreshMatchThread
	 * 
	 */
	public RefreshMatchThread(MatchController mc,Game g) {
		
		this.mc=mc;
		this.g=g;
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
			g.switchPlayer();
			mc.setGame(g);
		}catch(IllegalStateException ise) {
			System.err.println("It is over");
		}

		
	}

}

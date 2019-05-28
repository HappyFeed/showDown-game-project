package threads;

import model.Game;
import ui.MatchController;

public class RefreshMatchThread extends Thread {
	
	MatchController mc;
	Game g;
	
	public RefreshMatchThread(MatchController mc,Game g) {
		
		this.mc=mc;
		this.g=g;
	}
	
	@Override
	public void run() {
		
		g.switchPlayer();
		mc.setGame(g);
		
	}

}

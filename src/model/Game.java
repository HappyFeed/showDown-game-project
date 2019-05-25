package model;


import java.io.Serializable;

@SuppressWarnings("serial")
public class Game implements Serializable{

	
	//Relations
	    private Player firstPlayer;
	

	    //Methods
		public Game() {
			
		}
		
		public Player getFirstPlayer() {
			return firstPlayer;
		}
		
        
		public boolean addPlayer(String name, String profilePicture) {
	            boolean playerAdd=true;
	    		Player fl = new Player(name,profilePicture);
	    		if(firstPlayer == null) {
	    			firstPlayer = fl;
	    			System.out.println(fl.getName()+"Root");
	    		}else {
	    			Player current = firstPlayer;
	    			if(current.getNextPlayer()==null) {
		    			current.setNextPlayer(fl);
		    			fl.setPrevPlayer(current);
		    			System.out.println(fl.getName()+"NEXT");
	    			}else {
	    				playerAdd=false;
	    			}
	    		}
	    		return playerAdd;
		}
		
		public Player searchOficialParticipant(String n) {
			Player current = firstPlayer;
			Player returned = null;
			boolean stop = false;
			while(current != null && !stop) {
				if(current.getName().equals(n)) {
					stop = true;
					returned = current;
				}else {
						current = current.getNextPlayer();
				}
			}
			
			return returned;
		}
}

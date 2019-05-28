package model;


import java.io.Serializable;

import customeExceptions.BigNameException;
import customeExceptions.NoDataException;
import javafx.scene.image.Image;

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
		
        
		public boolean addPlayer(String name, Image profilePicture)throws BigNameException,NoDataException {
	            boolean playerAdd=true;
	            if(name=="" ||profilePicture==null) {
	            	throw new NoDataException(name,profilePicture);
	            }else if(name.length()>10) {
	            	throw new BigNameException(name.length());
	            }else {
	            	Player fl = new Player(name,profilePicture);
		    		if(firstPlayer == null) {
		    			firstPlayer = fl;
		    		}else {
		    			Player current = firstPlayer;
		    			if(current.getNextPlayer()==null) {
			    			current.setNextPlayer(fl);
			    			fl.setPrevPlayer(current);
		    			}else {
		    				playerAdd=false;
		    			}
		    		}
	            }	    		
	    		return playerAdd;
		}
		
		public Player searchPlayer(String n) {
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
		
		public void switchPlayer() {
			
		Player aux= firstPlayer;
		firstPlayer=firstPlayer.getNextPlayer();
		firstPlayer.setNextPlayer(aux);
		firstPlayer.getNextPlayer().setNextPlayer(null);
		}
}

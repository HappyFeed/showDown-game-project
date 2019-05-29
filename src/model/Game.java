package model;


import java.io.Serializable;

import customeExceptions.BigNameException;
import customeExceptions.NoDataException;
import javafx.scene.image.Image;

/* This class is corresponding to generate the Game
 * @Author: Alejandro Martinez
 * @Author1: Jose Jimenez 
 * @Author2: Juan Hernández 
  	@Version: 1.0
 */

@SuppressWarnings("serial")
public class Game implements Serializable{

	
	//Relations
	    private Player firstPlayer;
	

	    /*This method is a constructor method of Game
	     * 
	     */
		public Game() {
			
		}
		/*This method is to get a firstPlayer
		 * @pre: firstPlayer == null || firstPlayer != null
		 * @param: empty
		 * @return: firstPlayer of type Player
		 * @post: got firstPlayer
		 */
		public Player getFirstPlayer() {
			return firstPlayer;
		}
		
		/*This method allow to add Player in a linked list
		 * @pre: firstPlayer == null || firstPlayer != null
		 * @param: String name, Image profilePicture
		 * @return: This method return a boolean to know that the player that like add was added
		 * @post: Player added
		 */
		
        
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
		/*This method allow search a Player in the linkedlist 
		 * @pre: firstPlayer =! null
		 * @param: String n
		 * @return: This method return a player
		 * @post: Player founded
		 */
		
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
		
		/*This method allow switch players when one of that do a movement
		 * @pre: firstPlayer != null && firstPlayer.getNext() != null
		 * @param: empty
		 * @return: This method dont return nothing
		 * @post: Players switched
		 */
		
		public void switchPlayer() {
			
		Player aux= firstPlayer;
		firstPlayer=firstPlayer.getNextPlayer();
		firstPlayer.setNextPlayer(aux);
		firstPlayer.getNextPlayer().setNextPlayer(null);
		}
}

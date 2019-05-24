package model;


import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable{

	
	//Relations
	    private Player[] players;
	

	    //Methods
		public Game() {
			players= new Player[2];
		}
		
		public Player[] getPlayers() {
			return players;
		}
		
        
		public void addPlayer(String name, String profilePicture)
		{
			Player p1= new Player(name,profilePicture);
			for(int i=0;i<players.length;i++) {
				if(players[i]==null) {
					players[i]=p1;
				}
			}
		}

}

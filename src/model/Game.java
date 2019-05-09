package model;

public class Game {
 
		//Relations
	    private Player[] players;
		
	    //Methods
		public Game() {
          
			players= new Player[2];

		}
		
		public Player[] getPlayers() {
			return players;
		}
 
}

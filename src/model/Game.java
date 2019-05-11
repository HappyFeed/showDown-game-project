package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {
 
		//Relations
	    private ArrayList<Player> players;
		
	    //Constants
	    private static final String SAVE_PLAYERS="playerSave/playersSave.ps";
	    
	    //Methods
		public Game() throws ClassNotFoundException, IOException {
            load();
		}
		
		public ArrayList<Player> getPlayers() {
			return players;
		}
		
		@SuppressWarnings("unchecked")
		private void load() throws IOException, ClassNotFoundException {
			  File archivo= new File(SAVE_PLAYERS);
			  if(archivo.exists()) {
				  ObjectInputStream ois= new ObjectInputStream(new FileInputStream(archivo));
				  players=(ArrayList<Player>) ois.readObject();
				  ois.close();
			  }else {
				  players= new ArrayList<Player>();
			  }
		}
		
		public void save() throws IOException {
			  ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(SAVE_PLAYERS));
			  oos.writeObject(players);
			  oos.close();
		}
}

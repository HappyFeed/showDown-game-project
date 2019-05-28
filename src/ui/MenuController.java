package ui;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import model.Game;


public class MenuController {
	
	private static final String SAVE_PLAYERS="playerSave/playersSave.ps";
	private Game gm;

	@FXML
	private Pane pane;
	
    @FXML
    void start(ActionEvent event) throws Exception { 
    	gm= new Game();
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("SelectCharacter.fxml"));
    	Parent root = loader.load();
    	SelectCharacterController scc= (SelectCharacterController) loader.getController();
    	scc.recibirGame(gm);
    	Scene scene = new Scene(root);
		Main.stage.setScene(scene);
    }
    
    public Game getGame() {
		return gm;
	}

	@FXML
    void loadGame(ActionEvent event){
		ArrayList<Game> s= load();
		s.size();
		for(int i=0;i<s.size();i++) {
			Button n= new Button();
			n.setText(s.get(i).getFirstPlayer().getName()+"\n"+s.get(i).getFirstPlayer().getNextPlayer().getName());
		    pane.getChildren().add(n);
		}
    }
	
    @SuppressWarnings("unchecked")
	public ArrayList<Game> load(){
    	ArrayList<Game> savedGames= new ArrayList<Game>();
    	try {    		
    		File archivo= new File(SAVE_PLAYERS);
    		if(archivo.exists()) {
			  ObjectInputStream ois= new ObjectInputStream(new FileInputStream(archivo));
			  savedGames=(ArrayList<Game>) ois.readObject();
			  ois.close();
    		}else {
    			savedGames= new ArrayList<Game>();
    		}        		         	
		} catch (IOException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
    	return savedGames;
    }

}

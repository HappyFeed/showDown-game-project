package ui;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;
import model.Game;


public class MenuController {
	
	private static final String SAVE_PLAYERS="playerSave/playersSave.ps";
	private ArrayList<Game> gm;

    @FXML
    void start(ActionEvent event) throws Exception { 	
    	Game g= new Game();
    	gm.add(g);
    	Parent root = FXMLLoader.load(getClass().getResource("SelectCharacter.fxml"));
    	Scene scene = new Scene(root);
		Main.stage.setScene(scene);

    }
    
    public ArrayList<Game> getGame() {
		return gm;
	}

	@SuppressWarnings("unchecked")
	@FXML
    void loadGame(ActionEvent event){
    	try { 
    		File archivo= new File(SAVE_PLAYERS);
    		if(archivo.exists()) {
			  ObjectInputStream ois= new ObjectInputStream(new FileInputStream(archivo));
			  gm=(ArrayList<Game>) ois.readObject();
			  ois.close();
    		}else {
			  gm= new ArrayList<Game>();
    		}  	
		} catch (IOException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	showInformation(gm);
		 

    }
    
    @FXML
    void initialize() throws IOException {
    	gm= new ArrayList<Game>();
    	Game g=new Game();
    	g.addPlayer("pepe", "");
    	g.addPlayer("micahel", "");	
    	gm.add(g);
    	save();
    }
	public void save() throws IOException 
	{
		  ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(SAVE_PLAYERS));
		  oos.writeObject(gm);
		  oos.close();
	}
    
	public void showInformation(ArrayList<Game> a) {
		for(int i=0;i<a.size();i++) {

		}
	}

}

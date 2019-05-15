package ui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuController {
	
	

    @FXML
    void start(ActionEvent event) throws Exception {
    	
    	
    	Parent root = FXMLLoader.load(getClass().getResource("SelectCharacter.fxml"));
    	Scene scene = new Scene(root);
		Main.stage.setScene(scene);
		

    }
    
    @FXML
    void loadGame(ActionEvent event){
    	
    	
    }

}

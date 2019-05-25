package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;
import model.Game;

public class SelectCharacterController {

    @FXML
    private Button character1;

    @FXML
    private Button character2;

    @FXML
    private Button character3;

    @FXML
    private Button character10;

    @FXML
    private Button character9;

    @FXML
    private Button character4;

    @FXML
    private Button character5;

    @FXML
    private Button character6;

    @FXML
    private Button character7;

    @FXML
    private Button character8;

    @FXML
    private Button character11;

    @FXML
    private Button character12;

    @FXML
    private Button character13;

    @FXML
    private Button character14;

    @FXML
    private Button character15;

    @FXML
    private Button character16;

    @FXML
    private Button next;

    @FXML
    private Button back;

    @FXML
    private Button nextPage;

    @FXML
    private Button backPage;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private TextField namePlayers;
    
    @FXML
    private Label selectPlayer;

    private Game g;

    public void recibirGame(Game newGame) {
    	g= newGame;
    }
    
    @FXML
    void initialize() {
    	selectPlayer.setText("1");
    	next.setVisible(false);
    }
    
    @FXML
    void savePlayers(ActionEvent event) {   	
    	if(g.addPlayer(namePlayers.getText(), "")==true) {
        	Alert score = new Alert(AlertType.INFORMATION);
            score.setTitle("FinalFinal5EnElProyecto-Game");
            score.initStyle(StageStyle.DECORATED);
            score.setContentText("Saved");
            score.show();
            namePlayers.setText("");
            selectPlayer.setText("2");
            if(g.getFirstPlayer().getNextPlayer()!=null) {
                saveButton.setVisible(false);
            	next.setVisible(true);
            	namePlayers.setVisible(false);	
            	selectPlayer.setText("Not more");
            }
    	}        
    }
    
    @FXML
    void backPage(ActionEvent event) {

    }

    @FXML
    void nextPage(ActionEvent event) {

    }
    
    @FXML
    void backToStage(ActionEvent event) {
    	
    
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	


    }



    @FXML
    void nextToStage(ActionEvent event) {
		try {
			FXMLLoader loader= new FXMLLoader(getClass().getResource("SelectCharacter.fxml"));
			Parent root=loader.load();
			SelectTeamController stc= (SelectTeamController) loader.getController();
	    	stc.setPlayers(g.getFirstPlayer());
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void selectThisCharacter1(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter10(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter11(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter12(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter13(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter14(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter15(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter16(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter2(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter3(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter4(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter5(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter6(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter7(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter8(ActionEvent event) {

    }

    @FXML
    void selectThisCharacter9(ActionEvent event) {

    }

}


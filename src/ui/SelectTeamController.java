package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.Game;
import model.Player;


public class SelectTeamController {

    @FXML
    private Button pokemon1;

    @FXML
    private Button pokemon2;

    @FXML
    private Button pokemon3;

    @FXML
    private Button pokemon10;

    @FXML
    private Button pokemon9;

    @FXML
    private Button pokemon4;

    @FXML
    private Button pokemon5;

    @FXML
    private Button pokemon6;

    @FXML
    private Button pokemon7;

    @FXML
    private Button pokemon8;

    @FXML
    private Button pokemon11;

    @FXML
    private Button pokemon12;

    @FXML
    private Button pokemon13;

    @FXML
    private Button pokemon14;

    @FXML
    private Button pokemon15;

    @FXML
    private Button pokemon16;

    @FXML
    private Button next;

    @FXML
    private Button back;

    @FXML
    private ComboBox<String> selectPlayer;

    private Player players;
    
    public void setPlayers(Player p) {
    	players=p;
    	try {
			players.loadPokemons();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void backPage(ActionEvent event) {

    }

    @FXML
    void backToStage(ActionEvent event) {
    	
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("SelectCharacter.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			

		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void nextPage(ActionEvent event) {

    }

    @FXML
    void nextToStage(ActionEvent event) {
    	
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Match.fxml"));
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		

		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void selectThisPokemon1(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon10(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon11(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon12(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon13(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon14(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon15(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon16(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon2(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon3(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon4(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon5(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon6(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon7(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon8(ActionEvent event) {

    }

    @FXML
    void selectThisPokemon9(ActionEvent event) {

    }
    
}

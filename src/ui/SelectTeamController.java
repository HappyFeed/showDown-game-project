package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Player;
import model.Pokemon;


public class SelectTeamController {

	@FXML
	private Label pages;
	
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
    
    public List<Button> addButtons() {
    	List<Button> l= new ArrayList<Button>();
    	l.add(pokemon1);
    	l.add(pokemon2);
    	l.add(pokemon3);
    	l.add(pokemon4);
    	l.add(pokemon5);
    	l.add(pokemon6);
    	l.add(pokemon7);
    	l.add(pokemon8);
    	l.add(pokemon9);
    	l.add(pokemon10);
    	l.add(pokemon11);
    	l.add(pokemon12);
    	l.add(pokemon13);
    	l.add(pokemon14);
    	l.add(pokemon15);
    	l.add(pokemon16);
    	return l;
    }
    
    public void setPlayers(Player p) {
    	players=p;
    }
    
    public void showInformation(List<Pokemon> pokemons) {
    	System.out.println(pokemons.size());
    	int pagesN=(pokemons.size()/16);
    	List<Button>b=addButtons();
    	if(pokemons.size()%16>0) {
    		pagesN+=1;
    	}
    	System.out.println(pagesN);
    	for(int j=0;j<pagesN;j++){
    		if(j+1==Integer.parseInt(pages.getText())){
    			System.out.println("Entro");
    	    	for (int i = (16*j); i <16+(16*j) && i<pokemons.size(); i++) {
    	    		b.get(i).setText(pokemons.get(i).getName());
    		    }
    	    }
		}
    }
    
    @FXML
    void backPage(ActionEvent event) {
        int newPage= Integer.parseInt(pages.getText())-1;
        if(newPage>0) {
        	pages.setText(newPage+"");
        	clearData();
        	showInformation(players.inOrder());
        }
    }

    @FXML
    void nextPage(ActionEvent event) {
    	List<Pokemon> l=players.inOrder();
    	int newPage= Integer.parseInt(pages.getText())+1;
        if(newPage<(l.size()/16)+2) {
        	pages.setText(newPage+"");
        	clearData();
        	showInformation(players.inOrder());
        }
    }
    
    public void clearData() {
    	List<Button>b=addButtons();
    	for(int i=0;i<b.size();i++) {
    		b.get(i).setText("");
    	}
    }
    @FXML
    void backToStage(ActionEvent event) {
       	try {
    			players.loadPokemons();
    			List<Pokemon> l=players.inOrder();
    			showInformation(l);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
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

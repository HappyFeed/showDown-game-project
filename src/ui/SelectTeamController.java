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
		try {
	    	players=p;
			players.loadPokemons();
	    	showInformation();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    

    public void showInformation(List<Pokemon> pokemons) {
    	int pagesN=(pokemons.size()/16);
    	List<Button> buttons = addButtons();
    	if(pokemons.size()%16>0) {
    		pagesN+=1;
    	}
    	for(int j=0;j<pagesN;j++){
    		if(j+1==Integer.parseInt(pages.getText())){
    	    	for (int i = (16*j); i <16+(16*j) && i<pokemons.size(); i++) {
    	    		
    	    		
    	    		//Image img = pokemons.get(i).getImg();
    	    	/*	Image img=new Image(getClass().getResource("ui/icono.png").toString());
    	    		if(img!=null) {
                    buttons.get(j).setGraphic(new ImageView(img));
                    System.out.println("izi");*/
    	    		}}}}

    public void showInformation() throws IOException {
	   	ArrayList<Pokemon> rootPokemon= players.inOrder();
    	int pagesN=(rootPokemon.size()/16);
    	List<Button>b=addButtons();
    	if(rootPokemon.size()%16>0) {
    		pagesN+=1;
    	}
    	Boolean flag=true;
    	for(int j=0;j<pagesN&&flag;j++){    	
    		if(j+1==Integer.parseInt(pages.getText())){    
    	    	int bottonN=0;
    			for (int i = (16*j); i <16+(16*j) && i<rootPokemon.size(); i++) {
    	    			if(i>=b.size()) {
    	    				b.get(bottonN).setText(rootPokemon.get(i).getName());  
    	    				System.out.println(rootPokemon.get(i).getName()+i);
    	    				bottonN++;
    	    				if(bottonN>=b.size()) {
    	    					bottonN=0;
    	    				}
    	    			}else {
    	    				b.get(i).setText(rootPokemon.get(i).getName());
    	    				System.out.println(rootPokemon.get(i).getName()+i);
    	    			}
    	    			
    	    			

    		    }
    	    	flag=false;
    	    }
		}
    }
    
    @FXML
    void backPage(ActionEvent event) throws IOException {
        int newPage= Integer.parseInt(pages.getText())-1;
        if(newPage>0) {
        	pages.setText(newPage+"");
        	clearData();
        	showInformation();
        }
    }

    @FXML
    void nextPage(ActionEvent event) throws IOException {
    	int newPage= Integer.parseInt(pages.getText())+1;
        if(newPage<(149/16)+2) {
        	pages.setText(newPage+"");
        	clearData();
        	showInformation();
        }
    }
    
    public void clearData() {
    	pokemon1.setText("");
    	pokemon2.setText("");
    	pokemon3.setText("");
    	pokemon4.setText("");
    	pokemon5.setText("");
    	pokemon6.setText("");
    	pokemon7.setText("");
    	pokemon8.setText("");
    	pokemon9.setText("");
    	pokemon10.setText("");
    	pokemon11.setText("");
    	pokemon12.setText("");
    	pokemon13.setText("");
    	pokemon14.setText("");
    	pokemon15.setText("");
    	pokemon16.setText("");
    }
    @FXML
    void backToStage(ActionEvent event) {

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

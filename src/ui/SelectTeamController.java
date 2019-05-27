package ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import customeExceptions.BigTeamException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Game;
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
    private Button searchButton;

    @FXML
    private ComboBox<String> searchType;
    
    @FXML
    private Label playerTurn;
    
    @FXML
    private TextField pokemonToSearch;

    private Player players;
    private Game gm;
    
    
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
    
    public void setPlayers(Player p, Game nGame) {
		try {
			gm=nGame;
	    	players=p;
			players.loadPokemons();
			next.setVisible(false);
	    	showInformation();
	    	searchType.getItems().add("Binary");
	    	searchType.getItems().add("Lineal");
		} catch (IOException e) {
			e.printStackTrace();
			
		}

    }
    public void savePokemon(String name,Image pokemonPic) {
    	try {
        	Pokemon p=players.searchPokemon(name);
        	players.addPokemonLinkedList(name, pokemonPic, p.getType(), p.getBaseLife(), p.getBasicAtack(), p.getBasicDefense(), p.getEspecialAtack(), p.getEspecialDefense(), p.getSpeed());
			Alert score = new Alert(AlertType.INFORMATION);
		    score.setTitle("FinalFinal5EnElProyecto-Game");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(name+" is now in your team "+players.getSize());
		    score.show();
        	
        	if(players.getSize()>5) {
        		if(playerTurn.getText().equals("2")) {
        			disableButtons();
        			next.setVisible(true);
        		}else {
            		players=players.getNextPlayer();
            		players.loadPokemons();
            		playerTurn.setText("2");
        		}
        	}
    	}catch(BigTeamException bte) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("FinalFinal5EnElProyecto-Game");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(bte.getMessage());
		    score.show();
		    playerTurn.setText("2");
		    players=players.getNextPlayer();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
 }

    public void showInformation() throws IOException {
    	clearData();
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
    	    				b.get(bottonN).setVisible(true);
    	    				b.get(bottonN).setText(rootPokemon.get(i).getName());
    	    				b.get(bottonN).setBackground(new Background(new BackgroundImage(whatPokemosIs(rootPokemon.get(i).getName()),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,new BackgroundSize(b.get(0).getWidth(), b.get(0).getHeight(), true, true, true, true))));  
    	    				bottonN++;
    	    				if(bottonN>=b.size()) {
    	    					bottonN=0;
    	    				}   	    				
    	    			}else {
    	    				b.get(i).setVisible(true);
    	    				b.get(i).setText(rootPokemon.get(i).getName());
    	    				b.get(i).setBackground(new Background(new BackgroundImage(whatPokemosIs(rootPokemon.get(i).getName()),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,new BackgroundSize(b.get(0).getWidth(), b.get(0).getHeight(), true, true, true, true))));  

    	    			}
    		    }
    	    	flag=false;
    	    }
		}
    }
    
    private Image whatPokemosIs(String name) {
		if(name.equals("Zubat")==true) {
			return new Image(new File("imagesPokemons/zubat.jpg").toURI().toString());
		} else if (name.equals("Zapdos")==true) {
			return new Image(new File("imagesPokemons/zapdos.jpg").toURI().toString());
		} else if (name.equals("Wigglytuff")==true) {
			return new Image(new File("imagesPokemons/wigglytuff.jpg").toURI().toString());
		} else if (name.equals("Wezzing")==true) {
			return new Image(new File("imagesPokemons/weezing.jpg").toURI().toString());
		} else if (name.equals("Weepinbell")==true) {
			return new Image(new File("imagesPokemons/weepinbell.jpg").toURI().toString());
		} else if (name.equals("Weedle")==true) {
			return new Image(new File("imagesPokemons/weedle.jpg").toURI().toString());
		} else if (name.equals("Wartortle")==true) {
			return new Image(new File("imagesPokemons/wartotle.jpg").toURI().toString());
		}else if (name.equals("Vulpix")==true) {
			return new Image(new File("imagesPokemons/vulpix.jpg").toURI().toString());
		}else if (name.equals("Voltorb")==true) {
			return new Image(new File("imagesPokemons/voltorb.jpg").toURI().toString());
		}else if (name.equals("Vileplume")==true) {
			return new Image(new File("imagesPokemons/vileplume.jpg").toURI().toString());
		}else if (name.equals("Victreebel")==true) {
			return new Image(new File("imagesPokemons/victreebel.jpg").toURI().toString());
		}else if (name.equals("Venusaur")==true) {
			return new Image(new File("imagesPokemons/venusaur.jpg").toURI().toString());
		}else if (name.equals("Venonat")==true) {
			return new Image(new File("imagesPokemons/venonat.jpg").toURI().toString());
		}else if (name.equals("Venomoth")==true) {
			return new Image(new File("imagesPokemons/venomoth.jpg").toURI().toString());
		}else if (name.equals("Vaporeon")==true) {
			return new Image(new File("imagesPokemons/vaporeon.jpg").toURI().toString());
		}else if (name.equals("Tentacruel")==true) {
			return new Image(new File("imagesPokemons/tentacruel.jpg").toURI().toString());
		}else if (name.equals("Tentacool")==true) {
			return new Image(new File("imagesPokemons/tentacool.jpg").toURI().toString());
		}else if (name.equals("Tauros")==true) {
			return new Image(new File("imagesPokemons/Tauros.jpg").toURI().toString());
		}else if (name.equals("Tangela")==true) {
			return new Image(new File("imagesPokemons/tangela.jpg").toURI().toString());
		} else if (name.equals("Staryu")==true) {
			return new Image(new File("imagesPokemons/staryu.jpg").toURI().toString());
		} else if (name.equals("Starmie")==true) {
			return new Image(new File("imagesPokemons/starmie.jpg").toURI().toString());
		} else if (name.equals("Squirtle")==true) {
			return new Image(new File("imagesPokemons/squirtle.jpg").toURI().toString());
		} else if (name.equals("Spearow")==true) {
			return new Image(new File("imagesPokemons/spearow.jpg").toURI().toString());
		} else if (name.equals("Snorlax")==true) {
			return new Image(new File("imagesPokemons/snorlax.jpg").toURI().toString());
		}else if (name.equals("Slowpoke")==true) {
			return new Image(new File("imagesPokemons/slowpoke.jpg").toURI().toString());
		}else if (name.equals("Slowbro")==true) {
			return new Image(new File("imagesPokemons/slowbro.jpg").toURI().toString());
		}else if (name.equals("Shellder")==true) {
			return new Image(new File("imagesPokemons/shellder.jpg").toURI().toString());
		}else if (name.equals("Seel")==true) {
			return new Image(new File("imagesPokemons/seel.jpg").toURI().toString());
		}else if (name.equals("Seaking")==true) {
			return new Image(new File("imagesPokemons/seaking.jpg").toURI().toString());
		}else if (name.equals("Seadra")==true) {
			return new Image(new File("imagesPokemons/seadra.jpg").toURI().toString());
		}else if (name.equals("Scyther")==true) {
			return new Image(new File("imagesPokemons/scyther.jpg").toURI().toString());
		}else if (name.equals("Sandslash")==true) {
			return new Image(new File("imagesPokemons/sandslash.jpg").toURI().toString());
		}else if (name.equals("Sandshrew")==true) {
			return new Image(new File("imagesPokemons/sandshrew.jpg").toURI().toString());
		}else if (name.equals("Rhyhorn")==true) {
			return new Image(new File("imagesPokemons/rhyhorn.jpg").toURI().toString());
		}else if (name.equals("Rhydon")==true) {
			return new Image(new File("imagesPokemons/rhydon.jpg").toURI().toString());
		}else if (name.equals("Rattata")==true) {
			return new Image(new File("imagesPokemons/rattata.jpg").toURI().toString());
		} else if (name.equals("Raticate")==true) {
			return new Image(new File("imagesPokemons/raticate.jpg").toURI().toString());
		} else if (name.equals("Rapidash")==true) {
			return new Image(new File("imagesPokemons/rapidash.jpg").toURI().toString());
		} else if (name.equals("Raichu")==true) {
			return new Image(new File("imagesPokemons/raichu.jpg").toURI().toString());
		} else if (name.equals("Psyduck")==true) {
			return new Image(new File("imagesPokemons/psyduck.jpg").toURI().toString());
		} else if (name.equals("Primeape")==true) {
			return new Image(new File("imagesPokemons/primeape.jpg").toURI().toString());
		}else if (name.equals("Porygon")==true) {
			return new Image(new File("imagesPokemons/porygon.jpg").toURI().toString());
		}else if (name.equals("Ponyta")==true) {
			return new Image(new File("imagesPokemons/ponyta.jpg").toURI().toString());
		}else if (name.equals("Poliwrath")==true) {
			return new Image(new File("imagesPokemons/poliwrath.jpg").toURI().toString());
		}else if (name.equals("Poliwhirl")==true) {
			return new Image(new File("imagesPokemons/poliwhirl.jpg").toURI().toString());
		}else if (name.equals("Poliwag")==true) {
			return new Image(new File("imagesPokemons/poliwag.jpg").toURI().toString());
		}else if (name.equals("Pinsir")==true) {
			return new Image(new File("imagesPokemons/pinsir.jpg").toURI().toString());
		}else if (name.equals("Pikachu")==true) {
			return new Image(new File("imagesPokemons/pikachu.jpg").toURI().toString());
		}else if (name.equals("Pidgey")==true) {
			return new Image(new File("imagesPokemons/pidgey.jpg").toURI().toString());
		}else if (name.equals("Pidgeotto")==true) {
			return new Image(new File("imagesPokemons/pidgeotto.jpg").toURI().toString());
		}else if (name.equals("Pidgeot")==true) {
			return new Image(new File("imagesPokemons/pidgeot.jpg").toURI().toString());
		}else if (name.equals("Persian")==true) {
			return new Image(new File("imagesPokemons/persian.jpg").toURI().toString());
		} else if (name.equals("Parasect")==true) {
			return new Image(new File("imagesPokemons/parasect.jpg").toURI().toString());
		} else if (name.equals("Paras")==true) {
			return new Image(new File("imagesPokemons/paras.jpg").toURI().toString());
		} else if (name.equals("Onix")==true) {
			return new Image(new File("imagesPokemons/onix.jpg").toURI().toString());
		} else if (name.equals("Omastar")==true) {
			return new Image(new File("imagesPokemons/omastar.jpg").toURI().toString());
		}else if (name.equals("Omanyte")==true) {
			return new Image(new File("imagesPokemons/omanyte.jpg").toURI().toString());
		}else if (name.equals("Oddish")==true) {
			return new Image(new File("imagesPokemons/oddish.jpg").toURI().toString());
		}else if (name.equals("Ninetales")==true) {
			return new Image(new File("imagesPokemons/ninetales.jpg").toURI().toString());
		}else if (name.equals("Nidorino")==true) {
			return new Image(new File("imagesPokemons/nidorino.jpg").toURI().toString());
		}else if (name.equals("Nidorina")==true) {
			return new Image(new File("imagesPokemons/nidorina.jpg").toURI().toString());
		}else if (name.equals("Nidoran")==true) {
			return new Image(new File("imagesPokemons/nidoranMacho.jpg").toURI().toString());
		}else if (name.equals("Nidoqueen")==true) {
			return new Image(new File("imagesPokemons/nidoqueen.jpg").toURI().toString());
		}else if (name.equals("Nidoking")==true) {
			return new Image(new File("imagesPokemons/nidoking.jpg").toURI().toString());
		}else if (name.equals("Muk")==true) {
			return new Image(new File("imagesPokemons/muk.jpg").toURI().toString());
		}else if (name.equals("Mr.mime")==true) {
			return new Image(new File("imagesPokemons/mr. mime.jpg").toURI().toString());
		}else if (name.equals("Moltres")==true) {
			return new Image(new File("imagesPokemons/moltres.jpg").toURI().toString());
		}else if (name.equals("Mewtwo")==true) {
			return new Image(new File("imagesPokemons/mewtwo.jpg").toURI().toString());
		} else if (name.equals("Mew")==true) {
			return new Image(new File("imagesPokemons/mew.jpg").toURI().toString());
		} else if (name.equals("Metapod")==true) {
			return new Image(new File("imagesPokemons/metapod.jpg").toURI().toString());
		} else if (name.equals("Meowth")==true) {
			return new Image(new File("imagesPokemons/meowth.jpg").toURI().toString());
		} else if (name.equals("Marowak")==true) {
			return new Image(new File("imagesPokemons/marowak.jpg").toURI().toString());
		} else if (name.equals("Mankey")==true) {
			return new Image(new File("imagesPokemons/mankey.jpg").toURI().toString());
		}else if (name.equals("Magneton")==true) {
			return new Image(new File("imagesPokemons/magneton.jpg").toURI().toString());
		}else if (name.equals("Magnemite")==true) {
			return new Image(new File("imagesPokemons/magnemite.jpg").toURI().toString());
		}else if (name.equals("Magmar")==true) {
			return new Image(new File("imagesPokemons/magmar.jpg").toURI().toString());
		}else if (name.equals("Magikarp")==true) {
			return new Image(new File("imagesPokemons/magikarp.jpg").toURI().toString());
		}else if (name.equals("Machop")==true) {
			return new Image(new File("imagesPokemons/machop.jpg").toURI().toString());
		}else if (name.equals("Machoke")==true) {
			return new Image(new File("imagesPokemons/machoke.jpg").toURI().toString());
		}else if (name.equals("Machamp")==true) {
			return new Image(new File("imagesPokemons/machamp.jpg").toURI().toString());
		}else if (name.equals("Lickitung")==true) {
			return new Image(new File("imagesPokemons/lickitung.jpg").toURI().toString());
		}else if (name.equals("Lapras")==true) {
			return new Image(new File("imagesPokemons/lapras.jpg").toURI().toString());
		}else if (name.equals("Krabby")==true) {
			return new Image(new File("imagesPokemons/krabby.jpg").toURI().toString());
		}else if (name.equals("Koffing")==true) {
			return new Image(new File("imagesPokemons/koffing.jpg").toURI().toString());
		}else if (name.equals("Kingler")==true) {
			return new Image(new File("imagesPokemons/kingler.jpg").toURI().toString());
		}else if (name.equals("Kangaskhan")==true) {
			return new Image(new File("imagesPokemons/kangaskahn.jpg").toURI().toString());
		}else if (name.equals("Kakuna")==true) {
			return new Image(new File("imagesPokemons/kakuna.jpg").toURI().toString());
		}else if (name.equals("Kadabra")==true) {
			return new Image(new File("imagesPokemons/kadabra.jpg").toURI().toString());
		}else if (name.equals("Kabutops")==true) {
			return new Image(new File("imagesPokemons/kabutops.jpg").toURI().toString());
		}else if (name.equals("Kabuto")==true) {
			return new Image(new File("imagesPokemons/kabuto.jpg").toURI().toString());
		} else if (name.equals("Jynx")==true) {
			return new Image(new File("imagesPokemons/jynx.jpg").toURI().toString());
		} else if (name.equals("Jolteon")==true) {
			return new Image(new File("imagesPokemons/jolteon.jpg").toURI().toString());
		} else if (name.equals("Jigglypuff")==true) {
			return new Image(new File("imagesPokemons/jigglypuff.jpg").toURI().toString());
		} else if (name.equals("Ivysaur")==true) {
			return new Image(new File("imagesPokemons/ivysaur.jpg").toURI().toString());
		} else if (name.equals("Hypno")==true) {
			return new Image(new File("imagesPokemons/hypno.jpg").toURI().toString());
		}else if (name.equals("Horsea")==true) {
			return new Image(new File("imagesPokemons/horsea.jpg").toURI().toString());
		}else if (name.equals("Hitmonlee")==true) {
			return new Image(new File("imagesPokemons/hitmonlee.jpg").toURI().toString());
		}else if (name.equals("Hitmonchan")==true) {
			return new Image(new File("imagesPokemons/hitmonchan.jpg").toURI().toString());
		}else if (name.equals("Haunter")==true) {
			return new Image(new File("imagesPokemons/haunter.jpg").toURI().toString());
		}else if (name.equals("Gyarados")==true) {
			return new Image(new File("imagesPokemons/gyarados.jpg").toURI().toString());
		}else if (name.equals("Growlithe")==true) {
			return new Image(new File("imagesPokemons/growlithe.jpg").toURI().toString());
		}else if (name.equals("Grimer")==true) {
			return new Image(new File("imagesPokemons/grimer.jpg").toURI().toString());
		}else if (name.equals("Graveler")==true) {
			return new Image(new File("imagesPokemons/graveler.jpg").toURI().toString());
		}else if (name.equals("Golem")==true) {
			return new Image(new File("imagesPokemons/golem.jpg").toURI().toString());
		}else if (name.equals("Golduck")==true) {
			return new Image(new File("imagesPokemons/golduck.jpg").toURI().toString());
		}else if (name.equals("Goldeen")==true) {
			return new Image(new File("imagesPokemons/goldeen.jpg").toURI().toString());
		}else if (name.equals("Golbat")==true) {
			return new Image(new File("imagesPokemons/golbat.jpg").toURI().toString());
		} else if (name.equals("Gloom")==true) {
			return new Image(new File("imagesPokemons/gloom.jpg").toURI().toString());
		} else if (name.equals("Geodude")==true) {
			return new Image(new File("imagesPokemons/geodude.jpg").toURI().toString());
		} else if (name.equals("Gengar")==true) {
			return new Image(new File("imagesPokemons/gengar.jpg").toURI().toString());
		} else if (name.equals("Gastly")==true) {
			return new Image(new File("imagesPokemons/gastly.jpg").toURI().toString());
		} else if (name.equals("Flareon")==true) {
			return new Image(new File("imagesPokemons/flareon.jpg").toURI().toString());
		}else if (name.equals("Fearow")==true) {
			return new Image(new File("imagesPokemons/fearow.jpg").toURI().toString());
		}else if (name.equals("Farfetch")==true) {
			return new Image(new File("imagesPokemons/farfetch'd.jpg").toURI().toString());
		}else if (name.equals("Exeggutor")==true) {
			return new Image(new File("imagesPokemons/exeggutor.jpg").toURI().toString());
		}else if (name.equals("Exeggcute")==true) {
			return new Image(new File("imagesPokemons/exeggcute.jpg").toURI().toString());
		}else if (name.equals("Electrode")==true) {
			return new Image(new File("imagesPokemons/electrode.jpg").toURI().toString());
		}else if (name.equals("Electabuzz")==true) {
			return new Image(new File("imagesPokemons/electabuzz.jpg").toURI().toString());
		}else if (name.equals("Ekans")==true) {
			return new Image(new File("imagesPokemons/ekans.jpg").toURI().toString());
		}else if (name.equals("Eevee")==true) {
			return new Image(new File("imagesPokemons/eevee.jpg").toURI().toString());
		}else if (name.equals("Dugtrio")==true) {
			return new Image(new File("imagesPokemons/dugtrio.jpg").toURI().toString());
		}else if (name.equals("Drowzee")==true) {
			return new Image(new File("imagesPokemons/drowzee.jpg").toURI().toString());
		}else if (name.equals("Dratini")==true) {
			return new Image(new File("imagesPokemons/dratini.jpg").toURI().toString());
		} else if (name.equals("Dragonite")==true) {
			return new Image(new File("imagesPokemons/dragonite.jpg").toURI().toString());
		} else if (name.equals("Dragonair")==true) {
			return new Image(new File("imagesPokemons/dragonair.jpg").toURI().toString());
		} else if (name.equals("Doduo")==true) {
			return new Image(new File("imagesPokemons/Doduo.jpg").toURI().toString());
		} else if (name.equals("Dodrio")==true) {
			return new Image(new File("imagesPokemons/dodrio.jpg").toURI().toString());
		}else if (name.equals("Ditto")==true) {
			return new Image(new File("imagesPokemons/ditto.jpg").toURI().toString());
		}else if (name.equals("Diglett")==true) {
			return new Image(new File("imagesPokemons/diglett.jpg").toURI().toString());
		}else if (name.equals("Dewgong")==true) {
			return new Image(new File("imagesPokemons/dewgong.jpg").toURI().toString());
		}else if (name.equals("Cubone")==true) {
			return new Image(new File("imagesPokemons/cubone.jpg").toURI().toString());
		}else if (name.equals("Cloyster")==true) {
			return new Image(new File("imagesPokemons/cloyster.jpg").toURI().toString());
		}else if (name.equals("Clefairy")==true) {
			return new Image(new File("imagesPokemons/clefairy.jpg").toURI().toString());
		}else if (name.equals("Clefable")==true) {
			return new Image(new File("imagesPokemons/clefable.jpg").toURI().toString());
		}else if (name.equals("Charmeleon")==true) {
			return new Image(new File("imagesPokemons/charmeleon.jpg").toURI().toString());
		}else if (name.equals("Charmander")==true) {
			return new Image(new File("imagesPokemons/charmander.jpg").toURI().toString());
		}else if (name.equals("Charizard")==true) {
			return new Image(new File("imagesPokemons/charizard.jpg").toURI().toString());
		}else if (name.equals("Chansey")==true) {
			return new Image(new File("imagesPokemons/chansey.jpg").toURI().toString());
		}else if (name.equals("Caterpie")==true) {
			return new Image(new File("imagesPokemons/caterpie.jpg").toURI().toString());
		} else if (name.equals("Butterfree")==true) {
			return new Image(new File("imagesPokemons/butterfree.jpg").toURI().toString());
		} else if (name.equals("Bulbasaur")==true) {
			return new Image(new File("imagesPokemons/bulbasaur.jpg").toURI().toString());
		} else if (name.equals("Blastoise")==true) {
			return new Image(new File("imagesPokemons/blastoise.jpg").toURI().toString());
		} else if (name.equals("Bellsprout")==true) {
			return new Image(new File("imagesPokemons/bellsprout.jpg").toURI().toString());
		} else if (name.equals("Beedrill")==true) {
			return new Image(new File("imagesPokemons/beedrill.jpg").toURI().toString());
		}else if (name.equals("Articuno")==true) {
			return new Image(new File("imagesPokemons/articuno.jpg").toURI().toString());
		}else if (name.equals("Arcanine")==true) {
			return new Image(new File("imagesPokemons/arcanine.jpg").toURI().toString());
		}else if (name.equals("Arbok")==true) {
			return new Image(new File("imagesPokemons/arbok.jpg").toURI().toString());
		}else if (name.equals("Alakazam")==true) {
			return new Image(new File("imagesPokemons/alakazam.jpg").toURI().toString());
		}else if (name.equals("Aerodactyl")==true) {
			return new Image(new File("imagesPokemons/aerodactyl.jpg").toURI().toString());
		}else if (name.equals("Abra")==true) {
			return new Image(new File("imagesPokemons/abra.jpg").toURI().toString());
		}else if (name.equals("")) {
			return new Image(new File("iconPokemons/0.jpg").toURI().toString());
		}else{
			return new Image(new File("iconPokemons/0.jpg").toURI().toString());
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
    	pokemon1.setVisible(false);
    	pokemon2.setVisible(false);
    	pokemon3.setVisible(false);
    	pokemon4.setVisible(false);
    	pokemon5.setVisible(false);
    	pokemon6.setVisible(false);
    	pokemon7.setVisible(false);
    	pokemon8.setVisible(false);
    	pokemon9.setVisible(false);
    	pokemon10.setVisible(false);
    	pokemon11.setVisible(false);
    	pokemon12.setVisible(false);
    	pokemon13.setVisible(false);
    	pokemon14.setVisible(false);
    	pokemon15.setVisible(false);
    	pokemon16.setVisible(false);
    	
    	
    }
    public void disableButtons() {
    	pokemon1.setDisable(true);
    	pokemon2.setDisable(true);
    	pokemon3.setDisable(true);
    	pokemon4.setDisable(true);
    	pokemon5.setDisable(true);
    	pokemon6.setDisable(true);
    	pokemon7.setDisable(true);
    	pokemon8.setDisable(true);
    	pokemon9.setDisable(true);
    	pokemon10.setDisable(true);
    	pokemon11.setDisable(true);
    	pokemon12.setDisable(true);
    	pokemon13.setDisable(true);
    	pokemon14.setDisable(true);
    	pokemon15.setDisable(true);
    	pokemon16.setDisable(true);
    }
    @FXML
    void backToStage(ActionEvent event) {

    }

    @FXML
    void nextToStage(ActionEvent event) {

		try {
			FXMLLoader loader= new FXMLLoader(getClass().getResource("Match.fxml"));
			Parent root=loader.load();
			MatchController mc= (MatchController) loader.getController();
	    	mc.setGame(gm); 
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		   

		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void selectThisPokemon1(ActionEvent event) {
    	String namePokemon=pokemon1.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon10(ActionEvent event) {
    	String namePokemon=pokemon10.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon11(ActionEvent event) {
    	String namePokemon=pokemon11.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon12(ActionEvent event) {
    	String namePokemon=pokemon12.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon13(ActionEvent event) {
    	String namePokemon=pokemon13.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon14(ActionEvent event) {
    	String namePokemon=pokemon14.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon15(ActionEvent event) {
    	String namePokemon=pokemon15.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon16(ActionEvent event) {
    	String namePokemon=pokemon16.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon2(ActionEvent event) {
    	String namePokemon=pokemon2.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon3(ActionEvent event) {
    	String namePokemon=pokemon3.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon4(ActionEvent event) {
    	String namePokemon=pokemon4.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon5(ActionEvent event) {
    	String namePokemon=pokemon5.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon6(ActionEvent event) {
    	String namePokemon=pokemon6.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon7(ActionEvent event) {
    	String namePokemon=pokemon7.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon8(ActionEvent event) {
    	String namePokemon=pokemon8.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }

    @FXML
    void selectThisPokemon9(ActionEvent event) {
    	String namePokemon=pokemon9.getText();
    	Image img=whatPokemosIs(namePokemon);
    	savePokemon(namePokemon,img);
    }
    
    @FXML
    void searchAction(ActionEvent event) {
    	try {
        	String kind=searchType.getValue();
        	String nameToSearch=pokemonToSearch.getText();
        	Pokemon searching=null;
        	if(kind.equals("Binary")) {
        		Pokemon p=new Pokemon(nameToSearch,null,null,200,200,200,200,200,200);
        		searching=players.binarySearch(p);
        	}else if(kind.equals("Lineal")){
        		Pokemon p=new Pokemon(nameToSearch,null,null,200,200,200,200,200,200);
        		searching=players.linealSearch(p);
        	}      	
        
        	if(searching!=null) {
            	clearData();
            	pokemon1.setVisible(true);
            	pokemon1.setBackground(new Background(new BackgroundImage(whatPokemosIs(nameToSearch),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,new BackgroundSize(pokemon1.getWidth(), pokemon1.getHeight(), true, true, true, true))));  
                pokemon1.setText(searching.getName());
        	}else {
    			Alert score = new Alert(AlertType.ERROR);
    		    score.setTitle("FinalFinal5EnElProyecto-Game");
    		    score.initStyle(StageStyle.DECORATED);
    		    score.setContentText("That pokemons is not in this season");
    		    score.show();
        	}

    	}catch(IndexOutOfBoundsException npe) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("FinalFinal5EnElProyecto-Game");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText("That pokemons is not in this season");
		    score.show();
    	}

    }
    
}

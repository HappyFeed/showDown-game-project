package ui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Game;

public class MatchController {

	
	
    @FXML
    private Circle poke6;

    @FXML
    private Circle poke5;

    @FXML
    private Circle poke4;

    @FXML
    private Circle poke3;

    @FXML
    private Circle poke2;

    @FXML
    private Circle poke1;

    @FXML
    private Button creature1;

    @FXML
    private Button creature2;

    @FXML
    private Button creature3;

    @FXML
    private Button creature4;

    @FXML
    private Button creature5;

    @FXML
    private Button creature6;

    @FXML
    private Label rivalPlayer;

    @FXML
    private ImageView currentImage;

    @FXML
    private ImageView rivalImage;

    @FXML
    private Circle currentPoke4;

    @FXML
    private Circle currrentPoke6;

    @FXML
    private Circle currentPoke5;

    @FXML
    private Circle currentPoke3;

    @FXML
    private Circle currentPoke2;

    @FXML
    private Circle rivalPoke1;

    @FXML
    private Circle rivalPoke6;

    @FXML
    private Circle rivalPoke5;

    @FXML
    private Circle rivalPoke4;

    @FXML
    private Circle rivalPoke3;

    @FXML
    private Circle rivalPoke2;

    @FXML
    private Circle currentPoke1;

    @FXML
    private Rectangle imagePokeCurrent;

    @FXML
    private Rectangle imageRivalPoke;

    @FXML
    private Rectangle currentHP;

    @FXML
    private Rectangle currentHPRival;

    @FXML
    private Button attack1;

    @FXML
    private Button attack2;

    @FXML
    private Button attack3;

    @FXML
    private Button attack4;

    @FXML
    private Label turns;

    @FXML
    private Label currentPlayer;

    private Game newGame;
    
    public void setGame(Game nGame) {
    	newGame=nGame;
    }
    
    @FXML
    void attack1(ActionEvent event) {

    }

    @FXML
    void attack2(ActionEvent event) {

    }

    @FXML
    void attack3(ActionEvent event) {

    }

    @FXML
    void attack4(ActionEvent event) {

    }

    @FXML
    void giveUp(ActionEvent event) {

    }

    @FXML
    void saveGame(ActionEvent event) {

    }

    @FXML
    void switchPoke1(ActionEvent event) {

    }

    @FXML
    void switchPoke2(ActionEvent event) {

    }

    @FXML
    void switchPoke3(ActionEvent event) {

    }

    @FXML
    void switchPoke4(ActionEvent event) {

    }

    @FXML
    void switchPoke5(ActionEvent event) {

    }

    @FXML
    void switchPoke6(ActionEvent event) {

    }
    
    @SuppressWarnings("unused")
	private Image whatIconPokemosIs(String name) {
		if(name.equals("Zubat")==true) {
			return new Image(new File("iconPokemons/41.jpg").toURI().toString());
		} else if (name.equals("Zapdos")==true) {
			return new Image(new File("iconPokemons/145.jpg").toURI().toString());
		} else if (name.equals("Wigglytuff")==true) {
			return new Image(new File("iconPokemons/40.jpg").toURI().toString());
		} else if (name.equals("Wezzing")==true) {
			return new Image(new File("iconPokemons/110.jpg").toURI().toString());
		} else if (name.equals("Weepinbell")==true) {
			return new Image(new File("iconPokemons/70.jpg").toURI().toString());
		} else if (name.equals("Weedle")==true) {
			return new Image(new File("iconPokemons/13.jpg").toURI().toString());
		} else if (name.equals("Wartortle")==true) {
			return new Image(new File("iconPokemons/8.jpg").toURI().toString());
		}else if (name.equals("Vulpix")==true) {
			return new Image(new File("iconPokemons/37.jpg").toURI().toString());
		}else if (name.equals("Voltorb")==true) {
			return new Image(new File("iconPokemons/100.jpg").toURI().toString());
		}else if (name.equals("Vileplume")==true) {
			return new Image(new File("iconPokemons/45.jpg").toURI().toString());
		}else if (name.equals("Victreebel")==true) {
			return new Image(new File("iconPokemons/71.jpg").toURI().toString());
		}else if (name.equals("Venusaur")==true) {
			return new Image(new File("iconPokemons/3.jpg").toURI().toString());
		}else if (name.equals("Venonat")==true) {
			return new Image(new File("iconPokemons/48.jpg").toURI().toString());
		}else if (name.equals("Venomoth")==true) {
			return new Image(new File("iconPokemons/49.jpg").toURI().toString());
		}else if (name.equals("Vaporeon")==true) {
			return new Image(new File("iconPokemons/134.jpg").toURI().toString());
		}else if (name.equals("Tentacruel")==true) {
			return new Image(new File("iconPokemons/73.jpg").toURI().toString());
		}else if (name.equals("Tentacool")==true) {
			return new Image(new File("iconPokemons/72.jpg").toURI().toString());
		}else if (name.equals("Tauros")==true) {
			return new Image(new File("iconPokemons/128.jpg").toURI().toString());
		}else if (name.equals("Tangela")==true) {
			return new Image(new File("iconPokemons/114.jpg").toURI().toString());
		} else if (name.equals("Staryu")==true) {
			return new Image(new File("iconPokemons/120.jpg").toURI().toString());
		} else if (name.equals("Starmie")==true) {
			return new Image(new File("iconPokemons/121.jpg").toURI().toString());
		} else if (name.equals("Squirtle")==true) {
			return new Image(new File("iconPokemons/7.jpg").toURI().toString());
		} else if (name.equals("Spearow")==true) {
			return new Image(new File("iconPokemons/21.jpg").toURI().toString());
		} else if (name.equals("Snorlax")==true) {
			return new Image(new File("iconPokemons/143.jpg").toURI().toString());
		}else if (name.equals("Slowpoke")==true) {
			return new Image(new File("iconPokemons/79.jpg").toURI().toString());
		}else if (name.equals("Slowbro")==true) {
			return new Image(new File("iconPokemons/80.jpg").toURI().toString());
		}else if (name.equals("Shellder")==true) {
			return new Image(new File("iconPokemons/90.jpg").toURI().toString());
		}else if (name.equals("Seel")==true) {
			return new Image(new File("iconPokemons/86.jpg").toURI().toString());
		}else if (name.equals("Seaking")==true) {
			return new Image(new File("iconPokemons/119.jpg").toURI().toString());
		}else if (name.equals("Seadra")==true) {
			return new Image(new File("iconPokemons/117.jpg").toURI().toString());
		}else if (name.equals("Scyther")==true) {
			return new Image(new File("iconPokemons/123.jpg").toURI().toString());
		}else if (name.equals("Sandslash")==true) {
			return new Image(new File("iconPokemons/28.jpg").toURI().toString());
		}else if (name.equals("Sandshrew")==true) {
			return new Image(new File("iconPokemons/27.jpg").toURI().toString());
		}else if (name.equals("Rhyhorn")==true) {
			return new Image(new File("iconPokemons/112.jpg").toURI().toString());
		}else if (name.equals("Rhydon")==true) {
			return new Image(new File("iconPokemons/111.jpg").toURI().toString());
		}else if (name.equals("Rattata")==true) {
			return new Image(new File("iconPokemons/19.jpg").toURI().toString());
		} else if (name.equals("Raticate")==true) {
			return new Image(new File("iconPokemons/20.jpg").toURI().toString());
		} else if (name.equals("Rapidash")==true) {
			return new Image(new File("iconPokemons/78.jpg").toURI().toString());
		} else if (name.equals("Raichu")==true) {
			return new Image(new File("iconPokemons/26.jpg").toURI().toString());
		} else if (name.equals("Psyduck")==true) {
			return new Image(new File("iconPokemons/54.jpg").toURI().toString());
		} else if (name.equals("Primeape")==true) {
			return new Image(new File("iconPokemons/57.jpg").toURI().toString());
		}else if (name.equals("Porygon")==true) {
			return new Image(new File("iconPokemons/137.jpg").toURI().toString());
		}else if (name.equals("Ponyta")==true) {
			return new Image(new File("iconPokemons/77.jpg").toURI().toString());
		}else if (name.equals("Poliwrath")==true) {
			return new Image(new File("iconPokemons/62.jpg").toURI().toString());
		}else if (name.equals("Poliwhirl")==true) {
			return new Image(new File("iconPokemons/61.jpg").toURI().toString());
		}else if (name.equals("Poliwag")==true) {
			return new Image(new File("iconPokemons/60.jpg").toURI().toString());
		}else if (name.equals("Pinsir")==true) {
			return new Image(new File("iconPokemons/127.jpg").toURI().toString());
		}else if (name.equals("Pikachu")==true) {
			return new Image(new File("iconPokemons/25.jpg").toURI().toString());
		}else if (name.equals("Pidgey")==true) {
			return new Image(new File("iconPokemons/16.jpg").toURI().toString());
		}else if (name.equals("Pidgeotto")==true) {
			return new Image(new File("iconPokemons/17.jpg").toURI().toString());
		}else if (name.equals("Pidgeot")==true) {
			return new Image(new File("iconPokemons/18.jpg").toURI().toString());
		}else if (name.equals("Persian")==true) {
			return new Image(new File("iconPokemons/53.jpg").toURI().toString());
		} else if (name.equals("Parasect")==true) {
			return new Image(new File("iconPokemons/47.jpg").toURI().toString());
		} else if (name.equals("Paras")==true) {
			return new Image(new File("iconPokemons/46.jpg").toURI().toString());
		} else if (name.equals("Onix")==true) {
			return new Image(new File("iconPokemons/95.jpg").toURI().toString());
		} else if (name.equals("Omastar")==true) {
			return new Image(new File("iconPokemons/139.jpg").toURI().toString());
		}else if (name.equals("Omanyte")==true) {
			return new Image(new File("iconPokemons/138.jpg").toURI().toString());
		}else if (name.equals("Oddish")==true) {
			return new Image(new File("iconPokemons/43.jpg").toURI().toString());
		}else if (name.equals("Ninetales")==true) {
			return new Image(new File("iconPokemons/38.jpg").toURI().toString());
		}else if (name.equals("Nidorino")==true) {
			return new Image(new File("iconPokemons/33.jpg").toURI().toString());
		}else if (name.equals("Nidorina")==true) {
			return new Image(new File("iconPokemons/30.jpg").toURI().toString());
		}else if (name.equals("Nidoran")==true) {
			return new Image(new File("iconPokemons/32.jpg").toURI().toString());
		}else if (name.equals("Nidoqueen")==true) {
			return new Image(new File("iconPokemons/31.jpg").toURI().toString());
		}else if (name.equals("Nidoking")==true) {
			return new Image(new File("iconPokemons/34.jpg").toURI().toString());
		}else if (name.equals("Muk")==true) {
			return new Image(new File("iconPokemons/89.jpg").toURI().toString());
		}else if (name.equals("Mr.mime")==true) {
			return new Image(new File("iconPokemons/122.jpg").toURI().toString());
		}else if (name.equals("Moltres")==true) {
			return new Image(new File("iconPokemons/146.jpg").toURI().toString());
		}else if (name.equals("Mewtwo")==true) {
			return new Image(new File("iconPokemons/150.jpg").toURI().toString());
		} else if (name.equals("Mew")==true) {
			return new Image(new File("iconPokemons/151.jpg").toURI().toString());
		} else if (name.equals("Metapod")==true) {
			return new Image(new File("iconPokemons/11.jpg").toURI().toString());
		} else if (name.equals("Meowth")==true) {
			return new Image(new File("iconPokemons/52.jpg").toURI().toString());
		} else if (name.equals("Marowak")==true) {
			return new Image(new File("iconPokemons/105.jpg").toURI().toString());
		} else if (name.equals("Mankey")==true) {
			return new Image(new File("iconPokemons/56.jpg").toURI().toString());
		}else if (name.equals("Magneton")==true) {
			return new Image(new File("iconPokemons/82.jpg").toURI().toString());
		}else if (name.equals("Magnemite")==true) {
			return new Image(new File("iconPokemons/81.jpg").toURI().toString());
		}else if (name.equals("Magmar")==true) {
			return new Image(new File("iconPokemons/126.jpg").toURI().toString());
		}else if (name.equals("Magikarp")==true) {
			return new Image(new File("iconPokemons/129.jpg").toURI().toString());
		}else if (name.equals("Machop")==true) {
			return new Image(new File("iconPokemons/66.jpg").toURI().toString());
		}else if (name.equals("Machoke")==true) {
			return new Image(new File("iconPokemons/67.jpg").toURI().toString());
		}else if (name.equals("Machamp")==true) {
			return new Image(new File("iconPokemons/68.jpg").toURI().toString());
		}else if (name.equals("Lickitung")==true) {
			return new Image(new File("iconPokemons/108.jpg").toURI().toString());
		}else if (name.equals("Lapras")==true) {
			return new Image(new File("iconPokemons/131.jpg").toURI().toString());
		}else if (name.equals("Krabby")==true) {
			return new Image(new File("iconPokemons/98.jpg").toURI().toString());
		}else if (name.equals("Koffing")==true) {
			return new Image(new File("iconPokemons/109.jpg").toURI().toString());
		}else if (name.equals("Kingler")==true) {
			return new Image(new File("iconPokemons/99.jpg").toURI().toString());
		}else if (name.equals("Kangaskhan")==true) {
			return new Image(new File("iconPokemons/115.jpg").toURI().toString());
		}else if (name.equals("Kakuna")==true) {
			return new Image(new File("iconPokemons/14.jpg").toURI().toString());
		}else if (name.equals("Kadabra")==true) {
			return new Image(new File("iconPokemons/64.jpg").toURI().toString());
		}else if (name.equals("Kabutops")==true) {
			return new Image(new File("iconPokemons/141.jpg").toURI().toString());
		}else if (name.equals("Kabuto")==true) {
			return new Image(new File("iconPokemons/140.jpg").toURI().toString());
		} else if (name.equals("Jynx")==true) {
			return new Image(new File("iconPokemons/124.jpg").toURI().toString());
		} else if (name.equals("Jolteon")==true) {
			return new Image(new File("iconPokemons/135.jpg").toURI().toString());
		} else if (name.equals("Jigglypuff")==true) {
			return new Image(new File("iconPokemons/39.jpg").toURI().toString());
		} else if (name.equals("Ivysaur")==true) {
			return new Image(new File("iconPokemons/2.jpg").toURI().toString());
		} else if (name.equals("Hypno")==true) {
			return new Image(new File("iconPokemons/97.jpg").toURI().toString());
		}else if (name.equals("Horsea")==true) {
			return new Image(new File("iconPokemons/116.jpg").toURI().toString());
		}else if (name.equals("Hitmonlee")==true) {
			return new Image(new File("iconPokemons/106.jpg").toURI().toString());
		}else if (name.equals("Hitmonchan")==true) {
			return new Image(new File("iconPokemons/107.jpg").toURI().toString());
		}else if (name.equals("Haunter")==true) {
			return new Image(new File("iconPokemons/93.jpg").toURI().toString());
		}else if (name.equals("Gyarados")==true) {
			return new Image(new File("iconPokemons/130.jpg").toURI().toString());
		}else if (name.equals("Growlithe")==true) {
			return new Image(new File("iconPokemons/58.jpg").toURI().toString());
		}else if (name.equals("Grimer")==true) {
			return new Image(new File("iconPokemons/88.jpg").toURI().toString());
		}else if (name.equals("Graveler")==true) {
			return new Image(new File("iconPokemons/75.jpg").toURI().toString());
		}else if (name.equals("Golem")==true) {
			return new Image(new File("iconPokemons/76.jpg").toURI().toString());
		}else if (name.equals("Golduck")==true) {
			return new Image(new File("iconPokemons/55.jpg").toURI().toString());
		}else if (name.equals("Goldeen")==true) {
			return new Image(new File("iconPokemons/118.jpg").toURI().toString());
		}else if (name.equals("Golbat")==true) {
			return new Image(new File("iconPokemons/42.jpg").toURI().toString());
		} else if (name.equals("Gloom")==true) {
			return new Image(new File("iconPokemons/44.jpg").toURI().toString());
		} else if (name.equals("Geodude")==true) {
			return new Image(new File("iconPokemons/74.jpg").toURI().toString());
		} else if (name.equals("Gengar")==true) {
			return new Image(new File("iconPokemons/94.jpg").toURI().toString());
		} else if (name.equals("Gastly")==true) {
			return new Image(new File("iconPokemons/92.jpg").toURI().toString());
		} else if (name.equals("Flareon")==true) {
			return new Image(new File("iconPokemons/136.jpg").toURI().toString());
		}else if (name.equals("Fearow")==true) {
			return new Image(new File("iconPokemons/22.jpg").toURI().toString());
		}else if (name.equals("Farfetch")==true) {
			return new Image(new File("iconPokemons/83.jpg").toURI().toString());
		}else if (name.equals("Exeggutor")==true) {
			return new Image(new File("iconPokemons/103.jpg").toURI().toString());
		}else if (name.equals("Exeggcute")==true) {
			return new Image(new File("iconPokemons/102.jpg").toURI().toString());
		}else if (name.equals("Electrode")==true) {
			return new Image(new File("iconPokemons/101.jpg").toURI().toString());
		}else if (name.equals("Electabuzz")==true) {
			return new Image(new File("iconPokemons/125.jpg").toURI().toString());
		}else if (name.equals("Ekans")==true) {
			return new Image(new File("iconPokemons/23.jpg").toURI().toString());
		}else if (name.equals("Eevee")==true) {
			return new Image(new File("iconPokemons/133.jpg").toURI().toString());
		}else if (name.equals("Dugtrio")==true) {
			return new Image(new File("iconPokemons/51.jpg").toURI().toString());
		}else if (name.equals("Drowzee")==true) {
			return new Image(new File("iconPokemons/96.jpg").toURI().toString());
		}else if (name.equals("Dratini")==true) {
			return new Image(new File("iconPokemons/147.jpg").toURI().toString());
		} else if (name.equals("Dragonite")==true) {
			return new Image(new File("iconPokemons/149.jpg").toURI().toString());
		} else if (name.equals("Dragonair")==true) {
			return new Image(new File("iconPokemons/148.jpg").toURI().toString());
		} else if (name.equals("Doduo")==true) {
			return new Image(new File("iconPokemons/84.jpg").toURI().toString());
		} else if (name.equals("Dodrio")==true) {
			return new Image(new File("iconPokemons/85.jpg").toURI().toString());
		}else if (name.equals("Ditto")==true) {
			return new Image(new File("iconPokemons/132.jpg").toURI().toString());
		}else if (name.equals("Diglett")==true) {
			return new Image(new File("iconPokemons/50.jpg").toURI().toString());
		}else if (name.equals("Dewgong")==true) {
			return new Image(new File("iconPokemons/87.jpg").toURI().toString());
		}else if (name.equals("Cubone")==true) {
			return new Image(new File("iconPokemons/104.jpg").toURI().toString());
		}else if (name.equals("Cloyster")==true) {
			return new Image(new File("iconPokemons/91.jpg").toURI().toString());
		}else if (name.equals("Clefairy")==true) {
			return new Image(new File("iconPokemons/35.jpg").toURI().toString());
		}else if (name.equals("Clefable")==true) {
			return new Image(new File("iconPokemons/36.jpg").toURI().toString());
		}else if (name.equals("Charmeleon")==true) {
			return new Image(new File("iconPokemons/5.jpg").toURI().toString());
		}else if (name.equals("Charmander")==true) {
			return new Image(new File("iconPokemons/4.jpg").toURI().toString());
		}else if (name.equals("Charizard")==true) {
			return new Image(new File("iconPokemons/6.jpg").toURI().toString());
		}else if (name.equals("Chansey")==true) {
			return new Image(new File("iconPokemons/113.jpg").toURI().toString());
		}else if (name.equals("Caterpie")==true) {
			return new Image(new File("iconPokemons/10.jpg").toURI().toString());
		} else if (name.equals("Butterfree")==true) {
			return new Image(new File("iconPokemons/12.jpg").toURI().toString());
		} else if (name.equals("Bulbasaur")==true) {
			return new Image(new File("iconPokemons/1.jpg").toURI().toString());
		} else if (name.equals("Blastoise")==true) {
			return new Image(new File("iconPokemons/9.jpg").toURI().toString());
		} else if (name.equals("Bellsprout")==true) {
			return new Image(new File("iconPokemons/69.jpg").toURI().toString());
		} else if (name.equals("Beedrill")==true) {
			return new Image(new File("iconPokemons/15.jpg").toURI().toString());
		}else if (name.equals("Articuno")==true) {
			return new Image(new File("iconPokemons/144.jpg").toURI().toString());
		}else if (name.equals("Arcanine")==true) {
			return new Image(new File("iconPokemons/59.jpg").toURI().toString());
		}else if (name.equals("Arbok")==true) {
			return new Image(new File("iconPokemons/24.jpg").toURI().toString());
		}else if (name.equals("Alakazam")==true) {
			return new Image(new File("iconPokemons/65.jpg").toURI().toString());
		}else if (name.equals("Aerodactyl")==true) {
			return new Image(new File("iconPokemons/142.jpg").toURI().toString());
		}else if (name.equals("Abra")==true) {
			return new Image(new File("iconPokemons/63.jpg").toURI().toString());
		}else if (name.equals("")) {
			return new Image(new File("iconPokemons/0.jpg").toURI().toString());
		}else{
			return new Image(new File("iconPokemons/0.jpg").toURI().toString());
		}
	}
	
}

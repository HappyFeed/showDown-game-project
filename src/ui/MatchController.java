package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Game;
import model.Player;
import model.Pokemon;
import model.Skill;
import model.SkillAlteredStates;
import model.SkillDamage;
import model.SkillDefense;
import model.SkillHealth;
import threads.HealthThread;

public class MatchController {

	public static final String SER_FILE="playerSave/games.sc";
	
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
    private Button organiceButton;
    
    @FXML
    private ComboBox<String> electionTo;
    
    @FXML
    private Label turns;

    @FXML
    private Label currentPlayer;
    
    @FXML
    private Label pokemonInBattle;
   
    @FXML
    private Label enemyInBattle;
    
    @FXML
    private Label enemyPowerUp;
    
    @FXML
    private Label enemyState;
    
    @FXML
    private Label powerUp;
    
    @FXML
    private Label allyState;

    private Game newGame;
    
    public void setGame(Game nGame) {
    	newGame=nGame;
    	putIcons();

    	setPokemonsInBattle();

    	electionTo.getItems().add("Life");
    	electionTo.getItems().add("Speed");
    	electionTo.getItems().add("Basic atack");
    	electionTo.getItems().add("Special atack");
    	electionTo.getItems().add("Basic defense");
    	electionTo.getItems().add("Especial defense");
    }
    
    public List<Button> addButtons() {
    	List<Button> l= new ArrayList<Button>();
    	l.add(creature1);
    	l.add(creature2);
    	l.add(creature3);
    	l.add(creature4);
    	l.add(creature5);
    	l.add(creature6);
    	
    
    	return l;
    }
    
    public List<Circle> addCirclesPokes() {
    	List<Circle> l= new ArrayList<Circle>();
    	l.add(poke1);
    	l.add(poke2);
    	l.add(poke3);
    	l.add(poke4);
    	l.add(poke5);
    	l.add(poke6);
    	
    
    	return l;
    }
    
    public List<Circle> addCirclesCurrentPokes() {
    	List<Circle> l= new ArrayList<Circle>();
    	l.add(currentPoke1);
    	l.add(currentPoke2);
    	l.add(currentPoke3);
    	l.add(currentPoke4);
    	l.add(currentPoke5);
    	l.add(currrentPoke6);
    	
    
    	return l;
    }
    
    public List<Circle> addCirclesRivalPokes() {
    	List<Circle> l= new ArrayList<Circle>();
    	l.add(rivalPoke1);
    	l.add(rivalPoke2);
    	l.add(rivalPoke3);
    	l.add(rivalPoke4);
    	l.add(rivalPoke5);
    	l.add(rivalPoke6);
    	
    
    	return l;
    }
    
    public List<Button> addAtacks(){
    	List<Button> l= new ArrayList<Button>();
    	l.add(attack1);
    	l.add(attack2);
    	l.add(attack3);
    	l.add(attack4);
    	return l;
    }
    
    @FXML
    void attack1(ActionEvent event) {
    	String atackQuality=attack1.getText();
    	String[] parts= atackQuality.split("\n");
    	int power=0;
    	double health=0;
    	Player p=newGame.getFirstPlayer();
    	Pokemon current=p.searchPokemonInTeam(pokemonInBattle.getText());
    	Pokemon enemy=p.getNextPlayer().searchPokemonInTeam(enemyInBattle.getText());
    	System.out.println(enemy.getBaseLife());
        if(parts[2].equals("Damage")) {
        	power=Integer.parseInt(parts[3]);
        	HealthThread ht= new HealthThread(currentHPRival,enemy,current,power,0.0,"Damage",this);
        	ht.start();
        	System.out.println(enemy.getBaseLife());
        }else if(parts[2].equals("Health")) {
        	health=Double.parseDouble(parts[3]);
        	HealthThread ht= new HealthThread(currentHP,null,current,power,health,"Health",this);
        	ht.start();
        }else if(parts[2].equals("Defense")){
        	power=Integer.parseInt(parts[3]);
        	HealthThread ht= new HealthThread(currentHP,null,current,power,0.0,"Defense",this);
        	ht.start();
        }
        
    
        
    }

    public void setWeight(double w) {
    	currentHPRival.setWidth(w);
    }
    
    public void setFillRed() {
    	currentHPRival.setFill(Paint.valueOf("red"));
    }
    
    public void setFillGreen() {
    	currentHPRival.setFill(Paint.valueOf("lightgreen"));
    }
    
    public void setFillGreenA() {
    	currentHP.setFill(Paint.valueOf("lightgreen"));
    }
    
    public void setFillBlue() {
    	currentHP.setFill(Paint.valueOf("blue"));
    }
    
    public void setFillPink() {
    	currentHP.setFill(Paint.valueOf("pink"));
    }
    
    public void setPowerUP(String n) {
    	powerUp.setText(n);
    }
    
    public void setEnemyPowerUP(String n) {
    	enemyState.setText(n);
    }
    
    @FXML
    void attack2(ActionEvent event) {
    	String atackQuality=attack2.getText();
    	String[] parts= atackQuality.split("\n");
    	int power=0;
    	double health=0;
    	Player p=newGame.getFirstPlayer();
    	Pokemon current=p.searchPokemonInTeam(pokemonInBattle.getText());
    	Pokemon enemy=p.getNextPlayer().searchPokemonInTeam(enemyInBattle.getText());
    	System.out.println(enemy.getBaseLife());
        if(parts[2].equals("Damage")) {
        	power=Integer.parseInt(parts[3]);
        	HealthThread ht= new HealthThread(currentHPRival,enemy,current,power,0.0,"Damage",this);
        	ht.start();
        	System.out.println(enemy.getBaseLife());
        }else if(parts[2].equals("Health")) {
        	health=Double.parseDouble(parts[3]);
        	HealthThread ht= new HealthThread(currentHP,null,current,power,health,"Health",this);
        	ht.start();
        }else if(parts[2].equals("Defense")){
        	power=Integer.parseInt(parts[3]);
        	HealthThread ht= new HealthThread(currentHP,null,current,power,0.0,"Defense",this);
        	ht.start();
        }
       
    }

    @FXML
    void attack3(ActionEvent event) {
    	String atackQuality=attack3.getText();
    	String[] parts= atackQuality.split("\n");
    	int power=0;
    	double health=0;
    	Player p=newGame.getFirstPlayer();
    	Pokemon current=p.searchPokemonInTeam(pokemonInBattle.getText());
    	Pokemon enemy=p.getNextPlayer().searchPokemonInTeam(enemyInBattle.getText());
    	System.out.println(enemy.getBaseLife());
        if(parts[2].equals("Damage")) {
        	power=Integer.parseInt(parts[3]);
        	HealthThread ht= new HealthThread(currentHPRival,enemy,current,power,0.0,"Damage",this);
        	ht.start();
        	System.out.println(enemy.getBaseLife());
        }else if(parts[2].equals("Health")) {
        	health=Double.parseDouble(parts[3]);
        	HealthThread ht= new HealthThread(currentHP,null,current,power,health,"Health",this);
        	ht.start();
        }else if(parts[2].equals("Defense")){
        	power=Integer.parseInt(parts[3]);
        	HealthThread ht= new HealthThread(currentHP,null,current,power,0.0,"Defense",this);
        	ht.start();
        }
        
      
        
    }

    @FXML
    void attack4(ActionEvent event) {
    	String atackQuality=attack4.getText();
    	String[] parts= atackQuality.split("\n");
    	int power=0;
    	double health=0;
    	Player p=newGame.getFirstPlayer();
    	Pokemon current=p.searchPokemonInTeam(pokemonInBattle.getText());
    	Pokemon enemy=p.getNextPlayer().searchPokemonInTeam(enemyInBattle.getText());
    	System.out.println(enemy.getBaseLife());
    	
        if(parts[2].equals("Damage")) {
        	power=Integer.parseInt(parts[3]);
        	HealthThread ht= new HealthThread(currentHPRival,enemy,current,power,0.0,"Damage",this);
        	ht.start();
        	System.out.println(enemy.getBaseLife());
        }else if(parts[2].equals("Health")) {
        	health=Double.parseDouble(parts[3]);
        	HealthThread ht= new HealthThread(currentHP,null,current,power,health,"Health",this);
        	ht.start();
       
        }else if(parts[2].equals("Defense")){
        	power=Integer.parseInt(parts[3]);
        	HealthThread ht= new HealthThread(currentHP,null,current,power,0.0,"Defense",this);
        	ht.start();
      
        }
        
        
    }

    @FXML
    void giveUp(ActionEvent event) {

    }

    @FXML
    void saveGame(ActionEvent event) {
		  ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(SER_FILE));
			oos.writeObject(newGame);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void switchPoke1(ActionEvent event) {
    	
    	changePokemon(creature1.getText());
    }

    @FXML
    void switchPoke2(ActionEvent event) {
    	changePokemon(creature2.getText());

    }

    @FXML
    void switchPoke3(ActionEvent event) {
    	changePokemon(creature3.getText());
    }

    @FXML
    void switchPoke4(ActionEvent event) {
    	changePokemon(creature4.getText());

    }

    @FXML
    void switchPoke5(ActionEvent event) {
    	changePokemon(creature5.getText());

    }

    @FXML
    void switchPoke6(ActionEvent event) {
    	changePokemon(creature6.getText());

    }
    
    @FXML
    void organiceAction(ActionEvent event) {
    	String order=electionTo.getValue();
    	Player p=newGame.getFirstPlayer();
    	if(order.equals("Life")) {
    		p.selectionByBaseLife();
    		putIcons();
    	}else if(order.equals("Speed")) {
    		p.bubbleSortBySpeed();
    		putIcons();
    	}else if(order.equals("Basic atack")) {
    		p.selectionByAtackBasic();
    		putIcons();
    	}else if(order.equals("Special atack")) {
    		p.selectionByAtackEspecial();
    		putIcons();
    	}else if(order.equals("Basic defense")) {
    		p.insertionByDefenseBasic();
    		putIcons();
    	}else if(order.equals("Especial defense")) {
    		p.insertionByDefenseEspecial();
    		putIcons();
    	}
    }
  
	private Image whatIconPokemosIs(String name) {
		if(name.equals("Zubat")==true) {
			return new Image(new File("iconPokemons/41.png").toURI().toString());
		} else if (name.equals("Zapdos")==true) {
			return new Image(new File("iconPokemons/145.png").toURI().toString());
		} else if (name.equals("Wigglytuff")==true) {
			return new Image(new File("iconPokemons/40.png").toURI().toString());
		} else if (name.equals("Wezzing")==true) {
			return new Image(new File("iconPokemons/110.png").toURI().toString());
		} else if (name.equals("Weepinbell")==true) {
			return new Image(new File("iconPokemons/70.png").toURI().toString());
		} else if (name.equals("Weedle")==true) {
			return new Image(new File("iconPokemons/13.png").toURI().toString());
		} else if (name.equals("Wartortle")==true) {
			return new Image(new File("iconPokemons/8.png").toURI().toString());
		}else if (name.equals("Vulpix")==true) {
			return new Image(new File("iconPokemons/37.png").toURI().toString());
		}else if (name.equals("Voltorb")==true) {
			return new Image(new File("iconPokemons/100.png").toURI().toString());
		}else if (name.equals("Vileplume")==true) {
			return new Image(new File("iconPokemons/45.png").toURI().toString());
		}else if (name.equals("Victreebel")==true) {
			return new Image(new File("iconPokemons/71.png").toURI().toString());
		}else if (name.equals("Venusaur")==true) {
			return new Image(new File("iconPokemons/3.png").toURI().toString());
		}else if (name.equals("Venonat")==true) {
			return new Image(new File("iconPokemons/48.png").toURI().toString());
		}else if (name.equals("Venomoth")==true) {
			return new Image(new File("iconPokemons/49.png").toURI().toString());
		}else if (name.equals("Vaporeon")==true) {
			return new Image(new File("iconPokemons/134.png").toURI().toString());
		}else if (name.equals("Tentacruel")==true) {
			return new Image(new File("iconPokemons/73.png").toURI().toString());
		}else if (name.equals("Tentacool")==true) {
			return new Image(new File("iconPokemons/72.png").toURI().toString());
		}else if (name.equals("Tauros")==true) {
			return new Image(new File("iconPokemons/128.png").toURI().toString());
		}else if (name.equals("Tangela")==true) {
			return new Image(new File("iconPokemons/114.png").toURI().toString());
		} else if (name.equals("Staryu")==true) {
			return new Image(new File("iconPokemons/120.png").toURI().toString());
		} else if (name.equals("Starmie")==true) {
			return new Image(new File("iconPokemons/121.png").toURI().toString());
		} else if (name.equals("Squirtle")==true) {
			return new Image(new File("iconPokemons/7.png").toURI().toString());
		} else if (name.equals("Spearow")==true) {
			return new Image(new File("iconPokemons/21.png").toURI().toString());
		} else if (name.equals("Snorlax")==true) {
			return new Image(new File("iconPokemons/143.png").toURI().toString());
		}else if (name.equals("Slowpoke")==true) {
			return new Image(new File("iconPokemons/79.png").toURI().toString());
		}else if (name.equals("Slowbro")==true) {
			return new Image(new File("iconPokemons/80.png").toURI().toString());
		}else if (name.equals("Shellder")==true) {
			return new Image(new File("iconPokemons/90.png").toURI().toString());
		}else if (name.equals("Seel")==true) {
			return new Image(new File("iconPokemons/86.png").toURI().toString());
		}else if (name.equals("Seaking")==true) {
			return new Image(new File("iconPokemons/119.png").toURI().toString());
		}else if (name.equals("Seadra")==true) {
			return new Image(new File("iconPokemons/117.png").toURI().toString());
		}else if (name.equals("Scyther")==true) {
			return new Image(new File("iconPokemons/123.png").toURI().toString());
		}else if (name.equals("Sandslash")==true) {
			return new Image(new File("iconPokemons/28.png").toURI().toString());
		}else if (name.equals("Sandshrew")==true) {
			return new Image(new File("iconPokemons/27.png").toURI().toString());
		}else if (name.equals("Rhyhorn")==true) {
			return new Image(new File("iconPokemons/112.png").toURI().toString());
		}else if (name.equals("Rhydon")==true) {
			return new Image(new File("iconPokemons/111.png").toURI().toString());
		}else if (name.equals("Rattata")==true) {
			return new Image(new File("iconPokemons/19.png").toURI().toString());
		} else if (name.equals("Raticate")==true) {
			return new Image(new File("iconPokemons/20.png").toURI().toString());
		} else if (name.equals("Rapidash")==true) {
			return new Image(new File("iconPokemons/78.png").toURI().toString());
		} else if (name.equals("Raichu")==true) {
			return new Image(new File("iconPokemons/26.png").toURI().toString());
		} else if (name.equals("Psyduck")==true) {
			return new Image(new File("iconPokemons/54.png").toURI().toString());
		} else if (name.equals("Primeape")==true) {
			return new Image(new File("iconPokemons/57.png").toURI().toString());
		}else if (name.equals("Porygon")==true) {
			return new Image(new File("iconPokemons/137.png").toURI().toString());
		}else if (name.equals("Ponyta")==true) {
			return new Image(new File("iconPokemons/77.png").toURI().toString());
		}else if (name.equals("Poliwrath")==true) {
			return new Image(new File("iconPokemons/62.png").toURI().toString());
		}else if (name.equals("Poliwhirl")==true) {
			return new Image(new File("iconPokemons/61.png").toURI().toString());
		}else if (name.equals("Poliwag")==true) {
			return new Image(new File("iconPokemons/60.png").toURI().toString());
		}else if (name.equals("Pinsir")==true) {
			return new Image(new File("iconPokemons/127.png").toURI().toString());
		}else if (name.equals("Pikachu")==true) {
			return new Image(new File("iconPokemons/25.png").toURI().toString());
		}else if (name.equals("Pidgey")==true) {
			return new Image(new File("iconPokemons/16.png").toURI().toString());
		}else if (name.equals("Pidgeotto")==true) {
			return new Image(new File("iconPokemons/17.png").toURI().toString());
		}else if (name.equals("Pidgeot")==true) {
			return new Image(new File("iconPokemons/18.png").toURI().toString());
		}else if (name.equals("Persian")==true) {
			return new Image(new File("iconPokemons/53.png").toURI().toString());
		} else if (name.equals("Parasect")==true) {
			return new Image(new File("iconPokemons/47.png").toURI().toString());
		} else if (name.equals("Paras")==true) {
			return new Image(new File("iconPokemons/46.png").toURI().toString());
		} else if (name.equals("Onix")==true) {
			return new Image(new File("iconPokemons/95.png").toURI().toString());
		} else if (name.equals("Omastar")==true) {
			return new Image(new File("iconPokemons/139.png").toURI().toString());
		}else if (name.equals("Omanyte")==true) {
			return new Image(new File("iconPokemons/138.png").toURI().toString());
		}else if (name.equals("Oddish")==true) {
			return new Image(new File("iconPokemons/43.png").toURI().toString());
		}else if (name.equals("Ninetales")==true) {
			return new Image(new File("iconPokemons/38.png").toURI().toString());
		}else if (name.equals("Nidorino")==true) {
			return new Image(new File("iconPokemons/33.png").toURI().toString());
		}else if (name.equals("Nidorina")==true) {
			return new Image(new File("iconPokemons/30.png").toURI().toString());
		}else if (name.equals("Nidoran")==true) {
			return new Image(new File("iconPokemons/32.png").toURI().toString());
		}else if (name.equals("Nidoqueen")==true) {
			return new Image(new File("iconPokemons/31.png").toURI().toString());
		}else if (name.equals("Nidoking")==true) {
			return new Image(new File("iconPokemons/34.png").toURI().toString());
		}else if (name.equals("Muk")==true) {
			return new Image(new File("iconPokemons/89.png").toURI().toString());
		}else if (name.equals("Mr.mime")==true) {
			return new Image(new File("iconPokemons/122.png").toURI().toString());
		}else if (name.equals("Moltres")==true) {
			return new Image(new File("iconPokemons/146.png").toURI().toString());
		}else if (name.equals("Mewtwo")==true) {
			return new Image(new File("iconPokemons/150.png").toURI().toString());
		} else if (name.equals("Mew")==true) {
			return new Image(new File("iconPokemons/151.png").toURI().toString());
		} else if (name.equals("Metapod")==true) {
			return new Image(new File("iconPokemons/11.png").toURI().toString());
		} else if (name.equals("Meowth")==true) {
			return new Image(new File("iconPokemons/52.png").toURI().toString());
		} else if (name.equals("Marowak")==true) {
			return new Image(new File("iconPokemons/105.png").toURI().toString());
		} else if (name.equals("Mankey")==true) {
			return new Image(new File("iconPokemons/56.png").toURI().toString());
		}else if (name.equals("Magneton")==true) {
			return new Image(new File("iconPokemons/82.png").toURI().toString());
		}else if (name.equals("Magnemite")==true) {
			return new Image(new File("iconPokemons/81.png").toURI().toString());
		}else if (name.equals("Magmar")==true) {
			return new Image(new File("iconPokemons/126.png").toURI().toString());
		}else if (name.equals("Magikarp")==true) {
			return new Image(new File("iconPokemons/129.png").toURI().toString());
		}else if (name.equals("Machop")==true) {
			return new Image(new File("iconPokemons/66.png").toURI().toString());
		}else if (name.equals("Machoke")==true) {
			return new Image(new File("iconPokemons/67.png").toURI().toString());
		}else if (name.equals("Machamp")==true) {
			return new Image(new File("iconPokemons/68.png").toURI().toString());
		}else if (name.equals("Lickitung")==true) {
			return new Image(new File("iconPokemons/108.png").toURI().toString());
		}else if (name.equals("Lapras")==true) {
			return new Image(new File("iconPokemons/131.png").toURI().toString());
		}else if (name.equals("Krabby")==true) {
			return new Image(new File("iconPokemons/98.png").toURI().toString());
		}else if (name.equals("Koffing")==true) {
			return new Image(new File("iconPokemons/109.png").toURI().toString());
		}else if (name.equals("Kingler")==true) {
			return new Image(new File("iconPokemons/99.png").toURI().toString());
		}else if (name.equals("Kangaskhan")==true) {
			return new Image(new File("iconPokemons/115.png").toURI().toString());
		}else if (name.equals("Kakuna")==true) {
			return new Image(new File("iconPokemons/14.png").toURI().toString());
		}else if (name.equals("Kadabra")==true) {
			return new Image(new File("iconPokemons/64.png").toURI().toString());
		}else if (name.equals("Kabutops")==true) {
			return new Image(new File("iconPokemons/141.png").toURI().toString());
		}else if (name.equals("Kabuto")==true) {
			return new Image(new File("iconPokemons/140.png").toURI().toString());
		} else if (name.equals("Jynx")==true) {
			return new Image(new File("iconPokemons/124.png").toURI().toString());
		} else if (name.equals("Jolteon")==true) {
			return new Image(new File("iconPokemons/135.png").toURI().toString());
		} else if (name.equals("Jigglypuff")==true) {
			return new Image(new File("iconPokemons/39.png").toURI().toString());
		} else if (name.equals("Ivysaur")==true) {
			return new Image(new File("iconPokemons/2.png").toURI().toString());
		} else if (name.equals("Hypno")==true) {
			return new Image(new File("iconPokemons/97.png").toURI().toString());
		}else if (name.equals("Horsea")==true) {
			return new Image(new File("iconPokemons/116.png").toURI().toString());
		}else if (name.equals("Hitmonlee")==true) {
			return new Image(new File("iconPokemons/106.png").toURI().toString());
		}else if (name.equals("Hitmonchan")==true) {
			return new Image(new File("iconPokemons/107.png").toURI().toString());
		}else if (name.equals("Haunter")==true) {
			return new Image(new File("iconPokemons/93.png").toURI().toString());
		}else if (name.equals("Gyarados")==true) {
			return new Image(new File("iconPokemons/130.png").toURI().toString());
		}else if (name.equals("Growlithe")==true) {
			return new Image(new File("iconPokemons/58.png").toURI().toString());
		}else if (name.equals("Grimer")==true) {
			return new Image(new File("iconPokemons/88.png").toURI().toString());
		}else if (name.equals("Graveler")==true) {
			return new Image(new File("iconPokemons/75.png").toURI().toString());
		}else if (name.equals("Golem")==true) {
			return new Image(new File("iconPokemons/76.png").toURI().toString());
		}else if (name.equals("Golduck")==true) {
			return new Image(new File("iconPokemons/55.png").toURI().toString());
		}else if (name.equals("Goldeen")==true) {
			return new Image(new File("iconPokemons/118.png").toURI().toString());
		}else if (name.equals("Golbat")==true) {
			return new Image(new File("iconPokemons/42.png").toURI().toString());
		} else if (name.equals("Gloom")==true) {
			return new Image(new File("iconPokemons/44.png").toURI().toString());
		} else if (name.equals("Geodude")==true) {
			return new Image(new File("iconPokemons/74.png").toURI().toString());
		} else if (name.equals("Gengar")==true) {
			return new Image(new File("iconPokemons/94.png").toURI().toString());
		} else if (name.equals("Gastly")==true) {
			return new Image(new File("iconPokemons/92.png").toURI().toString());
		} else if (name.equals("Flareon")==true) {
			return new Image(new File("iconPokemons/136.png").toURI().toString());
		}else if (name.equals("Fearow")==true) {
			return new Image(new File("iconPokemons/22.png").toURI().toString());
		}else if (name.equals("Farfetch")==true) {
			return new Image(new File("iconPokemons/83.png").toURI().toString());
		}else if (name.equals("Exeggutor")==true) {
			return new Image(new File("iconPokemons/103.png").toURI().toString());
		}else if (name.equals("Exeggcute")==true) {
			return new Image(new File("iconPokemons/102.png").toURI().toString());
		}else if (name.equals("Electrode")==true) {
			return new Image(new File("iconPokemons/101.png").toURI().toString());
		}else if (name.equals("Electabuzz")==true) {
			return new Image(new File("iconPokemons/125.png").toURI().toString());
		}else if (name.equals("Ekans")==true) {
			return new Image(new File("iconPokemons/23.png").toURI().toString());
		}else if (name.equals("Eevee")==true) {
			return new Image(new File("iconPokemons/133.png").toURI().toString());
		}else if (name.equals("Dugtrio")==true) {
			return new Image(new File("iconPokemons/51.png").toURI().toString());
		}else if (name.equals("Drowzee")==true) {
			return new Image(new File("iconPokemons/96.png").toURI().toString());
		}else if (name.equals("Dratini")==true) {
			return new Image(new File("iconPokemons/147.png").toURI().toString());
		} else if (name.equals("Dragonite")==true) {
			return new Image(new File("iconPokemons/149.png").toURI().toString());
		} else if (name.equals("Dragonair")==true) {
			return new Image(new File("iconPokemons/148.png").toURI().toString());
		} else if (name.equals("Doduo")==true) {
			return new Image(new File("iconPokemons/84.png").toURI().toString());
		} else if (name.equals("Dodrio")==true) {
			return new Image(new File("iconPokemons/85.png").toURI().toString());
		}else if (name.equals("Ditto")==true) {
			return new Image(new File("iconPokemons/132.png").toURI().toString());
		}else if (name.equals("Diglett")==true) {
			return new Image(new File("iconPokemons/50.png").toURI().toString());
		}else if (name.equals("Dewgong")==true) {
			return new Image(new File("iconPokemons/87.png").toURI().toString());
		}else if (name.equals("Cubone")==true) {
			return new Image(new File("iconPokemons/104.png").toURI().toString());
		}else if (name.equals("Cloyster")==true) {
			return new Image(new File("iconPokemons/91.png").toURI().toString());
		}else if (name.equals("Clefairy")==true) {
			return new Image(new File("iconPokemons/35.png").toURI().toString());
		}else if (name.equals("Clefable")==true) {
			return new Image(new File("iconPokemons/36.png").toURI().toString());
		}else if (name.equals("Charmeleon")==true) {
			return new Image(new File("iconPokemons/5.png").toURI().toString());
		}else if (name.equals("Charmander")==true) {
			return new Image(new File("iconPokemons/4.png").toURI().toString());
		}else if (name.equals("Charizard")==true) {
			return new Image(new File("iconPokemons/6.png").toURI().toString());
		}else if (name.equals("Chansey")==true) {
			return new Image(new File("iconPokemons/113.png").toURI().toString());
		}else if (name.equals("Caterpie")==true) {
			return new Image(new File("iconPokemons/10.png").toURI().toString());
		} else if (name.equals("Butterfree")==true) {
			return new Image(new File("iconPokemons/12.png").toURI().toString());
		} else if (name.equals("Bulbasaur")==true) {
			return new Image(new File("iconPokemons/1.png").toURI().toString());
		} else if (name.equals("Blastoise")==true) {
			return new Image(new File("iconPokemons/9.png").toURI().toString());
		} else if (name.equals("Bellsprout")==true) {
			return new Image(new File("iconPokemons/69.png").toURI().toString());
		} else if (name.equals("Beedrill")==true) {
			return new Image(new File("iconPokemons/15.png").toURI().toString());
		}else if (name.equals("Articuno")==true) {
			return new Image(new File("iconPokemons/144.png").toURI().toString());
		}else if (name.equals("Arcanine")==true) {
			return new Image(new File("iconPokemons/59.png").toURI().toString());
		}else if (name.equals("Arbok")==true) {
			return new Image(new File("iconPokemons/24.png").toURI().toString());
		}else if (name.equals("Alakazam")==true) {
			return new Image(new File("iconPokemons/65.png").toURI().toString());
		}else if (name.equals("Aerodactyl")==true) {
			return new Image(new File("iconPokemons/142.png").toURI().toString());
		}else if (name.equals("Abra")==true) {
			return new Image(new File("iconPokemons/63.png").toURI().toString());
		}else if (name.equals("")) {
			return new Image(new File("iconPokemons/0.png").toURI().toString());
		}else{
			return new Image(new File("iconPokemons/0.png").toURI().toString());
		}
	}
    
    private void putIcons() {
    	 
    	ArrayList<Button> b=(ArrayList<Button>) addButtons();
    	ArrayList<Circle> currentPokes= (ArrayList<Circle>) addCirclesPokes();
    	ArrayList<Circle> rivalPokes= (ArrayList<Circle>) addCirclesRivalPokes();
    	ArrayList<Circle> myPokes= (ArrayList<Circle>) addCirclesCurrentPokes();
    	Player p=newGame.getFirstPlayer();
    	Pokemon pokeInTeam= p.getPokemons();
   
    	while (p!=null) {
    		if (currentImage.getImage()==null) {
				currentImage.setImage(p.getProfilePicture());
				currentPlayer.setText(p.getName());
			}else {
				rivalImage.setImage(p.getProfilePicture());
				rivalPlayer.setText(p.getName());

			}
    		while (pokeInTeam!=null) {
    			setSkills(pokeInTeam);
    			if(p.equals(newGame.getFirstPlayer())) {
    			for (int i = 0; i < b.size(); i++) {
    				
					myPokes.get(i).setFill(new ImagePattern(whatIconPokemosIs(pokeInTeam.getName())));
					currentPokes.get(i).setFill(new ImagePattern(whatIconPokemosIs(pokeInTeam.getName())));
					b.get(i).setBackground(new Background(new BackgroundImage(whatIconPokemosIs(pokeInTeam.getName()),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(34, 34, true, true, false, false))));  
    				b.get(i).setText(pokeInTeam.getName());
					pokeInTeam=pokeInTeam.getNextPokemon();
    			}	
    			}else {
    				for (int i = 0; i < myPokes.size(); i++) {
    					rivalPokes.get(i).setFill(new ImagePattern(whatIconPokemosIs(pokeInTeam.getName())));
    					pokeInTeam=pokeInTeam.getNextPokemon();
					}
    				
    			}
			  
			}
    		
    	   	
			p=p.getNextPlayer();
			if(p!=null) {
			pokeInTeam=p.getPokemons();
			}
		}
    
    	
    }
    

    public void setPokemonsInBattle() {
    	
    	Player p= newGame.getFirstPlayer();
    	Pokemon poke=p.getPokemons();
    	boolean flag=false;
    	while(p!=null) {
    		if(!flag) {
    			imagePokeCurrent.setFill(new ImagePattern(poke.getImg()));
    			pokemonInBattle.setText(poke.getName());
    			flag=true;
    		}else {
    			imageRivalPoke.setFill(new ImagePattern(poke.getImg()));
    			enemyInBattle.setText(poke.getName());
    		}
    		
    		p=p.getNextPlayer();
    		if(p!=null) {
				poke=p.getPokemons();
			}
    	}
    	
    }
    
    public void changePokemon(String name) {
    	
    	Player p=newGame.getFirstPlayer();
    	Pokemon poke = p.searchPokemonInTeam(name);
    	imagePokeCurrent.setFill(new ImagePattern(poke.getImg()));
    	pokemonInBattle.setText(name);
		setSkills(poke);	   	
    }
    
   

    public void setSkills(Pokemon p) {
    	ArrayList<Button> l=(ArrayList<Button>)addAtacks();
    	for(int i=0;i<4;i++) {
    		Skill s;
			try {
				s = p.selectSkill();
				if(s instanceof SkillDamage) {
					l.get(i).setText(s.getSkillName()+"\n"+s.getDescription()+"\n"+"Damage"+ s.toString());
				}else if(s instanceof SkillAlteredStates) {
					l.get(i).setText(s.getSkillName()+"\n"+s.getDescription()+"\n"+"States"+ s.toString());
				}else if(s instanceof SkillDefense) {
					l.get(i).setText(s.getSkillName()+"\n"+s.getDescription()+"\n"+"Defense"+ s.toString());
				}else if(s instanceof SkillHealth) {
					l.get(i).setText(s.getSkillName()+"\n"+s.getDescription()+"\n"+"Health"+ s.toString());
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    }

	
}

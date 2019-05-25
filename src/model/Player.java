package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;

import javafx.scene.image.Image;

@SuppressWarnings("serial")
public class Player implements Serializable{
	
	//Attributes
	private String name;
    private String profilePicture;
    
    private Player next;
    private Player prev;
    
    public static final String PATH = "pokemons/Pokemons.csv";

	//Relations
    private Pokemon team;
    private Pokemon rootPokemons;
    
	public Player(String name, String profilePicture) 
	{
		this.name = name;
		this.profilePicture = profilePicture;
		
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
    
	public String getProfilePicture() 
	{
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) 
	{
		this.profilePicture = profilePicture;
	}
	public Pokemon getPokemons() 
	{
		return team;
	}

    public Player getNextPlayer() {
		return next;
	}

	public void setNextPlayer(Player next) {
		this.next = next;
	}

	public Player getPrevPlayer() {
		return prev;
	}

	public void setPrevPlayer(Player prev) {
		this.prev = prev;
	}
	
	public boolean addPokemonLinkedList(String name, Image champPic, Type k, double baseLife, double basicAtack, double basicDefense, double especialAtack, double especialDefense, double speed) {
		Pokemon p= new Pokemon(name, champPic, k, baseLife, basicAtack, basicDefense, especialAtack, especialDefense, speed);
        boolean pokemonAdd=true;
		if(team == null) {
			team = p;
			team.setPrevPokemon(p);
			team.setNextPokemon(p);
		}else {
			Pokemon current = team;
			if(sizeTeam()<6) {				
    			current.setNextPokemon(p);
    			p.setPrevPokemon(current);
    			p.setNextPokemon(team);
    			team.setPrevPokemon(p);
			}else {
				pokemonAdd=false;
			}

		}
		return pokemonAdd;
	}
	
	public int sizeTeam() {
		int size=0;
		while(team!=null) {
			size++;
			team=team.getNextPokemon();
		}
		return size;
	}
   	
	public void loadPokemons() throws IOException {
		File file = new File(PATH);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		while(line != null){
			String[] parts = line.split(",");
			URL url = new URL(parts[1]);
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);	
			Pokemon nPokemon = new Pokemon(parts[0],img,Type.Fire,Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),Double.parseDouble(parts[5]),Double.parseDouble(parts[6]),Double.parseDouble(parts[7]),Double.parseDouble(parts[8]));
			addPokemonsToTree(nPokemon);
			line = br.readLine();
		}
		fileReader.close();
		br.close();
		
	}
	public void addPokemonsToTree(Pokemon p) {
		addPokemonsToTree(p,rootPokemons);
	}
	private void addPokemonsToTree(Pokemon part, Pokemon current) {
		if(rootPokemons == null) {
			rootPokemons = part;
		}
		else {
			if(part.compareTo(current) <= 0) {
				if(current.getLeft() == null) {
					current.setLeft(part);
				}else{
					addPokemonsToTree(part, current.getLeft());
				}
			} else{
				if(current.getRight() == null) {
					current.setRight(part);
				} else {
					addPokemonsToTree(part, current.getRight());
				}
			}
			
		}
	}
}

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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
	public Pokemon getRootPokemon() {
		return rootPokemons;
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
			/*URL url = new URL(parts[1]);
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);	*/
			Pokemon nPokemon = new Pokemon(parts[0],null,Type.Fire,Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),Double.parseDouble(parts[5]),Double.parseDouble(parts[6]),Double.parseDouble(parts[7]),Double.parseDouble(parts[8]));
			addPokemonsToTree(nPokemon);
			line = br.readLine();
		}
		fileReader.close();
		br.close();
		
	}

	public void addPokemonsToTree(Pokemon part) {
		if(rootPokemons == null) {
			rootPokemons = part;
		}else {
			Pokemon current=rootPokemons;
			Boolean flag=false;
			while(!flag) {
				if(current.compareTo(part)>0) {
					if(current.getRight()!=null) {
						current= current.getRight();
					}else {
						current.setRight(part);
						flag=true;
					}
				}else {
					if(current.getLeft()!=null) {
						current=current.getLeft();
					}else {
						current.setLeft(part);
						flag=true;
					}
				}
			}
		}
	}
	public Pokemon searchPokemon(String id) {
		Pokemon s= new Pokemon(id,null,Type.Fire,200,200,200,200,200,200);
		return searchPokemon(rootPokemons,s);
	}
	
	private Pokemon searchPokemon( Pokemon current,Pokemon s) {
		if(current!=null) {
			if(s.compareTo(current)<0) {
				if(current.getLeft()!=null){
					return searchPokemon(current.getLeft(),s);
				}else {
					return searchPokemon(current.getRight(), s);
				}
			}else if(s.compareTo(current)>0){
				if(current.getRight()!=null) {
					return searchPokemon(current.getRight(), s);
				}else {
					return searchPokemon(current.getLeft(), s);
				}
			}else {
				return current;
			}
		}
		return current;
	}
	public List<Pokemon> inOrder(){
		return inOrder(rootPokemons);
	}
	private List<Pokemon> inOrder(Pokemon r){
		List<Pokemon>l= new ArrayList<Pokemon>();
		if(r!=null) {
			inOrder(r.getLeft());
			l.add(r);
			inOrder(r.getRight());
		}
		return l;
	}
}

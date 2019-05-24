package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable{
	
	//Attributes
	private String name;
    private String profilePicture;
    
    private Player next;
    private Player prev;
    

	//Relations
    private Pokemon team;
    
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
	
	public boolean addPokemon(String name, String champPic, Type k, double baseLife, double basicAtack, double basicDefense, double especialAtack, double especialDefense, double speed) {
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
   	
}

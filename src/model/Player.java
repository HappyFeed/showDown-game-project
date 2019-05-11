package model;

public class Player {
	
	//Attributes
	private String name;
    private String profilePicture;
    
    //Relations
    private Pokemon[] team;
    
	public Player(String name, String profilePicture) 
	{
		this.name = name;
		this.profilePicture = profilePicture;
		
		team= new Pokemon[6];
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
	public Pokemon[] getPokemons() 
	{
		return team;
	}

	public void setPokemons(Pokemon[] champions)
	{
		this.team = champions;
	}
	public void addPokemon(String name, String champPic, Kind k, double baseLife, double basicAtack, double basicDefense, double especialAtack, double especialDefense, double speed) {
		Pokemon p= new Pokemon(name, champPic, k, baseLife, basicAtack, basicDefense, especialAtack, especialDefense, speed);
		for(int i=0; i<team.length;i++) {
			if(team[i]==null) {
				team[i]=p;
				i=team.length;
			}
		}
	}
   	
}

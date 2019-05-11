package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Player {
	
	//Attributes
	private String name;
    private String profilePicture;
    
    //Relations
    private Champ[] champions;
    
	public Player(String name, String profilePicture) 
	{
		this.name = name;
		this.profilePicture = profilePicture;
		
		champions= new Champ[6];
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
	public Champ[] getChampions() 
	{
		return champions;
	}

	public void setChampions(Champ[] champions)
	{
		this.champions = champions;
	}

    public void assignChamp() throws IOException
    {   
    	for(int i=0;i<6;i++) {
    		int numero = (int) (Math.random() * 6) + 1;  	
    		File f= new File("champs/"+numero+"-Champ.txt");
        	FileReader fr= new FileReader(f);
        	BufferedReader br= new BufferedReader(fr);
        	String line=br.readLine();
        	while(line !=null) {
        	   	if(line.startsWith("#")) {
        	   		line=br.readLine();
        	    }else if(line.startsWith("C:")) {
        	    	 String[] parts=line.split(";");
        	    	 String nameChamp=parts[0];
        	    	 String champPic=parts[1];
        	    	 double baseLife=Double.parseDouble(parts[3]);
        	    	 double baseMana=Double.parseDouble(parts[4]);
        	    	 Champ ch= new Champ(nameChamp, champPic,baseLife,baseMana);
        	    	 if(champions[i]==null) {
        	    		 champions[i]=ch;
        	    	 }
        	    	 line=br.readLine();
        	    }else {
        	    	String[] parts=line.split(";");
        	    	double damage=Double.parseDouble(parts[0]);
        	    	String description=parts[1];
        	    	double manaCost=Double.parseDouble(parts[2]);
        	    	champions[i].addSkills(damage, description, manaCost);
        	    }
        	}
        	br.close();
        	fr.close();
        }

    }
	
	
	
	
}

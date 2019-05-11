package model;

public class Skill {
     
	private double damage;
	private String description;
	private double manaCost;
	
	//Methods
    

	public double getDamage() 
	{
		return damage;
	}

	public Skill(double damage, String description, double manaCost) 
	{
		this.damage = damage;
		this.description = description;
		this.manaCost = manaCost;
	}

	public void setDamage(double damage) 
	{
		this.damage = damage;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public double getManaCost() 
	{
		return manaCost;
	}

	public void setManaCost(double manaCost) 
	{
		this.manaCost = manaCost;
	}
	
}

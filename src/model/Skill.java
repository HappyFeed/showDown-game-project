package model;

public class Skill {
     
	private String skillName;
	private String description;
	private double skillPower;
	
	//Methods
	public Skill(String skillName, String description, double skillPower) {
		super();
		this.skillName = skillName;
		this.description = description;
		this.skillPower = skillPower;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSkillPower() {
		return skillPower;
	}

	public void setSkillPower(double skillPower) {
		this.skillPower = skillPower;
	}
	
	
	
}

package model;

@SuppressWarnings("serial")
public class SkillHealth extends Skill{

	double healthPercent;
	
	public SkillHealth(String skillName, String skillDescription,double healthPercent) {
		super(skillName,skillDescription);
		this.healthPercent=healthPercent;
	}

	public double getHealthPercent() {
		return healthPercent;
	}

	public void setHealthPercent(double healthPercent) {
		this.healthPercent = healthPercent;
	}
	
}

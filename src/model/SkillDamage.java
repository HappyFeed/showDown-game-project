package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SkillDamage extends Skill implements Serializable{



	private int skillDamage;
	private int type;
	
	public SkillDamage(String skillName, String skillDescription,int type,int skillDamage) {
		super(skillName,skillDescription);
		this.skillDamage=skillDamage;
		this.type=type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSkillDamage() {
		return skillDamage;
	}

	public void setSkillDamage(int skillDamage) {
		this.skillDamage = skillDamage;
	}
	
	@Override
	public String toString() {
		return "skillDamage: " + skillDamage + "\n type: " + type ;
	}
}

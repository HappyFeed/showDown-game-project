package model;

@SuppressWarnings("serial")
public class SkillDefense extends Skill {

	int type;
	int skillDefense;
	
	public SkillDefense(String skillName, String skillDescription, int type, int skillDefense) {
		super(skillName,skillDescription);
		this.type=type;
		this.skillDefense=skillDefense;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSkillDefense() {
		return skillDefense;
	}

	public void setSkillDefense(int skillDefense) {
		this.skillDefense = skillDefense;
	}
	
}
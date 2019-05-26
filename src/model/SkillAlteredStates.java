package model;

@SuppressWarnings("serial")
public class SkillAlteredStates extends Skill{

	int alteredStateCode;
	public SkillAlteredStates(String skillName, String skillDescription, int alteredStateCode) {
		super(skillName,skillDescription);
		this.alteredStateCode=alteredStateCode;
	}
	
	public int getAlteredStateCode() {
		return alteredStateCode;
	}
	public void setAlteredStateCode(int alteredStateCode) {
		this.alteredStateCode = alteredStateCode;
	}
	
}

package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SkillAlteredStates extends Skill implements Serializable{

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

	@Override
	public String toString() {
		return "\n" + alteredStateCode ;
	}
	
	
	
}

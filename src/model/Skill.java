package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Skill implements Serializable, Comparable<Skill>{
     
	private String skillName;
	private String description;
	
	
	private Skill left;
	private Skill right;
	
    

	//Methods
	public Skill(String skillName, String description) {
		this.skillName = skillName;
		this.description = description;

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
	
	public Skill getLeft() {
		return left;
	}

	public void setLeft(Skill left) {
		this.left = left;
	}

	public Skill getRight() {
		return right;
	}

	public void setRight(Skill right) {
		this.right = right;
	}
	
	@Override
	public int compareTo(Skill p) {
		int comparation;
		
		if(skillName.compareTo(p.skillName)<0) {
			comparation = -1;
		}else if(skillName.compareTo(p.skillName)>0) {
			comparation =1;
		}else {
			comparation = 0;
		}
		return comparation;
	}
	
}

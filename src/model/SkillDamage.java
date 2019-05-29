package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SkillDamage extends Skill implements Serializable{


	//Atributtes
	private int skillDamage;
	private int type;
	
	/*This is a constructor method of SkillDamage
	 * 
	 */
	public SkillDamage(String skillName, String skillDescription,int type,int skillDamage) {
		super(skillName,skillDescription);
		this.skillDamage=skillDamage;
		this.type=type;
	}
	
	/*This method is to get Type of SkillDamage
	 * @pre: type != null || type == null
	 * @param: empty
	 * @return: This method return a int
	 * @post: got a type of SkillDamage
	 */

	public int getType() {
		return type;
	}
	
	/*This method is to set Type of SkillDamage
	 * @pre: type != null || type == null
	 * @param: int type
	 * @return: This method return void
	 * @post: type of SkillDamage changed
	 */

	public void setType(int type) {
		this.type = type;
	}
	
	/*This method is to get skillDamage of SkillDamage
	 * @pre: skillDamage != null || skillDamage == null
	 * @param: empty
	 * @return: This method return a int
	 * @post: got a skillDamage of SkillDamage
	 */

	public int getSkillDamage() {
		return skillDamage;
	}
	
	/*This method is to set skillDamage of SkillDamage
	 * @pre: skillDamage != null || skillDamage == null
	 * @param: int skillDamage
	 * @return: This method return void
	 * @post: skillDamage of SkillDamage changed
	 */

	public void setSkillDamage(int skillDamage) {
		this.skillDamage = skillDamage;
	}
	
	/*This method allow to String
	 * @pre: skillDamage != null || skillDamage == null
	 * @param: empty
	 * @return: This method return a String
	 * @post: got a skillDamage of SkillDamage
	 */
	
	@Override
	public String toString() {
		return "\n" + skillDamage;
	}
}

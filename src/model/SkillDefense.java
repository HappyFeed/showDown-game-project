package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SkillDefense extends Skill implements Serializable{


	//Atributtes
	int type;
	int skillDefense;
	
	
	/*This is a constructor method of SkillDefense
	 * 
	 */
	public SkillDefense(String skillName, String skillDescription, int type, int skillDefense) {
		super(skillName,skillDescription);
		this.type=type;
		this.skillDefense=skillDefense;
	}
	
	/*This method is to get type of SkillDefense
	 * @pre: type != null || type == null
	 * @param: empty
	 * @return: This method return a int
	 * @post: got a type of SkillDefense
	 */

	public int getType() {
		return type;
	}
	
	/*This method is to set type of SkillDefense
	 * @pre: type != null || type == null
	 * @param: int type
	 * @return: This method return void
	 * @post: type of SkillDefense changed
	 */

	public void setType(int type) {
		this.type = type;
	}
	
	/*This method is to get skillDefense of SkillDefense
	 * @pre: skillDefense != null || skillDefense == null
	 * @param: empty
	 * @return: This method return a int
	 * @post: got a skillDefense of SkillDefense
	 */

	public int getSkillDefense() {
		return skillDefense;
	}
	/*This method is to set skillDefense of SkillDefense
	 * @pre: skillDefense != null || skillDefense == null
	 * @param: int skillDefense
	 * @return: This method return void
	 * @post: skillDefense of SkillDefense changed
	 */
	
	public void setSkillDefense(int skillDefense) {
		this.skillDefense = skillDefense;
	}
	/*This method allow to String
	 * @pre: skillDefense != null || skillDefense == null
	 * @param: empty
	 * @return: This method return a String
	 * @post: got a skillDefense of SkillDefense
	 */
	
	@Override
	public String toString() {
		return "\n" + skillDefense ;
	}
	
}

package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SkillHealth extends Skill  implements Serializable{

	
	//Atributtes
	double healthPercent;
	/*This is a constructor method of SkillHealth
	 * 
	 */
	public SkillHealth(String skillName, String skillDescription,double healthPercent) {
		super(skillName,skillDescription);
		this.healthPercent=healthPercent;
	}
	
	/*This method is to get healthPercent of SkillHealth
	 * @pre: healthPercent != null || healthPercent == null
	 * @param: empty
	 * @return: This method return a double
	 * @post: got a healthPercent of SkillHealth
	 */

	public double getHealthPercent() {
		return healthPercent;
	}
	
	/*This method is to set healthPercent of SkillHealth
	 * @pre: healthPercent != null || healthPercent == null
	 * @param: double healthPercent
	 * @return: This method return void
	 * @post: healthPercent of SkillHealth changed
	 */

	public void setHealthPercent(double healthPercent) {
		this.healthPercent = healthPercent;
	}
	/*This method allow to String
	 * @pre: healthPercent != null || healthPercent == null
	 * @param: empty
	 * @return: This method return a String
	 * @post: got a healthPercent of SkillHealth
	 */
	
	@Override
	public String toString() {
		return  "\n"+healthPercent ;
	}
	
}

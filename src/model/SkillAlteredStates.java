package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SkillAlteredStates extends Skill implements Serializable{
	
	//Atributtes

	int alteredStateCode;
	
	/*This is a constructor method of SkillAlteredStates
	 * 
	 */
	public SkillAlteredStates(String skillName, String skillDescription, int alteredStateCode) {
		super(skillName,skillDescription);
		this.alteredStateCode=alteredStateCode;
	}
	/*This method is to get AlteredStateCode of SkillAlteredSates
	 * @pre: alteredStateCode != null || alteredStateCode == null
	 * @param: empty
	 * @return: This method return a int
	 * @post: got a alteredStateCode of SkillAlteredSates
	 */
	
	public int getAlteredStateCode() {
		return alteredStateCode;
	}
	
	/*This method is to set AlteredStateCode of SkillAlteredSates
	 * @pre: alteredStateCode != null || alteredStateCode == null
	 * @param: int alteredStateCode
	 * @return: This method return void
	 * @post: alteredStateCode of SkillAlteredSates
	 */
	public void setAlteredStateCode(int alteredStateCode) {
		this.alteredStateCode = alteredStateCode;
	}
	
	/*This method allow to String
	 * @pre: alteredStateCode != null || alteredStateCode == null
	 * @param: empty
	 * @return: This method return a String
	 * @post: got a alteredStateCode of SkillAlteredSates
	 */

	@Override
	public String toString() {
		return "\n" + alteredStateCode ;
	}
	
	
	
}

package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Skill implements Serializable, Comparable<Skill>{
	
	//Atributtes
     
	private String skillName;
	private String description;
	
	//Relations
	private Skill left;
	private Skill right;
	
    

	/*This is a constructor method of Skill
	 * 
	 */
	public Skill(String skillName, String description) {
		this.skillName = skillName;
		this.description = description;

	}
	
	/*This method is to get skillName of Skill
	 * @pre: skillName != ""
	 * @param: empty
	 * @return: This method return a String
	 * @post: got a skillName of skill
	 */

	public String getSkillName() {
		return skillName;
	}
	
	/*This method is to set skillName of Skill
	 * @pre: skillName != ""
	 * @param: String skillName
	 * @return: This method return void
	 * @post: skillName of skill changed
	 */

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	/*This method is to get description of Skill
	 * @pre: description != ""
	 * @param: empty
	 * @return: This method return a String
	 * @post: got a description of skill
	 */

	public String getDescription() {
		return description;
	}
	
	/*This method is to set description of Skill
	 * @pre: description != ""
	 * @param: String description
	 * @return: This method return void
	 * @post: description of skill changed
	 */
	
	

	public void setDescription(String description) {
		this.description = description;
	}
	
	/*This method is to get left of tree
	 * @pre: left != null || left == null
	 * @param: empty
	 * @return: This method return a Skill
	 * @post: got a left of skill
	 */
	
	public Skill getLeft() {
		return left;
	}
	
	/*This method is to set left of tree
	 * @pre: left != null || left == null
	 * @param: Skill left
	 * @return: This method return void
	 * @post: left of skill changed
	 */

	public void setLeft(Skill left) {
		this.left = left;
	}
	
	/*This method is to get right of tree
	 * @pre: right != null || right == null
	 * @param: empty
	 * @return: This method return a Skill
	 * @post: got a right of skill
	 */

	public Skill getRight() {
		return right;
	}
	
	/*This method is to set right of tree
	 * @pre: right != null || right == null
	 * @param: Skill right
	 * @return: This method return void
	 * @post: right of skill changed
	 */

	public void setRight(Skill right) {
		this.right = right;
	}
	
	/*This method allow to compare between Skill
	 * @pre: skillName != null 
	 * @param: Skill p
	 * @return: This method return a int
	 * @post: Skill compared
	 */
	
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

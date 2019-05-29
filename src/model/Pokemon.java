package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.image.Image;

@SuppressWarnings("serial")
public class Pokemon implements Serializable,  Comparable<Pokemon>{
		
	    //Attributes
	    private String name;
		private Image img;
		private Type k;
		private double baseLife;
		private double basicAtack;
		private double basicDefense;
		private double especialAtack;
		private double especialDefense;
		private double speed;
		
		private Pokemon next;
		private Pokemon prev;
		private Pokemon left;
		private Pokemon right;
		
		//Relations
		private Skill rootSkills;
		
		public static final String PATH = "skills/Skills.csv";
		
		/*This is a constructor method of Pokemon
		 * 
		 */
		public Pokemon(String name, Image champPic, Type k, double baseLife, double basicAtack, double basicDefense,
				double especialAtack, double especialDefense, double speed) throws IOException {
			super();
			this.name = name;
			this.img = champPic;
			this.k = k;
			this.baseLife = baseLife;
			this.basicAtack = basicAtack;
			this.basicDefense = basicDefense;
			this.especialAtack = especialAtack;
			this.especialDefense = especialDefense;
			this.speed = speed;
			loadSkills();

		}
		/*This method is to get a name of pokemon 
		 * @pre: name == "" || name != null
		 * @param: empty
		 * @return: This method return a String
		 * @post: got name of pokemon 
		 */
		
		   public String getName() {
			return name;
		}
		   /*This method is to set a name of pokemon 
			 * @pre: name == "" || name != null
			 * @param: String name
			 * @return: This method return void
			 * @post: name of pokemon changed 
			 */


		public void setName(String name) {
			this.name = name;
		}
		
		/*This method is to get a image of pokemon 
		 * @pre: image == null || image != null
		 * @param: empty
		 * @return: This method return a image of pokemon
		 * @post: got image of pokemon
		 */


		public Image getImg() {
			return img;
		}
		/*This method is to set a image of pokemon 
		 * @pre: image == null || image != null
		 * @param: Image img
		 * @return: This method return void
		 * @post: Image of pokemon changed
		 */


		public void setImg(Image img) {
			this.img = img;
		}
		
		/*This method is to get a type of pokemon 
		 * @pre: type == null || type != null
		 * @param: empty
		 * @return: This method return a type of pokemon
		 * @post: got type of pokemon
		 */


		public Type getType() {
			return k;
		}
		
		/*This method is to set a type of pokemon 
		 * @pre: type == null || type != null
		 * @param: int n
		 * @return: This method return void
		 * @post: Type of pokemon changed
		 */


		public void setType(int n) {
			this.k=k.assigType(n);
		}
		
		/*This method is to get a base life of pokemon 
		 * @pre: baseLife == null || baseLife != null
		 * @param: empty
		 * @return: This method return a baseLife of pokemon
		 * @post: got baseLife of pokemon
		 */


		public double getBaseLife() {
			return baseLife;
		}
		
		/*This method is to set a base life of pokemon 
		 * @pre: baseLife == null || baseLife != null
		 * @param: double baseLife
		 * @return: This method return a baseLife of pokemon
		 * @post: baseLife of pokemon changed
		 */


		public void setBaseLife(double baseLife) {
			this.baseLife = baseLife;
		}
		
		/*This method is to get a baseAtack of pokemon 
		 * @pre: baseAtack == null || baseAtack != null
		 * @param: empty
		 * @return: This method return a baseAtack of pokemon
		 * @post: got baseAtack of pokemon
		 */


		public double getBasicAtack() {
			return basicAtack;
		}
		
		/*This method is to set a baseAtack of pokemon 
		 * @pre: baseAtack == null || baseAtack != null
		 * @param: double basicAtack
		 * @return: This method return a void
		 * @post: baseAtack of pokemon changed
		 */


		public void setBasicAtack(double basicAtack) {
			this.basicAtack = basicAtack;
		}
		
		/*This method is to get a basicDefense of pokemon 
		 * @pre: basicDefense == null || basicDefense != null
		 * @param: empty
		 * @return: This method return a basicDefense of pokemon
		 * @post: got basicDefense of pokemon
		 */


		public double getBasicDefense() {
			return basicDefense;
		}
		
		/*This method is to set a basicDefense of pokemon 
		 * @pre: basicDefense == null || basicDefense != null
		 * @param: double basicDefense
		 * @return: This method return a void
		 * @post: basicDefense of pokemon changed
		 */


		public void setBasicDefense(double basicDefense) {
			this.basicDefense = basicDefense;
		}
		
		/*This method is to get a especialAtack of pokemon 
		 * @pre: especialAtack == null || especialAtack != null
		 * @param: empty
		 * @return: This method return a especialAtack of pokemon
		 * @post: got especialAtack of pokemon
		 */


		public double getEspecialAtack() {
			return especialAtack;
		}
		
		/*This method is to set a especialAtack of pokemon 
		 * @pre: especialAtack == null || especialAtack != null
		 * @param: double especialAtack
		 * @return: This method return void
		 * @post: especialAtack of pokemon changed
		 */


		public void setEspecialAtack(double especialAtack) {
			this.especialAtack = especialAtack;
		}
		/*This method is to get a especialDefense of pokemon 
		 * @pre: especialDefense == null || especialDefense != null
		 * @param: empty
		 * @return: This method return a especialDefense of pokemon
		 * @post: got especialDefense of pokemon
		 */

		public double getEspecialDefense() {
			return especialDefense;
		}
		
		/*This method is to set a especialDefense of pokemon 
		 * @pre: especialDefense == null || especialDefense != null
		 * @param: double especialDefense
		 * @return: This method return void
		 * @post: especialDefense of pokemon changed
		 */


		public void setEspecialDefense(double especialDefense) {
			this.especialDefense = especialDefense;
		}
		
		/*This method is to get a speed of pokemon 
		 * @pre: speed == null || speed != null
		 * @param: empty
		 * @return: This method return a speed of pokemon
		 * @post: got speed of pokemon
		 */


		public double getSpeed() {
			return speed;
		}
		
		/*This method is to set a speed of pokemon 
		 * @pre: speed == null || speed != null
		 * @param: double speed
		 * @return: This method return void
		 * @post: speed of pokemon changed
		 */


		public void setSpeed(double speed) {
			this.speed = speed;
		}
		
		/*This method is to get a rootskill of pokemons tree
		 * @pre: rootSkills == null || rootSkils != null
		 * @param: empty
		 * @return: This method return a rootSkills of tree
		 * @post: got rootSkils of tree
		 */


		public Skill getSkills() {
			return rootSkills;
		}
		
		/*This method is to get a NextPokemon of pokemons linkedList
		 * @pre: next == null || next != null
		 * @param: empty
		 * @return: This method return a next of linkedlist
		 * @post: got next of linkedList
		 */

		public Pokemon getNextPokemon() {
			return next;
		}
		
		/*This method is to set a NextPokemon of pokemons linkedList
		 * @pre: next == null || next != null
		 * @param: Pokemon next
		 * @return: This method return void
		 * @post: next of linkedList changed
		 */


		public void setNextPokemon(Pokemon next) {
			this.next = next;
		}
		
		/*This method is to get a prevPokemon of pokemons linkedList
		 * @pre: prev == null || prev != null
		 * @param: empty
		 * @return: This method return a prev of linkedlist
		 * @post: got prev of linkedList
		 */


		public Pokemon getPrevPokemon() {
			return prev;
		}
		
		/*This method is to set a prevPokemon of pokemons linkedList
		 * @pre: prev == null || prev != null
		 * @param: Pokemon prev
		 * @return: This method return void
		 * @post: prev of linkedList changed
		 */


		public void setPrevPokemon(Pokemon prev) {
			this.prev = prev;
		}
		
		/*This method is to get a leftPokemon of pokemon tree
		 * @pre: left == null || left != null
		 * @param: empty
		 * @return: This method return a left of tree
		 * @post: got left of tree
		 */

		public Pokemon getLeft() {
			return left;
		}
		
		/*This method is to set a leftPokemon of pokemon tree
		 * @pre: left == null || left != null
		 * @param: Pokemon left
		 * @return: This method return void
		 * @post: left of tree changed
		 */


		public void setLeft(Pokemon left) {
			this.left = left;
		}
		
		/*This method is to get a rightPokemon of pokemon tree
		 * @pre: right == null || right != null
		 * @param: empty
		 * @return: This method return a right of tree
		 * @post: got right of tree
		 */


		public Pokemon getRight() {
			return right;
		}
		
		/*This method is to set a rightPokemon of pokemon tree
		 * @pre: right == null || right != null
		 * @param: Pokemon right
		 * @return: This method return void
		 * @post: right of tree changed
		 */


		public void setRight(Pokemon right) {
			this.right = right;
		}
		
		/*This method is to set skill of pokemon tree
		 * @pre: rootSkill == null || setSkill != null
		 * @param: Skill root
		 * @return: This method return void
		 * @post: rootSkill of tree changed
		 */
		
		public void setSkill(Skill root) {
			this.rootSkills = root;
		}
		
		/*This method allow load the skill of file
		 * @pre: PATH != null
		 * @param: empty
		 * @return: This method return void
		 * @post: skills loaded
		 */
		
		public void loadSkills() throws IOException {
			File file = new File(PATH);
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			line = br.readLine();
			while(line != null){
				String[] parts = line.split(",");
				if(parts[0].equals("1")) {
					Skill s = new SkillDamage(parts[1],parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]));
					addSkillsToTree(s);
				}else if(parts[0].equals("2")) {
					Skill s = new SkillDefense(parts[1],parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]));
					addSkillsToTree(s);
				}else if(parts[0].equals("3")) {
					Skill s = new SkillAlteredStates(parts[1],parts[2],Integer.parseInt(parts[3]));
					addSkillsToTree(s);
				}else if(parts[0].equals("4")) {
					Skill s = new SkillHealth(parts[1],parts[2],Double.parseDouble(parts[3]));
					addSkillsToTree(s);
				}
				line = br.readLine();
			}
			fileReader.close();
			br.close();
			
		}
		
		/*This method allow to add the skill to tree
		 * @pre: rootSkills != null || rootSkill == null
		 * @param: Skill part
		 * @return: This method return void
		 * @post: skills added to tree
		 */
		
		public void addSkillsToTree(Skill part) {
			if(rootSkills == null) {
				rootSkills = part;
			}else {
				Skill current=rootSkills;
				Boolean flag=false;
				while(!flag) {
					if(current.compareTo(part)>0) {
						if(current.getRight()!=null) {
							current= current.getRight();
						}else {
							current.setRight(part);
							flag=true;
						}
					}else {
						if(current.getLeft()!=null) {
							current=current.getLeft();
						}else {
							current.setLeft(part);
							flag=true;
						}
					}
				}
			}
		}
		
		/*This method allow to select a random skill to tree
		 * @pre: rootSkills != null || rootSkill == null
		 * @param: empty
		 * @return: This method return Skill
		 * @post: randow skill selected
		 */

		public Skill selectSkill() throws IOException {
			ArrayList<Skill> s=preOrder();
			int n=(int) (Math.random() * (s.size()-1)) + 1;
			Skill selected=s.get(n);
			return selected;
		}
		
		/*This method allow to do a ArrayList of skill according pre order
		 * @pre: rootSkills != null || rootSkill == null
		 * @param: empty
		 * @return: This method return a ArrayList of Skill
		 * @post: Start a private method of preOrder
		 */
		public ArrayList<Skill> preOrder(){
			return preOrder(rootSkills);
		}
		
		/*This method allow to do a ArrayList of skill according pre order
		 * @pre: rootSkills != null || rootSkill == null
		 * @param: Skill root
		 * @return: This method return a ArrayList of Skill
		 * @post: The tree was organized
		 */
		private ArrayList<Skill> preOrder(Skill root){
			ArrayList<Skill> s= new ArrayList<Skill>();
			if(root!=null) {
				s.add(root);
				ArrayList<Skill> ls=preOrder(root.getLeft());
				ArrayList<Skill> lr=preOrder(root.getRight());
				s.addAll(ls);
				s.addAll(lr);
			}
			return s;
		}
		/*This method allow to compare between pokemons according Name
		 * @pre: name != null || name == null
		 * @param: Pokemon p
		 * @return: This method return a int
		 * @post: Pokemon compared
		 */
		@Override
		public int compareTo(Pokemon p) {
			int comparation;
			
			if(name.compareTo(p.name)<0) {
				comparation = -1;
			}else if(name.compareTo(p.name)>0) {
				comparation =1;
			}else {
				comparation = 0;
			}
			return comparation;
		}
		
}

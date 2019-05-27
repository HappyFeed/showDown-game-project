package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

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
		
		//Methods	
		public Pokemon(String name, Image champPic, Type k, double baseLife, double basicAtack, double basicDefense,
				double especialAtack, double especialDefense, double speed) {
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

		}
		
		
		   public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Image getImg() {
			return img;
		}


		public void setImg(Image img) {
			this.img = img;
		}


		public Type getType() {
			return k;
		}


		public void setType(Type k) {
			this.k = k;
		}


		public double getBaseLife() {
			return baseLife;
		}


		public void setBaseLife(double baseLife) {
			this.baseLife = baseLife;
		}


		public double getBasicAtack() {
			return basicAtack;
		}


		public void setBasicAtack(double basicAtack) {
			this.basicAtack = basicAtack;
		}


		public double getBasicDefense() {
			return basicDefense;
		}


		public void setBasicDefense(double basicDefense) {
			this.basicDefense = basicDefense;
		}


		public double getEspecialAtack() {
			return especialAtack;
		}


		public void setEspecialAtack(double especialAtack) {
			this.especialAtack = especialAtack;
		}


		public double getEspecialDefense() {
			return especialDefense;
		}


		public void setEspecialDefense(double especialDefense) {
			this.especialDefense = especialDefense;
		}


		public double getSpeed() {
			return speed;
		}


		public void setSpeed(double speed) {
			this.speed = speed;
		}


		public Skill getSkills() {
			return rootSkills;
		}

		public Pokemon getNextPokemon() {
			return next;
		}


		public void setNextPokemon(Pokemon next) {
			this.next = next;
		}


		public Pokemon getPrevPokemon() {
			return prev;
		}


		public void setPrevPokemon(Pokemon prev) {
			this.prev = prev;
		}

		public Pokemon getLeft() {
			return left;
		}


		public void setLeft(Pokemon left) {
			this.left = left;
		}


		public Pokemon getRight() {
			return right;
		}


		public void setRight(Pokemon right) {
			this.right = right;
		}
		
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

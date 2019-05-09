package model;

public class Champ {
		
	    //Attributes
	    private String name;
		private double baseLife;
		private double baseMana;
		
		//Relations
		private Skill[] skills;
		
		//Methods	
		public String getName() {
			return name;
		}
		public Champ(String name, double baseLife, double baseMana) {
			this.name = name;
			this.baseLife = baseLife;
			this.baseMana = baseMana;
			skills= new Skill[5];
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getBaseLife() {
			return baseLife;
		}
		public void setBaseLife(double baseLife) {
			this.baseLife = baseLife;
		}
		public double getBaseMana() {
			return baseMana;
		}
		public void setBaseMana(double baseMana) {
			this.baseMana = baseMana;
		}
		public Skill[] getSkills() {
			return skills;
		}
		
		
		
}

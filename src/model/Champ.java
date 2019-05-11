package model;

public class Champ {
		
	    //Attributes
	    private String name;
		private double baseLife;
		private double baseMana;
		private String champPic;
		//Relations
		private Skill[] skills;
		
		//Methods	
		public Champ(String name,String champPic, double baseLife, double baseMana) {
			this.name = name;
			this.baseLife = baseLife;
			this.baseMana = baseMana;
		    this.champPic= champPic;
			skills= new Skill[5];
		}
		
		public String getChampPic() {
			return champPic;
		}

		public void setChampPic(String champPic) {
			this.champPic = champPic;
		}

		public String getName() {
			return name;
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
		
		public void addSkills(double damage, String description, double manaCost) {
			Skill s= new Skill(damage,description,manaCost);
            for(int i=0;i<skills.length;i++) {
            	if(skills[i]==null) {
            		skills[i]=s;
            	}
            }
		}
		
}

package model;

public interface DamageCalculator {
	
	public double damage(Skill g,Pokemon defender);
	
	public void currentHp();

}

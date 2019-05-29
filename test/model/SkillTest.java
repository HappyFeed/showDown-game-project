package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SkillTest {
	
	private Skill skill;
	
	void setupScenary5() {
		skill = new SkillDamage("Salvatodos", "Epica", 5, 20);
	}
	
	void setupScenary6() {
		skill = null;
	}

	@Test
	void compareToTest1() {
		try {
			setupScenary5();
			Skill b = new SkillDamage("Amiwitos", "Legendaria", 10, 60);
			
			int c = b.compareTo(skill);
			
			assertTrue(c == -1);
			
		}catch(NullPointerException e) {
			
		}
	}
	
	@Test
	
	void compareToTest2() {
		try {
			setupScenary6();
			
			Skill b = new SkillDamage("Amiwitos", "Legendaria", 10, 60);
			
			int c = b.compareTo(skill);
			
		}catch(NullPointerException a) {
			assertTrue(true);
		}
	}

}

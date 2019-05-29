package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PokemonTest {

	private Pokemon pokemon;
	
	void setupScenary3() throws IOException {
		pokemon = new Pokemon("Pikachu", null, Type.Fire, 0, 0, 0, 0, 0, 0);
	}
	
	void setupScenary4() {
		pokemon = null;
	}
	
	@Test
	
	void addSkillsToTreeTest1() {
		try {
			//CIMETIDINE,Repeated falls,2,10
			//Sorbet APF,Puncture wound with foreign body of hip,2,36
			//Oxalis 20,"Unsp physeal fracture of lower end of right femur, init",1,18
			//TUSSIN COUGH,Absence of iris,2,22
			setupScenary3();
			Skill s = new SkillDamage("CIMETIDINE", "Repeated falls", 2, 10);
			
			pokemon.setSkill(null);
			pokemon.addSkillsToTree(s);
			
			assertTrue(pokemon.getSkills().getSkillName().equals("CIMETIDINE"));
		}catch(IOException e) {
			
		}
	}
	
	@Test
	
	void addSkillsToTreeTest2() {
		try {
			setupScenary4();
			Skill s = new SkillDamage("CIMETIDINE", "Repeated falls", 2, 10);
			pokemon.setSkill(null);
			pokemon.addSkillsToTree(s);
			
			
			
			
		}catch(NullPointerException n) {
			assertTrue(true);
		}
		
	}
	
	@Test
	 
	void selectSkillTest1() {
		try {
			setupScenary3();
			
			assertTrue(pokemon.selectSkill() instanceof Skill);
		}catch(IOException e) {
			
		}
	}
	
	@Test
	
	void selectSkillTest2() {
		try {
			setupScenary4();
			
			boolean a = pokemon.selectSkill() instanceof Skill;
			
		}catch(NullPointerException e) {
			assertTrue(true);
		}catch(IOException a) {
			
		}
	}
	
	@Test
	
	void preOrderTest1() {
		try {
			setupScenary3();
			pokemon.preOrder();
			
			assertTrue(pokemon.preOrder().get(0).getSkillName().equals("Sprayology Woman Power"));
		}catch(IOException a) {
		}
	}
	
	@Test
	
	void preOrderTest2() {
		try {
			setupScenary4();
			pokemon.preOrder();
		}catch(NullPointerException e) {
		assertTrue(true);	
		}
	}
	
	@Test
	
	void compareToTest1() {
		try {
			setupScenary3();
			Pokemon a= new Pokemon("Charizard", null, Type.Fire, 0, 0, 0, 0, 0, 0);
			
			int b = a.compareTo(pokemon);
			
			assertTrue(b == -1);
		}catch(IOException e) {
			
		}
	}
	
	@Test
	
	void compareToTest2() {
		try {
			setupScenary4();
			
			Pokemon a= new Pokemon("Charizard", null, Type.Fire, 0, 0, 0, 0, 0, 0);
			
			int b = a.compareTo(pokemon);
			
			
			
		}catch(NullPointerException b) {
			assertTrue(true);
		}catch(IOException a) {
			
		}
	}
}

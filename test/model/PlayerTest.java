package model;

import static org.junit.Assert.assertTrue;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class PlayerTest {
    
	private Player gm;
	
	void setUp1() throws ClassNotFoundException, IOException {
		 gm=new Player("alejandro","");
	}
	
	@Test
	void testAssignChamp() throws IOException, ClassNotFoundException {
		setUp1();
		gm.assignChamp();
		assertTrue("El metodo no asigna bien", gm.getChampions()[0]!=null);
		assertTrue("El metodo no cogio el nombre correcto",gm.getChampions()[0].getName().equals("Garen"));
		assertTrue("El metodo no cogio el nombre correcto",gm.getChampions()[0].getChampPic().equals("pic/garen.png"));
		assertTrue("El metodo no cogio el nombre correcto",gm.getChampions()[0].getBaseLife()==2000);
		assertTrue("El metodo no cogio el nombre correcto",gm.getChampions()[0].getBaseMana()==0);
	}
	

}

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
	void loadTest() throws IOException, ClassNotFoundException {
		setUp1();
        gm.loadPokemons();
        assertTrue("jisus",gm.getRootPokemon()!=null);
	}
	
}

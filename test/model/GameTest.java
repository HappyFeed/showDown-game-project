package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.junit.jupiter.api.Test;

import customeExceptions.BigNameException;
import customeExceptions.NoDataException;
import javafx.scene.image.Image;

class GameTest {
	
	private Game game;
	
	public void setupScenary1() {
		game = new Game();
	}

	@Test
	void addPlayerTest1() {
		try {
			setupScenary1();
			String a = "Juan";
			String b = "Pedro";
			URL url = new URL("https://robohash.org/etsitsed.bmp?size=50x50&set=set1");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			game.addPlayer(a, img);
			game.addPlayer(b, img);
			assertTrue(game.getFirstPlayer().getName().equals("Juan"));
			assertTrue(game.getFirstPlayer().getNextPlayer().getName().equals("Pedro"));
		}catch (BigNameException e) {
			fail("El nombre supera el lenght de 10");
		}catch (NoDataException a) {
			fail("Name no tiene valor y el avatar es nulo");
		}catch (IOException b) {
			fail("Se produce la excepcion IOException");
		}
	}
	
	@Test
	
	void addPlayerTest2() {
		try {
			setupScenary1();
			String a = "Rodrigoelmejor";
			URL url = new URL("https://robohash.org/etsitsed.bmp?size=50x50&set=set1");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			game.addPlayer(a, img);
			fail("No debría agregar el jugador porque es muy largo el nombre");
			
		}catch (BigNameException e) {
			assertTrue(true, "Atrapa la excepción porque el nombre es mayor a 10");
		
		}catch(NoDataException a) {
			fail("No debría salir esta excepcion porque se le dio valor a los atributos de Player");
			
		}catch(IOException b) {
			fail("Lanzo la excepcion IOException");
			
		}
	}
	
	@Test
	
	void searchPlayerTest1() {
		try {
			setupScenary1();
			String a = "Alejandro";
			String b = "Pepe";
			String c = "Juan";
			URL url = new URL("https://robohash.org/etsitsed.bmp?size=50x50&set=set1");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			game.addPlayer(a, img); 
			game.addPlayer(b, img);
			game.addPlayer(c, img);
			assertTrue(game.searchPlayer("Juan") == (game.getFirstPlayer().getNextPlayer().getNextPlayer()));
			
			
		}catch (BigNameException e) {
			fail("No debría generar excepcion porque los Player tiene como atrbiuto nombre menos a 10 caracteres");
		}catch (NoDataException a) {
			fail("No debría generar excepcion porque los atributos no estan vacios o nulos");
			}catch (IOException b) {
			fail("Produjo una IOException");
		}
	}
	
	@Test
	
	void searchPlayerTest2() {
		try {
			setupScenary1();
			String a = "Alejandro";
			String b = "";
			String c = "Juan";
			URL url = new URL("https://robohash.org/etsitsed.bmp?size=50x50&set=set1");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			game.addPlayer(a, img);
			
			game.addPlayer(c, img);
			assertTrue(game.searchPlayer("Juan") == game.getFirstPlayer().getNextPlayer());
			game.addPlayer(b, null);
			
			
		}catch (BigNameException a) {
			fail("No debía atrapar esta excepción");
		}catch (NoDataException b) {
			assertTrue(true, "Atrapa la excepcion cuando se trata de agregar un jugador con atributos nulos");
		}catch (IOException c) {
			fail("No debía atrapar esta excepcion");
		}
	}

}

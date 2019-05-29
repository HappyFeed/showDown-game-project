package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.junit.jupiter.api.Test;

import customeExceptions.BigTeamException;
import javafx.scene.image.Image;

class PlayerTest {
	private Player player;
	
	public void setupScenary2() throws IOException{
		URL url = new URL("https://robohash.org/etsitsed.bmp?size=50x50&set=set1");
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		Image img = new Image(in);
		player = new Player("Juan", img);
	}
	
	@Test
	void addPokemonLinkedListTest1() {
		try {
		setupScenary2();
		String n = "Charizard";
		String n1 = "Charmeleon";
		String n2 = "Charmander";
		String n3 = "Vulpix";
		String n4 = "Ninetales";
		String n5 = "Growlithe";
		
		Type k = Type.Fire;
		double baseLife = 286;
		double baseAttack = 12;
		double baseDefense = 4;
		double especialAttack = 10;
		double especialDefense = 6; 
		double speed = 10;
		URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		Image img = new Image(in);
		
		
		player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
		player.addPokemonLinkedList(n1, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
		player.addPokemonLinkedList(n2, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
		player.addPokemonLinkedList(n3, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
		player.addPokemonLinkedList(n4, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
		player.addPokemonLinkedList(n5, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
		
		assertTrue(player.getPokemons().getNextPokemon().getNextPokemon().getNextPokemon().getNextPokemon().getNextPokemon().getName().equals("Growlithe"));
		
		
		}catch (IOException e) {
			
			fail("No debe producir una excepcion");
			
		}catch (BigTeamException a) {
			fail ("No debe producir una excepcion");
		}
	}
	
	@Test
	
	void addPokemonLinkedListTest2() {
		try {
			setupScenary2();
			String n = "Charizard";
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
		}catch(IOException e) {
			fail("No debía producir IOException");
		}catch(BigTeamException b) {
			fail("No debía producir BigTeamException");
		}catch(NullPointerException n) {
			assertTrue(player.getPokemons().getPrevPokemon() == null);
		}
	}
	
	@Test
	
	void addPokemonsToTreeTest1() {
		try {
			setupScenary2();
			String n = "Charizard";
			Type k = Type.Fire;
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part1 = new Pokemon(n1, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part2 = new Pokemon(n2, null, k, 0, 0, 0, 0, 0, 0);
			
			player.addPokemonsToTree(part);
			player.addPokemonsToTree(part1);
			player.addPokemonsToTree(part2);
			
			assertTrue(player.getRootPokemon().getRight().getLeft().getName().equals("Charmander"));
		}catch(IOException e) {
			fail("No debría producir ninguna excepcion");
		}
	}
	
	@Test
	void addPokemonsToTreeTest2() {
		try {
			setupScenary2();
			String n = "Charizard";
			Type k = Type.Fire;
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			
			player.addPokemonsToTree(part);
		}catch (IOException e) {
			fail("No debía producir ninguna excepcion");
		}catch (NullPointerException a) {
			assertTrue(player.getRootPokemon().getLeft() == null || player.getRootPokemon().getRight() == null );
		}
	}
	
	@Test
	void searchPokemonTest1() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			Type k = Type.Fire;
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part1 = new Pokemon(n1, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part2 = new Pokemon(n2, null, k, 0, 0, 0, 0, 0, 0);
			
			player.addPokemonsToTree(part);
			player.addPokemonsToTree(part1);
			player.addPokemonsToTree(part2);
			
			assertTrue(player.searchPokemon(n1) == player.getRootPokemon().getRight());
			
			
		}catch(IOException e) {
			fail("No debría producir ninguna excepcion");
		}
	}
	
	@Test
	
	void searchPokemonTest2() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			Type k = Type.Fire;
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			
			player.addPokemonsToTree(part);
			
			assertTrue(player.searchPokemon("Charmander") != player.getRootPokemon() || player.searchPokemon("Charmander") != player.getRootPokemon().getLeft() || player.searchPokemon("Charmander") != player.getRootPokemon().getRight());
			
		}catch (IOException e) {
			
		}
	}
	
	@Test
	
	void inOrderTest1() {
		try {
			setupScenary2();
			String n = "Charizard";
			Type k = Type.Fire;
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part1 = new Pokemon(n1, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part2 = new Pokemon(n2, null, k, 0, 0, 0, 0, 0, 0);
			
			player.addPokemonsToTree(part);
			player.addPokemonsToTree(part1);
			player.addPokemonsToTree(part2);
			player.inOrder();
			
			assertTrue(player.inOrder().get(1) == part2);
			
		}catch (IOException e) {
			fail("No debío producir ninguna excepcion");
		}
	}
	
	@Test
	
	void inOrderTest2() {
		try {
			setupScenary2();
			
			
			
		}catch(IOException e) {
			fail("No debía generar esta excepción");
			
		}catch(NullPointerException b) {
			assertTrue(player.inOrder() == null);
		}
	}
	
	@Test
	
	void binarySearchTest1() {
		try {
			setupScenary2();
			String n = "Charizard";
			Type k = Type.Fire;
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Beedrill";
			String n4 = "Kakuna";
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part3 = new Pokemon(n3, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part1 = new Pokemon(n1, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part4 = new Pokemon(n4, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part2 = new Pokemon(n2, null, k, 0, 0, 0, 0, 0, 0);
			
			player.addPokemonsToTree(part);
			player.addPokemonsToTree(part3);
			
			player.addPokemonsToTree(part1);
			player.addPokemonsToTree(part4);
			player.addPokemonsToTree(part2);
			
			assertTrue(player.binarySearch(part2) == player.inOrder().get(2));
			
		}catch(IOException e) {
			fail("No debría producir una excepcion");
			
		}catch(IndexOutOfBoundsException i) {
			fail("No debría producir una excepción");
		}
	}
	
	@Test
	
	void binarySearchTest2() throws IOException {
		try {
			setupScenary2();
			String n = "Charizard";
			Type k = Type.Fire;
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part1 = new Pokemon(n1, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part2 = new Pokemon(n2, null, k, 0, 0, 0, 0, 0, 0);
			
			
			player.addPokemonsToTree(part);
			player.addPokemonsToTree(part1);
			player.addPokemonsToTree(part2);
			
			
			
		}catch (IOException e) {
			fail("No debía generar esta excepción");
			
		}catch(IndexOutOfBoundsException i) {
			fail("No debía generar esta excepción");
			
		}catch(NullPointerException a) {
			String n3 = "Pikachu";
			Type k = Type.Fire;
			Pokemon part3 = new Pokemon(n3, null, k, 0, 0, 0, 0, 0, 0);
			assertTrue(player.binarySearch(part3) == null);
			
		}
	}
	
	@Test
	
	void linealSearchTest1() {
		try {
			setupScenary2();
			String n = "Charizard";
			Type k = Type.Fire;
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Beedrill";
			String n4 = "Kakuna";
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part3 = new Pokemon(n3, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part1 = new Pokemon(n1, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part4 = new Pokemon(n4, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part2 = new Pokemon(n2, null, k, 0, 0, 0, 0, 0, 0);
			
			player.addPokemonsToTree(part);
			player.addPokemonsToTree(part3);
			
			player.addPokemonsToTree(part1);
			player.addPokemonsToTree(part4);
			player.addPokemonsToTree(part2);
			
			assertTrue(player.linealSearch(part4) == player.inOrder().get(4));
			
		}catch(IOException e) {
			fail("No debía generar excepcion");
		}catch(IndexOutOfBoundsException p) {
			fail("No debía generar excepcion");
		}
	}
	
	@Test
	
	void linealSearchTest2() throws IOException {
		try {
			setupScenary2();
			String n = "Charizard";
			Type k = Type.Fire;
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Beedrill";
			String n4 = "Kakuna";
			
			Pokemon part = new Pokemon(n, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part3 = new Pokemon(n3, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part1 = new Pokemon(n1, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part4 = new Pokemon(n4, null, k, 0, 0, 0, 0, 0, 0);
			Pokemon part2 = new Pokemon(n2, null, k, 0, 0, 0, 0, 0, 0);
			
			player.addPokemonsToTree(part);
			player.addPokemonsToTree(part3);
			
			player.addPokemonsToTree(part1);
			player.addPokemonsToTree(part4);
			player.addPokemonsToTree(part2);
			
		}catch(IOException a) {
			fail("No debía producir esta excepción");
		}catch(IndexOutOfBoundsException b) {
			fail("No debía producir esta excepción");
		}catch(NullPointerException p) {
			String n3 = "Pikachu";
			Type k = Type.Fire;
			Pokemon z = new Pokemon(n3, null, k, 0, 0, 0, 0, 0, 0);
			assertTrue(player.linealSearch(z) == null);
		}
		
	}
	
	@Test
	
	void bubbleSortByNameTest1() {
		try {
			setupScenary2();
			String n = "Charizard";
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Vulpix";
			String n4 = "Ninetales";
			String n5 = "Growlithe";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n1, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n2, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n3, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n4, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n5, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
			player.bubbleSortByName();
			
			assertTrue(player.getPokemons().getNextPokemon().getNextPokemon().getName().equals(n1));
		}catch(IOException b) {
			fail("No debría producir excepción");
		}catch(BigTeamException a) {
			fail("No debría producir excepción");
		}
	}
	
	@Test
	
	void bubbleSortByNameTest2() {
		try {
			setupScenary2();
			String n = "Charizard";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
			player.bubbleSortByName();
			
			assertTrue(player.getPokemons().getName().equals(n));
			
			
			
		}catch(IOException b) {
			fail("No debería producir ninguna excepción");
			
		}catch(BigTeamException c) {
			fail("No debería producir ninguna excepción");
		}
	}

	@Test
	
	void bubbleSortBySpeedTest1() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Vulpix";
			String n4 = "Ninetales";
			String n5 = "Growlithe";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			double speed1 = 20;
			double speed2 = 30;
			double speed3 = 40;
			double speed4 = 50;
			double speed5 = 60;
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed5);
			player.addPokemonLinkedList(n1, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed4);
			player.addPokemonLinkedList(n2, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed3);
			player.addPokemonLinkedList(n3, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed2);
			player.addPokemonLinkedList(n4, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed1);
			player.addPokemonLinkedList(n5, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
			player.bubbleSortBySpeed();
			
			assertTrue(player.getPokemons().getNextPokemon().getNextPokemon().getName().equals(n3));
			
		}catch(IOException a) {
			fail("No debería producir esta excepión");
		}catch(BigTeamException b) {
			fail("No debería producir esta excepión");
		}
	}
	
	@Test
	
	void burbbleSortBySpeedTest2() {
		try {
			setupScenary2();
			
			player.bubbleSortBySpeed();
			
			assertTrue(player.getPokemons() == null);
			
			
			
		}catch(IOException e) {
			
		}catch(NullPointerException a) {
			
		}
	}
	
	@Test
	
	void selectionByBaseLifeTest1() {
		try {
			setupScenary2();
			String n = "Charizard";
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Vulpix";
			String n4 = "Ninetales";
			String n5 = "Growlithe";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseLife1 = 287;
			double baseLife2 = 288;
			double baseLife3 = 289;
			double baseLife4 = 290;
			double baseLife5 = 291;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife5, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n1, img, k, baseLife4, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n2, img, k, baseLife3, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n3, img, k, baseLife2, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n4, img, k, baseLife1, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n5, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
			player.selectionByBaseLife();
			
			assertTrue(player.getPokemons().getNextPokemon().getName().equals(n4));
			
			
			
		}catch(IOException e) {
			
			
		}catch(BigTeamException a) {
			
		}
	}
	
	@Test
	
	void selectionByBaseLifeTest2() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.selectionByBaseLife();
			
			assertTrue(player.getPokemons().getName().equals(n));
		}catch(IOException a) {
			
		}catch(BigTeamException b) {
			
		}
	}
	
	@Test
	
	void selectionByBaseAttackTest1() {
		try {
			setupScenary2();
			String n = "Charizard";
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Vulpix";
			String n4 = "Ninetales";
			String n5 = "Growlithe";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseAttack1 = 13;
			double baseAttack2 = 14;
			double baseAttack3 = 15;
			double baseAttack4 = 16;
			double baseAttack5 = 17;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack5, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n1, img, k, baseLife, baseAttack4, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n2, img, k, baseLife, baseAttack3, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n3, img, k, baseLife, baseAttack2, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n4, img, k, baseLife, baseAttack1, baseDefense, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n5, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
			player.selectionByAtackBasic();
			
			assertTrue(player.getPokemons().getNextPokemon().getNextPokemon().getName().equals(n3));
			
			
			
		}catch(IOException e) {
			
			
		}catch(BigTeamException a) {
			
		}
	}
	
	@Test
	
	void selectionByBaseAttackTest2() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.selectionByAtackBasic();
			
			assertTrue(player.getPokemons().getName().equals(n));
			
		}catch(IOException a) {
			
		}catch(BigTeamException b) {
			
		}
	}
	
	@Test
	
	void selectionByAttackSpecialTest1() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Vulpix";
			String n4 = "Ninetales";
			String n5 = "Growlithe";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialAttack1 = 20;
			double especialAttack2 = 30;
			double especialAttack3 = 40;
			double especialAttack4 = 50;
			double especialAttack5 = 60;
			double especialDefense = 6; 
			double speed = 10;
			
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack5, especialDefense, speed);
			player.addPokemonLinkedList(n1, img, k, baseLife, baseAttack, baseDefense, especialAttack4, especialDefense, speed);
			player.addPokemonLinkedList(n2, img, k, baseLife, baseAttack, baseDefense, especialAttack3, especialDefense, speed);
			player.addPokemonLinkedList(n3, img, k, baseLife, baseAttack, baseDefense, especialAttack2, especialDefense, speed);
			player.addPokemonLinkedList(n4, img, k, baseLife, baseAttack, baseDefense, especialAttack1, especialDefense, speed);
			player.addPokemonLinkedList(n5, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
			player.selectionByAtackEspecial();
			
			assertTrue(player.getPokemons().getNextPokemon().getNextPokemon().getNextPokemon().getNextPokemon().getNextPokemon().getName().equals(n));
			
			
		}catch(IOException a) {
			
		}catch(BigTeamException b) {
			
		}
	}
	
	@Test
	
	void selectionByAttackSpecialTest2() {
		try {
			setupScenary2();
			
			
			player.selectionByAtackEspecial();
			
			assertTrue(player.getPokemons() == null);
			
		}catch(IOException b) {
			
		}
	}
	
	@Test
	
	void insertionByDefenseBasicTest1() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Vulpix";
			String n4 = "Ninetales";
			String n5 = "Growlithe";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double baseDefense1 = 5;
			double baseDefense2 = 6;
			double baseDefense3 = 7;
			double baseDefense4 = 8;
			double baseDefense5 = 9;
			double especialAttack = 10;
			double especialDefense = 6;
			double speed = 10;
			
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense5, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n1, img, k, baseLife, baseAttack, baseDefense4, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n2, img, k, baseLife, baseAttack, baseDefense3, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n3, img, k, baseLife, baseAttack, baseDefense2, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n4, img, k, baseLife, baseAttack, baseDefense1, especialAttack, especialDefense, speed);
			player.addPokemonLinkedList(n5, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
			player.insertionByDefenseBasic();
			
			assertTrue(player.getPokemons().getName().equals(n5));
			
			
			
		}catch(IOException e) {
			
		}catch(BigTeamException a) {
			
		}
	}
	
	@Test
	
	void insertionByBasicDefenseTest2() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.insertionByDefenseBasic();
			
			assertTrue(player.getPokemons().getName().equals(n));
			
		}catch(IOException a) {
			
		}catch(BigTeamException b) {
			
		}
	}
	
	@Test
	
	void insertionByDefenseSpecialTest1() {
		try {
			setupScenary2();
			String n = "Charizard";
			String n1 = "Charmeleon";
			String n2 = "Charmander";
			String n3 = "Vulpix";
			String n4 = "Ninetales";
			String n5 = "Growlithe";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6;
			double especialDefense1 = 7;
			double especialDefense2 = 8;
			double especialDefense3 = 9;
			double especialDefense4 = 10;
			double especialDefense5 = 11;
			double speed = 10;
			
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense5, speed);
			player.addPokemonLinkedList(n1, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense4, speed);
			player.addPokemonLinkedList(n2, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense3, speed);
			player.addPokemonLinkedList(n3, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense2, speed);
			player.addPokemonLinkedList(n4, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense1, speed);
			player.addPokemonLinkedList(n5, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			
			player.insertionByDefenseEspecial();
			
			assertTrue(player.getPokemons().getNextPokemon().getName().equals(n4));
			
			
		}catch(IOException a) {
			
		}catch(BigTeamException b) {
			
		}
	}
	
	@Test
	
	void insertionByDefenseSpecialTest2() {
		try {
			setupScenary2();
			
			String n = "Charizard";
			
			Type k = Type.Fire;
			double baseLife = 286;
			double baseAttack = 12;
			double baseDefense = 4;
			double especialAttack = 10;
			double especialDefense = 6; 
			double speed = 10;
			URL url = new URL("http://dummyimage.com/53x80.jpg/dddddd/000000");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			Image img = new Image(in);
			
			
			player.addPokemonLinkedList(n, img, k, baseLife, baseAttack, baseDefense, especialAttack, especialDefense, speed);
			player.insertionByDefenseEspecial();
			
			assertTrue(player.getPokemons().getName().equals(n));
		}catch(IOException e) {
			
		}catch(BigTeamException a) {
			
		}
	}
}

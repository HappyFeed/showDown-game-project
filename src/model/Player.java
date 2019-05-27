package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import customeExceptions.BigTeamException;
import javafx.scene.image.Image;

@SuppressWarnings("serial")
public class Player implements Serializable, Searching{
	
	//Attributes
	private String name;
    private Image profilePicture;
    private int size;
    
    private Player next;
    private Player prev;
    
    public static final String PATH = "pokemons/Pokemons.csv";

	//Relations
    private Pokemon team;
    private Pokemon rootPokemons;
    
	public Player(String name, Image profilePicture) 
	{
		this.name = name;
		this.profilePicture = profilePicture;
		
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
    
	public Image getProfilePicture() 
	{
		return profilePicture;
	}

	public void setProfilePicture(Image profilePicture) 
	{
		this.profilePicture = profilePicture;
	}
	public Pokemon getPokemons() 
	{
		return team;
	}

    public Player getNextPlayer() {
		return next;
	}

	public void setNextPlayer(Player next) {
		this.next = next;
	}

	public Player getPrevPlayer() {
		return prev;
	}

	public void setPrevPlayer(Player prev) {
		this.prev = prev;
	}
	public Pokemon getRootPokemon() {
		return rootPokemons;
	}
	public void addPokemonLinkedList(String name, Image champPic, Type k, double baseLife, double basicAtack, double basicDefense, double especialAtack, double especialDefense, double speed) throws BigTeamException  {
		Pokemon p= new Pokemon(name, champPic, k, baseLife, basicAtack, basicDefense, especialAtack, especialDefense, speed);
		if(team == null) {
			team = p;
			size++;
		}else {
			Pokemon current = team;	
			boolean flag=false;
    		while(!flag) {
    			if (current.getNextPokemon()==null) {
    				current.setNextPokemon(p);
    				p.setPrevPokemon(current);
    				size++;
    				flag=true;				
				}
    			current=current.getNextPokemon();
    		}
			
		}
	}
	
	
   	
	public int getSize() {
		return size;
	}

	public void loadPokemons() throws IOException {
		File file = new File(PATH);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		while(line != null){
			String[] parts = line.split(",");
			Pokemon nPokemon = new Pokemon(parts[0],null,Type.Fire,Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),Double.parseDouble(parts[5]),Double.parseDouble(parts[6]),Double.parseDouble(parts[7]),Double.parseDouble(parts[8]));
			addPokemonsToTree(nPokemon);
			line = br.readLine();

		}
		fileReader.close();
		br.close();
		
	}

	public void addPokemonsToTree(Pokemon part) {
		if(rootPokemons == null) {
			rootPokemons = part;
		}else {
			Pokemon current=rootPokemons;
			Boolean flag=false;
			while(!flag) {
				if(current.compareTo(part)<0) {
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
	public Pokemon searchPokemon(String id) {
		Pokemon s= new Pokemon(id,null,Type.Fire,200,200,200,200,200,200);
		return searchPokemon(rootPokemons,s);
	}
	
	private Pokemon searchPokemon( Pokemon current,Pokemon s) {
		if(current!=null) {
			if(s.compareTo(current)<0) {
				if(current.getLeft()!=null){
					return searchPokemon(current.getLeft(),s);
				}else {
					return searchPokemon(current.getRight(), s);
				}
			}else if(s.compareTo(current)>0){
				if(current.getRight()!=null) {
					return searchPokemon(current.getRight(), s);
				}else {
					return searchPokemon(current.getLeft(), s);
				}
			}else {
				return current;
			}
		}
		return current;
	}
	
	public ArrayList<Pokemon> inOrder(){
		return inOrder(rootPokemons);
	}
	private ArrayList<Pokemon> inOrder(Pokemon r){
		ArrayList<Pokemon>l= new ArrayList<Pokemon>();
		if(r!=null) {			
			l.addAll(inOrder(r.getLeft()));
			l.add(r);
			l.addAll(inOrder(r.getRight()));
		}
		return l;
	}

	@Override
	public Pokemon binarySearch(Pokemon p)throws IndexOutOfBoundsException {
		
		ArrayList<Pokemon> list=  inOrder();
		int low=0;
		int high=list.size();
		Pokemon found=null;
		while (low<=high) {
			int mid=(low+high)/2;
			if (list.get(mid).compareTo(p)<0) {
				low=mid+1;
				
			} else if (list.get(mid).compareTo(p)>0) {
				
				high=mid-1;
			} else {
				
				found= list.get(mid);
				break;
			}
		}

		return found;
	}

	@Override
	public Pokemon linealSearch(Pokemon p) throws IndexOutOfBoundsException{
		ArrayList<Pokemon> list=  inOrder();
		Pokemon found=null;
		
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).getName().equals(p.getName())) {
				found=list.get(i);
			}
			
		}
		
		return found;
	}
	
	public void bubbleSortByName() {
		if(team != null) {
			
			boolean changed = true;
			while(changed) {
				Pokemon currentNode = team;
				changed = false;
				//System.out.println("== NEW ITERATION A ==");
				while(currentNode.getNextPokemon() != null) {
					Pokemon nextNode = currentNode.getNextPokemon();
					//System.out.println(currentNode+" ? "+nextNode);
					if(currentNode.compareTo(nextNode)>0) {
						if(currentNode.getPrevPokemon()!=null) {
							currentNode.getPrevPokemon().setNextPokemon(nextNode);
						}
						if(nextNode.getNextPokemon()!=null) {
							nextNode.getNextPokemon().setPrevPokemon(currentNode);
						}
						
						currentNode.setNextPokemon(nextNode.getNextPokemon());
						nextNode.setPrevPokemon(currentNode.getPrevPokemon());
						currentNode.setPrevPokemon(nextNode);
						nextNode.setNextPokemon(currentNode);
						
						
						if(currentNode==team) {
							team = nextNode;
						}
						
						changed = true;
						
					}else{
						currentNode = currentNode.getNextPokemon();
					}
				}				
			}
		}
	}
}

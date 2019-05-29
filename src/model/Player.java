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
    
    /*This method is a constructor method of Player
     * 
     */
    
	public Player(String name, Image profilePicture) 
	{
		this.name = name;
		this.profilePicture = profilePicture;
		
	}
	
	//Get and setter
	
	/*This method is to get Name of Player
	 * @pre: name == "" || name != null
	 * @param: empty
	 * @return: This method return a string
	 * @post: Name of player
	 */

	public String getName() 
	{
		return name;
	}
	/*This method is to set Name of Player
	 * @pre: name == "" || name != null
	 * @param: String name
	 * @return: This method return void
	 * @post: Name of player changed
	 */
	
	public void setName(String name) 
	{
		this.name = name;
	}
	/*This method is to get Image of Player
	 * @pre: image == null || image != null
	 * @param: empty
	 * @return: This method return a Image
	 * @post: image of player
	 */
    
	public Image getProfilePicture() 
	{
		return profilePicture;
	}
	
	/*This method is to set Image of Player
	 * @pre: image == null || image != null
	 * @param: Image profilePicture
	 * @return: This method return void
	 * @post: Image of player changed
	 */

	public void setProfilePicture(Image profilePicture) 
	{
		this.profilePicture = profilePicture;
	}
	/*This method is to get firstPokemon of Player
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return a Pokemon
	 * @post: firstPokemon of player
	 */
	public Pokemon getPokemons() 
	{
		return team;
	}
	
	/*This method is to get nextPlayer of game
	 * @pre: next == null || next != null
	 * @param: empty
	 * @return: This method return a Player
	 * @post: next player of game
	 */

    public Player getNextPlayer() {
		return next;
	}
    
    /*This method is to set nextPlayer of game
	 * @pre: next == null || next != null
	 * @param: Player next
	 * @return: This method return void
	 * @post: player of game changed
	 */

	public void setNextPlayer(Player next) {
		this.next = next;
	}
	
	/*This method is to get prevPlayer of game
	 * @pre: prev == null || prev != null
	 * @param: empty
	 * @return: This method return a Player
	 * @post: previous player of game
	 */

	public Player getPrevPlayer() {
		return prev;
	}
	
	/*This method is to set prevPlayer of game
	 * @pre: prev == null || prev != null
	 * @param: Player prev
	 * @return: This method return void
	 * @post: previous player of game changed
	 */

	public void setPrevPlayer(Player prev) {
		this.prev = prev;
	}
	
	/*This method is to get root pokemon of tree
	 * @pre: rootPokemons == null || rootPokemons != null
	 * @param: empty
	 * @return: This method return a root pokemon
	 * @post: root pokemons of player
	 */
	public Pokemon getRootPokemon() {
		return rootPokemons;
	}
	
	/*This method is add pokemon to linkedlist 
	 * @pre: team == null || team != null
	 * @param: String name, Image champPic, Type k, double baseLife, double basicAtack
	 * double basicDefense, double especialAtack, double especialDefense, double speed
	 * @return: This method return void
	 * @post: new pokemon added
	 */
	public void addPokemonLinkedList(String name, Image champPic, Type k, double baseLife, double basicAtack, double basicDefense, double especialAtack, double especialDefense, double speed) throws BigTeamException, IOException  {
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
	
	/*This method is get a size of team
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return a int
	 * @post: Size of team
	 */
   	
	public int getSize() {
		return size;
	}
	
	/*This method allow to load pokemons of a file
	 * @pre: rootPokemons == null && PATH != null
	 * @param: empty
	 * @return: This method return void
	 * @post: Pokemons loaded
	 */

	public void loadPokemons() throws IOException {
		File file = new File(PATH);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		while(line != null){
			String[] parts = line.split(",");
			Pokemon nPokemon = new Pokemon(parts[0],null,Type.Fire,Double.parseDouble(parts[3]),Double.parseDouble(parts[4]),Double.parseDouble(parts[5]),Double.parseDouble(parts[6]),Double.parseDouble(parts[7]),Double.parseDouble(parts[8]));
			nPokemon.setType(Integer.parseInt(parts[2]));
			addPokemonsToTree(nPokemon);
			line = br.readLine();

		}
		fileReader.close();
		br.close();
		
	}
	
	/*This method allow to add pokemons to tree
	 * @pre: rootPokemons == null || rootPokemons != null
	 * @param: Pokemon part
	 * @return: This method return void
	 * @post: Pokemons added
	 */

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
	
	/*This method allow to search pokemons in a tree
	 * @pre: rootPokemons == null || rootPokemons != null
	 * @param: String id
	 * @return: This method return a Pokemon
	 * @post: Start a private method of search pokemon
	 */
	public Pokemon searchPokemon(String id) throws IOException {
		Pokemon s= new Pokemon(id,null,Type.Fire,200,200,200,200,200,200);
		return searchPokemon(rootPokemons,s);
	}
	
	/*This method allow to search pokemons in a tree
	 * @pre: rootPokemons == null || rootPokemons != null
	 * @param: Pokemon current, Pokemon s
	 * @return: This method return a Pokemon
	 * @post: Pokemons founded
	 */
	
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
	/*This method allow to do a ArrayList of organized pokemons in order
	 * @pre: rootPokemons == null || rootPokemons != null
	 * @param: empty
	 * @return: This method return a ArrayList of Pokemons
	 * @post: Star a private method of inOrder
	 */
	
	public ArrayList<Pokemon> inOrder(){
		return inOrder(rootPokemons);
	}
	/*This method allow to do a ArrayList of organized pokemons in order
	 * @pre: rootPokemons == null || rootPokemons != null
	 * @param: Pokemon r
	 * @return: This method return a ArrayList of Pokemons
	 * @post: Pokemons in a ArrayList organized in order
	 */
	private ArrayList<Pokemon> inOrder(Pokemon r){
		ArrayList<Pokemon>l= new ArrayList<Pokemon>();
		if(r!=null) {			
			l.addAll(inOrder(r.getLeft()));
			l.add(r);
			l.addAll(inOrder(r.getRight()));
		}
		return l;
	}
	/*This method allow to search a pokemon according to binary search
	 * @pre: rootPokemons == null || rootPokemons != null
	 * @param: Pokemon p
	 * @return: This method return a pokemon
	 * @post: Pokemon founded according to binarySearch
	 */

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
	/*This method allow to search a pokemon according to lineal search
	 * @pre: rootPokemons == null || rootPokemons != null
	 * @param: Pokemon p
	 * @return: This method return a pokemon
	 * @post: Pokemon founded according to linealSearch
	 */

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
	
	/*This method allow to organize a pokemon with bubble ordering
	  according to name of pokemons 
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return void
	 * @post: The linkedlist was organized
	 */
	
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
	/*This method allow to organize a pokemon with bubble ordering
	  according to speed of pokemons 
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return void
	 * @post: The linkedlist was organized
	 */
	public void bubbleSortBySpeed() {
		if(team != null) {
			
			boolean changed = true;
			while(changed) {
				Pokemon currentNode = team;
				changed = false;
				//System.out.println("== NEW ITERATION A ==");
				while(currentNode.getNextPokemon() != null) {
					Pokemon nextNode = currentNode.getNextPokemon();
					//System.out.println(currentNode+" ? "+nextNode);
					if(currentNode.getSpeed()>nextNode.getSpeed()) {
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
	/*This method allow to organize a pokemon with selection ordering
	  according to baseLife of pokemons 
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return void
	 * @post: The linkedlist was organized
	 */
	
	public void selectionByBaseLife() {
		Pokemon current = team;
		while(current != null) {
			Pokemon temp = current.getNextPokemon();
			Pokemon min = current;
			while(temp != null) {
				if(temp.getBaseLife() <= min.getBaseLife()) {
					min = temp;
				}
				temp = temp.getNextPokemon();
			}
			boolean firstIt = false;
			if(min != current) {
				Pokemon next1 = current.getNextPokemon();
				Pokemon previous1 = current.getPrevPokemon();
				
				Pokemon next2 = min.getNextPokemon();
				Pokemon previous2 = min.getPrevPokemon();
				
				if(min == current.getNextPokemon()	) {
					if(previous1 != null) previous1.setNextPokemon(min);
					else {
						team = min;
						firstIt = true;
					}
					current.setNextPokemon(next2);
					current.setPrevPokemon(min);
					if(next2 != null) next2.setPrevPokemon(current);
					min.setNextPokemon(current);
					min.setPrevPokemon(previous1);
				} else {
					if(next1 != null) next1.setPrevPokemon(min);
					if(previous1 != null) previous1.setNextPokemon(min);
					else {
						team = min;
						firstIt = true;
					}
					
					min.setNextPokemon(next1);
					min.setPrevPokemon(previous1);
					
					if(next2 != null) next2.setPrevPokemon(current);
					if(previous2 != null) previous2.setNextPokemon(current);
					
					current.setNextPokemon(next2);
					current.setPrevPokemon(previous2);
				}
				current = min;
			}	
			if(firstIt) {
				current = team.getNextPokemon();
			} else {
				current = current.getNextPokemon();
			}
		}
	}
	/*This method allow to organize a pokemon with selection ordering
	  according to baseAtack of pokemons 
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return void
	 * @post: The linkedlist was organized
	 */
	
	public void selectionByAtackBasic() {
		Pokemon current = team;
		while(current != null) {
			Pokemon temp = current.getNextPokemon();
			Pokemon min = current;
			while(temp != null) {
				if(temp.getBasicAtack()<= min.getBasicAtack()) {
					min = temp;
				}
				temp = temp.getNextPokemon();
			}
			boolean firstIt = false;
			if(min != current) {
				Pokemon next1 = current.getNextPokemon();
				Pokemon previous1 = current.getPrevPokemon();
				
				Pokemon next2 = min.getNextPokemon();
				Pokemon previous2 = min.getPrevPokemon();
				
				if(min == current.getNextPokemon()	) {
					if(previous1 != null) previous1.setNextPokemon(min);
					else {
						team = min;
						firstIt = true;
					}
					current.setNextPokemon(next2);
					current.setPrevPokemon(min);
					if(next2 != null) next2.setPrevPokemon(current);
					min.setNextPokemon(current);
					min.setPrevPokemon(previous1);
				} else {
					if(next1 != null) next1.setPrevPokemon(min);
					if(previous1 != null) previous1.setNextPokemon(min);
					else {
						team = min;
						firstIt = true;
					}
					
					min.setNextPokemon(next1);
					min.setPrevPokemon(previous1);
					
					if(next2 != null) next2.setPrevPokemon(current);
					if(previous2 != null) previous2.setNextPokemon(current);
					
					current.setNextPokemon(next2);
					current.setPrevPokemon(previous2);
				}
				current = min;
			}	
			if(firstIt) {
				current = team.getNextPokemon();
			} else {
				current = current.getNextPokemon();
			}
		}
	}
	
	/*This method allow to organize a pokemon with selection ordering
	  according to specialAtack of pokemons 
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return void
	 * @post: The linkedlist was organized
	 */
	
	public void selectionByAtackEspecial() {
		Pokemon current = team;
		while(current != null) {
			Pokemon temp = current.getNextPokemon();
			Pokemon min = current;
			while(temp != null) {
				if(temp.getEspecialAtack()<= min.getEspecialAtack()) {
					min = temp;
				}
				temp = temp.getNextPokemon();
			}
			boolean firstIt = false;
			if(min != current) {
				Pokemon next1 = current.getNextPokemon();
				Pokemon previous1 = current.getPrevPokemon();
				
				Pokemon next2 = min.getNextPokemon();
				Pokemon previous2 = min.getPrevPokemon();
				
				if(min == current.getNextPokemon()	) {
					if(previous1 != null) previous1.setNextPokemon(min);
					else {
						team = min;
						firstIt = true;
					}
					current.setNextPokemon(next2);
					current.setPrevPokemon(min);
					if(next2 != null) next2.setPrevPokemon(current);
					min.setNextPokemon(current);
					min.setPrevPokemon(previous1);
				} else {
					if(next1 != null) next1.setPrevPokemon(min);
					if(previous1 != null) previous1.setNextPokemon(min);
					else {
						team = min;
						firstIt = true;
					}
					
					min.setNextPokemon(next1);
					min.setPrevPokemon(previous1);
					
					if(next2 != null) next2.setPrevPokemon(current);
					if(previous2 != null) previous2.setNextPokemon(current);
					
					current.setNextPokemon(next2);
					current.setPrevPokemon(previous2);
				}
				current = min;
			}	
			if(firstIt) {
				current = team.getNextPokemon();
			} else {
				current = current.getNextPokemon();
			}
		}
	}
	
	/*This method allow to organize a pokemon with insertion ordering
	  according to baseDefense of pokemons 
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return void
	 * @post: The linkedlist was organized
	 */
	
	public void insertionByDefenseBasic() {
		if(team.getNextPokemon() != null) {
			Pokemon current = team.getNextPokemon();
			while(current != null) {
				Pokemon temp = current;
				while(temp.getPrevPokemon() != null) {					
					if(temp.getBasicDefense() < temp.getPrevPokemon().getBasicDefense()) {
						if(temp.getPrevPokemon() == team) team = temp;
						Pokemon next = temp.getNextPokemon();
						Pokemon prev = temp.getPrevPokemon().getPrevPokemon();
						if(next != null) next.setPrevPokemon(temp.getPrevPokemon());
						if(prev != null) prev.setNextPokemon(temp);
						temp.setNextPokemon(temp.getPrevPokemon());
						temp.getPrevPokemon().setPrevPokemon(temp);
						temp.getPrevPokemon().setNextPokemon(next);
						temp.setPrevPokemon(prev);
					} else {
						temp = temp.getPrevPokemon();
					}
				}
				current = current.getNextPokemon();
			}
		}
		
	}
	
	/*This method allow to organize a pokemon with insertion ordering
	  according to especialDefense of pokemons 
	 * @pre: team == null || team != null
	 * @param: empty
	 * @return: This method return void
	 * @post: The linkedlist was organized
	 */
	public void insertionByDefenseEspecial() {
		if(team.getNextPokemon() != null) {
			Pokemon current = team.getNextPokemon();
			while(current != null) {
				Pokemon temp = current;
				while(temp.getPrevPokemon() != null) {					
					if(temp.getEspecialDefense() < temp.getPrevPokemon().getEspecialDefense()) {
						if(temp.getPrevPokemon() == team) team = temp;
						Pokemon next = temp.getNextPokemon();
						Pokemon prev = temp.getPrevPokemon().getPrevPokemon();
						if(next != null) next.setPrevPokemon(temp.getPrevPokemon());
						if(prev != null) prev.setNextPokemon(temp);
						temp.setNextPokemon(temp.getPrevPokemon());
						temp.getPrevPokemon().setPrevPokemon(temp);
						temp.getPrevPokemon().setNextPokemon(next);
						temp.setPrevPokemon(prev);
					} else {
						temp = temp.getPrevPokemon();
					}
				}
				current = current.getNextPokemon();
			}
		}
		
	}
	/*This method allow to search a pokemon in a Team
	 * @pre: team == null || team != null
	 * @param: String n
	 * @return: This method return Pokemon
	 * @post: Pokemon founded
	 */
	
	
	public Pokemon searchPokemonInTeam(String n) {
		Pokemon aux=team;
		Pokemon found=aux;
		while (aux!=null) {
			if (aux.getName().equals(n)) {
				found=aux;
				aux=null;
			}else {
			
			aux=aux.getNextPokemon();
			}
		}
		return found;
	}
	
	
	

}

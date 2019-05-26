package customeExceptions;

@SuppressWarnings("serial")
public class IncompleteTeamException extends Exception{
	
	int teamSize;
	
	public IncompleteTeamException(int teamSize) {
		super("The size of the team"+teamSize+" is incomplete you need"+(6-teamSize)+"more pokemons");
		this.teamSize=teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}
}

package customeExceptions;

@SuppressWarnings("serial")
public class BigTeamException extends Exception{
	
	
	public BigTeamException() {
		super("The size of the team is 6 not more");
	}


}

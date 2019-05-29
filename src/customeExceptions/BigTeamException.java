package customeExceptions;

@SuppressWarnings("serial")
public class BigTeamException extends Exception{
	
	/*This is a constructor method of BigTeamException
	 * 
	 */
	public BigTeamException() {
		super("The size of the team is 6 not more");
	}


}

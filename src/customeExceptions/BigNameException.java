package customeExceptions;

@SuppressWarnings("serial")
public class BigNameException extends Exception{

	int name;
	
	/*This is a constructor method of BigNameException
	 * 
	 */
	public BigNameException(int name) {
		super("The name inserted is to long to saved: "+name+" characters is a lot");
		this.name=name;
	}
	
	/*This method get a name of BigNameException
	 * @pre: empty
	 * @param: empty
	 * @return: This method return int
	 * @post: got Name of BigNameException
	 */

	public int getName() {
		return name;
	}	
}

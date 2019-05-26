package customeExceptions;

@SuppressWarnings("serial")
public class BigNameException extends Exception{

	int name;
	
	public BigNameException(int name) {
		super("The name inserted is to long to saved: "+name+" characters is a lot");
		this.name=name;
	}

	public int getName() {
		return name;
	}	
}

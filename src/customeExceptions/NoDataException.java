package customeExceptions;

import javafx.scene.image.Image;

@SuppressWarnings("serial")
public class NoDataException extends Exception{

	String nameUser;
	Image profilePic;
	
	public NoDataException(String nameUser, Image profilePic) {
		super("the data inserted is wrong null is not a valid data");
		this.nameUser=nameUser;
		this.profilePic=profilePic;
	}

	public String getNameUser() {
		return nameUser;
	}

	public Image getProfilePic() {
		return profilePic;
	}
		
}

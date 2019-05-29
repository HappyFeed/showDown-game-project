package customeExceptions;

import javafx.scene.image.Image;

@SuppressWarnings("serial")
public class NoDataException extends Exception{

	String nameUser;
	Image profilePic;
	
	/*This is a constructor method of NoDataException
	 * 
	 */
	
	public NoDataException(String nameUser, Image profilePic) {
		super("the data inserted is wrong null is not a valid data");
		this.nameUser=nameUser;
		this.profilePic=profilePic;
	}
	
	/*This method get a nameUser of NoDataException
	 * @pre: empty
	 * @param: empty
	 * @return: This method return String
	 * @post: got nameUser of NoDataException
	 */

	public String getNameUser() {
		return nameUser;
	}
	
	/*This method get a profileUser of NoDataException
	 * @pre: empty
	 * @param: empty
	 * @return: This method return Image
	 * @post: got profileUser of NoDataException
	 */

	public Image getProfilePic() {
		return profilePic;
	}
		
}

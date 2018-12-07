/**
 * AccountBaseUser.java
 * - no copyright
 * - creation date: 17/11/2018
 * - last modified: 17/11/2018
 * @author Christian Onishile
 * @version 1.0.0
 * @since 17/11/2018
 */

/**
 * The AccountBaseUser abstract class is used to store attributes and abstract methods used within both of 
 * its subclasses: User and Librarian. 
 */

public abstract class AccountBaseUser {
	//Instance Variables:
	public String username;				//user name of the user or librarian's account.
	public String firstName;			//first name of the user or librarian.
	public String lastName;				//last name of the user or librarian.
	public int telephone;				//telephone number of the user or librarian.
	public String address;				//address of the user or librarian.
	public String profileImagePath;		//image path of the account's profile picture.
	
	/**
	 * Method to get the account's user name.
	 * @return The current account's user name.
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Method to get the account's first name.
	 * @return The current account's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Method to set the account's first name.
	 * @param newFirstName The new first name of the current account.
	 */
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}
	
	/**
	 * Method to get the account's last name.
	 * @return The current account's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Method to set the account's last name.
	 * @param newLastName The new last name of the current account.
	 */
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	/**
	 * Method to get the account's telephone number.
	 * @return The current account's telephone number.
	 */
	public int getTelephone() {
		return telephone;
	}
	
	/**
	 * Method to set the account's telephone number.
	 * @param newTelephone The current account's new telephone number.
	 */
	public void setTelephone(int newTelephone) {
		telephone = newTelephone;
	}
	
	/**
	 * Method to get the account's address.
	 * @return The current account's address.
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Method to set the account's address.
	 * @param newAddress The current account's new address.
	 */
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	
	/**
	 * Abstract method to choose the account's profile image.
	 * @return The current account's profile image (as type string).
	 */
	public abstract String chooseProfileImage();
	
	/**
	 * Abstract method to set the account's profile image.
	 * @param profileImagePath The current account's new profile image.
	 */
	public abstract void setProfileImage(String profileImagePath);
	
	/**
	 * Abstract method to draw the account's profile image.
	 */
	public abstract void drawProfileImage();
	
	/**
	 * Abstract method to get the account's profile image path.
	 * @return The current account's profile image path.
	 */
	public abstract String getProfileImagePath();
	
}

package backend;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.persistence.*;

/**
 * AccountBaseUser.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author Christian Onishile
 * @version 1.5
 * @since 07/12/2018
 */

/**
 * The AccountBaseUser abstract class is used to store attributes and abstract methods used within both of
 * its subclasses: User and Librarian.
 */
@Entity //Defining the class as a persistent entity allowing the hibernate API to interact with it
@Inheritance(strategy=InheritanceType.JOINED)//Defining which method of mapping inheritance is going to be used with the subclasses
public abstract class AccountBaseUser {
	//Instance Variables:
	@Id  //specifying which variable is the primary key
	@Column(unique=true) // This is specifying that the following attribute has to be unique, if not the program throws an exception 
	public String username;				//user name of the user or librarian's account.
	public String firstName;			//first name of the user or librarian.
	public String lastName;				//last name of the user or librarian.
	public int telephone;				//telephone number of the user or librarian.
	public String address;				//address of the user or librarian.
	public String profileImagePath;		//image path of the account's profile picture.
	
	/**
	 * Method to get the account's first name.
	 * @return The current account's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method to set the account's first name.
	 * @param firstName The new first name of the current account.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * @param lastName The new last name of the current account.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @param telephone The current account's new telephone number.
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	/**
	 * Method to get the account's user name.
	 * @return The current account's user name.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Method to get the account's address.
	 * @return The current account's address.
	 */
	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }

	/**
	 * Abstract method to set the account's profile image.
	 * @param profileImagePath The current account's new profile image.
	 */
	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	/**
	 * Method to call a GUI used draw the account's profile image.
	 */
	public void drawProfileImage() {
		// code to run when user draws a new profile image and save the new image within database.
		int width = 150;	//width of the user's profile image.
		int height = 150;	//height of the user's profile image.
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2d = image.createGraphics();
		
		/**
		 * Use event handling to call methods that:
		 * -Color the background (white, orange, red, blue, green, purple, and black
		 * -Color the lines being drawn
		 * -draw the lines 
		 * 
		 * 
		 * Use the set profile image method to change the name of the image.
		 */
	}
}
package backend;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.persistence.*;

/**
 * AccountBaseUser.java
 * This abstract class is used to store attributes and abstract methods used within both of 
 * its subclasses: User and Librarian. 
 * - Last Modified: 17/11/2018
 * - no copyright
 * - No Previous Versions
 * @version 1.0.0
 * @since 17/11/2018
 * @author Christian Onishile
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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return username;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public void drawProfileImage() {
		// code to run when user draws a new profile image and save the new image within database.
		int width = 150;
		int height = 150;
		
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
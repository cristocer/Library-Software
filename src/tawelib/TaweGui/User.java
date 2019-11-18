/**
 * User.java
 * - no copyright
 * - creation date 18/11/2018
 * - last modified 22/11/2018
 * @author 
 * @version 1.0
 * @since 22/11/2018
 */
package tawelib.TaweGui;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * User is a subclass of AccountBaseUser used to provide unique methods and
 * attributes to the user account.
 */

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="id")//Defining that this entity's primary key is imported from another class, Resources
public class User extends AccountBaseUser {
	//Instance variables:
	private double balance;				//Account balance
	//public Object[] requestedItems; //Is this supposed to be here?????? //Array of account requested items
	
	
	//Object is of type Copy.
	
	/**
     * Creates a user account.
     * @param username The username given to the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param telephone The telephone number of the user.
     * @param address The home address of the user.
     * @param profileImagePath The file path to the profile image of the user's account.
     * @param requestedItems An array of all the items requested by the user.
     * @param balance The account balance in pounds.
     */
	public User() {}
	public User(int id,String username, String firstName, String lastName, int telephone, String address, 
			String profileImagePath,double balance,String password) {	//Object is of type Copy.//add Object[] requestedItems,
		this.id = id;
		this.username=username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.profileImagePath = profileImagePath;
		//this.requestedItems = requestedItems;
		this.balance = balance;
		this.password=password;
	}

	/**
	 * Method to choose the librarian's profile image.
	 * @return null.
	 */
	@Override
	public String chooseProfileImage() {
		// have multiple choices of 
		// either choose an existing image or draw a new image and set the image path.
		return null;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * Method to set the librarian's profile image.
	 * @param newProfileImagePath The file path of the new profile image.
	 */
	@Override
	public void setProfileImage(String newProfileImagePath) {
		profileImagePath = newProfileImagePath;
	}

	/**
	 * Method draw the librarian's profile image.
	 */
	@Override
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

	/**
	 * Method to get the librarian's profile image file path.
	 * @return The profile image file path.
	 */
	@Override
	public String getProfileImagePath() {
		return profileImagePath;
	}

	/**
	 * Abstract method to set the account's profile image.
	 * @return The current account's .
	 */
	public Object[] getLoans() {	//Object is of type Copy.
		//implement after database
		return null;
	}

	
	/**
	 * Method to change the account balance.
	 * @param newBalance New balance after adding money or paying a loan.
	 */
	public void setBalance(int newBalance) {
		balance = newBalance;
	}

	/**
	 * Method to .
	 * @param user .
	 */
	public void payFines(User user) {
		//needs authority from librarian.
	}

}

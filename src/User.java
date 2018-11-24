import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class User extends AccountBaseUser {
	//Instance variables:
	public int balance;
	public Object[] requestedItems; //Is this supposed to be here??????
	//Object is of type Copy.
	
	public User(String username, String firstName, String lastName, int telephone, String address, 
			String profileImagePath, Object[] requestedItems, int balance) {	//Object is of type Copy.
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.profileImagePath = profileImagePath;
		this.requestedItems = requestedItems;
		this.balance = balance;
	}

	@Override
	public String chooseProfileImage() {
		// have multiple choices of 
		// either choose an existing image or draw a new image and set the image path.
		return null;
	}

	@Override
	public void setProfileImage(String newProfileImagePath) {
		profileImagePath = newProfileImagePath;
	}

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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int newBalance) {
		balance = newBalance;
	}

	public void payFines(User user) {
		//needs authority from librarian.
	}

}

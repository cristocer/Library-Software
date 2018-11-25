/**
 * Librarian.java
 * - no copyright
 * - creation date 18/11/2018
 * - last modified 22/11/2018
 * @author 
 * @version 1.0
 * @since 22/11/2018
 */

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Librarian is a subclass of AccountBaseUser used to provide unique methods and
 * attributes to the librarian account.
 */

public class Librarian extends AccountBaseUser {
	//Instance variables:
	public String employmentDate;	//employment date of the librarian
	public int staffID;				//staff ID of the librarian
	
	/**
     * Creates a librarian account.
     * @param username The username given to the employee.
     * @param firstname The first name of the employee.
     * @param lastname The last name of the employee.
     * @param telephone The telephone number of the employee.
     * @param address The home address of the employee.
     * @param profileImagePath The file path to the profile image of the employee's account.
     * @param employmentDate The date the librarian was first employed.
     * @param staffID The ID given to the employee.
     */
	public Librarian(String username, String firstName, String lastName, int telephone, String address, 
			String profileImagePath, String employmentDate, int staffID) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.profileImagePath = profileImagePath;
		this.employmentDate = employmentDate;
		this.staffID = staffID;
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
	 * Method to get the librarian's employment date.
	 * @return The employee's date of employment.
	 */
	public String getEmploymentDate() {
		return employmentDate;
	}
	
	/**
	 * Method to get the librarian's staff ID.
	 * @return The librarian's staff ID.
	 */
	public int getStaffID() {
		return staffID;
	}
	
	/**
	 * Method to get the resource history.
	 * @param copy .
	 * @return null .
	 */
	public String[] getHistory(Object copy) {	//Object is of type Copy.
		return null;
	}
	
	/**
	 * Method to get the overdue resources.
	 * @param copy .
	 * @return null .
	 */
	public String[] getOverdue(Object copy) {	//Object is of type Copy.
		//code.
		return null;
	}

}

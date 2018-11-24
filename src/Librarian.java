import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Librarian extends AccountBaseUser {
	//Instance variables:
	public String employmentDate;
	public int staffID;
	
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
	
	@Override 
	public String getUsername() {
		return username;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	@Override
	public int getTelephone() {
		return telephone;
	}

	@Override
	public void setTelephone(int newTelephone) {
		telephone = newTelephone;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String newAddress) {
		address = newAddress;
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
	
	public String getEmploymentDate() {
		return employmentDate;
	}
	
	public int getStaffID() {
		return staffID;
	}
	
	public String[] getHistory(Object copy) {	//Object is of type Copy.
		return null;
	}
	
	public String[] getOverdue(Object copy) {	//Object is of type Copy.
		//code.
		return null;
	}

}

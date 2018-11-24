package com.tawelib.Lib_Tawe;
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

@Entity
@Table(name="AccountBaseUser")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("AccountBaseUser")
public abstract class AccountBaseUser {
	//Instance Variables:
	@Id
	public String username;				//user name of the user or librarian's account.
	public String firstName;			//first name of the user or librarian.
	public String lastName;				//last name of the user or librarian.
	public int telephone;				//telephone number of the user or librarian.
	public String address;				//address of the user or librarian.
	public String profileImagePath;		//image path of the account's profile picture.
	
	/**
	 * Abstract method to get the account's user name.
	 * @return The current account's user name.
	 */
	public abstract String getUsername();
	
	/**
	 * Abstract method to get the account's first name.
	 * @return The current account's first name.
	 */
	public abstract String getFirstName();
	
	/**
	 * Abstract method to set the account's first name.
	 * @param newFirstName The new first name of the current account.
	 */
	public abstract void setFirstName(String newFirstName);
	
	/**
	 * Abstract method to get the account's last name.
	 * @return The current account's last name.
	 */
	public abstract String getLastName();
	
	/**
	 * Abstract method to set the account's last name.
	 * @param newLastName The new last name of the current account.
	 */
	public abstract void setLastName(String newLastName);
	
	/**
	 * Abstract method to get the account's telephone number.
	 * @return The current account's telephone number.
	 */
	public abstract int getTelephone();
	
	/**
	 * Abstract method to set the account's telephone number.
	 * @param newTelephone The current account's new telephone number.
	 */
	public abstract void setTelephone(int newTelephone);
	
	/**
	 * Abstract method to get the account's address.
	 * @return The current account's address.
	 */
	public abstract String getAddress();
	
	/**
	 * Abstract method to set the account's address.
	 * @param newAddress The current account's new address.
	 */
	public abstract void setAddress(String newAddress);
	
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

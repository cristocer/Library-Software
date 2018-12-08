package backend;
import javax.persistence.*;

/**
 * User.java
 * - GNU General Public License 2007
 * - creation date 18/11/2018
 * - last modified 07/12/2018
 * @author 
 * @version 1.5
 * @since 07/12/2018
 */

/**
 * User is a subclass of AccountBaseUser used to provide unique methods and
 * attributes to the user account.
 */

@Entity //Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="username")//Defining that this entity's primary key is imported from another class, Resources
public class User extends AccountBaseUser {
	
	//Instance variables:
	public int balance;		//Account balance
	
	/**
	 * Initial constructor for User.
	 */
	public User() {} //Default constructor for database stuff
	
	/**
	 * Creates a user account.
	 * @param balance The account balance in pounds.
	 * @param username The username given to the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
	 * @param telephone The telephone number of the user.
     * @param address The home address of the user.
     * @param profileImagePath The file path to the profile image of the user's account.
	 */
	public User( int balance, String username, String firstName, String lastName, int telephone, String address, 
			String profileImagePath) {	
		this.balance = balance;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.profileImagePath = profileImagePath;
	}
	
	/**
	 * Method to get the user's account balance.
	 * @return The user's balance.
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Method to change the account balance.
	 * @param newBalance New balance after adding money or paying a loan.
	 */
	public void setBalance(int newBalance) {
		balance = newBalance;
	}
	
	//Needs permissions system
	//public void payFines(User user) {
		//needs authority from librarian.
	//}
	
	//Needs transaction table
	//public Copies[] getLoans(User user) {	
	//}
	
}

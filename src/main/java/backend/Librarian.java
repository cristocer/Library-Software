package backend;
import javax.persistence.*;

/**
 * Librarian.java
 * - no copyright
 * - creation date 18/11/2018
 * - last modified 07/12/2018
 * @author Christian Onishile
 * @version 1.5
 * @since 07/12/2018
 */

/**
 * Librarian is a subclass of AccountBaseUser used to provide unique methods and
 * attributes to the librarian account.
 */

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="username")//Defining that this entity's primary key is imported from another class, Resources
public class Librarian extends AccountBaseUser {
	
	//Instance variables:
	public String employmentDate;	//employment date of the librarian
	
	//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
	//@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="seq")
	public int staffID;		//staff ID of the librarian
	
	/**
	 * Initial constructor for Librarian.
	 */
	public Librarian() {} //Default constructor for database stuff
	
	/**
	 * Creates a librarian account.
	 * @param employmentDate The date the librarian was first employed.
	 * @param username The username given to the employee.
	 * @param firstName The first name of the employee.
	 * @param lastName The last name of the employee.
	 * @param telephone The telephone number of the employee.
     * @param address The home address of the employee.
     * @param profileImagePath The file path to the profile image of the employee's account.
	 */
	public Librarian(String employmentDate, String username, String firstName, 
			String lastName, int telephone, String address, String profileImagePath) {
		
		this.employmentDate = employmentDate;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.profileImagePath = profileImagePath;
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
	
	//Needs transaction table
	//public String[] getHistory(Object copy) {	//Object is of type Copy.
	//	return null;
	//}
	
	//Needs transaction table
	//public String[] getOverdue(Object copy) {	//Object is of type Copy.
		//code.
	//	return null;
	//}

}

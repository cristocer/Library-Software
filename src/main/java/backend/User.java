package backend;
import javax.persistence.*;

@Entity //Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="username")//Defining that this entity's primary key is imported from another class, Resources
public class User extends AccountBaseUser {
	
	//Instance variables:
	public int balance;
	
	public User() {} //Default constructor for database stuff
	
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
	
	public int getBalance() {
		return balance;
	}
	
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

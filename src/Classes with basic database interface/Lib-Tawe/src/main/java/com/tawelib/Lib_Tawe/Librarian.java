package com.tawelib.Lib_Tawe;
import javax.persistence.*;

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@PrimaryKeyJoinColumn(name="username")//Defining that this entity's primary key is imported from another class, Resources
public class Librarian extends AccountBaseUser {
	
	//Instance variables:
	@GeneratedValue(strategy = GenerationType.IDENTITY) // specifying the type of auto-incrementation for the PK, in this case "IDENTITY" uses identifies and uses the type specified in the linked table
	public String employmentDate;
	public int staffID;
	
	public Librarian(String employmentDate, int staffID, String username, String firstName, 
			String lastName, int telephone, String address, String profileImagePath) {
		
		this.employmentDate = employmentDate;
		this.staffID = staffID;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.profileImagePath = profileImagePath;
	}
		
	public String getEmploymentDate() {
		return employmentDate;
	}
	
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

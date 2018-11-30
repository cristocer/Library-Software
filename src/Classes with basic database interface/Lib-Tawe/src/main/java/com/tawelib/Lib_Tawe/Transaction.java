package com.tawelib.Lib_Tawe;
import java.util.List;

import javax.persistence.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@Table(name = "Transaction")
public class Transaction {
	
	@Id//specifying which variable is the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)// specifying the type of auto-incrementation for the PK, in this cas "IDENTITY" uses identifies and uses the type specified in the linked table
	public int transactionUID;

	@JoinColumn(name="username")//Defining that resourceUID is a foreign key 
	public String username;
	
    @JoinColumn(name="staffUID")//Defining that resourceUID is a foreign key 
	public int staffUID;
	 
    @JoinColumn(name="copyUID")//Defining that resourceUID is a foreign key 
    public int copyUID;
	
	public String dueDate;
	
	public String issueDate;
	
	public String returnDate;
	
	public Transaction () {}
	
	public void returnCopy(int copyUID) {
		
		//Check to see if copy is in the transaction table 
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();		
		
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		for(Transaction emp : empList){
			if (emp.getCopyUID() == copyUID){         //check to see if the copy ID is present 		
				query = session.createQuery("update Transaction set returnDate= :returned where copyUID= :id");
				query.setParameter("returnDate", "today");                         //Change the retrun date on the copy to today then 
				query.setLong("copyUID", copyUID);
			}
		}
	}
	
	public void requestCopy(String title) {
		
		
		
	}
	
	public void collectCopy() {
		
		
	}
	
	public void houseKeeping() {
		
		
	}

	
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDueDate() {
		return dueDate;
	}
	
	public int getCopyUID() {
		return copyUID;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
}

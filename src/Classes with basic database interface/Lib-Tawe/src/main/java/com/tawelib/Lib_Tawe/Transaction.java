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
	public String username;
	public int staffID;
    @JoinColumn(name="copyUID")
    public int copyUID;
	public String dueDate;
	public String issueDate;
	public String returnDate;
	
	public Transaction() {}
	
	public Transaction (String username, int staffID, int copyUID, String dueDate, String issueDate, String returnDate) {
		this.username = username;
		this.staffID = staffID;
		this.copyUID = copyUID;
		this.dueDate = dueDate;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	
	public static void returnCopy(int copyUID) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  //
		Session session = sessionFactory.getCurrentSession();				//Start and setup session factory 
		org.hibernate.Transaction tx = session.beginTransaction();          //
		
		Query query = session.createQuery("From Transaction"); //query transaction table and return all Transaction objects from the table
		List<Transaction> empList = query.list();	           //return the objects into a list
		for(Transaction emp : empList){
			if (emp.getCopyUID() == copyUID){         //if this current Transaction object uses the same copyUID as specified
				query = session.createQuery("update Transaction set dueDate= :dueDate, issueDate= :issueDate, "
						+ "returnDate= :returnDate where transactionUID= :id");
				query.setParameter("dueDate", null); 				//
				query.setParameter("issueDate", null);              //Change the necessary parameters
				query.setParameter("returnDate", "today");     		//
				query.setLong("id", emp.getTransactionUID());	
				
				int result = query.executeUpdate();                //execute update
				System.out.println("Transaction Update Status= "+result);  //print to terminal if it worked
				tx.commit();		//commit changes
			}
		}	
		sessionFactory.close();     //end session
	}
	
	public static void requestCopy(int copyUID) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		for(Transaction emp : empList){
			if (emp.getCopyUID() == copyUID){         //if this current Transaction object uses the same copyUID as specified
				if (emp.getDueDate() == null && emp.getReturnDate() == null) { //if resource is out (dueDate = null) and hasnt been returned (returnDate = null)
					query = session.createQuery("update Transaction set dueDate= :dueDate, issueDate= :issueDate, returnDate= :returnDate where transactionUID= :id");
					query.setParameter("dueDate", "5 days"); 
					int result = query.executeUpdate();
					System.out.println("Transaction Update Status= "+result);
					
				}else if(emp.getReturnDate() != null ) { //if the resource is not out 
					
					
					//make new transaction??????????????????
					
				}	
				tx.commit();		
			}
		}	
		sessionFactory.close();
	}
		
	
	public static void collectCopy(int copyUID) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();		
		
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		for(Transaction emp : empList){
			if (emp.getCopyUID() == copyUID){ //check to see if the copy ID is present 	
				query = session.createQuery("update Transaction set dueDate= :dueDate, issueDate= :issueDate, returnDate= :returnDate where transactionUID= :id");
				query.setParameter("dueDate", null); 
				query.setParameter("issueDate", "today"); 
				query.setParameter("returnDate", null);         
				query.setLong("copyUID", copyUID);		
			}
		}
		
		
		//make new transaction????????????
		
	}
	
	public void houseKeeping() {	
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();		
		
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		for(Transaction emp : empList){
			
			//REEEEEEEEEEEEEEEEEE
		}
	}
	
	public static void addCopyToTransaction(Copies copy) {
		
		
		
		
		
	}
	
	
	
	

	public int getTransactionUID() {
		return transactionUID;
	}
	
	public int getStaffID() {
		return staffID;
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

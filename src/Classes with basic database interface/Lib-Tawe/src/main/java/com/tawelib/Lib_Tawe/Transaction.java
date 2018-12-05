package com.tawelib.Lib_Tawe;
import java.util.Date;
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
	
	public static void returnCopy(int copyUID, String username) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();				//Start and setup session factory 
		Query query = session.createQuery("From Transaction"); //query transaction table and return all Transaction objects from the table
		List<Transaction> empList = query.list();	           //return the objects into a list
		session.close();
		
		Date currentDateTime = new Date();
		String currentTime = String.valueOf(currentDateTime.getTime());
		
		for(Transaction emp : empList){
			if (emp.getCopyUID() == copyUID && emp.getReturnDate() == null && emp.getUsername().equals(username)){         //if this current Transaction object uses the same copyUID as specified
				Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
				session2.beginTransaction();
				query = session2.createQuery("update Transaction set returnDate= :returnDate where copyUID= :id");
				query.setParameter("returnDate", currentTime);     		//set return date
				query.setLong("id", emp.getTransactionUID());	
				int result = query.executeUpdate();                //execute update
				System.out.println("[Transaction Update] Status = "+result + " copy" +emp.getCopyUID()+" returned");  //print to terminal if it worked
				session2.getTransaction().commit();		//commit changes
				
				
				//CHECK AND ISSUING FINES
				
				Long dueDateLong = Long.parseLong(emp.getDueDate(), 10);
				
				if(dueDateLong < currentDateTime.getTime()) {
					
					System.out.println("here");
					
					Session session3 = HibernateUtil.getSessionFactory().getCurrentSession();
					session3.beginTransaction();
					Query query2 = session3.createQuery("From User"); //query user table and return all user objects from the table
					List<User> empList2 = query2.list();	           //return the objects into a list
					session3.close();
					
					for(User emp2 : empList2){
						if(emp2.getUsername().equals(username)) {
							
							int fineApplied= emp2.getBalance() - 5;
							
							Session session4 = HibernateUtil.getSessionFactory().getCurrentSession();
							session4.beginTransaction();
							query = session4.createQuery("update User set balance= :fine where username= :username");
							query.setParameter("fine", fineApplied);     		//set return date
							query.setParameter("username", username);	
							int result2 = query.executeUpdate();       //execute update
							System.out.println("[User balance update] Status = "+result2 + " user: " +username+" fined");  //print to terminal if it worked
							session4.getTransaction().commit();		//commit changes
							
						}
						
					}
					
				}
				
			}
		}		
	}
	
	
	
	public static void requestCopy(int copyUID, String username, int staffID) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		session.close();
		
		Date twoDaysTime = new Date();
		String twoDays = String.valueOf(twoDaysTime.getTime()+172800);
		
		for(Transaction emp : empList){
			if (emp.getCopyUID() == copyUID){         //if this current Transaction object uses the same copyUID as specified
				if (emp.getDueDate() == null && emp.getReturnDate() == null && !emp.getUsername().equals(username)) { //if resource is out (dueDate = null) and hasnt been returned (returnDate = null)
					
					Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
					session2.beginTransaction();
					query = session2.createQuery("update Transaction set dueDate= :dueDate where copyUID= :id");
				    query.setParameter("dueDate", twoDays); 
				    query.setLong("id", copyUID);
					int result = query.executeUpdate();
					System.out.println("[Transaction Update] Status = "+result + " copy requested");
					session2.getTransaction().commit();
					
					Transaction newTransaction = new Transaction();
					newTransaction.setCopyUID(copyUID);
					newTransaction.setUsername(username);
					newTransaction.setStaffID(staffID);
					newTransaction.setDueDate(null);
					newTransaction.setIssueDate(null);
					newTransaction.setReturnDate(null);
					
					Session session3 = HibernateUtil.getSessionFactory().getCurrentSession();
					session3.beginTransaction();
					session3.save(newTransaction);
					session3.getTransaction().commit();
					
				}else if(emp.getReturnDate() != null && emp.getIssueDate() != null && !emp.getUsername().equals(username)) { //if the resource is not out make a new transaction and push that shit
					
					Transaction newTransaction = new Transaction();
					newTransaction.setCopyUID(copyUID);
					newTransaction.setUsername(username);
					newTransaction.setStaffID(staffID);
					newTransaction.setDueDate(null);
					newTransaction.setIssueDate(null);
					newTransaction.setReturnDate(null);
					
					Session session4 = HibernateUtil.getSessionFactory().getCurrentSession();
					session4.beginTransaction();
					session4.save(newTransaction);
					session4.getTransaction().commit();
				}	
					
			}
		}	
	}
		
	
	public static void collectCopy(int copyUID, String username) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		session.close();
		
		Date currentDateTime = new Date();
		String currentTime = String.valueOf(currentDateTime.getTime());
		
		for(Transaction emp : empList){
			if (emp.getCopyUID() == copyUID){ //act on where the copyUID matches
				if (emp.getDueDate() == null && emp.getIssueDate() == null &&  emp.getReturnDate() == null && emp.getUsername().equals(username)) {
					
					Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
					session2.beginTransaction();
					query = session2.createQuery("update Transaction set issueDate= :issueDate where copyUID= :id");
					query.setParameter("issueDate", currentTime);        
					query.setLong("id", copyUID);	
					int result = query.executeUpdate();
					System.out.println("[Transaction Update] Status = "+result + " copy collected");
					session2.getTransaction().commit();
				}
			}
		}
	}
	
	
	public void updateTransaction() {
		//Adding new copies to transaction table	
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();
				Query query = session.createQuery("From Copies"); //return all Copies objects from the table
				List<Copies> empList = query.list();
				session.close();
				
				for(Copies emp : empList){
					if (Transaction.checkIfPresentInTransaction(emp)) {
						System.out.println("Copy "+ emp.getCopyUID()+ " already present in Transactions");		
					}else {
						Transaction.addCopyToTransaction(emp);
						System.out.println("Added copy "+ emp.getCopyUID()+ " to Transactions table");			
					}	
				}
				System.out.println(" ");
				System.out.println("[Transaction update] all copies not present in Transaction are now present in Transaction");
				System.out.println(" ");
				//Adding new copies to transaction table	
		
	}
	
	private static Boolean checkIfPresentInTransaction(Copies copy) {
		Boolean present = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		for(Transaction emp : empList){
			if (emp.getCopyUID() == copy.getCopyUID()) {
				present = true;
			}
		}
		session.close();
		return present;
	}
	
	public static void addCopyToTransaction(Copies copy) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();		
		session.beginTransaction();
		com.tawelib.Lib_Tawe.Transaction myTransaction = new com.tawelib.Lib_Tawe.Transaction();
		myTransaction.setCopyUID(copy.getCopyUID());
		session.save(myTransaction);
		session.getTransaction().commit();
		sessionFactory.close();
	}
	
	public static void houseKeeping() {	
		
		
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
	
	public void setCopyUID(int copyUID) {
		this.copyUID = copyUID;
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
	
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	
	
}

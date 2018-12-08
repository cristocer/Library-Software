package backend;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Request.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.1
 * @since 07/12/2018
 */

/**
 * The Request class is used to create requests for resource copies that have been
 * requested by users. Librarians can then issue a copy that has been requested.
 */

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it
@Table(name = "Request")
public class Request {

	@Id//specifying which variable is the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)// specifying the type of auto-incrementation for the PK, in this cas "IDENTITY" uses identifies and uses the type specified in the linked table
	public int transactionUID;		//The Unique identification number of the transaction.
	public String username;			//The username of the account requesting a resource copy.
	public int staffID;				//The staff ID of the librarian allowing the request.
	@JoinColumn(name="copyUID")
	public int copyUID;				//The unique ID of the copy being requested.
	public String dueDate;			//The date the resource copy is due to be returned.
	public String issueDate;		//The date the resource copy was issued.
	public String returnDate;		//The date the resource copy is returned.

	/**
	 * Initial constructor for Request.
	 */
	public Request() {}

	/**
	 * Creates a request for a resource copy.
	 * @param username The username of the user making the request.
	 * @param staffID The ID of the librarian issuing the copy.
	 * @param copyUID The unique ID of the copy.
	 * @param dueDate The date the copy is due to be returned.
	 * @param issueDate The date the copy was issued.
	 * @param returnDate The date the copy was returned.
	 */
	public Request (String username, int staffID, int copyUID, String dueDate, String issueDate, String returnDate) {
		this.username = username;
		this.staffID = staffID;
		this.copyUID = copyUID;
		this.dueDate = dueDate;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	/**
	 * Returns an on-loan copy that has been returned by a user.
	 * @param copyUID Unique ID of the copy that is being returned.
	 * @param username The username of the user returning an on-loan copy.
	 */
	public static void returnCopy(int copyUID, String username) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();				//Start and setup session factory
		Query query = session.createQuery("From Transaction"); //query transaction table and return all Transaction objects from the table
		List<Request> empList = query.list();	           //return the objects into a list
		session.close();

		Date currentDateTime = new Date();
		String currentTime = String.valueOf(currentDateTime.getTime());

		for(Request emp : empList){
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


	/**
	 * Requests a copy of a resource for a user, this request needs to verified and allowed by a librarian.
	 * @param copyUID The unique ID of the resource copy being requested.
	 * @param username The username of the user requesting a resource copy.
	 * @param staffID The staffID of the librarian allowing the request.
	 */
	public static void requestCopy(int copyUID, String username, int staffID) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Request> empList = query.list();
		session.close();

		Date twoDaysTime = new Date();
		String twoDays = String.valueOf(twoDaysTime.getTime()+172800);

		for(Request emp : empList){
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

					Request newTransaction = new Request();
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

					Request newTransaction = new Request();
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

	/**
	 * Used by a user to collect a requested resource copy.
	 * @param copyUID The unique ID of the resource copy being collected.
	 * @param username The username of the user collecting the resource copy.
	 */
	public static void collectCopy(int copyUID, String username) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Request> empList = query.list();
		session.close();

		Date currentDateTime = new Date();
		String currentTime = String.valueOf(currentDateTime.getTime());

		for(Request emp : empList){
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

	/**
	 * Updates a user's transaction history to add their most recent collected resource copy.
	 */
	public void updateTransaction() {
		//Adding new copies to transaction table
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Copies"); //return all Copies objects from the table
		List<Copies> empList = query.list();
		session.close();

		for(Copies emp : empList){
			if (Request.checkIfPresentInTransaction(emp)) {
				System.out.println("Copy "+ emp.getCopyUID()+ " already present in Transactions");
			}else {
				Request.addCopyToTransaction(emp);
				System.out.println("Added copy "+ emp.getCopyUID()+ " to Transactions table");
			}
		}
		System.out.println(" ");
		System.out.println("[Transaction update] all copies not present in Transaction are now present in Transaction");
		System.out.println(" ");
		//Adding new copies to transaction table

	}

	/**
	 * 
	 * @param copy
	 * @return
	 */
	private static Boolean checkIfPresentInTransaction(Copies copy) {
		Boolean present = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Request> empList = query.list();
		for(Request emp : empList){
			if (emp.getCopyUID() == copy.getCopyUID()) {
				present = true;
			}
		}
		session.close();
		return present;
	}

	/**
	 * 
	 * @param copy
	 */
	public static void addCopyToTransaction(Copies copy) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Request myTransaction = new Request();
		myTransaction.setCopyUID(copy.getCopyUID());
		session.save(myTransaction);
		session.getTransaction().commit();
		sessionFactory.close();
	}

	/**
	 * 
	 */
	public static void houseKeeping() {


	}

	/**
	 * Gets the transactions' unique identification number.
	 * @return The unique transaction identification number.
	 */
	public int getTransactionUID() {
		return transactionUID;
	}

	/**
	 * Gets the librarians unique staff ID.
	 * @return The librarians staff ID.
	 */
	public int getStaffID() {
		return staffID;
	}

	/**
	 * Gets the username of a user account.
	 * @return The user's username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username variable to the input username.
	 * @param username The user's username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the date the loaned resource copy is due to be returned.
	 * @return The date the resource copy is due.
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Gets the unique ID of the requested resource copy.
	 * @return The unique identification number of the resource copy.
	 */
	public int getCopyUID() {
		return copyUID;
	}

	/**
	 * Sets the date a requested resource copy is due to be returned.
	 * @param dueDate The date the resource copy is due.
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Sets the unique ID of a requested resource copy.
	 * @param copyUID The unique identification number of the resource copy.
	 */
	public void setCopyUID(int copyUID) {
		this.copyUID = copyUID;
	}

	/**
	 * Gets the date the requested resource copy was first issued by a librarian.
	 * @return The date the resource copy was issued.
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * Sets the date the requested resource copy is first issued by a librarian.
	 * @param issueDate The date the resource copy will be issued.
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * Gets the date the resource copy was returned.
	 * @return The date the resource copy was returned.
	 */
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * Sets the return date of the resource copy.
	 * @param returnDate The date the resource copy was returned.
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * Sets the staffID of the librarian.
	 * @param staffID The Librarians' staff Identification number.
	 */
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}


}

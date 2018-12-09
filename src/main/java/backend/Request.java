package backend;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it
@Table(name = "request")
public class Request {

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

	public Request() {}

	public Request (String username, int staffID, int copyUID, String dueDate, String issueDate, String returnDate) {
		this.username = username;
		this.staffID = staffID;
		this.copyUID = copyUID;
		this.dueDate = dueDate;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}


	/**
	 * Returns an on-loan copy that has been returned by a user. Then applies any necessary fines to that user
	 * @param copyUID Unique ID of the copy that is being returned.
	 * @param username The username of the user returning an on-loan copy.
	 */
	public static void returnCopy(int copyUID, String username) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();								//Start and setup session factory
		Query query = session.createQuery("From Request"); //query transaction table and return all Transaction objects from the table
		List<Request> empList = query.list();	           //return the objects into a list
		session.close();									   // close this request session

		Date currentDateTime = new Date();                             //Stores local time as a string in the EPOC format
		String currentTime = String.valueOf(currentDateTime.getTime());

		for(Request emp : empList){
			if (emp.getCopyUID() == copyUID && emp.getReturnDate() == null && emp.getUsername().equals(username)){         //if this current Transaction object uses the same copyUID as specified
				Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
				session2.beginTransaction();
				query = session2.createQuery("update Request set returnDate= :returnDate where copyUID= :id");         //Create a new query to update the return date transaction object
				query.setParameter("returnDate", currentTime);     		//set return date
				query.setLong("id", emp.getTransactionUID());			//put in the params
				int result = query.executeUpdate();                //execute update
				System.out.println("[Request Update] Status = "+result + " copy" +emp.getCopyUID()+" returned");  //print to terminal if it worked
				session2.getTransaction().commit();		//commit changes


				//CHECK AND ISSUING FINES

				Long dueDateLong = Long.parseLong(emp.getDueDate(), 10); // taking the current due date and converting it to a Long

				if(dueDateLong < currentDateTime.getTime()) { //comparing the return date (the date time rn) to the dueDate

					Session session3 = HibernateUtil.getSessionFactory().getCurrentSession();
					session3.beginTransaction();
					Query query2 = session3.createQuery("From User"); //query user table and return all user objects from the table into a list
					List<User> empList2 = query2.list();	           //return the objects into a list
					session3.close();

					for(User emp2 : empList2){                   // go through all user objects stored until it finds the one where the username matches the one of the passed in ( the user whose returned the copy)
						if(emp2.getUsername().equals(username)) {

							int fineApplied= emp2.getBalance() - 5;  // set a variable with the current users balance minus their fine

							Session session4 = HibernateUtil.getSessionFactory().getCurrentSession();
							session4.beginTransaction();
							query = session4.createQuery("update User set balance= :fine where username= :username"); //basically update the users balance with their £5 fine
							query.setParameter("fine", fineApplied);     		//set new balance with fine applied
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
		Query query = session.createQuery("From Request"); //return all Transaction objects from the table into a list
		List<Request> empList = query.list();
		session.close();

		Date twoDaysTime = new Date();
		String twoDays = String.valueOf(twoDaysTime.getTime() + 172800); //get and set the current time in two days

		for(Request emp : empList){
			if (emp.getCopyUID() == copyUID){         //if this current Transaction object uses the same copyUID as specified
				if (emp.getDueDate() == null && emp.getReturnDate() == null && !emp.getUsername().equals(username)) { //if resource is out (dueDate = null) and hasnt been returned (returnDate = null)
					// then set that transactions due date
					Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();						// and create a new request (which is a blank transaction)
					session2.beginTransaction();
					query = session2.createQuery("update Request set dueDate= :dueDate where copyUID= :id");
					query.setParameter("dueDate", twoDays);
					query.setLong("id", copyUID);
					int result = query.executeUpdate();
					System.out.println("[Request Update] Status = "+result + " copy requested");
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
					//then just create a blank request
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
		Query query = session.createQuery("From Request"); //return all Transaction objects from the table
		List<Request> empList = query.list();
		session.close();

		Date currentDateTime = new Date();
		String currentTime = String.valueOf(currentDateTime.getTime());  //storing the current time

		for(Request emp : empList){
			if (emp.getCopyUID() == copyUID){ //act on where the copyUID matches
				if (emp.getDueDate() == null && emp.getIssueDate() == null &&  emp.getReturnDate() == null && emp.getUsername().equals(username)) {

					Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
					session2.beginTransaction();
					query = session2.createQuery("update Request set issueDate= :issueDate where copyUID= :id");
					query.setParameter("issueDate", currentTime);
					query.setLong("id", copyUID);
					int result = query.executeUpdate();
					System.out.println("[Request Update] Status = "+result + " copy collected");
					session2.getTransaction().commit();
				}
			}
		}
	}


	/**
	 * Updates the requests table with any new copies of resources that have been added to the system, by creating blank
	 * requests with no associated username, so that the new copies can be requested and withdrawn. This is done with
	 * the use of two other methods checkIfPresentInTransaction() and addCopyToTransaction()
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
				System.out.println("Copy "+ emp.getCopyUID()+ " already present in Request");
			}else {
				Request.addCopyToTransaction(emp);
				System.out.println("Added copy "+ emp.getCopyUID()+ " to Request table");
			}
		}
		System.out.println(" ");
		System.out.println("[Request update] all copies not present in Request are now present in Request");
		System.out.println(" ");
		//Adding new copies to request table

	}


	/**
	 * This method is excusively called by updateRequests, it performs a search of the requests table to see wether
	 * the param copy is indeed already present within the request table, returning a true if it is
	 * @param copy object
	 * @return boolean value
	 */
	private static Boolean checkIfPresentInTransaction(Copies copy) {
		Boolean present = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Request"); //return all Transaction objects from the table
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
	 * This method is excusively called by updateRequests, it just takes a copy object and inserts it into the request
	 * table
	 * @param copy the copy of a resource to be inserted into request table
	 */
	public static void addCopyToTransaction(Copies copy) {
		Date currentDateTime = new Date();
		String currentTime = String.valueOf(currentDateTime.getTime());
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Request myTransaction = new Request();
		myTransaction.setCopyUID(copy.getCopyUID());
		myTransaction.setIssueDate(currentTime);
		myTransaction.setReturnDate(currentTime);
		myTransaction.setDueDate(currentTime);
		session.save(myTransaction);
		session.getTransaction().commit();
	}


	/**
	 * This method is ran whenever the program is booted up, this methods looks through the requests table and
	 * removes requests where the item requested has been returned for more than 2 days and yet not collected by someone
	 * who has requested it
	 */
	public static void houseKeeping() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From Request"); //return all Transaction objects from the table
		List<Request> empList = query.list();
		List<Request> emp2List = query.list();
		session.close();

		Date currentDateTime = new Date();
		String currentTime = String.valueOf(currentDateTime.getTime());  //storing the current time

		for(Request emp : empList){
			if (emp.getDueDate() != null && emp.getIssueDate() != null &&  emp.getReturnDate() != null) {
				//Looks for completed transactions then checks for requests on those completed transactions
				Long mostRecentlyReturned = currentDateTime.getTime();
				Long LongReturnDate = null;

				for(Request emp2 : emp2List){

					LongReturnDate = Long.parseLong(emp2.getReturnDate(), 10);  //Basically finding the most recently returned instance of the copy

					if (LongReturnDate > mostRecentlyReturned){
						mostRecentlyReturned = LongReturnDate;
					}

					if(mostRecentlyReturned < (currentDateTime.getTime() - 172800) && emp.getCopyUID() == emp2.getCopyUID()) {

						Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();			//Sorry about this mess kieran but like this basically deletes any requests for resources that have been returned more than 2 days ago,
						session2.beginTransaction();                                                        // as they have not been collected in that

						Query query2 = session.createQuery("delete from Request where copyUID= :CopyUID AND returnDate= :returnDate AND issueDate= :issueDate AND dueDate= :dueDate"); //return all Transaction objects from the table
						query2.setParameter("copyUID", emp.getCopyUID());
						query2.setParameter("returnDate", emp.getReturnDate());
						query2.setParameter("issueDate", emp.getIssueDate());
						query2.setParameter("dueDate", emp.getReturnDate());

						int result = query.executeUpdate();
						System.out.println("[Request Update] Status = "+result + " deleted uncollected request");
						session2.getTransaction().commit();
					}
				}
			}
		}
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

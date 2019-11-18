package tawelib.TaweGui;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Copies.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.1
 * @since 07/12/2018
 */

/**
 * The Copies class is used to create a copy of a Resource and track the loan duration
 * when the resource copy is taken on loan from the library.
 */

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@Table(name = "Copies")
public class Copies {

    @Id//specifying which variable is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// specifying the type of auto-incrementation for the PK, in this cas "IDENTITY" uses identifies and uses the type specified in the linked table
    private int copyUID;	//Unique identification number for the copy.
    
    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="resourceUID")//Defining that resourceUID is a foreign key 
    private int resourceUID;	//Unique identification number for the resource the copy is based off.

    private int loanDuration;	//Duration the copy will be taken on loan for.

    /**
     * Initial constructor for Copies.
     */
    public Copies() {}
    
    /**
     * Creates a Copy of a resource.
     * @param resourceUID Unique Identification number of the resource that there is a copy of.
     * @param loanDuration Duration the copy will be taken on loan for.
     */
    public Copies (int resourceUID, int loanDuration) {
        this.resourceUID = resourceUID;
        this.loanDuration = loanDuration;
    }

    /**
     * Finds and returns the User a copy was last issued to.
     * @return The username who was last issued the copy.
     */
    public String getLastIssuedTo(){
    	
    	String username = null;
    	
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("From Request"); //return all Request objects from the table
		List<Request> empList = query.list();
		for(Request emp : empList){
			if (emp.getCopyUID() == this.copyUID){         //check to see if the copy ID is present 
				username = emp.getUsername();
			}
		}	
		tx.rollback();
		sessionFactory.close();
		return (username);
    }

    /**
     * Finds and returns the date the copy was last issued.
     * @return The date the copy was last issued.
     */
    public String getLastIssueDate(){
    	String issueDate = null; //set blank variable
    
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  //
		Session session = sessionFactory.getCurrentSession();				//Start and setup session factory 
		org.hibernate.Transaction tx = session.beginTransaction();			//
		
		Query query = session.createQuery("From Request"); //query transaction table and return all Request objects from the table
		List<Request> empList = query.list();	 //return the objects into a list
		for(Request emp : empList){
			if (emp.getCopyUID() == this.copyUID && emp.getIssueDate() != null){  //if this current Request object uses the same copyUID as specified and this object is issued to someone
				issueDate = emp.getIssueDate();          //return the issueDate into the variable issueDate
			}
		}	
		sessionFactory.close(); //end session 
		return (issueDate);
    }

    /**
     * Finds and returns the Librarian who last issued the copy.
     * @return The Librarian who last issued the copy.
     */
    public int getLastIssuedBy(){
    	int staffID = 0;
    	
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("From Request"); //return all Request objects from the table
		List<Request> empList = query.list();
		for(Request emp : empList){
			if (emp.getCopyUID() == this.copyUID){         //check to see if the copy ID is present 
				staffID = emp.getStaffID();
			}
		}	
		tx.rollback();
		sessionFactory.close();
		return (staffID);
    }

    /**
     * Gets the UID of the copy.
     * @return Unique Identification number of the copy.
     */
    public int getCopyUID() {
        return copyUID;
    }

    /**
     * Gets the UID of the resource the copy is based off.
     * @return Unique Identification number of the resource.
     */
    public int getResourceUID() {
        return resourceUID;
    }

    /**
     * Gets the duration of the loan the copy is taken out for.
     * @return The duration of the loan.
     */
    public int getLoanDuration() {
        return loanDuration;
    }
}

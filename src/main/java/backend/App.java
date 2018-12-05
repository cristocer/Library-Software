package backend;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {		
    				
 //   		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 //   		Session session = sessionFactory.getCurrentSession();		
    		
 //   		session.beginTransaction();
    		
    		Book myBook = new Book ("yeet","a",420,"b","c","d","e","d");
    		
    //		session.save(myBook);
    		
    		Copies myCopyOfMyBook = new Copies(1, 420);

    //		session.save(myCopyOfMyBook);
    		
    		User myUser = new User(69, "The big yeeter420", "Ryan", "Williams", 999, "address who?", "SSD");
    		
    //		session.save(myUser);
    		
    		Librarian myLibrarian = new Librarian("from yesterday","The big yeeter421", "Ryan", "Williams", 999, "address who?", "SSD");
    		
  //  		session.save(myLibrarian);    		
    		
    		Request myTransaction = new Request(myUser.getUsername(), 420,
    				0, "today", "two weeks", " ");
    		
    		myTransaction.returnCopy(0);
    		
    		//session.save(myTransaction);
    		
    		//Query query = session.createQuery("from Book");
    		//	List<Book> empList = query.list();
    			    			
    		//for(Book emp : empList){
    		//	System.out.println("List of ResourcesUID's: "+ emp.getResourceUID());		
    		//}
    		
  //  		session.getTransaction().commit();	
    		
  //  		sessionFactory.close();
    		
    		
	    	System.out.println("NO ERRORS Lmao");
    }
}

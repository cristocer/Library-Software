package com.tawelib.Lib_Tawe;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {		
    //		Book myBook = new Book ("yeet","a",420,"b","c","d","e","d");
    //		session.save(myBook);
    //		Copies myCopyOfMyBook = new Copies(1, 420);
    // 		session.save(myCopyOfMyBook);
    //		User myUser = new User(69, "The big yeeter420", "Ryan", "Williams", 999, "address who?", "SSD");	
    //		session.save(myUser);
    //		Librarian myLibrarian = new Librarian("from yesterday","The big yeeter424", "Ryan", "Williams", 999, "address who?", "SSD");	
    		//session.save(myLibrarian);    
    		
			
	//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//		Session session = sessionFactory.getCurrentSession();		
	//		session.beginTransaction();
			
    //		com.tawelib.Lib_Tawe.Transaction myTransaction = new com.tawelib.Lib_Tawe.Transaction("The big yeeter420", 420, 
    //				1, "10", "10", null);
    
    //		session.save(myTransaction);
    //		session.getTransaction().commit();	
    		
    		com.tawelib.Lib_Tawe.Transaction.returnCopy(1, "The big yeeter420");
    		
    	//	com.tawelib.Lib_Tawe.Transaction.requestCopy(1, "Ryan 'the legend' Williams", 69);
    		
    	//	com.tawelib.Lib_Tawe.Transaction.collectCopy(1);
    		
    	//	com.tawelib.Lib_Tawe.Transaction.houseKeeping();
    		
    		
	    	System.out.println("NO ERRORS Lmao");
    }
}

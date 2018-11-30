package com.tawelib.Lib_Tawe;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {			      	
    		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    		Session session = sessionFactory.getCurrentSession();		
    		
    		Transaction tx = session.beginTransaction();
    		
    		Book myDVD = new Book ("yeet","a",420,"b","c","d","e","d");
    		
    		session.save(myDVD);
    		
    		//Query query = session.createQuery("from Book");
    		//	List<Book> empList = query.list();
    			    			
    		//for(Book emp : empList){
    		//	System.out.println("List of ResourcesUID's: "+ emp.getResourceUID());		
    		//}
    		
    	    session.getTransaction().commit();
    		
    		tx.rollback();
    		
    		sessionFactory.close();
    		
	    	System.out.println("NO ERRORS Lmao");
    }
}

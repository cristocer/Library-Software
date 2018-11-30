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
    		
    		Book myBook = new Book();
    		
    		myBook.setAuthor("REEE");
    		myBook.setGenre("PORN");
    		myBook.setIsbn(69);
    		myBook.setLanguage("welsh");
    		myBook.setPublisher("Ryan publishings");
    		myBook.setThumbnailImagePath("on harddrive");
    		myBook.setTitle("shitty book");
    		myBook.setYear("yeet");
    		
    		session.save(myBook);
    		
    		Query query = session.createQuery("from Book");
    			List<Resources> empList = query.list();
    			
    		for(Resources emp : empList){
    			System.out.println("List of ResourcesUID's: "+ emp.getResourceUID());		
  
    		}
    		
    		session.getTransaction().commit();
    		
    		tx.rollback();
    		
    		sessionFactory.close();
    		
	    	System.out.println("NO ERRORS Lmao");
    }
}

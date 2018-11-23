package com.tawelib.Lib_Tawe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
    	
    	Book myBook = new Book("Tegg","reeeee",189,"yeet","yeet", "yeet", "yeet", "yeet");
    
    	em.getTransaction().begin();
    	em.persist(myBook);
    	em.getTransaction().commit();
    	
    	DVD myDVD = new DVD("Tegg",123,"Tegg","Tegg","Tegg","Tegg","Tegg");
    
    	em.getTransaction().begin();
    	em.persist(myDVD);
    	em.getTransaction().commit();
    	
    	Laptop myLaptop = new Laptop("Tegg","Tegg","Tegg", "Tegg","Tegg","Tegg");
    	
    	em.getTransaction().begin();
    	em.persist(myLaptop);
    	em.getTransaction().commit();
    	
    	System.out.println("NO ERRORS Lmao");
    }
}

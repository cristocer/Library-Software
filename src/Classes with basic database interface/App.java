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
    	
        Laptop myLaptop = new Laptop("Windows","Dell","XPS15", "BIG BOI LAPTOP","2019", 
        		"idk");
        
    	em.getTransaction().begin();
    	em.persist(myLaptop);
    	em.getTransaction().commit();
        
        Copies myCopy = new Copies (myLaptop.getResourceUID(), 5);
        
    	em.getTransaction().begin();
    	em.persist(myCopy);
    	em.getTransaction().commit();
    	
        Copies myCopy2 = new Copies (myLaptop.getResourceUID(), 6);
        
    	em.getTransaction().begin();
    	em.persist(myCopy2);
    	em.getTransaction().commit();
    	
    	System.out.println("NO ERRORS Lmao");
    }
}

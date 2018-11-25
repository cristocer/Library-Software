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
        
     //   User myUser = new User(100,"big dick williams12", "ryan", "big dick", 89, "20 jones", "SSD");
        
     //   em.getTransaction().begin();
    //	em.persist(myUser);
    //	em.getTransaction().commit();  
    
        Book myBook = new Book("Ryan", "Ryan publishings", 420, "erotic", "Engish", "best book", 
        		"2013", "hardrive?" );
        
    	em.getTransaction().begin();
    	em.persist(myBook);
    	em.getTransaction().commit();  
        		
        //Laptop myLaptop = new Laptop("Windows","Dell","XPS15", "BIG BOI LAPTOP","2019", 
        	//	"idk");
    	//em.getTransaction().begin();
    	//em.persist(myLaptop);
    	//em.getTransaction().commit();  
        
        //Copies myCopy = new Copies (myBook.getResourceUID(), 7);
        
    	//em.getTransaction().begin();
    	//em.persist(myCopy);
    	//em.getTransaction().commit();
    	
    	System.out.println("NO ERRORS Lmao");
    }
}

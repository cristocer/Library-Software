package com.tawelib.Lib_Tawe;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity//Defining the class as a persistent entity allowing the hibernate API to interact with it 
@Table(name = "Copies")
public class Copies {

    @Id//specifying which variable is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// specifying the type of auto-incrementation for the PK, in this cas "IDENTITY" uses identifies and uses the type specified in the linked table
    private int copyUID;

    @JoinColumn(name="resourceUID")//Defining that resourceUID is a foreign key 
    private int resourceUID;
    private int loanDuration;

    public Copies() {}
    
    public Copies (int resourceUID, int loanDuration) {
        this.resourceUID = resourceUID;
        this.loanDuration = loanDuration;
    }

    public String getLastIssuedTo(){
    	
    	String username = null;
    	
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		for(Transaction emp : empList){
			if (emp.getCopyUID() == this.copyUID){         //check to see if the copy ID is present 
				username = emp.getUsername();
			}
		}	
		tx.rollback();
		sessionFactory.close();
		return (username);
    }

    public String getLastIssueDate(){
    	String issueDate = null; //set blank variable
    
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  //
		Session session = sessionFactory.getCurrentSession();				//Start and setup session factory 
		org.hibernate.Transaction tx = session.beginTransaction();			//
		
		Query query = session.createQuery("From Transaction"); //query transaction table and return all Transaction objects from the table
		List<Transaction> empList = query.list();	 //return the objects into a list
		for(Transaction emp : empList){
			if (emp.getCopyUID() == this.copyUID && emp.getIssueDate() != null){  //if this current Transaction object uses the same copyUID as specified and this object is issued to someone
				issueDate = emp.getIssueDate();          //return the issueDate into the variable issueDate
			}
		}	
		sessionFactory.close(); //end session 
		return (issueDate);
    }

    public int getLastIssuedBy(){
    	int staffID = 0;
    	
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("From Transaction"); //return all Transaction objects from the table
		List<Transaction> empList = query.list();	
		for(Transaction emp : empList){
			if (emp.getCopyUID() == this.copyUID){         //check to see if the copy ID is present 
				staffID = emp.getStaffID();
			}
		}	
		tx.rollback();
		sessionFactory.close();
		return (staffID);
    }
 

    public int getCopyUID() {
        return copyUID;
    }

    public int getResourceUID() {
        return resourceUID;
    }

    public int getLoanDuration() {
        return loanDuration;
    }
}

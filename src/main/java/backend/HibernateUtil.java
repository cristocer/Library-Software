package backend;

/**
 * HibernateUtil.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author Alex Moras & Ryan Williams
 * @version 1.5
 * @since 07/12/2018
 */

/**
 * The HibernateUtil class is used to create a sessionFactory session for use with the database
 * so long as a session is not already active, in which case it is used to  get the active session.
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory; //sessionFactory session for the database.
	
	/**
	 * Creates the SessionFactory from hibernate.cfg.xml or throws a failure state if
	 * SessionFactory cannot be created.
	 * @return The SessionFactory.
	 */
	private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Hibernate Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	/**
	 * Gets SessionFactory if one has been created or calls "buildSessionFactory" if one hasn't.
	 * @return The SessionFactory.
	 */
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}

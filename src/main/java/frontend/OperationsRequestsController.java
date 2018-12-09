package frontend;

import backend.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * OperationsRequestsController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The OperationsRequests class is a subclass of the class Controller. This class creates and manages the 
 * operations a librarian can use when a user requests a resource.
 */

public class OperationsRequestsController extends Controller{

    @FXML
    private ListView<String> listOfRequests;	//list with the requests (loan someone a copy of a resource, somebody came to collect or return it)
    @FXML
    private TextField textID;//the search field
    @FXML
    private TextField userID;//the id of user you want to loan sth
    @FXML
    private TextField copyID;//the id of copy you want to loan to sth
    @FXML
    private Text user;
    @FXML
    private Text copy;
    @FXML
    void searchID(){
        searchHandling(); 
    }
    @FXML
    void createL(){//approve a loan
        createHandling();
    }

    @FXML
    void collectL(){//collect a loan
        collectHandling();
    }

    @FXML
    void returnL(){//return a loan
        returnHandling();
    }

    @FXML
    void cancelButton(){
        close();
    }



    public void initialize(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Resources> resourcesList = session.createQuery("From Resources").list();
        for(int i = 0; i < resourcesList.size(); i++){
            List<Copies> copyList = session.createQuery("From Copies Where resourceUID = '" + resourcesList.get(i).getResourceUID() + "'").list();
            for(int i1 = 0; i1 < copyList.size(); i1++){
                listOfRequests.getItems().add(resourcesList.get(i).getTitle() + " (" + copyList.get(i1).getCopyUID() + ")");
            }
        }
        session.close();
        /*for(int i=0; i < 1000; i++){
            listOfRequests.getItems().add("lol"+Integer.toString(i));
        }*/

        //System.out.print(listOfRequests.getFocusModel().getFocusedItem());
        
        //the reason I am debating regarding if the request will be an object or a string is that I don't know 
        //how is easier to have a request class to take request.getID() or from the request String extract the ID
        //with like request.subSequence(0,request.indexOf(' '));

    }
    
    void searchHandling(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Request> request = session.createQuery("From Request Where username = '" + textID.getText() + "'").list();
        if(!request.isEmpty()) {
            for(int i = 0; i < request.size(); i++){
                Copies copy = (Copies) session.createQuery("From Copies Where copyUID = '" + request.get(i).getCopyUID() + "'").uniqueResult();
                Resources resource = (Resources) session.createQuery("From Resources Where resourceUID = '" + copy.getResourceUID() + "'").uniqueResult();
                listOfRequests.getItems().add(resource.getTitle() + " (" + copy.getCopyUID() + ")");
            }
        }
        session.close();
        //query the database by textID.getText() for the requests of the user.
        //put all the requests in the listOfRequests with 
        //listOfRequests.getItems().add(request);        
    }

    void createHandling(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Librarian librarian = (Librarian) session.createQuery("From Librarian Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
        String copyUID = listOfRequests.getFocusModel().getFocusedItem().split("[\\(\\)]")[1];
        if(userID.getText().compareTo("")==0 || copyID.getText().compareTo("")==0 ){
            //get the id from the string/object above and update the database with the loan status of the request as being approved

            //plus other operations regarding the database (like the resource is not available anymore to be loaned)
        }else{
            Request request = new Request(userID.getText(), librarian.getStaffID(), Integer.parseInt(copyUID), null, null, null);
            session.save(request);
        }
        session.getTransaction().commit();
        Request.requestCopy(Integer.parseInt(copyUID), userID.getText(), librarian.getStaffID());
        //listOfRequests.getFocusModel().getFocusedItem()
        //get the id from the string/object above and update the database with the loan status of the request as being approved
        //plus other operations regarding the database (like the resource is not available anymore to be loaned)
    }

    void collectHandling(){
        String copyUID = listOfRequests.getFocusModel().getFocusedItem().split("[\\(\\)]")[1];
        Request.collectCopy(Integer.parseInt(copyUID), userID.getText());
        //listOfRequests.getFocusModel().getFocusedItem()
        //get the id from the string/object above and update the database with the loan status of the request as being collected
        //plus other operations regarding the database (like update the resource due data or sth)
    }

    void returnHandling(){
        String copyUID = listOfRequests.getFocusModel().getFocusedItem().split("[\\(\\)]")[1];
        Request.returnCopy(Integer.parseInt(copyUID), userID.getText());
         //listOfRequests.getFocusModel().getFocusedItem()
        //get the id from the string/object above and update the database with the loan status of the request as being returned
        //plus other operations regarding the database (like the resource is available to be loaned)
    }
}
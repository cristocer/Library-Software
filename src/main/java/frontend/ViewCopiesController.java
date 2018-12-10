package frontend;
import backend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * ViewCopiesController.java
 * - GNU General Public License 2007
 * - creation date: 09/12/2018
 * - last modified: 09/12/2018
 * @author Alex Moras
 * @version 1.3
 * @since 09/12/2018
 */

/**
 * The ViewCopiesController class is a subclass of the class Controller and 
 * is used to by librarians to display all the copies of a resource.
 */

public class ViewCopiesController {
    @FXML
    private GridPane rootPane;	//Creates GridPane for displaying copies information via the GUI.
    @FXML
    private TextField userIDBox;	//Creates TextField to contain Librarian ID.
    @FXML
    private ListView<String> copiesList;	//Creates a list of all the copies of a resource
    @FXML
    private ImageView resourceImage;	//Creates an ImageView to display the image of the resource being viewed.
    
    /**
     * An event that occurs when the user has pressed the done button to leave the "view copies" page.
     * @param event An event caused by the user pressing the done button.
     */
    @FXML
    void doneButton(ActionEvent event) {
    }
    /**
     * A method that occurs when the user presses the loan button.
     */
    @FXML
    void loanB(){
        loan();
    }
    /**
     * Initialises the GUI for choosing profile images.
     */
    public void initialize(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Resources resource = (Resources) session.createQuery("From Resources Where resourceUID = '" + SceneController.SELECTED_RESOURCE.split("[\\(\\)]")[1] + "'").uniqueResult();
            System.out.println(resource.title);
            List<Copies> copies = session.createQuery("From Copies Where resourceUID = '" + resource.getResourceUID() + "'").list();
            for (int i = 0; i < copies.size(); i++) {
                copiesList.getItems().add(String.valueOf(copies.get(i).getCopyUID()));
            }
        }
        catch (Exception e){
            copiesList.getItems().add("Please close this window and select a resource.");
            System.out.println(e);
        }
        session.close();
    }
    /**
     * This method loans out a copy of a resource to a user.
     */
    public void loan(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Librarian librarian = (Librarian) session.createQuery("From Librarian Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
        Copies selectedCopy = (Copies) session.createQuery("From Copies Where copyUID = '" + copiesList.getSelectionModel().getSelectedItem() + "'").uniqueResult();
        session.close();
        Request.requestCopy(selectedCopy.getCopyUID(), userIDBox.getText(), librarian.getStaffID());
        Request.collectCopy(selectedCopy.getCopyUID(), userIDBox.getText());
    }
}
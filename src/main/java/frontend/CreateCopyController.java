package frontend;

import backend.Copies;
import backend.HibernateUtil;
import backend.Request;
import backend.Resources;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * CreateCopyController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 *
 * @author
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The CreateCopyController class is a subclass of the class Controller and 
 * is used to create a copy of a resource via a librarian account's GUI.
 */

public class CreateCopyController extends Controller {

    @FXML
    private RadioButton book;    //Book RadioButton used in the GUI.
    @FXML
    private RadioButton DVD;    //DVD RadioButton used in the GUI.
    @FXML
    private RadioButton laptop;    //Laptop RadioButton used in the GUI.

    @FXML
    private ListView<String> listOfCopies;    //list with the available copies to edit

    /**
     * Method used to add a button to the GUI.
     */
    @FXML
    void addButton() {
        addHandling();
        close();
    }

    /**
     * Method used to remove a button from the GUI.
     */
    @FXML
    void cancelButton() {
        close();
    }

    private int copy;    //Variable used to track the kind of copy created.
    @FXML
    private Text invalidMessage;    //Message used in the case of an invalid action.
    @FXML
    private Text incompleteMessage;    //Message used in the case of an incomplete action.

    /**
     * Method used to reset the individual text and textfields.
     */
    void reset() {
        invalidMessage.setVisible(false);
        incompleteMessage.setVisible(false);
        copy = 0;

    }

    /**
     * Method used to initialise the create a copy GUI.
     */
    public void initialize() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Resources> resourcesList = session.createQuery("From Resources").list();

        for (int i = 0; i < resourcesList.size(); i++) {
            String resourceName = resourcesList.get(i).getTitle();
            int resourceUID = resourcesList.get(i).getResourceUID();
            listOfCopies.getItems().add(resourceName + " (" + resourceUID + ")");
        }
        session.close();
        reset();

    }

    /**
     * Method used to refresh the list of copies of resources.
     */
    private void refreshList() {
        if (copy == 1) {
            //query laptop db of resources
        } else if (copy == 2) {
            //query DVD db of resources
        } else if (copy == 3) {
            //query book db of resources
        }
        //a select query to db that will return a list of objects of subtype of resource(laptop,book,dvd)
        //this list will be put in the listView.
        //We will also need the Id of the resource so we can reference it when we change it back into the database.
        //we may need to override toString method for every resource so we can display them as strings,unless the query
        //will return string objects which i doubt
        //then we simply use add() method./or the normal way from below
        //resourceID=id from db


        //a possible alternative
        //ObservableList<String> names = FXCollections.observableArrayList(
        //  "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        //listOfResources = new ListView<String>(names);
    }

    private int resourceID;        //Unique ID of the resource.

    /**
     * Method used to maintain and control the create copy GUI used by the librarian accounts.
     */
    private void addHandling() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int resourceUID = Integer.parseInt(listOfCopies.getFocusModel().getFocusedItem().split("[\\(\\)]")[1]);
        Copies copy = new Copies(resourceUID, 604800);
        session.save(copy);
        session.getTransaction().commit();
        Request.addCopyToTransaction(copy);
        refreshList();
    }
}

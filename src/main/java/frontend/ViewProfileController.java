package frontend;

import backend.AccountBaseUser;
import backend.HibernateUtil;
import backend.Librarian;
import backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * ViewProfileController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The ViewProfileController class is a subclass of the class Controller and is used to
 * display the appropriate GUI when the user requests their profile information.
 */

public class ViewProfileController extends Controller{

    @FXML
    private GridPane rootPane;	//Creates GridPane for displaying Profile information via the GUI.

    @FXML
    private ImageView imageField;	//Creates ImageView to display the Profile Image via the GUI.

    @FXML
    private VBox attributeVBox;	//Creates VBox to display attributes via the GUI.

    @FXML
    private ListView<String> profileInfo;	//Creates a ListView for displaying the profiles information.

    @FXML
    private HBox profileHBox;	//Creates Horizontal Box for displaying Profile information via the GUI.

    /**
     * Method called upon when the user presses the edit profile button.
     * @param event An even caused by the user pressing the edit profile button.
     */
    @FXML
    void editProfileButton(ActionEvent event) {
        editProfileHandling();
    }
    
    /**
     * Method called upon when the user presses the done button. The method closes the
     * profile controller GUI.
     */
    @FXML
    void doneButton(){
        close();
    }

    /**
     * Method used when the user first requests to view their profile.
     */
    public void initialize(){
        populateProfile();
    }

    /**
     * This method calls the appropriate methods and class to enable the user to edit their profile.
     */
    public void editProfileHandling(){
        Window editProfileWindow = new Window(SceneController.EDIT_PROFILE,SceneController.EDIT_PROFILE_WIDTH,SceneController.EDIT_PROFILE_HEIGHT,SceneController.EDIT_PROFILE_TITLE);
        editProfileWindow.makeModal();
        editProfileWindow.showAndWait();
    }

    /**
     * This method populates the GUI with the users' profile information.
     */
    private void populateProfile() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query queryLibrarian = session.createQuery("From Librarian Where username = '" + SceneController.USER_USERNAME + "'");
        AccountBaseUser baseUser = (AccountBaseUser) session.createQuery("From AccountBaseUser Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
        User user = (User) session.createQuery("From User Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
        Librarian librarian = (Librarian) queryLibrarian.uniqueResult();
        profileInfo.getItems().add("Username:   " + baseUser.getUsername());
        profileInfo.getItems().add("Firstname:  " + baseUser.getFirstName());
        profileInfo.getItems().add("Last name:  " + baseUser.getLastName());
        profileInfo.getItems().add("Telephone:  " + baseUser.getTelephone());
        profileInfo.getItems().add("Address:    " + baseUser.getAddress());
        if(queryLibrarian.uniqueResult() != null){
            profileInfo.getItems().add("Staff ID:   " + librarian.getStaffID());
            profileInfo.getItems().add("Start Date: " + librarian.getEmploymentDate());
        }
        else {
            profileInfo.getItems().add("Balance:    " + user.getBalance());
        }
        session.close();
    }
}

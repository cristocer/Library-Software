package frontend;

import backend.AccountBaseUser;
import backend.HibernateUtil;
import backend.Librarian;
import backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * EditProfileController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The EditProfileController Class is a subclass of the class Controller and is used in
 * editing a users' profile information via the GUI.
 */

public class EditProfileController extends Controller{

    @FXML
    private GridPane rootPane;	//Creates GridPane for displaying Profile information via the GUI.

    @FXML
    private ImageView imageField;	//Creates ImageView to display the Profile Image via the GUI.

    @FXML
    private VBox attributeVBox;	//Creates VBox to display attributes via the GUI.

    @FXML
    private TextField userNameField;	//Creates a TextField to display and edit the user's username via the GUI.

    @FXML
    private TextField firstnameField;	//Creates a TextField to display and edit the user's first name via the GUI.

    @FXML
    private TextField lastnameField;	//Creates a TextField to display and edit the user's last name via the GUI.

    @FXML
    private TextField telephoneField;	//Creates a TextField to display and edit the user's telephone number via the GUI.

    @FXML
    private TextField addressField;		//Creates a TextField to display and edit the user's address via the GUI.

    @FXML
    private VBox librarianFields;	//Creates a VBox to display attributes unique to librarian profiles.

    @FXML
    private TextField employmentField;	//Creates a TextField to display the librarians's employment date via the GUI.

    @FXML
    private HBox profileHBox;	//Creates Horizontal Box for displaying Profile information via the GUI.

    /**
     * Method used for choosing a new profile image for the profile.
     * @param event An event caused by the user submitting their profile image.
     */
    @FXML
    void chooseImage(ActionEvent event) {

    }

    /**
     * Method used when the user has chosen to draw their profile image.
     * @param event An event caused by the user drawing their profile image.
     */
    @FXML
    void drawImage(ActionEvent event) {

    }

    /**
     * Method used to finalise changes to the user's profile information.
     * @param event An event caused by the user submitting their profile changes.
     */
    @FXML
    void editProfileButton(ActionEvent event) {editProfileHandling(); }

    /**
     * Method used to cancel any changes to the user's profile information.
     */
    @FXML
    void cancelButton(){cancelHandling(); }

    /**
     * Method used when the edit profile feature is first used to call appropriate methods.
     */
    public void initialize(){
        isLibrarian();
    }

    /**
     * This method causes special circumstances if the user is a librarian.
     */
    public void isLibrarian(){
        //If user is librarian make employment date visible.
    }

    /**
     * This method submits final changes once the user has finished making changes.
     */
    public void editProfileHandling(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        AccountBaseUser baseUser = (AccountBaseUser) session.createQuery("From AccountBaseUser Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
        if(!firstnameField.getText().isEmpty()){ baseUser.setFirstName(firstnameField.getText()); }
        if(!lastnameField.getText().isEmpty()){ baseUser.setLastName(lastnameField.getText()); }
        if(!telephoneField.getText().isEmpty()){ baseUser.setTelephone(Integer.parseInt(telephoneField.getText())); }
        if(!addressField.getText().isEmpty()){ baseUser.setAddress(addressField.getText()); }
        session.save(baseUser);
        session.getTransaction().commit();
        close();
    }

    /**
     * This method cancels all changes to the user's profile information when called.
     */
    public void cancelHandling(){
        close();
    }
}

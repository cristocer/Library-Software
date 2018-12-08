package frontend;

import backend.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import backend.Librarian;
import backend.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * CreateUserController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The CreateUserController Class is is a subclass of the class Controller and is used 
 * in creating a new user via the GUI.
 */

public class CreateUserController extends Controller{

    @FXML
    private ImageView imageField;	//Creates ImageView used for choosing a profile image for the user via the GUI.

    @FXML
    private TextField userNameField;	//Creates TextField used for inputting the user's username via the GUI.

    @FXML
    private TextField firstnameField;	//Creates TextField used for inputting the user's first name via the GUI.

    @FXML
    private TextField lastnameField;	//Creates TextField used for inputting the user's last name via the GUI.

    @FXML
    private TextField telephoneField;	//Creates TextField used for inputting the user's telephone number via the GUI.

    @FXML
    private TextField addressField;		//Creates TextField used for inputting the user's address via the GUI.

    @FXML
    private CheckBox librarianCheckbox;	//Creates Checkbox used to define whether the user being created is a librarian or not.

    @FXML
    private VBox librarianFields;	//This VBox adds extra fields based on whether the librarianCheckbox is checked or not.

    @FXML
    private TextField employmentField;	//Creates TextField used to define when the librarian was hired.

    /**
     * Method called when the user has chosen their profile image.
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
        drawImageHandling();
    }

    /**
     * Method used when the created user is determined to be a librarian, the method shows
     * new fields on the GUI if the created user is a librarian.
     * @param event An event caused by the librarianCheckbox being checked.
     */
    @FXML
    void showLibrarianFields(ActionEvent event) {
        toggleLibrarian();
    }

    /**
     * Method used when the user has finished their creation form to submit all their fields.
     */
    @FXML
    void submitFormButton(){
        submitHandling();
    }


    /**
     * Method used to toggle whether or not extra fields relative to a librarian are shown,
     * this is decided based on whether the user being created is determined to be a librarian.
     */
    private void toggleLibrarian(){
        librarianFields.setDisable(!librarianFields.isDisabled());
        librarianFields.setVisible(!librarianFields.isVisible());
    }

    //ToDo - Chris to implement draw profile picture method here. have it return an Image if possible aswell as saving it.
    private Image drawImageHandling(){
        return null;
    }

    /**
     * Method used when the form has been filled and submitted to create and register the newly created user account.
     */
    private void submitHandling(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  //
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        if(librarianCheckbox.isSelected()) {
            // CODE HERE
            Librarian newLibrarian = new Librarian(employmentField.getText(), userNameField.getText(), firstnameField.getText(), lastnameField.getText(), Integer.parseInt(telephoneField.getText()), addressField.getText(), "");
            session.save(newLibrarian);
        }
        else {
            User newUser = new User(0, userNameField.getText(), firstnameField.getText(), lastnameField.getText(), Integer.parseInt(telephoneField.getText()), addressField.getText(), "");
            session.save(newUser);
        }
        session.getTransaction().commit();
        close();
    }
}

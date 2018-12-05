package frontend;

import backend.HibernateUtil;
import backend.Librarian;
import backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import frontend.TaweLib;


public class CreateUserController extends Controller{

    @FXML
    private ImageView imageField;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField telephoneField;

    @FXML
    private TextField addressField;

    @FXML
    private CheckBox librarianCheckbox;

    @FXML
    private VBox librarianFields;

    @FXML
    private TextField employmentField;

    @FXML
    void chooseImage(ActionEvent event) {

    }

    @FXML
    void drawImage(ActionEvent event) {
        drawImageHandling();
    }

    @FXML
    void showLibrarianFields(ActionEvent event) {
        toggleLibrarian();
    }

    @FXML
    void submitFormButton(){
        submitHandling();
    }



    private void toggleLibrarian(){
        librarianFields.setDisable(!librarianFields.isDisabled());
        librarianFields.setVisible(!librarianFields.isVisible());
    }

    //ToDo - Chris to implement draw profile picture method here. have it return an Image if possible aswell as saving it.
    private Image drawImageHandling(){
        return null;
    }

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

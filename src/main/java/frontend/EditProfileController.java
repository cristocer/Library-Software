package frontend;

import backend.AccountBaseUser;
import backend.HibernateUtil;
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

public class EditProfileController extends Controller{

    @FXML
    private GridPane rootPane;

    @FXML
    private ImageView imageField;

    @FXML
    private VBox attributeVBox;

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
    private VBox librarianFields;

    @FXML
    private TextField employmentField;

    @FXML
    private HBox profileHBox;

    @FXML
    void chooseImage(ActionEvent event) {

    }

    @FXML
    void drawImage(ActionEvent event) {

    }

    @FXML
    void editProfileButton(ActionEvent event) {editProfileHandling(); }
    @FXML
    void cancelButton(){cancelHandling(); }

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  //
    private Session session = sessionFactory.getCurrentSession();
    public void initialize(){
        isLibrarian();
    }

    public void isLibrarian(){
        session.beginTransaction();
        Query query = session.createQuery("From Librarian Where username = '" + SceneController.USER_USERNAME + "'");
        if(query.uniqueResult() != null){
            // EDIT A USER's PROFILE
            session.getTransaction().commit();
        }
        else {
            // Not a Librarian, so close the session.
            session.close();
        }
        close();
    }
    public void editProfileHandling(){
        session.beginTransaction();
        Query queryBaseUser = session.createQuery("update AccountBaseUser set firstName = :firstName, lastName = :lastName, address = :address, profileImagePath = :profileImagePath  Where username = '" + SceneController.USER_USERNAME + "'");
        queryBaseUser.setParameter("firstName", firstnameField.getText());
        queryBaseUser.setParameter("lastName", lastnameField.getText());
        queryBaseUser.setParameter("address", addressField.getText());
        queryBaseUser.setParameter("profileImagePath", "");  // TODO Implement profile image
        session.getTransaction().commit();
        close();
    }
    public void cancelHandling(){
        close();
    }
}

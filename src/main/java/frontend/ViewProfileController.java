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

import java.util.List;

public class ViewProfileController extends Controller{

    @FXML
    private GridPane rootPane;

    @FXML
    private ImageView imageField;

    @FXML
    private VBox attributeVBox;

    @FXML
    private ListView<String> profileInfo;

    @FXML
    private HBox profileHBox;

    @FXML
    void editProfileButton(ActionEvent event) {
        editProfileHandling();
    }
    @FXML
    void doneButton(){
        close();
    }

    public void initialize(){
        populateProfile();
    }


    public void editProfileHandling(){
        Window editProfileWindow = new Window(SceneController.EDIT_PROFILE,SceneController.EDIT_PROFILE_WIDTH,SceneController.EDIT_PROFILE_HEIGHT,SceneController.EDIT_PROFILE_TITLE);
        editProfileWindow.makeModal();
        editProfileWindow.showAndWait();
    }

    private void populateProfile() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query queryLibrarian = session.createQuery("From Librarian Where username = '" + SceneController.USER_USERNAME + "'");
        AccountBaseUser baseUser = (AccountBaseUser) session.createQuery("From AccountBaseUser Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
        User user = (User) session.createQuery("From User Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
        Librarian librarian = (Librarian) queryLibrarian.uniqueResult();
        profileInfo.getItems().add(baseUser.getUsername());
        profileInfo.getItems().add(baseUser.getFirstName());
        profileInfo.getItems().add(baseUser.getLastName());
        profileInfo.getItems().add(String.valueOf(baseUser.getTelephone()));
        profileInfo.getItems().add(baseUser.getAddress());
        if(queryLibrarian.uniqueResult() != null){
            profileInfo.getItems().add(String.valueOf(librarian.getStaffID()));
            profileInfo.getItems().add(librarian.getEmploymentDate());
        }
        else {
            profileInfo.getItems().add(String.valueOf(user.getBalance()));
        }
        session.close();
    }
}


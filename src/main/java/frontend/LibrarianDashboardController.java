package frontend;

import backend.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LibrarianDashboardController extends Controller{

    @FXML
    private ListView<String> resourcesList;
    @FXML
    private Text user_id;

    @FXML
    void logoutButton(ActionEvent event) {
        logoutHandling();
    }
    @FXML
    void createResourceButton() {
        createResourceHandling();
    }
    @FXML
    void editResourceButton() {
        editResourceHandling();
    }
    @FXML
    void loanResourceButton() {
        loanResourceHandling();
    }
    @FXML
    void collectResourceButton() {
        collectResourceHandling();
    } 
    @FXML
    void createUserButton(){createUserHandling();}
    @FXML
    void viewProfileButton(){viewProfileHandling();
    }
    /**
     * Initializes the GUI, prompts user for Login...ToDO
     */
    public void initialize(){
        user_id.setText(SceneController.USER_USERNAME);
        // populateList();
    }

// Just until i can fetch from db
    private void getResourcesList(){  // TODO Change to ListView<String> instead of void.
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  //
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("From resources");
        // RETURN LIST VIEW OF ABOVE!
    }

    private void createResourceHandling() {
        Window<CreateResourceController> viewWindow = new Window<>(SceneController.CREATE_VIEW, SceneController.CREATE_VIEW_WIDTH, SceneController.CREATE_VIEW_HEIGHT, SceneController.CREATE_VIEW_TITLE);
        viewWindow.show();
    }
    private void editResourceHandling() {
        Window<EditResourceController> viewWindow = new Window<>(SceneController.EDIT_VIEW, SceneController.EDIT_VIEW_WIDTH, SceneController.EDIT_VIEW_HEIGHT, SceneController.EDIT_VIEW_TITLE);
        viewWindow.show();
    }
    private void loanResourceHandling() {
        Window<LoanResourceController> viewWindow = new Window<>(SceneController.LOAN_VIEW, SceneController.LOAN_VIEW_WIDTH, SceneController.LOAN_VIEW_HEIGHT, SceneController.LOAN_VIEW_TITLE);
        viewWindow.show();
    }
    private void collectResourceHandling() {
        Window<CollectResourceController> viewWindow = new Window<>(SceneController.COLLECT_VIEW, SceneController.COLLECT_VIEW_WIDTH, SceneController.COLLECT_VIEW_HEIGHT, SceneController.COLLECT_VIEW_TITLE);
        viewWindow.show();
    }
    private void createUserHandling(){
        Window<CreateUserController> createUser = new Window<>(SceneController.CREATE_USER,SceneController.CREATE_USER_WIDTH,SceneController.CREATE_USER_HEIGHT,SceneController.CREATE_USER_TITLE);
        createUser.show();
    }
    @Override
    public void close(){
        System.exit(0);
    }
}


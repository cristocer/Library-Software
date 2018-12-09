package frontend;

import backend.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * LibrarianDashboardController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 03/12/2018
 * @author Alex Moras & Ryan Williams
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The LibrarianDashboardController class is a subclass of the class Controller. This class is used 
 * to create and manage the dashboard that Librarians use as a part of the library system.
 */

public class LibrarianDashboardController extends Controller{

    @FXML
    private ListView<String> resourcesList;	//A list of resources the library owns.
    @FXML
    private Text user_id;	//The ID of the currently logged in librarian.

    /**
     * A method called when the logout button is pressed in order to prompt logging out.
     * @param event An event caused by the user pressing the logout button.
     */
    @FXML
    void logoutButton(ActionEvent event) {
        logoutHandling();
    }
    
    /**
     * A method used when the create resource button is pressed in order to prompt the resource to be created.
     */
    @FXML
    void createResourceButton() {
        createResourceHandling();
    }
    
    /**
     * A method used when the create resource button is pressed in order to prompt edits to the resource to be finalised.
     */
    @FXML
    void editResourceButton() {
        editResourceHandling();
    }
    
    /**
     * 
     */
    @FXML
    void operationsRequestsButton() {
        operationsRequestsHandling();
    }
    
    /**
     * A method used when the create copy button is pressed in order to finalise the creation of a copy of a resource.
     */
    @FXML
    void createCopyButton() {
        createCopyHandling();
    }
    
    /**
     * A method used when the create user button is pressed in order to initialise the creation of a new user.
     */
    @FXML
    void createUserButton(){createUserHandling();}
    
    /**
     * A method used when the view profile button is pressed in order to bring the accounts profile information into view.
     */
    @FXML
    void viewProfileButton(){viewProfileHandling();
    }
    /**
     * Initialises the dashboard GUI for librarian accounts.
     */
    public void initialize(){
        user_id.setText(SceneController.USER_USERNAME);
        populateList();
    }

// Just until i can fetch from db
    /**
     * Fills the resourceList with all the resources the library owns.
     */
    private void populateList() { // Just for testing
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List resources = session.createQuery("Select title From Resources").list();
        if(!resources.isEmpty()) {
            for (int i = 0; i < resources.size(); i++) {
                resourcesList.getItems().add(String.valueOf(resources.get(i)));
            }
        }
        session.close();
    }
    
    /**
     * A method used to create a new resource in the library database.
     */
    private void createResourceHandling() {
        Window<CreateResourceController> viewWindow = new Window<>(SceneController.CREATE_VIEW, SceneController.CREATE_VIEW_WIDTH, SceneController.CREATE_VIEW_HEIGHT, SceneController.CREATE_VIEW_TITLE);
        viewWindow.show();
    }
    
    /**
     * A method used to edit a resources information in the library database.
     */
    private void editResourceHandling() {
        Window<EditResourceController> editResource = new Window<>(SceneController.EDIT_VIEW, SceneController.EDIT_VIEW_WIDTH, SceneController.EDIT_VIEW_HEIGHT, SceneController.EDIT_VIEW_TITLE);
        editResource.show();
    }
    
    /**
     * 
     */
    private void operationsRequestsHandling() {
        Window<OperationsRequestsController> operationsWindow = new Window<>(SceneController.OPERATIONS_VIEW, SceneController.OPERATIONS_VIEW_WIDTH, SceneController.OPERATIONS_VIEW_HEIGHT, SceneController.OPERATIONS_VIEW_TITLE);
        operationsWindow.show();
    }
    
    /**
     * A method used to create a new user.
     */
    private void createUserHandling(){
        Window<CreateUserController> createUser = new Window<>(SceneController.CREATE_USER,SceneController.CREATE_USER_WIDTH,SceneController.CREATE_USER_HEIGHT,SceneController.CREATE_USER_TITLE);
        createUser.show();
    }
    
    /**
     * A method used to create a new copy of a resource.
     */
    private void createCopyHandling(){
        Window<CreateCopyController> createCopy = new Window<>(SceneController.CREATEC_VIEW, SceneController.CREATEC_VIEW_WIDTH, SceneController.CREATEC_VIEW_HEIGHT, SceneController.CREATEC_VIEW_TITLE);
        createCopy.show();
    }
    
    /**
     * Method used to close the librarian dashboard.
     */
    @Override
    public void close(){
        System.exit(0);
    }
}


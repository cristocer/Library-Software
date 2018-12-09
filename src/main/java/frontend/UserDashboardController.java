package frontend;

import java.io.IOException;
import java.util.List;
import backend.HibernateUtil;
import backend.Resources;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * UserDashboardController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 03/12/2018
 * @author Alex Moras & Ryan Williams
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The UserDashboardController class is a subclass of the class Controller. This class is used
 * to create and manage the dashboard that Users use as a part of the library system.
 */

public class UserDashboardController extends Controller{

    @FXML
    private ListView<String> resourcesList;	////A list of resources the library owns.
    @FXML
    private Text user_id;	//The ID of the currently logged in user.

    /**
     * A method called when the logout button is pressed in order to prompt logging out.
     * @param event An event caused by the user pressing the logout button.
     */
    @FXML
    void logoutButton(ActionEvent event) {
        logoutHandling();
    }

    /**
     * A method used when the view resources button is pressed in order to bring the a resources' information into view.
     */
    @FXML
    void viewResourceButton() {
        SceneController.SELECTED_RESOURCE = resourcesList.getSelectionModel().getSelectedItem();
        viewHandling();
    }

    /**
     * A method used the the transaction history button is pressed in order to bring the users' transaction history into view.
     * @param event
     */
    @FXML
    void transactionHistoryButton(ActionEvent event) {
        transactionHandling();
    }

    /**
     * A method used when the view profile button is pressed in order to bring the accounts profile information into view.
     */
    @FXML
    void viewProfileButton(){viewProfileHandling();
    }

    /**
     * Initialises the dashboard GUI for user accounts.
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
     * A method used to present the libraries resources to the user.
     */
    private void viewHandling() {
        Window<ResourceViewController> viewWindow = new Window<>(SceneController.RESOURCE_VIEW, SceneController.RESOURCE_VIEW_WIDTH, SceneController.RESOURCE_VIEW_HEIGHT, SceneController.RESOURCE_VIEW_TITLE);
        viewWindow.show();
    }

    /**
     * A method used to present a list of the users' previous transactions.
     */
    private void transactionHandling(){
        Window<TransactionController> transactionWindow = new Window<>(SceneController.TRANSACTION_WINDOW, SceneController.TRANSACTION_WINDOW_WIDTH, SceneController.TRANSACTION_WINDOW_HEIGHT, SceneController.TRANSACTION_WINDOW_TITLE);
        transactionWindow.show();
    }

    /**
     * Method used to close the librarian dashboard.
     */
    @Override
    public void close(){
        System.exit(0);
    }
}


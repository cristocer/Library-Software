package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;


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
    void operationsRequestsButton() {
        operationsRequestsHandling();
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
        populateList();
    }

// Just until i can fetch from db
    private void populateList() { // Just for testing
        for(int x=0; x < 1000; x++){
            resourcesList.getItems().add("lol");
        }
    }

    private void createResourceHandling() {
        Window<CreateResourceController> viewWindow = new Window<>(SceneController.CREATE_VIEW, SceneController.CREATE_VIEW_WIDTH, SceneController.CREATE_VIEW_HEIGHT, SceneController.CREATE_VIEW_TITLE);
        viewWindow.show();
        System.out.println(SceneController.CREATE_VIEW_WIDTH);
    }
    private void editResourceHandling() {
        Window<EditResourceController> viewWindow = new Window<>(SceneController.EDIT_VIEW, SceneController.EDIT_VIEW_WIDTH, SceneController.EDIT_VIEW_HEIGHT, SceneController.EDIT_VIEW_TITLE);
        viewWindow.show();
        System.out.println(SceneController.EDIT_VIEW_WIDTH);
    }
    private void operationsRequestsHandling() {
        Window<OperationsRequestsController> viewWindow = new Window<>(SceneController.OPERATIONS_VIEW, SceneController.OPERATIONS_VIEW_WIDTH, SceneController.OPERATIONS_VIEW_HEIGHT, SceneController.OPERATIONS_VIEW_TITLE);
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


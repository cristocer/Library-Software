package tawelib;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.stage.Stage;
public class LibrarianDashboardController extends Controller{

    @FXML
    private ListView<String> resourcesList;
    @FXML
    private Text user_id;
    @FXML
    private VBox adminVBox;

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

    private void logoutHandling(){

        Stage stage = (Stage) adminVBox.getScene().getWindow();
        stage.close();
        try{stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(SceneController.LOGIN_SCREEN)), SceneController.LOGIN_WINDOW_WIDTH, SceneController.LOGIN_WINDOW_HEIGHT));
        stage.show();
        }
        catch (IOException e) {
                    e.printStackTrace();
                    // Quit the program (with an error code)
                    System.exit(-1);
            }
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
    @Override
    public void close(){
        System.exit(0);
    }
}


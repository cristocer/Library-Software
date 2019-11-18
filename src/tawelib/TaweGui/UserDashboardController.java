package tawelib.TaweGui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.stage.Stage;
public class UserDashboardController extends Controller{

    @FXML
    private ListView<String> resourcesList;
    @FXML
    private Text user_id;

    @FXML
    void logoutButton(ActionEvent event) {
        logoutHandling();
    }
    @FXML
    void viewResourceButton() {
        viewHandling();
    }
    @FXML
    void transactionHistoryButton(ActionEvent event) {
        transactionHandling();
    }
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


    private void viewHandling() {
        Window<ResourceViewController> viewWindow = new Window<>(SceneController.RESOURCE_VIEW, SceneController.RESOURCE_VIEW_WIDTH, SceneController.RESOURCE_VIEW_HEIGHT, SceneController.RESOURCE_VIEW_TITLE);
        viewWindow.show();
    }
    private void transactionHandling(){
        Window<TransactionController> transactionWindow = new Window<>(SceneController.TRANSACTION_WINDOW, SceneController.TRANSACTION_WINDOW_WIDTH, SceneController.TRANSACTION_WINDOW_HEIGHT, SceneController.TRANSACTION_WINDOW_TITLE);
        transactionWindow.show();
    }
    @Override
    public void close(){
        System.exit(0);
    }
}


package taweLib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DashboardController extends Controller{
    LoginController loginController;

    @FXML
    private ListView<String> resourcesList;
    @FXML
    private Text user_id;
    @FXML
    private VBox adminVBox;


    @FXML
    void adminButton(){ adminHandling(); }
    @FXML
    void logoutButton(ActionEvent event) {
        logoutHandling();
    }
    @FXML
    void transactionHistoryButton(ActionEvent event) {
        transactionHandling();
    }

    /**
     * Initializes the GUI, prompts user for Login...ToDO
     */
    public void initialize(){
        loginHandling();
        populateList();
    }

// Just until i can fetch from db
    private void populateList(){ // Just for testing
        for(int x=0; x<1000; x++){
            resourcesList.getItems().add("lol");
        }
    }

    private void loginHandling(){
        Window<LoginController> loginWindow = new Window<>("LoginScreen.fxml",250,250,"Login!");
        loginController = loginWindow.getFxmlLoader().getController();
        loginWindow.makeModal();
        loginWindow.showAndWait();

        if (!loginController.isAuthenticated()){
            close();
        }
        user_id.setText(loginController.getUser());
    }
    private void logoutHandling(){
        user_id.setText("nobody");
        disableAdmin();
        loginController.logout();
        loginHandling();
    }
    private void transactionHandling(){
        Window<TransactionController> transactionWindow = new Window<>("TransactionHistory.fxml",600,400,"Transaction History");
        transactionWindow.makeModal();
        transactionWindow.showAndWait();
    }
    private void adminHandling(){
        toggleAdmin();
    }
    private void toggleAdmin(){
        adminVBox.setDisable(!adminVBox.isDisable());
        adminVBox.setVisible(!adminVBox.isVisible());
    }
    private void disableAdmin(){
        adminVBox.setDisable(true);
        adminVBox.setVisible(false);
    }
    @Override
    public void close(){
        System.exit(0);
    }
}


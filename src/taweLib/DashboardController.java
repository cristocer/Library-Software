package taweLib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class DashboardController extends Controller{

    private LoginController loginController;
    @FXML
    private ListView<String> resourcesList;
    @FXML
    private Text user_id;

    @FXML
    void logoutButton(ActionEvent event) {
        logoutHandling();
    }
    @FXML
    void transactionHistoryButton(ActionEvent event) {
        viewTransactions();
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
        loginController.logout();
        loginHandling();
    }
    private void viewTransactions(){
        Window<TransactionController> transactionWindow = new Window<>("TransactionHistory.fxml",600,400,"Transaction History");
        transactionWindow.makeModal();
        transactionWindow.showAndWait();
    }

    @Override
    public void close(){
        System.exit(0);
    }
}


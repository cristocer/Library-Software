package taweLib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DashboardController {


    private LoginController loginController;

    @FXML
    private BorderPane borderPane;
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

    public void initialize(){
        loginHandling();
        populateList();
    }
    private void populateList(){ // Just for testing
        for(int x=0; x<1000; x++){
            resourcesList.getItems().add("lol");
        }
    }
    private void loginHandling(){ // Had issues converting this to use the new Window class. Due to the close function in the loginController.
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
            GridPane loginRoot = fxmlLoader.load();

            loginController = fxmlLoader.getController();

            Scene loginScene = new Scene(loginRoot, 250,250);

            Stage loginStage = new Stage();
            loginStage.setScene(loginScene);
            loginStage.setTitle("Login!");
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.showAndWait();
            if (!loginController.isAuthenticated()){
                close();
            }
            user_id.setText(loginController.getUser());
        }
        catch (Exception e){
            System.out.println("Login failed");
        }
    }
    private void logoutHandling(){
        user_id.setText("nobody");
        loginController.logout();
        loginHandling();
    }
    private void viewTransactions(){
        Window<TransactionController> transactionWindow = new Window<>("TransactionHistory.fxml",600,600,"Transcation History");
        transactionWindow.makeModal();
        transactionWindow.showAndWait();
    }
    private void close(){
        System.exit(0);
    }
}


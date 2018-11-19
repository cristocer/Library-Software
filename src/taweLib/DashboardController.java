package taweLib;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private ListView<String> resourcesList;

    @FXML
    private Text user_id;

    public void initialize(){
        loginHandling();
        populateList();
    }

    private void populateList(){
        for(int x=0; x<1000; x++){
            resourcesList.getItems().add("lol");
        }
    }
    private void loginHandling(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
            GridPane loginRoot = (GridPane)fxmlLoader.load();

            LoginController loginController = fxmlLoader.<LoginController>getController();

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

        }
    }

    private void close(){
        System.exit(0);
    }
}


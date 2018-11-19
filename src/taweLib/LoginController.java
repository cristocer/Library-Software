package taweLib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    private boolean authenticated;
    @FXML
    private TextField username_text;
    @FXML
    private GridPane rootPane;
    @FXML
    private Text wronguser_text;

    public LoginController(){
        authenticated = false;
    }

    @FXML
    void loginHandling(ActionEvent event) {
        String username = username_text.getText();
        if (authenticate(username)){
            authenticated = true;
            close();
        }
        else{
            wronguser_text.setText("Error: User doesn't exist!");
        }

    }
    private boolean authenticate(String username){
        if (username.equals("admin")){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isAuthenticated(){
        return authenticated;
    }
    public String getUser(){
        return username_text.getText();
    }
    private void close(){
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}

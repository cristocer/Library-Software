package taweLib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController extends Controller{
    private boolean authenticated;
    @FXML
    private TextField username_text;
    @FXML
    private GridPane rootPane;
    @FXML
    private Text wronguser_text;

    /**
     * Initiates the variables.
     */
    public LoginController(){
        authenticated = false;
    }

    /**
     * Handles login button press and Authenticates user.
     * @param event button press.
     */
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

    /**
     * Check if User is authentic
     * @return authenticity status.
     */
    public boolean isAuthenticated(){
        return authenticated;
    }

    /**
     * Get the username of user logging in.
     * @return
     */
    public String getUser(){
        return username_text.getText();
    }

    /**
     * Logout the user.
     */
    public void logout(){
        authenticated = false;
    }

}

package tawelib;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//there will be 2 separate dashboards each with it's own components and methods
//I say that 2 concise smaller classes are better than 1 big cluster
//plus it is easier to work  on a certain dashboard individually and we don't 
//have to deal with permissions (so far)
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
        if (authenticate(username)=="Librarian"){
            authenticated = true;
            SceneController.USER_USERNAME=username;
            openLibrarianDashboard();
        }
        else if(authenticate(username)=="User"){
            authenticated = true;
            SceneController.USER_USERNAME=username;
            openUserDashboard();
        }
        else if(authenticate(username)=="User"){
            wronguser_text.setText("Error: User doesn't exist!");
        }

    } 
    void openLibrarianDashboard(){
        try{Stage stage = (Stage) username_text.getScene().getWindow();
            username_text.getScene();
            stage.close();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RootDashboard.fxml")), 600, 600));
            stage.show();
            }
        catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
    }
    void openUserDashboard(){
        try{Stage stage = (Stage) username_text.getScene().getWindow();
            username_text.getScene();
            stage.close();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RootDashboard.fxml")), 600, 600));
            stage.show();
            }
        catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
    }    
    private String authenticate(String username){
        if (username.equals("admin")){
            return "Librarian";//query the database for input user
        }
        else if(username.equals("user")){
            return "User";
        }
        return "error";
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

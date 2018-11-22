package tawelib;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//SceneController was made for changing scenes but I ran out of time so,so far it is a resource class
//and I should call it global session variables
public class SceneController {
    
    public static final int LOGIN_WINDOW_WIDTH = 600;
    public static final int LOGIN_WINDOW_HEIGHT = 600;
    public static final String LOGIN_WINDOW_TITLE = "Login";
    public static final int DASHBOARD_WINDOW_WIDTH = 600;
    public static final int DASHBOARD_WINDOW_HEIGHT = 600;
    public static final String DASHBOARD_USER_WINDOW_TITLE = "Welcome User !";
    public static final String DASHBOARD_LIBRARIAN_WINDOW_TITLE = "Welcome Librarian !";    
    public static final String LOGIN_SCREEN="LoginScreen.fxml";
    public static String USER_USERNAME;   
    
}

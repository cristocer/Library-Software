package frontend;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import backend.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoginController extends Controller{
    private boolean authenticated;
    @FXML
    private TextField username_text;
    @FXML
    private GridPane rootPane;
    @FXML
    private Text wronguser_text;
    private boolean isLibrarian;
    /**
     * Initiates the variables.
     */
    public LoginController(){
        authenticated = false;
        isLibrarian = false; 
    }
    /**
     * Handles login button press and Authenticates user.
     * @param event button press.
     */
    @FXML
    void loginHandling(ActionEvent event) {
        String username = username_text.getText();
        authenticate(username);
        if (authenticated) {
            openDashboard();
        }
        else{
            wronguser_text.setText("Error: No user found");
        }
    } 
      private void openDashboard(){

        String dashboard, dashboardTitle;
        if (isLibrarian){ // if user is librarian.
            dashboard = SceneController.DASHBOARD_LIBRARIAN_WINDOW;
            dashboardTitle = SceneController.DASHBOARD_LIBRARIAN_WINDOW_TITLE;
        }
        else{ // if normal dashboard to be opened.
            dashboard = SceneController.DASHBOARD_USER_WINDOW;
            dashboardTitle = SceneController.DASHBOARD_USER_WINDOW_TITLE;
        }
        
        try{Stage stage = (Stage) username_text.getScene().getWindow();
            username_text.getScene();
            stage.close();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(dashboard)), SceneController.DASHBOARD_WINDOW_WIDTH, SceneController.DASHBOARD_WINDOW_HEIGHT));
            stage.setTitle(dashboardTitle);
            stage.show();
            }
        catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
    }
    private void authenticate(String username){ // Let the authenticity of the user be decided here.
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("From AccountBaseUser Where username = '" + username + "'");
        if (username.equals("admin")){
            isLibrarian=true;
            authenticated=true;
        }
        else if(username.equals("defaultuser")){
            isLibrarian=false;
            authenticated=true;
        }
        else if(query.uniqueResult() != null){
            Query queryLibrarian = session.createQuery("From Librarian Where username = '" + username + "'");
            if(queryLibrarian.uniqueResult() != null){
                isLibrarian = true;
            }
            else {
                isLibrarian = false;
            }
            authenticated=true;
        }
        else{
            authenticated=false;
        }
        session.close();
        SceneController.USER_USERNAME = username;  // TODO parse User to scenecontroller. Not just the name
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

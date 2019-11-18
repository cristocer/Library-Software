package tawelib.TaweGui;
import javafx.scene.control.Button;

import javafx.scene.input.KeyEvent;
import java.io.IOException; 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController extends Controller{
    private static final int EventType = 0;
	private boolean authenticated;
    @FXML
    private TextField id_text;
    @FXML
    private TextField password_text;
    @FXML
    private GridPane rootPane;
    @FXML
    private Text wronguser_text;
    @FXML
    private Button userType;
    @FXML
    private Button login;
    @FXML
    private Text title;

    private boolean isLibrarian;
    /**
     * Initiates the variables.
     */
    public LoginController(){
        authenticated = false;
        isLibrarian = true; 
    
    }   
    /**
     * Handles title toggle text .
     * @param event button press.
     */
    @FXML
    void switchUser(ActionEvent event) {
        if(isLibrarian) {
        	isLibrarian=false;
        	userType.setText("User");
        	title.setText("Tawe-Lib(User)");
        }else {
        	isLibrarian=true;
        	userType.setText("Librarian");
        	title.setText("Tawe-Lib(Librarian)");
        }
    }

    /**
     * Handles login button press and Authenticates user.
     * @param event button press.
     */
    @FXML
    void loginHandling(ActionEvent event1) {
        int  id = Integer.parseInt(id_text.getText());
        String  password = password_text.getText();
        authenticate(id,password);
        if (authenticated) {
            openDashboard();
        }
        else{
            wronguser_text.setText("Error: No user found");
        }
    } 
    /**
     * Handles login button press and Authenticates user.
     * @param event button press.
     * Still broken
     */
    @FXML
    void enterKeyPressed(ActionEvent event1) {
        int  id = Integer.parseInt(id_text.getText());
        String  password = password_text.getText();
        authenticate(id,password);
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
        
        try{Stage stage = (Stage) id_text.getScene().getWindow();
            id_text.getScene();
            stage.close();
            stage.setScene(new Scene((Parent) FXMLLoader.load(getClass().getResource(dashboard)), SceneController.DASHBOARD_WINDOW_WIDTH, SceneController.DASHBOARD_WINDOW_HEIGHT));
            stage.setTitle(dashboardTitle);
            stage.show();
            }
        catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
    }
      
    private void authenticate(int id,String password){ // Let the authenticity of the user be decided here.
        Session session = HibernateUtil.getSessionFactory().openSession();
        /*session.beginTransaction();
        Librarian newLibrarian = new Librarian(1,"JonnyB","Jonny","Bravo",07123213233,"SA34OP","images.default.png","12/01/2018","passMe");
        session.save(newLibrarian);
        User newUser = new User(2,"BobyR","Boby","Randy",0712223233,"SA34OP","images.default.png",500,"passMePlox");
        session.save(newUser);        
        session.getTransaction().commit();
        session.close();       
        session=HibernateUtil.getSessionFactory().openSession();*/
        session.beginTransaction();
        AccountBaseUser user;
        if(isLibrarian) {
        	user= (Librarian) session.get(Librarian.class, id);
        	isLibrarian=true;
        }else {
        	user = (User) session.get(User.class, id);
        	isLibrarian=false;
        }
        String passwordU="";
        try{
        	passwordU=user.getPassword();//If the user is not found at previous step,
        	//this will throw an error on screen at the end.
        	if (password.equals(passwordU)){
                authenticated=true;
            }else {
            	authenticated=false;
            }
        }catch(Exception e){
        	authenticated=false;
        }
    	session.getTransaction().commit();
        session.close();
        if(authenticated==true) {
        	SceneController.USER_USERNAME = String.valueOf(user.getUsername()); //ToDo parse User to scenecontroller. Not just the name
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
        return id_text.getText();
    }

    /**
     * Logout the user.
     */
    public void logout(){
        authenticated = false;
        
    }

}

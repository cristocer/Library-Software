package tawelib;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    
    // Login Window
    public static final String LOGIN_SCREEN="LoginScreen.fxml";
    public static final String LOGIN_WINDOW_TITLE = "Login";
    public static final int LOGIN_WINDOW_WIDTH = 250;
    public static final int LOGIN_WINDOW_HEIGHT = 250;

    //Dashboard
    public static final String DASHBOARD_USER_WINDOW = "UserDashboard.fxml";
    public static final String DASHBOARD_LIBRARIAN_WINDOW = "LibrarianDashboard.fxml";
    public static final int DASHBOARD_WINDOW_WIDTH = 600;
    public static final int DASHBOARD_WINDOW_HEIGHT = 600;
    public static final String DASHBOARD_USER_WINDOW_TITLE = "User Dashboard";
    public static final String DASHBOARD_LIBRARIAN_WINDOW_TITLE = "Librarian Dashboard";

    //Transaction Window
    public static final String TRANSACTION_WINDOW="TransactionHistory.fxml";
    public static final int TRANSACTION_WINDOW_HEIGHT = 300;
    public static final int TRANSACTION_WINDOW_WIDTH = 600;
    public static final String TRANSACTION_WINDOW_TITLE="Transaction History";

    //Resource View Window
    public static final String RESOURCE_VIEW="ViewResource.fxml";
    public static final int RESOURCE_VIEW_HEIGHT = 300;
    public static final int RESOURCE_VIEW_WIDTH = 600;
    public static final String RESOURCE_VIEW_TITLE="View Resource"; 
    
    //Create Resource Window
    public static final String CREATE_VIEW="CreateResource.fxml";
    public static final int CREATE_VIEW_HEIGHT = 400;
    public static final int CREATE_VIEW_WIDTH = 600;
    public static final String CREATE_VIEW_TITLE="Create Resource"; 
    
    //Edit Resource Window
    public static final String EDIT_VIEW="EditResource.fxml";
    public static final int EDIT_VIEW_HEIGHT = 400;
    public static final int EDIT_VIEW_WIDTH = 600;
    public static final String EDIT_VIEW_TITLE="Edit Resource"; 
    
    //Loan Resource Window
    public static final String LOAN_VIEW="LoanResource.fxml";
    public static final int LOAN_VIEW_HEIGHT = 400;
    public static final int LOAN_VIEW_WIDTH = 600;
    public static final String LOAN_VIEW_TITLE="Loan Resource"; 
    
    //Collect Resource Window
    public static final String COLLECT_VIEW="CollectResource.fxml";
    public static final int COLLECT_VIEW_HEIGHT = 400;
    public static final int COLLECT_VIEW_WIDTH = 600;
    public static final String COLLECT_VIEW_TITLE="Collect Resource"; 

    //Create User Window
    public static final String CREATE_USER="CreateUser.fxml";
    public static final int CREATE_USER_HEIGHT = 300;
    public static final int CREATE_USER_WIDTH= 600;
    public static final String CREATE_USER_TITLE="Create User";

    //View Profile Window
    public static final String VIEW_PROFILE = "ViewProfile.fxml";
    public static final int VIEW_PROFILE_HEIGHT = 300;
    public static final int VIEW_PROFILE_WIDTH = 600;
    public static final String VIEW_PROFILE_TITLE = "View Profile";


    public static String USER_USERNAME ; 

}

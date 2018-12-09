package frontend;

/**
 * LibrarianDashboardController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 03/12/2018
 * @author Alex Moras & Ryan Williams
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The SceneController class...
 */

public class SceneController {
    
    // Login Window
    public static final String LOGIN_SCREEN="/fxml/LoginScreen.fxml";
    public static final String LOGIN_WINDOW_TITLE = "Login";
    public static final int LOGIN_WINDOW_WIDTH = 250;
    public static final int LOGIN_WINDOW_HEIGHT = 250;

    //Dashboard
    public static final String DASHBOARD_USER_WINDOW = "/fxml/UserDashboard.fxml";
    public static final String DASHBOARD_LIBRARIAN_WINDOW = "/fxml/LibrarianDashboard.fxml";
    public static final int DASHBOARD_WINDOW_WIDTH = 600;
    public static final int DASHBOARD_WINDOW_HEIGHT = 600;
    public static final String DASHBOARD_USER_WINDOW_TITLE = "User Dashboard";
    public static final String DASHBOARD_LIBRARIAN_WINDOW_TITLE = "Librarian Dashboard";

    //Transaction Window
    public static final String TRANSACTION_WINDOW="/fxml/TransactionHistory.fxml";
    public static final int TRANSACTION_WINDOW_HEIGHT = 300;
    public static final int TRANSACTION_WINDOW_WIDTH = 600;
    public static final String TRANSACTION_WINDOW_TITLE="Transaction History";

    //Resource View Window
    public static final String RESOURCE_VIEW="/fxml/ViewResource.fxml";
    public static final int RESOURCE_VIEW_HEIGHT = 300;
    public static final int RESOURCE_VIEW_WIDTH = 600;
    public static final String RESOURCE_VIEW_TITLE="View Resource"; 
    
    //Create Resource Window
    public static final String CREATE_VIEW="/fxml/CreateResource.fxml";
    public static final int CREATE_VIEW_HEIGHT = 400;
    public static final int CREATE_VIEW_WIDTH = 600;
    public static final String CREATE_VIEW_TITLE="Create Resource"; 
    
    //Edit Resource Window
    public static final String EDIT_VIEW="/fxml/EditResource.fxml";
    public static final int EDIT_VIEW_HEIGHT = 400;
    public static final int EDIT_VIEW_WIDTH = 750;
    public static final String EDIT_VIEW_TITLE="Edit Resource"; 
    
    //Create Copy Window
    public static final String CREATEC_VIEW="/fxml/CreateCopy.fxml";
    public static final int CREATEC_VIEW_HEIGHT = 400;
    public static final int CREATEC_VIEW_WIDTH = 750;
    public static final String CREATEC_VIEW_TITLE="Create Copy"; 
    
    //Operations Resource Window
    public static final String OPERATIONS_VIEW="/fxml/OperationsRequests.fxml";
    public static final int OPERATIONS_VIEW_HEIGHT = 360;
    public static final int OPERATIONS_VIEW_WIDTH = 666;
    public static final String OPERATIONS_VIEW_TITLE="Operations on Requests";
    

    //Create User Window
    public static final String CREATE_USER="/fxml/CreateUser.fxml";
    public static final int CREATE_USER_HEIGHT = 300;
    public static final int CREATE_USER_WIDTH= 600;
    public static final String CREATE_USER_TITLE="Create User";

    //View Profile Window
    public static final String VIEW_PROFILE = "/fxml/ViewProfile.fxml";
    public static final int VIEW_PROFILE_HEIGHT = 300;
    public static final int VIEW_PROFILE_WIDTH = 600;
    public static final String VIEW_PROFILE_TITLE = "View Profile";

    public static final String EDIT_PROFILE = "/fxml/EditProfile.fxml";
    public static final int EDIT_PROFILE_HEIGHT = 300;
    public static final int EDIT_PROFILE_WIDTH = 600;
    public static final String EDIT_PROFILE_TITLE = "Edit Profile";

    public static String USER_USERNAME ;
    public static String SELECTED_RESOURCE;

}

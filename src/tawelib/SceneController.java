package tawelib;

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
    public static final int EDIT_VIEW_WIDTH = 750;
    public static final String EDIT_VIEW_TITLE="Edit Resource"; 
    
    //Create Copy Window
    public static final String CREATEC_VIEW="CreateCopy.fxml";
    public static final int CREATEC_VIEW_HEIGHT = 400;
    public static final int CREATEC_VIEW_WIDTH = 750;
    public static final String CREATEC_VIEW_TITLE="Create Copy"; 
    
    //Operations Resource Window
    public static final String OPERATIONS_VIEW="OperationsRequests.fxml";
    public static final int OPERATIONS_VIEW_HEIGHT = 360;
    public static final int OPERATIONS_VIEW_WIDTH = 666;
    public static final String OPERATIONS_VIEW_TITLE="Operations on Requests";
    

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

    //Edit Profile Window
    public static final String EDIT_PROFILE = "EditProfile.fxml";
    public static final int EDIT_PROFILE_HEIGHT = 300;
    public static final int EDIT_PROFILE_WIDTH = 600;
    public static final String EDIT_PROFILE_TITLE = "Edit Profile";

    //Edit Profile Image Window
    public static final String CHOOSE_PROFILE_IMAGE = "ChooseProfileImage.fxml";
    public static final String CHOOSE_PROFILE_IMAGE_TITLE = "Choose Profile Image";
    public static final int CHOOSE_PROFILE_IMAGE_HEIGHT = 475;
    public static final int CHOOSE_PROFILE_IMAGE_WIDTH = 550;

    //Draw Profile Image Window
    public static final String DRAW_PROFILE = "DrawProfileImage.fxml";
    public static final String DRAW_PROFILE_TITLE = "Draw Profile";
    public static final int DRAW_PROFILE_HEIGHT = 350;
    public static final int DRAW_PROFILE_WIDTH = 300;

    public static String USER_USERNAME ;
    public static String currentProfileImagePath = "file:profilepics/default.png";

}

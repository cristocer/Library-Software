package tawelib.TaweGui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//main class
public class TaweLib extends Application {
	

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(SceneController.LOGIN_SCREEN));
        primaryStage.setTitle(SceneController.LOGIN_WINDOW_TITLE);
        primaryStage.setScene(new Scene(root,SceneController.LOGIN_WINDOW_WIDTH, SceneController.LOGIN_WINDOW_HEIGHT));
        primaryStage.show();
       
        
        
        primaryStage.setOnCloseRequest(e -> {
            
            System.exit(0);
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
        launch(args);
        
    }
    
}

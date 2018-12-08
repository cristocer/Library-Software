package frontend;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Controller.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author Alex Moras & Ryan Williams
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The Controller class sets up and controls the window and other conditions necessary
 * for the application and its subclasses.
 */

public abstract class Controller{
    @FXML
    public Pane rootPane;
    /**
     * Close the window.
     */
    public void close(){
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
    public void viewProfileHandling(){
        Window viewProfile = new Window(SceneController.VIEW_PROFILE,SceneController.VIEW_PROFILE_WIDTH,SceneController.VIEW_PROFILE_HEIGHT,SceneController.VIEW_PROFILE_TITLE);
        viewProfile.show();
    }
    public void logoutHandling(){
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
        try{stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(SceneController.LOGIN_SCREEN)), SceneController.LOGIN_WINDOW_WIDTH, SceneController.LOGIN_WINDOW_HEIGHT));
        stage.show();
        }
        catch (IOException e) {
                e.printStackTrace();
                // Quit the program (with an error code)
                System.exit(-1);
        }
    }
}

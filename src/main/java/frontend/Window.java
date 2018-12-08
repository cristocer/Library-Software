package frontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Window.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author Alex Moras & Ryan Williams
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The Window class creates and manages a window to display the application in.
 */

//Simplifies creating new windows. Removes a stupid amount of redundant code.
public class Window<Controller> {
    private FXMLLoader fxmlLoader;	//Creates a loader for fxml.
    private Controller controller;	//Creates a controller to be used in the application.
    private Stage stage;			//Creates a stage for JavaFX.

    /**
     * Creates a javaFx stage ready for display.
     * @param fxml FXML file to use.
     * @param width Width of window.
     * @param height Height of window.
     * @param title Title of window.
     */
    public Window(String fxml, int width, int height, String title){
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            controller = fxmlLoader.getController();

            Scene scene = new Scene(fxmlLoader.load(),width,height);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
        }
        catch (Exception e){
            System.out.println("Creating new Window failed.");
        }

    }

    /**
     * Displays the window.
     */
    public void show(){
        stage.show();
    }

    /**
     * Displays the window and waits for return.
     */
    public void showAndWait(){
        stage.showAndWait();
    }

    /**
     * Make the window Modal.
     */
    public void makeModal(){
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    /**
     * Closes the window.
     */
    public void close(){
        stage.close();
    }

    /**
     * Get the FXMLLoader of the window.
     * @return FXMLLoader
     */
    public FXMLLoader getFxmlLoader(){
        return fxmlLoader;
    }

    /**
     * Get the Controller class of the window.
     * @return Controller class of window.
     */
    public Controller getController(){
        return controller;
    }
}

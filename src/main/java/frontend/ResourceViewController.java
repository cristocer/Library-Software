package frontend;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * ResourceViewController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The ResourceViewController class is a subclass of the class Controller. This class is used to
 * manage displaying information on a resource within the libraries' database.
 */

public class ResourceViewController extends Controller{
    @FXML
    private ListView<String> resourceDetails;	//A list of the resources' information.
    @FXML
    private ImageView resourceImage;	//An ImageView of the appropriate resources' thumbnail image.
    
    /**
     * A method called when the user presses the done button.
     */
    @FXML
    void doneButton(){
        doneHandling();
    }
    
    /**
     * Calls the methods necessary to populate the GUI with the resources' information.
     */
    public void initialize(){
        // Purely for testing purposes.
        Image image = null;
        try {
            image = new Image("file:testpic.png");
        }
        catch (Exception e){
            System.exit(-1);
        }
        resourceImage.setImage(image);
        resourceDetails.getItems().add("test");
    }

    /**
     * Closes the resources' information when the user is finished.
     */
    private void doneHandling(){
        close();
    }
}
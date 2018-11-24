package tawelib;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ResourceViewController extends Controller{
    @FXML
    private ListView<String> resourceDetails;
    @FXML
    private ImageView resourceImage;
    @FXML
    void doneButton(){
        doneHandling();
    }
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


    private void doneHandling(){
        close();
    }
}
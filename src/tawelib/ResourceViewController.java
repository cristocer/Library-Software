package tawelib;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ResourceViewController {
    @FXML
    private ListView<String> resourceDetails;
    @FXML
    private Button doneButton;
    @FXML
    private ImageView resourceImage;


    public void initialize(){
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

}
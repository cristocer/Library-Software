package tawelib;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChooseProfileImageController extends Controller{
    private final String DEFAULT = "file:profilepics/default.png";
    private final String DEFAULT_1 = "file:profilepics/default1.png";
    private final String DEFAULT_2 = "file:profilepics/default2.png";
    private final String DEFAULT_3 = "file:profilepics/default3.png";
    private final String DEFAULT_4 = "file:profilepics/default4.png";


    @FXML
    private ImageView selectedImage;
    @FXML
    private ImageView d1;
    @FXML
    private ImageView d2;
    @FXML
    private ImageView d3;
    @FXML
    private ImageView d4;

    public void initialize(){
        setup();
    }
    @FXML
    void chooseD1() {
        selectedImage.setImage(d1.getImage());
        SceneController.currentProfileImagePath = DEFAULT_1;
    }

    @FXML
    void chooseD2() {
        selectedImage.setImage(d2.getImage());
        SceneController.currentProfileImagePath = DEFAULT_2;
    }

    @FXML
    void chooseD3() {
        selectedImage.setImage(d3.getImage());
        SceneController.currentProfileImagePath = DEFAULT_3;
    }

    @FXML
    void chooseD4() {
        selectedImage.setImage(d4.getImage());
        SceneController.currentProfileImagePath = DEFAULT_4;
    }
    @FXML
    void doneB() {
        close();
    }

    @FXML
    void resetB() {
        reset();
    }

    private void setup(){
        reset();
        d1.setImage(new Image(DEFAULT_1));
        d2.setImage(new Image(DEFAULT_2));
        d3.setImage(new Image(DEFAULT_3));
        d4.setImage(new Image(DEFAULT_4));
    }
    private void reset(){
        selectedImage.setImage(new Image(DEFAULT));
        SceneController.currentProfileImagePath = DEFAULT;
    }

}

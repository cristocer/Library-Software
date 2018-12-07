package tawelib;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChooseProfileImageController {
    private String imagePath;
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
    void chooseD1(MouseEvent event) {
        selectedImage.setImage(d1.getImage());
    }

    @FXML
    void chooseD2(MouseEvent event) {
        selectedImage.setImage(d2.getImage());
    }

    @FXML
    void chooseD3(MouseEvent event) {
        selectedImage.setImage(d3.getImage());
    }

    @FXML
    void chooseD4(MouseEvent event) {
        selectedImage.setImage(d4.getImage());
    }


    private void setup(){
//        d1.setImage(new Image("profilepics/default1.png"));
//        d2.setImage(new Image("profilepics/default1.png"));
//        d3.setImage(new Image("profilepics/default1.png"));
//        d4.setImage(new Image("profilepics/default1.png"));
    }
}

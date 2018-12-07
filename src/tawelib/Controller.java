package tawelib;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public abstract class Controller{
    @FXML
    public ImageView imageField; // to prevent duplicate code. Can be removed and the profile image handling moved to create user and edit user.
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

    public void drawImageHandling(){
        Window<DrawProfileImageController> drawProfile = new Window<>(SceneController.DRAW_PROFILE,SceneController.DRAW_PROFILE_WIDTH,SceneController.DRAW_PROFILE_HEIGHT,SceneController.DRAW_PROFILE_TITLE);
        drawProfile.showAndWait();
        imageField.setImage(new Image(SceneController.imagePath));
    }
    public void chooseImageHandling(){
        Window<ChooseProfileImageController> chooseProfileImage = new Window<>(SceneController.CHOOSE_PROFILE_IMAGE,SceneController.CHOOSE_PROFILE_IMAGE_WIDTH,SceneController.CHOOSE_PROFILE_IMAGE_HEIGHT,SceneController.CHOOSE_PROFILE_IMAGE_TITLE);
        chooseProfileImage.showAndWait();
        imageField.setImage(new Image(SceneController.imagePath));
    }
}

package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ViewProfileController extends Controller{

    @FXML
    private GridPane rootPane;

    @FXML
    private ImageView imageField;

    @FXML
    private VBox attributeVBox;

    @FXML
    private ListView<?> profileInfo;

    @FXML
    private HBox profileHBox;

    @FXML
    void editProfileButton(ActionEvent event) {
        editProfileHandling();
    }
    @FXML
    void doneButton(){
        close();
    }

    public void editProfileHandling(){
        Window editProfileWindow = new Window(SceneController.EDIT_PROFILE,SceneController.EDIT_PROFILE_WIDTH,SceneController.EDIT_PROFILE_HEIGHT,SceneController.EDIT_PROFILE_TITLE);
        editProfileWindow.makeModal();
        editProfileWindow.showAndWait();
    }
}


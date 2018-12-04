package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ViewProfileController {

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

    }

}


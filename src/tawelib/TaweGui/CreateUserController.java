package tawelib.TaweGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CreateUserController extends Controller{

    @FXML
    private ImageView imageField;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField telephoneField;

    @FXML
    private TextField addressField;

    @FXML
    private CheckBox librarianCheckbox;

    @FXML
    private VBox librarianFields;

    @FXML
    private TextField employmentField;

    @FXML
    void chooseImage(ActionEvent event) {

    }

    @FXML
    void drawImage(ActionEvent event) {
        drawImageHandling();
    }

    @FXML
    void showLibrarianFields(ActionEvent event) {
        toggleLibrarian();
    }

    @FXML
    void submitFormButton(){
        submitHandling();
    }



    private void toggleLibrarian(){
        librarianFields.setDisable(!librarianFields.isDisabled());
        librarianFields.setVisible(!librarianFields.isVisible());
    }

    //ToDo - Chris to implement draw profile picture method here. have it return an Image if possible aswell as saving it.
    private Image drawImageHandling(){
        return null;
    }

    private void submitHandling(){
        close();
    }
}

package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditProfileController extends Controller{
    private String imagePath; // Path to be store in DB under this attribute.

    @FXML
    private GridPane rootPane;

    @FXML
    private ImageView imageField;

    @FXML
    private VBox attributeVBox;

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
    private VBox librarianFields;

    @FXML
    private TextField employmentField;

    @FXML
    private HBox profileHBox;

    @FXML
    void chooseImage(ActionEvent event) {
        chooseImageHandling();
    }

    @FXML
    void drawImage(ActionEvent event) {
        drawImageHandling();
    }

    @FXML
    void editProfileButton(ActionEvent event) {editProfileHandling(); }
    @FXML
    void cancelButton(){cancelHandling(); }

    public void initialize(){
        isLibrarian();
    }

    public void isLibrarian(){
        //If user is librarian make employment date visible.
    }
    public void editProfileHandling(){
        // Submit Form.
        close();
    }
    public void cancelHandling(){
        close();
    }
}

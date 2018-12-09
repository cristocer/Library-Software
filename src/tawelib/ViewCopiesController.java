package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ViewCopiesController {
    private backend.Copies selectedCopy;
    @FXML
    private GridPane rootPane;
    @FXML
    private TextField userIDBox;
    @FXML
    private ListView<backend.Copies> copiesList;

    @FXML
    private ImageView resourceImage;

    @FXML
    void doneButton(ActionEvent event) {

    }
    @FXML
    void loanB(){
        selectedCopy = copiesList.getSelectionModel().getSelectedItem();

    }


    public void initialize(){
        //Selected resource assigned to static variable in scene controller. So same as viewResource but fetch copies.
    }
}

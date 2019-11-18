package tawelib.TaweGui;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class TransactionController extends Controller{

    @FXML
    private GridPane rootPane;
    @FXML
    private ListView<String> transactionList;
    @FXML
    void backButton(){
        close();
    }

    public void initialize(){
        populateList();
    }

    private void populateList(){ // Just for testing
        for(int x=0; x<1000; x++){

            transactionList.getItems().add("lol");
        }
    }
}
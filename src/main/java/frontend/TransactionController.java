package frontend;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

/**
 * Transaction.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author Alex Moras & Ryan Williams
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The TransactionController class is a subclass of the class Controller. This class creates and manages the 
 * list that holds data on all the transactions a user class has made.
 */

public class TransactionController extends Controller{

    @FXML
    private GridPane rootPane;	//Creates a GridPane for displaying the transaction screen.
    @FXML
    private ListView<String> transactionList;	//Creates a list of all the user's transactions.
    
    /**
     * Used to create button to leave the transaction history screen.
     */
    @FXML
    void backButton(){
        close();
    }

    /**
     * Method used to initialise the transaction history GUI.
     */
    public void initialize(){
        populateList();
    }

    /**
     * Used to add all the items from the users' transaction history to the transaction list.
     */
    private void populateList(){ // Just for testing
        for(int x=0; x<1000; x++){

            transactionList.getItems().add("lol");
        }
    }
}
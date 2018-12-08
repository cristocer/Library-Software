package tawelib;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;

public class OperationsRequestsController extends Controller{

    @FXML
    private ListView<bob> listOfRequests;//list with the requests (loan someone a copy of a resource, somebody came to collect or return it)
    @FXML
    private TextField textID;//the search field
    @FXML
    private TextField userID;//the id of user you want to loan sth
    @FXML
    private TextField copyID;//the id of copy you want to loan to sth
    @FXML
    private Text user;
    @FXML
    private Text copy;
    
    @FXML
    void searchID(){
        searchHandling(); 
    }
    @FXML
    void createL(){//approve a loan 
        //createHandling(); 
    }
    @FXML
    void collectL(){//collect a loan
        //collectHandling(); 
    }
    @FXML
    void returnL(){//return a loan
        //returnHandling(); 
    }
    @FXML
    void cancelButton(){
        close();
    }
    @FXML
    private Text incompleteMessage;
    public void initialize(){
        
        incompleteMessage.setVisible(false);
        /*for(int i=0; i < 1000; i++){
            listOfRequests.getItems().add("lol"+Integer.toString(i));
        }*/
        
        //test Class bob will be either the request class or String
        bob test=new bob();
        listOfRequests.getItems().add(test);//requests/String returned by db
        //System.out.print(listOfRequests.getFocusModel().getFocusedItem());
        
        //the reason I am debating regarding if the request will be an object or a string is that I don't know 
        //how is easier to have a request class to take request.getID() or from the request String extract the ID
        //with like request.subSequence(0,request.indexOf(' '));

    }
    
    void searchHandling(){
        //query the database by textID.getText() for the requests of the student's ID
        //put all the requests in the listOfRequests with 
        //listOfRequests.getItems().add(request);        
    }
    void createHandling(){
        if(userID.getText().compareTo("")==0 || copyID.getText().compareTo("")==0 ){
          incompleteMessage.setVisible(true);     
          }else{
             //creare in the db a request using the userID.getText() and copyID.getTExt()
          }
    //close();         
        
    }
    void collectHandling(){
        //listOfRequests.getFocusModel().getFocusedItem()
        //get the id from the string/object above and update the database with the loan status of the request as being collected
        //plus other operations regarding the database (like update the resource due data or sth)
        //close();
    }
    void returnHandling(){
         //listOfRequests.getFocusModel().getFocusedItem()
        //get the id from the string/object above and update the database with the loan status of the request as being returned
        //plus other operations regarding the database (like the resource is available to be loaned)
        //close(); 
    }

}
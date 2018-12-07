package frontend;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;

public class CreateCopyController extends Controller{

    @FXML
    private RadioButton book;
    @FXML
    private RadioButton DVD;
    @FXML
    private RadioButton laptop;
    
    @FXML
    private ListView<String> listOfCopies;//list with the available copies to edit
    @FXML
    void addButton(){
        addHandling(); 
    }
    @FXML
    void cancelButton(){
        close();
    }
   
    private int copy;
    @FXML
    private Text invalidMessage;
    @FXML
    private Text incompleteMessage;
    //reset the individual text and textfields
    void reset(){    
        invalidMessage.setVisible(false);
        incompleteMessage.setVisible(false);
        copy =0;

    }
        @FXML
    void createLaptop(){
        reset();        
        copy=1;
        refreshList();
        
    }
    @FXML
    void createDVD(){
        reset();
        copy=2;
        refreshList();
       
    }
    @FXML
    void createBook(){
        reset();
        copy=3;
        refreshList();
       
    }
    public void initialize(){
        
        
        for(int i=0; i < 1000; i++){
            listOfCopies.getItems().add("lol"+Integer.toString(i));
        }
        copy=0;
        ToggleGroup group = new ToggleGroup();
        book.setToggleGroup(group);
        DVD.setToggleGroup(group);
        laptop.setToggleGroup(group);
        reset();        
                
    }
    private void refreshList(){
        if(copy==1){
            //query laptop db of resources
        }else if(copy==2){
            //query DVD db of resources
        }else if(copy==3){
            //query book db of resources
        }
        //a select query to db that will return a list of objects of subtype of resource(laptop,book,dvd)
        //this list will be put in the listView.
        //We will also need the Id of the resource so we can reference it when we change it back into the database.
        //we may need to override toString method for every resource so we can display them as strings,unless the query
        //will return string objects which i doubt
        //then we simply use add() method./or the normal way from below
        //resourceID=id from db
        
        
        
        //a possible alternative
        //ObservableList<String> names = FXCollections.observableArrayList(
        //  "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        //listOfResources = new ListView<String>(names);
    }
    private int resourceID;
    private void addHandling(){
        
       invalidMessage.setVisible(false);
       incompleteMessage.setVisible(false);
       if(copy==0){
           invalidMessage.setVisible(true);
       }else if(copy==1){//laptop
           if(listOfCopies.getFocusModel().getFocusedItem()==null){
           incompleteMessage.setVisible(true);   
           }else{
               // System.out.print(resourcesList.getFocusModel().getFocusedItem());//return the item focused in the list to get the id
               //an update table query to the database with the resourceId to reference the resource of which copy to be created
           }
       }else if(copy==2){//dvd
           if(listOfCopies.getFocusModel().getFocusedItem()==null){
           incompleteMessage.setVisible(true);     
           }else{
               // System.out.print(resourcesList.getFocusModel().getFocusedItem());//return the item focused in the list to get the id
               //an update table query to the database with the resourceId to reference the resource of which copy to be created
           }
       }else if(copy==3){//book
           if(listOfCopies.getFocusModel().getFocusedItem()==null){
           incompleteMessage.setVisible(true);     
           }else{
               // System.out.print(resourcesList.getFocusModel().getFocusedItem());//return the item focused in the list to get the id
               //an update table query to the database with the resourceId to reference the resource of which copy to be created
           }
       }
       refreshList();
    }
}

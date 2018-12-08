package frontend;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;

/**
 * CreateCopyController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The CreateCopyController class is a subclass of the class Controller and 
 * is used to create a copy of a resource via a librarian account's GUI.
 */

public class CreateCopyController extends Controller{

    @FXML
    private RadioButton book;	//Book RadioButton used in the GUI.
    @FXML
    private RadioButton DVD;	//DVD RadioButton used in the GUI.
    @FXML
    private RadioButton laptop;	//Laptop RadioButton used in the GUI.
    
    @FXML
    private ListView<String> listOfCopies;	//list with the available copies to edit
    
    /**
     * Method used to add a button to the GUI.
     */
    @FXML
    void addButton(){
        addHandling(); 
    }
    
    /**
     * Method used to remove a button from the GUI.
     */
    @FXML
    void cancelButton(){
        close();
    }
   
    private int copy;	//Variable used to track the kind of copy created.
    @FXML
    private Text invalidMessage;	//Message used in the case of an invalid action.
    @FXML
    private Text incompleteMessage;	//Message used in the case of an incomplete action.
    
    /**
     * Method used to reset the individual text and textfields.
     */
    void reset(){    
        invalidMessage.setVisible(false);
        incompleteMessage.setVisible(false);
        copy =0;

    }
    
    /**
     * Method used when Laptop resource copy is being created.
     */
    @FXML
    void createLaptop(){
        reset();        
        copy=1;
        refreshList();
        
    }
    
    /**
     * Method used when DVD resource copy is being created.
     */
    @FXML
    void createDVD(){
        reset();
        copy=2;
        refreshList();
       
    }
    
    /**
     * Method used when Book resource copy is being created.
     */
    @FXML
    void createBook(){
        reset();
        copy=3;
        refreshList();
       
    }
    
    /**
     * Method used to initialise the create a copy GUI.
     */
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
    
    /**
     * Method used to refresh the list of copies of resources.
     */
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
    private int resourceID;		//Unique ID of the resource.
    
    /**
     * Method used to maintain and control the create copy GUI used by the librarian accounts.
     */
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

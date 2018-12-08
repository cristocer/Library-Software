package frontend;

/**
 * EditResourcesController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 03/12/2018
 * @author Alex Moras & Ryan Williams
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The EditResourcesController class is a subclass of the class Controller. This class is used 
 * to edit information on Resources already owned by the library.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;

public class EditResourceController extends Controller{

	@FXML
    private RadioButton book;	//Book RadioButton used in the GUI.
    @FXML
    private RadioButton DVD;	//DVD RadioButton used in the GUI.
    @FXML
    private RadioButton laptop;	//Laptop RadioButton used in the GUI.
    @FXML
    private TextField title;	//Title TextField to be used in creating a resource via the GUI.
    @FXML
    private TextField year;		//Year TextField to be used in creating a resource via the GUI.
    @FXML
    private TextField os;		//OS TextField to be used in creating a laptop resource via the GUI.
    @FXML
    private TextField manufacturer;	//Manufacturer TextField to be used in creating a laptop resource via the GUI.
    @FXML
    private TextField image;	//Image TextField to be used in creating a resource via the GUI.
    @FXML
    private TextField model;	//Model TextField to be used in creating a laptop resource via the GUI.
    @FXML
    private Text modelT;	//Model Text to be used in creating a laptop resource via the GUI.
    @FXML
    private Text osT;	//Os Text to be used in creating a laptop resource via the GUI.
    @FXML
    private Text manufacturerT;	//Manufacturer Text to be used in creating a laptop resource via the GUI.
    @FXML
    private Text publisherT;	//Publisher Text to be used in creating a Book resource via the GUI.
    @FXML
    private TextField publisher;	//Publisher TextField to be used in creating a Book resource via the GUI.
    @FXML
    private Text isbnT;		//Isbn Text to be used in creating a Book resource via the GUI.
    @FXML
    private TextField isbn;    //Isbn TextField to be used in creating a Book resource via the GUI.
    @FXML
    private TextField author;	//Author TextField to be used in creating a Book resource via the GUI.
    @FXML
    private Text authorT;	//Author Text to be used in creating a Book resource via the GUI.
    @FXML
    private TextField language;	//Language TextField to be used in creating a Book resource via the GUI.
    @FXML
    private Text languageT;	//Language Text to be used in creating a Book resource via the GUI.
    @FXML
    private TextField genre;	//Genre TextField to be used in creating a DVD resource via the GUI.
    @FXML
    private Text genreT;	//Genre Text to be used in creating a DVD resource via the GUI.
    @FXML
    private TextField director;	//Director TextField to be used in creating a DVD resource via the GUI.
    @FXML
    private TextField runTime;	//Runtime TextField to be used in creating a DVD resource via the GUI.
    @FXML
    private TextField languageD;	//Language TextField to be used in creating a DVD resource via the GUI.
    @FXML
    private TextField subtitleLanguage;	//SubtitleLanguage TextField to be used in creating a DVD resource via the GUI.
    @FXML
    private Text directorT;	//Director Text to be used in creating a DVD resource via the GUI.
    @FXML
    private Text runTimeT;	//Runtime Text to be used in creating a DVD resource via the GUI.
    @FXML
    private Text languageDT;	//Language Text to be used in creating a DVD resource via the GUI.
    @FXML
    private Text subtitleLanguageT;	//SubtitleLanguage Text to be used in creating a DVD resource via the GUI.
    @FXML
    private ListView<String> listOfResources;//list with the available resource to edit.
    
    /**
     * A method called when the user presses the edit button.
     */
    @FXML
    void editButton(){
        editHandling(); 
    }
    
    /**
     * A method called when the user presses the cancel button. This method closes
     * the edit resource menu.
     */
    @FXML
    void cancelButton(){
        close();
    }
    
    /**
     * Method used in creating a laptop resource via the GUI.
     */
    @FXML
    void createLaptop(){
        reset();        
        resource=1;
        refreshList();
        os.setVisible(true);
        manufacturer.setVisible(true);
        model.setVisible(true);
        modelT.setVisible(true);
        osT.setVisible(true);
        manufacturerT.setVisible(true);
        
    }
    
    /**
     * Method used in creating a DVD resource via the GUI.
     */
    @FXML
    void createDVD(){
        reset();
        resource=2;
        refreshList();
        director.setVisible(true);
        runTime.setVisible(true);
        languageD.setVisible(true);
        subtitleLanguage.setVisible(true);
        directorT.setVisible(true);
        runTimeT.setVisible(true);
        languageDT.setVisible(true);
        subtitleLanguageT.setVisible(true);
       
    }
    
    /**
     * Method used in creating a Book resource via the GUI.
     */
    @FXML
    void createBook(){
        reset();
        resource=3;
        refreshList();
        publisher.setVisible(true);
        isbn.setVisible(true);
        language.setVisible(true);
        author.setVisible(true);
        genre.setVisible(true);
        publisherT.setVisible(true);
        isbnT.setVisible(true);
        languageT.setVisible(true);
        authorT.setVisible(true);
        genreT.setVisible(true);
        
    }
    private int resource;	//Variable used to track the kind of resource created.
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
        resource =0;
        os.setVisible(false);
        manufacturer.setVisible(false);
        model.setVisible(false);
        modelT.setVisible(false);
        osT.setVisible(false);
        manufacturerT.setVisible(false);
        director.setVisible(false);
        runTime.setVisible(false);
        languageD.setVisible(false);
        subtitleLanguage.setVisible(false);
        directorT.setVisible(false);
        runTimeT.setVisible(false);
        languageDT.setVisible(false);
        subtitleLanguageT.setVisible(false);
        publisher.setVisible(false);
        isbn.setVisible(false);
        language.setVisible(false);
        author.setVisible(false);
        genre.setVisible(false);
        publisherT.setVisible(false);
        isbnT.setVisible(false);
        languageT.setVisible(false);
        authorT.setVisible(false);
        genreT.setVisible(false);
    }
    
    /**
     * Method used to initialise the create a resource GUI.
     */
    public void initialize(){
        
        
        for(int i=0; i < 1000; i++){
            listOfResources.getItems().add("lol"+Integer.toString(i));
        }
        resource=0;
        ToggleGroup group = new ToggleGroup();
        book.setToggleGroup(group);
        DVD.setToggleGroup(group);
        laptop.setToggleGroup(group);
        title.setVisible(true);
        year.setVisible(true);
        image.setVisible(true);
        reset();        
                
    }
    
    /**
     * Method used to refresh the list of available resources.
     */
    private void refreshList(){
        if(resource==1){
            //query laptop db
        }else if(resource==2){
            //query DVD db
        }else if(resource==3){
            //query book db
        }
        //a select query to db that will return a list of objects of subtype of resource(laptop,book,dvd)
        //from which we can extract the attributes that can be changed.
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
    private int resourceID;	//Identification number unique to the resource.
    
    /**
     * Method used to maintain and control the edit resource GUI used by the librarian accounts.
     */
    private void editHandling(){
        
       invalidMessage.setVisible(false);
       incompleteMessage.setVisible(false);  
       if(resource==0){
           invalidMessage.setVisible(true);
       }else if(resource==1){//laptop
           if(title.getText().compareTo("")==0 || year.getText().compareTo("")==0 || image.getText().compareTo("")==0 || os.getText().compareTo("")==0 || 
                   manufacturer.getText().compareTo("")==0|| model.getText().compareTo("")==0){
           incompleteMessage.setVisible(true);   
           }else{
               // System.out.print(resourcesList.getFocusModel().getFocusedItem());//return the item focused in the list to get the id
               //an update table query to the database with the resourceId to reference the resource to be changed and the parameters (year.getText(),title.getText(),image.getText()==""..)
           }
       }else if(resource==2){//dvd
           if(title.getText().compareTo("")==0 || year.getText().compareTo("")==0 || image.getText().compareTo("")==0 || director.getText().compareTo("")==0
                   || runTime.getText().compareTo("")==0 || languageD.getText().compareTo("")==0 || subtitleLanguage.getText().compareTo("")==0){
           incompleteMessage.setVisible(true);     
           }else{
               // System.out.print(resourcesList.getFocusModel().getFocusedItem());//return the item focused in the list to get the id
               //an update table query to the database with the resourceId to reference the resource to be changed and the parameters (year.getText(),title.getText(),image.getText()==""..)
           }
       }else if(resource==3){//book
           if(title.getText().compareTo("")==0 || year.getText().compareTo("")==0 || image.getText().compareTo("")==0 || publisher.getText().compareTo("")==0
                   || isbn.getText().compareTo("")==0|| language.getText().compareTo("")==0|| author.getText().compareTo("")==0|| genre.getText().compareTo("")==0){
           incompleteMessage.setVisible(true);     
           }else{
               // System.out.print(resourcesList.getFocusModel().getFocusedItem());//return the item focused in the list to get the id
               //an update table query to the database with the resourceId to reference the resource to be changed and the parameters (year.getText(),title.getText(),image.getText()==""..)
           }
       }
       refreshList();
    }
}

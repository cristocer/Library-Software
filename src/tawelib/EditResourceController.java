package tawelib;

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
    private RadioButton book;
    @FXML
    private RadioButton DVD;
    @FXML
    private RadioButton laptop;
    @FXML
    private TextField title;
    @FXML
    private TextField year;
    @FXML
    private TextField os;
    @FXML
    private TextField manufacturer;
    @FXML
    private TextField image;
    @FXML
    private TextField model;
    @FXML
    private Text modelT;
    @FXML
    private Text osT;
    @FXML
    private Text manufacturerT;
    @FXML
    private Text publisherT;
    @FXML
    private TextField publisher;
    @FXML
    private Text isbnT;
    @FXML
    private TextField isbn;    
    @FXML
    private TextField author;
    @FXML
    private Text authorT;
    @FXML
    private TextField language;
    @FXML
    private Text languageT;
    @FXML
    private TextField genre;
    @FXML
    private Text genreT;
    @FXML
    private TextField director;
    @FXML
    private TextField runTime;
    @FXML
    private TextField languageD;
    @FXML
    private TextField subtitleLanguage;
    @FXML
    private Text directorT;
    @FXML
    private Text runTimeT;
    @FXML
    private Text languageDT;
    @FXML
    private Text subtitleLanguageT;
    @FXML
    private ListView<String> listOfResources;//list with the available resource to edit
    @FXML
    void editButton(){
        editHandling(); 
    }
    @FXML
    void cancelButton(){
        close();
    }
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
    private int resource;
    @FXML
    private Text invalidMessage;
    @FXML
    private Text incompleteMessage;
    //reset the individual text and textfields
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
    private int resourceID;
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

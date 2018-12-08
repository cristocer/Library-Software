package frontend;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
public class CreateResourceController extends Controller{

/**
 * CreateResourceController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.3
 * @since 07/12/2018
 */
	
/**
 * The CreateResourceController class is a subclass of the class Controller and is 
 * used to create a new resource via a librarian account's GUI.
 */	
	
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
    
    /**
     * Method used to create a button in the GUI.
     */
    @FXML
    void createButton(){
        createHandling(); 
    }
    
    /**
     * Method used to remove a button from the GUI.
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
    
    
    //take the inputs and call the constructor of the class or insert into db by the right format
    //TO DO complete constructors when we decide on the format
    //solve small error why the imcompleteMessage doesn't appear
    //how to get the absence of text
    
    /**
     * Method used to maintain and control the create resource GUI used by the librarian accounts.
     */
    private void createHandling(){
       invalidMessage.setVisible(false);
       incompleteMessage.setVisible(false);  
       if(resource==0){
           invalidMessage.setVisible(true);
       }else if(resource==1){
           if(title.getText()==null || year.getText()==null || image.getText()==null || os.getText()==null || manufacturer.getText()==null || model.getText()==null ){
           incompleteMessage.setVisible(true);   
           }else{
               //Laptop.(year.getText(),title.getText(),image.getText()==""..)
              // close();
           }
       }else if(resource==2){
           if(title.getText()=="" || year.getText()=="" || image.getText()=="" || director.getText()=="" || runTime.getText()=="" || languageD.getText()=="" || subtitleLanguage.getText()==""){
           invalidMessage.setText("Error: Field not completed!");   
           }else{
               //DVD.(year.getText(),title.getText(),image.getText()==""..)
              // close();
           }
       }else if(resource==3){
           if(title.getText()=="" || year.getText()=="" || image.getText()=="" || publisher.getText()=="" || isbn.getText()=="" || language.getText()=="" || author.getText()=="" || genre.getText()==""){
           invalidMessage.setText("Error: Field not completed!");   
           }else{
               //Book.(year.getText(),title.getText(),image.getText()==""..)
               //close();
           }
       }
    }

}
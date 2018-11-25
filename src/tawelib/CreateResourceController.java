package tawelib;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
public class CreateResourceController extends Controller{

    //TO DO add text and textField  for dvd and book
    //to ask when we press the create button do we call the onstructor of the 
    //class book which will insert the data into the database?
    private boolean validCreate;//validates that every input valid and entered
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
    void createButton(){
        //createHandling(); 
        close();
    }
    @FXML
    void cancelButton(){
        close();
    }
    @FXML
    void createLaptop(){
        reset();
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
        //director.setVisible(true);
        //runTime.setVisible(true);
        //language.setVisible(true);
        //subtitleLanguage.setVisible(true);
        //directorT.setVisible(true);
        //runTimeT.setVisible(true);
        //languageT.setVisible(true);
        //subtitleLanguagelanguageT.setVisible(true);
       
    }
    @FXML
    void createBook(){
        reset();
        //publisher.setVisible(true);
        //isbn.setVisible(true);
        //language.setVisible(true);
        //author.setVisible(true);
        //genre.setVisible(true);
        //publisherT.setVisible(true);
        //isbnT.setVisible(true);
        //languageT.setVisible(true);
        //authorT.setVisible(true);
        //genreT.setVisible(true);
        
    }
    //reset the individual text and textfields
    void reset(){        
        os.setVisible(false);
        manufacturer.setVisible(false);
        model.setVisible(false);
        modelT.setVisible(false);
        osT.setVisible(false);
        manufacturerT.setVisible(false);
        //director.setVisible(false);
        //runTime.setVisible(false);
        //language.setVisible(false);
        //subtitleLanguage.setVisible(false);
        //directorT.setVisible(false);
        //runTimeT.setVisible(false);
        //languageT.setVisible(false);
        //subtitleLanguagelanguageT.setVisible(false);
        //publisher.setVisible(false);
        //isbn.setVisible(false);
        //language.setVisible(false);
        //author.setVisible(false);
        //genre.setVisible(false);
        //publisherT.setVisible(false);
        //isbnT.setVisible(false);
        //languageT.setVisible(false);
        //authorT.setVisible(false);
        //genreT.setVisible(false);
    }
    
    public void initialize(){
        
        validCreate=false;
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
    /*
    private void createHandling(){
        //to be build the resource
    }*/

}
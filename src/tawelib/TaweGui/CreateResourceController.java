package tawelib.TaweGui;

import org.hibernate.Session;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
public class CreateResourceController extends Controller{

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
    void createButton(){
        createHandling(); 
    }
    @FXML
    void cancelButton(){
        close();
    }
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
    
    private void createHandling(){
    	Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        invalidMessage.setVisible(false);
        incompleteMessage.setVisible(false);  
        if(resource==0){
            invalidMessage.setVisible(true);
        }else if(resource==1){
            if(title.getText().compareTo("")==0 || year.getText().compareTo("")==0 || image.getText().compareTo("")==0 || os.getText().compareTo("")==0 || 
                    manufacturer.getText().compareTo("")==0|| model.getText().compareTo("")==0){
            incompleteMessage.setVisible(true);   
            }else{
            	Laptop laptop = new Laptop(year.getText(),title.getText(),image.getText(),os.getText(), manufacturer.getText(), model.getText());
                session.save(laptop);
               
            }
        }else if(resource==2){
            if(title.getText().compareTo("")==0 || year.getText().compareTo("")==0 || image.getText().compareTo("")==0 || director.getText().compareTo("")==0
                    || runTime.getText().compareTo("")==0 || languageD.getText().compareTo("")==0 || subtitleLanguage.getText().compareTo("")==0){
            incompleteMessage.setVisible(true);   
            }else{
            	DVD dvd = new DVD(year.getText(),title.getText(),image.getText(),director.getText(), Integer.parseInt(runTime.getText()), language.getText(), subtitleLanguage.getText());
                session.save(dvd);
                
            }
        }else if(resource==3){
            if(title.getText().compareTo("")==0 || year.getText().compareTo("")==0 || image.getText().compareTo("")==0 || publisher.getText().compareTo("")==0
                    || isbn.getText().compareTo("")==0|| language.getText().compareTo("")==0|| author.getText().compareTo("")==0|| genre.getText().compareTo("")==0){
            incompleteMessage.setVisible(true);  
            }else{
            	Book book = new Book(year.getText(),title.getText(),image.getText(),author.getText(), publisher.getText(), Integer.parseInt(isbn.getText()), genre.getText(), language.getText());
                session.save(book);
                
            }
            
        }
        session.getTransaction().commit();
        session.close();
    }

}
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

import backend.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EditResourceController extends Controller{

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
    void createLaptop(Laptop laptop){
        reset();
        os.setVisible(true);
        manufacturer.setVisible(true);
        model.setVisible(true);
        modelT.setVisible(true);
        osT.setVisible(true);
        manufacturerT.setVisible(true);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        laptop.editResource(os.getText(),manufacturer.getText(),model.getText(),title.getText(),year.getText(),image.getText());
        session.save(laptop);
        session.getTransaction().commit();
    }
    
    /**
     * Method used in creating a DVD resource via the GUI.
     */
    @FXML
    void createDVD(DVD dvd){
        reset();
        director.setVisible(true);
        runTime.setVisible(true);
        languageD.setVisible(true);
        subtitleLanguage.setVisible(true);
        directorT.setVisible(true);
        runTimeT.setVisible(true);
        languageDT.setVisible(true);
        subtitleLanguageT.setVisible(true);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        dvd.editResource(director.getText(), Integer.parseInt(runTime.getText()), language.getText(), subtitleLanguage.getText(), title.getText(), year.getText(), image.getText());
        session.save(dvd);
        session.getTransaction().commit();
       
    }
    
    /**
     * Method used in creating a Book resource via the GUI.
     */
    @FXML
    void createBook(Book book){
        reset();
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
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        book.editResource(author.getText(), publisher.getText(), Integer.parseInt(isbn.getText()), genre.getText(), language.getText(), title.getText(), year.getText(), image.getText());
        session.save(book);
        session.getTransaction().commit();
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
        title.setVisible(true);
        year.setVisible(true);
        image.setVisible(true);
        reset();
    }

    /**
     * Method used to maintain and control the edit resource GUI used by the librarian accounts.
     */
    private void editHandling(){
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Resources resource = (Resources) session.createQuery("From Resources Where resourceUID = '" + SceneController.SELECTED_RESOURCE.split("[\\(\\)]")[1] + "'").uniqueResult();
            Book book = (Book) session.createQuery("From Book Where resourceUID = '" + resource.getResourceUID() + "'").uniqueResult();
            Laptop laptop = (Laptop) session.createQuery("From Laptop Where resourceUID = '" + resource.getResourceUID() + "'").uniqueResult();
            DVD dvd = (DVD) session.createQuery("From DVD Where resourceUID = '" + resource.getResourceUID() + "'").uniqueResult();
            session.close();
            if(book != null){
                //It's a book!
                createBook(book);
            }
            else if(laptop != null){
                //It's a laptop!
                createLaptop(laptop);

            }
            else if(dvd != null){
                //It's a dvd!
                createDVD(dvd);
            }
        }
        catch (Exception e){
            listOfResources.getItems().add("Please close this window and select a resource.");
            System.out.println(e);
        }
    }
}

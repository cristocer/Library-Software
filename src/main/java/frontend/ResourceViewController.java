package frontend;

import backend.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * ResourceViewController.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 07/12/2018
 * @author 
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The ResourceViewController class is a subclass of the class Controller. This class is used to
 * manage displaying information on a resource within the libraries' database.
 */

public class ResourceViewController extends Controller{
    @FXML
    private ListView<String> resourceDetails;	//A list of the resources' information.
    @FXML
    private ImageView resourceImage;	//An ImageView of the appropriate resources' thumbnail image.
    
    /**
     * A method called when the user presses the done button.
     */
    @FXML
    void doneButton(){
        doneHandling();
    }
    
    /**
     * Calls the methods necessary to populate the GUI with the resources' information.
     */
    public void initialize(){ //TODO Fix bug where program crashes if no resource is selected.
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Resources resource = (Resources) session.createQuery("From Resources Where title = '" + SceneController.SELECTED_RESOURCE + "'").uniqueResult();
            Book book = (Book) session.createQuery("From Book Where resourceUID = '" + resource.getResourceUID() + "'").uniqueResult();
            Laptop laptop = (Laptop) session.createQuery("From Laptop Where resourceUID = '" + resource.getResourceUID() + "'").uniqueResult();
            DVD dvd = (DVD) session.createQuery("From DVD Where resourceUID = '" + resource.getResourceUID() + "'").uniqueResult();
            if (book != null) {
                resourceDetails.getItems().add("Title: " + book.getTitle());
                resourceDetails.getItems().add("Author: " + book.getAuthor());
                resourceDetails.getItems().add("Publisher: " + book.getPublisher());
                resourceDetails.getItems().add("Year: " + book.getYear());
                resourceDetails.getItems().add("Genre: " + book.getGenre());
                resourceDetails.getItems().add("Language: " + book.getLanguage());
                resourceDetails.getItems().add("ISBN: " + book.getIsbn());
            } else if (laptop != null) {
                resourceDetails.getItems().add("Title: " + laptop.getTitle());
                resourceDetails.getItems().add("OS: " + laptop.getOperatingSystem());
                resourceDetails.getItems().add("Manufacturer: " + laptop.getManufacturer());
                resourceDetails.getItems().add("Model: " + laptop.getModel());
                resourceDetails.getItems().add("Year: " + laptop.getYear());
            } else if (dvd != null) {
                resourceDetails.getItems().add("Title: " + dvd.getTitle());
                resourceDetails.getItems().add("Director: " + dvd.getDirector());
                resourceDetails.getItems().add("Year: " + dvd.getYear());
                resourceDetails.getItems().add("Run-time: " + dvd.getRunTime());
                resourceDetails.getItems().add("Language: " + dvd.getLanguage());
                resourceDetails.getItems().add("Subtitles: " + dvd.getSubtitleLanguage());
            }
        }
        catch (Exception e){
            resourceDetails.getItems().add("Please close this window and select a resource.");
            System.out.println(e);
        }
        session.close();
    }

    /**
     * Closes the resources' information when the user is finished.
     */
    private void doneHandling(){
        close();
    }
}
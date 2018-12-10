package frontend;

import backend.AccountBaseUser;
import backend.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * ChoosProfileImageController.java
 * - GNU General Public License 2007
 * - creation date: 09/12/2018
 * - last modified: 09/12/2018
 * @author Alex Moras
 * @version 1.3
 * @since 09/12/2018
 */

/**
 * The CreateProfileImageController class is a subclass of the class Controller and 
 * is used to set a users' profile image when they choose to change it.
 */

public class ChooseProfileImageController extends Controller{
    private final String DEFAULT = "src/main/resources/images/default.png";		//Location of users' currently selected profile image
    private final String DEFAULT_1 = "src/main/resources/images/default1.png";	//Location of first built-in profile image
    private final String DEFAULT_2 = "src/main/resources/images/default1.png";	//Location of second built-in profile image
    private final String DEFAULT_3 = "src/main/resources/images/default2.png";	//Location of third built-in profile image
    private final String DEFAULT_4 = "src/main/resources/images/default3.png";	//Location of fourth built-in profile image


    @FXML
    private ImageView selectedImage;	//Display of users' currently selected profile image
    @FXML
    private ImageView d1;	//Display of first built-in profile image
    @FXML
    private ImageView d2;	//Display of second built-in profile image
    @FXML
    private ImageView d3;	//Display of third built-in profile image
    @FXML
    private ImageView d4;	//Display of fourth built-in profile image

    /**
     * Initialises the GUI for choosing profile images.
     */
    public void initialize(){
        setup();
    }
    
    /**
     * Selects first built-in profile image on the GUI.
     */
    @FXML
    void chooseD1() {
        selectedImage.setImage(d1.getImage());
        SceneController.currentProfileImagePath = DEFAULT_1;
    }

    /**
     * Selects second built-in profile image on the GUI.
     */
    @FXML
    void chooseD2() {
        selectedImage.setImage(d2.getImage());
        SceneController.currentProfileImagePath = DEFAULT_2;
    }

    /**
     * Selects third built-in profile image on the GUI.
     */
    @FXML
    void chooseD3() {
        selectedImage.setImage(d3.getImage());
        SceneController.currentProfileImagePath = DEFAULT_3;
    }

    /**
     * Selects fourth built-in profile image on the GUI.
     */
    @FXML
    void chooseD4() {
        selectedImage.setImage(d4.getImage());
        SceneController.currentProfileImagePath = DEFAULT_4;
    }

    /**
     * When user is finished selecting their profile image, this method saves it to their account.
     */
    @FXML
    void doneB() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            AccountBaseUser baseUser = (AccountBaseUser) session.createQuery("From AccountBaseUser Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
            baseUser.setProfileImagePath(SceneController.currentProfileImagePath);
            session.save(baseUser);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e);
        }
        close();
    }

    /**
     * A method that occurs when the user presses the reset button.
     */
    @FXML
    void resetB() {
        reset();
    }

    /**
     * Displays the built-in profile images on the GUI.
     */
    private void setup(){
        reset();
        d1.setImage(new Image(DEFAULT_1));
        d2.setImage(new Image(DEFAULT_2));
        d3.setImage(new Image(DEFAULT_3));
        d4.setImage(new Image(DEFAULT_4));
    }

    /**
     * Resets users' profile image in the case that they cancel the change.
     */
    private void reset(){
        selectedImage.setImage(new Image(DEFAULT));
        SceneController.currentProfileImagePath = DEFAULT;
    }

}

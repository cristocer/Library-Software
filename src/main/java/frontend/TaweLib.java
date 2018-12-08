package frontend;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import backend.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * TawLib.java
 * - GNU General Public License 2007
 * - creation date: 17/11/2018
 * - last modified: 03/12/2018
 * @author 
 * @version 1.3
 * @since 07/12/2018
 */

/**
 * The TawLib class...
 */

//main class
public class TaweLib extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Parent root = FXMLLoader.load(getClass().getResource(SceneController.LOGIN_SCREEN));
        primaryStage.setTitle(SceneController.LOGIN_WINDOW_TITLE);
        primaryStage.setScene(new Scene(root,SceneController.LOGIN_WINDOW_WIDTH, SceneController.LOGIN_WINDOW_HEIGHT));
        primaryStage.show();
		primaryStage.setOnCloseRequest(e -> {
            sessionFactory.close();
            System.exit(0);
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

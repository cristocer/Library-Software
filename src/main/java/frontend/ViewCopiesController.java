package frontend;
import backend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ViewCopiesController {
    @FXML
    private GridPane rootPane;
    @FXML
    private TextField userIDBox;
    @FXML
    private ListView<String> copiesList;
    @FXML
    private ImageView resourceImage;
    @FXML
    void doneButton(ActionEvent event) {
    }
    @FXML
    void loanB(){
        loan();
    }
    public void initialize(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            Resources resource = (Resources) session.createQuery("From Resources Where resourceUID = '" + SceneController.SELECTED_RESOURCE.split("[\\(\\)]")[1] + "'").uniqueResult();
            System.out.println(resource.title);
            List<Copies> copies = session.createQuery("From Copies Where resourceUID = '" + resource.getResourceUID() + "'").list();
            for (int i = 0; i < copies.size(); i++) {
                copiesList.getItems().add(String.valueOf(copies.get(i).getCopyUID()));
            }
        }
        catch (Exception e){
            copiesList.getItems().add("Please close this window and select a resource.");
            System.out.println(e);
        }
        session.close();
    }
    public void loan(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Librarian librarian = (Librarian) session.createQuery("From Librarian Where username = '" + SceneController.USER_USERNAME + "'").uniqueResult();
        Copies selectedCopy = (Copies) session.createQuery("From Copies Where copyUID = '" + copiesList.getSelectionModel().getSelectedItem() + "'").uniqueResult();
        session.close();
        Request.requestCopy(selectedCopy.getCopyUID(), userIDBox.getText(), librarian.getStaffID());
        Request.collectCopy(selectedCopy.getCopyUID(), userIDBox.getText());
    }
}
package taweLib;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Simplifies creating new windows. Removes a stupid amount of redundant code.
public class Window<Controller> {
    private FXMLLoader fxmlLoader;
    private Controller controller;
    private Stage stage;

    public Window(String fxml, int width, int height, String title){
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            controller = fxmlLoader.getController();

            Scene scene = new Scene(fxmlLoader.load(),width,height);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
        }
        catch (Exception e){
            System.out.println("Creating new Window failed.");
        }

    }
    public void show(){
        stage.show();
    }
    public void showAndWait(){
        stage.showAndWait();
    }
    public void makeModal(){
        stage.initModality(Modality.APPLICATION_MODAL);
    }
    public Controller getController(){
        return controller;
    }
}

package frontend;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * DrawProfileImageController.java
 * - GNU General Public License 2007
 * - creation date: 09/12/2018
 * - last modified: 09/12/2018
 * @author Alex Moras
 * @version 1.3
 * @since 09/12/2018
 */

/**
 * The DrawProfielImage class is a subclass of the class Controller and 
 * is used when an account is drawing their own profile image.
 */

public class DrawProfileImageController extends Controller {
    private GraphicsContext gc;	//Creates a GraphicsContext menu for the profile image drawer.
    private ColorPicker cpLine;	//Creates a ColorPicker for the profile image drawer.
    @FXML
    private Canvas canvas;	//Creates a Canva for the profile image drawer.

    /**
     * An event that occurs when the user has pressed the done button to leave the profile image drawer.
     * @param event An event caused by the user pressing the done button.
     */
    @FXML
    void doneB(ActionEvent event) {
        finish();
    }

    /**
     * An event that occurs when the user has pressed on the canvas in order to draw and applies a stroke to
     * their mouse location.
     * @param e An event caused by the user pressing on the canvas with the draw tool.
     */
    @FXML
    void mouseD(MouseEvent e) {
        gc.lineTo(e.getX(), e.getY());
        gc.stroke();
    }

    /**
     * An event that occurs when the user has pressed on the canvas in order to draw a straight line and 
     * applies a path beginning at their mouse location which ends when they next click.
     * @param e An event caused by the user pressing on the canvas with the straight line tool.
     */
    @FXML
    void mouseP(MouseEvent e) {
        gc.setStroke(cpLine.getValue());
        gc.beginPath();
        gc.lineTo(e.getX(), e.getY());
    }

    /**
     * An event that occurs when the user has pressed on the canvas in order to draw a rectangle and applies
     * a rectangle beginning at their mouse location which finishes where they next click.
     * @param e An event caused by the user pressing on the canvas with the rectangle tool.
     */
    @FXML
    void mouseR(MouseEvent e) {
        gc.lineTo(e.getX(), e.getY());
        gc.stroke();
        gc.closePath();
    }

    /**
     * An event that occurs when the user presses the clear button, it clears the canvas of all edits the user
     * has made thus far.
     * @param event An event caused by the user pressing the clear button.
     */
    @FXML
    void resetB(ActionEvent event) {
        gc.clearRect(0, 0, 300, 300);
        setup();
    }

    /**
     * Initialises the GUI for drawing profile images.
     */
    public void initialize() {
        setup();
    }

    /**
     * Sets up the canvas and tools for the draw profile image GUI.
     */
    private void setup() {
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
        cpLine = new ColorPicker(Color.BLACK);
    }

    /**
     * Gets the file path for the users' profile image.
     * @return
     */
    private String getPath(){
        return "src/main/resources/images/"+ System.currentTimeMillis()/1000 + ".png";
    }
    
    /**
     * Saves the newly drawn profile image to the users profile image file path.
     */
    private void save() {
        String filePath = getPath();
        File file = new File(filePath);
        try {
            WritableImage writableImage = new WritableImage(300, 300);
            canvas.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            ImageIO.write(renderedImage, "png", file);
            SceneController.currentProfileImagePath = filePath;
        } catch (IOException ex) {
            System.out.println("Error!");
        }
    }

    /**
     * Saves the users drawn profile image and closes the draw profile image GUI.
     */
    private void finish() {
        save();
        close();
    }

}

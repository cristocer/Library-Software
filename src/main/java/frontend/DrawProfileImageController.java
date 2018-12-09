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

public class DrawProfileImageController extends Controller {
    private GraphicsContext gc;
    private ColorPicker cpLine;
    @FXML
    private Canvas canvas;

    @FXML
    void doneB(ActionEvent event) {
        finish();
    }

    @FXML
    void mouseD(MouseEvent e) {
        gc.lineTo(e.getX(), e.getY());
        gc.stroke();
    }

    @FXML
    void mouseP(MouseEvent e) {
        gc.setStroke(cpLine.getValue());
        gc.beginPath();
        gc.lineTo(e.getX(), e.getY());
    }

    @FXML
    void mouseR(MouseEvent e) {
        gc.lineTo(e.getX(), e.getY());
        gc.stroke();
        gc.closePath();
    }

    @FXML
    void resetB(ActionEvent event) {
        gc.clearRect(0, 0, 300, 300);
        setup();
    }

    public void initialize() {
        setup();
    }

    private void setup() {
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1);
        cpLine = new ColorPicker(Color.BLACK);
    }

    private String getPath(){
        return "src/main/resources/images/"+ System.currentTimeMillis()/1000 + ".png";
    }
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

    private void finish() {
        save();
        close();
    }

}

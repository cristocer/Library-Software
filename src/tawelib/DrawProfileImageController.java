package tawelib;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;

public class DrawProfileImageController implements Initializable{
	@FXML
	private Button brush;
	@FXML
	private Button line;
	@FXML
	private Button circle;
	@FXML
	private Button triangle;
	@FXML
	private Button rect;
	@FXML
	private Button save;
	@FXML
	private Button clear;
	@FXML
	private Button exit;
	@FXML
	private RadioButton fill;
	@FXML
	private ColorPicker colorPicker;
	@FXML
	private TextField brushSize;
	@FXML
	private Canvas canvas;

	private boolean brushToolSelected = false;
	private boolean lineToolSelected = false;
	private boolean circleToolSelected = false;
	private boolean triangleToolSelected = false;
	private boolean rectToolSelected = false;
	private boolean fillShapes = false;
	GraphicsContext tool;
	
	@FXML
	private void brushToolSelected(ActionEvent e) {
		brushToolSelected = true;
	}
	@FXML
	private void lineToolSelected(ActionEvent e) {
		lineToolSelected = true;
	}
	@FXML
	private void circleToolSelected(ActionEvent e) {
		circleToolSelected = true;
	}
	@FXML
	private void triangleToolSelected(ActionEvent e) {
		triangleToolSelected = true;
	}
	@FXML
	private void rectToolSelected(ActionEvent e) {
		rectToolSelected = true;
	}
	@FXML
	private void fillShapes(ActionEvent e) {
		fillShapes = true;
	}
	@FXML
	private void saveCanvas(ActionEvent e) {
		saveCanvasHandling();
	}
	@FXML
	private void clearCanvas(ActionEvent e) {
		double width = canvas.getWidth();
		double height = canvas.getHeight();
		canvas.getGraphicsContext2D().fillRect(0, 0, width, height);
	}
	@FXML
	private void exitCanvas(ActionEvent e) {
		exitCanvasHandling();
	}
	

	
	private void saveCanvasHandling() {
//		try {
////			Image screenShot = canvas.snapshot(null, null);
////			ImageIO.write(SwingFXUtils.fromFXImage(screenShot, null), "png", new File("/Tawe Library Repo/tawelib/ProfileImages/DRAWN" + SystemUtilTime.now +".png"));
////			//save image in database as logged in user's equipped image path
////			closeWindow();
////		} catch (Exception e) {
////			System.out.println("Failure to save drawn profile image: DrawnProfileImageController");
////		}
	}
	
	public void exitCanvasHandling() {
		closeWindow();
	}
	
	public void closeWindow() {
//		Stage temp = (Stage) save.getScene().getWindow();
//		temp.close();
//		Window<EditProfileImageController> editProfileImage = new Window<EditProfileImageController>(SceneController.EDIT_PROFILE_IMAGE,SceneController.EDIT_PROFILE_IMAGE_WIDTH,SceneController.EDIT_PROFILE_IMAGE_HEIGHT,SceneController.EDIT_PROFILE_IMAGE_TITLE);
//    	editProfileImage.show();
    }
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tool = canvas.getGraphicsContext2D();
		
		//Draw Shit
		canvas.setOnMouseDragged(e -> {
			double size = Double.parseDouble(brushSize.getText());
			
			double x = e.getX() - size / 2;
			double y = e.getY() - size / 2;
			
			if (brushToolSelected && !(brushSize.getText().isEmpty())) {
				tool.setFill(colorPicker.getValue());
				tool.fillRoundRect(x, y, size, size, size, size);
			} 
		});
		
		//Draw straight lines
		canvas.setOnMousePressed(e -> {
			double first_x = e.getX();
			double first_y = e.getY();
			
			canvas.setOnMouseReleased(f -> {
				double last_x = f.getX();
				double last_y = f.getY();
				
				if (lineToolSelected) {	//Code to draw straight line.
					tool.setStroke(colorPicker.getValue());
					tool.strokeLine(first_x, first_y, last_x, last_y);
				}
			});
		});
		
		//Draw hollow circles
		canvas.setOnMousePressed(e -> {
			double first_x = e.getX();
			double first_y = e.getY();
			
			canvas.setOnMouseReleased(f -> {
				double last_x = f.getX();
				double last_y = f.getY();
				
				double width = last_x - first_x;
				double height = last_y - first_y;
				width = Math.abs(width);
				height = Math.abs(height);
				
				if (circleToolSelected && !(fillShapes)) { //Code to draw circle.
					tool.setStroke(colorPicker.getValue());
					tool.strokeOval(first_x, first_y, width, height);
				} 
			});
		});
		
		//Draw hollow triangle
		canvas.setOnMousePressed(e -> {
			double first_x = e.getX();
			double first_y = e.getY();
			
			canvas.setOnMouseReleased(f -> {
				double last_x = f.getX();
				double last_y = f.getY();
				
				double width = last_x - first_x;
				double height = last_y - first_y;
				width = Math.abs(width);
				height = Math.abs(height);
				
				if (triangleToolSelected && !(fillShapes)) { //Code to draw circle.
					tool.setStroke(colorPicker.getValue());
					double[] xPoints = {(width/2), first_x, last_x};
					double[] yPoints = {first_y, last_y, last_y};
					tool.strokePolygon(xPoints, yPoints, 3);
				} 
			});
		});
		
		//Draw hollow Rectangle
				canvas.setOnMousePressed(e -> {
					double first_x = e.getX();
					double first_y = e.getY();
					
					canvas.setOnMouseReleased(f -> {
						double last_x = f.getX();
						double last_y = f.getY();
						
						double width = last_x - first_x;
						double height = last_y - first_y;
						width = Math.abs(width);
						height = Math.abs(height);
						
						if (rectToolSelected && !(fillShapes)) { //Code to draw circle.
							tool.setStroke(colorPicker.getValue());
							tool.strokeRect(first_x, first_y, width, height);
						} 
					});
				});
			
			//Draw filled circles
				canvas.setOnMousePressed(e -> {
					double first_x = e.getX();
					double first_y = e.getY();
					
					canvas.setOnMouseReleased(f -> {
						double last_x = f.getX();
						double last_y = f.getY();
						
						double width = last_x - first_x;
						double height = last_y - first_y;
						width = Math.abs(width);
						height = Math.abs(height);
						
						if (circleToolSelected && (fillShapes)) { //Code to draw circle.
							tool.setFill(colorPicker.getValue());
							tool.fillOval(first_x, first_y, width, height);
						} 
					});
				});
				
				//Draw filled triangle
				canvas.setOnMousePressed(e -> {
					double first_x = e.getX();
					double first_y = e.getY();
					
					canvas.setOnMouseReleased(f -> {
						double last_x = f.getX();
						double last_y = f.getY();
						
						double width = last_x - first_x;
						double height = last_y - first_y;
						width = Math.abs(width);
						height = Math.abs(height);
						
						if (triangleToolSelected && (fillShapes)) { //Code to draw circle.
							tool.setFill(colorPicker.getValue());
							double[] xPoints = {(width/2), first_x, last_x};
							double[] yPoints = {first_y, last_y, last_y};
							tool.fillPolygon(xPoints, yPoints, 3);
						} 
					});
				});
				
				//Draw filled Rectangle
						canvas.setOnMousePressed(e -> {
							double first_x = e.getX();
							double first_y = e.getY();
							
							canvas.setOnMouseReleased(f -> {
								double last_x = f.getX();
								double last_y = f.getY();
								
								double width = last_x - first_x;
								double height = last_y - first_y;
								width = Math.abs(width);
								height = Math.abs(height);
								
								if (rectToolSelected && (fillShapes)) { //Code to draw circle.
									tool.setFill(colorPicker.getValue());
									tool.fillRect(first_x, first_y, width, height);
								} 
							});
						});
	}
}

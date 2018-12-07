package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChooseProfileImage {
	@FXML
	private ImageView equippedImage;
	@FXML
	private ImageView imageOption1;
	@FXML
	private ImageView imageOption2;
	@FXML
	private ImageView imageOption3;
	@FXML
	private ImageView imageOption4;
	@FXML
	private Button done;

	private String equipped;
	private String option1 = "/Tawe Library Repo/tawelib/ProfileImages/OPTION1.jpg";
	private String option2 = "/Tawe Library Repo/tawelib/ProfileImages/OPTION2.png";
	private String option3 = "/Tawe Library Repo/tawelib/ProfileImages/OPTION3.jpg";
	private String option4 = "/Tawe Library Repo/tawelib/ProfileImages/OPTION4.jpg";

	
	
	
	public ChooseProfileImage() {
		
		//equipped = equipped data from loggedin table in database.
		//String equippedPath = path from current user.
		//equipped = new SavedProfileImage(equippedPath);
		Image profile = new Image(equipped);
		equippedImage.setImage(profile);
		
		Image op1 = new Image(option1);
		imageOption1.setImage(op1);
		
		Image op2 = new Image(option2);
		imageOption2.setImage(op2);
		
		Image op3 = new Image(option3);
		imageOption3.setImage(op3);
		
		Image op4 = new Image(option4);
		imageOption4.setImage(op4);
	}
	
	@FXML
	void drawWindow(ActionEvent e) {
		drawWindowHandling();
	}
	@FXML
	void closeWindow(ActionEvent e) {
		closeWindowHandling();
	}
	@FXML
	void revertToDefault(ActionEvent e) {
		revertToDefaultHandling();
	}
	@FXML
	void chooseImageOption1(ActionEvent e) {
		chooseImageOption1Handling();
	}
	@FXML
	void chooseImageOption2(ActionEvent e) {
		chooseImageOption2Handling();
	}
	@FXML
	void chooseImageOption3(ActionEvent e) {
		chooseImageOption3Handling();
	}
	@FXML
	void chooseImageOption4(ActionEvent e) {
		chooseImageOption4Handling();
	}
	
	
	
	
	public void drawWindowHandling() {
//		closeWindowHandling();
//		Window<DrawProfileImageController> drawProfileImage = new Window<>(SceneController.DRAW_PROFILE_IMAGE,SceneController.DRAW_PROFILE_IMAGE_WIDTH,SceneController.DRAW_PROFILE_IMAGE_HEIGHT,SceneController.DRAW_PROFILE_IMAGE_TITLE);
//		drawProfileImage.show();
	}
	public void closeWindowHandling() {
		Stage temp = (Stage) done.getScene().getWindow();
		temp.close();
	}
	public void revertToDefaultHandling() {
		equipped = "/Tawe Library Repo/tawelib/ProfileImages/DEFAULT.png";
		Image def = new Image(equipped);
		equippedImage.setImage(def);
	}
	public void chooseImageOption1Handling() {
		//swap places with equipped image
		equipDefaultImage(option1);
	}
	public void chooseImageOption2Handling() {
		//swap places with equipped image
		equipDefaultImage(option2);
	}
	public void chooseImageOption3Handling() {
		//swap places with equipped image
		equipDefaultImage(option3);
	}
	public void chooseImageOption4Handling() {
		//swap places with equipped image
		equipDefaultImage(option4);
	}
	
	//Code to run after new profile image is drawn.
	
	public void equipDefaultImage(String option) {
		//delete DEFAULT image
		if (option.contains("DEFAULT")) {
			equipped = option;
			Image image = new Image(equipped);
			equippedImage.setImage(image);
			//save: access loggedin table and edit the (equipped) variable and set it to user.setProfileImagePath(equipped).
		} else {
			if (option.contains("OPTION1")) {
				equipped = option;
				Image image = new Image(equipped);
				equippedImage.setImage(image);
				//save: access loggedin table and edit the (equipped) variable and set it to user.setProfileImagePath(equipped).
			} else if (option.contains("OPTION2")) {
				equipped = option;
				Image image = new Image(equipped);
				equippedImage.setImage(image);
				//save: access loggedin table and edit the (equipped) variable and set it to user.setProfileImagePath(equipped).
			} else if (option.contains("OPTION3")) {
				equipped = option;
				Image image = new Image(equipped);
				equippedImage.setImage(image);
				//save: access loggedin table and edit the (equipped) variable and set it to user.setProfileImagePath(equipped).
			} else if (option.contains("OPTION4")) {
				equipped = option;
				Image image = new Image(equipped);
				equippedImage.setImage(image);
				//save: access loggedin table and edit the (equipped) variable and set it to user.setProfileImagePath(equipped).
			} 
		}
	}
}
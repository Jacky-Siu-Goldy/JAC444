package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**********************************************
Workshop # 6
Course: JAC444 - Semester Winter 2023
Last Name: Siu
First Name: Chun Kit Jacky
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-17
**********************************************/
public class Main extends Application {
	/**
	 * The start of the gui
	 * contain the primaryStage
	 * pane and scene
	 */
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("GuessTheNum.fxml"));
			Parent parentView = loader.load();
			Scene scene = new Scene(parentView);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Guess the Number");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}

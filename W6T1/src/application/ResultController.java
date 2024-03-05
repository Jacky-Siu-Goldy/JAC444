package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
/**
 * Controller for the Result.fxml Gui
 * @author Jacky Chun Kit Siu 
 *
 */
public class ResultController {

	
	
	@FXML
    private Button noButton;

    @FXML
    private Label resultLabel;

    @FXML
    private Button yesButton;
    /**
     *  Exit the application when the noButton is pressed
     * @param event - when the no button is pressed
     */
    @FXML
    void noButtonPushed(ActionEvent event) {
    	javafx.application.Platform.exit();
    }

    /**
     * When the yesbutton is pushed It changes
     * the Stage and the pane and the scene to the nameRanking.fxml gui.
     * and show it.
     * @param event - when the yesButton is pressed
     */
    @FXML
    void yesButtonPushed(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/nameRanking.fxml"));
		
		try {
		Parent parentView = loader.load();
		
		Scene scene = new Scene(parentView);
		
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		stage.setScene(scene);
		stage.setTitle("Search Name Ranking Application");
		stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Take the argument and organize it into String and set the text of the
     * resultLabel to that String.
     * If the search comes up empty then the resultLabel will be Sorry, no Result Found
     * 
     * @param rank -- rank of the name for that year resulted from the search
     * @param gender -- gender 
     * @param name -- name resulted from the search 
     * @param year -- year of the search
     */
	public void initData(String rank, String gender, String name, String year) {
		       char gender2 = gender.toLowerCase().charAt(0);
		       
			
			if (!(name.isEmpty())) {
				switch(gender2) {
				
				case 'm':	String result = "Boy name " + name +" is rank #" + rank +" in " + year;
				  			resultLabel.setText(result);
				  			break;
			      
		        
				
				case 'f':	String result2 = "Girl name " + name +" is rank #" + rank +" in " + year;
				  			resultLabel.setText(result2);
				  			break;
		
				}
			}else {
				resultLabel.setText("Sorry, no Result Found.");
			}	
			
	}
}

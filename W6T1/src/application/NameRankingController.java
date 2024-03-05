package application;
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
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ns.NameSearch;
import rbgn.RankBoyGirlName;
/**
 * Controller for the NameRanking.fxml Gui
 * @author Jacky Chun Kit Siu
 *
 */
public class NameRankingController {

	@FXML
    private Button exitButton;

    @FXML
    private TextField genderTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField yearTextField;
    
   
    
    
    /**
     * exit the Application when the exitButton is press
     * @param  event - when the exitButton is pressed
     */
    @FXML
    void exitButtonPushed(ActionEvent event) {
    	 javafx.application.Platform.exit();
    }
    /** 
     * When the query submit button is pushed It changes
     * the Stage and the pane and the scene to the result.fxml gui.
     * It declare a NameSearch Object and uses its functionality to
     * open the right file and record the file's content into an array.
     * It will throw an exception if the file is not found.
     * then it checks the genderTextField to see if its been entered
     * correctly, otherwise it will throw an exception. Both exception
     * will be taken care of with it arised.
     * If all the parameter has been deem ok. It Uses a method in the
     * NameSearch class to Search for the name ranking in that specific
     * year and return the result and copy it to an object nameRankYear of
     * the RankBoyGirlName class.
     * It uses a method call initData in the ResultController to insert the data
     * into the new scene before it is set. Then it set the screen and title and 
     * show the Stage.
     * 
     * @param event - the querySubmitButton is pushed
     */
    @FXML
    void querySubmitButtonPushed(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("/application/result.fxml"));
    		Parent parentView = loader.load();
    		Scene scene = new Scene(parentView);
    		ResultController Controller = loader.getController();
    		
    		NameSearch nameFind = new NameSearch();
    		RankBoyGirlName nameRankYear = new RankBoyGirlName();
    		
    		
    		
    		nameFind.getNamesAndRanksFromFile(yearTextField.getText(), nameFind.getBoyGirlNameArray());
    		
    		Pattern genderPattern = Pattern.compile("[MmFf]");
    		Matcher matcher = genderPattern.matcher(genderTextField.getText());
    		if (matcher.find()) {
    			nameRankYear = nameFind.nameSearch(yearTextField.getText(),
    					genderTextField.getText(),nameTextField.getText(),
    					nameFind.getBoyGirlNameArray());
    		}else {
    			throw new IllegalArgumentException();
    		}
    		char gender = genderTextField.getText().charAt(0);
    		
    		switch(gender) {
    		case 'm': 	Controller.initData(nameRankYear.getRank(), genderTextField.getText(),
    					nameRankYear.getBoyName(),nameRankYear.getYear());
    					break;
    					
    		case 'f':	Controller.initData(nameRankYear.getRank(), genderTextField.getText(),
						nameRankYear.getGirlName(),nameRankYear.getYear());
    					break;
    			
    		}
    		
    		
    		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		
    		stage.setScene(scene);
    		stage.setTitle("Search Name Ranking Application");
    		stage.show();
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    		yearTextField.selectAll();	
    		yearTextField.requestFocus();
    	}catch(IllegalArgumentException e) {
    		e.printStackTrace();
    		yearTextField.selectAll();
    		yearTextField.requestFocus();
    	}
    }
}

package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

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
 * This is the controller of a guess the number
 * game which produce a random number in each game
 * for the user to guess. The random number is between 
 * 1 to 1000. The user is allow an unlimited number of
 * guesses in each game 
 * @author Jacky Chun Kit Siu
 *
 */
public class GuessTheNumController {
	    private boolean playTrigger = true;
	    public int max = 1000;
		public int min = 1;
	    public int randomNumber = ((int)(Math.random() * ((max - min) + 1)));;
	    private int previousNumber = -1;
	    public int count = 0;
	
	    /**
	     * return the previous number guessed
	     * @return - an integer number
	     */
	    public int getPreviousNumber() {
			return previousNumber;
		}

	    /**
	     * sets the previous number. Happens every time the 
	     * user entered a guess. his or her guess is recorded
	     * for comparison with the new guess.
	     * @param - previousNumber an integer.
	     */
		public void setPreviousNumber(int previousNumber) {
			this.previousNumber = previousNumber;
		}

		/**
		 * return the state of the game if it is in play mode or not.
		 * return true every time  the game start.
		 * return false when the game end.
		 * return true again if the play again button is pressed.
		 * @return a boolean
		 */
		public boolean getPlayTrigger() {
			return playTrigger;
		}

		/**
		 * set whether the game is in play mode or not
		 * set playTrigger to false every time the game ends.
		 * after the play again button is pressed, playTrgger 
		 * is set to true.
		 * @param - playTrigger a boolean
		 */
		public void setPlayTrigger(boolean playTrigger) {
			this.playTrigger = playTrigger;
		}
	    
		@FXML
	    private AnchorPane anchorPane;
		
		@FXML
	    private Label bottomLabel;

	    @FXML
	    private Button enterAndPlayAgainButton;

	    @FXML
	    private Label topLabel;

	    @FXML
	    private TextField userInputTextField;
	    
	    /**
	     * This event handler contain the game itself
	     * The game is only playable if the playTrigger is equal to true
	     * Every time a guess is entered it is recorded for comparison with 
	     * next guess. If the previous guess is closer in absolute term to
	     * the random number set than the current guess, then the background 
	     * color turns blue. If the previous guess is further in absolute term
	     * to the random number set than the current guess, then the background
	     * color turns red. The text of the labels are white when the background 
	     * is blue or red. The bottom label indicate whether the guess is too high
	     * or too low when compared to the random number.
	     * The text is black when the background is white. The
	     * black ground is white when the distance between the first guess and
	     * the random number is 999 or when the guess is correct. The text is black 
	     * when the background is white. When the game ends then enter button turns
	     * into the Play Again button.
	     * @param - event when the enterAndPlayAgainButton is pressed
	     */

	    @FXML
	    void enterAndPlayAgainButtonPressed(ActionEvent event) {
            int max = 1000;
            int min = 1;
            if(count != 1) {
            	System.out.println(randomNumber);
            	count = 1;
            }
			
            if(!(getPlayTrigger())){
            	
	            setPlayTrigger(true);
	            userInputTextField.setEditable(true);
				userInputTextField.setDisable(false);
				userInputTextField.setText("1 to 1000");
				userInputTextField.selectAll();
				userInputTextField.requestFocus();
				bottomLabel.setText("Please enter your first guess.");
				enterAndPlayAgainButton.setText("Enter");
				 
				
				
            }else if(getPlayTrigger()) {
				
			
				
				try {
					String inputString = userInputTextField.getText();
					int inputStringToInteger = Integer.parseInt(inputString);
					
					Pattern numPattern = Pattern.compile("^1000$|^[1-9][0-9][0-9]$|^[1-9][0-9]$|^[1-9]$");
					Matcher matcher = numPattern.matcher(inputString);
					
					if(!(matcher.find())){
						throw new IllegalArgumentException();
					}
    				
					int diffBtwInputAndRanNum =  randomNumber - inputStringToInteger;
					int absValueOfInputAndRanNum = Math.abs(diffBtwInputAndRanNum);
					int diffBtwPreNumAndRanNum = randomNumber - getPreviousNumber();
					int absValueOfPreNumAndRanNum = Math.abs(diffBtwPreNumAndRanNum);
					
					if( getPreviousNumber() == -1 && absValueOfInputAndRanNum == 999 && diffBtwInputAndRanNum < 0) {
						
						bottomLabel.setText("Too High");
						setPreviousNumber(inputStringToInteger);
						userInputTextField.setText("1 to 1000");
						userInputTextField.selectAll();
						userInputTextField.requestFocus();
						
					}else if ( getPreviousNumber() == -1 && absValueOfInputAndRanNum == 999 && diffBtwInputAndRanNum > 0) {
						
						bottomLabel.setText("Too Low");
						setPreviousNumber(inputStringToInteger);
						userInputTextField.setText("1 to 1000");
						userInputTextField.selectAll();
						userInputTextField.requestFocus();
						
					}else if(getPreviousNumber() == -1 && absValueOfInputAndRanNum < 999 && diffBtwInputAndRanNum < 0) {
						
    					anchorPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
    					topLabel.setTextFill(Color.WHITE);
    					bottomLabel.setTextFill(Color.WHITE);
    					bottomLabel.setText("Too High");
    					setPreviousNumber(inputStringToInteger);
    					userInputTextField.setText("1 to 1000");
    					userInputTextField.selectAll();
    					userInputTextField.requestFocus();
    					
					}else if(getPreviousNumber() == -1 && absValueOfInputAndRanNum < 999 && diffBtwInputAndRanNum > 0) {
						
						anchorPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
						topLabel.setTextFill(Color.WHITE);
    					bottomLabel.setTextFill(Color.WHITE);
						bottomLabel.setText("Too Low");
    					setPreviousNumber(inputStringToInteger);
    					userInputTextField.setText("1 to 1000");
    					userInputTextField.selectAll();
    					userInputTextField.requestFocus();
					
					}else if(getPreviousNumber() != -1 && absValueOfInputAndRanNum < absValueOfPreNumAndRanNum 
							&& diffBtwInputAndRanNum < 0) {
						
						anchorPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
						topLabel.setTextFill(Color.WHITE);
    					bottomLabel.setTextFill(Color.WHITE);
						bottomLabel.setText("Too High");
    					setPreviousNumber(inputStringToInteger);
    					userInputTextField.setText("1 to 1000");
    					userInputTextField.selectAll();
    					userInputTextField.requestFocus();
						
					}else if(getPreviousNumber() != -1 && absValueOfInputAndRanNum < absValueOfPreNumAndRanNum 
							&& diffBtwInputAndRanNum > 0) {
						
						anchorPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
    					topLabel.setTextFill(Color.WHITE);
    					bottomLabel.setTextFill(Color.WHITE);
						bottomLabel.setText("Too Low");
    					setPreviousNumber(inputStringToInteger);
    					userInputTextField.setText("1 to 1000");
    					userInputTextField.selectAll();
    					userInputTextField.requestFocus();
    					
					}else if(getPreviousNumber() != -1 && absValueOfInputAndRanNum > absValueOfPreNumAndRanNum 
							&& diffBtwInputAndRanNum < 0) {
						
						anchorPane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
						topLabel.setTextFill(Color.WHITE);
    					bottomLabel.setTextFill(Color.WHITE);
						bottomLabel.setText("Too High");
    					setPreviousNumber(inputStringToInteger);
    					userInputTextField.setText("1 to 1000");
    					userInputTextField.selectAll();
    					userInputTextField.requestFocus();
    					
					}else if(getPreviousNumber() != -1 && absValueOfInputAndRanNum > absValueOfPreNumAndRanNum 
							&& diffBtwInputAndRanNum > 0) {
						
						anchorPane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
						topLabel.setTextFill(Color.WHITE);
    					bottomLabel.setTextFill(Color.WHITE);
						bottomLabel.setText("Too Low");
    					setPreviousNumber(inputStringToInteger);
    					userInputTextField.setText("1 to 1000");
    					userInputTextField.selectAll();
    					userInputTextField.requestFocus();
						
					}else if(getPreviousNumber() != -1 && absValueOfInputAndRanNum == 0) {
						anchorPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
						topLabel.setTextFill(Color.BLACK);
    					bottomLabel.setTextFill(Color.BLACK);
						bottomLabel.setText("Correct!");
    					setPreviousNumber(-1);
    					userInputTextField.setEditable(false);
    					userInputTextField.setDisable(true);
    					setPlayTrigger(false);
    					enterAndPlayAgainButton.setText("Play Again");
    					randomNumber =((int)(Math.random() * ((max - min) + 1)));
    					System.out.println(randomNumber);
					}
					
				}catch(Exception e) {
					userInputTextField.setText("1 to 1000");
					userInputTextField.selectAll();
					userInputTextField.requestFocus();
				}
			}
	    }

		

	    
}

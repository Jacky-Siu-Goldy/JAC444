package w8.app;
/**********************************************
Workshop # 8
Course: JAC444 - Winter 2023
Last Name: Siu
First Name: Jacky Chun Kit 
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-29
**********************************************/
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import w8.model.DoubleArrayFunctions;
import w8.model.DoubleModel;
import w8.view.GuiView;

/**
 * Application for WorkShop 8
 * Lambda Practice
 *
 */
public class DoubleApp extends Application{
	private static GuiView Gui;
	private static DoubleModel model;
	
	/**
	 * Contain the pane which added Gui
	 * and then the pane is added to the scene
	 * and then the scene is added on to the Primary Stage ps
	 * 
	 * The Eventhandler for all the buttons and One TextField
	 * are here
	 */
	public void start(Stage ps) {
		model = new DoubleModel();
		Pane pane = new Pane();
		Gui = new GuiView(model);
		
		
		Gui.getButtonSubmit().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent a) {
				handleButtonSubmitPressed();
			}
		});
		
		Gui.getTextFieldDouble().setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				handleTextEntry();
			}
			
		});
		
		Gui.getButtonAverage().setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent a) {
				handleButtonAveragePressed();
			}
		});
		
		Gui.getButtonMax().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a) {
				handleButtonMaxPressed();
			}
		});
		
		Gui.getButtonMin().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a) {
				handleButtonMinPressed();
			}
		});
		
		Gui.getButtonSum().setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent a) {
				handleButtonSumPressed();
			}
		});
		
		Gui.getButtonCount().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a) {
				handleButtonCountPressed();
			}
		});
		
		Gui.getButtonNewArray().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent a) {
				handleButtonNewArrayPressed();
			}
		});
		
		pane.getChildren().addAll(Gui);
		Scene scene = new Scene(pane);
		ps.setTitle("DoubleArrayFunctions");
		ps.setScene(scene);
		ps.setResizable(false);
		ps.show();
		
		Gui.update();
		refreshTextFieldDouble();
		buttonsUpdate();
	}
	
	/**
	 * handle for the Submit Button
	 * Update ListView (String)doubleList to the latest addition of the DoubleArray of doubleModel
	 * refresh the TextField TextFieldDouble
	 * Update all the buttons' state 
	 */
	public void handleButtonSubmitPressed() {
		DoubleModel.add(Double.valueOf(Gui.getTextFieldDouble().getText()));
		Gui.update();
		
		refreshTextFieldDouble();
		buttonsUpdate();
	}
	
	/**
	 * handle for the New Array Button
	 * clear the ArrayList doubleArray of DoubleModel
	 * update all the buttons' state
	 * refresh the TextField TextFieldDouble
	 * set the result Label text to an empty text
	 */
	public void handleButtonNewArrayPressed() {
		DoubleModel.clear();
		Gui.update();
		buttonsUpdate();
		refreshTextFieldDouble();
		Gui.setResult("");
	}
	
	
	/**
	 * Lambda Expression that find max double value in an array of double
	 */
	public static final DoubleArrayFunctions max = (double[] array) -> {
			double max2 = 0;
			for(double element : array) {
				if (max2 < element) {
					max2 = element;
				}
			}
			return max2;
		};
		
	
	/**
	 * set the Result label with the value from  max.applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())
	 * coverted to a String argument
	 * refresh the TextField TextFieldDouble
	 * Update all the Buttons' state
	 */
	public void handleButtonMaxPressed() {
			
		Gui.setResult(String.valueOf(max.applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())));
		refreshTextFieldDouble();
		buttonsUpdate();
	}
	
	
	
	/**
	 * Lambda Expression that finds the min double value in a double Array
	 * 	
	 */
	public static final DoubleArrayFunctions min = (double[] array) -> {
			double min2 = array[0];
			for (double element : array) {
				if(min2 > element) {
					min2 = element;
				}
			}
			return min2;
		};
	
	
	/**
	 * set the Result Label with the value from min.applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())
	 * converted to a String Argument
	 * refresh the TextField TextFieldDouble
	 * Update all the Buttons' State
	 */
	public void handleButtonMinPressed() {
			
		Gui.setResult(String.valueOf(min.applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())));
		refreshTextFieldDouble();
		buttonsUpdate();
	}
	
	
	/**
	 * Lambda expression that finds the sum of the all the elements in a double Array
	 * 
	 */
		
	public static final DoubleArrayFunctions sum = (double[] array) ->{
				double sum2 = 0;
				for(double element : array) {
					sum2 += element;
				}
				return sum2;
			};
	
	
	/**
	 * set the Result Label with the value from sum.applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())
	 * converted to a String Argument
	 * refresh the TextField TextFieldDouble
	 * Update all the Buttons' State
	 */
	public void handleButtonSumPressed() {
			
		Gui.setResult(String.valueOf(sum.applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())));
		refreshTextFieldDouble();
		buttonsUpdate();
	}
	
    /**
     * The Method Counter receives a double value as an argument
     * and contain a lambda expression of the DoubleArrayFunctions (Functional Interface)
     * that finds out how many time that value occurs inside a double array
     * and returns that DoubleArrayFunctions' lambda
     * @param value - a double
     * @return DoubleArrayFunctions - a lambda of the DoubleArrayFunction functional interface
     */
	public static DoubleArrayFunctions counter (double value) {
			DoubleArrayFunctions counter2 = (double[] array) ->{
		    
			double count = 0;
				for(double element : array) {
					if (element == value) {
						count++;
					}
				}
				return count;
		    };
			return counter2;
	};
	
	
	/**
	 * set the Result Label to the value of the counter method after it receive a double value as an argument
	 * and a double array as an argument of it's lambda expression
	 * refresh the TextField TextFieldDouble
	 * Update all the Buttons' State
	 */
	public void handleButtonCountPressed() {
		double input = Double.valueOf(Gui.getTextFieldDouble().getText());
		
		Gui.setResult(String.valueOf((int)counter(input).applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())));
		refreshTextFieldDouble();
		buttonsUpdate();
	}
	
	/**
	 * Update all the Buttons' State
	 */
	public void handleTextEntry() {
		buttonsUpdate();
	}
	
	
	/**
	 * lambda expression that finds out average of all the elements of a double array
	 */
	public static final	DoubleArrayFunctions average = (double[] array) -> { 
			
			double sum = 0;
			for(double element : array ) {
			    	   sum+= element;
			}
			return sum/array.length;
		};
		
	
	/**
	 * Set the Result label to the value from average.applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())
	 * refresh the TextField TextFieldDouble
	 * Update all the Buttons' State
	 */
	public void handleButtonAveragePressed( ) {
		
		Gui.setResult(String.valueOf(average.applyDouble(DoubleModel.getDoubleArrayListtoPrimitiveArray())));
		refreshTextFieldDouble();
		buttonsUpdate();
	}	
			
			
	
	/**
	 * Set the State of each Button depending on certain Condition or Condition
	 */
	
	public void buttonsUpdate() {
		
		Pattern oneToTwoDecimalPoint = Pattern.compile("^[1-9][0-9]*\\.[0-9]{1,2}$|^0\\.[0-9]{1,2}$");
		Pattern notMatchingOneToTwoDecimalPoint = Pattern.compile("^(?!([1-9]{0,1}[0-9]*\\.[0-9]{1,2})$).*$|^0[0]+\\.[0-9]+$|^\\.[0-9]+$|^0[0]+[0-9]+\\.[0-9]+$");
		Predicate<String> asPredicate = notMatchingOneToTwoDecimalPoint.asPredicate();
		String textFieldToString = Gui.getTextFieldDouble().getText().trim();
		Matcher matcher = oneToTwoDecimalPoint.matcher(textFieldToString);
		boolean matchOrNot = !(matcher.find());
	    
		BooleanBinding validation = Bindings.createBooleanBinding(()->{
			return asPredicate.test(textFieldToString);
		}, Gui.getTextFieldDouble().textProperty()).or(Bindings.createBooleanBinding(()->{
			return Gui.getDoubleList().getItems().isEmpty();
		}, Gui.getDoubleList().getItems()));
		
		Gui.getButtonSubmit().setDisable(matchOrNot);
		Gui.getButtonAverage().disableProperty().bind(Bindings.isEmpty(Gui.getDoubleList().getItems()));
		Gui.getButtonCount().disableProperty().bind(validation);
		Gui.getButtonMax().disableProperty().bind(Bindings.isEmpty(Gui.getDoubleList().getItems()));
		Gui.getButtonMin().disableProperty().bind(Bindings.isEmpty(Gui.getDoubleList().getItems()));
		Gui.getButtonNewArray().disableProperty().bind(Bindings.isEmpty(Gui.getDoubleList().getItems()));
		Gui.getButtonSum().disableProperty().bind(Bindings.isEmpty(Gui.getDoubleList().getItems()));
			
	}
	
	/**
	 * set the Text of TextFieldDouble to "Enter a double with 1 or 2 decimal places"
	 * Select all of the TextField
	 * set the Focus on the TextField
	 */
	public void refreshTextFieldDouble() {
		Gui.getTextFieldDouble().setText("Enter a double with 1 or 2 decimal places");
		Gui.getTextFieldDouble().selectAll();
		Gui.getTextFieldDouble().requestFocus();
	}
	
	/**
	 * Main of the Application
	 * @param args - a String Array
	 */
	public static void main(String[] args) {
		
		launch(args);
	}

}

//^[1-9][0-9]*\.[0-9]{1,2}$|^0\.[0-9]{1,2}$
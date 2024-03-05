package w8.view;
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
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import w8.model.DoubleModel;

public class GuiView extends Pane{
	private ListView<String> doubleList;
	private DoubleModel doubleModel;
	
	private Button buttonMax;
	private Button buttonMin;
	private Button buttonSum;
	private Button buttonAverage;
	private Button buttonCount;
	private Button buttonNewArray;
	private Button buttonSubmit;
	private Label result;
	private TextField textFieldDouble;
	
	/**
	 * constructor with Field for GuiView
	 * @param doubleModel - DoubleModel type, use to initialize doubleModel
	 */
	public GuiView(DoubleModel doubleModel) {
		this.doubleModel = doubleModel;
		doubleList = new ListView<>();
		buttonMax = new Button("Max");
		buttonMin = new Button("Min");
		buttonSum = new Button("Sum");
		buttonAverage = new Button("Average");
		buttonCount = new Button("Count");
	    buttonNewArray = new Button("New Array");
	    buttonSubmit = new Button("Submit");
		textFieldDouble = new TextField();
		result = new Label("");
		
	    doubleList.setPrefSize(150,410);
		doubleList.relocate(10,10);
		
		result.relocate(190,110);
		
		textFieldDouble.setPrefSize(250,12);
		textFieldDouble.relocate(190,160);
		
		
		buttonSubmit.setPrefSize(100,10);		
		buttonSubmit.relocate(190,200);
		
		buttonMax.setPrefSize(100,10);
		buttonMax.relocate(190, 240);
		
		buttonMin.setPrefSize(100,10);
		buttonMin.relocate(295,240);
		
		buttonSum.setPrefSize(100,10);
		buttonSum.relocate(400,240);
		
		buttonAverage.setPrefSize(100, 10);
		buttonAverage.relocate(190,280);
		
		buttonCount.setPrefSize(100, 10);
		buttonCount.relocate(295,280);
		
		buttonNewArray.setPrefSize(100, 10);
		buttonNewArray.relocate(400,280);
		
		getChildren().addAll(doubleList, result, textFieldDouble, buttonSubmit, buttonMax, buttonMin, buttonSum, buttonAverage, buttonCount, buttonNewArray);
		
		this.setPrefSize(590,430);
		
		update();
		
	}
	
	/**
	 * get the Field doubleList a listView (String) type
	 * @return doubleList - a listView(String) type
	 */
	public ListView<String> getDoubleList() {
		return doubleList;
	}
	
	
	/**
	 * Set the Label result base on the String received
	 * @param result - A String
	 */
	public void setResult(String result) {
		this.result.setText(result);
	}
	
	
	/**
	 * get the button buttonMax
	 * @return buttonMax - a button
	 */
	public Button getButtonMax() {
		return buttonMax;
	}

	/**
	 * get the button buttonMin
	 * @return buttonMin - a button
	 */
	public Button getButtonMin() {
		return buttonMin;
	}
	
	/**
	 * get the button buttonSum
	 * @return buttonSum - a button
	 */
	public Button getButtonSum() {
		return buttonSum;
	}
	
	/**
	 * get the button buttonAverage
	 * @return buttonAverage - a button
	 */
	public Button getButtonAverage() {
		return buttonAverage;
	}

	/**
	 * get the button buttonCount
	 * @return buttonCount - a button
	 */
	public Button getButtonCount() {
		return buttonCount;
	}

	/**
	 * get the button buttonNewArray
	 * @return buttonNewArray - a button
	 */
	public Button getButtonNewArray() {
		return buttonNewArray;
	}
	
	/**
	 * get the button buttonSubmit
	 * @return buttonSubmit - a button
	 */
	public Button getButtonSubmit() {
		return buttonSubmit;
	}
	
	/**
	 * get the TextField textFieldDouble
	 * @return textFieldDouble - A TextField
	 */
	public TextField getTextFieldDouble() {
		return textFieldDouble;
	}
	
	
	/**
	 * Update doubleList to the latest addition of the DoubleArray of doubleModel
	 */
	public void update() {
		
		 String[] doubleToStringArray = new String[doubleModel.getSize()];
		
		for(int i = 0; i < doubleModel.getSize(); i++) {
			doubleToStringArray[i] = String.valueOf(DoubleModel.getDoubleArrayListtoPrimitiveArray()[i]);
		}
		
		doubleList.setItems(FXCollections.observableArrayList(doubleToStringArray));
		doubleList.getFocusModel().focus(0);
		
	}
	
	

}

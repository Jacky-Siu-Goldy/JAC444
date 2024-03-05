package w7.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
/**********************************************
Workshop # 7
Course: JAC444 - Winter 2023
Last Name: Siu
First Name: Jacky Chun Kit 
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-24
**********************************************/

/**
 * 
 * @author Jacky Chun Kit Siu
 * Class of the Address Pane
 */
public class AddressPane extends Pane {
    private Label lblName;
    private Label lblStreet;
    private Label lblCity;
    private Label lblProvince;
    private Label lblPostalCode;
    private Label lblTitle;
    private TextField txtName;
    private TextField txtStreet;
    private TextField txtCity;
    private TextField txtProvince;
    private TextField txtPostalCode;
   /**
    * Design of the Address Pane
    */
    public AddressPane() {
    	StackPane border = new StackPane();
    	GridPane grid = new GridPane();
    	 lblName = new Label("Name:");
         lblStreet = new Label("Street:");
         lblCity = new Label("City:");
         lblProvince = new Label("Province:");
         lblPostalCode = new Label("Postalcode:");
         lblTitle = new Label("CONTACT ADDRESS");
         txtName = new TextField();
         txtStreet = new TextField();
         txtCity = new TextField();
         txtProvince = new TextField();
         txtPostalCode = new TextField();
    	grid.add(lblName, 0, 0);
    	grid.add(txtName, 1, 0);
    	grid.add(lblStreet, 0, 1);
    	grid.add(txtStreet, 1, 1);
    	grid.add(lblCity, 0, 2);
    	grid.add(txtCity, 1, 2);
    	grid.add(lblProvince, 0, 3);
    	grid.add(txtProvince, 1, 3);
    	grid.add(lblPostalCode, 0, 4);
    	grid.add(txtPostalCode, 1, 4);
    	grid.setHgap(2);
    	grid.setVgap(2);
    	grid.setPadding(new Insets(10,10,10,10));
    	
    	GridPane.setHgrow(txtName, Priority.ALWAYS);
    	GridPane.setHgrow(txtStreet, Priority.ALWAYS);
    	GridPane.setHgrow(txtCity, Priority.ALWAYS);
    	GridPane.setHgrow(txtProvince, Priority.ALWAYS);
    	GridPane.setHgrow(txtPostalCode, Priority.ALWAYS);
    	GridPane.setVgrow(txtName, Priority.ALWAYS);
    	GridPane.setVgrow(txtStreet, Priority.ALWAYS);
    	GridPane.setVgrow(txtCity, Priority.ALWAYS);
    	GridPane.setVgrow(txtProvince, Priority.ALWAYS);
    	GridPane.setVgrow(txtPostalCode, Priority.ALWAYS);
    	
    	
    	
    	lblTitle.setStyle("-fx-text-fill: black;" + "-fx-background-color: white" );
    	lblTitle.relocate(12,2);
    	//border.setStyle("-fx-border-insets: 30 0 0 0;" + "-fx-border-color: black;");
    	grid.setStyle("-fx-border-insets: 10 10 10 0;" + "-fx-border-color: black;" + "-fx-background-color: white");
    
        
        grid.setPrefSize(410,200);
    	
    	
    	
    	
    	getChildren().addAll( grid, border,lblTitle);
    	
    }

	

    /**
     * set the Label lblTitle on the Address Pane
     * @param lblTitle - a String
     */
	public void setLblTitle(String lblTitle) {
		this.lblTitle.setText(lblTitle);
	}
    /**
     * get the TextField txtName
     * @return txtName - a TextField
     */
	public TextField getTxtName() {
		return txtName;
	}
	
	/**
	 * set the TextField txtName
	 * @param txtName - a String
	 */
	public void setTxtName(String txtName) {
		this.txtName.setText(txtName); 
	}

	/**
	 * get the TextField txtStreet
	 * @return txtStreet - a TextField
	 */
	public TextField getTxtStreet() {
		return txtStreet;
	}

	/**
	 * set the TextField txtStreet
	 * @param txtStreet - a String
	 */
	public void setTxtStreet(String txtStreet) {
		this.txtStreet.setText(txtStreet);
	}
	
	/**
	 * get the TextField txtCity
	 * @return txtCity - a TextField
	 */
	public TextField getTxtCity() {
		return txtCity;
	}
	
	/**
	 * set the TextField txtCity
	 * @param txtCity - a String
	 */
	public void setTxtCity(String txtCity) {
		this.txtCity.setText(txtCity);
	}
	/**
	 * get the TextField txtProvince
	 * @return txtProvince - a TextField
	 */
	public TextField getTxtProvince() {
		return txtProvince;
	}
	
	/**
	 * set the TextField txtProvince
	 * @param txtProvince - a String
	 */
	public void setTxtProvince(String txtProvince) {
		this.txtProvince.setText(txtProvince);;
	}
	
	/**
	 * get the TextField txtPostalCode
	 * @return txtPostalCode - a TextField
	 */
	public TextField getTxtPostalCode() {
		return txtPostalCode;
	}
	
	/**
	 * set the TextField txtPostalCode
	 * @param txtPostalCode - a String
	 */
	public void setTxtPostalCode(String txtPostalCode) {
		this.txtPostalCode.setText(txtPostalCode);
	}

	

	
	
	


	
    
   
}

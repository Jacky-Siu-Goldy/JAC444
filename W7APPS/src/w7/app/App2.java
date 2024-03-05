package w7.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import w7.model.Address;
import w7.model.InformationList;
import w7.view.AddressPane;
import w7.view.NameListView;
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
 * App2 application
 *
 */
public class App2 extends Application{
	private AddressPane homeAddress;
	private AddressPane alternativeAddress;
	private NameListView nameListPane;
	private InformationList infoList;
	private Button addButton;
	private Button removeButton;

	/**
	 * Design of the Scene of the primary Stage
	 */
	public void start(@SuppressWarnings("exports") Stage ps) {
		
		Pane ap = new Pane();
		
		
		
		homeAddress = new AddressPane();
		homeAddress.setLblTitle("HOME ADDRESS");
		homeAddress.relocate(170, 10);
		
	    alternativeAddress = new AddressPane();
		alternativeAddress.setLblTitle("ALTERNATIVE ADDRESS");
		alternativeAddress.relocate(170, 210);
		
		infoList = new InformationList();
	    nameListPane = new NameListView(infoList);
		nameListPane.relocate(10, 10);
		
		addButton = new Button("Add");
		addButton.relocate(175, 410);
		addButton.setPrefSize(70,10);
		
		removeButton = new Button("Remove");
		removeButton.relocate(250, 410);
		removeButton.setPrefSize(70, 10);
		
		this.addButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				handleAddButtonPress();
			}
		});
		
		this.removeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				handleRemoveButtonPress();
			}
		});
		
		homeAddress.getTxtName().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		homeAddress.getTxtStreet().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		homeAddress.getTxtCity().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		homeAddress.getTxtProvince().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		homeAddress.getTxtPostalCode().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		alternativeAddress.getTxtName().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		alternativeAddress.getTxtStreet().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		alternativeAddress.getTxtCity().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		alternativeAddress.getTxtProvince().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		alternativeAddress.getTxtPostalCode().setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent m) {
				handleTextEntry();
			}
		});
		
		nameListPane.getNameList().setOnMousePressed(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent m) {
				handleListSelection();
			}
		});
		ap.getChildren().addAll(nameListPane, homeAddress, alternativeAddress, addButton, removeButton);
		ap.setPrefSize(590, 440 );
		Scene scene = new Scene(ap);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		ps.setResizable(false);
		ps.setTitle("App2");
		ps.setScene(scene);
		this.buttonsUpdate();
		ps.show();
		
		
		
	}
	/**
	 * if the homeAddress's name, street, city, province, postal code, their String lengths are all greater then 0
	 * and also if the alternative Address's name, street, city, province, postal code, their String lengths are all greater then 0
	 * Then two new Address Object will be created and be added to the Address Array of infoList
	 * 
	 * the nameListPane will upDate
	 * and the buttons 's state will be updated as well
	 */
	private void handleAddButtonPress() {
		String hTN = homeAddress.getTxtName().getText().trim();
		String hTS = homeAddress.getTxtStreet().getText().trim();
		String hTC = homeAddress.getTxtCity().getText().trim();
		String hTP = homeAddress.getTxtProvince().getText().trim();
		String hTPC = homeAddress.getTxtPostalCode().getText().trim();
		String aTN = alternativeAddress.getTxtName().getText().trim();
		String aTS = alternativeAddress.getTxtStreet().getText().trim();
		String aTC = alternativeAddress.getTxtCity().getText().trim();
		String aTP = alternativeAddress.getTxtProvince().getText().trim();
		String aTPC = alternativeAddress.getTxtPostalCode().getText().trim();
		
		Address homeAddress2; 
		
		Address alternativeAddress2; 
		
		if(hTN.length() > 0 &&  hTS.length() > 0 &&  hTC.length() > 0 && hTP.length() > 0 && hTPC.length() > 0 
				&& aTN.length() > 0 && aTS.length() > 0 && aTC.length() > 0 && aTP.length() > 0 && aTPC.length() > 0) {
			
			homeAddress2 = new Address("Home Address", hTN, hTS, hTC, hTP, hTPC);
			alternativeAddress2 = new Address("Alternative Address", aTN, aTS, aTC, aTP, aTPC);
            infoList.add(homeAddress2);
            infoList.add(alternativeAddress2);
            homeAddress.setTxtName("");
            homeAddress.setTxtStreet("");
            homeAddress.setTxtCity("");
            homeAddress.setTxtProvince("");
            homeAddress.setTxtPostalCode("");
            alternativeAddress.setTxtName("");
            alternativeAddress.setTxtStreet("");
            alternativeAddress.setTxtCity("");
            alternativeAddress.setTxtProvince("");
            alternativeAddress.setTxtPostalCode("");
            
            nameListPane.update();
            this.buttonsUpdate();
		}
	}
	
	/**
	 * if the index of the nameList of the nameListPane is greater or equal to 0
	 * Then the infoList will remove both the homeAddress and the alternative Address
	 * of the same Person.
	 * 
	 *The nameListPane will update
	 *and buttons's state will Update
	 */
	public void handleRemoveButtonPress() {
		int index = nameListPane.getNameList().getSelectionModel().getSelectedIndex();
		
		if (index >= 0) {
			infoList.remove(index*2);
			infoList.remove(index*2);
			nameListPane.update();
			this.buttonsUpdate();
		}
	}
	
	/**
	 * buttons' State will Update
	 */
	public void handleTextEntry() { 
		
		this.buttonsUpdate();
	}
	
	/**
	 * Get the nameList's Selected Index
	 * and print the name, street, city, province and postal code of the homeAddress and the alternativeAddress of that person
	 * on to the console
	 * And Update the nameListPane and Update the Buttons' state.
	 */
	public void handleListSelection() {
		int index = nameListPane.getNameList().getSelectionModel().getSelectedIndex();
		System.out.println(infoList.getAddresses()[index*2].getKindOfAddr());
		System.out.println(infoList.getAddresses()[index*2].getName());
		System.out.println(infoList.getAddresses()[index*2].getStreet());
		System.out.println(infoList.getAddresses()[index*2].getCity());
		System.out.println(infoList.getAddresses()[index*2].getProvince());
		System.out.println(infoList.getAddresses()[index*2].getPostalCode() + "\n");
		System.out.println(infoList.getAddresses()[index*2 + 1].getKindOfAddr());
		System.out.println(infoList.getAddresses()[index*2 + 1].getName());
		System.out.println(infoList.getAddresses()[index*2 + 1].getStreet());
		System.out.println(infoList.getAddresses()[index*2 + 1].getCity());
		System.out.println(infoList.getAddresses()[index*2 + 1].getProvince());
		System.out.println(infoList.getAddresses()[index*2 + 1].getPostalCode()+ "\n");
		nameListPane.update();
		this.buttonsUpdate();
	}
	
	/**
	 * Disable the remove button if the index of the nameList of nameListPane is less then 0
	 * 
	 * Disable the add button if any of the TextField is not filled or if the HomeAddress's name is not the same as the AlternativeAddress's name
	 */
	public void buttonsUpdate() {
        removeButton.setDisable(nameListPane.getNameList().getSelectionModel().getSelectedIndex() < 0);
		
		addButton.setDisable(homeAddress.getTxtName().getText().trim().length() == 0 || homeAddress.getTxtStreet().getText().trim().length() == 0
				|| homeAddress.getTxtCity().getText().trim().length() == 0 || homeAddress.getTxtProvince().getText().trim().length() == 0
				|| homeAddress.getTxtPostalCode().getText().trim().length() == 0 || alternativeAddress.getTxtName().getText().trim().length() == 0 
				|| alternativeAddress.getTxtStreet().getText().trim().length() == 0 || alternativeAddress.getTxtCity().getText().trim().length() == 0 
				|| alternativeAddress.getTxtProvince().getText().trim().length() == 0 || alternativeAddress.getTxtPostalCode().getText().trim().length() == 0
				|| !(homeAddress.getTxtName().getText().trim().equals(alternativeAddress.getTxtName().getText().trim())));
	}
	
	/**
	 * Main of the application
	 * @param args - a String[]
	 */
	public static void main(String[] args) {
		
		launch(args);
		
	}

}

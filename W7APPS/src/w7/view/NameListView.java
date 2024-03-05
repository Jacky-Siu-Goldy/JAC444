package w7.view;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import w7.model.Address;
import w7.model.InformationList;
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
 * The Class NameListView
 *
 */
public class NameListView extends Pane {
	private ListView<String> nameList;
	private InformationList infoList;
	private String[] exNames;
	
	/**
	 * Design of NameListView
	 * @param infoList - an object of InformationList. It is used to initialize the member variable infoList which is of the same type
	 */
	public NameListView(InformationList infoList) {
		
		this.infoList = infoList;
		nameList = new ListView<>();
		
		
		
		nameList.setPrefSize(150,410);
		getChildren().addAll(nameList);
		
		update();
	}
	
	/**
	 * get the nameList
	 * @return nameList - a ListView<String> type
	 */
	public ListView<String> getNameList() {
		return nameList;
	}

	
	
    /**
     * get infoList
     * @return infoList - a member object of the InformationList class
     */
	public InformationList getInfoList() {
		return infoList;
	}

	
	/**
	 * Update nameList base on changes in the infoList object
	 */

	public void update() {
		Address[] exAddresses = new Address[infoList.getSize()];//exact number of addresses
		exNames = new String[infoList.getSize()/2];
		for(int i = 0, g = 0; i < infoList.getSize(); i++) {
			exAddresses[i] = infoList.getAddresses()[i];
			if (i % 2 == 0) {
				exNames[g] = exAddresses[i].getName();
				g++;
			}
		}
		int selectedIndex = nameList.getSelectionModel().getSelectedIndex();
		
		nameList.setItems(FXCollections.observableArrayList(exNames));
		nameList.getSelectionModel().select(selectedIndex);
		
		
	}


}

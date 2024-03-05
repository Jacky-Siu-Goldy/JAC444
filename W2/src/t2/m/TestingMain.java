/**********************************************
Workshop # 2
Course: JAC444 - Winter 2023
Last Name: Siu
First Name: Jacky Chun Kit 
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-08
**********************************************/
package t2.m;

import t2.gio.GroceryItemOrder;
import t2.gl.GroceryList;
/**
 * This Class is the main of GroceryList and GroceryItemOrder.
 * It tests the functionality of all of the methods in GroceryList and GroceryItemOrder.
 * @author Jacky Chun Kit Siu
 *
 */
public class TestingMain {
	public static void main(String[] args) {
		GroceryItemOrder[] groceryListMain = new GroceryItemOrder[11];
		groceryListMain[0] = new GroceryItemOrder("Orange", 6, 0.87);
		groceryListMain[1] = new GroceryItemOrder("Apple", 3, 0.95);
		groceryListMain[2] = new GroceryItemOrder("Salmon", 1, 12.99);
		groceryListMain[3] = new GroceryItemOrder("Lettuce", 1, 3.45);
		groceryListMain[4] = new GroceryItemOrder("Frozen Peas",2, 4.75);
		groceryListMain[5] = new GroceryItemOrder("Aluminum Foil",2, 4.00);
		groceryListMain[6] = new GroceryItemOrder("Milk", 2, 5.45);
		groceryListMain[7] = new GroceryItemOrder("Banana", 2, 3.25);
		groceryListMain[8] = new GroceryItemOrder("Mango",4,2.45);
		groceryListMain[9] = new GroceryItemOrder("Chicken Breast", 3, 8.75);
		groceryListMain[10] = new GroceryItemOrder("Coca Cola", 2, 8.00);
		
		GroceryList gL = new GroceryList();
		
		for(int i = 0; i < 6; i++) {
			gL.add(groceryListMain[i]);
		}
		
		System.out.println("If displays works it means (getName(), getQuantity(), getPricePerUnit()),\n"
							+ "setName(String nsme), setQusntity(int quantity), \n"
							+ "setPricePerUnit(double pricePerUnit) + getCost() and getTotalCost() All Worked");
		gL.displayGroceryList();
		System.out.print("\n\n\n");
		System.out.println("Filling the array to full (10 items)");
		for(int i = 6; i < 10; i++) {
			gL.add(groceryListMain[i]);
		}
		
		
		gL.displayGroceryList();
		System.out.print("\n\n\n");
		System.out.print("Testing GroceryList Limit of 10 items by adding one more an 11th item.\n\n");
		gL.add(groceryListMain[10]);
		
		System.out.print("\n\n\n");
		System.out.print("Display again to see if there is any changes to the array \n"
				+ "If it is the same as before It means add(groceryItemOrder Item) Worked \n");
		gL.displayGroceryList();
	}
}

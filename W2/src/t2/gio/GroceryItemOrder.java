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
package t2.gio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GroceryItemOrder {
	private String name;
	private int quantity;
	private double pricePerUnit;
	
	/**
	 * Constructor for the Class GroceryItemOrder.
	 * @param name -- initialize the member variable name that is of the String type.
	 *                name represent the name of the grocery item. 
	 * @param quantity -- initialize the member variable quantity that is of the integer type.
	 *                    quantity how many units of the grocery item is there. 
	 * @param pricePerUnit -- initialize the member variable pricePerUnit that is of the double type.
	 * 						  pricePerUnit is how much a Unit of a grocery item cost.
	 */
	public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
		this.name = name;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}
	
	/**
	 * This method sets the member variable name that is of the String type.
	 * @param name  -- It is of a String type.
	 *                 name represent the name of the grocery item. 
	 */
	public void setName (String name) {
		this.name = name;
	}
	
	/**
	 * This method sets the member variable quantity that is of the integer type.
	 * @param quantity -- It is of an integer type.
	 *                    quantity is how many units of the grocery item is there. 
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * This method sets the member variable pricePerUnit that is of the double type.
	 * @param pricePerUnit -- It is of a double type.
	 *                        pricePerUnit is how much a Unit of a grocery item cost.
	 */
	public void setPricePerUnit(double pricePerUnit) {
		BigDecimal bdUp = new BigDecimal(pricePerUnit).setScale(2, RoundingMode.UP);
		this.pricePerUnit = bdUp.doubleValue();
	}
	/**
	 * This method return the member variable name.
	 * @return name -- It is of a String type.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method return the member variable quantity.
	 * @return quantity --It is of an integer type.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * This method return the member variable pricePerUnit.
	 * @return pricePerUnit --It is of a double type.
	 */
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	/**
	 * This method calculate the cost of item base on the price and the number of Units purchased
	 * @return bdUp.doubleValue() -- The rounded value of the calculated cost, scale is set to 2 
	 * 							     significant digit after the decimal and is rounded up.
	 */
	public double getCost() {
		BigDecimal bdUp = new BigDecimal((this.quantity * this.pricePerUnit)).setScale(2, RoundingMode.UP);
		return bdUp.doubleValue();
	}
}

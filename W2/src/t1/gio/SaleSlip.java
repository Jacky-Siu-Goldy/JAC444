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
package t1.gio;

public class SaleSlip {
	private int person;
	private int product;
	private double value;
    /**
     * Constructor for the object SaleSlip	
     * @param person -- person is of an integer type use to initialize the member variable person
     *                  person represent a sale person
     *                  
     * @param product -- product is of an integer type use to initialize the member variable product
     *                   product represent the number of a product
     *                   
     * @param value -- value is of a double type use to initialize the member variable value
     * 					value represent the total sale of a product in a day
     */
	public SaleSlip(int person, int product, double value) {
		this.person = person;
		this.product =product;
		this.value = value;
	};
	
	/**
	 * This method return the member variable person
	 * @return person -- a member variable that is of an integer type
	 */
	public int getPerson() {
		return person;
	}
	
	/**
	 * This method return the member variable product
	 * @return product -- a member variable that is of an integer type 
	 */
	public int getProduct() {
		return product;
	}
	
	/**
	 * This method return the member variable value
	 * @return value -- a member variable that is of a double type
	 */
	public double getValue() {
		return value;
	}
}

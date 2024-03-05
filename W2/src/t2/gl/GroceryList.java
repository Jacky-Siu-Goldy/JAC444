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
package t2.gl;

import t2.gio.GroceryItemOrder;

public class GroceryList {
	GroceryItemOrder[] groceryList = new GroceryItemOrder[10];
	private int groceryListCount;
	private double totalCost;
	
	/**
	 * Constructor for the class GroceryList
	 * Initialize member groceryList array of the GroceryItemOrder[] Type
	 * Initialize member variable (type int) groceryListCount  to 0
	 * Initialize member variable (type double) totalCost to 0.00
	 */
	public GroceryList() {
		
		for(int i = 0; i < 10; i++) {
			groceryList[i] = new GroceryItemOrder("", 0, 0.00);
		}
		groceryListCount = 0;
		totalCost = 0.00;
	}
	/**
	 * This method copy to value of the properties of the Object in the parameter of a 
	 * GroceryItemOrder type into the properties of an element in the groceryListArray
	 * in a sense adding an item into the array by copying the information
	 * The member variable groceryListCount is increment by 1 every time an item is added
	 * until it reaches the count of 10 which is the size of the array.
	 * At that point no more item is added. And the method prints out "GroceryList is Full" 
	 * to the Console.
	 * @param Item -- Object variable is of the GroceryItemOrder Type
	 */
	public void add(GroceryItemOrder Item) {
		if (groceryListCount == 10) {
			System.out.println("GroceryList is Full");
		}else if (groceryListCount == 0) {
			
			groceryList[0].setName(Item.getName());
			groceryList[0].setQuantity(Item.getQuantity());
			groceryList[0].setPricePerUnit(Item.getPricePerUnit());
			groceryListCount += 1;
		}else {
			groceryList[groceryListCount].setName(Item.getName());
			groceryList[groceryListCount].setQuantity(Item.getQuantity());
			groceryList[groceryListCount].setPricePerUnit(Item.getPricePerUnit());
			groceryListCount += 1;
		}
	}
	
	/**
	 * This method set the member variable  of totalCost by recalculating it 
	 * and renewing the value of totalCost every time this method is called
	 * totalCost is the Total of the Cost of buying all the items on the groceryList
	 */
	public void setTotalCost() {
		
		totalCost = 0.00;
	
		for(int i = 0; i < groceryListCount; i++) {
			totalCost += groceryList[i].getCost();
		}

	}
	/**
	 * This method first called the method setTotalCost() and then return totalCost
	 * {@link #setTotalCost}
	 * @return totalCost --member variable that is of the double type
	 * totalCost is the Total of the Cost of buying all the items on the groceryList 
	 */
	public double getTotalCost() {
		setTotalCost();
		return totalCost;
	}
	/**
	 * This method right pad the inputed string
	 * @param input -- a string to be right padded
	 * @param ch --character to fill up the space padding
	 * @param L -- an Integer used in this method to determine the length
	 *             of spaces to right pad the (input) String
	 * @return result --the Resultant String
	 */
	public static String rightPadding(String input, char ch, int L)
    {
		// First right pad the string                 // Then replace all the spaces
        // with space up to length  L                   // with the given character ch
    	String result = String.format("%" + (-L) + "s", input).replace(' ', ch);
        // Return the resultant string
        return result;
    }
	
	/**
	 * This method right pad the inputed double by formating it into a string
	 * and then right padding it
	 * 
	 * @param input -- a double to be right padded
	 * @param ch --character to fill up the space padding
	 * @param L -- an Integer used in this method to determine the length
	 *             of spaces to right pad the (input) double
	 * @return result --the Resultant String
	 */
    public static String rightPadding(double input, char ch, int L)
    {
		String processStr = String.format("%.2f",input);
		                       // First right pad the string       // Then replace all the spaces
                               // with space up to length  L       // with the given character ch
		String result = String.format("%" + (-L) + "s", processStr).replace(' ', ch);
        // Return the resultant string
        return result;
    }
    
    /**
	 * This method left pad the inputed string
	 * @param input -- a string to be left padded
	 * @param ch --character to fill up the space padding
	 * @param L -- an Integer used in this method to determine the length
	 *             of spaces to left pad the (input) String
	 * @return result --the Resultant String
	 */
    public static String leftPadding(String input, char ch, int L)
    {
	                        // First left pad the string     // Then replace all the spaces
                            // with space up to length L    // with the given character ch
        String result = String.format("%" + L + "s", input).replace(' ', ch);
    // Return the resultant string
        return result;
    }
	
    /**
     * Create a visual display of the items in the groceryList array
     * Including each element's properties' value such as name, quantity, price
     * It calls getCost() to get the value of how much in total each item cost and displays it.
     * It calls getTotalCost() to get the value of how much in total all of the items added 
     * together and displays it at the bottom
     */
	public void displayGroceryList() {
		if (groceryListCount == 0) {
			System.out.println("GroceryList is Empty");
		}else {
			System.out.println("Item          Quantity            Price         Cost");
			for(int i = 0; i < groceryListCount; i++) {
			 System.out.print(rightPadding((i + 1)+ ": " + groceryList[i].getName(),' ',20));
			 System.out.print(rightPadding(""+groceryList[i].getQuantity(), ' ', 14));
			 System.out.print(rightPadding(groceryList[i].getPricePerUnit(), ' ', 14));
			 System.out.println(String.format("%.2f", groceryList[i].getCost()));
			}
			 System.out.println(leftPadding("Total Cost:" + this.getTotalCost(), ' ', 53));
		}
	}
}

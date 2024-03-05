/**********************************************
Workshop # 3
Course: JAC444 - Semester
Last Name: Siu
First Name: Chun Kit Jacky
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-15
**********************************************/
package w3.abstr;


/**
 * abstract class Ticket
 * @author Jacky Chun Kit Siu
 *
 */
public abstract class Ticket {

	protected int number;
	/**
	 * Constructor for the class Ticket 
	 * @param number --initializes the member variable number 
	 */
	public Ticket(int number) {
		this.number = number;	
	}
	/**
	 * It is an abstract method and is a method declaration. 
	 * It gets the number of days before the event when it 
	 * is implemented by the subclass that inherits the Ticket 
	 * class.	
	 * @return daysBeforeEvent--It is an integer. It would be a 
	 * member variable of the subclass when this method is 
	 * implemented by a subclass.
	 */
	protected abstract int getDaysBeforeEvent();
	/**
	 * It is an abstract method and is a method declaration. It sets 
	 * the member variable daysBeforeEvent of the subclass when implement 
	 * by the subclass
	 * @param numOfDaysLeft--when implemented it is going to receive
	 * an integer; A member variable of the Class TicketMain whose value is 
	 * generated by a class method setNumOfDaysLeft of TicketMain
	 */
	public abstract void setDaysBeforeEvent(int numOfDaysLeft);
	/**
	 * It is an abstract method and is a method declaration. It get the price
	 * of a ticket when implemented by the subclass.
	 * @return price -- a member variable of the subclass when implemented
	 * by the subclass
	 */
	protected abstract double getPrice();
	
	/**
	 * It is an abstract method and is a method declaration. It set the price
	 * of a ticket base on the number of days before the Event when implemented
	 * by the subclass
	 */
	protected abstract void setPrice();
	
	/**
	 * It is an abstract method and is a method declaration. Overload the ToString()
	 * method
	 * @return a string --It is used for printing the ticket
	 */
    public abstract String  toString();
}

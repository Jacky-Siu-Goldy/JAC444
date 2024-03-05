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
package w3.adv;

import w3.abstr.Ticket;
/**
 * This class represent a category of ticket. An advance ticket can only be
 * purchase 1 or more days in advance before the Event.
 * @author Jacky Chun Kit Siu
 *
 */
public class AdvanceTicket extends Ticket{
	
	
	protected double price;
	protected int daysBeforeEvent;
	/**
	 * Constructor initializes the member variable daysBeforeEvent and the
	 * member variable price. It uses the super construct to pass
	 * the parameter number to the parent constructor there by initializing
	 * a ticket number for itself. It passes the parameter numOfDaysLeft to
	 * the function setDaysBeforeEvent to set the member variable daysBeforeEvent.
	 * @param number --An Integer value that is pass on to the parent constructor
	 * @param numOfDaysLeft --An Integer value representing the number of days
	 *                        before the Event.
	 */
	public AdvanceTicket(int number, int numOfDaysLeft) {
		super(number);
		setDaysBeforeEvent(numOfDaysLeft);
		setPrice();
	}
	
	/**
	 * sets the number days before the Event.
	 */
	@Override
	public void setDaysBeforeEvent(int numOfDaysLeft) {
		
		daysBeforeEvent = numOfDaysLeft;
	}
	
	/**
	 * returns an integer value representing number of days left
	 * before the Event from the member variable daysBeforeEvent
	 */
    @Override
	protected int getDaysBeforeEvent() {
		return daysBeforeEvent;
	}
	
    /**
     * set the member variable price base on the number of days left
     * before the Event
     */
    @Override
	protected void setPrice() {
		int daysLeft = getDaysBeforeEvent();
		
		if (daysLeft >= 10) {
			this.price = 30.00;
		}else if ( daysLeft >= 1 &&daysLeft < 10) {
			this.price = 40.00;
		}else {
			this.price =0.00;
		}
	}
    
    /**
     * Return the price of the ticket
     * @return price --a double value representing the price of the ticket
     */
	@Override
	protected double getPrice() {
		
		return price;
	}
	
	/**
	 * an overloaded toString() method. Returns a String that contain the information
	 * on the printed out ticket Should it be printed on the console.
	 * 
	 * @return a String -- containing the ticket number, ticket price, number of days
	 *                     in advance.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Number: " + super.number + "  Price: " + this.getPrice() 
		       + "  Days in Advance: " + getDaysBeforeEvent();
	}
	
	

}

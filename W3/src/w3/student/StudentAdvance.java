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
package w3.student;

import w3.adv.AdvanceTicket;

/**
 * A class that represent Student Advance Ticket that can be purchase if
 * the days left before the Event is greater or equal to 1.
 * @author Jacky Chun Kit Siu
 *
 */
public class StudentAdvance extends AdvanceTicket {
	protected String studentID;
	/**
	 * Constructor initializes the parent member variable daysBeforeEvent
	 * and the grand parent's member variable number, and its own member
	 * variable studentID.
	 * It uses the super constructor to pass the parameter number and the 
	 * parameter numOfDaysLeft to the parent constructor there by initializing 
	 * a ticket number for itself and initializes daysBeforeEvent a member 
	 * variable of the parent. 
	 * @param number --An Integer value that is pass on to the parent constructor
	 * @param numOfDaysLeft --An Integer value representing the number of days
	 *                        before the Event.
	 * @param studentID -- A string value represent the required student ID.
	 */
	public StudentAdvance(int number, int numOfDaysLeft, String studentID) {
		super(number, numOfDaysLeft);
		this.studentID = studentID;
		
	}
	
	/**
     * set the parent member variable price base on the number of days left
     * before the Event
     */
	@Override
	protected void setPrice() {
		int daysLeft = super.getDaysBeforeEvent();
		
		if (daysLeft >= 10) {
			super.price = 15.00;
		}else if (daysLeft >=1 && daysLeft < 10) {
			super.price = 20.00;
		}else {
			super.price = 0.00;
		}
	}
	
	/**
	 * Returns the parent member variable price
	 */
	@Override
	protected double getPrice() {
		return super.price;
	}
	
	/**
	 * an overloaded toString() method. Returns a String that contain the information
	 * on the printed out ticket Should it be printed on the console.
	 * 
	 * @return a String -- containing the ticket number, ticket price, studentID,
	 *                     number of days in advance.
	 */
	@Override
	public String toString() {
		return  "Number: " + super.number +"  Price: " + super.getPrice()
		        + "  Student ID: " + getStudentID() + "  Days in Advance: " + super.getDaysBeforeEvent();
	};
	
	/**
	 * Return a String representing the ID of a student
	 * @return studentID -- A String from a member variable studentID
	 */
	protected String getStudentID() {
		return studentID;
	}

}

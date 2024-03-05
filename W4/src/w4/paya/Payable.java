package w4.paya;
/**********************************************
Workshop # 4
Course: JAC444 - Semester Winter 2023
Last Name: Siu
First Name: Chun Kit Jacky
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-22
**********************************************/
/**
 * 
 * @author Jacky Chun Kit Siu
 * Interface Payable
 */
public interface Payable {
/**
 * It is an abstract method and is a method declaration
 * Calculate the payment amount and return it
 * @return a double  calculated paymentAmount when implemented by the subclass
 */
	public double getPaymentAmount();
/**
 * It is an abstract method and is a method declaration
 * Return a String representation of the object of a subclass
 * @return a String
 */
	public String toString();
}

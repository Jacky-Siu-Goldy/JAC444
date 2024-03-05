package w4.inv;

import w4.paya.Payable;
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
 *	A category of Payable 
 * @author Jacky Chun Kit Siu
 *
 */
public class Invoice implements Payable{
	private double invoiceCost;
	
	/**
	 * Constructor initializes the member variable invoiceCost which is a double
	 * @param invoiceCost which is a double
	 */
	public Invoice(double invoiceCost) {
		super();
		this.setInvoiceCost(invoiceCost);
	}
	
	/**
	 * get the payment amount which is going to be the invoiceCost
	 * @return a double
	 */
	@Override
	public double getPaymentAmount() {
		return getInvoiceCost();
	}
	
	/**
	 * get the invoiceCost
	 * @return a double
	 */
	public double getInvoiceCost() {
		return invoiceCost;
	}
	
	/**
	 * set the member variable invoiceCost
	 * @param invoiceCost -- a double value representing the cost of the invoice
	 */
	public void setInvoiceCost(double invoiceCost) {
		this.invoiceCost = invoiceCost;
	}
	
	/**
	 * an overloaded toString() method. Return a String that 
	 * contain the information on the payment amount
	 * @return a String Stating the payment amount
	 */
	@Override
	public String toString() {
		return "Payment Amount: " + getPaymentAmount();
	}
	
}

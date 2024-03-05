package w4.comemp;

import w4.baseplus.BasePlusCommissionEmployee;

import w4.emp.Employee;
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
 * CommissionEmployee is a category of the Employee.
 * This class extends Employee and implement Payable.
 * The Class contain the member variables grossSale (Total amount in dollars of the employee's sales)
 * and his or her commissionRate
 * @author Jacky Chun Kit Siu
 *
 */
public class CommissionEmployee extends Employee implements Payable {
	private double grossSales;
	private double commissionRate;
	
	/**
	 * Constructor that initialize the attribute grossSales and commissionRate. It uses
	 * the super constructor to pass the parameters firstName, lastName, 
	 * and socialSecurityNumber to the parent's (Employee) constructor, there by 
	 * registering the employee.
	 * This constructor will throw an IllegalArgumentException if (It is not it's child
	 * BasePlusCommissionEmployee instance and ( if grossSales is lesser than 0.0 or if commissionRate is lesser than 0.0
	 * or if commissionRate is greater than 1.0)
	 * @param firstName -- A String representing the first name of the employee
	 * @param lastName -- A String representing the last name of the employee
	 * @param socialSecurityNumber --A String representing the Social Security Number 
	 * of the employee.
	 * @param grossSales -- A double representing (Total amount in dollars of the employee's sales)
	 * @param commissionRate -- representing the rate anywhere from 0 to 1 of commission an employee
	 * is entitle to.
	 */
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
		double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		if (!(this instanceof BasePlusCommissionEmployee) && (grossSales < 0.0 || commissionRate < 0.0 ||
			commissionRate > 1.0)) {
			throw new IllegalArgumentException("grossSales lesser than 0.0 or commissionRate lesser than "
					+ "0.0 or commissionRate greater than 1.0"); 
		}else {
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
		}
	}
	
	/**
	 * Set the member variable grossSale equal the the parameter grossSale
	 * @param grossSales -- a double representing the total amount in dollars of Sales a
	 * a commissioned employee has achieved
	 */
	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}
	
	/**
	 * Return the gross sales of an employee
	 * @return grossSales -- a double representing the total amount in dollars of Sales a
	 * a commissioned employee has achieved
	 */
	public double getGrossSales() {
		return grossSales;
	}
	
	/**
	 * Set the member variable commissionRate equal to the parameter commissionRate
	 * @param commissionRate -- A rate that is use to calculate the percentage of the total
	 * Sales in dollars 
	 */
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	/**
	 * Return the commission rate of a commissioned employee
	 * @return commissionRate -- a double representing the rate at which of the total Sales
	 * a commissioned Employee is entitled to
	 */
	public double getCommissionRate() {
		return commissionRate;
	}
	
	/**
	 * Return the calculated payment amount a commissioned employee is entitled to
	 * @return the payment amount of a commissioned employee which is derived from
	 * the grossSales x commissionRate
	 */
	@Override
	public double getPaymentAmount() {
		return getGrossSales() * getCommissionRate();
	};
	
	/**
	 * Return a String contain the various information of a commissioned Employee
	 * It will not output a payment amount if it is an Instance of it's child
	 * BasePlusCommissionEmployee. This is so that there will not be two payment amount
	 * print in the child's toString() method, one of them being wrong which belong to 
	 * the parent and the other being right which calculated by the overloaded 
	 * getPaymentAmount() method of the BasePlusCommissionEmployee class.
	 * @return a String containing first name, last name, social Security number
	 * grossSale, commission rate and payment amount.
	 * 
	 */
	@Override
	public String toString() {
		String partialStringOfCommissionEmployee = "";
		if (this instanceof BasePlusCommissionEmployee) {
			partialStringOfCommissionEmployee = "";
		}else {
			partialStringOfCommissionEmployee = " Payment Ammount: " + getPaymentAmount()+")";
		}
		return "("+super.toString() 
			+"\n Gross Sale: " + getGrossSales() + " Commission Rate: " + getCommissionRate()
			+ partialStringOfCommissionEmployee;
			
			
	}
	
	
}

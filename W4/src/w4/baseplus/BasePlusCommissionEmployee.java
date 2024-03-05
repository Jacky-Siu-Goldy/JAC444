package w4.baseplus;

import w4.comemp.CommissionEmployee;
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
 * BasePlusComissionEmployee is A category of Employee, and a subclass of 
 * CommissionEmployee which is a subclass of Employee. It has a member
 * variable baseSalary which is a base amount that an employee is paid along 
 * with his or her commission.
 * @author Jacky Chun Kit Siu
 *
 */
public class BasePlusCommissionEmployee extends CommissionEmployee implements Payable{
	private double baseSalary;
	/**
	 * Constructor initializes the member variable baseSalary. It uses the super constructor
	 * to pass the parameters firstName, lastName, socialSecurityNumber, 
	 * grossSales, commissionRate to its parent's constructor as well as its parent's parent's 
	 * constructor.
	 * This Constructor will throw an IllegalArgumentException if grossSales is < 0.0 or
	 * if the commissionRate is < 0.0 or if the commissionRate is > 1.0 or if the baseSalary is <=0.0
	 * @param firstName --A String representing the first name of the base plus commission employee
	 * @param lastName -- A String representing the last name of the base plus commission employee
	 * @param socialSecurityNumber --A String representing the Social Security Number of the base plus commission employee
	 * @param grossSales --A double representing the total amount in dollar of Sales made by the base plus commission employee
	 * @param commissionRate --A double representing the commission rate between 0.0 and 1.0 of a base plus commission  employee
	 * @param baseSalary -- A double represent the base amount that a base plus commission employee should receive
	 */
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
			double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		if(grossSales < 0.0 || commissionRate < 0.0 || commissionRate > 1.0|| baseSalary <= 0.0) {
			throw new IllegalArgumentException("grossSales lesser than 0.0 or commissionRate lesser than 0.0 "
					+ "or commissionRate greater than 1.0 or baseSalary lesser or equal to 0.0");
		}else {
			setBaseSalary(baseSalary);
		}
	}
	
	/**
	 * Set the member variable baseSalary equal to the parameter baseSalary
	 * @param baseSalary --a double representing the base amount a base plus commission employee should receive
	 */
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	/**
	 * Return the BaseSalary of a base plus commission Employee
	 * @return baseSalary --a double
	 */
	public double getBaseSalary() {
		return baseSalary;
	}
	
	/**
	 * Return the Payment amount that a base plus commission employee should be receiving 
	 * @return a double --The calculated payment Amount which grossSale x commissionRate + 
	 * baseSalary x 1.10 
	 */
	@Override
	public double getPaymentAmount() {
		return super.getPaymentAmount() + getBaseSalary()*1.10;
	}
	
	/**
	 * An overloaded toString() method
	 * Return a String containing various information about a base plus commission employee
	 * such as firstName, lastName, socialSecurityNumber, grossSales, commissionRate, baseSalary,
	 * Reward Amount, payment Amount.
	 * @return a String all information about a base plus commission employee
	 */
	@Override
	public String toString() {
		return "("+ super.toString() + "\n Base Salary: "+ String.format("%.2f",getBaseSalary()) 
			+" Reward Amount: " + String.format("%.2f", getBaseSalary()*0.10)+ " Payment Amount: " + String.format("%.2f",getPaymentAmount()) + ")";
	}
}

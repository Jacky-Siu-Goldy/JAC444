package w4.salariedemp;

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
 * A category of employee hence it inherit from employee and also implement Payable.
 * Contain a member variable weeklySalary which is a double
 * @author Jacky Chun Kit Siu
 *
 */
public class SalariedEmployee extends Employee implements Payable{
	private double weeklySalary;
	/**
	 * Constructor initialize the member variable weeklySalary. It uses
	 * the super constructor to pass the parameter firstName, lastName, socialSecurityNumber
	 * to the parent constructor there by initializing an employee for itself.
	 * It will throw an IllegalArgumentException if the parameter weeklySalary is lesser or equal to 0.0.
	 * Otherwise it will initialize weeklySalary.
	 * @param firstName --A String representing the first name of the employee.
	 * @param lastName --A String representing the last name of the employee.
	 * @param socialSecurityNumber --A String representing the Social Security Number of the employee.
	 * @param weeklySalary -- A double representing the weekly Salary of the employee.
	 */
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber,
				double weeklySalary) {
			super(firstName, lastName, socialSecurityNumber);
			if (weeklySalary <= 0.0) {
				throw new IllegalArgumentException("weeklySalary lesser or equal 0.0");
			}else {
				setWeeklySalary(weeklySalary);
			}
	}

	/**
	 * Set the member variable weeklySalary to equal the String parameter weeklySalary
	 * @param weeklySalary -- A double representing the weekly Salary of a Salaried employee
	 */
	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	
	/**
	 * Return the weekly Salary of the Salaried Employee
	 * @return a double from the member variable weeklySalary
	 */
	public double getWeeklySalary() {
		return weeklySalary;
	}
	
	/**
	 * Return the weeklySalary which is going to be the payment amount for the employee 
	 * @return a double which going to be the weekly salary amount
	 */
	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
	
	/**
	 * return a String containing the detail of a salaried employee
	 * @return a String about the employee's information his or her 
	 * weekly salary and the payment amount
	 */
	@Override
	public String toString() {
		return "(" + super.toString() + "\n Weekly Salary: " + getWeeklySalary() +
				" Payment Amount: " + getPaymentAmount()+")";
	}
}

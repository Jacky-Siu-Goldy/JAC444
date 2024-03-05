package w4.hourlyemp;

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
 * This class represent a category of Employee. The class
 * HourlyEmployee extends Employee and implement Payable.
 * A Hourly employee get wages and is pay by the hour.
 * The payment amount is hours * wage.
 * @author Jacky Chun Kit Siu
 *
 */
public class HourlyEmployee extends Employee implements Payable{
	private double wage;
	private double hours;
	/**
	 * Constructor initialize the member variables wage and hours. It
	 * uses the super constructor to pass the parameter firstName, lastName,
	 * socialSecurityNumber to the parameter thereby registering the employee
	 * and associating that employee with his or her wage and hours information
	 * Constructor will throw an IllegalArgumentException if the parameter wage is <= 0.0
	 * or if the hours is <0.0 or if the hour is >168.0
	 * @param firstName -- a String representing the first name of the employee
	 * @param lastName --a String representing the last name of the employee
	 * @param socialSecurityNumber --a String representing the Social Security Number 
	 * of the employee.
	 * @param wage -- a double representing the wage (dollars per hour) of the employee
	 * @param hours -- a double representing the hours the employee worked in a week
	 */
	public HourlyEmployee(String firstName, String lastName,
				String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		if(wage <=0.0 || hours< 0.0 || hours > 168.0) {
			throw new  IllegalArgumentException("wage lesser than or Equal to 0.0 or hours lesser than 0.0 or hours greater than 168.0");
		}else {
			setWage(wage);
			setHours(hours);
		}
	}
	
	/**
	 * Set the member variable wage to equal to the parameter wage
	 * @param wage -- representing the wage (dollars per hour) of the employee
	 */
	public void setWage(double wage) {
		this.wage = wage;
	}
	
	/**
	 * Returns the wage of the employee
	 * @return wage --a double representing the wage of the employee
	 */
	public double getWage() {
		return wage;
	}

	/**
	 * Returns the hours worked by the employee in a week
	 * @return hours --a double representing hours worked by the employee in a week
	 */
	public double getHours() {
		return hours;
	}

	/**
	 * Set the member variable hours equal the parameter hours
	 * @param hours --a double representing the hours worked by the employee in a week 
	 */
	public void setHours(double hours) {
		this.hours = hours;
	}

	/**
	 * Return the calculated payment amount
	 *@return the paymentAmount which is wage x hours
	 */
	@Override
	public double getPaymentAmount() {
		return getWage() * getHours();
	}
	
	/**
	 * Returns a String containing the employee's information such as first name, last name,
	 * Social Security Number, wage, hours and payment amount.
	 * @return a String with all the information of an HourlyEmployee
	 */
	@Override
	public String toString() {
		return "(" + super.toString() + "\n Wage: " + getWage() + " Hours: " + getHours()
			+ " Payment Amount: "+ getPaymentAmount()+")";
	}
	
}

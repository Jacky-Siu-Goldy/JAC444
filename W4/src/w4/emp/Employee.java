package w4.emp;

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
 * Abstract class Employee implements Payable
 * Attribute include firstName, lastName, socialSecurityNumber
 * @author Jacky Chun Kit Siu
 *
 */
public abstract class Employee implements Payable{
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	/**
	 * Constructor initializes member variables such as firstName, lastName and socialSecurityNumber
	 * @param firstName -- A String representing the first name of the employee
	 * @param lastName -- A String representing the last name of the employee
	 * @param socialSecurityNumber -- A String representing the social security number of the employee
	 */
	protected Employee(String firstName, String lastName, String socialSecurityNumber) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setSocialSecurityNumber(socialSecurityNumber);
	}

	/**
	 * Return the member variable firstName
	 * @return firstName -- A member variable which is a String representing the first name of the employee
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the member variable firstName to equal the String parameter firstName
	 * @param firstName -- A String representing the first name of the employee
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Return the member variable lastName
	 * @return lastName -- A member variable which is a String representing the last name of the employee
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the member variable firstName to equal the String parameter firstName
	 * @param firstName -- A String representing the first name of the employee
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return the member variable socialSecurityNumber
	 * @return socialSecurityNumber -- A member variable which is a String representing the Social Security Number of the employee
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * Set the member variable socialSecurityNumber to equal the String parameter socialSecurityNumber
	 * @param socialSecurityNumber -- A String representing the Social Security Number of the employee
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	/**
	 * Return a String stating the FirstName, LastName, Social Security Number
	 * @return a String
	 */
	@Override
	public String toString() {
		return "FirstName: " + getFirstName() + " LastName: " + getLastName() 
			+ " Social Security Number: " + getSocialSecurityNumber();
	};

}

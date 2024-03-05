package w7.model;
/**********************************************
Workshop # 7
Course: JAC444 - Winter 2023
Last Name: Siu
First Name: Jacky Chun Kit 
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-24
**********************************************/

/**
 * 
 * class for the Address model
 *
 */
public class Address {
	private String kindOfAddr;
	private String name;
	private String street;
	private String city;
	private String province;
	private String postalCode;
	
	
    /**
     * getter for the kind of Address
     * @return kindOfAddr - a String
     */
	public String getKindOfAddr() {
		return kindOfAddr;
	}
	
	/**
	 * getter for the Name
	 * @return name - a String
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * getter for the Street
	 * @return street - a String
	 */
	public String getStreet() {
		return street;
	}

	
	/**
	 * getter for the City
	 * @return city - a String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * getter for the Province
	 * @return province - a String
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * getter for the Postal Code
	 * @return postalCode - a String
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Default constructor for Address
	 */
	public Address() {
		this.kindOfAddr = "";
		this.name = "";
		this.street = "";
		this.province = "";
		this.postalCode = "";
	}

	/**
	 * Contructor for Address using Fields
	 * @param kindOfAddr - a String 
	 * @param name - a String
	 * @param street - a String
	 * @param city - a String
	 * @param province - a String
	 * @param postalCode -a String
	 */
	public Address(String kindOfAddr, String name, String street, String city, String province, String postalCode) {
		
		this.kindOfAddr = kindOfAddr;
		this.name = name;
		this.street = street;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	
	
	
}

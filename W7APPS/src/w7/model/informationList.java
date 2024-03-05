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
 * Class for managing an array of Address
 *
 */
public class InformationList {
	
	public final int MAX_SIZE = 100;
	private Address[] addresses;
	private int size;
	/**
	 * Default constructor for class information list
	 */
	public InformationList(){
		addresses = new Address[MAX_SIZE];
		size = 0;
	}
	
	/**
	 * get the Field array of addresses
	 * @return addresses - an array of address of type Address[]
	 */
	public Address[] getAddresses() {
		return addresses;
	}
	
	/**
	 * get the size of the array of Address
	 * @return size - an integer
	 */
	public int getSize() {
		return size;
	}
    
	/**
	 * add to the array of Address if size is less than max size
	 * @param address - an object of Address
	 */
	public void add(Address addr) {
		if (size < MAX_SIZE) {
			addresses[size] = addr;
		    size++;
		}
		
	}
	
	/**
	 * remove an element with index provided if the index is >=0 or < MAX_SIZE
	 * @param index - an integer
	 */
	public void remove(int index) {
		if(index >=0 && index < MAX_SIZE) {
			for (int i = index; i < size; i++) {
				addresses[i] = addresses[i + 1];
			}
			size--;
		}
	}
	
	
}

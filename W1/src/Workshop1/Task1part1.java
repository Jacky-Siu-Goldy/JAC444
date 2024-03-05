/**********************************************
Workshop #
Course:JAC444 - winter 2023
Last Name:Siu
First Name:Jacky Chun Kit
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-01
**********************************************/
package Workshop1;

import java.util.Scanner;



public class Task1part1 {
	private int[] dataToBeEncrypted = new int [4];
	/**
	 * This program receives an input of string of 4 digits and encrypts it.
     * after encrypting the 4 digit the program print out the encrypted
     * code as a string.
	 * @param args --not used
	 */
	public static void main(String[] args) {
		Task1part1 t1p1 = new Task1part1();
		t1p1.unencrypted4DigitsStringToEncryptedString();
	}
	
	/** 
	 * This method output the encrypted 4 digits String
	 */
	public void unencrypted4DigitsStringToEncryptedString() {
		String encryptedData = "";
		this.setDataToBeEncrypted();
		encryptedData = this.encryptedData(this.getDataToBeEncrypted());
		System.out.println(encryptedData);
	}
	
	/**
	 * method takes a 4 digits string and store the digits in an array of integers (dataToBeEncrypted)
	 * by converting them to digits
	 * 
	 */
	public void setDataToBeEncrypted() {
		Scanner scan = new Scanner(System.in);
		String regex = "^\\d+";
		
		String fourDigitsString = "";
		boolean inputStringIsCorrect = false;
		do {
			
			if(fourDigitsString.length() != 4  || !inputStringIsCorrect) {
				System.out.println("Please Enter a Four Digit String.");
				fourDigitsString = scan.nextLine(); 
				inputStringIsCorrect= fourDigitsString.matches(regex);		 
			
			}else {
				System.out.println("Input is not a 4 digits String. ");
			}
					 
		}while((fourDigitsString.length() != 4 || !inputStringIsCorrect));
		
		for (int i = 0; i < 4; i++) {
			dataToBeEncrypted[i] = Character.digit(fourDigitsString.charAt(i), 10);
		}
		
		scan.close();
	}
	/**
	 * This method return an integer array
	 * @return int[] --member variable integer array(dataToBeEncrypted)
	 */
	public int[] getDataToBeEncrypted() {
		return dataToBeEncrypted;
	}
	
	/**
	 * This method takes an integer array and encrypts it and return a string
	 * @param unencryptedData --method suppose to received the member integer array 
	 *                        --dataToBeEncrypted
	 * @return an encrypted 4 digits string
	 */
	public String encryptedData(int[] unencryptedData) {
		for(int i = 0; i < 4; i++) {
			unencryptedData[i] = (unencryptedData[i] + 7) % 10;
		}
		this.swapValue(unencryptedData);
		
		String encryptedData = "";
		
		for(int j = 0; j <= 3; j++) {
	        encryptedData = encryptedData + unencryptedData[j];
		}	
		return encryptedData;
	}
	
	/**
	 * This is a method a that swaps the value of the element at index 0 with value of the element at index 2
	 * and swap the value of the element at index 1 with the value of the element at index 3 
	 * This method is called in the encryptedData() method
	 * @param unencryptedData -- it is an integer array of 4 digits in the process of being encrypted
	 */
	public void swapValue (int[] unencryptedData) {
		int temp = unencryptedData[0];
		unencryptedData[0] = unencryptedData[2];
		unencryptedData[2] = temp;
		temp = unencryptedData[1];
		unencryptedData[1] = unencryptedData[3];
		unencryptedData[3] = temp;	
	}
}

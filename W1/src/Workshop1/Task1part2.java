
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



public class Task1part2 {
private int[] dataToBeDecrypted = new int[4];
	
	/**
	 * This program receive an input of a 4 digits string and decrypts it
     * and then prints out the decrypted digits as a string
	 * @param args -- not used
	 */
	public static void main(String[] args) {
		Task1part2 t1p2 = new Task1part2();
		t1p2.encrypted4DigitsStringToDecryptedString();
	}
	
	/**
	 * This method receives and encrypted 4 digits String and Output a Decrypted 4 digits String
	 */
	public void encrypted4DigitsStringToDecryptedString() {
		this.setDataToBeDecrypted();
		String decryptedData = this.decryptedData(this.getDataToBeDecrypted());
		System.out.println(decryptedData);
	}
	/**
	 * This method receive an input of a 4 digits string and convert it into digits and store
	 * the digits in an integer array (dataToBeDecrypted)
	 */
	public void setDataToBeDecrypted() {
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
			dataToBeDecrypted[i] = Character.digit(fourDigitsString.charAt(i), 10);
		}
		scan.close();
	}
	/**
	 * The method getDataToBeDecrypted returns the member variable integer array
	 * dataToBeDecrypted
	 * @return int[] dataToBeDecrypted
	 */
	public int[] getDataToBeDecrypted() {
		return dataToBeDecrypted;
	}
	/**
	 * This method decrypt the integer array that it receives.
	 * This method is suppose to receive the member variable integer array dataToBeDecrypted
	 * @param encryptedData
	 * @return a  decrypted string of 4 digits
	 */
	public String decryptedData(int[] encryptedData) {
		for (int i = 0; i < 4; i++) {
			
		    encryptedData[i] = (encryptedData[i] + 3)%10;
				
		}	
		
		this.swapValue(encryptedData);
		String decryptedData = "";
		
		for(int j = 0; j <= 3; j++) {
	        decryptedData = decryptedData + encryptedData[j];
		}	
		return decryptedData;
	}
	
	/**
	 * 
	 * This is a method a that swaps the value of the element at index 0 with value of the element at index 2
	 * and swap the value of the element at index 1 with the value of the element at index 3 
	 * This method is called in the dencryptedData() method
	 *  
	 *
	 * @param encryptedData-- it is an integer array of 4 digits in the process of being dencrypted
	 */
	public void swapValue (int[] encryptedData) {
		int temp = encryptedData[0];
		encryptedData[0] = encryptedData[2];
		encryptedData[2] = temp;
		temp = encryptedData[1];
		encryptedData[1] = encryptedData[3];
		encryptedData[3] = temp;	
	}
}

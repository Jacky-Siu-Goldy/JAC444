package w8.model;
/**********************************************
Workshop # 8
Course: JAC444 - Winter 2023
Last Name: Siu
First Name: Jacky Chun Kit 
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-29
**********************************************/
import java.util.ArrayList;
/**
 * Model for an Array of double
 * Contain a static ArrayList of the Type Double
 * and a static int size
 */
public class DoubleModel {
	private static ArrayList<Double> doubleArray;
	private static int size;
	
	/**
	 * default constructor
	 * initialize doubleArray to new ArrayList<>()
	 * size to 0
	 */
	public DoubleModel() {
		doubleArray = new ArrayList<>();
		size = 0;
	}
	
	/**
	 * Add the argument dbElement to the ArrayList doubleArray
	 * @param dbElement - a double
	 */
	public static void add(double dbElement) {
		
		doubleArray.add(dbElement);
		size++;
	}
	
	/**
	 * Convert doubleArray (ArrayList) to a primitive array of double
	 * @return array - primitive array of double
	 */
	public static double[] getDoubleArrayListtoPrimitiveArray() {
		final double[] array = new double[doubleArray.size()];
		 for (int i = 0; i < array.length; i++) {
			 array[i] = doubleArray.get(i);
		 }
		 return array;
	}

    /**
     * get the size of the ArrayList doubleArray
     * @return size - the size of doubleArray (ArrayList)
     */
	public int getSize() {
		return size;
	}

	
	/**
	 * clear the doubleArray of its elements
	 * and set size equal to 0
	 */
	public static void clear() {
		
		doubleArray = new ArrayList<>();
		size = 0;
	}

}

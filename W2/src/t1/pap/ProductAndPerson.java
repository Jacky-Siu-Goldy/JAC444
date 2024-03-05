/**********************************************
Workshop # 2
Course: JAC444 - Winter 2023
Last Name: Siu
First Name: Jacky Chun Kit 
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-08
**********************************************/
package t1.pap;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import t1.gio.SaleSlip;

public class ProductAndPerson {
	private SaleSlip[] saleRecord = new SaleSlip[100];
	private int[][] saleSlipsPerPersonPerMonth = new int[4][5];
	private double[][] saleRecordTable = new double [4][5];
	
	/**
	 * This method create a saleRecord array (an array of 100 SaleSlip Object)
	 * First it uses the class Calendar to determine the current Month and current Year
	 * Then it uses If and else statements to determine what the Month of last Month was
	 * and what the Year of last Month was. With that it is able to determine the 
	 * number of days last Month has.
	 * Then It initialize all the elements of saleSlipsPerPersonPerMonth[][] a two dimensional 
	 * int array that keep track of how many SaleSlip per product a person generate each month
	 * Each person can generate a maximum of 28 to 31 saleslips per product per month. So all 
	 * The products a person can sell combined, a person can technically generate a maximum of 28x5 
	 * to 31x5 saleslips per month. But this function generate a 100 saleslips with randomized product
	 * among 5 product and value ($0 to 150)per saleSlip for each product and distributed them among 4 
	 * sales person randomized. This function make sure a person does not over produce saleslips 
	 * for a product and that a 100 SaleSlip is distributed randomly according to the rules to 4 Sales 
	 * person.
	 */
	public void createSaleRecord() {
		
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH)+1;
		int yearOfLastMonth;
		int lastMonth;
		int daysInMonth;
		if(currentMonth == 1) {
			yearOfLastMonth = currentYear - 1;
			lastMonth = 12;
		}else {
			yearOfLastMonth = currentYear;
			lastMonth = currentMonth - 1;
		}
		
		if(lastMonth == 1 || lastMonth == 3 || lastMonth == 5 ||lastMonth == 7 ||
				lastMonth == 8 || lastMonth == 10 ||lastMonth == 12 ) {
			daysInMonth = 31;
		}else if(lastMonth == 4 ||lastMonth == 6 || lastMonth == 9 ||lastMonth == 11) {
			daysInMonth = 30;
		}else if((lastMonth == 2 && yearOfLastMonth%400 == 0 && yearOfLastMonth%100 == 0)
				|| (lastMonth == 2 && yearOfLastMonth%4 == 0 && yearOfLastMonth%100 == 0)) {
			daysInMonth = 29;
		}else {
			daysInMonth = 28;
		}
		int count = 0;
		for(int i = 0; i < 4; i++) {
			for(int u = 0; u < 5; u++) {
				saleSlipsPerPersonPerMonth[i][u] = 0;
			}
		}
		while (count < 100) {
			int personNum = (int)(Math.random()* 4 );
			int productNum = (int)(Math.random()* 5 );
			double valueNum = Math.random() * 150;
			BigDecimal bdUp = new BigDecimal(valueNum).setScale(2, RoundingMode.UP);
			if (saleSlipsPerPersonPerMonth[personNum][productNum] < (daysInMonth + 1)) {
				saleRecord[count] = new SaleSlip(personNum, productNum,bdUp.doubleValue());
				saleSlipsPerPersonPerMonth[personNum][productNum]++;
				count++;
			}
			
		}
		
	}
	
	/**
	 * </p>
	 * This method first initialize each element of the saleRecordTable
	 * The saleRecordTable is 4X5 2D array of type double
	 * Each Element store the total dollar value of the sale 
	 * of that product by a person last month.
	 * </p>
	 * </p>
	 * It then uses the value of the properties of each element of the 
	 * saleRecord array to populate the saleRecordTable array
	 * </p>
	 * @param saleRecord --an array of the object SaleSlip
	 */
	public void loadSaleRecordIntoTable(SaleSlip[] saleRecord) {
		for(int i = 0; i < 4 ; i++) {
			for (int a = 0; a < 5; a++) {
				saleRecordTable[i][a] = 0.00;
			}
		}
		for(SaleSlip a : saleRecord) {
			saleRecordTable[a.getPerson()][a.getProduct()] += a.getValue();
		}
	}

	/**
	 * This method left pad the inputed string
	 * @param input -- a string to be left padded
	 * @param ch --character to fill up the space padding
	 * @param L -- an Integer used in this method to determine the length
	 *             of spaces to left pad the (input) String
	 * @return result --the Resultant String
	 */
	public static String leftPadding(String input, char ch, int L)
	    {
		// First left pad the string
        // with space up to length L
		// Then replace all the spaces
        // with the given character ch
	        String result = String.format("%" + L + "s", input).replace(' ', ch);
	    // Return the resultant string
	        return result;
	    }
	
	
	/**
	 * This method right pad the inputed string
	 * @param input -- a string to be right padded
	 * @param ch --character to fill up the space padding
	 * @param L -- an Integer used in this method to determine the length
	 *             of spaces to right pad the (input) String
	 * @return result --the Resultant String
	 */
	public static String rightPadding(String input, char ch, int L)
    {
    	 // First right pad the string
        // with space up to length L
    	// Then replace all the spaces
        // with the given character ch
    	
    	String result = String.format("%" + (-L) + "s", input).replace(' ', ch);
    	
        // Return the resultant string
        return result;
    }
	/**
	 * This method right pad the inputed double by formating it into a string
	 * and then right padding it
	 * 
	 * @param input -- a double to be right padded
	 * @param ch --character to fill up the space padding
	 * @param L -- an Integer used in this method to determine the length
	 *             of spaces to right pad the (input) double
	 * @return result --the Resultant String
	 */
	public static String rightPadding(double input, char ch, int L)
    {
    	 // First right pad the string
        // with space up to length L
    	// Then replace all the spaces
        // with the given character ch
    		
    		
    		String processStr = String.format("%.2f",input);
    		String result = String.format("%" + (-L) + "s", processStr).replace(' ', ch);
        // Return the resultant string
        return result;
    }
	
    /**
     * This method create the visualization of the PersonProductTable and display
     * it
     * It added a row of the total sale of each person for each column
     * It also added a column displaying the total sales of each product for 
     * each row.
     */
    public void displayPersonProductTable() {
		createSaleRecord();
		loadSaleRecordIntoTable(saleRecord);
		char ch = ' ';
		StringBuilder personProductTitle = new StringBuilder();
		personProductTitle.append(rightPadding("Prod/Person",ch,16));
		for(int h = 1; h< 5; h++) {
			personProductTitle.append(rightPadding("" + h,ch,8));
		}
		personProductTitle.append("Total");
		
		System.out.println(personProductTitle);
		
		
		StringBuilder[] personProductRow = new StringBuilder[5];
		for(int i = 0; i < 5 ; i++) {
			double totalSaleOfEachProduct = 0.00;
			personProductRow[i] = new StringBuilder();
			personProductRow[i].append(leftPadding("" + (i+1), ch, 9));
			personProductRow[i].append(rightPadding("", ch, 7));
				for (int a = 0; a < 4; a++) {
					personProductRow[i].append(rightPadding(saleRecordTable[a][i], ch, 8));
					totalSaleOfEachProduct += saleRecordTable[a][i];
				}
			personProductRow[i].append(String.format("%.2f",totalSaleOfEachProduct));
			System.out.println(personProductRow[i]);
			
		}
		
		StringBuilder totalSaleOfEachPersonRow = new StringBuilder();
		totalSaleOfEachPersonRow.append(leftPadding("Total",ch, 13));
		totalSaleOfEachPersonRow.append(rightPadding("",ch,3));
		
		for(int a = 0; a < 4; a++) {
			double totalSaleOfEachPerson = 0.00;
			for(int i = 0; i < 5; i++) {
				
				totalSaleOfEachPerson += saleRecordTable[a][i];
			}
			totalSaleOfEachPersonRow.append(rightPadding(totalSaleOfEachPerson, ch, 8));
		}
		System.out.println(totalSaleOfEachPersonRow);
	}
}

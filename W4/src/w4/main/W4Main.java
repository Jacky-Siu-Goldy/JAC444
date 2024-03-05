package w4.main;

import w4.baseplus.BasePlusCommissionEmployee;
import w4.comemp.CommissionEmployee;
import w4.hourlyemp.HourlyEmployee;
import w4.inv.Invoice;
import w4.paya.Payable;
import w4.salariedemp.SalariedEmployee;
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
 * Tests the constructor of Invoice, HourlyEmployee, CommissionEmployee, SalariedEmployee,
 * BasePlusCommissionEmployee and the toString() method of each of these subclass
 * @author Jacky Chun Kit Siu
 *
 */
public class W4Main {
	public static void main(String[] args) {
		
		
		Payable[] payable = new Payable[6];
					
		try {
			payable[2] = new SalariedEmployee("Adam", "Stuart", "12345", -1.0);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		payable[1] = new Invoice(250.95);
		
		try {
			payable[3] = new HourlyEmployee("Stephen", "Jay", "34567", -1.0, 169.50);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		payable[0] = new Invoice(12.45);
		
		try {
			payable[4] = new CommissionEmployee("Carl", "Eben", "67543", 3892.00, 1.45);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	
		try {
			payable[5] = new BasePlusCommissionEmployee("Robert", "Tomson", "89765", 4285.60, 1.45, 0.0);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	
		
		Payable[] payable2 = new Payable[6];
		
		payable2[0] = new Invoice(12.45);
		payable2[1] = new Invoice(250.95);
		payable2[2] = new SalariedEmployee("Adam", "Stuart", "12345", 720.50);
		payable2[3] = new HourlyEmployee("Stephen", "Jay", "34567", 20.50, 100.0);
		payable2[4] = new CommissionEmployee("Carl", "Eben", "67543", 5000.00, 0.50);
		payable2[5] = new BasePlusCommissionEmployee("Robert", "Tomson", "89765", 4000.0, 0.50, 3000.00);
		
		for(int i = 0; i < 6; i++) {
			System.out.println(payable2[i].toString());
		}
		
		
		
	}
}

/**********************************************
Workshop # 3
Course: JAC444 - Semester
Last Name: Siu
First Name: Chun Kit Jacky
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-02-15
**********************************************/
package w3.tmain;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import w3.abstr.Ticket;
import w3.adv.AdvanceTicket;
import w3.student.StudentAdvance;
import w3.walkup.WalkUpTicket;
/**
 * A tester Class that tests the functionality  of the methods and Constructors
 * of classes such as Ticket, AdvanceTicket,StudentAdvance and WalkUpTicket by 
 * allowing user input.
 * TicketMain contains some member variable such as count an integer variable
 * to keep track of the number Ticket array's elements being initialized 
 * and the member variable numOfDaysLeft to keep track of the number
 * of Days left before the Event and A method to set the number of Days left.
 * 
 * @author Jacky Chun Kit Siu
 *
 */
public class TicketMain {
	/**
	 * An integer member variable of TicketMain. It is use to keep track
	 * of the number of Ticket array's elements that has been initialized.
	 */
	public int count = 0;
	/**
	 * An integer member variable of TicketMain. It is use to keep track
	 * of the number of Days left before the Event.
	 */
	public int numOfDaysLeft = 20;
	Ticket[] ticket = new Ticket[15];
	public static void main(String[] args) {
	    
	    TicketMain tM = new TicketMain();
	    String ticketChoice = "";
	    Scanner scan = new Scanner(System.in);
		while(tM.count < 15){
			tM.setNumOfDaysLeft();
			
			System.out.println("\n\nDays before Event: " + tM.numOfDaysLeft);
			Pattern regex1 = Pattern.compile("[asq]");
			Pattern regex2 = Pattern.compile("[wq]");
			Pattern regex3 = Pattern.compile("^\\d+");
			String studentNumber = "";
			boolean isChoiceCorrect = false;
			boolean isStudentIDCorrect = false;
			do {
				
				if( tM.numOfDaysLeft >= 10) {
					System.out.println("Advance_Ticket(available)---$30.00");
					System.out.println("Student_Ticket(available)---$15.00");
					System.out.println("Enter 'a' for Advance_Ticket.");
					System.out.println("Enter 's' for Student_Ticket.");
					System.out.println("Enter 'q' to quit.");
					ticketChoice = scan.nextLine();
					if (ticketChoice.matches("s")) {
						do {
							System.out.print("ID required: ");
							studentNumber = scan.nextLine();
							Matcher m3 = regex3.matcher(studentNumber);
							isStudentIDCorrect = m3.find();
						}while(!isStudentIDCorrect);
						
					}
					Matcher m1 = regex1.matcher(ticketChoice);
					isChoiceCorrect = m1.find();
				}else if( tM.numOfDaysLeft >= 1 && tM.numOfDaysLeft < 10) {
					System.out.println("Advance_Ticket(available)---$40.00");
					System.out.println("Student_Ticket(available)---$20.00");
					System.out.println("Enter 'a' for Advance_Ticket.");
					System.out.println("Enter 's' for Student_Ticket.");
					System.out.println("Enter 'q' to quit.");
					ticketChoice = scan.nextLine();
					if (ticketChoice.matches("s")) {
						do {
							System.out.print("ID required: ");
							studentNumber = scan.nextLine();
							Matcher m3 = regex3.matcher(studentNumber);
							isStudentIDCorrect = m3.find();
						}while(!isStudentIDCorrect);
						
					}
					Matcher m1 = regex1.matcher(ticketChoice);
					isChoiceCorrect = m1.find();
				}else if(tM.numOfDaysLeft == 0) {
					System.out.println("Walk-Up_Ticket (available)---$50.00");
					System.out.println("Enter 'w' for Walk-Up_Ticket.");
					System.out.println("Enter 'q' to quit.");
					ticketChoice = scan.nextLine();
					Matcher m2 = regex2.matcher(ticketChoice);
					isChoiceCorrect = m2.find();
				}
				
			}while(ticketChoice.length() != 1 || !isChoiceCorrect);
			
			
			if(ticketChoice.matches("a")) {
			    tM.ticket[tM.count] = new AdvanceTicket(tM.count, tM.numOfDaysLeft);
	            System.out.println(tM.ticket[tM.count].toString());
	            tM.count++;
			}else if(ticketChoice.matches("s")){
				tM.ticket[tM.count] = new StudentAdvance(tM.count, tM.numOfDaysLeft, studentNumber);
	            System.out.println(tM.ticket[tM.count].toString());
	            tM.count++;
			}else if(ticketChoice.matches("w")) {
				tM.ticket[tM.count] = new WalkUpTicket(tM.count, tM.numOfDaysLeft);
		        System.out.println(tM.ticket[tM.count].toString());
		        tM.count++;
			}else if(ticketChoice.matches("q")) {
			    break;
			}
		}
		
		scan.close();
		
		System.out.println("\n\nTickets Sold:");
		for(int i = 0; i < tM.count; i++) {
			System.out.println(tM.ticket[i].toString());
		}
		
	}
	/**
	 * A method that changes the number of Days left before the Event
	 * by a decrement of 3 every time this method is called all
	 * the way to zero.
	 */
	public void setNumOfDaysLeft() {
		numOfDaysLeft -=3;
		if (numOfDaysLeft < 0) {
			numOfDaysLeft = 0;
		}
	}
}

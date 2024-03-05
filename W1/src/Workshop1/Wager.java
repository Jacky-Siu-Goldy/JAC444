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



public class Wager {
	static boolean play = true;
	static boolean pointEstablished = false;
	static int point = 0;
	static int bankBalance = 1000;
	static int wager = 0;
	private int dice1 = 7;
	private int dice2 = 7;
	
	/**
	 * This program allows the user to place wager on a game of craps
	 * The user starts with a bank balance of a 1000 dollar
	 * the game is played repeatedly and each time a wager greater than zero and lesser or
	 * equal to the bank balance the user have is placed
	 * each time a player wins or loses their new bank balance is displayed
	 * the game ends when the user's bank balance reaches zero
	 *
	 * @param args --not used
	 */
	public static void main(String[] args) {
		
		Wager w = new Wager();
		w.crapsGameWithWager();
	}
	/**
	 * let the User play crapsgames with wager with the bank balance starting at a $1000
	 */
	public void crapsGameWithWager() {
		Scanner scan = new Scanner(System.in);
		CrapsGame cg = new CrapsGame();
		while (bankBalance > 0) {
			
			wager = 0;
			do {
				System.out.println("Enter a wager > $0 and <= $" + bankBalance);
				wager = scan.nextInt();
			}while(wager <= 0 || wager >bankBalance);
			
			this.chatter();
			play = true;
			point = 0;
			pointEstablished = false;
			while(play) {
				cg.rollDice1();
				cg.rollDice2();
				
				int rolledSum = cg.dice1Rolled() + cg.dice2Rolled();
				switch(rolledSum) {
				case 2:
					cg.responseFor2_3_or_12();
					bankBalance -= wager;
					System.out.println("BankBalance: $" + bankBalance);
					play = false;
					break;
				case 3:
					cg.responseFor2_3_or_12();
					bankBalance -= wager;
					System.out.println("BankBalance: $" + bankBalance);
					play = false;
					break;
				case 4:
					responseFor4_5_6_8_9_or_10(4, cg.dice1Rolled(),cg.dice2Rolled());
					break;
				case 5: 
					responseFor4_5_6_8_9_or_10(5, cg.dice1Rolled(),cg.dice2Rolled());
					break;
				case 6:
					responseFor4_5_6_8_9_or_10(6, cg.dice1Rolled(),cg.dice2Rolled());
					break;
				case 7:
					responseFor7_or_11(7, cg.dice1Rolled(), cg.dice2Rolled());
					break;
				case 8:
					responseFor4_5_6_8_9_or_10(8, cg.dice1Rolled(), cg.dice2Rolled());
					break;
				case 9:
					responseFor4_5_6_8_9_or_10(9, cg.dice1Rolled(), cg.dice2Rolled());
					break;
				case 10:
					responseFor4_5_6_8_9_or_10(10, cg.dice1Rolled(), cg.dice2Rolled());
					break;
				case 11:
					responseFor7_or_11(11, cg.dice1Rolled(), cg.dice2Rolled());
					break;
				case 12:
					cg.responseFor2_3_or_12();
					bankBalance -= wager;
					System.out.println("BankBalance: $" + bankBalance);
					play = false;
					break;
				}
			}
			if(bankBalance == 0) {
				System.out.println("Sorry, You Busted!");
			}
			
		}
		scan.close();
	}
	/** 
	 * this method print different chatter at random at the beginning of a game
	 */
	public void chatter() {
		int rand = (int)(Math.random() * 3)+ 1;
		switch (rand) {
		case 1:
			System.out.println("Oh, you're going for broke, huh?");
			break;
		case 2:
			System.out.println("Aw c'mon, take a chance!");
			break;
		case 3:
			System.out.println("You're up big. Now's the time to cash in your chips!");
			break;
		}
	}
	
	/**
	 * This method set the number rolled for dice 1 randomly from 1 to 6
	 */
	public void rollDice1() {
		dice1 = (int)(Math.random() * 6) + 1;
	}
	
	/**
	 * This method set the number rolled for dice 2 randomly from 1 to 6
	 */
	public void rollDice2() {
		dice2 = (int)(Math.random() * 6) + 1;
	}
	
	/**
	 * This method the returns the number rolled for dice 1
	 * @return member variable dice1
	 */
	public int dice1Rolled() {
		return dice1;
	}
	
	/**
	 * This method returns the number rolled for dice 2
	 * @return member variable dice2
	 */
	public int dice2Rolled() {
		return dice2;
	}
	
	/**
	 * This method print out the response if you rolled a sum of 2, 3, or 12 of the two dices
	 */
	public void responseFor2_3_or_12() {
		System.out.println("You rolled " + this.dice1Rolled() + " + " + this.dice2Rolled());
		System.out.println("Craps, Better Luck Next Time, You Lose");
		
	}
	
	/**
	 * This method print out the response if you rolled 4, 5, 6, 8, 9, or 10
	 * The static variable point is set to the sum of the two dices if a sum of 4,5,6,8,9, or 10 is rolled
	 * in a game for the first time and once the point is set it does not change through the entirety of 
	 * of a game
	 * if you are able to roll a sum of the two dice same as the number set for point a second time you win
	 * the 
	 * each time you win your bank balance is increased by the same amount you placed
	 * as a wager
	 * @param caseNum --sum of two dice rolled
	 * @param dice1Rolled --number dice1 rolled
	 * @param dice2Rolled --number dice2 rolled
	 */
	static void responseFor4_5_6_8_9_or_10(int caseNum, int dice1Rolled, int dice2Rolled) {
		System.out.println("You rolled " + dice1Rolled + " + " + dice2Rolled);
		if (point == caseNum) {
			System.out.println("Congratulations, You win");
			bankBalance += wager;
			System.out.println("BankBalance: $" + bankBalance);
			play = false;
		}
		if (!pointEstablished) {
			point = dice1Rolled + dice2Rolled;
			System.out.println("Point is (established) set to " + caseNum);
			pointEstablished = true;
		}
	}
	
	/**
	 * This method prints the response for the sum of 7 or 11 of the two dice rolled
	 * if a sum of 7 or 11 is rolled for the first time in the game before the point 
	 * is set you win 
	 * each time you win your bank balance is increased by the same amount you placed
	 * as a wager
	 * if the point is set and you roll a sum of 7 you lose  
	 * each time you loses your bank balance is decrease by the same amount you placed
	 * as a wager
	 * @param caseNum --sum of the 2 dice rolled
	 * @param dice1Rolled --number dice1 rolled
	 * @param dice2Rolled --number dice2 rolled
	 */
	static void responseFor7_or_11(int caseNum, int dice1Rolled, int dice2Rolled) {
		System.out.println("You rolled " + dice1Rolled + " + " + dice2Rolled);
		if (pointEstablished && caseNum == 7) {
			System.out.println("Craps, Better Luck Next Time, You Lose");
			bankBalance -= wager;
			System.out.println("BankBalance: $" + bankBalance);
			play = false;
		}else if (pointEstablished && caseNum == 11){
			
		}
		else{
			System.out.println("Congratulations, You Win");
			bankBalance += wager;
			System.out.println("BankBalance: $" + bankBalance);
			play = false;
		}
	};
}

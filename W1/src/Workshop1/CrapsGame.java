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



public class CrapsGame {
	static boolean play = true;
	static boolean pointEstablished = false;
	static int point = 0;
	private int dice1 = 7;
	private int dice2 = 7;
	/**
	 * This program allows the user to play a game of craps according to the gambling rules
	 * @param args --not used
	 */
	public static void main(String[] args) {
		CrapsGame cg = new CrapsGame();
		cg.playCrapsGame();
		
	}
	
	/**
	 * This method let the user play a game of craps.
	 */
	public void playCrapsGame() {
		while(play) {
			this.rollDice1();
			this.rollDice2();
			
			int rolledSum = this.dice1Rolled() + this.dice2Rolled();
			switch(rolledSum) {
			case 2:
				this.responseFor2_3_or_12();
				play = false;
				break;
			case 3:
				this.responseFor2_3_or_12();
				play = false;
				break;
			case 4:
				responseFor4_5_6_8_9_or_10(4, this.dice1Rolled(),this.dice2Rolled());
				break;
			case 5: 
				responseFor4_5_6_8_9_or_10(5, this.dice1Rolled(),this.dice2Rolled());
				break;
			case 6:
				responseFor4_5_6_8_9_or_10(6, this.dice1Rolled(),this.dice2Rolled());
				break;
			case 7:
				responseFor7_or_11(7, this.dice1Rolled(), this.dice2Rolled());
				break;
			case 8:
				responseFor4_5_6_8_9_or_10(8, this.dice1Rolled(), this.dice2Rolled());
				break;
			case 9:
				responseFor4_5_6_8_9_or_10(9, this.dice1Rolled(), this.dice2Rolled());
				break;
			case 10:
				responseFor4_5_6_8_9_or_10(10, this.dice1Rolled(), this.dice2Rolled());
				break;
			case 11:
				responseFor7_or_11(11, this.dice1Rolled(), this.dice2Rolled());
				break;
			case 12:
				this.responseFor2_3_or_12();
				play = false;
				break;
			}
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
	 * of the game
	 * if you are able to roll a sum of the two dice same as the number set for point a second time you win
	 * the game ends
	 * 
	 * @param caseNum --sum of two dice rolled
	 * @param dice1Rolled --number dice1 rolled
	 * @param dice2Rolled --number dice2 rolled
	 */
	static void responseFor4_5_6_8_9_or_10(int caseNum, int dice1Rolled, int dice2Rolled) {
		System.out.println("You rolled " + dice1Rolled + " + " + dice2Rolled);
		if (point == caseNum) {
			System.out.println("Congratulations, You win");
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
	 * is set you win and the game ends
	 * if the point is set and you roll a sum of 7 you lose and the game ends
	 * @param caseNum --sum of the 2 dice rolled
	 * @param dice1Rolled --number dice1 rolled
	 * @param dice2Rolled --number dice2 rolled
	 */
	static void responseFor7_or_11(int caseNum, int dice1Rolled, int dice2Rolled) {
		System.out.println("You rolled " + dice1Rolled + " + " + dice2Rolled);
		if (pointEstablished && caseNum == 7) {
			System.out.println("Craps, Better Luck Next Time, You Lose");
			play = false;
		}else if (pointEstablished && caseNum == 11){
			
		}
		else{
			System.out.println("Congratulations, You Win");
			play = false;
		}
	};
}

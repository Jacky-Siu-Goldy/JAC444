package ml;
/**********************************************
Workshop # 5
Course: JAC444 - Semester Winter 2023
Last Name: Siu
First Name: Chun Kit Jacky
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-05
**********************************************/
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This is a computerize version of the Game "Mad Libs"
 * 
 * @author Jacky Chun Kit Siu
 *
 */
public class MadLibs {
	/**
	 * The main program for this computerize version of madlib.
	 * It allows the user to input a special kind of text file that
	 * contain a body of text (a Story) with a bunch of placeholders in it.
	 * Those Placeholders serves as tokens that can be replaced by
	 * a word or phrase that the user enters. After all the tokens
	 * have been replaced, the program creates an altered
	 * text file with all the users input that can be viewed if the user
	 * chose to view it. As the program start there are three options to chose from
	 * (C)reate mad-lib, (V)iew mad-lib, or (Q)uit. If the user input C or c, 
	 * the user enters into a process of creating a mad-lib text file as was described 
	 * previously. If the user select v or V it allows the Users to view a mad-lib text file.
	 * Finally if the user enters q or Q the program exit.
	 * @param args - String argument not used.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the game of Mad Libs.\n"
				+ "I will ask you to provide various words\n"
				+ "and phrases to fill in a story.\n"
				+ "The result will be written to an output file.\n");
		boolean quit =false;
		String gameChoice="";
		Scanner scan = new Scanner(System.in);
		Pattern choicePattern = Pattern.compile("[cvqCVQ]");
		while(!quit) {
			boolean isChoiceCorrect = false;
			do {
				System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
				gameChoice = scan.nextLine();
				Matcher match = choicePattern.matcher(gameChoice);
				isChoiceCorrect = match.find();
			}while(gameChoice.length()!=1||!isChoiceCorrect);
			
			char gameChoiceChar = gameChoice.toLowerCase().charAt(0);
			
			
			switch(gameChoiceChar) {
			case 'c':
				String original = readTxtFile(scan);
				
				System.out.print("Output file name: ");
				String fileOutName = scan.nextLine();
				
				int lastIndex = 0;
				StringBuilder output = new StringBuilder();
				Pattern token = Pattern.compile("(<([a-zA-Z'-]+)>)");
				Matcher match = token.matcher(original);
				Pattern vowel = Pattern.compile("^[aeiou]");
				System.out.println("");
				while(match.find()) {
					String placeHolder = match.group(2);
					Matcher vowelMatch = vowel.matcher(placeHolder);
					String newPlaceHolder = placeHolder.replace('-', ' ');
					if(vowelMatch.find()) {
						System.out.print("Please type an " + newPlaceHolder + ": ");
					}else {
						System.out.print("Please type a " + newPlaceHolder + ": ");
					}
					String replacement = scan.nextLine();
					output.append(original, lastIndex, match.start()).append(replacement);
					lastIndex = match.end();
				}
				if(lastIndex < original.length()) {
					output.append(original, lastIndex, original.length());
				}
				try {
					FileWriter myWriter = new FileWriter(fileOutName);
					myWriter.write(output.toString());
					myWriter.close();
					System.out.println("Your mad-lib has been created!\n");
					
				}catch( IOException e) {
					System.err.println("Error in creating file!\n");
				}
				
				break;
			case 'v':
				System.out.println("\n" + readTxtFile(scan));
				break;
				
			case 'q':
				quit = true;
				break;
			}
			
		}
		scan.close();
	}
	/**
	 * This function prompts the user to enter a filename. And then it proceed to read from the
	 * text file with the name that the user have entered. The function uses Files.readString(path) to read the
	 * the content of the file and uses StringBuilder to append the content to a String.
	 * After it reach the end of file and the whole text has been collected. The function return a
	 * String containing the text.
	 * @param scan - it is an object of the Scanner class. It allow the program to scan for the filename the user entered
	 * @return a String - the String contain the text that was read by the function from the file
	 */
	public static String readTxtFile(Scanner scan) {
		StringBuilder input = new StringBuilder();
		boolean loopedOnceAlready = false;
		boolean anErrorOccurred = false;
		
		do {
			try {
				if(!loopedOnceAlready) {
					System.out.print("Input file name: ");
				}
				String fileInName = scan.nextLine();
				Path path = Paths.get(fileInName);
				input.append(Files.readString(path));
				
				anErrorOccurred = false;
			}catch(IOException e) {
				loopedOnceAlready = true;
				anErrorOccurred = true;
				System.out.print("File not found. Try again: ");
				
			}
			
		}while(anErrorOccurred);
		
		return input.toString();
	}
}

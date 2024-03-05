package ns;

import java.io.File;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rbgn.RankBoyGirlName;
/**********************************************
Workshop # 6
Course: JAC444 - Semester Winter 2023
Last Name: Siu
First Name: Chun Kit Jacky
ID: 134663186
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2023-03-17
**********************************************/
/**
 * This class contains the getNamesAndRankFromFile method and the nameSearch method
 * 
 * @author Jacky Chun Kit Siu
 *
 */
public class NameSearch {
private RankBoyGirlName[] boyGirlNameArray = new RankBoyGirlName[1000];
    /**
     * constructor initialize the boyGirlNameArray
     */
	public NameSearch() {
		for(int i = 0; i < 1000; i++) {
			boyGirlNameArray[i] = new RankBoyGirlName();
		}
	
	}
	
	/**
	 * return the member variable array
	 * @return boyGirlNameArray of objects of the RankBoyGirlName class
	 */
	public RankBoyGirlName[] getBoyGirlNameArray() {
		return boyGirlNameArray;
	}
   
	 /**
	  * set the member variable array
	  * @param boyGirlNameArray of objects of the RankBoyGirlName class
	  */
	public void setBoyGirlNameArray(RankBoyGirlName[] boyGirlNameArray) {
		this.boyGirlNameArray = boyGirlNameArray;
	}
	
	/**
	 * 
	 * Need to change the file directory in order for this application to work on your computer
	 * 
	 * Open the right file base on the year provided and read its content
	 * load the BoyGirlNameArray with the file content
	 * 
	 * @param year part of the name of the file
	 * @param boyGirlNamesArray of objects of the RankBoyGirlName class
	 * @throws IOException --if the file is not found
	 */
	public void getNamesAndRanksFromFile(String year, RankBoyGirlName[] boyGirlNamesArray) throws IOException {
		
		StringBuilder fileName = new StringBuilder();
		
		fileName.append("C:\\Users\\goldy\\Documents\\JAC444_NAA\\W6T1\\src\\application\\Babynamesranking");
		
		fileName.append(year + ".txt");
		
		String fileName2 = fileName.toString();
		
		File boyGirlNamesFile = new File(fileName2);
		
		Pattern token = Pattern.compile("\\S+");
		
		try {
			Scanner scan = new Scanner(boyGirlNamesFile);
			int numberOfLine = 0;
			while(scan.hasNextLine()) {
				
				String data = scan.nextLine();
				Matcher match = token.matcher(data);
				int count = 0;
				while(match.find()) {
					if(count == 0) {
						boyGirlNamesArray[numberOfLine].setRank(match.group(0));
					}else if(count == 1) {
						boyGirlNamesArray[numberOfLine].setBoyName(match.group(0));
					}else if (count == 3) {
						boyGirlNamesArray[numberOfLine].setGirlName(match.group(0));
					}
					
					count++;	
				}
				boyGirlNameArray[numberOfLine].setYear(year);
				numberOfLine++;
				if(numberOfLine > 999) {
					break;
				}
			}
			scan.close();
		}catch(IOException e) {
			
			throw new IOException();
		};
		
		
	}
	
	/**
	 * Search for the name in the BoyGirlNameArray and get the name rank and year base on the Gender
	 * -set rankYearName object of the RankBoyGirlName class
	 * and return the object
	 * @param year - year of the search
	 * @param gender - gender of the search
	 * @param name - name of the search
	 * @param boyGirlNameArray - An array of object of the RankBoyGirlName class
	 * @return and object of the RankBoyGirlName Class
	 */
	public RankBoyGirlName nameSearch (String year, String gender, String name, 
		RankBoyGirlName[] boyGirlNameArray){
		Pattern namePattern = Pattern.compile(name.toLowerCase());
		
		RankBoyGirlName rankYearName = new RankBoyGirlName();
		char gender2 = gender.toLowerCase().charAt(0);
		switch (gender2) {
		case 'm':
					for (RankBoyGirlName object : boyGirlNameArray) {
						  Matcher matcher = namePattern.matcher(object.getBoyName().toLowerCase());
						  if(matcher.find()) {
								  
							  rankYearName.setBoyName(object.getBoyName());
							  rankYearName.setRank(object.getRank());
							  rankYearName.setYear(object.getYear());
							  break;
						  }
						  
					  }
					break;
			
		case 'f':
					for (RankBoyGirlName object : boyGirlNameArray) {
						  Matcher matcher = namePattern.matcher(object.getGirlName().toLowerCase());
						  if(matcher.find()) {
								  
							  rankYearName.setGirlName(object.getGirlName());
							  rankYearName.setRank(object.getRank());
							  rankYearName.setYear(object.getYear());
							  break;
						  }
						  
					  }
					break;
			
		}
		
		return rankYearName;
	}
}

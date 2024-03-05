package rbgn;
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
 * This class contains the properties needed to be able make an object that can be use to record
 * information from a file that contain that kind of information
 * @author goldy
 *
 */
public class RankBoyGirlName {
	private String rank;
	private String boyName;
	private String girlName;
	private String year;
	/**
	 * Contructor initialize member variable 
	 */
	public RankBoyGirlName() {
		rank = "";
		boyName = "";
		girlName = "";
		year = "";
	}
	
	/**
	 * return the year
	 * @return year -- A String member variable
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * set the member variable year base on the argument provide
	 * @param year -- A string 
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * return the rank
	 * @return rank -- A String member variable
	 */
	public String getRank() {
		return rank;
	}
	
	/**
	 * set the member variable rank base on the argument provide
	 * @param rank -- A string 
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	/**
	 * return a Boy name
	 * @return boyName -- A String member variable
	 */
	public String getBoyName() {
		return boyName;
	}
	
	/**
	 * set the member variable boyName base on the argument provide
	 * @param boyName -- A string 
	 */
	public void setBoyName(String boyName) {
		this.boyName = boyName;
	}
	
	/**
	 * return a girl name
	 * @return girlName -- A String member variable
	 */
	public String getGirlName() {
		return girlName;
	}
	
	/**
	 * set the member variable girlName base on the argument provide
	 * @param girlName -- A string 
	 */
	public void setGirlName(String girlName) {
		this.girlName = girlName;
	}
}

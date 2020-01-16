package main;
/**
 * Template to hold an object Card.
 * This class is meant to represent an object Card.
 * An array of 52 cards would make the deck for our game.
 * 
 * @author Janvi Sharma
 *
 */

public class Cards {
	int cardValue;
	String imageName="";
	Cards()
	{
	cardValue=0;
	imageName="";
	}
	
	/**
	 * Assigning Card Values: Setter function.
	 * This method takes in a parameter of the form integer and assigns
	 * that value to its corresponding card object.
	 * @param a Parameter of type int holding the card's value.
	 */
	public void assignCardValue(int a) {
		cardValue = a;
	}
	
	/**
	 * Get Card Value: Getter function.
	 * This function returns the card value of an object of type Card.
	 * @return cardValue Integer type value given to a card.
	 */
	public int getCardValue() {
		return cardValue;
	}
	
	/**
	 * Assigning Image Name: Setter function.
	 * This method takes in a string as a parameter and assigns
	 * the image name accordingly to enable the use of image icons to display
	 * the cards.
	 * @param s Parameter of type string 
	 */
	public void assignImageName(String s) {
		String g;
		g = "card_"+s+"-0000.jpg";
		imageName = g;
	}
	
	/**
	 * Get Image Name: Getter function.
	 * This method returns the image name associated with a Card object.
	 * @return imageName String type value that holds file name of card's image.
	 */
	public String getImageName() {
		return imageName;
	}
	
}



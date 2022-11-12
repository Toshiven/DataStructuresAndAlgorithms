package CardGameWar;

public class Card {
	/*
	 * Abler, Andrew Kevin M.
	 * The Card Game War
	 *
	 */

	     // Attributes

	     private int suit; // 1 Clubs, 2 Diamonds, 3 Hearts, 4 Spades
	     private int value; // 1 Ace... 11 J, 12 Q, 13 K

	     // Constructors

	     public Card() { // Default constructor, default card is Ace of Spades
	          this.suit = 1;
	          this.value = 1;
	     }

	     /**
	      * 
	      * @param suit
	      * @param value
	      */
	     public Card(int suit, int value) { // Construct a speciifc card
	          this.suit = suit;
	          this.value = value;
	     }

	     // Methods
	     /**
	      * 
	      * @return
	      */
	     public int getSuit() {
	          return this.suit;
	     }

	     /**
	      * 
	      * @return
	      */
	     public int getValue() {
	          return this.value;
	     }

	     /**
	      * 
	      * @param suit
	      */
	     public void setSuit(int suit) {
	          this.suit = suit;
	     }

	     /**
	      * 
	      * @param value
	      */
	     public void setValue(int value) {
	          this.value = value;
	     }

	     /**
	      * 
	      * @return
	      */
	     public String getName() {
	          String name = "";

	          // Convert int value to name of face value as String

	          if (this.value == 1)
	               name = "A";
	          else if (value == 11) 
	               name = "J";
	          else if (value == 12)
	               name = "Q";
	          else if (value == 13)
	               name = "K";
	          else // For cards 2 through 10
	               name = Integer.toString(value);

	          // Convert int suit to name of suit as String

	          if (suit == 1)
	               name += (char)'c';
	          else if (suit == 2)
	               name += (char)'d';
	          else if (suit == 3)
	               name += (char)'h';
	          else if (suit == 4)
	               name += (char)'s';

	          // Return name as a String

	          return name;
	     }

	     public String toString() {
	          return getName();
	     }
	}

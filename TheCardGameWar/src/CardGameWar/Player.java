package CardGameWar;


public class Player {
	/*
	 * Abler, Andrew Kevin M.
	 * The Card Game War
	 *
	 */
	
     // Attributes

     private Hands hand;
     private String name;

     // Default constructor

     /**
      * 
      * @param name
      */
     public Player(String name) {
          hand = new Hands(); // Instantiate new hand object
          this.name = name;
     }

     // Methods
     /**
      * 
      * @return
      */
     public Card playCard() {
          Card c = hand.playCard();
          System.out.println(String.format("%5s", name) + " plays a " + c.getName() + "!");

          return c;
     }
     
     /**
      * 
      * @param card
      */
     public void takeCard(Card card) {
          hand.addCard(card);
     }
     
     /**
      * 
      * @return
      */
     public String getName() {
          return name;
     }
     
     public void displayHand() {
          System.out.println(name + "\'s hand (" + hand.getSize() + "):");
          hand.display();
          System.out.println();
     }

     /**
      * 
      * @return
      */
     public int handSize() {
          return hand.getSize();
     }
}

package CardGameWar;

import java.util.*; // Import Random

public class SimulateGame {
	/*
	 * Abler, Andrew Kevin M.
	 * The Card Game War
	 *
	 */
	
    // Attributes

    private static Player playerOne = new Player("Player 1");
    private static Player playerTwo = new Player("Player 2");
    private static Player currentPlayer = playerOne;
    private static Deck deck = new Deck(true); // Shuffle deck automatically
    private static ArrayList<Card> table = new ArrayList<>();
    private static Card topCard;
    private static int roundsPlayed = 1;
    private static boolean gameOver = false;

    // Main method

    public static void main(String[] args) {
        playGame();
    }

    // Methods

    // Play the simple card game
    public static void playGame() {
        System.out.println("Starting game...");
        System.out.println();

        dealCards(); // Deal 26 cards to each player
        chooseFirstPlayer(); // Choose who goes first
        
        if(playerOne.handSize() > 0 || playerTwo.handSize() > 0) {
        playRounds(); // Start the rounds
        }
        
        if(playerOne.handSize() == 0 || playerTwo.handSize() == 0) {
        declareWinner(); // Declare a winner
        }
    }

    // Deal 26 cards to each hand in alternating order
    public static void dealCards() {
        for (int i = 0; i < 26; i++) {
            playerOne.takeCard(deck.deal());
            playerTwo.takeCard(deck.deal());
        }
    }

    // Choose who goes first
    public static void chooseFirstPlayer() {
        Random random = new Random();
        int n = random.nextInt(2);

        if (n == 1) { // Make playerTwo the new playerOne
            Player temp = playerOne;
            playerOne = playerTwo;
            playerTwo = temp;
        }
    }

    // Play rounds, max 10
    public static void playRounds() {
        while (roundsPlayed <= 100 && (gameOver == false)) {
            // Display the round number
            System.out.println("ROUND " + roundsPlayed);
            System.out.println();

            // Display each player's hand
            displayHands();
            
            // Play individual round
            playRound();
            
            // Increment roundsPlayed counter
            roundsPlayed++;    
        }
    }

    // Play an individual round
    public static void playRound() {
        boolean suitMatch = false; // Flag for notifying a suit match
        Card cardToPlay;

        

        while (suitMatch == false) {
        	
        	if ((playerOne.handSize() == 0) || (playerTwo.handSize() == 0)) {
                gameOver = true;
                break;
            }
        	
            // Current player places card on table
            cardToPlay = currentPlayer.playCard();
            table.add(cardToPlay);

            // Check if there's a suit match
            suitMatch = checkSuitMatch();

            if (suitMatch == false)
                switchCurrentPlayer();
        }

        collectCards();
        System.out.println();

        // Sleep for a second before beginning a new round
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
        }
    }

    // Switch current player
    public static void switchCurrentPlayer() {
        if (currentPlayer == playerOne)
            currentPlayer = playerTwo;
        else if (currentPlayer == playerTwo)
            currentPlayer = playerOne;
    }

    // Check for a suit match
    public static boolean checkSuitMatch() {
        int tableSize = table.size();
        int lastSuit;
        int topSuit;

        if (tableSize < 2) {
            return false;
        }
        else {
            lastSuit = table.get(tableSize - 1).getSuit();
            topSuit = table.get(tableSize - 2).getSuit();
        }

        // Check suit equivalence
        if (lastSuit == topSuit) {
            System.out.println();
            System.out.println(currentPlayer.getName() + " wins the round!");
            System.out.println();

            return true;
        }

        return false;
    }

    // Collect cards from table
    public static void collectCards() {
        // Print a message
        System.out.print(currentPlayer.getName() + " takes the table (" +
            table.size() + "): ");
        displayTable();

        // Player takes each card from the table and adds to hand
        for (int i = 0; i < table.size(); i++) {
            Card cardToTake = table.get(i);
            currentPlayer.takeCard(cardToTake);
        }

        table.clear();
    }

    // Displays all the cards currently on the table
    public static void displayTable() {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {
                System.out.print(table.get(i).getName() + " ");
            }
        }

        System.out.println();
        System.out.println();
    }

    // Displays each player's current hand
    public static void displayHands() {
        playerOne.displayHand();
        playerTwo.displayHand();
    }

    // Declare a winner
    public static void declareWinner() {
        if (playerTwo.handSize() == 0) {
            System.out.println(playerOne.getName().toUpperCase() + " WINS ");
        }
        else if (playerOne.handSize() == 0) {
            System.out.println(playerTwo.getName().toUpperCase() + " WINS ");
        }
        else {
            System.out.println("TIE! CONGRATS! kinda lost technically :p");
        }

        System.out.println();
    }
}

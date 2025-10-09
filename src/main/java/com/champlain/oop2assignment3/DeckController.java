package com.champlain.oop2assignment3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * Controller class for managing the deck and hand of cards in the user interface.
 * <p>
 * This class handles user interactions with the deck, including shuffling,
 * sorting, scoring, and drawing cards. It updates the UI components to reflect
 * the current state of the deck and hand.
 * </p>
 */
public class DeckController {
    /**
     * TextArea for displaying the current state of the deck.
     */
    @FXML
    private TextArea aDeckTextArea;

    /**
     * TextArea for displaying the current hand of cards.
     */
    @FXML
    private TextArea aHandTextArea;

    /**
     * ChoiceBox for selecting the sorting strategy for the deck.
     */
    @FXML
    private ChoiceBox<String> aSortStrategyChoiceBox;

    /**
     * ChoiceBox for selecting the scoring strategy for the hand.
     */
    @FXML
    private ChoiceBox<String> aScoreStrategyChoiceBox;

    /**
     * Label for displaying the current score based on the selected scoring strategy.
     */
    @FXML
    private Label aScoreLabel;

    /**
     * The deck of cards being managed by this controller.
     * <p>
     * Modified to get instance instead of creating a new deck.
     */
    private final Deck aDeck = Deck.getInstance();

    /**
     * The hand of cards being managed by this controller.
     */
    private final Hand aHand = new Hand();

    /**
     * Initializes the controller and sets up the UI components.
     * This method is called after the FXML file has been loaded.
     */
    public void initialize() {
        this.displayCardCollections();
        this.aSortStrategyChoiceBox.getItems().addAll("Rank First", "Suit First");
        this.aScoreStrategyChoiceBox.getItems().addAll("Simple Count", "Number Of Aces");
        this.testEquals();
    }

    /**
     * Upon initialization the system will test the equality of three cards.
     * The first comparison should return true, the second false.
     */
    public void testEquals(){
        Card card1 = new Card(Rank.QUEEN, Suit.CLUBS);
        Card card2 = new Card(Rank.QUEEN, Suit.CLUBS);
        Card card3 = new Card(Rank.ACE, Suit.DIAMONDS);

        System.out.println("card1 equals card2: " + card1.equals(card2)); // should print true
        System.out.println("card1 equals card3: " + card1.equals(card3)); // should print false
    }

    /**
     * Handles the event when the shuffle button is clicked.
     * Shuffles the deck and updates the displayed card collections.
     */
    @FXML
    protected void onShuffleButtonClick() {
        this.aDeck.shuffle();
        this.displayCardCollections();
    }

    /**
     * Handles the event when the sort button is clicked.
     * Sorts the deck based on the selected sorting strategy.
     * Displays an error alert if no strategy is selected.
     */
    @FXML
    protected void onSortButtonClick() {
        String choice = this.aSortStrategyChoiceBox.getValue();
        if (choice == null) {
            Alert selectionErrorAlert = new Alert(Alert.AlertType.ERROR, "Please choose a sorting strategy first.");
            selectionErrorAlert.showAndWait();
        } else {
            switch (choice) {
                case "Rank First":
                    // TODO: Replace the following line of code.
                    this.aDeckTextArea.setText("This does not sort by rank first yet.");
                    break;
                case "Suit First":
                    // TODO: Replace the following line of code.
                    this.aDeckTextArea.setText("This does not sort by suit first yet.");
                    break;
                default:
                    this.aDeckTextArea.setText("This should not happen! You messed up.");
                    break;
            }
        }
    }

    /**
     * Handles the event when the score button is clicked.
     * Calculates the score based on the selected scoring strategy.
     * Displays an error alert if no strategy is selected.
     */
    @FXML
    protected void onScoreButtonClick() {
        String choice = this.aScoreStrategyChoiceBox.getValue();
        if (choice == null) {
            Alert selectionErrorAlert = new Alert(Alert.AlertType.ERROR, "Please choose a scoring strategy first.");
            selectionErrorAlert.showAndWait();
        } else {
            switch (choice) {
                case "Simple Count":
                    // TODO: Replace the following line of code.
                    this.aScoreLabel.setText("Simple count...");
                    break;
                case "Number Of Aces":
                    // TODO: Replace the following line of code.
                    this.aScoreLabel.setText("Number of aces...");
                    break;
                default:
                    this.aScoreLabel.setText("This should not happen! You messed up.");
                    break;
            }
        }
    }

    /**
     * Handles the event when the draw button is clicked.
     * Draws a card from the deck and adds it to the player's hand.
     * Displays an alert if there are no more cards in the deck.
     */
    @FXML
    protected void onDrawButtonClick() {
        if (!this.aDeck.isEmpty()) {
            this.aHand.addCard(this.aDeck.draw());
        } else {
            Alert selectionErrorAlert = new Alert(Alert.AlertType.INFORMATION, "There are no more cards in the deck.");
            selectionErrorAlert.showAndWait();
        }
        this.displayCardCollections();
    }

    /**
     * Updates the text areas to display the current state of the deck and hand.
     */
    private void displayCardCollections() {
        this.aDeckTextArea.setText(this.aDeck.toString());
        this.aHandTextArea.setText(this.aHand.toString());
    }
}
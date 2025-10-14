package com.champlain.oop2assignment3;
import java.util.Comparator;
/**
 * A comparator that sorts {@link Card} objects by suit first, then by rank.
 * <p>
 * The custom suit order is defined as:
 * <b>Clubs → Diamonds → Hearts → Spades</b>.
 * When two cards have the same suit, their ranks are compared to determine order.
 * </p>
 */

public class SuitFirstComparator implements Comparator<Card> {
    /**
     * Compares two {@link Card} objects by suit first and then by rank.
     *
     * @param c1 the first card to compare
     * @param c2 the second card to compare
     * @return a negative integer if {@code c1} should come before {@code c2},
     *         zero if they are equal, or a positive integer if {@code c1}
     *         should come after {@code c2}.
     */
    @Override
    public int compare(Card c1, Card c2) {
        // Compare suits first (using custom suit order)
        int suitComparison = getSuitOrder(c1.getSuit()) - getSuitOrder(c2.getSuit());
        if (suitComparison != 0) {
            return suitComparison;
        }

        // Then compare ranks
        return c1.getRank().compareTo(c2.getRank());
    }
    /**
     * Returns a numeric value representing the custom order of each suit.
     * <p>
     * This method assigns a fixed priority to each suit:
     * Clubs = 1, Diamonds = 2, Hearts = 3, Spades = 4.
     * </p>
     *
     * @param suit the {@link Suit} whose order value is being retrieved
     * @return an integer representing the suit's sort order
     */
    private int getSuitOrder(Suit suit) {
        switch (suit) {
            case CLUBS: return 1;
            case DIAMONDS: return 2;
            case HEARTS: return 3;
            case SPADES: return 4;
            default: return 0;
        }
    }
}

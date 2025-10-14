package com.champlain.oop2assignment3;
import java.util.Comparator;

public class SuitFirstComparator implements Comparator<Card> {
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

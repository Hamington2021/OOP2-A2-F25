package com.champlain.oop2assignment3;

import java.util.Comparator;
/**
 * Comparator for comparing cards by rank first, then by suit.
 * Used to sort cards primarily by their {@link Rank}.
 *
 * @author Pascale Fontaine
 */
public class RankFirstComparator implements Comparator<Card> {
    /**
     * Compares two cards by rank, then by suit if ranks are equal.
     *
     * @param c1 the first card
     * @param c2 the second card
     * @return a negative, zero, or positive number based on comparison
     */
    @Override
    public int compare(Card c1, Card c2) {
        int rankComparison = c1.getRank().compareTo(c2.getRank());

        if (rankComparison == 0) {
            return c1.getSuit().compareTo(c2.getSuit());
        }

        return rankComparison;
    }
}

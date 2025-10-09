package com.champlain.oop2assignment3;

import java.util.Comparator;

public class RankFirstComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        int rankComparison = c1.getRank().compareTo(c2.getRank());

        if (rankComparison == 0) {
            return c1.getSuit().compareTo(c2.getSuit());
        }

        return rankComparison;
    }
}

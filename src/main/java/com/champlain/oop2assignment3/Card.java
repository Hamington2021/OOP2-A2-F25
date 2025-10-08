package com.champlain.oop2assignment3;

/**
 * Represents a playing card with a specific suit and rank.
 * @implNote This class is immutable, meaning that once a card is created, its suit and rank cannot be changed.
 */
public class Card {
    /**
     * The suit of this card (e.g., Hearts, Diamonds, Clubs, Spades).
     */
    private final Suit aSuit;

    /**
     * The rank of this card (e.g., Ace, 2, 3, ..., King).
     */
    private final Rank aRank;

    /**
     * Constructs a new Card with the specified rank and suit.
     *
     * @param pRank the rank of the card (e.g., Ace, 2, 3, ..., King)
     * @param pSuit the suit of the card (e.g., Hearts, Diamonds, Clubs, Spades)
     */
    public Card (Rank pRank, Suit pSuit) {
        this.aRank = pRank;
        this.aSuit = pSuit;
    }

    /**
     * Returns the rank of this card.
     *
     * @return the rank of the card
     */
    public Rank getRank() {
        return this.aRank;
    }

    /**
     * Returns the suit of this card.
     *
     * @return the suit of the card
     */
    public Suit getSuit() {
        return this.aSuit;
    }

    /**
     * Returns a string representation of this card.
     *
     * @return a string in the format "Rank of Suit" (e.g., "Ace of Hearts")
     */
    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }

    /**
     * The boolean method takes an object and confirms it's a card by getting its class.
     * It ensures the object isn't null.
     * When the object is confirmed, it is then cast for comparison.
     * @param pObj   the reference object with which to compare.
     * @return will return true if the card is a duplicate, false otherwise.
     */
    @Override
    public boolean equals(Object pObj) {
        if (pObj == null) {
            return false;
        }
        if (pObj.getClass() != this.getClass()) {
            return false;
        }
        if (this == pObj) {
            return true;
        }
        Card card = (Card) pObj;
        return aRank == card.aRank && aSuit == card.aSuit;
    }
}


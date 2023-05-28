package com.isidore.model;

import com.isidore.constant.Rank;
import com.isidore.constant.Suit;

public class Card {
    int id;
    Suit suit;
    Rank rank;

    public Card(int id, Suit suit, Rank rank) {
        this.id = id;
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
}

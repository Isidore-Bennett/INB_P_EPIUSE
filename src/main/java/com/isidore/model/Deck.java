package com.isidore.model;

import com.isidore.constant.Rank;
import com.isidore.constant.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Deck {
    public Deck() {
        initialize();
    }

    private static List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    private void initialize() {
        cards = new ArrayList<>();
        int id = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(++id, suit, rank));
            }
        }
    }

    public Deck shuffle() {
        Map<String, Card> shuffledCardMap = cards
                .stream()
                .collect(Collectors.toMap(x -> UUID.randomUUID().toString(), Function.identity()));

        cards = new TreeSet<>(shuffledCardMap.keySet())
                .stream()
                .map(shuffledCardMap::get)
                .collect(Collectors.toList());

        return this;
    }

    public static int deckSize() {
        return cards.size();
    }

    public static List<Card> draw(int handSize) {
        List<Card> returnCards = cards.stream().limit(handSize).collect(Collectors.toList());
        cards = deckSize() < handSize
                ? cards
                : cards.subList(handSize - 1, deckSize() - 1);
        return returnCards;
    }
}

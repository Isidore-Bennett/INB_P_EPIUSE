package com.isidore.service;

import com.isidore.model.Card;
import com.isidore.model.Deck;

import java.util.List;
import java.util.Objects;

public class DeckService {
    private static DeckService instance;
    private Deck currentDeck;

    private DeckService() {
    }

    private static DeckService setInstance(DeckService currentInstance) {
        instance = currentInstance;
        return instance;
    }

    public static synchronized DeckService getInstance() {
        return Objects.isNull(instance) ? setInstance(new DeckService()) : instance;
    }

    public List<Card> newShuffle() {
        currentDeck = new Deck();
        return currentDeck.shuffle().getCards();
    }

    public List<Card> newDeck() {
        currentDeck = new Deck();
        return currentDeck.getCards();
    }

    public List<Card> currentDeck() {
        return currentDeck.getCards();
    }
}

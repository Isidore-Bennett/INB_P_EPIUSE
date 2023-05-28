package com.isidore.service;

import com.isidore.model.Card;
import com.isidore.model.Deck;

import java.util.List;
import java.util.Objects;

public class CardService {
    private static CardService instance;
    private final HandService handService;
    private final GameService gameService;

    private CardService() {
        handService = HandService.getInstance();
        gameService = GameService.getInstance();
    }

    private static CardService setInstance(CardService currentInstance) {
        instance = currentInstance;
        return instance;
    }

    public static synchronized CardService getInstance() {
        return Objects.isNull(instance) ? setInstance(new CardService()) : instance;
    }

    public List<Card> draw() {
        if (Deck.deckSize() == 0) {
            new Deck().shuffle();
        }
        handService.getCurrentHand().setCards(Deck.draw(gameService.getCurrentGame().handSize));
        return handService.getCurrentHand().getCards();
    }
}

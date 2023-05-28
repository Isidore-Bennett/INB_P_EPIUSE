package com.isidore.service;

import com.isidore.model.Card;
import com.isidore.model.Hand;
import com.isidore.util.RuleEngine;

import java.util.List;
import java.util.Objects;

public class HandService {
    private static HandService instance;
    private final GameService gameService;
    private Hand currentHand = new Hand();

    private HandService() {
        gameService = GameService.getInstance();
    }

    private static HandService setInstance(HandService currentInstance) {
        instance = currentInstance;
        return instance;
    }

    public static synchronized HandService getInstance() {
        return Objects.isNull(instance) ? setInstance(new HandService()) : instance;
    }

    public void setCurrentHand(Hand currentHand) {
        this.currentHand = currentHand;
    }

    public Hand getCurrentHand() {
        return currentHand;
    }

    public String getStrength(List<Card> hand) {
        return RuleEngine.doCheck(hand, gameService.getCurrentGame());
    }
}

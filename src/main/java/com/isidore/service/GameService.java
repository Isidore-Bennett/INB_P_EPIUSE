package com.isidore.service;

import com.isidore.constant.Game;
import com.isidore.model.Card;
import com.isidore.model.Hand;
import com.isidore.util.RuleEngine;

import java.util.List;
import java.util.Objects;

public class GameService {
    private static GameService instance;
    private Game currentGame;

    private GameService() {
    }

    private static GameService setInstance(GameService currentInstance) {
        instance = currentInstance;
        return instance;
    }

    public static synchronized GameService getInstance() {
        return Objects.isNull(instance) ? setInstance(new GameService()) : instance;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public Game[] getGameCollection() {
        return Game.values();
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}

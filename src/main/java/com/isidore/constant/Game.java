package com.isidore.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum Game {
    FIVE_CARD_DRAW("FIVE_CARD_DRAW", 5),
    BADUGI("BADUGI", 4);


    public final String value;
    public final int handSize;
    private static final Map<String, Game> valueToGame = new HashMap<>();

    static {
        valueToGame.putAll(Arrays
                .stream(Game.values())
                .collect(Collectors.toMap(game -> game.value, game -> game)));
    }

    Game(String value, int handSize) {
        this.value = value;
        this.handSize = handSize;
    }

    public static Game getGame(String value) {
        return valueToGame.get(value);
    }
}

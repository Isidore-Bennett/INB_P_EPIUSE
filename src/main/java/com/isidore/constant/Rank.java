package com.isidore.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    Ace(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13);

    public final int value;
    private static final Map<Integer, Rank> valueToRank = new HashMap<>();

    static {
        valueToRank.putAll(Arrays
                .stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank.value, rank -> rank)));
    }

    Rank(int value) {
        this.value = value;
    }

    public static boolean rankExists(int rankValue) {
        return Arrays
                .stream(Rank.values())
                .map(rank -> rank.value)
                .collect(Collectors.toList())
                .contains(rankValue);
    }

    public static Rank getRank(int value) {
        return valueToRank.get(value);
    }
}

package com.isidore.util;

import com.isidore.constant.Game;
import com.isidore.constant.Rank;
import com.isidore.model.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class RuleEngine {

    static List<Card> hand;

    public static String doCheck(List<Card> hand, Game game) {
        setHand(hand);
        switch (game) {
            case FIVE_CARD_DRAW:
                return fiveCardDraw();
            case BADUGI:
                return badugi();
            default:
                return "No game selected";
        }
    }

    private static String fiveCardDraw() {
        if (allSuitMatch() && isSequential())
            return "Straight Flush";
        if (thisByThatPair(1, 4))
            return "Four Of a Kind";
        if (thisByThatPair(2, 5))
            return "Full House";
        if (allSuitMatch())
            return "Flush";
        if (isSequential())
            return "Straight";
        if (thisByThatPair(1, 3))
            return "Three Of a Kind";
        if (thisByThatPair(2, 4))
            return "Two Pair";
        if (thisByThatPair(1, 2))
            return "One Pair";

        return "High Card";
    }

    public static String badugi() {
        if (suitGroups(4))
            return "Badugi";
        if (suitGroups(3))
            return "Three-Card Hand";
        if (suitGroups(2))
            return "Two-Card Hand";
        return "One-Card Hand";
    }

    private static void setHand(List<Card> hand) {
        RuleEngine.hand = hand;
    }

    private static boolean suitGroups(int numberOfGroups) {
        return hand.stream().collect(Collectors.groupingBy(Card::getSuit, Collectors.counting())).size() == numberOfGroups;
    }

    private static boolean thisByThatPair(int numberOfGroups, int cardsConsidered) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        hand.forEach(card -> rankCount.put(card.getRank(), Objects.isNull(rankCount.get(card.getRank()))
                ? 1
                : rankCount.get(card.getRank()) + 1));
        List<Integer> cleanList = rankCount.values().stream().filter(i -> i > 1).collect(Collectors.toList());
        return cleanList.size() == numberOfGroups && cleanList.stream().reduce(Integer::sum).orElse(0) == cardsConsidered;
    }

    private static boolean allSuitMatch() {
        return hand.stream().allMatch(card -> card.getSuit().equals(hand.get(0).getSuit()));
    }

    private static boolean allRankMatch() {
        return hand.stream().allMatch(card -> card.getRank().equals(hand.get(0).getRank()));
    }

    private static boolean isSequential() {
        Set<Integer> weights = hand.stream().map(card -> card.getRank().value).collect(Collectors.toSet());
        if (weights.size() < hand.size()) {
            return false;
        }
        Integer lowestWeight = weights.stream().reduce(Integer::min).orElse(-0);
        List<Integer> adjustedWeights = weights.stream().map(integer -> integer - lowestWeight).collect(Collectors.toList());
        return adjustedWeights.stream().reduce(0, Integer::sum) == ((hand.size() - 1) / 2) * hand.size();
    }
}

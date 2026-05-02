package com.programs;

import java.util.*;

public class PlayersWithZeroLossinArray {

    public static void main(String[] args) {
        int[][] matches = { {3, 4}, {2, 4}, {1, 3} };

        Map<Integer, Integer> lossCount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // Ensure winner exists with 0 loss
            lossCount.putIfAbsent(winner, 0);

            // Increment loser count
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : lossCount.entrySet()) {
            int player = entry.getKey();
            int losses = entry.getValue();

            if (losses == 0) {
                zeroLoss.add(player);
            } else if (losses == 1) {
                oneLoss.add(player);
            }
        }

        System.out.println("0 Loss Players: " + zeroLoss);
        System.out.println("1 Loss Players: " + oneLoss);
    }
}

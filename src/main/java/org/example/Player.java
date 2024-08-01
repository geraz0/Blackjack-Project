package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private int balance = 100; // Initial balance
    private int bet = 5;       // Initial bet

    // Method to add a card to the player's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    // Method to get the current bet
    public int getBet() {
        return bet;
    }

    // Method to calculate the total value of the hand
    public int calculateHandValue() {
        int totalValue = 0;
        for (Card card : hand) {
            String rank = card.getRank();
            if ("Jack".equals(rank) || "Queen".equals(rank) || "King".equals(rank)) {
                totalValue += 10;
            } else if ("Ace".equals(rank)) {
                totalValue += 11; // Simplifying, normally you would handle Ace as 1 or 11
            } else {
                totalValue += Integer.parseInt(rank);
            }
        }
        return totalValue;
    }

    // Method to display the player's hand as a string
    public String displayHand() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card.toString()).append(" ");
        }
        return sb.toString();
    }

    // Method to get the player's balance
    public int getBalance() {
        return balance;
    }

    // Double down method
    public void doubleDown() {
        if (canDoubleDown()) {
            balance -= bet;
            bet *= 2;
        }
    }

    // Check if the player can double down
    public boolean canDoubleDown() {
        return balance >= bet * 2;
    }

    // Check if the player can split their hand
    public boolean canSplit() {
        return hand.size() == 2 && hand.get(0).getRank().equals(hand.get(1).getRank());
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck implements DeckActions {
    private List<Card> myCards = new ArrayList<>();
    private int numCards = 52; // Default for a standard deck

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                myCards.add(new Card(rank, suit));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(myCards);
    }

    @Override
    public Card dealNextCard() {
        return myCards.isEmpty() ? null : myCards.remove(0);
    }

    @Override
    public void printDeck(int numToPrint) {
        numToPrint = Math.min(numToPrint, myCards.size());
        for (int i = 0; i < numToPrint; i++) {
            System.out.println(myCards.get(i));
        }
    }
}


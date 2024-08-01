package org.example;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        // Start background music
        String filepath = "CasinoJazz.wav";
        PlayMusic music = new PlayMusic();
        music.playMusic(filepath);

        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        player.addCard(deck.dealNextCard());
        player.addCard(deck.dealNextCard());

        Scanner sc = new Scanner(System.in);
        boolean playerTurn = true;

        while (playerTurn) {
            System.out.println("Your hand: " + player.displayHand());
            System.out.println("Balance: $" + player.getBalance());
            System.out.println("Current Bet: $" + player.getBet());
            System.out.println("Choose action: 1 - Hit, 2 - Stand, 3 - Double Down, 4 - Split");

            int action = sc.nextInt();
            switch (action) {
                case 1: // Hit
                    player.addCard(deck.dealNextCard());
                    break;
                case 2: // Stand
                    playerTurn = false;
                    break;
                case 3: // Double Down
                    if (player.canDoubleDown()) {
                        player.doubleDown();
                        player.addCard(deck.dealNextCard());
                        playerTurn = false;
                    } else {
                        System.out.println("Not enough balance to double down.");
                    }
                    break;
                case 4: // Split
                    if (player.canSplit()) {
                        System.out.println("Splitting not implemented yet.");
                        // Implement splitting logic here
                    } else {
                        System.out.println("Cannot split these cards.");
                    }
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }

            // Check if player's balance is 0 or hand value exceeds 21
            if (player.getBalance() <= 0 || player.calculateHandValue() > 21) {
                playerTurn = false;
                System.out.println("Game over! Your final hand: " + player.displayHand());
                System.out.println("Final Balance: $" + player.getBalance());
            }
        }
        sc.close();
    }
}

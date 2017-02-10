/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;

/**
 *
 * @author ShadowX
 */
public class Game {
    static Card[] deck = new Card[52];
    static Random rand = new Random();
    static int currentCard = 0;
    
    public static void createDeck() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck[(i * j) - 1] = new Card(i, j);
            }
        }
    }
    
    public static void shuffleDeck() {
        for (int i = 0; i < deck.length; i++) {
            int randompos = rand.nextInt(52);
            Card temp = deck[i];
            deck[i] = deck[randompos];
            deck[randompos] = temp;
        }
    }
    
    public static Card nextCard() {
        currentCard++;
        if (currentCard > 51) {
            currentCard = 0;
        }
        return deck[currentCard];
    }
    
}

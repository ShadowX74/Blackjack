/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author ShadowX
 */
public class Card {
    int suit, number;
    
    public Card(int x, int y) {
        this.number = y;
        this.suit = x;
    }
}

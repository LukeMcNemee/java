/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author LukeMcNemee
 */
public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        
        //add all cards
        String name = "King";
        cards.add(new Card(1, "Clubs", name));
        cards.add(new Card(1, "Hearts", name));
        cards.add(new Card(1, "Spades", name));
        cards.add(new Card(1, "Diamonds", name));

        name = "Queen";
        cards.add(new Card(1, "Clubs", name));
        cards.add(new Card(1, "Hearts", name));
        cards.add(new Card(1, "Spades", name));
        cards.add(new Card(1, "Diamonds", name));

        name = "Jack";
        cards.add(new Card(1, "Clubs", name));
        cards.add(new Card(1, "Hearts", name));
        cards.add(new Card(1, "Spades", name));
        cards.add(new Card(1, "Diamonds", name));

        name = "Ace";
        cards.add(new Card(11, "Clubs", name));
        cards.add(new Card(11, "Hearts", name));
        cards.add(new Card(11, "Spades", name));
        cards.add(new Card(11, "Diamonds", name));

        for (int i = 7; i < 11; i++) {
            cards.add(new Card(i, "Clubs", String.valueOf(i)));
            cards.add(new Card(i, "Hearts", String.valueOf(i)));
            cards.add(new Card(i, "Spades", String.valueOf(i)));
            cards.add(new Card(i, "Diamonds", String.valueOf(i)));
        }
        
        //Shuffle deck
        Collections.shuffle(cards);
    }
    
    public Card dealCard(){
        return cards.remove(0);
    }

    @Override
    public String toString() {
        return "Deck{" + "cards= \n" + cards + "}\n";
    }
    
    

}

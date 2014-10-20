/*
 * The MIT License
 *
 * Copyright 2014 LukeMcNemee.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package card_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @brief Representation of deck of cards 
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
    
    /**
     * @brief removes card from deck and returns this card
     * @return dealed card from Deck
     */
    public Card dealCard(){
        return cards.remove(0);
    }

    /**
     * 
     * @return String representation of deck and all cards in deck
     */
    @Override
    public String toString() {
        return "Deck{" + "cards= \n" + cards + "}\n";
    }
    
    

}

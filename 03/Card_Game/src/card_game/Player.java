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

/**
 *
 * @author LukeMcNemee
 */
public class Player {
    String name;
    int numCards;
    int cardsValue;

    
    /*
        TODO: 
        Konstruktor, parametr pouze jméno, ostatní nastaví na nulu
        Getter pro parametry, GetCardsValue funguje speciálně pro dvě esa,
            tedy pokud je počet karet 2 a součet hodnot 22, tak vrátí -1, jinak
            vrací normální hodnotu
        Funkce receiveCard(Card card) zvýší počet karet numCards, zvýší hodnotu 
            cardsValue o hodnotu karty a vypíše info, že hráč obdržel kartu 
            včetně informací o kartě (stačí vypsat card a java automaticky použije 
            toString pro kartu)    
    
        Generovat lze téměř vše kromě receiveCard (hlavička této funkce tu ale již je)
        u ostatních je občas potřeba něco dopsat dovnitř
    */
    
    public Player(String name) {
        this.name = name;
        numCards = 0;
        cardsValue = 0;
    }
    
    public void receiveCard(Card card){
        numCards++;
        cardsValue += card.getValue();
        System.out.print("Player "+ name + " received " + card);
        System.out.println("new total value is " + getCardsValue() +"\n");
    }

    public String getName() {
        return name;
    }

    public int getNumCards() {
        return numCards;
    }

    public int getCardsValue() {
        if(numCards == 2 && cardsValue == 22){
            return -1;
        } else {
            return cardsValue;
        }
    }
    
    
    
}

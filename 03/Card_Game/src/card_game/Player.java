/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

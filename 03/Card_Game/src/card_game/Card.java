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
public class Card {
    private int value;
    private String color;
    private String name;

    public Card(int value, String color, String name) {
        this.value = value;
        this.color = color;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }    

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Card{ " + name +" of " + color + ", value is " + value +"}\n";
    }
    
    
}

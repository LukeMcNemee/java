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
public class Card {
    private int value;
    private String color;
    private String name;

    /*TODO: 
        Konstruktor, všechny parametry
        Getter pro všechny parametry
        toString vracející textový řetězec s informacemi o kartě
        např: Card{ Queen of Hearts, value is 1 }
        nebo: Card{ Ace of Clubs, value is 11 }  
    
        Všechny funkce lze generovat celé, nebo alespoň hlavičku a upravit vnitřek
    */
    
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

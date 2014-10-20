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

import java.util.Scanner;

/**
 *
 * @author LukeMcNemee
 */
public class Card_Game {

    /**
     * @brief reprezentation of card game, two players receive their cards, then 
     * are asked for optional another card, results are shown in the end.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        Deck myDeck = new Deck();
        Player player1 = new Player("John Doe");
        Player player2 = new Player("Tommy Atkins");

        player1.receiveCard(myDeck.dealCard());
        player2.receiveCard(myDeck.dealCard());

        player1.receiveCard(myDeck.dealCard());
        player2.receiveCard(myDeck.dealCard());

        boolean wantsNext = true;

        printDivider(30);

        /*
         TODO
         přidat podmínku, aby cyklus nezačal, pokud je hodnota karet 21 nebo -1,
         protože jakákoliv karta navíc znamená prohru
         (při splnění podmínky nastavit wantsNext na false, cyklus potom bude rovnou přeskočen)
         */
        if (player1.getCardsValue() == -1 || player1.getCardsValue() == 21) {
            System.out.println("Player 1, currently on: " + player1.getCardsValue());
            System.out.println("no additional cards");
            wantsNext = false;
        }

        while (wantsNext) {
            System.out.println("Player 1, currently on: " + player1.getCardsValue());
            System.out.println("Next Card? Enter Y/N");
            String response = scanner.next();
            switch (response) {
                case "Y":
                case "y":
                case "Yes":
                case "yes":
                case "YES":
                    System.out.println("selected yes");
                    player1.receiveCard(myDeck.dealCard());
                    wantsNext = true;
                    break;

                case "N":
                case "n":
                case "no":
                case "No":
                case "NO":
                    System.out.println("selected no");
                    wantsNext = false;
                    break;

                default:
                    System.out.println("wrong option");
                    break;
            }

            /*
             TODO
             přidat podmínku, aby cyklus skončil, pokud hodnota karet přesáhne 21
             (nastavit wants next na false, pokud je podmínka splněna)
             */
            if (player1.getCardsValue() >= 21) {
                System.out.println("Player 1, currently on: " + player1.getCardsValue());
                System.out.println("no additional cards");
                wantsNext = false;
            }

        }

        System.out.println("Player 2");
        wantsNext = true;

        /*
         TODO
         přidat podmínku, aby cyklus nezačal, pokud je hodnota karet 21 nebo -1,
         protože jakákoliv karta navíc znamená prohru
         (při splnění podmínky nastavit wantsNext na false, cyklus potom bude rovnou přeskočen)
         */
        if (player2.getCardsValue() == -1 || player2.getCardsValue() == 21) {
            System.out.println("Player 2, currently on: " + player2.getCardsValue());
            System.out.println("no additional cards");
            wantsNext = false;
        }

        while (wantsNext) {
            System.out.println("Player 2, currently on: " + player2.getCardsValue());
            System.out.println("Next Card? Enter Y/N");
            String response = scanner.next();

            switch (response) {
                case "Y":
                case "y":
                case "Yes":
                case "yes":
                case "YES":
                    System.out.println("selected yes");
                    player2.receiveCard(myDeck.dealCard());
                    wantsNext = true;
                    break;

                case "N":
                case "n":
                case "no":
                case "No":
                case "NO":
                    System.out.println("selected no");
                    wantsNext = false;
                    break;

                default:
                    System.out.println("wrong option");
                    break;
            }

            /*
             TODO
             přidat podmínku, aby cyklus skončil, pokud hodnota karet přesáhne 21
             (nastavit wants next na false, pokud je podmínka splněna)
             */
            if (player2.getCardsValue() >= 21) {
                System.out.println("Player 2, currently on: " + player2.getCardsValue());
                System.out.println("no additional cards");
                wantsNext = false;
            }

        }

        System.out.println("Results:");

        System.out.println("Player 1 value: " + player1.getCardsValue());
        System.out.println("Player 2 value: " + player2.getCardsValue());

        System.out.println("Player 1 cards: " + player1.getNumCards());
        System.out.println("Player 2 cards: " + player2.getNumCards());

        Player winner = null;
        if (player1.getCardsValue() == -1 && player2.getCardsValue() != -1) {
            winner = player1;
        } else if (player1.getCardsValue() != -1 && player2.getCardsValue() == -1) {
            winner = player2;
        } else if (player1.getCardsValue() <= 21 && player1.getCardsValue() > player2.getCardsValue()) {
            winner = player1;
        } else if (player2.getCardsValue() <= 21 && player2.getCardsValue() > player1.getCardsValue()) {
            winner = player2;
        } else if (player2.getCardsValue() > 21 && player1.getCardsValue() <= 21) {
            winner = player1;
        } else if (player1.getCardsValue() > 21 && player2.getCardsValue() <= 21) {
            winner = player2;
        } else if (player1.getCardsValue() == player2.getCardsValue()) {
            if (player1.getNumCards() > player2.getNumCards()) {
                winner = player2;
            } else if (player1.getNumCards() < player2.getNumCards()) {
                winner = player1;
            }
        }

        if (winner == null) {
            System.out.println("Draw");
        } else {
            System.out.println("Winner is: " + winner.getName());
        }

    }

    
    public static void printDivider(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

}

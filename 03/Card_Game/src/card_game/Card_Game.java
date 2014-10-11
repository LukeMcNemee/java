/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_game;

import java.util.Scanner;

/**
 *
 * @author LukeMcNemee
 */
public class Card_Game {

    /**
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
        while (wantsNext) {
            System.out.println("Player 1, currently on: " + player1.getCardsValue());
            System.out.println("Next Card? Enter Y/N");
            String op = scanner.next();            
            switch (op) {
                case "Y":
                case "y":
                    System.out.println("selected yes");
                    player1.receiveCard(myDeck.dealCard());
                    wantsNext = true;
                    break;

                case "N":
                case "n":
                    System.out.println("selected no");
                    wantsNext = false;
                    break;

                default:
                    System.out.println("wrong option");
                    break;
            }
        }
        
        System.out.println("Player 2");
        wantsNext = true;
        while (wantsNext) {
            System.out.println("Player 2, currently on: " + player2.getCardsValue());
            System.out.println("Next Card? Enter Y/N");
            String op = scanner.next();
            
            switch (op) {
                case "Y":
                case "y":
                    System.out.println("selected yes");
                    player2.receiveCard(myDeck.dealCard());
                    wantsNext = true;
                    break;

                case "N":
                case "n":
                    System.out.println("selected no");
                    wantsNext = false;
                    break;

                default:
                    System.out.println("wrong option");
                    break;
            }
        }
        
        System.out.println("Results:");
        
        System.out.println("Player 1: " + player1.getCardsValue());
        
        System.out.println("Player 2: " + player2.getCardsValue());
        
        System.out.println("Player 1: " + player1.getNumCards());
        System.out.println("Player 2: " + player2.getNumCards());
        
        Player winner = null;
        if(player1.getCardsValue() == -1 &&  player2.getCardsValue() != -1){
           winner = player1;
        } else if(player1.getCardsValue() != -1 &&  player2.getCardsValue() == -1){
           winner = player2;
        } else if(player1.getCardsValue() <= 21 &&  player1.getCardsValue() > player2.getCardsValue()){
           winner = player1;
        } else if(player2.getCardsValue() <= 21 &&  player2.getCardsValue() > player1.getCardsValue()){
           winner = player2;
        } else if(player2.getCardsValue() > 21 &&  player1.getCardsValue() <= 21){
           winner = player1;
        } else if(player1.getCardsValue() > 21 &&  player2.getCardsValue() <= 21){
           winner = player2;
        } else if(player1.getCardsValue() ==  player2.getCardsValue()){
            if(player1.getNumCards() > player2.getNumCards()){
                winner = player2;
            } else if(player1.getNumCards() < player2.getNumCards()){
                winner = player1;
            }
        }
        
        if(winner == null){
            System.out.println("Draw");
        } else {
            System.out.println("Winner is: " + winner.getName());
        }
        
        
    }

}

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
    
    
    
    public void receiveCard(Card card){
       
        
    }

    
    
    
    
}

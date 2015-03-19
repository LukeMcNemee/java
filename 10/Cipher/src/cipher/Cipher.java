/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LukeMcNemee
 */
public class Cipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Caesar myCaesar = new Caesar(3);
        
        String plainText = "áDobrý den,Chtěl bych se zeptat, jestli tu někdo neví, kde získat seznam českých slov a to ideálně i těch nespisovných. Pokoušel jsem se stáhnout něco jako slovník spisovného jazyka českého, ale bez úspěchu. Také mě napadlo procrawlit české weby. Budu rád za každý odkaz.";
        
        String cipherText = myCaesar.encode(plainText);
        
        System.out.println(myCaesar.decode(cipherText));
        
        //System.out.println(cipherText);
        return;
        /*
        CaesarBruteForce breaker;
        try {
            breaker = new CaesarBruteForce("slova2.txt");
            breaker.breakCaesar(cipherText);
        } catch (IOException ex) {
            System.err.println("error "+ ex.getMessage());
        }
        */
        
    }

    public static String unify(String text){
        
        return text;
    }
}

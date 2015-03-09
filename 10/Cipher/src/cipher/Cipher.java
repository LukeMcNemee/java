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
        
        String plainText = "Java is a programming language and computing platform first released by Sun Microsystems in 1995. There are lots of applications and websites that will not work unless you have Java installed, and more are created every day. Java is fast, secure, and reliable. From laptops to datacenters, game consoles to scientific supercomputers, cell phones to the Internet, Java is everywhere! ";
        
        String cipherText = myCaesar.encode(plainText);

        System.out.println(cipherText);
        
        CaesarBruteForce breaker;
        try {
            breaker = new CaesarBruteForce("words.txt");
            breaker.breakCaesar(cipherText);
        } catch (IOException ex) {
            System.err.println("error "+ ex.getMessage());
        }
        
        
    }

}

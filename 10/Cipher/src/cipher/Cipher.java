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
        String cipherText = myCaesar.encode("Java is a programming language and computing platform first released by Sun Microsystems in 1995. There are lots of applications and websites that will not work unless you have Java installed, and more are created every day. Java is fast, secure, and reliable. From laptops to datacenters, game consoles to scientific supercomputers, cell phones to the Internet, Java is everywhere! ");

        System.out.println(cipherText);
        String file = "words.txt";
        List<String> dict = new ArrayList<>();        
        
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                dict.add(line);
                wordCount++;
            }
        } catch (IOException ex){
            System.err.println("IO exception "+ ex.getMessage());
        }
        System.out.println(wordCount);
        
        for (int i = 0; i < 26; i++){
            Caesar caesar2 = new Caesar(i);
            String test = caesar2.decode(cipherText);
            String[] split = test.split(" ");
            int found = 0;
            for (String s : split){
                if(dict.contains(s)){
                    found++;
                    System.out.println(s);
                }
            } 
            System.out.println(test);
            System.out.println(found + " "+ split.length);
            if(found > split.length * 0.2){
                System.out.println(test);
                return;
            }
        }
        

    }

}

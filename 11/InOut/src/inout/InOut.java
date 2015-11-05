/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LukeMcNemee
 */
public class InOut {

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }
    }
    */
/*
    public static void main(String[] args) {

        //nacist parametry, ulozit nazvy souboru za parametrem -s
        List<String> soubory = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
            if (args[i].equals("-s")) {
                i++;
                System.out.println(args[i]);
                soubory.add(args[i]);
            }

        }

        //vypsat ulozene nazvy
        System.out.println(soubory);

        //otevrit a vypsat soubory
        for (String s : soubory) {
            try (BufferedReader br = 
                    new BufferedReader(new FileReader(s))) {

                String line = br.readLine();

                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
*/

    public static void main(String[] args) {

        //nacist parametry, ulozit nazvy souboru za parametrem -s
        String souborIn = new String();
        String souborOut = new String();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
            if (args[i].equals("-s")) {
                i++;
                
                souborIn = args[i];
            } else if (args[i].equals("-o")) {
                i++;
                
                souborOut = args[i];
            }

        }

        //otevrit a vypsat soubory
        try (BufferedReader br = 
                new BufferedReader(new FileReader(souborIn));
             BufferedWriter bw = 
                new BufferedWriter(new FileWriter(souborOut))) {

            String line = br.readLine();

            while (line != null) {
                
                bw.write(line + "\n");
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

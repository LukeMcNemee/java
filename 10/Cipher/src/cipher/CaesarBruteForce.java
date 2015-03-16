/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LukeMcNemee
 */
public class CaesarBruteForce {

    private String file;

    public CaesarBruteForce(String dict) throws IOException {
        this.file = dict;
        File f = new File(dict);
        if(!f.exists() && f.isDirectory()){
            throw new IOException("file does not exist " + dict);
        }
    }   
    
    public void breakCaesar(String cipherText) {

        
        List<String> dict = new ArrayList<>();

        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                dict.add(Cipher.unify(line));
                //wordCount++;
            }
        } catch (IOException ex) {
            System.err.println("IO exception " + ex.getMessage());
        }
        //System.out.println(wordCount);

        for (int i = 0; i < 26; i++) {
            Caesar caesar = new Caesar(i);
            String test = caesar.decode(cipherText);
            String[] rozdelenyText = test.split(" ");
            int found = 0;
            for (String s : rozdelenyText) {
                if (dict.contains(Cipher.unify(s)) && s.length() >= 3 ) {
                    found++;
                    System.out.println(s);
                }
            }
            //System.out.println(test);
            //System.out.println(found + " "+ rozdelenyText.length);
            if (found > rozdelenyText.length * 0.2) {
                System.out.println(found + " " + rozdelenyText.length);
                System.out.println(test);
                return;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author lukemcnemee
 */
public class ICAO {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("record.txt"));
        
        String line = br.readLine();
        line=line.substring(0,100000 );
        String[] split =  line.split(" ");
    
        for(String s: split){
            if(s.substring(1).contains("q")){
                
            }else{
                System.out.println(s);
            }
        }
    }
    
}

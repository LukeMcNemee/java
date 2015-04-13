/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LukeMcNemee
 */
public class Count {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new Integer(String.valueOf((int) (Math.random() * 50))));
        }

        countNumbers(list);
    }

    public static void countNumbers(List<Integer> list) {
        for (Integer i : list) {
            
        }
        
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            iter.next();
        }
        
    }

}

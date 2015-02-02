/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duplicates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author LukeMcNemee
 */
public class Duplicates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 100; i++){
            list.add(new Integer(String.valueOf((int) (Math.random() * 50))));
        }
        list = removeDuplicates(list);
        
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.size());
        
    }
    
    public static List<Integer> removeDuplicates(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            Integer o = list.get(i);
            if(!newList.contains(o)){
                newList.add(o);
            }
        }
        return newList;
    }
    
}

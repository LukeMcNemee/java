/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duplicates;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
            list.add(new Integer(String.valueOf(
                    (int) (Math.random() * 50 +1))));
        }
        
        for(Integer item : list){
            System.out.print(item + ", ");
        }
        
        System.out.println(" ");
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + ", ");
        }
        System.out.println(" ");
        
        System.out.println(multiplyList(list));
        list = findNonDuplicates(list);
        System.out.println(list);
        System.out.println(sumList(list));
        System.out.println(multiplyList(list));
        
        
        
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
    
    public static List<Integer> findNonDuplicates(List<Integer> list){
        List<Integer> unique = new ArrayList<>();
        List<Integer> duplicated = new ArrayList<>();
        
        for(Integer item : list){
            if(!(duplicated.contains(item))){
                if(!(unique.contains(item))){
                    unique.add(item);
                } else {
                    unique.remove(item);
                    duplicated.add(item);
                }
            }            
        }
        return unique;
    }
    
    public static int sumList(List<Integer> list){
        int sum = 0;
        Iterator<Integer> iter = list.iterator();
        
        while(iter.hasNext()){
            sum += iter.next();
        }
        
        return sum;
    }
    
    public static BigDecimal multiplyList(List<Integer> list){
        BigDecimal multiple = new BigDecimal(1);
        Iterator<Integer> iter = list.iterator();
        
        while(iter.hasNext()){
            multiple = multiple.multiply(new BigDecimal(iter.next()));
        }
        
        return multiple;
    }
}

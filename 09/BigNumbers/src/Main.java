
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LukeMcNemee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(1);
        BigDecimal c = new BigDecimal(5);
        
        c = a.multiply(b);
        System.out.println(c);
        
        a = a.add(a);        
        System.out.println(a);
        
        b = b.subtract(new BigDecimal(3));
        System.out.println(fact(1000).toString().length());
        //System.out.println((fact(1000).compareTo(power(876))));
        //System.out.println((factOdd(211).compareTo(factEven(211))));
        //System.out.println(factOdd(10));
        //System.out.println(factEven(10));
    }  
    
    static BigDecimal fact(int x){
        BigDecimal result = new BigDecimal(1);
        for(int i = 1; i <= x; i++){
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }
    
    static BigDecimal factOdd(int x){
        BigDecimal result = new BigDecimal(1);
        for(int i = 1; i <= x; i+=2){
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }
    
    static BigDecimal factEven(int x){
        BigDecimal result = new BigDecimal(1);
        for(int i = 2; i <= x; i+=2){
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }
    
    static BigDecimal power(int x){
        BigDecimal result = new BigDecimal(1);
        for(int i = 1; i <= x; i++){
            result = result.multiply(new BigDecimal(x));
        }
        return result; 
        
    }
    
}

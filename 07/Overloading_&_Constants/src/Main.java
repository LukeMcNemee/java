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
        // TODO code application logic here
        
        rectangle2(11);
        
        System.out.println("");
        
        hourGlass(11);
        
        
        
        
        
    }

    public static void hourGlass(int x){
        for(int i = 0; i < x/2; i++){
            for(int j = 0; j < x; j++){
                if(j >= i && j <= x - i - 1){
                     System.out.print("#");
                } else {
                     System.out.print(" ");
                }
            }
            System.out.println("");
        }
        for(int i = x/2; i < x; i++){
            for(int j = 0; j < x; j++){
                if(j <= i && j >= x - i - 1){
                     System.out.print("#");
                } else {
                     System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
    
    public static void rectangle2(int x){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if(i == 0 || j == 0 || i == x-1 || j == x-1 || j == i || j == x - i - 1){
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void rectangle(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("#");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    /* //
     public static int rectangle(int x){
     return 0;
     }
     */
    public static void rectangle(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("#");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void circle(int r) {
        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {
                double distance = Math.sqrt(Math.pow(j, 2) + Math.pow(i, 2));
                if (distance >= r - 0.5 && distance <= r + 0.5) {
                    System.out.print("\u2588");
                } else {
                    System.out.print("\u2006");
                }
            }
            System.out.println("");
        }
        System.out.println("");

    }

}

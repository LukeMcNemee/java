
import java.util.Random;
import java.util.Scanner;

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

    static final int SCREEN_MAX = 80;
    
    /**
     * @param args the command line arguments
     */   
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        
        
        snow();
        
    }
    
    
    public static void snow() throws InterruptedException{
        for (;;){
            for(int i = 0; i < SCREEN_MAX; i++){
                if(Math.random() > 0.95){
                    System.out.print("\u2744");
                }else {
                    System.out.print(" ");
                }                
            }
            System.out.println("");
            Thread.sleep(100);
        }
    }
    
    public static void matrix() throws InterruptedException{
        Boolean[] screen = new Boolean[SCREEN_MAX];
        for(int i = 0; i < SCREEN_MAX; i++){
            screen[i] = false;
        }
        for (;;){
            for(int i = 0; i < SCREEN_MAX; i++){
                double rand = Math.random();
                if((rand > 0.70 && screen[i] == true) || (rand > 0.95 && screen[i] == false)){
                    screen[i] = !screen[i];
                }
                
                if(screen[i] == true){
                    Random chr = new Random();
                    System.out.print((char)(chr.nextInt(500)+'a'));
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
            Thread.sleep(90);
        }
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
                if(j >= x-i){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
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

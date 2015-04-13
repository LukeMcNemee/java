/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LukeMcNemee
 */
class main {

    public static void main(String[] args) {
        //vytvořím instanci objektu mince
        mince mojeMince = new mince();
        //zavolám funkci hození mincí
        mojeMince.hodMinci();
    }
}

public class mince {

    //tyhle věci jsou ve třídě, nikoliv pouze v konstruktoru
    //a měly by být private
    private Scanner rozhodnuti = new Scanner(System.in);

    private double konto;

    //konstruktor, pouze nastaví počáteční hodnoty
    public mince() {
        //hlavni hoObject = new hlavni();
        konto = 50;
        System.out.println("nastaveno na " + konto);
    }

    //funkce která provádí hod, tuto funkci voláme znovu a znovu tak, aby se mohlo házet opakovaně
    public void hodMinci() {
        //promene, které se mění s každým spuštěním, není potřeba dlouhoddobě ukládat 
        //jejich stav, tedy nemusí být všeobecně ve třídě
        int hodnota;
        int panaorel;
        int sazka;

        //vypsat aktuální stav
        System.out.println("Aktualni stav konta je : " + konto);

        //ověřit, že hráč může dál hrát
        if (konto <= 0) {
            //prohrál, tedy končíme
            System.out.println("prohral jsi");
            return;
        }
        System.out.println("Prejete si hodit minci ? \n 1 : ANO \n 2 : NE");

        int p = rozhodnuti.nextInt();

        //pokud chce končít, tak skončím rovnou
        if (p == 2) {
            return;
        }
        if (p == 1) {
            Random mince = new Random();

            //původně bylo tohle:            
            //hodnota = mince.nextInt(2);
            //funkce ti vrátí čísla 0, nebo 1, tedy mince nebude fungovat, je 
            //potřeba přičíst 1 nebo upravit podmíky tak, aby byl správný rozsah            
            hodnota = mince.nextInt(2) + 1;

            System.out.println("1 : PANA \n2 : OREL");
            panaorel = rozhodnuti.nextInt();
            System.out.println("Kolik si prejete vsadit ? (max." + konto + ")");
            sazka = rozhodnuti.nextInt();
            if (sazka <= konto) {
                if (hodnota == 1 && panaorel == 1) {
                    konto = konto + sazka;
                    System.out.println("Padla pana, vyhral jste");
                } else if (hodnota == 2 && panaorel == 2) {
                    System.out.println("Padl orel, vyhral jste");
                    konto = konto + sazka;
                } else if (hodnota == 1 && panaorel == 2) {
                    System.out.println("Padla pana, prohral jste");
                    konto = konto - sazka;
                } else if (hodnota == 2 && panaorel == 1) {
                    System.out.println("Padl orel, prohral jste");
                    konto = konto - sazka;
                }
            } else {                
                System.out.println("Maximalni moznost sazky je : " + konto);

            }
        }
        //zavolám funkci znovu
        hodMinci();
    }
}

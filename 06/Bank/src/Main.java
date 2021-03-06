/*
 * The MIT License
 *
 * Copyright 2014 LukeMcNemee.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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

        Account a1 = new Account(500);
        SporUcet sa1 = new SporUcet(1.2, 500);
        //PremiumSavingAccount psa1 = new PremiumSavingAccount(1.2, 500);

        System.out.println("balance " + a1.getBalance());
        System.out.println("balance " + sa1.getBalance());
        //System.out.println("balance " + psa1.getBalance());
        
        sa1.dalsiMesic();
        
        System.out.println("balance " + a1.getBalance());
        System.out.println("balance " + sa1.getBalance());

        //for (int i = 1; i <= 15; i++) {
            //System.out.println("###########################################");
            //System.out.println("month " + i + ": ");
/*
            sa1.addMonthInterest();
            psa1.addMonthInterest();
            System.out.println("balance " + a1.getBalance());
            System.out.println("balance " + sa1.getBalance());
            System.out.println("balance " + psa1.getBalance());
        */
        }

    }

}

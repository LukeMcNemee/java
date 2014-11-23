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
public class PremiumSavingAccount extends SavingAccount{

    private int premiumPeriod;
    
    public PremiumSavingAccount(double interest, double amount) {
        super(interest, amount);
        System.out.println("premium created");
    }

    public PremiumSavingAccount(double interest) {
        super(interest);
    }

    public double withdraw(double amount){
        
        if(balance >= amount){
            premiumPeriod = 0;
            balance -= amount;
            return amount;
        } else {        
            return 0.0;
        }
    }
    
    public void addMonthInterest(){
        balance *= interest;
        premiumPeriod++;
        if(premiumPeriod == 6){
            balance += 100;
            premiumPeriod = 0;
        }
        
    }    
    
}

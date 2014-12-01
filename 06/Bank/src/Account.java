

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
 * @brief class represents simple account, which allows deposits and withdrawals
 * with some basic checking for limits etc.
 * @author LukeMcNemee
 */
public class Account {

    protected double balance;

    /**
     * @brief creates account
     * @param ammount to be deposited in account
     */
    public Account(double ammount) {
        this.balance = ammount;
        //System.out.println("account created");
    }

    /**
     * @brief creates account with zero deposit
     */
    public Account() {
        balance = 0.0;
    }

    /**
     * 
     * @return actual balance on account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @brief adds to account
     * @param amount to be added
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * @brief withdraws amount from account, checks for avaiable amount
     * @param amount to be withdrawed
     * @return withdrawed amount or zero
     */
    public double withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return amount;
        } else {
            return 0.0;
        }
    }

}

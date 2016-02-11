
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lukemcnemee
 */
public class MathModule {

    private double first;
    private double second;
    private Operation operation;

    private double memory;
    
    private boolean dot;
    private int digits;

    public void setNumber(double number){
        if (operation == null) {
            first = number;
        } else {
            second = number;
        }
    }
    
    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public void clear() {
        first = 0;
        second = 0;
        operation = null;
        dot = false;
        digits = 1;
        
    }

    public MathModule() {
        first = 0;
        second = 0;
        operation = null;
        dot = false;
        digits = 1;
        memory = 0;
    }

    public void dot() {

        dot = true;

    }

    public void addDigit(int digit) {
        if (operation == null) {
            addFirstDigit(digit);
        } else {
            addSecondDigit(digit);
        }
    }

    private void addFirstDigit(int digit) {
        if (dot) {
            this.first = this.first + (digit / Math.pow(10, digits));
            digits++;
        } else {
            this.first = this.first * 10 + digit;
        }
    }

    private void addSecondDigit(int digit) {
        if (dot) {
            this.second = this.second + (digit / Math.pow(10, digits));
            digits++;
        } else {
            this.second = this.second * 10 + digit;
        }
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        dot = false;
    }

    public String getDisplay() {
        if (operation == null) {
            String f = String.valueOf(first);
            return f.substring(0, f.indexOf(".")+digits);
        } else {
            String s = String.valueOf(second);
            return s.substring(0, s.indexOf(".")+digits);            
        }
    }

    public String getResult() {
        switch (operation) {
            case PLUS:
                return String.valueOf(first + second);
            case MINUS:
                return String.valueOf(first - second);
            case TIMES:
                return String.valueOf(first * second);
            case DIVIDE:
                if (second == 0) {
                    JOptionPane.showMessageDialog(null, "Division by zero.",
                            "Division error", JOptionPane.ERROR_MESSAGE);
                    return getDisplay();
                } else {
                    return String.valueOf(first / second);
                }

            default:
                return getDisplay();
        }
    }

}

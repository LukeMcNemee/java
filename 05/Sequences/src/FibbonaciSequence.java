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
 * @brief fibbonaci sequence
 * @author LukeMcNemee
 */
public class FibbonaciSequence implements Sequence{

    @Override
    public int getNumberOnPosition(int pos) {
        if(pos == 1 || pos == 2){
            return 1;
        } else {
            return getNumberOnPosition(pos - 1) + getNumberOnPosition(pos - 2);
        }
    
    }

    @Override
    public void printFirstN(int n) {
        int first = 1;
        int second = 1;
        for(int i = 0; i < n; i++){
            if( i == 0){
                System.out.print(first + " ");
            }
            if(i == 1){
                System.out.print(second + " ");
            }
            if(i > 1){
                System.out.print(first + second + " ");
                second = first + second;
                first = second - first;
            }
            
        }
        System.err.println("");
    }
    
}

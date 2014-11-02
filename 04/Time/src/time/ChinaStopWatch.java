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

package time;

/**
 * @brief China version of stopwatch, multiplies time by random coefitient in range 0.5 - 1.5
 * @author LukeMcNemee
 */
public class ChinaStopWatch implements StopWatch{

    private long startTime;
    private long endTime;
    private double coefitient;

    public ChinaStopWatch() {
        startTime = 0;
        endTime = 0;
        coefitient = Math.random() + 0.5;        
    }
    
    @Override
    public void startStopWatch() {
        startTime = System.nanoTime();
    }

    @Override
    public void stopStopWatch() {
        endTime = System.nanoTime();
    }

    @Override
    public void resetStopWatch() {
        startTime = 0;
        endTime = 0;
    }

    @Override
    public long getTimeDifference() {
        if (startTime == 0 || endTime == 0) {
            return 0;
        }
        return (long)((endTime - startTime) * coefitient);
    }  

    
}

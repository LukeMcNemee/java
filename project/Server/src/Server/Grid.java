/*
 * The MIT License
 *
 * Copyright 2015 LukeMcNemee.
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
package Server;

/**
 *
 * @author LukeMcNemee
 */
public class Grid {

    /**
     * Grid size
     */
    private int size;
    private char[][] gameGrid;
    private char color;

    public Grid(int size) {
        this.size = size;
        gameGrid = new char[10][10];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameGrid[i][j] = '_';
            }
        }
        color = '_';
    }
    
    public void startGame(){
        color = 'X';
    }

    public char getColor() {
        return color;
    }

    public int play(int x, int y,char myColor) {
        if(myColor != color){
            System.err.println("Wrong color");
            return -1;
        }
        if (x >= size || y >= size || x < 0 || y < 0) {
            System.err.println("Wrong coordinates, out of grid");
            return -2;
        }
        if (gameGrid[x][y] != '_') {
            System.err.println("Wrong coordinates, already played");
            return -3;
        }
        gameGrid[x][y] = color;
        if(color == 'X'){
            color = 'O';
        } else {
            color = 'X';
        }
        return 0;
    }

    public char[][] getGameGrid() {
        return gameGrid.clone();
    }
    
    public char getGrid(int x, int y){
         if (x >= size || y >= size || x < 0 || y < 0) {
            System.err.println("Wrong coordinates, out of grid");
            return '0';
        }
        return gameGrid[x][y];
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(size + "\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                builder.append(gameGrid[j][i]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }  
    

}

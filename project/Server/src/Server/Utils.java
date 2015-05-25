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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LukeMcNemee
 */
public class Utils {
    
    public static String evaluate(Grid g, char color){
        if (getPlaces(g, '_').isEmpty()) return "WIN";
        if (hasWon(g, color)) return "WIN";
        if (hasWon(g, getRevertedColor(color))) return "DEFEAT";
        return "ABCD";
    }
    
    private static List<Point> getPlaces(Grid g, char player) {
        List<Point> availablePoints = new ArrayList<>();
        char[][] field = g.getGameGrid();
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[x][y] == player) {
                    availablePoints.add(new Point(x, y));
                }
            }
        }
        return availablePoints;
    }
    
    private static boolean hasWon(Grid g, char player) {
        int winLength = g.getWinLength();
        char[][] board = g.getGameGrid();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == player) {
                    if (getLineLength(new Point(x, y), board, 1, 0, player) >= winLength || getLineLength(new Point(x, y), board, 0, 1, player) >= winLength
                            || getLineLength(new Point(x, y), board, 1, 1, player) >= winLength || getLineLength(new Point(x, y), board, -1, 1, player) >= winLength) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int getLineLength(Point startPosition, char[][] board, int xm, int ym, char player) {
        return getLineLen(startPosition, board, xm, ym, player) + getLineLen(startPosition, board, -xm, -ym, player) + 1;
    }

    private static int getLineLen(Point startPosition, char[][] board, int xm, int ym, char player) {
        int x = startPosition.getX() + xm, y = startPosition.getY() + ym, len = 0;
        while (x >= 0 && y >= 0 && x < board.length && y < board[x].length) {
            if (board[x][y] == player) {
                len++;
            } else {
                break;
            }
            x += xm;
            y += ym;
        }
        return len;
    }
    
    private static char getRevertedColor(char color) {
        switch (color) {
            case 'X':
                return 'O';
            case 'O':
                return 'X';
            default:
                return '_';
        }
    }
}

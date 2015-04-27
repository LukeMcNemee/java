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

import java.io.*;
import java.net.*;

/**
 *
 * @author LukeMcNemee
 */
public class Main {

    private static int port = 13248, maxConnections = 2;

    /**
     * @param args the command line arguments
     */
    // Listen for incoming connections and handle them
    public static void main(String[] args) {
        ServerSocket listener;
        try {
            listener = new ServerSocket(port);
        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            return;
            //ioe.printStackTrace();
        }
        while (true) {
            int i = 0;
            Grid g;
            if (args.length > 1) {
                try {
                    g = new Grid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    g = new Grid(10, 5);
                }
            } else {
                g = new Grid(10, 5);
            }
            String grid = g.toString();
            final Object gridLock = new Object();
            System.out.println(grid);

            try {
                Socket server;

                while ((i++ < maxConnections) || (maxConnections == 0)) {
                    //ServerThread(connection);

                    server = listener.accept();
                    ServerThread conn_c = null;
                    if (i == 1) {
                        conn_c = new ServerThread(server, g, 'X', gridLock);
                    } else {
                        conn_c = new ServerThread(server, g, 'O', gridLock);
                    }
                    Thread t = new Thread(conn_c);
                    t.start();
                }
                synchronized (gridLock) {
                    System.out.println("[DEBUG] two clients connected, game starts");
                    g.startGame();
                }

            } catch (IOException ioe) {
                System.out.println("IOException on socket listen: " + ioe);
                //ioe.printStackTrace();
            }
        }
    }

}

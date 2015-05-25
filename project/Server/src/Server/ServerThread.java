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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author LukeMcNemee
 */
public class ServerThread implements Runnable {

    private final Socket connectionSocket;
    private String line, input;
    private final Grid g;
    private final char color;
    private final Object lock;

    ServerThread(Socket connectionSocket, Grid g, char color, Object lock) {
        this.connectionSocket = connectionSocket;
        this.g = g;
        this.color = color;
        this.lock = lock;
    }

    @Override
    public void run() {

        input = "";

        try {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            PrintStream out = new PrintStream(connectionSocket.getOutputStream());
            while (connectionSocket.isConnected()) {
                String received = inFromClient.readLine();

                if (received == null) {
                    continue;
                }
                String[] split = received.split(" ");
                System.out.println("[DEBUG] received: " + received + " from " + color);
                System.out.println("split[0]:" + split[0]);
                String output;
                switch (split[0]) {
                    case "STATUS":
                        synchronized (lock) {
                            String utils = Utils.evaluate(g, color);
                            System.out.println(utils);
                            switch (utils) {
                                case "WIN":
                                    outToClient.writeBytes("WIN" + "\n");
                                    break;
                                case "DEFEAT":
                                    outToClient.writeBytes("DEFEAT" + "\n");
                                    break;
                                default:
                                    if (g.getColor() == color) {
                                        outToClient.writeBytes("PLAY" + "\n");
                                    } else {
                                        outToClient.writeBytes("WAIT" + "\n");
                                    }
                            }
                        }
                        break;
                    case "SIZE":
                        outToClient.writeBytes(g.getSize() + "\n");
                        break;
                    case "COLOR":
                        outToClient.writeBytes(color + "\n");
                        break;
                    case "GRID":
                        synchronized (lock) {
                            output = Character.toString(g.getGrid(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                        }
                        outToClient.writeBytes(output + "\n");
                        break;
                    case "PLAY":
                        synchronized (lock) {
                            output = Integer.toString(g.play(Integer.parseInt(split[1]), Integer.parseInt(split[2]), color));
                        }
                        outToClient.writeBytes(output + "\n");
                        break;
                    case "FULLGRID":
                        synchronized (lock) {
                            output = g.getGameGridAsString();
                        }
                        outToClient.writeBytes(output + "\n");
                        break;
                    case "WINLENGTH":
                        synchronized (lock) {
                            output = Integer.toString(g.getWinLength());
                        }
                        outToClient.writeBytes(output + "\n");
                        break;
                    default:
                        outToClient.writeBytes("ERROR, command not known" + "\n");
                        System.out.println("[ERROR] received: " + received);
                        break;
                }
                System.out.println(g.toString());
            }
            connectionSocket.close();
        } catch (IOException ioe) {
            System.out.println("Connection terminated; IOException on socket listen: " + ioe);

        }
    }
}

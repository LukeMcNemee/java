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

    private Socket connectionSocket;
    private String line, input;
    private Grid g;

    ServerThread(Socket connectionSocket, Grid g) {
        this.connectionSocket = connectionSocket;
        this.g = g;
    }

    @Override
    public void run() {

        input = "";

        try {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            PrintStream out = new PrintStream(connectionSocket.getOutputStream());
            while (connectionSocket.isConnected()) {
                System.out.println(inFromClient.readLine());
                outToClient.writeBytes("DEFEAT\n");
                // Now write to the client
                //System.out.println("Overall message is:" + input);
                //out.println("Overall message is:" + input);

            }
            connectionSocket.close();
        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            //ioe.printStackTrace();
            
        }
    }
}

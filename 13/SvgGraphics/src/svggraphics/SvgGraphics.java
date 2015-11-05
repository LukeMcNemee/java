/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svggraphics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author LukeMcNemee
 */
public class SvgGraphics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Canvas canvas = new Canvas();
        canvas.addGraphics(new RecursiveRectangle(10, 10, 500,500, "black", "white", 3, 7));
        

        BufferedWriter bw = new BufferedWriter(new FileWriter("test.svg"));

        canvas.toSvg(bw);

        bw.flush();
        bw.close();
    }

}

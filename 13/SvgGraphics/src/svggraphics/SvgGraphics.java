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
        canvas.addGraphics(new Rectangle(10,10,100,100,"yellow","blue",4));
        canvas.addGraphics(new Rectangle(150,10,100,100,"yellow","blue",4));
        canvas.addGraphics(new Rectangle(10,150,100,100,"yellow","blue",4));
        canvas.addGraphics(new Circle(50, 50, 30, "white", "red", 5));
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("test.svg"));
        
        bw.write(canvas.toSvg());
    
        bw.flush();
        bw.close();
    }
    
}

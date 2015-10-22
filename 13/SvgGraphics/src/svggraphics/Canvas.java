/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svggraphics;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LukeMcNemee
 */
public class Canvas {

    private List<GraphicsObject> graphics;

    public Canvas() {
        graphics = new ArrayList<>();
    }

    public void addGraphics(GraphicsObject g) {
        graphics.add(g);
    }

    public void toSvg(BufferedWriter bw) throws IOException {

        bw.append("<svg xmlns=\"http://www.w3.org/2000/svg\">\n");
        for (GraphicsObject g : graphics) {
            g.toSvg(bw);
        }
        bw.append("</svg>\n");
    }
}

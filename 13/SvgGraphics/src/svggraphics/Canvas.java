/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svggraphics;

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
    
    public void addGraphics(GraphicsObject graphic){
        graphics.add(graphic);
    }
    
    
    
    public String toSvg(){
        StringBuilder builder = new StringBuilder();
        builder.append("<svg xmlns=\"http://www.w3.org/2000/svg\">\n");
        for(GraphicsObject g: graphics){
            builder.append(g.toSvg());
        }
        builder.append("</svg>\n");
        return builder.toString();
    }   
    
}

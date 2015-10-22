/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svggraphics;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author LukeMcNemee
 */
public class Rectangle implements GraphicsObject{

    private float x;
    private float y;
    private float width;
    private float height;    
    private String fill;
    private String stroke;
    private float strokeWidth;

    public Rectangle(float x, float y, float width, float height, String fill, String stroke, float strokeWidth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = fill;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }
    
    
    
    
    @Override
    public void toSvg(BufferedWriter bw) throws IOException { 
        bw.append("<rect x=\""+ x +"\" y=\""+y+"\" height=\""+height+"\" width=\""+width+"\" stroke=\"" +stroke+ "\" stroke-width=\""+ strokeWidth+"\" fill=\""+ fill+"\"/>\n");
    }
    
}

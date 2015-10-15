/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svggraphics;

/**
 *
 * @author LukeMcNemee
 */
public class Rectangle implements GraphicsObject{

    private int x;
    private int y;
    private int width;
    private int height;    
    private String fill;
    private String stroke;
    private int strokeWidth;

    public Rectangle(int x, int y, int width, int height, String fill, String stroke, int strokeWidth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = fill;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }
    
    
    @Override
    public String toSvg() {
        
        return "<rect x=\""+ x +"\" y=\""+y+"\" height=\""+height+"\" width=\""+width+"\" stroke=\"" +stroke+ "\" stroke-width=\""+ strokeWidth+"\" fill=\""+ fill+"\"/>\n";
    }
    
}

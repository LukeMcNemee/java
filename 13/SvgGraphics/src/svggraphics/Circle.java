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
public class Circle implements GraphicsObject{

    private int cx;
    private int cy;
    private int r;    
    private String fill;
    private String stroke;
    private int strokeWidth;

    public Circle(int cx, int cy, int r, String fill, String stroke, int strokeWidth) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
        this.fill = fill;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
    }
    
    
    @Override
    public String toSvg() {
        return "<circle cx=\""+ cx +"\" cy=\""+cy+"\" r=\""+r+"\" stroke=\"" +stroke+ "\" stroke-width=\""+ strokeWidth+"\" fill=\""+ fill+"\"/>\n";
    }
    
}

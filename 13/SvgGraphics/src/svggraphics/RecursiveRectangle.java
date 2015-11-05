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
 * @author lukemcnemee
 */
public class RecursiveRectangle implements GraphicsObject {

    private float x;
    private float y;
    private float width;
    private float height;
    private String fill;
    private String stroke;
    private float strokeWidth;

    private List<GraphicsObject> rectangles;

    public RecursiveRectangle(float x, float y, float width, float height, String fill, String stroke, float strokeWidth, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fill = fill;
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;

        rectangles = new ArrayList<>();
        if (depth != 0) {
            rectangles.add(new RecursiveRectangle(x, y, width / 3, height / 3, fill, stroke, strokeWidth / 3, depth - 1));
            rectangles.add(new RecursiveRectangle(x +  width / 3, y, width / 3, height / 3, fill, stroke, strokeWidth / 3, depth - 1));
            rectangles.add(new RecursiveRectangle(x + 2*(width / 3), y, width / 3, height / 3, fill, stroke, strokeWidth / 3, depth - 1));
            
            rectangles.add(new RecursiveRectangle(x, y + height / 3, width / 3, height / 3, fill, stroke, strokeWidth / 3, depth - 1));
            rectangles.add(new Rectangle(x +  width / 3, y + height / 3, width / 3, height / 3, stroke,fill, strokeWidth / 3));
            rectangles.add(new RecursiveRectangle(x + 2*(width / 3), y + height / 3, width / 3, height / 3, fill, stroke, strokeWidth / 3, depth - 1));
            
            rectangles.add(new RecursiveRectangle(x, y + 2*(height / 3), width / 3, height / 3, fill, stroke, strokeWidth / 3, depth - 1));
            rectangles.add(new RecursiveRectangle(x +  width / 3, y+ 2*(height / 3), width / 3, height / 3, fill, stroke, strokeWidth / 3, depth - 1));
            rectangles.add(new RecursiveRectangle(x + 2*(width / 3), y+ 2*(height / 3), width / 3, height / 3, fill, stroke, strokeWidth / 3, depth - 1));
        }

    }

    @Override
    public void toSvg(BufferedWriter bw) throws IOException {
        bw.append("<rect x=\"" + x + "\" y=\"" + y + "\" height=\"" + height + "\" width=\"" + width + "\" stroke=\"" + stroke + "\" stroke-width=\"" + strokeWidth + "\" fill=\"" + fill + "\"/>\n");
        for (GraphicsObject r : rectangles) {
            r.toSvg(bw);
        }
    }
}

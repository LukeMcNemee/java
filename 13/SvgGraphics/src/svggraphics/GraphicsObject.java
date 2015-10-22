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
public interface GraphicsObject {
    
    public void toSvg(BufferedWriter bw) throws IOException;
    
}

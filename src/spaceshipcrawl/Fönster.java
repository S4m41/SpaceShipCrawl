package spaceshipcrawl;

import java.applet.*;
import java.awt.*;

/**
 *
 * @author petmeu239
 */
public class Fönster extends Applet implements Runnable {
    int width=16*32, height=16*32;
        @Override
        public void init(){
            this.setSize(width,height);
        }
        @Override
        public void paint(Graphics g){
            
        }
        public void update(){
            
        }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
                
    
    
}

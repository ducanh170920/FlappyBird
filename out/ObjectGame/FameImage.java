package ObjectGame;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class FameImage {
   BufferedImage image;
   private double rotation;

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public FameImage(BufferedImage image){
       this.image = image;

   }

    public void draw(Graphics2D g2,int x , int y , double rotation){
       AffineTransform backup = g2.getTransform();
       AffineTransform a = AffineTransform.getRotateInstance(rotation,x + image.getWidth()/2 , y+ image.getHeight()/2);
       g2.setTransform(a);
       g2.drawImage(image,x,y,null);
        g2.setTransform(backup);
    }
}

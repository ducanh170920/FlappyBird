package ObjectGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Object{
    private  float x ;
    private  float y ;
    BufferedImage image;

    public Object(float x, float y, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public abstract void Update();
    public abstract void Draw(Graphics2D g2);
}

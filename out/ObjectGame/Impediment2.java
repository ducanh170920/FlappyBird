package ObjectGame;

import SCREEN.GameFrame;
import SCREEN.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Impediment2 extends Object {
    public Rectangle rectangle;
    public Impediment2(float x, float y, BufferedImage image) {
        super(x, y, image);
        try {
            setImage(ImageIO.read(new File("asset/chimney.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        rectangle = new Rectangle((int)getX(),(int)getY(),74,400);
    }

    @Override
    public void Update() {
        setX((float) (getX()- GamePanel.speed));
        rectangle.setBounds((int)getX(),(int)getY(),74,400);
    }

    @Override
    public void Draw(Graphics2D g2) {
        g2.drawImage(getImage(),(int)getX(), (int)getY(),null);
    }
}

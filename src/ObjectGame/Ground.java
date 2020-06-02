package ObjectGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ground extends Object {
    BufferedImage image1 ;
    BufferedImage image2 ;
    public Ground(float x, float y, BufferedImage image) {
        super(x, y, image);
        try {
            image1 = ImageIO.read(new File("asset/ground.png"));
            image2 = ImageIO.read(new File("asset/ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Update() {
        setX((float) (getX() - 0.5));
    }

    @Override
    public void Draw(Graphics2D g2) {
        g2.drawImage(image1,0,(int)getY(),null);
    }
}

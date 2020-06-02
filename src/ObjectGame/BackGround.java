package ObjectGame;

import SCREEN.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGround  extends  Object{
    private BufferedImage image1 ;
    private double x1;
    public BackGround(int x , int y , BufferedImage bufferedImage){
        super(x,y,bufferedImage);
        x1 = x+1150;
        try {
            setImage(ImageIO.read(new File("asset/background.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image1 = getImage();
    }

    @Override
    public void Update() {
        setX((float) (getX()- GamePanel.speed));
        x1 -=GamePanel.speed;
    }

    @Override
    public void Draw(Graphics2D g2) {
        if((int)getX() == -1150)
            setX(1150);
        else if((int)x1 == -1150)
            x1=1150;
        g2.drawImage(image,(int)getX() , (int)getY(),null);
        g2.drawImage(image1,(int)(x1),(int)getY(),null);
    }
}

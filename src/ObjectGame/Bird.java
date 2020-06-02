package ObjectGame;

import SCREEN.GameWorld;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends Object{
    public Rectangle rectangle;
    private Boolean isRunning;
    private double speedY = 0;
    private float mass;
    BufferedImage image;
    Animation bird1;
    FameImage fameImage1;
    FameImage fameImage2;
    FameImage fameImage3;

    public Bird(int x, int y, BufferedImage image,float mass) {
        super(x, y, image);
        this.mass = mass;
        bird1 = new Animation();
        isRunning = true;
        try {
            image = ImageIO.read(new File("asset/bird_sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fameImage1 = new FameImage(image.getSubimage(0,0,60,60));
        fameImage2 = new FameImage(image.getSubimage(60,0,60,60));
        fameImage3 = new FameImage(image.getSubimage(120,0,60,60));
        bird1.add(fameImage1,70);
        bird1.add(fameImage2,70);
        bird1.add(fameImage3,100);

        rectangle = new Rectangle((int)getX(),(int)getY(),60,60);
    }

    public Boolean getRunning() {
        return isRunning;
    }

    public void setRunning(Boolean running) {
        isRunning = running;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Animation getBird() {
        return bird1;
    }

    public void setBird(Animation bird) {
        this.bird1 = bird;
    }

    public FameImage getFameImage1() {
        return fameImage1;
    }

    public void setFameImage1(FameImage fameImage1) {
        this.fameImage1 = fameImage1;
    }

    public FameImage getFameImage2() {
        return fameImage2;
    }

    public void setFameImage2(FameImage fameImage2) {
        this.fameImage2 = fameImage2;
    }

    public FameImage getFameImage3() {
        return fameImage3;
    }

    public void setFameImage3(FameImage fameImage3) {
        this.fameImage3 = fameImage3;
    }

    @Override
    public void Update() {
        speedY+=mass;
        rectangle.setBounds((int)getX(),(int)getY(),60,60);
        setY((float) (getY()+speedY));
        if(speedY > 0)
            bird1.setRotation(0);
        else
            bird1.setRotation(-1);

    }
    public void jump(){
        speedY=-2;
    }

    @Override
    public void Draw(Graphics2D g2) {
        bird1.draw(g2,(int)getX() , (int)getY());

    }
}

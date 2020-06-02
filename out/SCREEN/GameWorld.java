package SCREEN;

import ObjectGame.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

public class GameWorld {
    public  int Score = 0;
    public ArrayList<Rectangle>rectangles;
    Bird bird = new Bird(100,300,null,0.04f);
    BackGround backGround = new BackGround(0,0,null);
    Impediment1 impediment1 = new Impediment1(350,-200, null);
    Impediment2 impediment2 = new Impediment2(350,400,null);
    Impediment1 impediment3 = new Impediment1(700,-200, null);
    Impediment2 impediment4 = new Impediment2(700,400,null);
    Impediment1 impediment5 = new Impediment1(1050,-200, null);
    Impediment2 impediment6 = new Impediment2(1050,400,null);
    BufferedImage image;

    GameWorld() {
        rectangles = new ArrayList<>();
        rectangles.add(impediment1.rectangle);
        rectangles.add(impediment2.rectangle);
        rectangles.add(impediment3.rectangle);
        rectangles.add(impediment4.rectangle);
        rectangles.add(impediment5.rectangle);
        rectangles.add(impediment6.rectangle);
            try {
                image = ImageIO.read(new File("asset/meo.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    Ground ground = new Ground(0,650,null);
    public int rand(){
        return (int)( Math.random()*300);
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }
    public void draw(Graphics2D g2){
        backGround.Draw(g2);
        bird.Draw(g2);
        impediment1.Draw(g2);
        impediment2.Draw(g2);
        impediment3.Draw(g2);
        impediment4.Draw(g2);
        impediment5.Draw(g2);
        impediment6.Draw(g2);
        ground.Draw(g2);
        g2.setColor(Color.RED);
        String s = "Scores : " + Score;
        Font font = new Font(Font.SANS_SERIF,  Font.BOLD, 30);
        g2.setFont(font);
        g2.drawString(s,150,730);
        g2.drawImage(image,50,680,null);
    }
    public void Update(){
        if(GamePanel.start == false) {
            backGround.Update();
            ground.Update();
        }
        else {
            bird.Update();
            backGround.Update();
            impediment1.Update();
            impediment2.Update();
            impediment3.Update();
            impediment4.Update();
            impediment5.Update();
            impediment6.Update();
            ground.Update();
            CheckColumn();
            CheckBird();
        }
        if(Score % 12 == 0 && Score != 0 )
            GamePanel.speed=1;
    }

    private void reset() {
        bird = new Bird(100,300,null,0.04f);
        backGround = new BackGround(0,0,null);
        impediment1 = new Impediment1(350,-200, null);
        impediment2 = new Impediment2(350,400,null);
        impediment3 = new Impediment1(700,-200, null);
        impediment4 = new Impediment2(700,400,null);
        impediment5 = new Impediment1(1050,-200, null);
        impediment6 = new Impediment2(1050,400,null);
        rectangles = new ArrayList<>();
        rectangles.add(impediment1.rectangle);
        rectangles.add(impediment2.rectangle);
        rectangles.add(impediment3.rectangle);
        rectangles.add(impediment4.rectangle);
        rectangles.add(impediment5.rectangle);
        rectangles.add(impediment6.rectangle);
        GamePanel.speed = 0.5;
    }

    private void CheckBird() {
        for(Rectangle r : rectangles){
            if(r.getX() == bird.getX())
                Score++;
            if(bird.rectangle.intersects(r)||bird.getY() < 0 || bird.getY() > ground.getY()) {
                bird.setRunning(false);
                reset();
                GamePanel.start= false;
                System.out.println("bird die");
            }
        }
    }

    private void CheckColumn() {
        if(bird.getX() == impediment1.getX() + 150){
            impediment1.setX((float) (impediment5.getX() + 350)) ;
            impediment2.setX((float) (impediment5.getX() + 350)) ;
            impediment1.setY(-rand());
            impediment2.setY(impediment1.getY()+400+150);
        }
        else if(bird.getX() == impediment3.getX() + 150){
            impediment3.setX((float) (impediment1.getX() + 350)) ;
            impediment4.setX((float) (impediment1.getX() + 350)) ;
            impediment3.setY(-rand());
            impediment4.setY(impediment3.getY()+400+150);
        }
        else if(bird.getX() == impediment5.getX() + 150){
            impediment5.setX((float) (impediment3.getX() + 350)) ;
            impediment5.setY(- rand());
            impediment6.setY(impediment5.getY()+400+150);
            impediment6.setX((float) (impediment5.getX())) ;
        }
    }
}

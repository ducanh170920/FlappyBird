package SCREEN;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable , KeyListener {
    private Thread thread;
    private  Boolean isRunning = true;
    private SCREEN.GameWorld gameWorld;
    private int FPS = 60;
    public static double speed = 0.5;
    BufferedImage image;
    public static Boolean start = false;


    public GamePanel(){
        this.setLayout(null);
       this.setBounds(0,0, SCREEN.GameFrame.Screen_width, SCREEN.GameFrame.Screen_width);
       this.setVisible(true);
       gameWorld = new SCREEN.GameWorld();
        try {
            image = ImageIO.read(new File("asset/Play.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(Boolean start) {
        this.start = start;
    }

    public void start() {
        if (thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }
    @Override
    public void paint(Graphics g){
         super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        gameWorld.draw((Graphics2D)g2);
        if(!start){
            g2.drawImage(image,460,270,null);
        String s = " Press Space to Play";
        Font font = new Font(Font.SANS_SERIF,  Font.BOLD, 30);
        g2.setFont(font);
        g2.drawString(s,430,430);
        }
    }
    @Override
    public void run() {
        long T = 1000/FPS;
        long TimeBuffer = T/2;

        long BeginTime = System.currentTimeMillis();
        long EndTime;
        long  sleeptime;
             while(isRunning){
                 repaint();
                 gameWorld.Update();
                 try {
                     EndTime = System.currentTimeMillis();
                     sleeptime = T-(EndTime - BeginTime);
                     if(sleeptime < 0)
                     thread.sleep(TimeBuffer);
                     else
                         thread.sleep(sleeptime);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                gameWorld.bird.jump();
                if(!start){
                    start = true;
                    gameWorld.Score =0;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

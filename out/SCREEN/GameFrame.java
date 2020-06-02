package SCREEN;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public static final int Screen_width = 1000;
    public static final  int Screen_height = 800;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame  Frame = new JFrame("FlappyBird");
    GamePanel gamePanel = new GamePanel();
    public GameFrame(){
        Frame.setSize(Screen_width,Screen_height);
        Frame.setLocation((int)(dim.getWidth()-Screen_width)/2,(int)(dim.getHeight()-Screen_height)/2);
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Frame.add(gamePanel);
        gamePanel.start();
        Frame.addKeyListener(gamePanel);
    }
    public static void main(String args[]){
        GameFrame gameFrame = new GameFrame();
    }
}

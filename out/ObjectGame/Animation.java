package ObjectGame;

import java.awt.*;
import java.util.ArrayList;

public class Animation {
    ArrayList<FameImage>fameImages;
    ArrayList<Double> timeperFame;
    private int CurentFram = 0;
    private long BeginTime = 0;
    private long TimeNextFrame;

    public long getRotation() {
        return Rotation;
    }

    public void setRotation(long rotation) {
        Rotation = rotation;
    }

    private long Rotation =0;
    public Animation(){
        fameImages = new ArrayList<>();
        timeperFame = new ArrayList<>();
        TimeNextFrame = System.currentTimeMillis();
    }
    public void add(FameImage fameImage, double time){
        fameImages.add(fameImage);
        timeperFame.add(new Double(time));
    }

    public ArrayList<FameImage> getFameImages() {
        return fameImages;
    }

    public void setFameImages(ArrayList<FameImage> fameImages) {
        this.fameImages = fameImages;
    }

    public ArrayList<Double> getTimeperFame() {
        return timeperFame;
    }

    public void setTimeperFame(ArrayList<Double> timeperFame) {
        this.timeperFame = timeperFame;
    }
    public  void nextFrame(){
        if(CurentFram >= 0 && CurentFram <= fameImages.size())
            CurentFram ++;
        if(CurentFram > fameImages.size() -1 )
            CurentFram = 0;
    }

    public int getCurentFram() {
        return CurentFram;
    }

    public void setCurentFram(int curentFram) {
        CurentFram = curentFram;
    }

    public long getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(long beginTime) {
        BeginTime = beginTime;
    }

    public long getTimeNextFrame() {
        return TimeNextFrame;
    }

    public void setTimeNextFrame(long timeNextFrame) {
        TimeNextFrame = timeNextFrame;
    }

    public void draw(Graphics2D g2, int x , int y){
        TimeNextFrame = System.currentTimeMillis();
        if(TimeNextFrame - BeginTime >= timeperFame.get(CurentFram)){
            nextFrame();
            BeginTime = TimeNextFrame;
        }
        fameImages.get(CurentFram).draw(g2,x,y,Rotation);


    }

}

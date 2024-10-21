package model;

import controller.GamePlayController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.Iterator;

public class Bullet extends GameElements {
    private int lane;
    private int plantPosition;
    transient private Timeline peaAnimation;
    private static int peaID = 0;
    private boolean flag;
    private int thispea;
    
    public Bullet(int x, int y, int plantPosision, int lane) {
        super(x, y, "/assets/pea.png", 20, 20);
        this.path = getClass().getResource("/assets/pea.png").toString();
        this.plantPosition = plantPosition;
        this.lane = lane;
        thispea = peaID++;
        this.flag = false;
    }
    public void movePea(){
        if(x <= 1050){
            setX(getX()+1);
        }
        if(plantPosition>getX()){
            img.setVisible(false);
        }
        else{
            img.setVisible(true);
        }
        checkPestCollision();
    }
    
    public void shootPea(){
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), e-> movePea()));
        animation.setCycleCount(1050);
        animation.play();
        this.peaAnimation = animation;
        GamePlayController.animationTimelines.add(animation);
    }
    
    public void checkPestCollision(){
        synchronized(GamePlayController.allPest){
            Iterator<Pest> i = GamePlayController.allPest.iterator();
            while(i.hasNext()){
                Pest z = i.next();
                if(z.getLane() == lane && !flag){
                    this.flag = true;
                    z.setHp(z.getHp()-1);
                    img.setVisible(false);
                    img.setDisable(true);
                    peaAnimation.stop();
                }
            }
        }
    }
    
    
}

package model;

import controller.GamePlayController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;

public class Shooter extends Plant{
    transient protected Timeline shooterTimeline;
    protected int lane;
    
    public Shooter(int x, int y, String path, int width, int height, int hp, int col, int row) {
        super(x, y, path, width, height, hp, col, row);
    }
    
    @Override
    public void attack(Pane pane){
        Timeline peaShooter = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                synchronized (GamePlayController.allPest){
                    Iterator<Pest> i = GamePlayController.allPest.iterator();
                    while(i.hasNext()){
                        Pest z = i.next();
                        if(z.getLane()== getShooterLane()&& getX() <= z.getX()){
                            int peaStartX = getX() + 50;
                            int peaStartY = getY() + 25;
                            Bullet p = new Bullet(peaStartX, peaStartY,getX() + 50, row);
                            p.makeImage(pane);
                            p.shootPea();
                            checkHp();
                        }
                    }
                }
            }
        }));
        peaShooter.setCycleCount(Timeline.INDEFINITE);
        peaShooter.play();
        this.shooterTimeline = peaShooter;
        GamePlayController.animationTimelines.add(peaShooter);
    }
    public Timeline getShooterTimeline(){
        return (this.shooterTimeline);
    }
    public int getShooterLane(){
        return (this.lane);
    }
    
    public void checkHp(){
        if(getHp() <= 0){
            endAnimation(this.shooterTimeline);
        }
    }
    public void endAnimation(Timeline timeline){
        if(timeline != null){
            timeline.stop();
        }
    }
    
    
}

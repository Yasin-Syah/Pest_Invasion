package model;

import controller.GamePlayController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;

public class LawnMower extends GameElements{
    
    int lane;
    boolean activated = false;
    String activatedPath = getClass().getResource("/assets/lawnmowerActivated.gif").toString();
    
    public LawnMower(int x, int y, int width) {
        super(x, y, "/assets/lawnmowerIdle.gif", 81, 77);
        this.path = getClass().getResource("/assets/lawnmowerIdle.gif").toString();
        this.lane = lane;
    }
    
    //method jika pest kena pemotong rumput
    public void checkPest(){
        Timeline findPest = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                synchronized (GamePlayController.allPest){
                    Iterator<Pest> i = GamePlayController.allPest.iterator();
                    while (i.hasNext()){
                        Pest z;
                            z = i.next();
                            if(Math.abs(z.getX()- getX()) <= 30){
                                if(activated == false){
                                    activate();
                                    z.setHp(0);
                                    activated = true;
                                    z.getPestAnimation().stop();
                                } else {
                                    z.setHp(0);
                                    z.getPestAnimation().stop();
                                }
                    
                         }
                            
                       GamePlayController.allMowers.remove(this);
                     }
                }
             }
        }));
        findPest.setCycleCount(Timeline.INDEFINITE);
        findPest.play();
    }
    //method Active
    public void activate(){
        img.setImage(new Image(activatedPath, 81,77, false, false));
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), e-> moveMower()));
        animation.play();
        GamePlayController.animationTimelines.add(animation);
        
    }
    public void moveMower(){
        if(getX() <= 1500){
            setX(getX() + 1);
        }
    }
    
}

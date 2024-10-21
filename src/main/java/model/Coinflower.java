package model;

import controller.GamePlayController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Coinflower extends Plant{
    transient private Timeline coinProducer;

    public Coinflower(int x, int y, String path, int width, int height, int hp, int col, int row) {
        super(x, y, "/assets/sunflower.gif", 73, 74, 100, col, row);
    }
    
    
    @Override
    public void attack(Pane pane){
        produceCoin(pane);
    }
    
    public void produceCoin(Pane pane){
        Timeline stopGlow = new Timeline (new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                Glow glow = new Glow();
                img.setEffect(glow);
                glow.setLevel(0.0);
            }
        }));
        
        Timeline coinProducer = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                checkHp();
                if(getHp()>0){
                    Coin s = new Coin(getX()+20, getY()+40, "/assets/koin.png", 40, 40, false);
                    s.makeImage(pane);
                }
                stopGlow.play();
            }
        }));
        Timeline startGlow = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                Glow glow = new Glow();
                img.setEffect(glow);
                glow.setLevel(0.5);
                coinProducer.play();
            }
        }));
        startGlow.setCycleCount(Timeline.INDEFINITE);
        startGlow.play();
        this.coinProducer = coinProducer;
        GamePlayController.animationTimelines.add(coinProducer);
        GamePlayController.animationTimelines.add(startGlow);
        GamePlayController.animationTimelines.add(stopGlow);
    }
    public Timeline getTimeline(){
        return this.coinProducer;
    }
    public void checkHp(){
        if(getHp() <= 0){
            endAnimation(getTimeline());
        }
    }
    
    public void endAnimation(Timeline timeline){
        if(timeline != null){
            timeline.stop();
        }
    }

    
}

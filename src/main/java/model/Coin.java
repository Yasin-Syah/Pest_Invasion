package model;

import controller.GamePlayController;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Coin extends GameElements{
    private int x;
    private int y;
    private final int timeouttime;
    
    public Coin(int x, int y, String assetskoinpng, int par1, int par2, boolean fallingCoin) {
        super(x, y, "/assets/koin.png",50, 50);
        //super.makeImage();
        
        if(fallingCoin) timeouttime=14000;
        else timeouttime = 5000;
        hilang();
    }
    
    public void hilang (){
        Thread t = new Thread(() -> {
            try{
                Thread.sleep(timeouttime);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            img.setVisible(false);
            img.setDisable(true);
        });
        t.start();
    }
    
    @Override
    public void makeImage(Pane p){
        super.makeImage(p);
        this.img.setOnMouseClicked(e->{
            this.img.setVisible(false);
            this.img.setDisable(true);
            GamePlayController.updateCoinCount(25);
        });
    }
    public void moveCoin(){
        if(getY() <= 550){
            
        }
    }
    
    public void dropCoin(){
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(12),e-> moveCoin()));
        animation.setCycleCount(550);
        animation.play();
        GamePlayController.animationTimelines.add(animation);
    }

    
    
}

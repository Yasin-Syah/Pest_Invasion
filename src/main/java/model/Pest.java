package model;

import controller.GamePlayController;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


import java.io.File;
import java.io.Serializable;
import java.util.Iterator;

public class Pest extends GameElements {
    private int hp;
    private int x;
    private int y;
    private int attackPower;
    private int lane;
    private int dx;
    transient private Timeline pestAnimation;
    private boolean reachedPlant = false;
    private boolean isEating = false;
    private transient Timeline chomping;
    
    
    public Pest(int x, int y, String p, int width, int height, int hp, int ap, int lane) {
        super(x, y, p, width, height);
        this.hp = hp;
        this.attackPower = ap;
        this.lane = lane;
        this.dx = -1;
        this.chomping = new Timeline(); 
    }
    
    
    
    public int getHp(){
        return this.hp;
    }
    public int getLane(){
        return (this.lane);
    }
    
    public void setHp(int hp){
        this.hp = hp;
        //kondisi hama mati
        if(hp<=0){
            GamePlayController.numPestKilled+=1;
            this.img.setVisible(false);
            this.img.setDisable(true);
            this.pestAnimation.stop();
            //kondisi memakan tanaman
            if(this.chomping != null){
                this.chomping.stop();
            }
            //untuk pest mati terus hilang
            for(int i = 0; i<GamePlayController.allPest.size(); i++){
                if(this == GamePlayController.allPest.get(i)){
                    GamePlayController.allPest.remove(i);
                    System.out.println("Pest Mati");
                    break;
                }
            }
        }
    }
    
    public void setLane(int lane){
        this.y = lane;
    }
    
    //jika pest masuk ke rumah dan game kalah
    public void checkReachedHouse(){
        //jika pest sudah berada di kordinat tertrntu
        if(img.getX() <= 220){
            GamePlayController.wonGame= -1;
            System.out.println("You Lose");
        }
    }
    
    //Pest Berpindah
    public void movePest(){
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(70), e-> pestWalk()));
        animation.play();
        this.pestAnimation = animation;
        GamePlayController.animationTimelines.add(animation);
    }
    
    //pest berjalan
    public void pestWalk(){
        if(getX() > 220 && this.hp > 0){
            setX(getX() + this.dx);
            try{
                eatPlant();
            }
            catch(java.util.ConcurrentModificationException e){
                System.out.println("Tanaman Mati");
            }
            checkReachedHouse();
        }
    }
    
    public Timeline getPestAnimation(){
        return this.pestAnimation;
    }

    
    
    public void chompPlant(){
        System.out.println("Tanamannya diamakan");
    }

    //kondisi jika pest ketemu plant maka dia akan makan tanamannya
    private void eatPlant() {
        int foundPlant = 0;
        synchronized(GamePlayController.allPlants){
            Iterator<Plant> i = GamePlayController.allPlants.iterator();
            while(i.hasNext()){
                Plant p = i.next();
                if(p.hashCode() == getLane()){
                    if(Math.abs(p.getX()-img.getX()) <= 50){
                        foundPlant = 1;
                        
                        if(reachedPlant == false){
                            reachedPlant = true;
                            isEating = true;
                        }
                        if(isEating){
                            Timeline chomp = new Timeline(new KeyFrame(Duration.millis(1000), e -> chompPlant()));
                            chomp.setCycleCount(1000);
                            chomp.play();
                            this.dx = 0;
                            this.chomping = chomp;
                            GamePlayController.animationTimelines.add(chomp);
                            isEating = false;
                        }
                        if(foundPlant == 1){
                            this.dx = 0;
                            p.setHp(p.getHp()-this.attackPower);
                            if(p.getHp() <= 0){
                                p.setHp(0);
                                GamePlayController.allPlants.remove(p);
                                p.img.setVisible(false);
                                p.img.setDisable(true);
                                this.dx = -1;
                                this.reachedPlant = false;
                                this.chomping.stop();
                                
                            }
                        }
                    }
                    else {
                        this.dx = -1;
                        this.reachedPlant = false;
                        if(this.chomping != null){
                            this.chomping.stop();
                        }
                    }
                }
                else {
                    this.dx = -1;
                }
            }
        }
        if(foundPlant == 0){
            this.dx = -1;
            if(this.chomping!= null){
                this.chomping.stop();
            }
            this.reachedPlant = false;
        }
    }
    
}

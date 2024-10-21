package model;

import controller.GamePlayController;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.nio.file.spi.FileSystemProvider;

public class Plant extends GameElements {
    String path;
    private int hp;
    public int col;
    public int row;
    
    public Plant(int x, int y, String path, int width, int height, int hp, int col, int row) {
        super(x, y, path, width, height);
        this.hp = hp;
        this.col = col;
        this.row = row;
    }
    
    public void makeImage(GridPane lawn){
        img = new ImageView();
        Image im = new Image(path,(double) width,(double) height,false,false);
        img.setImage(im);
        lawn.add(img,col,row,1,1);
    }
    
    public void attack(Pane p){
        
    }
    
    public int getHp(){
        return this.hp;
    }
    
    public void setHp(int hp){
        this.hp = hp;
        //kondisi jika plant di makan sampai hp habis
        if(this.hp<=0){
            GamePlayController.allPlants.remove(this);
        }
    }
    
}

package model;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


import java.io.Serializable;
import java.net.URL;


public abstract class GameElements implements Serializable {
    int x;
    private int y;
    protected String path;
    public transient ImageView img;
    public int width;
    public int height;
    
    public GameElements(int x, int y, String path, int width, int height){
        this.x = x;
        this.y = y;
        URL imagePath = getClass().getResource(path);
        if (imagePath != null) {
            this.path = imagePath.toString();
        } else {
            throw new IllegalArgumentException("Image path not found: " + path);
        }
        this.path = getClass().getResource(path).toString();
        this.width = width;
        this.height = height;
    }
    
    public void makeImage(Pane pane){
        
        if (path == null || path.isEmpty()) {
        throw new IllegalArgumentException("Image path cannot be null or empty");
    }
        
        img = new ImageView();
        Image im = new Image(path,(double) width,(double) height,false,false);
        img.setImage(im);
        img.setX(x);
        img.setY(y);
        pane.getChildren().add(img);
    }
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    
    public void setX(int x){
        this.x = x;
        img.setX(x);
    }
    public void setY(int y){
        this.y = y;
        img.setY(y);
    }
    
}

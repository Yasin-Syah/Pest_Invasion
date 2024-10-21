package model;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Shovel extends GameElements{
    
    private static boolean isDisabled=true;
    private static Shovel shovel;
    
    public Shovel(int x, int y, String path, int width, int height) {
        super(500, 10, path + "/assets/Shovel.png", 60, 60);
        this.path = getClass().getResource("/assets/Shovel.png").toString();
    }
    public boolean isDisabled(){
        return isDisabled;
    }
    
    public static Shovel getInstance(){
        if(shovel == null){
            shovel = new Shovel(500,10,"/assets/Shovel",60,60);
        }
        return shovel;
    }
    
    @Override
    public void makeImage(Pane p){
        super.makeImage(p);
        shovel.img.setOnMouseClicked(e->{
            shovel.isDisabled= false;
            shovel.enable();
            SidebarElement.setCardSelectedToNull();
        });
    }
    
    public void enable(){
        Glow glow= new Glow();
        shovel.img.setEffect(glow);
        glow.setLevel(0.4);
    }
    
    public void disable(){
        if(!isDisabled){
            Glow glow = (Glow) shovel.img.getEffect();
            glow.setLevel(0.0);
            shovel.isDisabled();
        }
    }
}

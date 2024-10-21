package model;

import controller.GamePlayController;
import javafx.scene.image.Image;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Bambu extends Plant{
    
    public Bambu(int x, int y, String path, int width, int height, int col, int row) {
        super(x, y, "/assets/walnut_full_life.gif", 75, 60, 400, col, row);
        this.path = getClass().getResource("/assets/walnut_full_life.gif").toString();
    }
    public void checkHp(){
        if(getHp()<=0){
            setHp(0);
            GamePlayController.allPlants.remove(this);
            img.setVisible(false);
            img.setDisable(true);
        }
    }
}

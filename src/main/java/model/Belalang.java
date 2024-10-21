package model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Iterator;

public class Belalang extends Pest{
    
    public Belalang(int x, int y, int lane) {
        super(14, 1, "/assets/coneheadzombie.gif", x, y, 300, 150, lane);
        this.path = getClass().getResource("/assets/coneheadzombie.gif").toString();
    }
    
}

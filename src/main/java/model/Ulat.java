package model;

import javafx.scene.layout.Pane;

public class Ulat extends Pest{
    
    public Ulat(int x, int y, int lane) {
        super(7, 1, "/assets/normalzombie.gif", x, y, 100, 100, lane);
        this.path = getClass().getResource("/assets/normalzombie.gif").toString();
    }
    
}

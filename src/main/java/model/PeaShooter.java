package model;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PeaShooter extends Shooter {
    
    public PeaShooter(int x, int y, String path, int width, int height, int hp, int col, int row) {
        super(x, y, "/assets/peaShooter.gif", 60, 62, 100, col, row);
        this.path=getClass().getResource("/assets/peaShooter.gif").toString();
    }
    
}

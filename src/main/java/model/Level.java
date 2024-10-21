package model;

import controller.GamePlayController;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.scene.layout.AnchorPane;

public class Level {

    private int levelNumber;
    private int ulat;
    private int belalang;
    private int totoalPest;
    
    private ArrayList<Plant> availablePlants;
    private ArrayList<Integer> availablePest;
    private ArrayList<Integer> pestList1;
    private ArrayList<Integer> pestList2;
    
    public Level(int n){
        this.levelNumber = n;
        this.availablePlants = new ArrayList<Plant>();
        this.availablePest = new ArrayList<Integer>();
        this.pestList1 = new ArrayList<Integer>();
        this.pestList2 = new ArrayList<Integer>();
        
        if (n>=1){
            this.totoalPest = 5;
            this.ulat = 5;
            this.belalang = 0;
        }
        if (n >=2){
            this.totoalPest = 15;
            this.ulat = 10;
            this.belalang = 5;
        }
        
        for (int i = 0; i < this.ulat; i++){
            this.availablePest.add(0);
        }
        for (int j = 0; j < belalang; j++){
            this.availablePest.add(1);
        }
        
        Collections.shuffle(availablePest);
        for(int m = 0; m<availablePest.size(); m++){
            if(m%2 == 0){
                this.pestList1.add(availablePest.get(m));
            } else {
                this.pestList2.add(availablePest.get(m));
            }
        }
    }
    
    public ArrayList<Integer> getPestList(){
        return(this.pestList1);
    }
    public ArrayList<Integer> getPestList2(){
        return(this.pestList2);
    }
    
    public static void spawnUlat(Pane pane, int lane, int laneNumber){
        Ulat z = new Ulat(1024, lane, laneNumber);
        z.makeImage(pane);
        GamePlayController.allPest.add(z);
        z.movePest();
    }
    
    public static void spawnBelalang(Pane pane, int lane, int laneNumber){
        Belalang z = new Belalang(1024, lane, laneNumber);
        z.makeImage(pane);
        GamePlayController.allPest.add(z);
        z.movePest();
    }
    
    public int getTotalPest(){
        return(this.totoalPest);
    }
}

package model;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author AERO
 */

public class Record {
    private int score;
    private int id;

    public Record(int score, int id) {
        this.setScore(score);
        this.setId(id);
    
    }
    

//    public Record() {
//    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.Bullet;
/**
 *
 * @author Asus
 */
public class Plant {
    private int hp;
    private int x;
    private int y;
    Bullet bullet;
    
    public Plant (int hp, int x, int y, Bullet bullet){
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.bullet = bullet;
    }
    

   public int getHp() {
        return hp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bullet getBullet() {
        return bullet;
    }
    
    
}

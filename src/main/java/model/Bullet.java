/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Bullet {
    private int damage;
    private int x;
    private int y;
    private int speed;
    
    public Bullet (int damage, int x, int y){
        this.damage = damage;
        this.x = x;
        this.y = y;
    }
    
    public void shoot (){
        x++;
        
    }
}

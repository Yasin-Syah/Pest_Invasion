package main;

/*import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
*/

/*
public class GamePanel extends JPanel implements Runnable{
    //screen seting
    final int originalTileSize = 25; //16x16 tile
    final int scale =3;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol =16;
    final int maxScreenRow=12;
    final int screenWidth = tileSize*maxScreenCol; //768 pixels
    final int screenHeight =tileSize*maxScreenRow; //576 pixels
    
    
    
    //set player ke posisi default
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        
    }
    
    /*public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }*/
    
/*
    @Override
    public void run(){
        
        double drawInterval = 1000000000/FPS; //0.0166666 second
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread !=null){
           
            update();
            
            repaint();
            
            
            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                
                Thread.sleep((long)remainingTime);
                
                nextDrawTime += drawInterval;
                
            }
            catch (InterruptedException e){
                    //
                    e.printStackTrace();
                    }
            
        }
    }
*/
  
/*
    public void run(){
        
        
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer =0;
        int drawCount = 0;
        
        
       /* while(gameThread != null){
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1){
                //update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS : " +drawCount);
                drawCount = 0;
                timer = 0;
            }
        }*/
        
        
/*        
    }
    
    //public void update(){
        //player.update();
    //} 
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        //player.draw(g2);
        
        g2.dispose();
        
    }
   
}
*/

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

public class GamePanel extends JFrame {

    public GamePanel() {
        // Set default behavior on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat panel untuk game
        //JPanel gamePanel = new JPanel();
        //gamePanel.setBackground(Color.BLACK); // Warna latar belakang untuk game
        
        // Mengatur agar fullscreen
        setUndecorated(true); // Menghilangkan border dan title bar
        setResizable(false); // Mencegah resizing

        // Mendapatkan perangkat grafis dan mengatur ke mode fullscreen
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = env.getDefaultScreenDevice();

        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this); // Set window menjadi fullscreen
        } else {
            System.out.println("Fullscreen mode tidak didukung");
            setSize(800, 600); // Jika tidak bisa fullscreen, atur ukuran default
        }

        // Membuat dan menampilkan layar loading
        LoadingScreen loadingScreen = new LoadingScreen();
        add(loadingScreen);
        revalidate();
        repaint();

        // Menjalankan proses loading
        loadingScreen.showLoading();

        // Setelah loading selesai, pindah ke game panel
        getContentPane().removeAll();  // Menghapus komponen loading screen
        revalidate();                  // Refresh layar agar perubahan terlihat
        repaint();
    }
}
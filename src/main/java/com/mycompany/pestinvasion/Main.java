/*package main;
import entity.Pest;
import entity.Plant;
import object.Bullet;

public class Main {
    public static void main(String[] args) {
        Bullet beceng = new Bullet(10, 100, 100);
        Bullet corndog = new Bullet(10, 100, 100);
        Plant jagung = new Plant(100, 0, 0, corndog);
        
        
        Bullet test = jagung.getBullet();
        System.out.println();
    }
}
*/

package com.mycompany.pestinvasion;



import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import model.Player;  // Mengimpor Player dari package model
import dao.PlayerDAO;
import dao.BaseDAO;
import model.Record;
import dao.RecordDAO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/main/java/view/GamePlay.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Online Diary");
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
//        JFrame window = new JFrame();
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setResizable(false);
//        window.setTitle("Pest Invation");
//        
//        GamePanel gamePanel = new GamePanel();
//        window.add(gamePanel);
//        
//        window.pack();
//        
//        
//        window.setLocationRelativeTo(null);
//        window.setVisible(true);
        
//        BaseDAO db = new BaseDAO();
//        db.getCon();

    

        launch();



//        Scanner sc = new Scanner(System.in);
//        BaseDAO.getCon();
//        System.out.println("masukkan username");
//        String name = sc.nextLine();
//        System.out.println("masukkan password");
//        String pw = sc.nextLine();
//        Player p = new Player(name,pw);
//        System.out.println(p.getUname());
//        p.getPass();
//        PlayerDAO.registerPlayer( p);
//        int x = PlayerDAO.Valdi(p.getUname(), p.getPass());
        
        
        //gamePanel.startGameThread();
         
//        Record r = new Record(1000, x);
//        System.out.println(r.getId());
//        RecordDAO.insertEntry(r);
//        
//        RecordDAO.showLB();
    }
}

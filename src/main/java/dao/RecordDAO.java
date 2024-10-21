/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Record;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import model.Player;
import java.sql.Statement;

/**
 *
 * @author Asus
 */
public class RecordDAO extends BaseDAO {
    private static PreparedStatement st;
    private static Connection con;
    
    public static void insertEntry(Record s) {
        
        try {
            
//            String query = "insert into record (idPlayer, score ) "
//                    + " values (,'%s') ";
//            query = String.format(query,
//                    s.getOwner().getId(),
//                    s.getScore());
            con = getCon();
            String query = "INSERT INTO record (idPlayer, score) VALUES (?, ?)";
            st = con.prepareStatement(query);
            st.setInt(1, s.getId());
            st.setInt(2,s.getScore());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
    
    public static void showLB (){
        con = getCon();
        if (con != null) {
            String query = "SELECT MAX(score) AS score, player.uname\n" +
                            "FROM record JOIN player ON idPlayer = player.id\n" +
                            "GROUP BY player.id\n" +
                            "ORDER BY MAX(score) DESC ";
            
            try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                while (resultSet.next()) {
                    String nama = resultSet.getString("uname");
                    int score = resultSet.getInt("score");
                    
                    System.out.println("Nama: " + nama + ", score: " + score);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

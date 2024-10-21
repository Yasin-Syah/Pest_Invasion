/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.BaseDAO.closeCon;
import static dao.BaseDAO.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import model.Player;
/**
 *
 * @author Asus
 */
public class PlayerDAO {
    private static PreparedStatement st;
    private static Connection con;
    
    public static Player validate(String name, String passwd) {
        Player u = null;
        try {
            con = getCon();
            String query = "select id from player where uname = '%s' and password = '%s' ";
            query = String.format(query,
                    name,
                    passwd);
            st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                u = new Player( name, passwd, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return u;
    }
    public static int Valdi(String name, String passwd){
        int id = -1;
        try {
            con = getCon();
            String query = "select id from player where uname = '%s' and password = '%s' ";
            query = String.format(query,
                    name,
                    passwd);
            st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return id;
    }
    
    
    public static void registerPlayer(Player u) {
        try {
            con = getCon();
//            String query = "insert into player"
//                    + " values ('%s', '%s') ";
//            query = String.format(query,
//                    u.getUname(),
//                    u.getPass());
            String query = "INSERT INTO player (uname, password) VALUES (?, ?)";
            st = con.prepareStatement(query);
            st.setString(1, u.getUname());
            st.setString(2, u.getPass());
            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }

    }
}

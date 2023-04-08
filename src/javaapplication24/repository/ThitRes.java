/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import javaapplication24.model.Thit;
import Utilities.DBContext;
import Utilities.JDBCHelpers;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThitRes implements InThitRes{
    @Override
    public ArrayList<Thit> read(){
        ArrayList<Thit> listT = new ArrayList<>();
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT * FROM THIT";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listT.add(new Thit(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi !!!");
            Logger.getLogger(ThitRes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listT;
    }
    
    public Thit getThitByMa(String Ma){
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT * FROM THIT WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Thit(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            connection.close();
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Thit getThitByTen(String Ten){
        try {
            Connection connection = DBContext.getConnection();
            String sql = "SELECT * FROM THIT WHERE TEN = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Ten);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Thit(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            connection.close();
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public int add(Thit t){
        String sql = "INSERT INTO THIT (TEN, MOTA) VALUES (?, ?)";
        return JDBCHelpers.executeUpdate(sql, t.getTen(), t.getMota());
    }
    
    
    public int delete(String Ma){
        String sql = "DELETE FROM THIT WHERE ID = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    public int update(Thit t){
        String sql = "UPDATE THIT SET TEN = ?, MOTA = ? WHERE ID = ?";
        return JDBCHelpers.executeUpdate(sql, t.getTen(), t.getMota(), t.getId());
    }
}

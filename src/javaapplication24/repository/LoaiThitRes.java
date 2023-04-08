/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import javaapplication24.model.LoaiThit;
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
public class LoaiThitRes implements InLoaiThitRes{
    
    @Override
    public ArrayList<LoaiThit> read(){
        ArrayList<LoaiThit> listLT = new ArrayList<>();
        String sql = "SELECT LOAITHIT.ID, LOAITHIT.TEN, LOAITHIT.GIATHEOKG, LOAITHIT.HSD, THIT.ID, THIT.TEN, THIT.MOTA FROM LOAITHIT JOIN THIT ON THIT.ID = LOAITHIT.IDTHIT ORDER BY LOAITHIT.ID";
        ResultSet rs = JDBCHelpers.executeQuery(sql);
        try {
            while (rs.next()) {
                String Id = rs.getString(1);
                String Ten = rs.getString(2);
                int DonGia = Integer.parseInt(rs.getString(3));
                int HSD = Integer.parseInt(rs.getString(4));
                listLT.add(new LoaiThit(Id, rs.getString(5), rs.getString(6), Ten, DonGia, HSD));
            }
            return listLT;

        } catch (SQLException ex) {
            Logger.getLogger(LoaiThitRes.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public LoaiThit getLTByMa(String Ma){
        LoaiThit lt = null;
        String sql = "SELECT LOAITHIT.ID, LOAITHIT.TEN, LOAITHIT.GIATHEOKG, LOAITHIT.HSD, THIT.ID, THIT.TEN, THIT.MOTA FROM LOAITHIT JOIN THIT ON THIT.ID = LOAITHIT.IDTHIT WHERE LOAITHIT.ID = ? ORDER BY LOAITHIT.ID";
        ResultSet rs = JDBCHelpers.executeQuery(sql,Ma);
        try {
            while (rs.next()) {
                String Id = rs.getString(1);
                String Ten = rs.getString(2);
                int DonGia = Integer.parseInt(rs.getString(3));
                int HSD = Integer.parseInt(rs.getString(4));
                lt = new LoaiThit(Id, rs.getString(5), rs.getString(6), Ten, DonGia, HSD);
            }
            return lt;

        } catch (SQLException ex) {
            Logger.getLogger(LoaiThitRes.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public LoaiThit getLTByTen(String TenLT){
        LoaiThit lt = null;
        String sql = "SELECT LOAITHIT.ID, LOAITHIT.TEN, LOAITHIT.GIATHEOKG, LOAITHIT.HSD, THIT.ID, THIT.TEN, THIT.MOTA FROM LOAITHIT JOIN THIT ON THIT.ID = LOAITHIT.IDTHIT WHERE LOAITHIT.TEN = ? ORDER BY LOAITHIT.ID";
        ResultSet rs = JDBCHelpers.executeQuery(sql,TenLT);
        try {
            while (rs.next()) {
                String Id = rs.getString(1);
                String Ten = rs.getString(2);
                int DonGia = Integer.parseInt(rs.getString(3));
                int HSD = Integer.parseInt(rs.getString(4));
                lt = new LoaiThit(Id, rs.getString(5), rs.getString(6), Ten, DonGia, HSD);
            }
            return lt;

        } catch (SQLException ex) {
            Logger.getLogger(LoaiThitRes.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public LoaiThit getLTByGia(String Gia){
        LoaiThit lt = null;
        String sql = "SELECT LOAITHIT.ID, LOAITHIT.TEN, LOAITHIT.GIATHEOKG, LOAITHIT.HSD, THIT.ID, THIT.TEN, THIT.MOTA FROM LOAITHIT JOIN THIT ON THIT.ID = LOAITHIT.IDTHIT WHERE LOAITHIT.GIATHEOKG = ? ORDER BY LOAITHIT.ID";
        ResultSet rs = JDBCHelpers.executeQuery(sql,Gia);
        try {
            while (rs.next()) {
                String Id = rs.getString(1);
                String Ten = rs.getString(2);
                int DonGia = Integer.parseInt(rs.getString(3));
                int HSD = Integer.parseInt(rs.getString(4));
                lt = new LoaiThit(Id, rs.getString(5), rs.getString(6), Ten, DonGia, HSD);
            }
            return lt;

        } catch (SQLException ex) {
            Logger.getLogger(LoaiThitRes.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public int add(LoaiThit lt){
        String sql = "INSERT INTO LOAITHIT (IDTHIT, TEN, GIATHEOKG, HSD) VALUES (?,?,?,?)";
        return JDBCHelpers.executeUpdate(sql, lt.getIDThit(), lt.getTen(), lt.getDonGia(), lt.getHSD());
    }
    
    
    @Override
    public int delete(String Ma){
        String sql = "DELETE FROM LOAITHIT WHERE ID = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    
    @Override
    public int deleteByThit(String Ma){
        String sql = "DELETE FROM LOAITHIT WHERE IDTHIT = ?";
        return JDBCHelpers.executeUpdate(sql, Ma);
    }
    
    @Override
    public int update(LoaiThit lt){
        String sql = "UPDATE LOAITHIT SET IDTHIT = ?, TEN = ?, GIATHEOKG = ?, HSD = ? WHERE ID = ?";
        return JDBCHelpers.executeUpdate(sql, lt.getIDThit(), lt.getTen(), lt.getDonGia(), lt.getHSD(), lt.getId());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javaapplication24.model.DonViVanChuyen;

/**
 *
 * @author Administrator
 */
public class DonViVCRepo {

    private Connection conn;

    public DonViVCRepo() {
        conn = DBconnect.getConnection();

    }

    public boolean update(DonViVanChuyen dvvc) {

        try {

            String sql = "Update DonViVanChuyen set ten=?,phamViVanCHuyen=?,trangThai=?,hotLine=? where iddonViVanChuyen=?";
            PreparedStatement ps = conn.prepareStatement(sql);

          
            ps.setString(1, dvvc.getTen());
            ps.setString(2, dvvc.getPhamViVC());
            ps.setInt(3, dvvc.getTrangThai());
            
              ps.setString(4, dvvc.getHotLine());
               ps.setString(5, dvvc.getIdDVVC());
            ps.execute();
            System.out.println("Thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
            return false;
        }

    }

    public boolean delete(DonViVanChuyen dvvc) {

        try {

            String sql = "Delete DonViVanChuyen where iddonViVanChuyen=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dvvc.getIdDVVC());

            ps.execute();
            System.out.println("Thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
            return false;
        }

    }

    public boolean insert(DonViVanChuyen dvvc) {

        try {

            String sql = "Insert into DonViVanChuyen(ten,phamViVanChuyen,trangThai,hotLine) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

           
            ps.setString(1, dvvc.getTen());
            ps.setString(2, dvvc.getPhamViVC());
            ps.setInt(3, dvvc.getTrangThai());
             ps.setString(4, dvvc.getHotLine());
            ps.execute();
            System.out.println("Thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
            return false;
        }

    }

    public List<DonViVanChuyen> all() {

        List<DonViVanChuyen> ds = new ArrayList<>();
        try {

            String sql = "Select * from DonViVanChuyen";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("iddonViVanChuyen");
              
                String ten = rs.getString("ten");
                String phamviVC = rs.getString("phamViVanChuyen");
                int trangThai = rs.getInt("trangThai");
                String hotLine = rs.getString("hotLine");
                DonViVanChuyen dvvc = new DonViVanChuyen(id, ten, phamviVC, trangThai, hotLine);
                ds.add(dvvc);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }

}

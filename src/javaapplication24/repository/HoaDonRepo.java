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

import javaapplication24.model.HoaDon;

/**
 *
 * @author Administrator
 */
public class HoaDonRepo {

    private Connection conn;

    public HoaDonRepo() {
        conn = DBconnect.getConnection();

    }

    public List<HoaDon> all() {

        List<HoaDon> ds = new ArrayList<>();
        try {

            String sql = "Select * from hoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("idHoaDon");
                 String idKH = rs.getString("idKH");
                  String idVC = rs.getString("idVC");
                   String idNV = rs.getString("idNV");
                String ngayTao = rs.getString("ngaytao");
                String trangThai = rs.getString("trangThai");
                String ghiChu = rs.getString("ghiChu");
                HoaDon hd = new HoaDon(id, idKH, idVC, idNV, ngayTao, trangThai, ghiChu);
                ds.add(hd);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }

}

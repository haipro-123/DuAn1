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
import javaapplication24.domainmodel.KhachHang;

/**
 *
 * @author fptsh
 */
public class KhachHangRepository {
    
    public static List<KhachHang> readDB() {
        String query = """
                       SELECT [idKhachHang]
                             ,[maKH]
                             ,[tenKH]
                             ,[gioiTinh]
                             ,[ngaySinh]
                             ,[sdt]
                             ,[email]
                             ,[trangThai]
                             ,[diaChi]
                         FROM [dbo].[khachHang]
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public List<KhachHang> getMa(String maKH) {
        String query = """
                       SELECT [idKhachHang]
                             ,[maKH]
                             ,[tenKH]
                             ,[gioiTinh]
                             ,[ngaySinh]
                             ,[sdt]
                             ,[email]
                             ,[trangThai]
                             ,[diaChi]
                         FROM [dbo].[khachHang]
                         WHERE maKH = ?
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ps.setObject(1, maKH);
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static List<KhachHang> sortByName() {
        String query = """
                       SELECT [idKhachHang]
                        ,[maKH]
                        ,[tenKH]
                        ,[gioiTinh]
                        ,[ngaySinh]
                        ,[sdt]
                        ,[email]
                        ,[trangThai]
                        ,[diaChi]
                       FROM [dbo].[khachHang]
                       ORDER BY maKH ASC
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareCall(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(khachHang);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean add(KhachHang khachHang) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[khachHang]
                                  ([maKH]
                                  ,[tenKH]
                                  ,[gioiTinh]
                                  ,[ngaySinh]
                                  ,[sdt]
                                  ,[email]
                                  ,[trangThai]
                                  ,[diaChi])
                            VALUES
                                  (?,?,?,?,?,?,?,?)
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, khachHang.getMaKH());
            ps.setObject(2, khachHang.getTenKH());
            ps.setObject(3, khachHang.getGioiTinh());
            ps.setObject(4, khachHang.getNgaySinh());
            ps.setObject(5, khachHang.getSdt());
            ps.setObject(6, khachHang.getEmail());
            ps.setObject(7, khachHang.getTrangThai());
            ps.setObject(8, khachHang.getDiaChi());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean update(String maKH, KhachHang khachHang) {
        int check = 0;
        String query = """
                        UPDATE [dbo].[khachHang]
                           SET [maKH] = ?
                              ,[tenKH] = ?
                              ,[gioiTinh] = ?
                              ,[ngaySinh] = ?
                              ,[sdt] = ?
                              ,[email] = ?
                              ,[trangThai] = ?
                              ,[diaChi] = ?
                         WHERE maKH = ?
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(8, maKH);
            ps.setObject(1, khachHang.getTenKH());
            ps.setObject(2, khachHang.getGioiTinh());
            ps.setObject(3, khachHang.getNgaySinh());
            ps.setObject(4, khachHang.getSdt());
            ps.setObject(5, khachHang.getEmail());
            ps.setObject(6, khachHang.getTrangThai());
            ps.setObject(7, khachHang.getDiaChi());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        List<KhachHang> list = new KhachHangRepository().readDB();
        for (KhachHang khachHang : list) {
            System.out.println(khachHang.toString());
        }
    }
    
}

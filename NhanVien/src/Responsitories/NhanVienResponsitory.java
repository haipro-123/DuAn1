/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;

import DomainModels.NhanVien;
import Utilities.DBConnection;
import ViewModel.QLNhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.lang.System;

/**
 *
 * @author Do Quoc Thinh
 */
public class NhanVienResponsitory implements INhanVienResponsitory {

    @Override
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> lis = new ArrayList<>();
        try {
            Connection c = DBConnection.openDbConnection();
            String sql = "select * from nhanVien order by MaNV asc";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lis.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lis;
    }

    @Override
    public int deleteNhanVien(String idNhanVien) {
        String sql = "delete from nhanVien where idNhanVien = ?";
        return DBConnection.ExcuteDungna(sql, idNhanVien);
    }

    @Override
    public int updateNhanVien(NhanVien nv) {
        String sql = "update nhanVien set MaNV = ?, HoTen = ?, GioiTinh = ?, "
                + "Email = ?, DiaChi = ?, SDT = ?, MatKhau = ?, TenCV = ?, TrangThai = ? where idNhanVien = ?";
        return DBConnection.ExcuteDungna(sql, nv.getMaNV(), nv.getHoTen(), nv.getGioiTinh(),
                nv.getEmail(), nv.getDiaChi(), nv.getSDT(), nv.getMatKhau(), nv.getChucVu(), nv.getTrangThai(), nv.getIdNhanVien());
    }

    @Override
    public NhanVien addNhanVien(NhanVien nv) {
        String sql = "insert into nhanVien values\n"
                + "(newid(),?,?,?,?,?,?,?,?,?)";
        DBConnection.ExcuteDungna(sql, nv.getMaNV(), nv.getHoTen(),
                nv.getGioiTinh(), nv.getEmail(), nv.getDiaChi(), nv.getSDT(), nv.getMatKhau(), nv.getChucVu(), nv.getTrangThai());
        return nv;
    }

    public ArrayList<NhanVien> findNhanVien(String MaNV) {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        try {
            Connection cn = DBConnection.openDbConnection();
            String sql = "select * from nhanVien where MaNV like ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, MaNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10)));
            }
            cn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
}

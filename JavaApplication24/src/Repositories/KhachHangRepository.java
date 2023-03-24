/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
public class KhachHangRepository {

    final String insert = "insert into khachHang(maKH, hoTen, sdt, diaChi) values (?, ?, ?, ?)";
    final String update = "update khachHang set maKH = ?, hoTen = ?, sdt = ?, diaChi = ? where idKhachHang = ?";
    final String selectID = "select idKhachHang from khachHang where maKH = ?";
    final String selectAll = "select * from khachHang";
    final String selectByID = "select * from khachHang where maKH = ?";
    private List<KhachHang> listKH;

    public KhachHangRepository() {
        listKH = new ArrayList<>();
    }

    private List<KhachHang> getSelectSQL(String sql, Object... args) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);
            while (rs.next()) {
                listKH.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return listKH;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
//Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getID(String sql, Object... args) {
        String id = null;
        try {
            ResultSet rs = DBConnection.getDataFromQuery(sql, args);

            while (rs.next()) {
                id = rs.getString(1);
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
//Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List<KhachHang> findAll() {
        listKH = new ArrayList<>();
        return getSelectSQL(selectAll);
    }

    public KhachHang getKHByMa(String ma) {
        return getSelectSQL(selectByID, ma).get(0);
    }

    public KhachHang save(KhachHang khachHang) {
        DBConnection.ExcuteUpdate(insert, khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getSdt(), khachHang.getDiaChi());
        return khachHang;
    }
    public String findID(String ma) {
        return getID(selectID, ma);
    }
    public KhachHang update(KhachHang khachHang) {
        DBConnection.ExcuteUpdate(update, khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getSdt(), khachHang.getDiaChi(), khachHang.getId());
        return khachHang;
    }
}

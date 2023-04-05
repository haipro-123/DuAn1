/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import java.util.List;
import javaapplication24.viewmodel.GioHangViewModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class GioHangViewRepository {

    public List<GioHangViewModel> getList() {
        String query = """
                       select tenLoai,hdct.soluong,hdct.gia from HoaDonChiTiet as hdct join hopThit as ht on hdct.idhopThit = ht.idThit 
                       join loaiThit as lt on lt.idLoaithit = ht.idLoaithit
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<GioHangViewModel> list = new ArrayList<>();
            while(rs.next()){
//                GioHangViewModel gh = new GioHangViewModel(, query, 0, 0)
            }
        } catch (Exception e) {
        }
        return null;
    }
    
}

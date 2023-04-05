/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import java.util.List;
import javaapplication24.viewmodel.HoaDonViewModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class HoaDonViewRepository {

    public List<HoaDonViewModel> getList() {
        String query = """
                       select hd.idHoaDon,hd.ngaytao,nv.hoTen,kh.sdt from hoaDon as hd join nhanvien as nv on hd.idNV = nv.idNhanVien join khachHang as kh on hd.idKH = kh.idKhachHang
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<HoaDonViewModel> list = new ArrayList<>();
            while(rs.next()){
                HoaDonViewModel hdvm = new HoaDonViewModel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                list.add(hdvm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}

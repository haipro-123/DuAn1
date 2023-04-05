/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.repository;

import java.util.List;
import javaapplication24.model.Voucher;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class VoucherRepository {

    public List<Voucher> getList() {
        String query = """
                       SELECT [idVoucher]
                             ,[Loai]
                             ,[Giatri]
                             ,[ten]
                             ,[HSD]
                             ,[dkNhan]
                             ,[mucGiaGioiHan]
                             ,[ngayKetThuc]
                         FROM [dbo].[voucher]
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List<Voucher> list = new ArrayList<>();
            while(rs.next()){
                Voucher vou = new Voucher(rs.getString(1),rs.getString(4),rs.getByte(2),rs.getInt(3),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8));
                list.add(vou);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(Voucher vou) {
        int check =0;
        String query = """
                       INSERT INTO [dbo].[voucher]
                                  ([Loai]
                                  ,[Giatri]
                                  ,[ten]
                                  ,[HSD]
                                  ,[dkNhan]
                                  ,[mucGiaGioiHan]
                                  ,[ngayKetThuc])
                            VALUES(?,?,?,?,?,?,?)
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1,vou.getLoai());
            ps.setObject(2,vou.getGiaTri());
            ps.setObject(3,vou.getTen());
            ps.setObject(4,vou.getHsd());
            ps.setObject(5,vou.getDkNhan());
            ps.setObject(6,vou.getMucGiaGioiHan());
            ps.setObject(7,vou.getNgayKetThuc());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    public boolean update(Voucher vou) {
        int check =0;
        String query = """
                       UPDATE [dbo].[voucher]
                          SET [Loai] = ?
                             ,[Giatri] = ?
                             ,[ten] = ?
                             ,[HSD] = ?
                             ,[dkNhan] = ?
                             ,[mucGiaGioiHan] = ?
                             ,[ngayKetThuc] = ?
                        WHERE [idVoucher] = ?
                       """;
        try(Connection con = DBconnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setObject(1,vou.getLoai());
            ps.setObject(2,vou.getGiaTri());
            ps.setObject(3,vou.getTen());
            ps.setObject(4,vou.getHsd());
            ps.setObject(5,vou.getDkNhan());
            ps.setObject(6,vou.getMucGiaGioiHan());
            ps.setObject(7,vou.getNgayKetThuc());
            ps.setObject(8, vou.getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    
}

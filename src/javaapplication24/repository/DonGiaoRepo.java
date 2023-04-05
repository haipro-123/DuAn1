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
import javaapplication24.model.DonGiao;

/**
 *
 * @author Administrator
 */
public class DonGiaoRepo {

    private Connection conn;

    public DonGiaoRepo() {
        conn = DBconnect.getConnection();

    }

    public boolean update(DonGiao dgct) {

        try {

            String sql = "Update donGiao set idHoaDon=?,idDonViVanChuyen=?,tinhTrang=? where idDonGiao=?";
            PreparedStatement ps = conn.prepareStatement(sql);

              ps.setString(1, dgct.getIdHoaDon());
            ps.setString(2, dgct.getIdDonViVanChuyen());
            
                ps.setString(3, dgct.getTinhTrang());
                   ps.setString(4, dgct.getIdDonGiao());
            ps.execute();
            System.out.println("Thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
            return false;
        }

    }

  

    public boolean insert(DonGiao dg) {

        try {

            String sql = "Insert into donGiao(idHoaDon,idDonViVanChuyen,ngayGiaohang,ngayNhanDuKien,diaChiNhanHang,tinhTrang) values(?,?,?,?,?,'Đang Giao')";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dg.getIdHoaDon());
            ps.setString(2, dg.getIdDonViVanChuyen());
             ps.setString(3, dg.getNgayGiaoHang());
              ps.setString(4, dg.getNgayNhanDK());
               ps.setString(5, dg.getDiaChi());
           
              
                 
                 

            ps.execute();
            System.out.println("Thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
            return false;
        }

    }

    public List<DonGiao> all() {

        List<DonGiao> ds = new ArrayList<>();
        try {

            String sql = "Select donGiao.idDonGiao,donGiao.idHoaDon,donGiao.idDonViVanChuyen,DonViVanChuyen.ten as tenDVVC,donGiao.ngayGiaohang,donGiao.ngayNhanDuKien,donGiao.diaChiNhanHang,donGiao.tinhTrang\n"
                    + "from donGiao join DonViVanChuyen on DonViVanChuyen.iddonViVanChuyen= donGiao.idDonViVanChuyen join hoaDon on donGiao.idHoaDon=hoaDon.idHoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
              
                String idDonGiao = rs.getString("idDonGiao");
                String idHoaDon = rs.getString("idHoaDon");
                String idDVVC = rs.getString("idDonViVanChuyen");
               
               
                String tenDVVC = rs.getString("tenDVVC");
                String ngayGiao = rs.getString("ngayGiaohang");
                String ngayNhan = rs.getString("ngayNhanDuKien");
                 String diaChi = rs.getString("diaChiNhanHang");
                String tinhTrang = rs.getString("tinhTrang");

                DonGiao dg = new DonGiao(idDonGiao, idHoaDon, idDVVC, tenDVVC, ngayGiao, ngayNhan, diaChi, tinhTrang);
                ds.add(dg);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
    
    public List<DonGiao> donDangGiao() {

        List<DonGiao> ds = new ArrayList<>();
        try {

            String sql = "Select donGiao.idDonGiao,donGiao.idHoaDon,donGiao.idDonViVanChuyen,DonViVanChuyen.ten as tenDVVC,donGiao.ngayGiaohang,donGiao.ngayNhanDuKien,donGiao.diaChiNhanHang,donGiao.tinhTrang\n"
                    + "from donGiao join DonViVanChuyen on DonViVanChuyen.iddonViVanChuyen= donGiao.idDonViVanChuyen join hoaDon on donGiao.idHoaDon=hoaDon.idHoaDon\n"
                     +"where tinhTrang like N'Đang giao'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
              
                String idDonGiao = rs.getString("idDonGiao");
                String idHoaDon = rs.getString("idHoaDon");
                String idDVVC = rs.getString("idDonViVanChuyen");
               
               
                String tenDVVC = rs.getString("tenDVVC");
                String ngayGiao = rs.getString("ngayGiaohang");
                String ngayNhan = rs.getString("ngayNhanDuKien");
                 String diaChi = rs.getString("diaChiNhanHang");
                String tinhTrang = rs.getString("tinhTrang");

                DonGiao dg = new DonGiao(idDonGiao, idHoaDon, idDVVC, tenDVVC, ngayGiao, ngayNhan, diaChi, tinhTrang);
                ds.add(dg);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
    public List<DonGiao> donDaGiao() {

        List<DonGiao> ds = new ArrayList<>();
        try {

            String sql = "Select donGiao.idDonGiao,donGiao.idHoaDon,donGiao.idDonViVanChuyen,DonViVanChuyen.ten as tenDVVC,donGiao.ngayGiaohang,donGiao.ngayNhanDuKien,donGiao.diaChiNhanHang,donGiao.tinhTrang\n"
                    + "from donGiao join DonViVanChuyen on DonViVanChuyen.iddonViVanChuyen= donGiao.idDonViVanChuyen join hoaDon on donGiao.idHoaDon=hoaDon.idHoaDon\n"
                     +"where tinhTrang like N'Đã giao'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
              
                String idDonGiao = rs.getString("idDonGiao");
                String idHoaDon = rs.getString("idHoaDon");
                String idDVVC = rs.getString("idDonViVanChuyen");
               
               
                String tenDVVC = rs.getString("tenDVVC");
                String ngayGiao = rs.getString("ngayGiaohang");
                String ngayNhan = rs.getString("ngayNhanDuKien");
                 String diaChi = rs.getString("diaChiNhanHang");
                String tinhTrang = rs.getString("tinhTrang");

                DonGiao dg = new DonGiao(idDonGiao, idHoaDon, idDVVC, tenDVVC, ngayGiao, ngayNhan, diaChi, tinhTrang);
                ds.add(dg);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }
    public List<DonGiao> donDaHuy() {

        List<DonGiao> ds = new ArrayList<>();
        try {

            String sql = "Select donGiao.idDonGiao,donGiao.idHoaDon,donGiao.idDonViVanChuyen,DonViVanChuyen.ten as tenDVVC,donGiao.ngayGiaohang,donGiao.ngayNhanDuKien,donGiao.diaChiNhanHang,donGiao.tinhTrang\n"
                    + "from donGiao join DonViVanChuyen on DonViVanChuyen.iddonViVanChuyen= donGiao.idDonViVanChuyen join hoaDon on donGiao.idHoaDon=hoaDon.idHoaDon\n"
                    +"where tinhTrang like N'Đã hủy'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
              
                String idDonGiao = rs.getString("idDonGiao");
                String idHoaDon = rs.getString("idHoaDon");
                String idDVVC = rs.getString("idDonViVanChuyen");
               
               
                String tenDVVC = rs.getString("tenDVVC");
                String ngayGiao = rs.getString("ngayGiaohang");
                String ngayNhan = rs.getString("ngayNhanDuKien");
                 String diaChi = rs.getString("diaChiNhanHang");
                String tinhTrang = rs.getString("tinhTrang");

                DonGiao dg = new DonGiao(idDonGiao, idHoaDon, idDVVC, tenDVVC, ngayGiao, ngayNhan, diaChi, tinhTrang);
                ds.add(dg);
            }
            System.out.println("Thành công");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Thất bại");
        }
        return ds;
    }

}

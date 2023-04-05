/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Administrator
 */
public class HoaDon {

    private String idHoaDon;
    private String idKH;
    private String idVC;
    private String idNV;
      private String ngayTao;
        private String trangThai;
          private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(String idHoaDon, String idKH, String idVC, String idNV, String ngayTao, String trangThai, String ghiChu) {
        this.idHoaDon = idHoaDon;
        this.idKH = idKH;
        this.idVC = idVC;
        this.idNV = idNV;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

   
    
  

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdVC() {
        return idVC;
    }

    public void setIdVC(String idVC) {
        this.idVC = idVC;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

}

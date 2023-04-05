/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.viewmodel;

/**
 *
 * @author Admin
 */
public class HoaDonViewModel {
    private String idHoaDon;
    private String ngayTao;
    private String nhanVien;
    private String khachHang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String idHoaDon, String ngayTao, String nhanVien, String khachHang) {
        this.idHoaDon = idHoaDon;
        this.ngayTao = ngayTao;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
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

    public String getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(String nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }
    
}

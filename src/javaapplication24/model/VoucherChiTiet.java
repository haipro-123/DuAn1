/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Admin
 */
public class VoucherChiTiet {
    private String idVoucherChiTiet;
    private String idVoucher;
    private String idKhachHang;
    private String NgayBatDau;
    private String idHoaDon;
    private byte trangThai;

    public VoucherChiTiet() {
    }

    public VoucherChiTiet(String idVoucherChiTiet, String idVoucher, String idKhachHang, String NgayBatDau, String idHoaDon, byte trangThai) {
        this.idVoucherChiTiet = idVoucherChiTiet;
        this.idVoucher = idVoucher;
        this.idKhachHang = idKhachHang;
        this.NgayBatDau = NgayBatDau;
        this.idHoaDon = idHoaDon;
        this.trangThai = trangThai;
    }
    public VoucherChiTiet( String idVoucher, String idKhachHang, String NgayBatDau, String idHoaDon, byte trangThai) {
        this.idVoucher = idVoucher;
        this.idKhachHang = idKhachHang;
        this.NgayBatDau = NgayBatDau;
        this.idHoaDon = idHoaDon;
        this.trangThai = trangThai;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdVoucherChiTiet() {
        return idVoucherChiTiet;
    }

    public void setIdVoucherChiTiet(String idVoucherChiTiet) {
        this.idVoucherChiTiet = idVoucherChiTiet;
    }

    public String getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(String idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public byte getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(byte trangThai) {
        this.trangThai = trangThai;
    }
    
}

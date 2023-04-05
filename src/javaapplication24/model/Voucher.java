/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Admin
 */
public class Voucher {
    private String id;
    private String ten;
    private byte loai;
    private int giaTri;
    private int hsd;
    private int dkNhan;
    private int mucGiaGioiHan;
    private String ngayKetThuc;
    public Voucher() {
    }

    public Voucher(String id, String ten, byte loai, int giaTri, int hsd, int dkNhan, int mucGiaGioiHan, String ngayKetThuc) {
        this.id = id;
        this.ten = ten;
        this.loai = loai;
        this.giaTri = giaTri;
        this.hsd = hsd;
        this.dkNhan = dkNhan;
        this.mucGiaGioiHan = mucGiaGioiHan;
        this.ngayKetThuc = ngayKetThuc;
    }
    public Voucher(String ten, byte loai, int giaTri, int hsd, int dkNhan, int mucGiaGioiHan, String ngayKetThuc) {
        this.ten = ten;
        this.loai = loai;
        this.giaTri = giaTri;
        this.hsd = hsd;
        this.dkNhan = dkNhan;
        this.mucGiaGioiHan = mucGiaGioiHan;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    
    public int getDkNhan() {
        return dkNhan;
    }

    public void setDkNhan(int dkNhan) {
        this.dkNhan = dkNhan;
    }

    public int getMucGiaGioiHan() {
        return mucGiaGioiHan;
    }

    public void setMucGiaGioiHan(int mucGiaGioiHan) {
        this.mucGiaGioiHan = mucGiaGioiHan;
    }
    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHsd() {
        return hsd;
    }

    public void setHsd(int hsd) {
        this.hsd = hsd;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte getLoai() {
        return loai;
    }

    public void setLoai(byte loai) {
        this.loai = loai;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }
    
}

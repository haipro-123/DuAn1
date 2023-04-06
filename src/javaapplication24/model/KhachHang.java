/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.domainmodel;

/**
 *
 * @author fptsh
 */
public class KhachHang {
    
    private String idKhachHang;
    private String maKH;
    private String tenKH;
    private int gioiTinh;
    private String ngaySinh;
    private int sdt;
    private String email;
    private String trangThai;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String idKhachHang, String maKH, String tenKH, int gioiTinh, String ngaySinh, int sdt, String email, String trangThai, String diaChi) {
        this.idKhachHang = idKhachHang;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.trangThai = trangThai;
        this.diaChi = diaChi;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public String getGioiTinh(int gioiTinh) {
        if (gioiTinh == 0) {
            return "Nu";
        } else {
            return "Nam";
        }
    }

    @Override
    public String toString() {
        return "KhachHang{" + "idKhachHang=" + idKhachHang + ", maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", email=" + email + ", trangThai=" + trangThai + ", diaChi=" + diaChi + '}';
    }
    
    public Object[] toDataRow() {
        return new Object[]{idKhachHang, maKH, tenKH, getGioiTinh(gioiTinh), ngaySinh, sdt, email, trangThai, diaChi};
    }
}

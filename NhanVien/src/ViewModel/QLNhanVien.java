/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author Do Quoc Thinh
 */
public class QLNhanVien {

    private String idNhanVien;
    private String MaNV;
    private String HoTen;
    private String GioiTinh;
    private String Email;
    private String DiaChi;
    private String SDT;
    private String MatKhau;
    private String ChucVu;
    private String TrangThai;

    public QLNhanVien() {
    }

    public QLNhanVien(String idNhanVien, String MaNV, String HoTen, String GioiTinh, String Email, String DiaChi, String SDT, String MatKhau, String ChucVu, String TrangThai) {
        this.idNhanVien = idNhanVien;
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.MatKhau = MatKhau;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
    }

//    public QLNhanVien(int stt, String idNhanVien, String MaNV, String HoTen, String GioiTinh, String Email, String DiaChi, String SDT, String MatKhau, String ChucVu, String TrangThai) {
//        this.idNhanVien = idNhanVien;
//        this.MaNV = MaNV;
//        this.HoTen = HoTen;
//        this.Email = Email;
//        this.DiaChi = DiaChi;
//        this.SDT = SDT;
//        this.MatKhau = MatKhau;
//        this.ChucVu = ChucVu;
//        this.TrangThai = TrangThai;
//    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Object[] toRow() {
        return new Object[]{idNhanVien, MaNV, ChucVu, HoTen, SDT, Email, MatKhau, TrangThai};
    }
}

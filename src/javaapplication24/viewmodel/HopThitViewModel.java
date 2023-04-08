/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HopThitViewModel {
    private int Stt;
    private String Ma;
    private String LoaiThit;
    private int TrongLuong;
    private int SoLuong;
    private Date NgaySanXuat;
    private int TongGia;

    public HopThitViewModel() {
    }

    public HopThitViewModel(int Stt, String Ma, String LoaiThit, int TrongLuong, int SoLuong, Date NgaySanXuat, int TongGia) {
        this.Stt = Stt;
        this.Ma = Ma;
        this.LoaiThit = LoaiThit;
        this.TrongLuong = TrongLuong;
        this.SoLuong = SoLuong;
        this.NgaySanXuat = NgaySanXuat;
        this.TongGia = TongGia;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getLoaiThit() {
        return LoaiThit;
    }

    public void setLoaiThit(String LoaiThit) {
        this.LoaiThit = LoaiThit;
    }

    public int getTrongLuong() {
        return TrongLuong;
    }

    public void setTrongLuong(int TrongLuong) {
        this.TrongLuong = TrongLuong;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(Date NgaySanXuat) {
        this.NgaySanXuat = NgaySanXuat;
    }

    public int getTongGia() {
        return TongGia;
    }

    public void setTongGia(int TongGia) {
        this.TongGia = TongGia;
    }

    
    
    
}

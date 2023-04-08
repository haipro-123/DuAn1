/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.viewmodel;

/**
 *
 * @author Admin
 */
public class LoaiThitViewModel {
    private int Stt;
    private String Ma;
    private String Thit;
    private String TenThit;
    private String Ten;
    private int DonGia;
    private int HSD;

    public LoaiThitViewModel() {
    }

    public LoaiThitViewModel(int Stt, String Ma, String Thit, String TenThit, String Ten, int DonGia, int HSD) {
        this.Stt = Stt;
        this.Ma = Ma;
        this.Thit = Thit;
        this.TenThit = TenThit;
        this.Ten = Ten;
        this.DonGia = DonGia;
        this.HSD = HSD;
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

    public String getThit() {
        return Thit;
    }

    public void setThit(String Thit) {
        this.Thit = Thit;
    }

    public String getTenThit() {
        return TenThit;
    }

    public void setTenThit(String TenThit) {
        this.TenThit = TenThit;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getHSD() {
        return HSD;
    }

    public void setHSD(int HSD) {
        this.HSD = HSD;
    }

    

    

    @Override
    public String toString() {
        return TenThit;
    }

    
    
    
}

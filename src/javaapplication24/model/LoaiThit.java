/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Admin
 */

public class LoaiThit{
    private String Id;
    private String IDThit;
    private String TenThit;
    private String Ten;
    private int DonGia;
    private int HSD;

    public LoaiThit() {
    }

    public LoaiThit(String Id, String IDThit, String TenThit, String Ten, int DonGia, int HSD) {
        this.Id = Id;
        this.IDThit = IDThit;
        this.TenThit = TenThit;
        this.Ten = Ten;
        this.DonGia = DonGia;
        this.HSD = HSD;
    }

    public LoaiThit(String IDThit, String TenThit, String Ten, int DonGia, int HSD) {
        this.IDThit = IDThit;
        this.TenThit = TenThit;
        this.Ten = Ten;
        this.DonGia = DonGia;
        this.HSD = HSD;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getIDThit() {
        return IDThit;
    }

    public void setIDThit(String IDThit) {
        this.IDThit = IDThit;
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
        return Ten;
    }
    
    
}

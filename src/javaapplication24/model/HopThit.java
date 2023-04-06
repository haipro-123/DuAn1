/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author Admin
 */

public class HopThit{
    private String Id;
    private String IDLoaiThit;
    private int TrongLuong;
    private int SoLuong;
    private Date NgaySanXuat;
    private int TongGia;

    public HopThit() {
    }

    public HopThit(String Id, String IDLoaiThit, int TrongLuong, int SoLuong, Date NgaySanXuat, int TongGia) {
        this.Id = Id;
        this.IDLoaiThit = IDLoaiThit;
        this.TrongLuong = TrongLuong;
        this.SoLuong = SoLuong;
        this.NgaySanXuat = NgaySanXuat;
        this.TongGia = TongGia;
    }

    public HopThit(String IDLoaiThit, int TrongLuong, int SoLuong, Date NgaySanXuat, int TongGia) {
        this.IDLoaiThit = IDLoaiThit;
        this.TrongLuong = TrongLuong;
        this.SoLuong = SoLuong;
        this.NgaySanXuat = NgaySanXuat;
        this.TongGia = TongGia;
    }

    public HopThit(String IDLoaiThit, int TrongLuong, int SoLuong, Date NgaySanXuat) {
        this.IDLoaiThit = IDLoaiThit;
        this.TrongLuong = TrongLuong;
        this.SoLuong = SoLuong;
        this.NgaySanXuat = NgaySanXuat;
    }
    
    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getIDLoaiThit() {
        return IDLoaiThit;
    }

    public void setIDLoaiThit(String IDLoaiThit) {
        this.IDLoaiThit = IDLoaiThit;
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

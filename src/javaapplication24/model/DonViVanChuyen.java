/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.model;

/**
 *
 * @author Admin
 */
public class DonViVanChuyen {
    private String idDVVC;
   
    private String ten;
    private String phamViVC;
    private int trangThai;
   private String hotLine ;

    public DonViVanChuyen() {
    }

    public DonViVanChuyen(String idDVVC, String ten, String phamViVC, int trangThai, String hotLine) {
        this.idDVVC = idDVVC;
        
        this.ten = ten;
        this.phamViVC = phamViVC;
        this.trangThai = trangThai;
        this.hotLine = hotLine;
    }

   

    public String getIdDVVC() {
        return idDVVC;
    }

    public void setIdDVVC(String idDVVC) {
        this.idDVVC = idDVVC;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhamViVC() {
        return phamViVC;
    }

    public void setPhamViVC(String phamViVC) {
        this.phamViVC = phamViVC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getHotLine() {
        return hotLine;
    }

    public void setHotLine(String hotLine) {
        this.hotLine = hotLine;
    }

    

    
    
}

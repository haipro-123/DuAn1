
package javaapplication24.model;


public class DonGiao {

  private String   idDonGiao;
   private String  idHoaDon;
 private String    idDonViVanChuyen;

  private String    tenDVVC;
  private String   ngayGiaoHang;
 private String    ngayNhanDK;
 private String diaChi;
 private String    tinhTrang;

    public DonGiao() {
    }

    public DonGiao(String idDonGiao, String idHoaDon, String idDonViVanChuyen, String tenDVVC, String ngayGiaoHang, String ngayNhanDK, String diaChi, String tinhTrang) {
        this.idDonGiao = idDonGiao;
        this.idHoaDon = idHoaDon;
        this.idDonViVanChuyen = idDonViVanChuyen;
        this.tenDVVC = tenDVVC;
        this.ngayGiaoHang = ngayGiaoHang;
        this.ngayNhanDK = ngayNhanDK;
        this.diaChi = diaChi;
        this.tinhTrang = tinhTrang;
    }

    public String getIdDonGiao() {
        return idDonGiao;
    }

    public void setIdDonGiao(String idDonGiao) {
        this.idDonGiao = idDonGiao;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdDonViVanChuyen() {
        return idDonViVanChuyen;
    }

    public void setIdDonViVanChuyen(String idDonViVanChuyen) {
        this.idDonViVanChuyen = idDonViVanChuyen;
    }

    public String getTenDVVC() {
        return tenDVVC;
    }

    public void setTenDVVC(String tenDVVC) {
        this.tenDVVC = tenDVVC;
    }

    public String getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(String ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getNgayNhanDK() {
        return ngayNhanDK;
    }

    public void setNgayNhanDK(String ngayNhanDK) {
        this.ngayNhanDK = ngayNhanDK;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
   }

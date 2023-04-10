/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NhanVien;
import Responsitories.INhanVienResponsitory;
import Responsitories.NhanVienResponsitory;
import ViewModel.QLNhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Do Quoc Thinh
 */
public class NhanVienService implements INhanVienService{
    
     public final INhanVienResponsitory iNhanVienResponsitory;

    public NhanVienService() {
        this.iNhanVienResponsitory = new NhanVienResponsitory();
    }
     
     
    @Override
    public List<QLNhanVien> getAllNhanVien() {
        List<QLNhanVien> list = new ArrayList<>();
        List<NhanVien> a = iNhanVienResponsitory.getAllNhanVien();
        
        for (NhanVien qlNhanVien :a) {
            list.add(new QLNhanVien(qlNhanVien.getIdNhanVien(), qlNhanVien.getMaNV(),
                    qlNhanVien.getHoTen(), qlNhanVien.getGioiTinh(),
                    qlNhanVien.getEmail(),qlNhanVien.getDiaChi(),qlNhanVien.getSDT(), qlNhanVien.getMatKhau(),qlNhanVien.getChucVu(),qlNhanVien.getTrangThai()));
        } 
        return list;
    }
    

    @Override
    public QLNhanVien addNhanVien(QLNhanVien nv) {
        nv.setIdNhanVien(null);
        NhanVien n = iNhanVienResponsitory.addNhanVien(new NhanVien(nv.getIdNhanVien(), nv.getMaNV(), nv.getHoTen(), nv.getGioiTinh(), nv.getEmail(), nv.getDiaChi(), nv.getSDT(), nv.getMatKhau(), nv.getChucVu(), nv.getTrangThai()));
        return new QLNhanVien(n.getIdNhanVien(), n.getMaNV(), n.getHoTen(), n.getGioiTinh(), n.getEmail(), n.getDiaChi(), n.getSDT(), n.getMatKhau(), n.getChucVu(), n.getTrangThai());
    }

    @Override
    public QLNhanVien updateNhanVienById(QLNhanVien nv) {
        System.out.println("MA NV = " + nv.getMaNV());
        NhanVien n = new NhanVien( nv.getIdNhanVien(), nv.getMaNV(), nv.getHoTen(), nv.getGioiTinh(), nv.getEmail(), nv.getDiaChi(), nv.getSDT(), nv.getMatKhau(), nv.getChucVu(),nv.getTrangThai());
        iNhanVienResponsitory.updateNhanVien(n);
        return new QLNhanVien( n.getIdNhanVien(), n.getMaNV(), n.getHoTen(), n.getGioiTinh(), n.getEmail(), n.getDiaChi(), n.getSDT(), n.getMatKhau(), n.getChucVu(),n.getTrangThai());
    }

    @Override
    public int deleteNhanVienById(String id) {
        return iNhanVienResponsitory.deleteNhanVien(id);
    }
    
//    public ArrayList<QLNhanVien> findNhanVien(String MaNV) {
//        NhanVienResponsitory nhanVienResponsitory = new NhanVienResponsitory();
//        
//        ArrayList<NhanVien> listNV = nhanVienResponsitory.findNhanVien(MaNV);
//        ArrayList<QLNhanVien> view = new ArrayList<>();
//        int stt = 1;
//        for (NhanVien nv : listNV) {
//            view.add(new QLNhanVien(stt, nv.getIdNhanVien(), nv.getMaNV(), nv.getChucVu(), nv.getHoTen(), nv.getSDT(), nv.getEmail(), nv.getMatKhau(), nv.getTrangThai()));
//            stt++;
//        }
//    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import Repositories.KhachHangRepository;
import ViewModels.QLKhachHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class KhachHangService {
    private final KhachHangRepository khachHangRepository;
    private List<QLKhachHang> listKH;
    public KhachHangService(){
        khachHangRepository = new KhachHangRepository();
        listKH = new ArrayList<>();
    }
    public List<QLKhachHang> getKH(){
        listKH = new ArrayList<>();
        var ds = khachHangRepository.findAll();
        for(KhachHang x : ds){
            listKH.add(new QLKhachHang(x.getMaKH(), x.getHoTen(), x.getSdt(), x.getDiaChi()));
        }
        return listKH;
    }
    public String getID(String ma){
        return khachHangRepository.findID(ma);
    }
    public String createKH(QLKhachHang kh){
        if(kh.getMaKH().equals("")){
            return "Mã khách hàng không được để trống.";
        }
        if(kh.getHoTen().equals("")){
            return "Họ tên khách hàng không được để trống.";
        }
        if(kh.getSdt().equals("")){
            return "SĐT khách hàng không được để trống.";
        }
        if(kh.getDiaChi().equals("")){
            return "Địa chỉ khách hàng không được để trống.";
        }
        if(kh.getSdt().matches("0[0-9]{9}") == false){
            return "Số điện thoại phải bắt đầu bằng số 0 và có 10 số.";
        }
        for(QLKhachHang x : this.listKH){
            if(x.getMaKH().equals(kh.getMaKH())){
                return "Mã khách hàng đã tồn tại.";
            }
        }
        if(khachHangRepository.save(new KhachHang(null, kh.getMaKH(), kh.getHoTen(), kh.getSdt(), kh.getDiaChi())) != null){
            return "Thêm thành công.";
        }else{
            return "Thêm thất bại";
        }
        
    }
    public String updateKH(QLKhachHang kh){
        if(kh.getMaKH().equals("")){
            return "Mã khách hàng không được để trống.";
        }
        if(kh.getHoTen().equals("")){
            return "Họ tên khách hàng không được để trống.";
        }
        if(kh.getSdt().equals("")){
            return "SĐT khách hàng không được để trống.";
        }
        if(kh.getDiaChi().equals("")){
            return "Địa chỉ khách hàng không được để trống.";
        }
        if(kh.getSdt().matches("0[0-9]{9}") == false){
            return "Số điện thoại phải bắt đầu bằng số 0 và có 10 số.";
        }
//        for(QLKhachHang x : this.listKH){
//            if(x.getMaKH().equals(kh.getMaKH())){
//                return "Mã khách hàng đã tồn tại.";
//            }
//        }
        String id = getID(kh.getMaKH());
        if(khachHangRepository.update(new KhachHang(id, kh.getMaKH(), kh.getHoTen(), kh.getSdt(), kh.getDiaChi() )) != null){
            return "Sửa thành công.";
        }else{
            return "Sửa thất bại";
        }
    }
}

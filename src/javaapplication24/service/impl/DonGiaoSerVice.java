/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.ArrayList;
import java.util.List;

import javaapplication24.model.DonGiao;
import javaapplication24.repository.DonGiaoRepo;

import javaapplication24.viewmodel.DonGiaoViewModel;



public class DonGiaoSerVice {
   private javaapplication24.repository.DonGiaoRepo donGiaoRepo;

    public DonGiaoSerVice() {
        this.donGiaoRepo= new DonGiaoRepo();
    }
    
    public boolean insert( DonGiaoViewModel ql ){
        DonGiao dgct = new DonGiao("", ql.getIdHoaDon(),ql.getIdDonViVanChuyen(),"",ql.getNgayGiaoHang(),ql.getNgayNhanDK(),ql.getDiaChi(),"");
       
          return donGiaoRepo.insert(dgct) ;
        }
  
    public boolean update( DonGiaoViewModel ql ){
       DonGiao dgct = new DonGiao( ql.getIdDonGiao(), ql.getIdHoaDon(),ql.getIdDonViVanChuyen(),"","","","",ql.getTinhTrang());
       
          return donGiaoRepo.update(dgct) ;
        }
  
   
    public List<DonGiaoViewModel> all(){
        List<DonGiaoViewModel> ds = new ArrayList<>();
        List<DonGiao> list = donGiaoRepo.all();
        for (DonGiao dg : list) {
            DonGiaoViewModel ql = new DonGiaoViewModel( dg.getIdDonGiao(), dg.getIdHoaDon(),dg.getIdDonViVanChuyen(),dg.getTenDVVC(),dg.getNgayGiaoHang(),dg.getNgayNhanDK(),dg.getDiaChi(),dg.getTinhTrang());
            ds.add(ql);
        }
     return ds;
    }
     public List<DonGiaoViewModel> donDangGiao(){
        List<DonGiaoViewModel> ds = new ArrayList<>();
        List<DonGiao> list = donGiaoRepo.donDangGiao();
        for (DonGiao dg : list) {
            DonGiaoViewModel ql = new DonGiaoViewModel( dg.getIdDonGiao(), dg.getIdHoaDon(),dg.getIdDonViVanChuyen(),dg.getTenDVVC(),dg.getNgayGiaoHang(),dg.getNgayNhanDK(),dg.getDiaChi(),dg.getTinhTrang());
            ds.add(ql);
        }
     return ds;
    }
      public List<DonGiaoViewModel> donDaGiao(){
        List<DonGiaoViewModel> ds = new ArrayList<>();
        List<DonGiao> list = donGiaoRepo.donDaGiao();
        for (DonGiao dg : list) {
            DonGiaoViewModel ql = new DonGiaoViewModel( dg.getIdDonGiao(), dg.getIdHoaDon(),dg.getIdDonViVanChuyen(),dg.getTenDVVC(),dg.getNgayGiaoHang(),dg.getNgayNhanDK(),dg.getDiaChi(),dg.getTinhTrang());
            ds.add(ql);
        }
     return ds;
    }
       public List<DonGiaoViewModel> donDaHuy(){
        List<DonGiaoViewModel> ds = new ArrayList<>();
        List<DonGiao> list = donGiaoRepo.donDaHuy();
        for (DonGiao dg : list) {
            DonGiaoViewModel ql = new DonGiaoViewModel( dg.getIdDonGiao(), dg.getIdHoaDon(),dg.getIdDonViVanChuyen(),dg.getTenDVVC(),dg.getNgayGiaoHang(),dg.getNgayNhanDK(),dg.getDiaChi(),dg.getTinhTrang());
            ds.add(ql);
        }
     return ds;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.ArrayList;
import java.util.List;

import javaapplication24.model.DonViVanChuyen;

import javaapplication24.repository.DonViVCRepo;

import javaapplication24.viewmodel.DonViVanChuyenViewModel;

/**
 *
 * @author Administrator
 */
public class DonViVanChuyenSerVice {
   private javaapplication24.repository.DonViVCRepo donViVCRepo;

    public DonViVanChuyenSerVice() {
        this.donViVCRepo= new DonViVCRepo();
    }
    
    public boolean insert( DonViVanChuyenViewModel ql ){
       DonViVanChuyen dvvc = new DonViVanChuyen("", ql.getTen(),ql.getPhamViVC(),ql.getTrangThai(),ql.getHotLine());
       
          return donViVCRepo.insert(dvvc) ;
        }
  
    public boolean update( DonViVanChuyenViewModel ql ){
       DonViVanChuyen dvvc = new DonViVanChuyen(ql.getIdDVVC(), ql.getTen(),ql.getPhamViVC(),ql.getTrangThai(),ql.getHotLine());
       
          return donViVCRepo.update(dvvc) ;
        }
    public boolean delete( DonViVanChuyenViewModel ql ){
       DonViVanChuyen dvvc = new DonViVanChuyen(ql.getIdDVVC(),"","",0,"");
       
          return donViVCRepo.delete(dvvc) ;
        }
   
    public List<DonViVanChuyenViewModel> all(){
        List<DonViVanChuyenViewModel> ds = new ArrayList<>();
        List<DonViVanChuyen> list = donViVCRepo.all();
        for (DonViVanChuyen dvvc : list) {
            DonViVanChuyenViewModel ql = new DonViVanChuyenViewModel(dvvc.getIdDVVC(), dvvc.getTen(),dvvc.getPhamViVC(),dvvc.getTrangThai(),dvvc.getHotLine());
            ds.add(ql);
        }
     return ds;
    }
}

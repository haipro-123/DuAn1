/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.List;
import javaapplication24.domainmodel.KhachHang;
import javaapplication24.repository.KhachHangRepository;
import javaapplication24.repository.PhieuTraRepository;
import javaapplication24.service.KhachHangService;

/**
 *
 * @author fptsh
 */
public class KhachHangServiceImpl implements KhachHangService{

    KhachHangRepository khr = new KhachHangRepository();
    
    @Override
    public List<KhachHang> getData() {
        return khr.readDB();
    }

    @Override
    public List<KhachHang> Search(List<KhachHang> lists, String maKH) {
        return khr.getMa(maKH);
    }

    @Override
    public List<KhachHang> sortBy() {
        return khr.sortByName();
    }

    @Override
    public String add(KhachHang kh) {
        boolean addSV = khr.add(kh);
        if (addSV) {
            return "Add successfully";
        }
        return "Add failed";
    }

    @Override
    public String update(List<KhachHang> lists, String maKH, KhachHang kh) {
        boolean updatePT = khr.update(maKH, kh);
        if (updatePT) {
            return "Update successfully";
        }
        return "Update failed";
    }
    
}

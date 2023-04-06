/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.service;

import java.util.List;
import javaapplication24.domainmodel.KhachHang;

/**
 *
 * @author fptsh
 */
public interface KhachHangService {
    
    List<KhachHang> getData();

    List<KhachHang> Search(List<KhachHang> lists, String maKH);

    List<KhachHang> sortBy();

    String add(KhachHang kh);

    String update(List<KhachHang> lists, String maKH, KhachHang kh);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.service;

import java.util.List;
import javaapplication24.model.VoucherChiTiet;

/**
 *
 * @author Admin
 */
public interface VoucherChiTietService {
    public boolean add(VoucherChiTiet vou);
    public boolean delete(String idHoaDon);
    public boolean update (String id,String tinhTrang);

    public List<VoucherChiTiet> getList();
}

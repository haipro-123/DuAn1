/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.List;
import javaapplication24.repository.HoaDonViewRepository;
import javaapplication24.viewmodel.HoaDonViewModel;

/**
 *
 * @author Admin
 */
public class HoaDonViewService {
    HoaDonViewRepository hdvr = new HoaDonViewRepository();

    public List<HoaDonViewModel> getList() {
        return hdvr.getList();
    }
}

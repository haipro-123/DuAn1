/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.List;
import javaapplication24.repository.GioHangViewRepository;
import javaapplication24.viewmodel.GioHangViewModel;

/**
 *
 * @author Admin
 */
public class GioHangViewService {
    GioHangViewRepository ghvr = new GioHangViewRepository();

    public List<GioHangViewModel> getList() {
        return ghvr.getList();
    }
    
}

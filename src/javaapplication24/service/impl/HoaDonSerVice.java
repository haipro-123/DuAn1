/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service.impl;

import java.util.List;
import javaapplication24.model.HoaDon;
import javaapplication24.repository.HoaDonRepo;

/**
 *
 * @author Administrator
 */
public class HoaDonSerVice {
private javaapplication24.repository.HoaDonRepo hoaDonRepo;
    public HoaDonSerVice() {
        hoaDonRepo= new HoaDonRepo();
    }
    public List<HoaDon> all(){
        return hoaDonRepo.all();
    }
}

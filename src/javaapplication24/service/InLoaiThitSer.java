/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.service;

import javaapplication24.model.LoaiThit;
import javaapplication24.viewmodel.LoaiThitViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InLoaiThitSer {
    ArrayList<LoaiThitViewModel> layDanhSachLoaiThit();
    LoaiThit getLTByMa(String Ma);
    LoaiThit getLTByTen(String TenLT);
    LoaiThit getLTByGia(String Gia);
    int add(LoaiThit lt);
    int delete(String Ma);
    int deleteByThit(String Ma);
    int update(LoaiThit lt);
}

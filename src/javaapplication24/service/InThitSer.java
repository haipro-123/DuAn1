/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.service;

import javaapplication24.model.Thit;
import javaapplication24.viewmodel.ThitViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InThitSer {
    ArrayList<ThitViewModel> layDanhSachThit();
    Thit getThitByMa(String Ma);
    Thit getThitByTen(String Ten);
    int add(Thit t);
    int delete(String Ma);
    int update(Thit t);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication24.service;

import javaapplication24.model.HopThit;
import javaapplication24.viewmodel.HopThitViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InHopThitSer {
    ArrayList<HopThitViewModel> layDanhSachHopThit();
    HopThit getHTByMa(String Ma);
    int add(HopThit ht);
    int delete(String Ma);
    int update(HopThit ht);
    int update(HopThit ht, int SL);
}

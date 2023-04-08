/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.HopThit;
import ViewModels.HopThitViewModel;
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

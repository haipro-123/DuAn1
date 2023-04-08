/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.HopThit;
import Responsitory.HopThitRes;
import Responsitory.InHopThitRes;
import ViewModels.HopThitViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HopThitSer implements InHopThitSer{
    private InHopThitRes responsitory = new HopThitRes();
    
    
    public ArrayList<HopThitViewModel> layDanhSachHopThit(){
        ArrayList<HopThit> listHT = responsitory.read();
        ArrayList<HopThitViewModel> view = new ArrayList<>();
        int stt = 1;
        for (HopThit ht : listHT) {
            view.add(new HopThitViewModel(stt, ht.getId(), ht.getIDLoaiThit(), ht.getTrongLuong(), ht.getSoLuong(), ht.getNgaySanXuat(), ht.getTongGia()));
            stt++;
        }
        return view;
    }
    
    
    public HopThit getHTByMa(String Ma){
        return responsitory.getHTByMa(Ma);
    }
    
    public int add(HopThit ht){
        return responsitory.add(ht);
    }
    
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    public int update(HopThit ht){
        return responsitory.update(ht);
    }
    
    public int update(HopThit ht, int SL){
        return responsitory.update(ht, SL);
    }
}

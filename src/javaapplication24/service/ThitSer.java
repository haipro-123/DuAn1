/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.Thit;
import Responsitory.ThitRes;
import Responsitory.InThitRes;
import ViewModels.ThitViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThitSer implements InThitSer{
    private InThitRes responsitory = new ThitRes();
    
    @Override
    public ArrayList<ThitViewModel> layDanhSachThit(){
        ArrayList<Thit> list = responsitory.read();
        ArrayList<ThitViewModel> view = new ArrayList<>();
        int stt = 1;
        for (Thit t : list) {
            view.add(new ThitViewModel(stt, t.getId(), t.getTen(), t.getMota()));
            stt++;
        }
        return view;
    } 
    
    public Thit getThitByMa(String Ma){
        return responsitory.getThitByMa(Ma);
    }
    
    public Thit getThitByTen(String Ten){
        return responsitory.getThitByTen(Ten);
    }
    
    public int add(Thit t){
        return responsitory.add(t);
    }
    
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    public int update(Thit t){
        return responsitory.update(t);
    }
}

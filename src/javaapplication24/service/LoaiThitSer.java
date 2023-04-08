/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication24.service;

import javaapplication24.model.LoaiThit;
import javaapplication24.repository.LoaiThitRes;
import javaapplication24.repository.InLoaiThitRes;
import javaapplication24.viewmodel.LoaiThitViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LoaiThitSer implements InLoaiThitSer{
    private InLoaiThitRes responsitory = new LoaiThitRes();
    
    @Override
    public ArrayList<LoaiThitViewModel> layDanhSachLoaiThit(){
        ArrayList<LoaiThit> list = responsitory.read();
        ArrayList<LoaiThitViewModel> view = new ArrayList<>();
        int stt = 1;
        for (LoaiThit lt : list) {
            view.add(new LoaiThitViewModel(stt, lt.getId(), lt.getIDThit(), lt.getTenThit(), lt.getTen(), lt.getDonGia(), lt.getHSD()));
            stt++;
        }
        return view;
    }
    
    @Override
    public LoaiThit getLTByMa(String Ma){
        return responsitory.getLTByMa(Ma);
    }
    
    @Override
    public LoaiThit getLTByTen(String TenLT){
        return responsitory.getLTByTen(TenLT);
    }
    
    @Override
    public LoaiThit getLTByGia(String Gia){
        return responsitory.getLTByGia(Gia);
    }
    
    @Override
    public int add(LoaiThit lt){
        return responsitory.add(lt);
    }
    
    @Override
    public int delete(String Ma){
        return responsitory.delete(Ma);
    }
    
    
    @Override
    public int deleteByThit(String Ma){
        return responsitory.deleteByThit(Ma);
    }
    
    @Override
    public int update(LoaiThit lt){
        return responsitory.update(lt);
    }
}
